package com.example.appartelisad1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.appartelisad1.R
import com.example.appartelisad1.databinding.ActivityLoginBinding
import com.example.appartelisad1.databinding.ActivitySplashScreenBinding
import java.io.IOException

class activitySplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)

            binding = ActivitySplashScreenBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
            //---------------------------
            val animlogo = AnimationUtils.loadAnimation(this, R.anim.animacion)
            val imglogo: ImageView = binding.imaglogo
            imglogo.startAnimation(animlogo)

            val intent = Intent(this, activity_login::class.java)
            animlogo.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    startActivity(intent)
                    finish()
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }
        catch (e:IOException)
        {
            e.printStackTrace()
        }
    }

}