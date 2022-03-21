package com.josephgwara.shoppinglist.ui.shoppingList

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.josephgwara.shoppinglist.R
import com.josephgwara.shoppinglist.data.ShoppingItems
import com.josephgwara.shoppinglist.data.db.ShoppingDatabase
import com.josephgwara.shoppinglist.data.repositories.ShoppingRepository
import com.josephgwara.shoppinglist.databinding.ActivityShoppingBinding
import com.josephgwara.shoppinglist.other.ShoppingItemAdapter
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

        val binding:ActivityShoppingBinding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val viewModel  = ViewModelProviders.of(this,Factory).get(ShoppingViewModel::class.java)
        val viewModel = ViewModelProvider(this,factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
binding.fab.setOnClickListener {
    AddShoppingItemDialog(this,object :AddDialogListener{
        override fun onAddButtonClicked(item: ShoppingItems) {
            viewModel.upsert(item)
        }
    }).show()
}




    }


}