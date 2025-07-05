package com.example.testecosystemalpha.presentation.ui.screen_states

import androidx.lifecycle.LiveData
import com.example.testecosystemalpha.domain.entity.BinInfoItem

sealed class BinItemListScreenStates {

    object Initial : BinItemListScreenStates()

    data class BinInfoScreen(
        val binItems: List<BinInfoItem>
    ) : BinItemListScreenStates()
}