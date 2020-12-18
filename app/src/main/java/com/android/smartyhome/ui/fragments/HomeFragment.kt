package com.android.smartyhome.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.smartyhome.R
import com.android.smartyhome.databinding.FragmentHomeBinding
import com.android.smartyhome.model.Room
import com.android.smartyhome.ui.MainNavigationFragment
import com.android.smartyhome.ui.adapters.RoomsAdapter
import com.android.smartyhome.ui.fragments.MainFragment.Companion.ARG_NAME
import com.android.smartyhome.utils.getDateFormat
import com.android.smartyhome.viewModels.HomeViewModel
import java.util.*

class HomeFragment : MainNavigationFragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = RoomsAdapter(viewLifecycleOwner, viewModel, getRoomList())

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.adapter = adapter
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        arguments?.takeIf { it.containsKey(ARG_NAME) }?.apply {
            val data = getString(ARG_NAME)
            data?.let {
                viewModel.name = it
            }
        } ?: kotlin.run {
            findNavController().popBackStack()
        }

        viewModel.date = getDateFormat(Calendar.getInstance())


        return binding.root
    }


    /**
     * create fake room list
     */
    private fun getRoomList(): ArrayList<Room> {
        val roomList: ArrayList<Room> = arrayListOf()
        roomList.add(Room("Living Room", 4, getDrawable(requireActivity(), R.drawable.livingroom)!!))
        roomList.add(Room("Media Room", 6, getDrawable(requireActivity(), R.drawable.mediaroom)!!))
        roomList.add(Room("Bathroom", 1, getDrawable(requireActivity(), R.drawable.bathroom)!!))
        roomList.add(Room("BedRoom", 3, getDrawable(requireActivity(), R.drawable.bedroom)!!))
        return roomList
    }


}