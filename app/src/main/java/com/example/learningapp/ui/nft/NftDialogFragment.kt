package com.example.learningapp.ui.nft

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import coil.load
import com.example.learningapp.R

class NftDialogFragment : DialogFragment() {



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;
            val layout = inflater.inflate(R.layout.popupnftimage, null)
            val imageString = arguments?.getSerializable(DATA) as? String
            val imageView: ImageView = layout.findViewById(R.id.popupImage)
            imageString?.let { s ->
                imageView.load(s) {
                    placeholder(R.drawable.ic_launcher_background)
                    error(androidx.constraintlayout.widget.R.drawable.abc_ic_search_api_material)
                }
            }

            builder.setView(layout)
            builder.setTitle("Hardcoded")

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {
        const val DATA = "data"
        fun newInstance(imageUri: String) : NftDialogFragment = NftDialogFragment().apply {
            arguments = Bundle().apply {
                putSerializable(DATA, imageUri)
            }
        }
    }
}