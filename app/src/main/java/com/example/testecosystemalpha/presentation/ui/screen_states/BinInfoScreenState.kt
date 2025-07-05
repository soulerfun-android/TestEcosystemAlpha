package com.example.testecosystemalpha.presentation.ui.screen_states

import com.example.testecosystemalpha.domain.entity.BinInfoItem

sealed class BinInfoScreenState {

    object Initial : BinInfoScreenState()

    data class BinInfoScreen(
        val binItem: BinInfoItem
    ) : BinInfoScreenState()
}