package com.android.smartyhome.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class HomeViewModel : ViewModel() {

    lateinit var name: String
    lateinit var date: String

}