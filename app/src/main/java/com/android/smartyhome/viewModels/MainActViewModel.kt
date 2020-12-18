package com.android.smartyhome.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.smartyhome.Event
import com.android.smartyhome.model.FadingSnackBarEvent
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActViewModel : ViewModel() {

    val eventFadingSnackBar = MutableLiveData<Event<FadingSnackBarEvent>>()

}