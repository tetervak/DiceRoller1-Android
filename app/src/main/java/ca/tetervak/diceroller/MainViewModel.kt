package ca.tetervak.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tetervak.diceroller.model.DiceGame
import ca.tetervak.diceroller.model.RollData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val game: DiceGame
): ViewModel() {

    private val _liveRollData = MutableLiveData<RollData?>(game.rollData)
    val liveRollData: LiveData<RollData?> = _liveRollData

    fun roll() {
        game.roll()
        _liveRollData.value = game.rollData
    }

    fun reset() {
        game.reset()
        _liveRollData.value = game.rollData
    }
}