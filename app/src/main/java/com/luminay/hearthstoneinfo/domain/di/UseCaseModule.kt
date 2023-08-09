package com.luminay.hearthstoneinfo.domain.di

import com.luminay.hearthstoneinfo.domain.usecases.cards.GetAllCardsUseCaseImpl
import com.luminay.hearthstoneinfo.domain.usecases.cards.IGetAllCardsUseCase
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
