package ca.tetervak.diceroller

import androidx.lifecycle.ViewModel
import ca.tetervak.diceroller.model.DiceGame
import ca.tetervak.diceroller.model.RollData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    // in a perfect app, this game object should be in the data layer
    private val game = DiceGame(numberOfDice = 3)

    private val _flowRollData = MutableStateFlow<RollData?>(game.rollData)
    val flowRollData: StateFlow<RollData?> = _flowRollData.asStateFlow()

    fun roll() {
        game.roll()
        _flowRollData.value = game.rollData
    }

    fun reset() {
        game.reset()
        _flowRollData.value = game.rollData
    }
}