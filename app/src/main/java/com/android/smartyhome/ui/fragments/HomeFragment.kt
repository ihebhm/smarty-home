package com.android.smartyhome.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.smartyhome.R
import com.android.smartyhome.databinding.FragmentHomeBinding
import com.android.smartyhome.model.Room
import com.android.smartyhome.ui.MainNavigationFragment
import com.android.smartyhome.ui.adapters.RoomsAdapter
import com.android.smartyhome.ui.fragments.MainFragment.Companion.ARG_NAME
import com.android.smartyhome.viewModels.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalCoroutinesApi
class HomeFragment : MainNavigationFragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val roomList: ArrayList<Room> = arrayListOf()
        roomList.add(Room("Living Room", 4, resources.getDrawable(R.drawable.livingroom)))
        roomList.add(Room("Media Room", 6, resources.getDrawable(R.drawable.mediaroom)))
        roomList.add(Room("Bathroom", 1, resources.getDrawable(R.drawable.bathroom)))
        roomList.add(Room("BedRoom", 3, resources.getDrawable(R.drawable.bedroom)))
        val adapter = RoomsAdapter(viewLifecycleOwner, viewModel, roomList)

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


    @SuppressLint("SimpleDateFormat")
    fun getDateFormat(calendar: Calendar?): String {
        calendar?.let { mCalendar ->
            val sdf = SimpleDateFormat("MMMM dd,yyyy")
            return sdf.format(mCalendar.time)
        }
        return ""
    }

}