package ca.tetervak.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import ca.tetervak.diceroller.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rollButton.setOnClickListener {
            mainViewModel.roll()
        }

        binding.resetButton.setOnClickListener {
            mainViewModel.reset()
        }

        // Start a coroutine in the lifecycle scope
        lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Trigger the flow and start listening for values.
                // Note that this happens when lifecycle is STARTED and stops
                // collecting when the lifecycle is STOPPED
                mainViewModel.flowRollData.collect { rollData ->
                    // New value received
                    if(rollData == null){
                        hideDiceRows()
                        hideResetButton()
                    } else {
                        showDiceRows()
                        val list = rollData.values
                        updateDiceImageRow(list)
                        updateDiceValueRow(list)
                        showResetButton()
                    }
                    updateTotal(rollData?.total ?: 0)
                }
            }
        }
    }

    private fun showResetButton() {
        binding.resetButton.visibility = View.VISIBLE
    }

    private fun hideResetButton() {
        binding.resetButton.visibility = View.GONE
    }

    private fun hideDiceRows(){
        with(binding){
            dieImagesRow.visibility = View.GONE
            dieValuesRow.visibility = View.GONE
        }
    }

    private fun showDiceRows(){
        with(binding){
            dieImagesRow.visibility = View.VISIBLE
            dieValuesRow.visibility = View.VISIBLE
        }
    }

    private fun updateDiceValueRow(list: List<Int>) {
        with(binding) {
            updateDieValue(die0TextView, list[0])
            updateDieValue(die1TextView, list[1])
            updateDieValue(die2TextView, list[2])
        }
    }

    private fun updateDiceImageRow(list: List<Int>) {
        with(binding) {
            updateDieImage(die0ImageView, list[0])
            updateDieImage(die1ImageView, list[1])
            updateDieImage(die2ImageView, list[2])
        }
    }

    private fun updateDieImage(imageView: ImageView, value: Int){
        with(imageView) {
            when (value) {
                1 -> setImageResource(R.drawable.dice_1)
                2 -> setImageResource(R.drawable.dice_2)
                3 -> setImageResource(R.drawable.dice_3)
                4 -> setImageResource(R.drawable.dice_4)
                5 -> setImageResource(R.drawable.dice_5)
                6 -> setImageResource(R.drawable.dice_6)
            }
        }
    }

    private fun updateDieValue(textView: TextView, value: Int){
        textView.text = value.toString()
    }

    private fun updateTotal(total: Int){
        binding.totalValueTextView.text = total.toString()
    }
}