package com.paba.projectpaba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class detPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_det_player)
        var _ivFoto = findViewById<ImageView>(R.id.ivFoto)
        var _tvNama = findViewById<TextView>(R.id.tvNama)
        var _tvDetail = findViewById<TextView>(R.id.tvDetail)
        val dataIntent = intent.getParcelableExtra<player>("kirimData")
        _ivFoto.setImageResource(dataIntent!!.foto)
        _tvNama.setText(dataIntent!!.nama)
        _tvDetail.setText(dataIntent!!.detail)
    }

}