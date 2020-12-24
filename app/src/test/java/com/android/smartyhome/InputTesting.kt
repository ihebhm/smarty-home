package com.android.smartyhome

import com.android.smartyhome.dataManager.DataManager
import com.android.smartyhome.viewModels.MainViewModel
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InputTesting {
    private lateinit var myObjectUnderTest: MainViewModel

    @Before
    fun initMocks() {
        val mockDataMainViewModel = mock(DataManager::class.java)
        myObjectUnderTest = MainViewModel(mockDataMainViewModel)
    }

    @Test
    fun testSignInInputs() {
        assertTrue(myObjectUnderTest.verifyName("name"))
        assertFalse(myObjectUnderTest.verifyName(""))
        assertFalse(myObjectUnderTest.verifyName(null))
    }


}