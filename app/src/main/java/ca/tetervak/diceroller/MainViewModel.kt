package ca.tetervak.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tetervak.diceroller.model.RollData

class MainViewModel: ViewModel() {

    private val _rollData = MutableLiveData<RollData?>()
    val rollData: LiveData<RollData?> = _rollData

    fun roll() {
        TODO("Not yet implemented")
    }

    fun reset() {
        TODO("Not yet implemented")
    }




}