package com.example.appartelisad1.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appartelisad1.R
import com.example.appartelisad1.model.posts

class adapterInfo(val infoListener: infoListener, posts: MutableList<posts>, resource: Int, context: Context?) :
    RecyclerView.Adapter<adapterInfo.InfoViewHolder>() {

    //---------
    private val postInfo: MutableList<posts>
    private val resource:Int
    private val context: Context?
    init {
        this.postInfo = posts
        this.resource = resource
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): InfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return InfoViewHolder(view)
    }
    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        //
        val posts: posts = postInfo[position]
        holder.postNombre.text = posts.postNombre
        holder.postDescripcion.text = posts.postDescripcion

        holder.itemView.setOnClickListener { view ->
            infoListener.onInfoClicked(posts, position)
        }
    }
    override fun getItemCount(): Int {
        return postInfo.size
    }

    inner class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // -----
        val postNombre: TextView
        val postDescripcion: TextView

        init {
            postNombre = itemView.findViewById<View>(R.id.txtInfoTitle) as TextView
            postDescripcion = itemView.findViewById<View>(R.id.txtSubText) as TextView
        }
    }
}
