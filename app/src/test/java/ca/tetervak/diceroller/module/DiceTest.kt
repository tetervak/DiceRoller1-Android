package ca.tetervak.diceroller.model

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException
import kotlin.random.Random

internal class DiceTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun startAll() {
            println("--- Starting Dice Tests ---")
        }

        @JvmStatic
        @AfterAll
        fun endAll() {
            println("--- End of Dice Tests ---")
        }
    }

    @BeforeEach
    fun setUp() {
        println("--- testing case ---")
    }

    @AfterEach
    fun tearDown() {
        println("--- ------- ---- ---")
    }

    @Test
    fun constructor_default() {
        println("constructor with all default parameters")
        val dice = Dice()
        println("dice = $dice")
        assertEquals(Dice.DEFAULT_INIT_VALUE, dice.value)
    }

    @Test
    fun constructor_valueFive() {
        println("constructor with init value: five")
        val dice = Dice(initValue = 5)
        println("dice = $dice")
        assertEquals(5, dice.initValue)
        assertEquals(5, dice.value)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 6])
    fun constructor_validValue(value: Int) {
        println("constructor with valid init value: $value")
        val dice = Dice(initValue = value)
        println("dice = $dice")
        assertEquals(value, dice.value)
    }

    @Test
    fun constructor_valueZero() {
        println("constructor with init value: zero")
        assertThrows<IllegalArgumentException> {
            val dice = Dice(initValue = 0)
            println("dice = $dice")
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 7])
    fun constructor_invalidValue(value: Int) {
        println("constructor with invalid init value: $value")
        assertThrows<IllegalArgumentException> {
            val dice = Dice(initValue = value)
            println("dice = $dice")
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 6])
    fun setValue_validValue(value: Int) {
        println("set valid value: $value")
        val dice = Dice()
        dice.value = value
        assertEquals(value, dice.value)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 7])
    fun setValue_invalidValue(value: Int) {
        println("set invalid value: $value")
        val dice = Dice()
        assertThrows<IllegalArgumentException> {
            dice.value = value
        }
    }

    @RepeatedTest(5)
    fun roll(repetitionInfo: RepetitionInfo) {
        val random = Random(seed = repetitionInfo.currentRepetition)
        val dice = Dice(random = random)
        println("before roll: dice = $dice")
        dice.roll()
        assertTrue(dice.value > 0)
        assertTrue(dice.value <= 6)
        println("after roll: dice = $dice")
    }

    @Test
    fun reset() {
        val dice = Dice(5)
        println("before reset: dice = $dice")
        dice.reset()
        println("after reset: dice = $dice")
        assertEquals(dice.initValue, dice.value)
    }

}
