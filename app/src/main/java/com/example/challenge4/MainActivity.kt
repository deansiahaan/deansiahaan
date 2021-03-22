package com.example.challenge4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity(), Callback {


    private lateinit var btnPemain1: ImageButton
    private lateinit var btnPemain12: ImageButton
    private lateinit var btnPemain13: ImageButton
    private lateinit var btnCom1: ImageButton
    private lateinit var btnCom12: ImageButton
    private lateinit var btnCom13: ImageButton
    private lateinit var btnRefresh: ImageButton
    private lateinit var imageStatus: ImageView
    private lateinit var pilihanPemain: String
    private lateinit var pilihanCom: String

    private val controller = Controller(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPemain1 = findViewById(R.id.batu1)
        btnPemain12 = findViewById(R.id.kertas1)
        btnPemain13 = findViewById(R.id.gunting1)
        imageStatus = findViewById(R.id.vs)
        btnRefresh = findViewById(R.id.refresh)

        btnRefresh.setOnClickListener()
        {
            btnPemain1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnPemain12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnPemain13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            imageStatus.setImageResource(R.drawable.vs)
            btnPemain1.isEnabled = true
            btnPemain12.isEnabled = true
            btnPemain13.isEnabled = true

        }

        btnPemain1.setOnClickListener {
            pilihanPemain = "Batu"
            btnPemain1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            Log.i("Pemain1", "Pemain1 memilih Batu")
            pemain()
            btnPemain12.isEnabled = false
            btnPemain13.isEnabled = false
        }

        btnPemain12.setOnClickListener {
            pilihanPemain = "Kertas"
            btnPemain12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            Log.i("Pemain1", "Pemain1 memilih Kertas")
            pemain()
            btnPemain1.isEnabled = false
            btnPemain13.isEnabled = false

        }

        btnPemain13.setOnClickListener {
            pilihanPemain = "Gunting"
            btnPemain13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            Log.i("Pemain1", "Pemain1 memilih Gunting")
            pemain()
            btnPemain1.isEnabled = false
            btnPemain12.isEnabled = false
        }
    }

    fun pemain() {
        val randomCom: Int = Random.nextInt(3)
        btnCom1 = findViewById(R.id.batu2)
        btnCom12 = findViewById(R.id.kertas2)
        btnCom13 = findViewById(R.id.gunting2)

        when (randomCom) {
            0 -> {
                pilihanCom = "Batu"
                btnCom1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
                Log.i("Com1", "Com1 memilih Batu")

            }
            1 -> {
                pilihanCom = "Kertas"
                btnCom12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
                Log.i("Com1", "Com1 memilih Kertas")
            }
            2 -> {
                pilihanCom = "Gunting"
                btnCom13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
                Log.i("Com1", "Com1 memilih Gunting")
            }
        }


        controller.hitung(pilihanPemain, pilihanCom)
    }

    override fun kirimStatus(status: String) {

        if (status.contains("1")) {
            imageStatus.setImageResource(R.drawable.p1menang)
            Log.i("Hasil", "Pemain1 Menang")
        } else if (status.contains("2")) {
            imageStatus.setImageResource(R.drawable.p2menang)
            Log.i("Hasil", "Pemain2 Menang")
        } else {
            imageStatus.setImageResource(R.drawable.draw)
            Log.i("Hasil", "Draw")
        }

    }
}

    //        when {
    //            status.contains("1")  -> imageStatus.setImageResource(R.drawable.p1menang)
    //            status.contains("2") -> imageStatus.setImageResource(R.drawable.p2menang)
    //            status.contains("Draw") -> imageStatus.setImageResource(R.drawable.draw)
    //        }





