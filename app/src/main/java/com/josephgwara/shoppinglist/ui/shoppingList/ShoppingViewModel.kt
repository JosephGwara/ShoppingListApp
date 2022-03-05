package com.josephgwara.shoppinglist.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.josephgwara.shoppinglist.data.ShoppingItems
import com.josephgwara.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository):ViewModel() {

    fun upsert(items: ShoppingItems)= CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(items)
    }
    fun delete(items: ShoppingItems)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(items)
    }
    fun getAllShoppingItems() = repository.getAllShoppingItems()

}