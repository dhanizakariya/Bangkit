package com.dicoding.submission1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_user,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (_, name, location, _, company, _, _, avatar) = listUser[position]
        holder.imgAvatar.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvCompany.text = company
        holder.tvLocation.text = location
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listUser[holder.absoluteAdapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

    override fun getItemCount():Int = listUser.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_photo)

    }
}