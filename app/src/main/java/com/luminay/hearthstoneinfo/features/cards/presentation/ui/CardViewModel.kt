package com.luminay.hearthstoneinfo.features.cards.presentation.ui

import androidx.lifecycle.ViewModel
import com.example.core.constants.HYPHEN
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor() : ViewModel() {

    fun handleStat(stat: Int): String = if (stat == -1) HYPHEN else stat.toString()
}
