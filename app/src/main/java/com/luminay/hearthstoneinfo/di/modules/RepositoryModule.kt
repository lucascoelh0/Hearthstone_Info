package com.luminay.hearthstoneinfo.di.modules

import com.example.data.remote.repositories.CardRepositoryImpl
import com.example.domain.repositories.ICardRepository
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
