package com.example.demoapplication

import android.animation.ObjectAnimator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.BounceInterpolator
import androidx.annotation.RequiresApi
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
@RequiresApi(Build.VERSION_CODES.S)
class MainActivity : AppCompatActivity() {
    private lateinit var splashScreen: SplashScreen
    override fun onCreate(savedInstanceState: Bundle?) {
        splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        useCustomExitAnimation()
//        keepSplashScreenIndefinitely()
        keepSplashScreenFor2Seconds()
    }

    private fun useCustomExitAnimation() {
        splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
            val splashScreenView = splashScreenViewProvider.view
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_Y,
                0f,
                -splashScreenView.height.toFloat(),
            )
            slideUp.interpolator = BounceInterpolator()
            slideUp.duration = 1000L
            slideUp.doOnEnd {
                splashScreenViewProvider.remove()
            }
            slideUp.start()
        }
    }

    /**
     * Keep splash screen on-screen indefinitely. This is useful if you're using a custom Activity
     * for routing.
     */
    private fun keepSplashScreenIndefinitely() {
        splashScreen.setKeepOnScreenCondition { true }
    }

    /**
     * Keep splash screen on-screen for longer period. This is useful if you need to load data when
     * splash screen is appearing.
     */
    private fun keepSplashScreenFor2Seconds() {
        val content = findViewById<View>(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                Thread.sleep(2000)
                content.viewTreeObserver.removeOnPreDrawListener(this)
                return true
            }
        })
    }
}