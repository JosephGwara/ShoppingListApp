package com.josephgwara.shoppinglist.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.josephgwara.shoppinglist.R
import com.josephgwara.shoppinglist.data.ShoppingItems
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tv_add.setOnClickListener {
            val name = et_Name.text.toString()
            val amount = et_Amount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItems(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tv_cancel.setOnClickListener {
            cancel()
        }


    }

}