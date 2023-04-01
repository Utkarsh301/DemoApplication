package com.example.demoapplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(): ViewModel() {
    val loadingFlow = MutableSharedFlow<Boolean>(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
    var loadingState: SharedFlow<Boolean> = loadingFlow

    var errorFlow = MutableSharedFlow<String>(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
    var errorState: SharedFlow<String> = errorFlow

    fun <T> requestApi(flow: Flow<Response<T?>>?, onResult: (suspend (T?) -> Unit)) {
        viewModelScope.launch {
            flow?.collectLatest {
                onResult.invoke(it.body())
                try {
                    val message = JSONObject(
                        it.errorBody()?.string().toString()
                    ).getString("error")
                    errorFlow.emit(message)
                } catch (e: Exception) {
                    errorFlow.emit("Something went wrong. Please try again later")
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}