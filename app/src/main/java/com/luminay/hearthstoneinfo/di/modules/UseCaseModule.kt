package com.luminay.hearthstoneinfo.di.modules

import com.example.domain.cards.GetAllCardsUseCaseImpl
import com.example.domain.cards.IGetAllCardsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
fun interface UseCaseModule {

    @Binds
    fun providesGetAllCardsUseCase(
        getAllCardsUseCaseImpl: GetAllCardsUseCaseImpl,
    ): IGetAllCardsUseCase
}
