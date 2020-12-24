package com.android.smartyhome.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.android.smartyhome.databinding.ItemRoomBinding
import com.android.smartyhome.model.Room
import com.android.smartyhome.utils.executeAfter
import com.android.smartyhome.viewModels.HomeViewModel

class RoomsAdapter constructor(
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: HomeViewModel,
    private val roomList: List<Room>
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemRoomBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = roomList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.executeAfter {
            lifecycleOwner = this@RoomsAdapter.lifecycleOwner
            viewModel = this@RoomsAdapter.viewModel
            item = roomList[position]
        }
    }

}

class ViewHolder(val binding: ItemRoomBinding) :
    RecyclerView.ViewHolder(binding.root)