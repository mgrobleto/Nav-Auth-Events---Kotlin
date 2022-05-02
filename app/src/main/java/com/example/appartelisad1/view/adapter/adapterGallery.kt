package com.example.appartelisad1.view.adapter

import android.content.Context
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appartelisad1.R
import com.example.appartelisad1.model.images

class adapterGallery (val galleryListener: galleryListener,
                      images:MutableList<images>,
                      resource: Int,
                      context: Context?):
    RecyclerView.Adapter<adapterGallery.ViewHolder>() {

    //--------------

    private val galleryImages:MutableList<images>
    private val resource:Int
    private val context:Context?

    init {
        this.galleryImages = images
        this.resource = resource
        this.context = context
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //
        val images:images = galleryImages[position]
        holder.imgName.text = images.nombreImagen

        holder.imgPicture.setOnClickListener{ view ->
            galleryListener.onGalleryClicked(images, position)
        }

    }
    override fun getItemCount():Int{
        return galleryImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //-----
        val imgPicture: ImageView
        val imgClasification: TextView
        val imgName: TextView

        init{
            imgPicture =itemView.findViewById<View>(R.id.imgPicture)as ImageView
            imgClasification=itemView.findViewById<View>(R.id.tvNombreArt)as TextView
            imgName=itemView.findViewById<View>(R.id.txtImgTitle) as TextView
        }
    }
}