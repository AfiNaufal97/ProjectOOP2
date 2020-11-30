package id.ac.politeknikharber.oop2.database.pelanggan

import androidx.room.*

@Dao
interface PelangganDao {
    @Query("SELECT * FROM pelanggan")
    fun selectAllPel():List<Pelanggan>

    @Query("SELECT * FROM pelanggan WHERE id = :id")
    fun selectPelById(id:Int)

    @Insert
    fun insertPel(data:Pelanggan)

    @Update
    fun updatePel(data:Pelanggan)

    @Delete
    fun deletePel(data:Pelanggan)
}