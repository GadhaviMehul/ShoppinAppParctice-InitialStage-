package com.example.florist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.florist.databinding.ProductshoppingItemBinding
import com.example.florist.fragments.CatalogViewFragment
import com.example.florist.model.ProductItem


 class MyAdapter(val context: CatalogViewFragment)

: RecyclerView.Adapter<MyAdapter.ViewHodler>() {

    private var Product = emptyList<ProductItem>()
    var onItemClick: ((ProductItem) -> Unit)? = null

    inner class ViewHodler(private val MyItemView: ProductshoppingItemBinding) :
        RecyclerView.ViewHolder(MyItemView.root) {

        fun bind(productItem: ProductItem) {

            MyItemView.price.text = productItem.price.toString()
            MyItemView.title.text = productItem.title
            Glide.with(context).load(productItem.image).into(MyItemView.productImage)

            MyItemView.singleItem.setOnClickListener {
                onItemClick?.invoke(productItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        val binding = ProductshoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHodler(binding)
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        val user = Product[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = Product.size

    fun setData(context: CatalogViewFragment, productItem: MutableList<ProductItem>) {
        this.Product = productItem
        notifyDataSetChanged()
    }
}