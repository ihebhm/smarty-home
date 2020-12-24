package com.android.smartyhome.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.smartyhome.Event
import com.android.smartyhome.dataManager.DataManager
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val dataManager: DataManager
) : ViewModel() {

    private val _navigate = MutableLiveData<Event<Destination>>()
    val navigate: LiveData<Event<Destination>>
        get() = _navigate

    fun onClickOpenHome() {
        viewModelScope.launch {
            _navigate.postValue(Event(Destination.HOME))
        }
    }

    /**
     * verify name input
     */
    fun verifyName(name: String?): Boolean {
        if (name.isNullOrEmpty()) {
            return false
        }
        return true
    }

    enum class Destination {
        HOME
    }

}