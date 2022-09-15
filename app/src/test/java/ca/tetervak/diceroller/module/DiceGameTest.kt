package ca.tetervak.diceroller.model

import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random


internal class DiceGameTest {

    companion object {

        @JvmStatic
        @BeforeAll
        fun startAll() {
            println("--- Starting DiceGame Tests ---")
        }

        @JvmStatic
        @AfterAll
        fun endAll() {
            println("--- End of DiceGame Tests ---")
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
    fun isRolled() {
        val game = DiceGame()
        println("before roll: game = $game")
        assertFalse(game.isRolled)
        game.roll()
        println("after roll: game = $game")
        assertTrue(game.isRolled)
    }

    @Test
    fun getRollData() {
        val rollData = RollData(listOf(3,4,2,5))
        println("rollData = $rollData")
        val game = DiceGame(rollData)
        assertTrue(game.isRolled)
        println("game = $game")
        println("game.rollData = ${game.rollData}")
        assertEquals(rollData, game.rollData)
    }

    @Test
    fun getTotal() {
        val rollData = RollData(listOf(1,3,4,2,5))
        println("rollData = $rollData")
        val game = DiceGame(rollData)
        assertTrue(game.isRolled)
        println("game = $game")
        val total = game.total
        println("total = $total")
        assertEquals(15, total)
    }


    @RepeatedTest(3)
    fun roll(repetitionInfo: RepetitionInfo) {
        val rep = repetitionInfo.currentRepetition
        val game = DiceGame(numberOfDice = rep + 2, random = Random(seed = rep + 17))
        println("before roll: game = $game")
        game.roll()
        println("after roll: game = $game")
    }

    @Test
    fun reset() {
        val game = DiceGame()
        assertFalse(game.isRolled)
        game.roll()
        assertTrue(game.isRolled)
        println("before reset: game = $game")
        game.reset()
        println("after reset: game = $game")
        assertFalse(game.isRolled)
    }

    @Test
    fun getNumberOfDice() {
        val game = DiceGame(numberOfDice = 5)
        println("game = $game")
        assertEquals(5, game.numberOfDice)
        println("game.numberOfDice = ${game.numberOfDice}")
    }
}
