//package com.example.roomdatabase.fragments
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.lifecycleScope
//import androidx.navigation.fragment.findNavController
//import com.example.roomdatabase.R
//import com.example.roomdatabase.databinding.FragmentAddStudentFragmentBinding
//
//import com.example.roomdatabase.db.StudentDb
//import com.example.roomdatabase.model.Student
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//class AddStudentFragment : Fragment() {
//    private var _binding: FragmentAddStudentFragmentBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentAddStudentFragmentBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Navigate to ViewStudentFragment when btn2 is clicked
//        binding.btn2.setOnClickListener {
//            findNavController().navigate(R.id.action_addStudentFrament_to_addStudentList)
//        }
//
//        // Handle save button click to insert student data
//        binding.save.setOnClickListener {
//            insertData()
//        }
//    }
//
//    private fun insertData() {
//        val name = binding.editText.text.toString().trim()
//        val course = binding.et2.text.toString().trim()
//        val mobile = binding.edi3.text.toString().trim()
//        val totalFeeText = binding.ed4.text.toString().trim()
//
//        // Validate input fields
//        if (name.isEmpty() || course.isEmpty() || mobile.isEmpty() || totalFeeText.isEmpty()) {
//            Toast.makeText(requireContext(), "All fields are required!", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        // Convert total fee to a double value
//        val totalFee = totalFeeText.toDoubleOrNull()
//        if (totalFee == null) {
//            Toast.makeText(requireContext(), "Invalid fee amount!", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        val student = Student(
//            name = name,
//            course = course,
//            mobile = mobile,
//            totalFee = totalFee
//        )
//
//        // Get database instance and insert data
//        val db = StudentDb.createDbInstance(requireContext())
//
//        lifecycleScope.launch {
//            try {
//                withContext(Dispatchers.IO) {
//                    db!!.studentDao().insertStudentData(student)
//                }
//
//                // Show success message and clear input fields on the main thread
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(requireContext(), "Student added successfully!", Toast.LENGTH_SHORT).show()
//                    clearInputFields()
//                }
//            } catch (e: Exception) {
//                // Catch any exceptions and show an error message
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(requireContext(), "Error adding student: ${e.message}", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
//
//    private fun clearInputFields() {
//        binding.editText.text.clear()
//        binding.et2.text.clear()
//        binding.edi3.text.clear()
//        binding.ed4.text.clear()
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}
