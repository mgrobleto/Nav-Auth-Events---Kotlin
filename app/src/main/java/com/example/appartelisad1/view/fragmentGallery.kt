package com.example.appartelisad1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appartelisad1.R
import com.example.appartelisad1.databinding.FragmentGalleryBinding
import com.example.appartelisad1.model.images
import com.example.appartelisad1.view.adapter.adapterGallery
import com.example.appartelisad1.view.adapter.galleryListener

class fragmentGallery : Fragment(), galleryListener {

    private var fbinding : FragmentGalleryBinding?=null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fbinding = FragmentGalleryBinding.inflate(layoutInflater)

        val recycleList = binding.rvGallery
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        recycleList.layoutManager = linearmanager

        //val view:View= inflater.inflate(R.layout.fragment_gallery, container, false)
        //-----------------
        //val reciclergaleria=view.findViewById<View>(R.id.rvGallery) as RecyclerView
        //val linerManager= LinearLayoutManager(context)
        //linerManager.orientation = LinearLayoutManager.VERTICAL
        //reciclergaleria.layoutManager=linerManager
        //----------------

        val adapter = adapterGallery(this,getGallery(),R.layout.item_gallery,context)
        recycleList.adapter=adapter

        return binding.root
    }

    override fun onGalleryClicked (Gallery:images, position:Int)
    {
        //---------------------------REVISARRRR------------------R.id.mfragmentGallery----------------
        NavHostFragment.findNavController(this).navigate(R.id.mfragmentDetailGallery)
    }

    //Cargar obras de arte
    private fun getGallery(): MutableList<images>{
        var gallery: MutableList<images> = ArrayList()

        gallery.add(images("Nebulosa de Orión","src/main/res/drawable/nebulosaorion.jpg"))
        gallery.add(images("Astronauta", "src/main/res/drawable/astronaut.jpg"))
        return gallery
    }

}