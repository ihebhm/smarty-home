package com.android.smartyhome.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.smartyhome.EventObserver
import com.android.smartyhome.R
import com.android.smartyhome.databinding.ActivityMainBinding
import com.android.smartyhome.viewModels.MainActViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    val viewModel: MainActViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initSnackBar()
    }

    /**
     * show snackBar for successful or failed tasks
     */
    private fun initSnackBar() {
        viewModel.eventFadingSnackBar.observe(this, EventObserver { fadingSnackBar ->

            mBinding.snackbar.show(
                messageText = fadingSnackBar.message,
                actionId = R.string.ok,
                longDuration = true,
                background = if (fadingSnackBar.success) {
                    R.drawable.fading_snackbar_background_successful // successful tasks bg
                } else {
                    R.drawable.fading_snackbar_background_red // failed tasks bg
                }
            )

        })
    }

}