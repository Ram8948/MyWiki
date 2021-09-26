package com.ramosoft.mywiki.ui.images

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.ramosoft.mywiki.data.entities.CategoryModel
import com.ramosoft.mywiki.databinding.ItemCategoryBinding

class CategoryAdapter(private val listener: CategoryItemListener) : RecyclerView.Adapter<CategoryViewHolder>() {

    interface CategoryItemListener {
        fun onClickedImageinfo(ImageinfoId: CategoryModel.Query.Allcategory)
    }

    private val items = ArrayList<CategoryModel.Query.Allcategory>()

    fun setItems(items: ArrayList<CategoryModel.Query.Allcategory>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding: ItemCategoryBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = holder.bind(items[position])
}

class CategoryViewHolder(private val itemBinding: ItemCategoryBinding, private val listener: CategoryAdapter.CategoryItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var Imageinfo: CategoryModel.Query.Allcategory

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: CategoryModel.Query.Allcategory) {
        this.Imageinfo = item
        itemBinding.name.text = item.category
        itemBinding.id.text = item.id.toString()
    }

    override fun onClick(v: View?) {
        listener.onClickedImageinfo(Imageinfo)
    }
}

