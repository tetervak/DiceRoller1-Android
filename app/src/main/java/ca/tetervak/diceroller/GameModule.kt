package ca.tetervak.diceroller

import ca.tetervak.diceroller.model.DiceGame
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object GameModule {

    @Provides
    fun provideDiceGame() = DiceGame()
}