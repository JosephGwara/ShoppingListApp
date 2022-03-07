package com.josephgwara.shoppinglist.ui.shoppingList

import com.josephgwara.shoppinglist.data.ShoppingItems

interface AddDialogListener {
    fun onAddButtonClicked(item:ShoppingItems)
}