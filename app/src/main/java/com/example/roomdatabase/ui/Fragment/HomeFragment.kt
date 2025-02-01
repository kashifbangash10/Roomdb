package com.example.roomdatabase.ui.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.roomdatabase.MvvM.NoteViewModel
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.FragmentHomeBinding
import com.example.roomdatabase.ui.Adaptor.NotesAdaptor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Mark the fragment as an entry point for Hilt
class HomeFragment : Fragment() {

    // Use nullable binding to prevent memory leaks
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // ViewModel injected using Hilt
    private val viewModel: NoteViewModel by viewModels()

    private lateinit var notesAdapter: NotesAdaptor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate to AddFragment when the button is clicked
        binding.addbtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addFragment)
        }

        // Set up RecyclerView with a GridLayoutManager
        notesAdapter = NotesAdaptor(requireContext(), emptyList())
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = notesAdapter

        // Observe the notes data from ViewModel
        viewModel.getAllNotes().observe(viewLifecycleOwner, Observer { notesList ->
            // Update the adapter with new data
            notesAdapter.update(notesList)  // Now calling the correct `update` method

            // Log the data for debugging
            for (note in notesList) {
                Log.e("HomeFragment", "Note: $note")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Prevent memory leaks
    }
}
