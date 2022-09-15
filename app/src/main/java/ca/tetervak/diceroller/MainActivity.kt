package ca.tetervak.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.tetervak.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rollButton.setOnClickListener {

        }

        binding.resetButton.setOnClickListener {

        }

    }
}