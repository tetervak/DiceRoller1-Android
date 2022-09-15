package ca.tetervak.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ca.tetervak.diceroller.databinding.ActivityMainBinding
import ca.tetervak.diceroller.model.RollData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val mainViewModel: MainViewModel by viewModels()

        binding.rollButton.setOnClickListener {
            mainViewModel.roll()
        }

        binding.resetButton.setOnClickListener {
            mainViewModel.reset()
        }

        mainViewModel.rollData.observe(this){ data ->
            updateViews(data)
        }

    }

    private fun updateViews(data: RollData?) {

    }
}