package com.android.smartyhome.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.smartyhome.EventObserver
import com.android.smartyhome.R
import com.android.smartyhome.databinding.FragmentMainBinding
import com.android.smartyhome.ui.MainNavigationFragment
import com.android.smartyhome.utils.getNavOptions
import com.android.smartyhome.viewModels.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainFragment : MainNavigationFragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    companion object {
        const val ARG_NAME = "arg_name"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.navigate.observe(viewLifecycleOwner, EventObserver {
            val action = Bundle()
            action.putString(ARG_NAME, name_et.text.toString())
            findNavController().navigate(
                R.id.homeFragment,
                action,
                getNavOptions()
            )
        })

        return binding.root
    }


}