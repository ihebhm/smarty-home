package com.android.smartyhome.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.smartyhome.Event
import com.android.smartyhome.model.FadingSnackBarEvent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainActViewModel : ViewModel() {

    val _eventFadingSnackBar = MutableLiveData<Event<FadingSnackBarEvent>>()
    val eventFadingSnackBar: LiveData<Event<FadingSnackBarEvent>>
        get() = _eventFadingSnackBar


}