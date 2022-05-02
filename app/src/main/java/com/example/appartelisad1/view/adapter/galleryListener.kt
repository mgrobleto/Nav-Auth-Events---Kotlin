package com.example.appartelisad1.view.adapter

import com.example.appartelisad1.model.images

interface galleryListener {
    fun onGalleryClicked(gallery: images, position: Int)
}