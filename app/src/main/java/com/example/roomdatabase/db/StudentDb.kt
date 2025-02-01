//package com.example.roomdatabase.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.roomdatabase.dao.StudentDao
//import com.example.roomdatabase.model.Student
//import kotlinx.coroutines.InternalCoroutinesApi
//import kotlinx.coroutines.internal.synchronized
//@Database(entities =[Student::class], version = 2 )
//abstract class StudentDb : RoomDatabase() {
//
//    abstract fun studentDao():StudentDao
//    // singleton object hai
//    companion object{
//        //this the name of db
//        private const val DATABASE_NAME= "STUDENT"
//            // first we create the object of db in here hum aik as aik object ko har jaga use kar sakti hai
//            // create once use everywhere
//        private var instance:StudentDb?= null
//        //now we create the function for db creation in my database
//
//        @OptIn(InternalCoroutinesApi::class)
//        fun createDbInstance(context: Context):StudentDb?{
//            if (instance==null)
//                {
//                synchronized(StudentDb::class.java){
//                    if (instance==null) {
//                        instance= Room.databaseBuilder(context,StudentDb::class.java,"Student").build()
//                    }
//                }
//            }
//            return instance
//        }
//
//    }
//
//
//}