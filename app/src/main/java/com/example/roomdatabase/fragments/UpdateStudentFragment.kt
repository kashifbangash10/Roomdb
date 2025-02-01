//package com.example.roomdatabase.fragments
//
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.lifecycleScope
//import com.example.roomdatabase.databinding.FragmentUpdateStudentBinding
//import com.example.roomdatabase.db.StudentDb
//import com.example.roomdatabase.model.Student
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//class UpdateStudentFragment : Fragment() {
//    private var _binding: FragmentUpdateStudentBinding? = null
//    private val binding get() = _binding!!
//    private lateinit var database: StudentDb
//    private var studentId: Int = -1 // Default invalid ID
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Retrieve student ID from arguments
//        arguments?.let {
//            studentId = it.getInt("studentId", -1)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentUpdateStudentBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Initialize the Room database
//        database = StudentDb.createDbInstance(requireContext())!!
//
//        // Handle the 'Update' button click
//        binding.updatebutton.setOnClickListener {
//            val name = binding.ed1.text.toString().trim()
//            val course = binding.ed2.text.toString().trim()
//            val mobile = binding.ed3.text.toString().trim()
//            val totalFeeText = binding.ed5.text.toString().trim()
//
//            // Validate input
//            if (name.isEmpty() || course.isEmpty() || mobile.isEmpty() || totalFeeText.isEmpty()) {
//                Toast.makeText(requireContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            // Convert totalFee safely
//            val totalFee = totalFeeText.toDoubleOrNull()
//            if (totalFee == null) {
//                Toast.makeText(requireContext(), "Invalid total fee entered.", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            // Create a Student object
//            val student = Student(
//                id = studentId,
//                name = name,
//                course = course,
//                mobile = mobile,
//                totalFee = totalFee
//            )
//
//            // Update student data
//            updateStudentData(student)
//        }
//    }
//
//    private fun updateStudentData(student: Student) {
//        // Check if student ID is valid (make sure it's not -1 or null)
//
//        lifecycleScope.launch {
//            try {
//                // Perform database update on a background thread
//                val rowsUpdated = withContext(Dispatchers.IO) {
//                    database.studentDao().updateStudentData(student)
//                }
//
//                // Log the result and notify the user
//                if (rowsUpdated > 0) {
//                    Log.d("UpdateStudentFragment", "Rows updated: $rowsUpdated")
//                    Toast.makeText(requireContext(), "Student updated successfully!", Toast.LENGTH_SHORT).show()
//
//                    // Optionally navigate back to the previous fragment
//                    parentFragmentManager.popBackStack()
//                } else {
//                    Log.d("UpdateStudentFragment", "No rows updated.")
//                    Toast.makeText(requireContext(), "Failed to update student.", Toast.LENGTH_SHORT).show()
//                }
//            } catch (e: Exception) {
//                // Handle any exceptions during the update operation
//                Log.e("UpdateStudentFragment", "Error updating student: ${e.message}")
//                Toast.makeText(requireContext(), "Error updating student. Please try again.", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null // Avoid memory leaks
//    }
//}
