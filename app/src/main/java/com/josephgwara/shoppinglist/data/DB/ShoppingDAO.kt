package com.josephgwara.shoppinglist.data.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.josephgwara.shoppinglist.data.ShoppingItems

@Dao
interface ShoppingDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(item: ShoppingItems)

    @Delete
    suspend fun delete(item: ShoppingItems)

    @Query(value = "select * from ShoppingItems")
    fun getAllShoppingItems(): LiveData<List<ShoppingItems>>
}