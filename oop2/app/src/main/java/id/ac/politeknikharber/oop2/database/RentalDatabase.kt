package id.ac.politeknikharber.oop2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.politeknikharber.oop2.database.mobil.Mobil

@Database(entities = [Mobil::class], version=1, exportSchema = false)

abstract class RentalDatabase:RoomDatabase(){
    companion object{
        @Volatile
        private var INSTANCE : RentalDatabase? = null

        fun getDatabase(context:Context):RentalDatabase{
            return INSTANCE?: synchronized(this){
                // create database
                val instance  = Room.databaseBuilder(
                    context.applicationContext,
                    RentalDatabase::class.java,
                    "rental_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }

    }
}