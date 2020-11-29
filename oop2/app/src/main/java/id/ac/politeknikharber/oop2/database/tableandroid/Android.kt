package id.ac.politeknikharber.oop2.database.tableandroid

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

// membuat table
@Entity(tableName = "android")

@Parcelize
data class Android(
    // isi table
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name="id") var id:Int = 0,
    @ColumnInfo(name="versi_android") var versi_android:String = "",
    @ColumnInfo(name="nama") var nama:String = ""
) : Parcelable