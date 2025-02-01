package com.example.roomdatabase.ui.Fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.roomdatabase.MvvM.NoteViewModel
import com.example.roomdatabase.MvvM.Notes
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.FragmentEditBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
@AndroidEntryPoint // Mark the fragment as an entry point for Hilt
class EditFragment : Fragment() {

    private val args by navArgs<EditFragmentArgs>() // Safely get arguments using Navigation Args
    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize ViewBinding
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true) // Enable options menu
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Populate fields with existing note data
        binding.titleInput.setText(args.data.title)
        binding.subtitleInput.setText(args.data.subtitle)
        binding.descriptionInput.setText(args.data.content)

        // Set click listener for the update button
        binding.editnotesbtn.setOnClickListener {
            updateNote()
        }
    }

    private fun updateNote() {
        // Get updated input from user
        val updatedTitle = binding.titleInput.text.toString().trim()
        val updatedSubtitle = binding.subtitleInput.text.toString().trim()
        val updatedContent = binding.descriptionInput.text.toString().trim()

        // Validate inputs
        if (updatedTitle.isEmpty() || updatedSubtitle.isEmpty() || updatedContent.isEmpty()) {
            Toast.makeText(requireContext(), "All fields must be filled!", Toast.LENGTH_SHORT).show()
            return
        }

        // Generate the current date (optional if not required to update the timestamp)
        val updatedDate =
            SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())

        // Create an updated Notes object
        val updatedNote = Notes(
            id = args.data.id, // Retain the existing note's ID
            title = updatedTitle,
            subtitle = updatedSubtitle,
            content = updatedContent
        )

        // Log updated note details for debugging
        Log.d("EditFragment", "Updated Note - Title: $updatedTitle, Subtitle: $updatedSubtitle, Content: $updatedContent")

        // Use ViewModel to update the note
        viewModel.updateNote(updatedNote)

        // Notify user
        Toast.makeText(requireContext(), "Note updated successfully!", Toast.LENGTH_SHORT).show()

        // Navigate back to HomeFragment to refresh the RecyclerView
        Navigation.findNavController(requireView()).navigate(R.id.action_editFragment_to_homeFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu) // Inflate menu with delete option
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menudelete) {
            deleteNote()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteNote() {
        // Safely delete the note using ViewModel
        args.data.id?.let { noteId ->
            viewModel.deleteNotesById(noteId)

            // Notify user
            Toast.makeText(requireContext(), "Note deleted successfully!", Toast.LENGTH_SHORT).show()

            // Navigate back to HomeFragment to refresh the RecyclerView
            Navigation.findNavController(requireView()).navigate(R.id.action_editFragment_to_homeFragment)
        } ?: run {
            Toast.makeText(requireContext(), "Failed to delete the note.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
