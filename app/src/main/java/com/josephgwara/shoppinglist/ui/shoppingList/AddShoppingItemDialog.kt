package com.josephgwara.shoppinglist.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.josephgwara.shoppinglist.R
import com.josephgwara.shoppinglist.data.ShoppingItems
import com.josephgwara.shoppinglist.databinding.DialogAddShoppingItemBinding


class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        val binding: DialogAddShoppingItemBinding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItems(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        binding.tvCancel.setOnClickListener {
            cancel()
        }


    }

}