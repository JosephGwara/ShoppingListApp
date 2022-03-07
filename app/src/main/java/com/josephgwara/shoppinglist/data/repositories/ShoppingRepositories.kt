package com.josephgwara.shoppinglist.data.repositories

import com.josephgwara.shoppinglist.data.db.ShoppingDatabase
import com.josephgwara.shoppinglist.data.ShoppingItems

class ShoppingRepository(private  val db :ShoppingDatabase) {

    suspend fun upsert(items: ShoppingItems) = db.getShoppingDao().upsert(items)
    suspend fun delete(items: ShoppingItems) = db.getShoppingDao().delete(items)
    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}