package com.example.w5d2_animations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class Main1Activity : AppCompatActivity(), View.OnClickListener {

    var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContentView(R.layout.activity_main1)
        initializeViews()
    }

    private fun initializeViews() {
        val fade_in_button =
            findViewById<View>(R.id.fade_in) as FrameLayout
        fade_in_button.setOnClickListener(this)
        val fade_out_button =
            findViewById<View>(R.id.fade_out) as FrameLayout
        fade_out_button.setOnClickListener(this)
        val slide_down_button =
            findViewById<View>(R.id.slide_down) as FrameLayout
        slide_down_button.setOnClickListener(this)
        val slide_up_button =
            findViewById<View>(R.id.slide_up) as FrameLayout
        slide_up_button.setOnClickListener(this)
        val slide_from_left_button =
            findViewById<View>(R.id.slide_from_left) as FrameLayout
        slide_from_left_button.setOnClickListener(this)
        val slide_from_right_button =
            findViewById<View>(R.id.slide_from_right) as FrameLayout
        slide_from_right_button.setOnClickListener(this)
    }

    private fun goToNextActivity(animationIn: Int, animationOut: Int) {
        val intent = Intent(this, Main2Activity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        overridePendingTransition(animationIn, animationOut)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.fade_in -> {
                goToNextActivity(R.anim.fade_in, R.anim.fade_out)
            }
            R.id.fade_out -> {
                goToNextActivity(R.anim.fade_out, R.anim.fade_out)
            }
            R.id.slide_down -> {
                goToNextActivity(R.anim.slide_down, R.anim.fade_out)
            }
            R.id.slide_up -> {
                goToNextActivity(R.anim.slide_up, R.anim.fade_out)
            }
            R.id.slide_from_left -> {
                goToNextActivity(R.anim.slide_in_from_left, R.anim.fade_out)
            }
            R.id.slide_from_right -> {
                goToNextActivity(R.anim.slide_in_from_right, R.anim.fade_out)
            }
        }
    }
}