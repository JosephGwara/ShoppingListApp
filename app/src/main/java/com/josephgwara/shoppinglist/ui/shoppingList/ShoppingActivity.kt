package com.josephgwara.shoppinglist.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.josephgwara.shoppinglist.R
import com.josephgwara.shoppinglist.data.db.ShoppingDatabase
import com.josephgwara.shoppinglist.data.repositories.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)


        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database as ShoppingDatabase)
        val Factory = ShoppingViewModelFactory(repository)
        //val viewModel  = ViewModelProviders.of(this,Factory).get(ShoppingViewModel::class.java)
        val viewModel = ViewModelProvider(this,Factory)[ShoppingViewModel::class.java]





    }
}