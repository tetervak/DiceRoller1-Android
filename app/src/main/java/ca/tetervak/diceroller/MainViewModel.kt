package ca.tetervak.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tetervak.diceroller.model.DiceGame
import ca.tetervak.diceroller.model.RollData

class MainViewModel: ViewModel() {

    private val _liveRollData = MutableLiveData<RollData?>()
    val liveRollData: LiveData<RollData?> = _liveRollData

    fun roll() {
        game.roll()
        _liveRollData.value = game.rollData
    }

    fun reset() {
        game.reset()
        _liveRollData.value = null
    }

    // in a perfect app, this should be in the data layer
    private val game = DiceGame(numberOfDice = 3)

}