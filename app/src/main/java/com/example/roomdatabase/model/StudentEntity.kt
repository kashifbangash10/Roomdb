////package com.example.roomdatabase.model
////
////import android.os.Parcel
////import android.os.Parcelable
////import androidx.room.Entity
////import androidx.room.PrimaryKey
////
//@Entity(tableName = "student")
//data class Student(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,        // Unique identifier, auto-incremented.
//    val name: String,       // Student's name.
//    val course: String,     // Course the student is enrolled in.
//    val mobile: String,     // Student's mobile number.
//    val totalFee: Double   // Total fee for the course (changed to Double for numeric calculations).
//) : Parcelable {
//
//    override fun describeContents(): Int {
//        // Return 0 since there is no special file descriptor for the object
//        return 0
//    }
//
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        // Writing the properties of the class to the Parcel
//        dest.writeInt(id)
//        dest.writeString(name)
//        dest.writeString(course)
//        dest.writeString(mobile)
//        dest.writeDouble(totalFee)
//    }
//
//    // Companion object to recreate the object from a Parcel
//    companion object CREATOR : Parcelable.Creator<Student> {
//        override fun createFromParcel(parcel: Parcel): Student {
//            return Student(
//                id = parcel.readInt(),
//                name = parcel.readString() ?: "",
//                course = parcel.readString() ?: "",
//                mobile = parcel.readString() ?: "",
//                totalFee = parcel.readDouble()
//            )
//        }
//
//        override fun newArray(size: Int): Array<Student?> {
//            return arrayOfNulls(size)
//        }
//    }
//}
