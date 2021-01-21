package id.ac.politeknikharber.oop2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.politeknikharber.oop2.database.mobil.Mobil
import id.ac.politeknikharber.oop2.database.mobil.MobilDao
import id.ac.politeknikharber.oop2.database.pelanggan.Pelanggan
import id.ac.politeknikharber.oop2.database.pelanggan.PelangganDao

@Database(entities = [Mobil::class, Pelanggan::class], version=1, exportSchema = false)

abstract class RentalDatabase:RoomDatabase(){
    abstract fun mobilDao():MobilDao
    abstract fun pelangganDao():PelangganDao

    companion object{
        @Volatile
        var instance:RentalDatabase? = null
        val LOCK = Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?: buatDatabase(context).also {
                instance = it
            }
        }

        fun buatDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            RentalDatabase::class.java,
            "databaserental_dd"
        ).build()

    }
}