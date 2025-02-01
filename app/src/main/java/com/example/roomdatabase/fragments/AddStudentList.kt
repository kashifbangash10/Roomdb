//package com.example.roomdatabase.fragments
//
//import android.app.AlertDialog
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.lifecycle.lifecycleScope
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.roomdatabase.dao.StudentDao
//import com.example.roomdatabase.databinding.FragmentAddStudentListBinding
//import com.example.roomdatabase.db.StudentDb
//import com.example.roomdatabase.model.Student
//import com.example.roomdatabase.studentAdaptor.StudentAdapter
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//
//class AddStudentList : Fragment() {
//
//    private var _binding: FragmentAddStudentListBinding? = null
//    private val binding get() = _binding!!
//    private lateinit var studentDb: StudentDb
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentAddStudentListBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//
//
/////////////////////
//        studentDb = StudentDb.createDbInstance(requireContext())!!
//
//        // Observe LiveData from the database
//        studentDb.studentDao().getAllStudentData().observe(viewLifecycleOwner) { students ->
//            // Update the UI with the list of students
//            displayStudents(students)
//        }
//    }
//    private fun deleteStudent(student: Student) {
//        AlertDialog.Builder(requireContext())
//            .setTitle("Delete Student")
//            .setMessage("Are you sure you want to delete this student?")
//            .setPositiveButton("Yes") { dialog, _ ->
//              lifecycleScope.launch(Dispatchers.IO) {
//                  studentDb.studentDao().deleteStudentData(student)
//
//              }
////                val rowsDeleted = StudentDb.StudentDao.deleteStudentData(student)
////                if (rowsDeleted > 0) {
////                    Toast.makeText(requireContext(), "Student deleted successfully!", Toast.LENGTH_SHORT).show()
////                } else {
////                    Toast.makeText(requireContext(), "Failed to delete student.", Toast.LENGTH_SHORT).show()
////                }
//                dialog.dismiss()
//            }
//            .setNegativeButton("No") { dialog, _ ->
//                dialog.dismiss()
//            }
//            .show()
//    }
//
//
//
//
//
//
//    private fun displayStudents(students: List<Student>) {
//        binding.recyclerVie.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//            adapter = StudentAdapter(students) { student ->
//                deleteStudent(student)
//            }
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}
//
//
//
//
