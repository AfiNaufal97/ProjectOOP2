package id.ac.politeknikharber.oop2.database.mobil

import androidx.room.*

@Dao
interface MobilDao{
    @Query("SELECT * FROM mobil")
    fun selectAll():List<Mobil>

    @Query("SELECT * FROM mobil WHERE id=:id")
    fun selectAll(id:Int):List<Mobil>

    @Insert
    fun insert(data:Mobil)

    @Delete
    fun delete(data:Mobil)

    @Update
    fun update(data:Mobil)

}