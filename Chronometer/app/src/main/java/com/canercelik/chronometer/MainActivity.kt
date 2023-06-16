package com.canercelik.chronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.view.inputmethod.InputBinding
import com.canercelik.chronometer.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var stopTheTime: Long = 0
        binding.btnStart.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime()+ stopTheTime
            binding.chronometer.start()
            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }

        binding.btnPause.setOnClickListener {
            stopTheTime = binding.chronometer.base-SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }

        binding.btnReset.setOnClickListener{
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            stopTheTime = 0
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }

        }

    }
