package id.ac.politeknikharber.oop2.database.pelanggan

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
data class Pelanggan(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var nama:String = "",
    var nik:Int = 0,
    var alamat:String="",
    var email:String="",
    var sandi:String="",
    var jenis_kelamin:String=""
)