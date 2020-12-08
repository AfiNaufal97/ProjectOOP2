package id.ac.politeknikharber.oop2.database.mobil

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
data class Mobil(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var nama_mobil:String="",
    var jenis_mobil:String="",
    var kapasitas:Int=0,
    var no_polisi:String=""
)