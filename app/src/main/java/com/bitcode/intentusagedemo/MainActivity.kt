package com.bitcode.intentusagedemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import com.bitcode.intentusagedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder().build()
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDisplay.setOnClickListener {

            var intent = Intent("in.bitcode.media.VIEW")
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )
            //intent.putExtra("path", binding.edtPath.text.toString())

            startActivity(intent)
        }

        binding.btnShowImageInGal.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )
            //intent.putExtra("path", binding.edtPath.text.toString())

            startActivity(intent)
        }

        binding.btnVideo.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "video/mp4"
            )
            //intent.putExtra("path", binding.edtPath.text.toString())

            startActivity(intent)
        }

        binding.btnAudio.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "audio/mp3"
            )
            //intent.putExtra("path", binding.edtPath.text.toString())

            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {

            var intent = Intent(Intent.ACTION_SEND)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )
            //intent.putExtra("path", binding.edtPath.text.toString())

            startActivity(intent)
        }

        binding.btnWeb.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(
                Uri.parse(binding.edtPath.text.toString())
            )
            //intent.putExtra("path", binding.edtPath.text.toString())

            startActivity(intent)
        }

        binding.btnCall.setOnClickListener {

            //var intent = Intent(Intent.ACTION_DIAL)
            var intent = Intent(Intent.ACTION_CALL)
            intent.setData(
                Uri.parse(binding.edtPath.text.toString())
            )
            //intent.putExtra("path", binding.edtPath.text.toString())

            startActivity(intent)
        }

        binding.btnPickImage.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"

            startActivityForResult(
                intent, 1
            )
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null) {
            Log.e("tag", "********************************")
            Log.e("tag", "${data.data}")
            Log.e("tag", "********************************")
            binding.imgSomeImage.setImageURI(data.data)
        }
    }
}