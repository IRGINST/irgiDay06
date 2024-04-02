package com.example.irgiday06

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irgiday06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mobilAdapter: MobilAdapter
    private lateinit var mList: List<Mobil>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val namaMobil = resources.getStringArray(R.array.nama_mobil)
        val merkMobil = resources.getStringArray(R.array.merk_mobil)
        val hargaMobil = resources.getStringArray(R.array.harga_mobil)
        val fotoMobil = resources.getStringArray(R.array.foto_mobil)

        mList = namaMobil.indices.map {
            Mobil(
                namaMobil[it],
                merkMobil[it],
                hargaMobil[it],
                fotoMobil[it]
            )
        }

        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(this)
            mobilAdapter = MobilAdapter(mList)
            it.adapter = mobilAdapter
        }
    }
}