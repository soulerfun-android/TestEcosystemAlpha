package com.example.testecosystemalpha.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testecosystemalpha.domain.entity.BinInfoItem
import com.example.testecosystemalpha.domain.usecases.AddBinItemUseCase
import com.example.testecosystemalpha.domain.usecases.DeleteBinItemUseCase
import com.example.testecosystemalpha.domain.usecases.GetBinItemListUseCase
import com.example.testecosystemalpha.domain.usecases.GetBinItemUseCase
import com.example.testecosystemalpha.presentation.ui.screen_states.BinInfoScreenState
import com.example.testecosystemalpha.presentation.ui.screen_states.BinItemListScreenStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addBinItemUseCase: AddBinItemUseCase,
    private val getBinItemUseCase: GetBinItemUseCase,
    private val getBinItemListUseCase: GetBinItemListUseCase,
    private val deleteBinItemUseCase: DeleteBinItemUseCase
) : ViewModel() {

    private val _binInfoState =
        MutableStateFlow<BinInfoScreenState>(BinInfoScreenState.Initial)
    val newsItemsState = _binInfoState.asStateFlow()

    private val _searchState =
        MutableStateFlow<Boolean>(true)
    val searchState = _searchState.asStateFlow()

    private val _binItemsState =
        MutableStateFlow<BinItemListScreenStates>(BinItemListScreenStates.Initial)
    val binItemsState = _binItemsState.asStateFlow()

    fun getBinItemList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val binItems = getBinItemListUseCase.getBinItemList()
                _binItemsState.value = BinItemListScreenStates.BinInfoScreen(binItems)
            }
        }
    }

    fun deleteBinItem(binItemId: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                deleteBinItemUseCase.deleteBinItem(binItemId)
                getBinItemList()
            }
        }
    }

    fun loadCardInfo(bin: String) {
        val search = viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _searchState.value = false
                try {
                    val binItem = getBinItemUseCase.getBinItem(bin)
                    val newBinItem = binItem.copy(binNumber = bin)
                    _binInfoState.value = BinInfoScreenState.BinInfoScreen(newBinItem)
                    addBinCardInfoInDb(newBinItem)
                } catch (_: Exception) {
                    _binInfoState.value =
                        BinInfoScreenState.BinInfoScreen(BinInfoItem(binNumber = "no data"))
                }
            }
        }
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                search.join()
                _searchState.value = true
            }
        }
    }

    private fun addBinCardInfoInDb(binInfoItem: BinInfoItem) {
        addBinItemUseCase.addBinItem(binInfoItem)
        getBinItemList()
    }

    init {
        loadCardInfo(bin = "no data")
        getBinItemList()
    }
}