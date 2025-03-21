package com.example.zadanie2281_statelistanimator_version_3

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.BounceInterpolator
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zadanie2281_statelistanimator_version_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            startRocketAnimation()
        }
    }
    private fun startRocketAnimation() {
        // Create animation for translationY (move up and down)
        // Create animation for translationY (move up and down)
        val translateYAnimator = ObjectAnimator.ofFloat(
            binding.rocketView,
            "translationY",
            0f,
            -1700f,
            0f
        )
        translateYAnimator.duration = 3500
        translateYAnimator.interpolator = BounceInterpolator()

        // Create animation for alpha (fade in and out - появление и исчезновение)
        val alphaAnimator = ObjectAnimator.ofFloat(
            binding.rocketView,
            "alpha",
            1f, // Fully opaque (полностью непрозрачный)
            0f, // Completely transparent (полностью прозрачный)
            1f  // Back to fully opaque (обратно к полной непрозрачности)
        )
        alphaAnimator.duration = 2000 // Немного более быстрое исчезновение
        alphaAnimator.interpolator =
            android.view.animation.AccelerateDecelerateInterpolator() // Плавное выцветание

        // Create AnimatorSet to play animations together
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(translateYAnimator, alphaAnimator)

        // Start the animation
        animatorSet.start()
    }
}

