package com.emmutua.viewmodel_demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    fun findSum() {
        val output = _uiState.value.number1.toInt() + _uiState.value.number2.toInt()
        _uiState.update {
            it.copy(
                output = output.toString(),
            )
        }
    }

    fun updateNumOne(number1: String) {
        _uiState.update {
            it.copy(
                number1 = number1,
            )
        }
    }

    fun updateNumTwo(number2: String) {
        _uiState.update {
            it.copy(
                number2 = number2,
            )
        }
    }
}

data class UiState(
    val number1: String = "",
    val number2: String = "",
    val output: String = "",
)
