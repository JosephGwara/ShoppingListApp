package com.josephgwara.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josephgwara.shoppinglist.R
import com.josephgwara.shoppinglist.data.ShoppingItems
import com.josephgwara.shoppinglist.ui.shoppingList.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*


class ShoppingItemAdapter(var items:List<ShoppingItems>,private val viewModel:ShoppingViewModel):
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
       val currentShoppingItem = items[position]
        holder.itemView.tv_name.text = currentShoppingItem.name
        holder.itemView.tv_amount.text = "${currentShoppingItem.amount}"
        holder.itemView.iv_delete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.itemView.iv_plus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
        holder.itemView.iv_minus.setOnClickListener {
            if(currentShoppingItem.amount > 0)currentShoppingItem.amount--
            viewModel.upsert(currentShoppingItem)

        }



    }

    override fun getItemCount(): Int {
       return items.size
    }

    inner class ShoppingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)


}