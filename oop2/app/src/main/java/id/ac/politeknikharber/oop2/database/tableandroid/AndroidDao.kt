package id.ac.politeknikharber.oop2.database.tableandroid

import androidx.room.*

@Dao
// pengolah data
interface AndroidDao {
    @Query("SELECT * FROM android")
    fun selectAll():List<Android>

    @Query("SELECT * FROM android WHERE id = :id")
    fun getById(id:Int):List<Android>

    @Insert
    fun insert(data:Android)

    @Update
    fun update(data:Android)

    @Delete
    fun delete(data:Android)
}