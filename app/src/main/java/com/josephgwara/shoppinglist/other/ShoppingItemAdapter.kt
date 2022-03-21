package com.josephgwara.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josephgwara.shoppinglist.R
import com.josephgwara.shoppinglist.data.ShoppingItems
import com.josephgwara.shoppinglist.databinding.ActivityShoppingBinding
import com.josephgwara.shoppinglist.databinding.ShoppingItemBinding
import com.josephgwara.shoppinglist.ui.shoppingList.ShoppingViewModel



class ShoppingItemAdapter(var items:List<ShoppingItems>,private val viewModel:ShoppingViewModel):
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       //val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(ShoppingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {


       val currentShoppingItem = items[position]

        holder.itemBinding.tvName.text = currentShoppingItem.name
        holder.itemBinding.tvAmount.text = "${currentShoppingItem.amount}"
        holder.itemBinding.ivDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.itemBinding.ivPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
        holder.itemBinding.ivMinus.setOnClickListener {
            if(currentShoppingItem.amount > 0)currentShoppingItem.amount--
            viewModel.upsert(currentShoppingItem)

        }



    }

    override fun getItemCount(): Int {
       return items.size
    }

    inner class ShoppingViewHolder(val itemBinding:ShoppingItemBinding) :RecyclerView.ViewHolder(itemBinding.root)


}