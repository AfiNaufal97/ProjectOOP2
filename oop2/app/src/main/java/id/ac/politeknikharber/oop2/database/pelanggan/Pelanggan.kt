package id.ac.politeknikharber.oop2.database.pelanggan

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "pelanggan")
@Parcelize
data class Pelanggan(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") var id:Int=0,
    @ColumnInfo(name="nik") var nik:Int=0,
    @ColumnInfo(name="nama") var nama:String="",
    @ColumnInfo(name="alamat") var alamat:String="",
    @ColumnInfo(name="gender") var gender:String="",
    @ColumnInfo(name="pekerjaan") var pekerjaan:String=""
) : Parcelable