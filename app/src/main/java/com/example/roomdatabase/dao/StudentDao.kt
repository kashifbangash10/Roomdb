//package com.example.roomdatabase.dao
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.Update
//import com.example.roomdatabase.model.Student
//
//@Dao
//interface StudentDao {
//
//    @Insert
//    fun insertStudentData(student: Student)
//
//    @Query("SELECT * From student ORDER BY id ASC")
//    fun getAllStudentData(): LiveData<List<Student>>
//
//    @Update
//    fun updateStudentData(student: Student): Int
//
//    @Delete
//    fun deleteStudentData(student: Student)
//    //  fun getAllStudents()
//
//    @Query("SELECT * FROM student WHERE id = :studentid LIMIT 1")
//   fun getStudentById(studentid: Int): Student?
//}
