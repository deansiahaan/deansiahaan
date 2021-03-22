package com.example.challenge4

class Controller(private val callback: Callback) {
    fun hitung(pemain1: String, pemain2: String) {
        val status = when {
            pemain1 == "Batu" && pemain2 == "Gunting" || pemain1 == "Kertas" &&
                    pemain2 == "Batu" || pemain1 == "Gunting" && pemain2 == "Kertas" -> "Pemain1 Menang!"

            pemain1 == "Gunting" && pemain2 == "Batu" || pemain1 == "Batu" &&
                    pemain2 == "Kertas" || pemain1 == "Kertas" && pemain2 == "Gunting" -> "Pemain2 Menang!"
            else -> "Draw"


        }

        callback.kirimStatus(status)

    }
}