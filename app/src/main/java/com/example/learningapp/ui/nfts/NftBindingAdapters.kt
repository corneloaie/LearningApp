package com.example.learningapp.ui.nfts

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.example.learningapp.R

@BindingAdapter("imageUrl")
fun setImage(imageView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imgUri) {
            placeholder(com.google.android.material.R.drawable.abc_btn_check_material_anim)
            error(R.drawable.ic_launcher_background)
        }
    }
}
@BindingAdapter("nftName")
fun setName(textview: TextView, string: String?) {
    string?.let {
        textview.setText(string)
    }
}