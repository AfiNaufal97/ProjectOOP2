package id.ac.politeknikharber.oop2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.politeknikharber.oop2.database.tableandroid.Android

@Database(entities = [Android::class], version = 1, exportSchema = false)

abstract class OsDatabase :RoomDatabase(){
    companion object{
        @Volatile
        private var INSTACE:OsDatabase? = null

        fun getDatabase(context:Context):OsDatabase{
            return INSTACE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OsDatabase::class.java,
                    "os_database_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTACE = instance
                instance
            }
        }
    }

    abstract fun getAndroidDao(): Android
}