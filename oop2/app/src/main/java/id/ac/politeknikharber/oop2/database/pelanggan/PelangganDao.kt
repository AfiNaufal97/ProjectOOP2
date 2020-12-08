package id.ac.politeknikharber.oop2.database.pelanggan

import androidx.room.*

@Dao
interface PelangganDao {
    @Query("SELECT * FROM user")
    suspend fun selectAllPelanggan():List<User>

    @Insert
    suspend fun insertPelanggan(user:User)

    @Update
    suspend fun updatePelanggan(user:User)

    @Delete
    suspend fun deletePelanggan(user:User)
}
