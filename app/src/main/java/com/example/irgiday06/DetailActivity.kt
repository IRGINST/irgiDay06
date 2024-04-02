package com.example.irgiday06

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.irgiday06.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val namaMobil = intent.getStringExtra("nama")
        val merkMobil = intent.getStringExtra("merk")
        val hargaMobil = intent.getStringExtra("harga")
        val fotoMobil = intent.getIntExtra("foto", 1)

        with(binding){
            nama.text = namaMobil
            merk.text = merkMobil
            harga.text = hargaMobil
            foto.setImageResource(fotoMobil)

            btnShare.setOnClickListener {
                val i = Intent()
                i.setAction(Intent.ACTION_SEND)
                i.putExtra(Intent.EXTRA_TEXT, "Nama mobil : $namaMobil \n" + "Merk mobil : $merkMobil \n" +
                        "Harga mobil : $hargaMobil")
                i.setType("text/plain")
                startActivity(i)
            }
        }
    }
}