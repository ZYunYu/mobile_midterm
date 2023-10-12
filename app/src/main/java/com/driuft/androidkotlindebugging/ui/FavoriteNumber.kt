package com.driuft.androidkotlindebugging.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.driuft.androidkotlindebugging.R
import kotlin.random.Random

class FavoriteNumber : AppCompatActivity() {

    private val favoriteNumber: TextView get() = findViewById(R.id.favorite_number)
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_number)

        mediaPlayer = MediaPlayer.create(this, R.raw.fanfare_trumpets)
        mediaPlayer.isLooping = false

        val randomNumber = Random.nextInt(1, 10)  // Generates a random number between 1 and 9 inclusive
        favoriteNumber.text = "$randomNumber"
        Toast.makeText(this, "Today's lucky number is $randomNumber!", Toast.LENGTH_SHORT).show()
        mediaPlayer.start()  // Play the music
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}