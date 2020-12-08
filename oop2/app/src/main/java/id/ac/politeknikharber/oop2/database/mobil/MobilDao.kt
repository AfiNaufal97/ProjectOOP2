package id.ac.politeknikharber.oop2.database.mobil

import androidx.room.*

@Dao
interface MobilDao {
    @Query("SELECT * FROM mobil")
    suspend fun selectAllMobil():List<Mobil>

    @Query("SELECT * FROM mobil WHERE id=:id")
    suspend fun selectMobilById(id:Int):List<Mobil>

    @Query("SELECT * FROM mobil WHERE jenis_mobil=:jenis")
    suspend fun selectMObilByJenis(jenis:String):List<Mobil>

    @Query("SELECT * FROM mobil WHERE kapasitas=:kapasitas")
    suspend fun selectMobilByKapasitas(kapasitas:Int):List<Mobil>

    @Insert
    suspend fun insertMobil(mobil:Mobil)

    @Update
    suspend fun updateMobil(mobil:Mobil)

    @Delete
    suspend fun deleteMobil(mobil:Mobil)
}