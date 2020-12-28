package id.ac.politeknikharber.oop2.database.pelanggan

import androidx.room.*

@Dao
interface PelangganDao {
    @Query("SELECT * FROM pelanggan")
    suspend fun selectAllPelanggan():List<Pelanggan>

    @Insert
    suspend fun insertPelanggan(user:Pelanggan)

    @Update
    suspend fun updatePelanggan(user:Pelanggan)

    @Delete
    suspend fun deletePelanggan(user:Pelanggan)
}
