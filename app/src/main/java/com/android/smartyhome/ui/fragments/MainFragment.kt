package com.android.smartyhome.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.smartyhome.Event
import com.android.smartyhome.EventObserver
import com.android.smartyhome.R
import com.android.smartyhome.databinding.FragmentMainBinding
import com.android.smartyhome.model.FadingSnackBarEvent
import com.android.smartyhome.ui.MainNavigationFragment
import com.android.smartyhome.ui.activities.MainActivity
import com.android.smartyhome.utils.getNavOptions
import com.android.smartyhome.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class MainFragment : MainNavigationFragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()
    private lateinit var mainActivity: MainActivity

    companion object {
        const val ARG_NAME = "arg_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        if (!viewModel.dataManager.getUserName().isNullOrEmpty()) {
            goToHome(viewModel.dataManager.getUserName()!!)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        onObserverEvents()

        return binding.root
    }

    /**
     * observe [MainFragment] events
     */
    private fun onObserverEvents() {
        viewModel.navigate.observe(viewLifecycleOwner, EventObserver {
            if (viewModel.verifyName(name_et.text.toString())) {
                viewModel.dataManager.setUserName(name_et.text.toString())
                goToHome(name_et.text.toString())
            } else {
                mainActivity.viewModel.eventFadingSnackBar.postValue(
                    Event(
                        FadingSnackBarEvent(
                            true,
                            getString(R.string.required_name),
                            false
                        )
                    )
                )
            }
        })
    }

    /**
     * open [HomeFragment] and clear backStack
     */
    private fun goToHome(userName: String) {
        val action = Bundle()
        action.putString(ARG_NAME, userName)

        findNavController().popBackStack(R.id.mainFragment, true)

        findNavController().navigate(
            R.id.homeFragment,
            action,
            getNavOptions()
        )
    }


}