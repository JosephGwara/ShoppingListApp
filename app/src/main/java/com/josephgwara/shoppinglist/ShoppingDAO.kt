package com.josephgwara.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(item: ShoppingItems)

    @Delete
    suspend fun delete(item: ShoppingItems)

    @Query(value = "select * from ShoppingItems")
    fun getAllShoppingItems(): LiveData<List<ShoppingItems>>
}