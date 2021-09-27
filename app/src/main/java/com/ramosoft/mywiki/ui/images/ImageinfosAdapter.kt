package com.ramosoft.mywiki.ui.images

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramosoft.mywiki.data.entities.ImageModel
import com.ramosoft.mywiki.databinding.ItemCharacterBinding

class ImageinfosAdapter(private val listener: ImageinfoItemListener) : RecyclerView.Adapter<ImageinfoViewHolder>() {

    interface ImageinfoItemListener {
        fun onClickedImageinfo(ImageinfoId: ImageModel.Query.Allimage)
    }

    private val items = ArrayList<ImageModel.Query.Allimage>()

    fun setItems(items: ArrayList<ImageModel.Query.Allimage>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addData(items: ArrayList<ImageModel.Query.Allimage>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageinfoViewHolder {
        val binding: ItemCharacterBinding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageinfoViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ImageinfoViewHolder, position: Int) = holder.bind(items[position])
}

class ImageinfoViewHolder(private val itemBinding: ItemCharacterBinding, private val listener: ImageinfosAdapter.ImageinfoItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var Imageinfo: ImageModel.Query.Allimage

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: ImageModel.Query.Allimage) {
        this.Imageinfo = item
        itemBinding.name.text = item.name
//        itemBinding.speciesAndStatus.text = """${item.descriptionshorturl} - ${item.descriptionurl}"""
        Glide.with(itemBinding.root)
            .load(item.url)
            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        listener.onClickedImageinfo(Imageinfo)
    }
}

