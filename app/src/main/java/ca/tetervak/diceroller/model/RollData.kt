package ca.tetervak.diceroller.model

// The data from one roll
data class RollData(val values: List<Int>){

    val total: Int
    init{
        var sum = 0
        for(value in values){
            sum += value
        }
        total = sum
    }

    val numberOfDice:Int get() = values.size
}
