package com.example.bottomsheetdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.bottomsheetdialog.databinding.ActivityMainBinding
import com.example.bottomsheetdialog.databinding.CustomButtonLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowDialog.setOnClickListener{showBottomSheetDialog()}
    }
    private fun showBottomSheetDialog(){
        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog).apply {
            window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }

        val sheetBinding: CustomButtonLayoutBinding =
            CustomButtonLayoutBinding.inflate(layoutInflater, null, false)

        sheetBinding.btnLogin.setOnClickListener{
            dialog.dismiss()
            val email = sheetBinding.editEmail.text.toString()
            binding.textEmail.text = email
        }

        dialog.setContentView(sheetBinding.root)
        dialog.show()
    }
}