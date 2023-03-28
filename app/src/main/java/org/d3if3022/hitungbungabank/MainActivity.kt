package org.d3if3022.hitungbungabank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if3022.hitungbungabank.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { hitungBunga() }

    }
    private fun hitungBunga() {
        Log.d("MainActivity", "Tombol diklik!")

        val pinjaman = binding.pinjamanInp.text.toString()
        if (TextUtils.isEmpty(pinjaman)) {
            Toast.makeText(this, R.string.pinjaman_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val waktu = binding.waktuInp.text.toString()
        if (TextUtils.isEmpty(waktu)) {
            Toast.makeText(this, R.string.waktu_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val bunga = binding.bungaInp.text.toString()
        if (TextUtils.isEmpty(bunga)) {
            Toast.makeText(this, R.string.bunga_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val bungaPersen = bunga.toFloat() / 100

        val hitung_bunga = (pinjaman.toFloat() / waktu.toFloat()) * bungaPersen

        val hitung_angsuran = (pinjaman.toFloat() / waktu.toFloat()) + hitung_bunga



        binding.banyakBungaTextView.text = getString(R.string.banyakbunga_x, hitung_bunga)

        binding.angsuranTextView.text = getString(R.string.banyakbunga_x, hitung_angsuran)
    }



}