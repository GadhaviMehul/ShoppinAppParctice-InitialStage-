package com.example.florist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.florist.R
import com.example.florist.model.ProductItem

class Adapter(models: MutableList<ProductItem>, context: Context) : PagerAdapter() {
    private val models: MutableList<ProductItem>
    private lateinit var layoutInflater: LayoutInflater
    private val context: Context

    init {
        this.models = models
        this.context = context
    }

    override fun getCount(): Int {
        return models.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(R.layout.mainview_item, container, false)

        val imageView: ImageView = view.findViewById(R.id.product_image)
        val title: TextView = view.findViewById(R.id.title)
        val price: TextView = view.findViewById(R.id.price)
        title.text = models[position].title
        price.text = "$" + models[position].price.toString()
        Glide.with(context).load(models[position].image).into(imageView)

        container.addView(view, 0);
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}