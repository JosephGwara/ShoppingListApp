package com.josephgwara.shoppinglist.ui.shoppingList

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.josephgwara.shoppinglist.R
import com.josephgwara.shoppinglist.data.ShoppingItems
import com.josephgwara.shoppinglist.data.db.ShoppingDatabase
import com.josephgwara.shoppinglist.data.repositories.ShoppingRepository
import com.josephgwara.shoppinglist.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity() ,KodeinAware{
    override val kodein by kodein { this }
        private val factory:ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)


        //val viewModel  = ViewModelProviders.of(this,Factory).get(ShoppingViewModel::class.java)
        val viewModel = ViewModelProvider(this,factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        rv_shoppingItems.layoutManager = LinearLayoutManager(this)
        rv_shoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
fab.setOnClickListener {
    AddShoppingItemDialog(this,object :AddDialogListener{
        override fun onAddButtonClicked(item: ShoppingItems) {
            viewModel.upsert(item)
        }
    }).show()
}




    }


}