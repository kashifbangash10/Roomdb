package com.example.roomdatabase.ui.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.roomdatabase.MvvM.NoteViewModel
import com.example.roomdatabase.MvvM.Notes
import com.example.roomdatabase.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint // Mark the fragment as an entry point for Hilt
class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    // Use Hilt to provide the ViewModel
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using ViewBinding
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listener for the create button
        binding.btncreate.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        // Get input from the user
        val title = binding.titleInput.text.toString().trim()
        val subtitle = binding.subtitleInput.text.toString().trim()
        val content = binding.descriptionInput.text.toString().trim()

        // Validate inputs
        if (title.isEmpty() || subtitle.isEmpty() || content.isEmpty()) {
            Toast.makeText(requireContext(), "All fields are required!", Toast.LENGTH_SHORT).show()
            return
        }

        // Generate the current date
        val date = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())

        // Create a Notes object
        val note = Notes(
            title = title,
            subtitle = subtitle,
            content = content,
             // Make sure the `Notes` model has a `date` field if needed
        )

        // Use the ViewModel to add the note
        viewModel.addNotes(note)

        // Notify the user and clear the input fields
        Toast.makeText(requireContext(), "Note added successfully!", Toast.LENGTH_SHORT).show()
        binding.titleInput.text?.clear()
        binding.subtitleInput.text?.clear()
        binding.descriptionInput.text?.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
