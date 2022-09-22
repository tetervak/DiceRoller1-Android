package ca.tetervak.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import ca.tetervak.diceroller.databinding.ActivityMainBinding
import ca.tetervak.diceroller.model.RollData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rollButton.setOnClickListener {
            mainViewModel.roll()
        }

        binding.resetButton.setOnClickListener {
            mainViewModel.reset()
        }

        mainViewModel.liveRollData.observe(this){ data ->
            if(data == null){
                hideOutputs()
            } else {
                showOutputs()
                updateOutputs(data)
            }
        }
    }

    private fun hideOutputs(){
        with(binding){
            dieImagesRow.visibility = View.INVISIBLE
            dieValuesRow.visibility = View.INVISIBLE
            totalRow.visibility = View.INVISIBLE
        }
    }

    private fun showOutputs(){
        with(binding){
            dieImagesRow.visibility = View.VISIBLE
            dieValuesRow.visibility = View.VISIBLE
            totalRow.visibility = View.VISIBLE
        }
    }

    private fun updateOutputs(data: RollData) {
        with(binding) {
            updateDieImageOutput(die0ImageView, data.values[0])
            updateDieImageOutput(die1ImageView, data.values[1])
            updateDieImageOutput(die2ImageView, data.values[2])

            updateDieValueOutput(die0TextView, data.values[0])
            updateDieValueOutput(die1TextView, data.values[1])
            updateDieValueOutput(die2TextView, data.values[2])

            updateTotalValueOutput(data.total)
        }
    }

    private fun updateDieImageOutput(imageView: ImageView, value: Int){
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

    private fun updateDieValueOutput(textView: TextView, value: Int){
        textView.text = value.toString()
    }

    private fun updateTotalValueOutput(total: Int){
        binding.totalValueTextView.text = total.toString()
    }
}