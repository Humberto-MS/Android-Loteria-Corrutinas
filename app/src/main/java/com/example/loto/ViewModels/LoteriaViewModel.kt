package com.example.loto.ViewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class LoteriaViewModel: ViewModel() {
    private val _lotoNumbers = mutableStateOf ( emptyList<Int>() )
    val lotoNumbers: State<List<Int>> = _lotoNumbers

    var isLoading by mutableStateOf(false)
        private set

    var loadingIndex by mutableStateOf(-1)
        private set

    fun generateLotoNumbers() {
        if (_lotoNumbers.value.size >= 6) return
        viewModelScope.launch {
            isLoading = true
            val newNumber = (1..60).shuffled().first()
            delay(2000)
            _lotoNumbers.value += newNumber
            isLoading = false
        }
    }
}