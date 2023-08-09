package com.luminay.hearthstoneinfo.domain.di

import com.luminay.hearthstoneinfo.data.remote.repositories.CardRepositoryImpl
import com.luminay.hearthstoneinfo.domain.repositories.ICardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
fun interface RepositoryModule {

     @Binds
     fun bindCardRepository(cardRepositoryImpl: CardRepositoryImpl): ICardRepository
}
