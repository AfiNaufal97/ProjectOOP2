package id.ac.politeknikharber.oop2.database.mobil

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "mobil")

@Parcelize
data class Mobil (
    @PrimaryKey (autoGenerate = true) @ColumnInfo(name="id") var id:Int=0,
    @ColumnInfo(name="no_kendaraan") var no_kendaraan:String="",
    @ColumnInfo(name = "jenis_mobil") var jenis_mobil:String="",
    @ColumnInfo(name = "nama") var nama:String="",
    @ColumnInfo(name="tarif") var tarif:String=""
) : Parcelable