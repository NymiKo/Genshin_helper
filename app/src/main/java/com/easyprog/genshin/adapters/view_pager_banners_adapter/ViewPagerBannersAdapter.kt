package com.easyprog.genshin.adapters.view_pager_banners_adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.genshin.adapters.view_pager_banners_adapter.ViewPagerBannersAdapter.ViewHolder
import com.easyprog.genshin.databinding.ItemBannerBinding
import com.easyprog.genshin.utils.load

class ViewPagerBannersAdapter : RecyclerView.Adapter<ViewHolder>() {

    var mBannerList: List<Int> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val banner = mBannerList[position]
        with(holder.binding) {
            imageBanner.load(banner)
        }
    }

    override fun getItemCount(): Int = mBannerList.size

    class ViewHolder(val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root)

}