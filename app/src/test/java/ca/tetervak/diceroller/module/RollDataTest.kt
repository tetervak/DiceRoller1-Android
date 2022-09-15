package ca.tetervak.diceroller.model

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll

internal class RollDataTest {

    companion object {

        @JvmStatic
        @BeforeAll
        fun startAll() {
            println("--- Starting RollData Tests ---")
        }

        @JvmStatic
        @AfterAll
        fun endAll() {
            println("--- End of RollData Tests ---")
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
    fun getTotal() {
        val rollData = RollData(listOf(3,4,2,5))
        println("rollData = $rollData")
        val total = rollData.total
        println("total = $total")
        assertEquals(14, total)
    }

    @Test
    fun getNumberOfDice() {
        val rollData = RollData(listOf(1,4,3,4,2,5))
        println("rollData = $rollData")
        val numberOfDice = rollData.numberOfDice
        println("numberOfDice = $numberOfDice")
        assertEquals(6, numberOfDice)
    }

    @Test
    fun getValues() {
        val values = listOf(1,3,4,2,5)
        println("values = $values")
        val rollData = RollData(values)
        println("rollData = $rollData")
        println("rollData.values = ${rollData.values}")
        assertEquals(values, rollData.values)
    }
}
