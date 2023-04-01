package com.example.demoapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    var proceed: Boolean = false

    fun goToNextScreen(): Boolean {
        viewModelScope.launch {
            delay(5000)
            proceed = true
        }
        return proceed
    }
}