package ca.tetervak.diceroller.model

import java.lang.IllegalArgumentException
import kotlin.random.Random

// One die object, for values 1 .. 6
class Dice(
    val initValue: Int = DEFAULT_INIT_VALUE,
    private val random: Random = Random.Default
) {

    companion object{
        const val DEFAULT_INIT_VALUE: Int = 1
    }

    var value: Int = DEFAULT_INIT_VALUE
        set(n) {
            if (n in 1..6) {
                field = n
            } else {
                throw IllegalArgumentException("Illegal die value $n")
            }
        }

    init {
        value = initValue
    }

    fun roll() {
        value = 1 + random.nextInt(6)
    }

    fun reset(){
        value = initValue
    }

    override fun toString() = "Dice(value = $value)"
}
