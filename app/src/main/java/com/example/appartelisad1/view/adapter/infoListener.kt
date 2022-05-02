package com.example.appartelisad1.view.adapter

import com.example.appartelisad1.model.posts
import java.text.FieldPosition

interface infoListener {
    fun onInfoClicked(posts: posts, position: Int)
}