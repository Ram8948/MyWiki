package com.ramosoft.mywiki.ui.article

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramosoft.mywiki.data.entities.ArticleModel
import com.ramosoft.mywiki.databinding.ArticleCardItemBinding

class ArticleAdapter(private val listener: ArticleItemListener) : RecyclerView.Adapter<ArticleViewHolder>() {

    interface ArticleItemListener {
        fun onClickedImageinfo(ImageinfoId: ArticleModel.Query.Page)
    }

    private val items = ArrayList<ArticleModel.Query.Page>()

    fun setItems(items: ArrayList<ArticleModel.Query.Page>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addData(items: ArrayList<ArticleModel.Query.Page>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding: ArticleCardItemBinding = ArticleCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) = holder.bind(items[position])
}

class ArticleViewHolder(private val itemBinding: ArticleCardItemBinding, private val listener: ArticleAdapter.ArticleItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var Imageinfo: ArticleModel.Query.Page

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: ArticleModel.Query.Page) {
        this.Imageinfo = item
        itemBinding.articleTitle.text = item.title
//        Glide.with(itemBinding.root)
//            .load("item.thumbnail!!.source")
//            .into(itemBinding.articleImage)
    }

    override fun onClick(v: View?) {
        listener.onClickedImageinfo(Imageinfo)
    }
}

