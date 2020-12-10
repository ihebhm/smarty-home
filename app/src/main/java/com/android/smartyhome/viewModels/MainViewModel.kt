package com.android.smartyhome.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.smartyhome.Event
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {

    private val _navigate = MutableLiveData<Event<Destination>>()
    val navigate: LiveData<Event<Destination>>
        get() = _navigate

    fun onClickOpenHome() {
        viewModelScope.launch {
            _navigate.postValue(Event(Destination.HOME))
        }
    }

    enum class Destination {
        HOME
    }
}