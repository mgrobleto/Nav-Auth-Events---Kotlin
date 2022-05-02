package com.example.appartelisad1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.compose.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appartelisad1.R
import com.example.appartelisad1.databinding.FragmentArtistBinding
import com.example.appartelisad1.model.posts
import com.example.appartelisad1.view.adapter.adapterInfo
import com.example.appartelisad1.view.adapter.infoListener
import java.text.FieldPosition

class fragmentArtist : Fragment(), infoListener {

    private var fbinding : FragmentArtistBinding?= null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentArtistBinding.inflate(layoutInflater)

        // Cargar el recycler view
        val recycleList = binding.rvInfoItems
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        recycleList.layoutManager = linearmanager

        val adapter = adapterInfo(this, GetInfo(), R.layout.item_info, context)
        recycleList.adapter = adapter
        
        return binding.root
    }

    override fun onInfoClicked(posts: posts, position: Int){
        NavHostFragment.findNavController(this).navigate(R.id.mfragmentArtistaDetalle)
    }

    private fun GetInfo(): MutableList<posts> {
        val posts : MutableList<posts> = ArrayList()

        posts.add(posts("Agujeros Negros", "Leer"))
        posts.add(posts("Galaxias", "Leer"))
        posts.add(posts("¿Por qué el cielo es azul?", "Leer"))

        return posts
    }
}