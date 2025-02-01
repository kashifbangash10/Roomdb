package com.example.roomdatabase.ui.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.MvvM.Notes
import com.example.roomdatabase.databinding.ItemnotesBinding
import com.example.roomdatabase.ui.Fragment.HomeFragmentDirections

class NotesAdaptor(
    private val context: Context?,
    private var notelist: List<Notes> // Make it mutable so we can update it
) : RecyclerView.Adapter<NotesAdaptor.NotesViewHolder>() {

    // Method to update the list of notes and notify the adapter
    fun update(newNotesList: List<Notes>) {
        notelist = newNotesList
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemnotesBinding.inflate(layoutInflater, parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NotesViewHolder,
        position: Int
    ) {
        val data = notelist[position]
        with(holder.itemnotesBinding) {
            titleText.text = data.title
            descriptionText.text = data.subtitle
            content.text = data.content

            root.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToEditFragment(data)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int = notelist.size

    class NotesViewHolder(val itemnotesBinding: ItemnotesBinding) :
        RecyclerView.ViewHolder(itemnotesBinding.root)
}
