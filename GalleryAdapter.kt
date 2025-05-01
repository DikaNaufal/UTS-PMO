package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.uts.R
import com.example.uts.LoginActivity

class GalleryAdapter(
    private val context: Context,
    private val galleryItems: List<GalleryItem>
) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = galleryItems.size

    override fun getItem(position: Int): Any = galleryItems[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.splashscreenactivity, parent, false)
            holder = ViewHolder(
                imageView = view.findViewById(R.id.splash_logo),
                textView = view.findViewById(R.id.textViewLoginTitle)
            )
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val item = galleryItems[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textView.text = item.title

        return view
    }

    data class ViewHolder(
        val imageView: ImageView,
        val textView: TextView
    )
}