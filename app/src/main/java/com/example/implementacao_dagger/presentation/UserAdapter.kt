package com.example.implementacao_dagger.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.implementacao_dagger.data.model.UserDetails
import com.example.implementaodagger.databinding.ItemNameBinding

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private val dataset = mutableListOf<UserDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNameBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size

    fun update(list: List<UserDetails>) {
        this.dataset.clear()
        this.dataset.addAll(list)
        notifyDataSetChanged()
    }
}

class UserViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userDetails: UserDetails) {

        binding.name.text = userDetails.name
    }

}
