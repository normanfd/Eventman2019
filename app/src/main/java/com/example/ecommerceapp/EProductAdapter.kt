package com.example.ecommerceapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.e_product_row.view.*

class EProductAdapter(var context: Context, var arrayList:ArrayList<EProduct>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val productView = LayoutInflater.from(context).inflate(R.layout.e_product_row, parent, false)

        return ProductViewHolder(productView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductViewHolder).initializeRowUIComponents(arrayList.get(position).id, arrayList.get(position).name, arrayList.get(position).price, arrayList.get(position).pictureName)
    }

    inner class ProductViewHolder(pView:View):RecyclerView.ViewHolder(pView) {
        fun initializeRowUIComponents(id:Int, name:String, price:Int, pictName:String) {
            itemView.txtId.text = id.toString()
            itemView.txtName.text = name
            itemView.txtPrice.text = price.toString()

            var picUrl = "http://10.0.2.2:80/EventmanAPI/osimages/"
            picUrl = picUrl.replace(" ", "%20")
            Picasso.get().load(picUrl + pictName).into(itemView.imgProduct)
        }
    }
}