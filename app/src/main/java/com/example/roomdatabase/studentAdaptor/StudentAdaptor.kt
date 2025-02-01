//package com.example.roomdatabase.studentAdaptor
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.navigation.findNavController
//import androidx.recyclerview.widget.RecyclerView
//import com.example.roomdatabase.R
//import com.example.roomdatabase.databinding.ItemstudentBinding
//import com.example.roomdatabase.model.Student
//
//class StudentAdapter(
//    private val studentList: List<Student>,
//    private val onDeleteClicked: (Student) -> Unit
//) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
//
//    // ViewHolder class
//    class StudentViewHolder(private val binding: ItemstudentBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//    /////call back ma student araha hai wapas  StudentlistFragment ma ///
//        fun bind(student: Student, onDeleteClicked: (Student) -> Unit) {
//            binding.tvNam.text = student.name
//            binding.tvCours.text = student.course
//            binding.tvMobil.text = student.mobile
//            binding.tvTotalFee.text = "${student.totalFee}"
//
//            // Delete Button
//            binding.btnDelete.setOnClickListener {
//                onDeleteClicked(student) // Trigger the delete action
//            }
//
//            // Update Button
//            binding.btnUpdate.setOnClickListener {
//                val bundle = Bundle()
//                bundle.putInt("studentId", student.id) // Pass student ID
//                it.findNavController().navigate(
//                    R.id.action_addStudentList_to_updateStudentFragment,
//                    bundle
//                )
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        val binding = ItemstudentBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent,
//            false
//        )
//        return StudentViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
//        holder.bind(studentList[position], onDeleteClicked)
//    }
//
//    override fun getItemCount(): Int {
//        return studentList.size
//    }
//
//    fun removeStudent(student: Student) {
//        val position = studentList.indexOf(student)
//        if (position != -1) {
//            studentList.toMutableList().removeAt(position)
//            notifyItemRemoved(position)
//        }
//    }
//}
