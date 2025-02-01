package com.example.roomdatabase.MvvM

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,  // Default value for Room's auto-increment
    var title: String,
    var subtitle: String,
    var content: String
) : Parcelable {

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id!!)
        dest.writeString(title)
        dest.writeString(subtitle)
        dest.writeString(content)
    }

    companion object CREATOR : Parcelable.Creator<Notes> {
        override fun createFromParcel(parcel: Parcel): Notes {
            return Notes(
                id = parcel.readInt(),
                title = parcel.readString().orEmpty(),
                subtitle = parcel.readString().orEmpty(),
                content = parcel.readString().orEmpty()
            )
        }

        override fun newArray(size: Int): Array<Notes?> = arrayOfNulls(size)
    }
}
