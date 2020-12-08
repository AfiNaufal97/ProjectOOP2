package id.ac.politeknikharber.oop2.mobilfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.politeknikharber.oop2.R
import id.ac.politeknikharber.oop2.database.RentalDatabase
import id.ac.politeknikharber.oop2.database.mobil.Mobil
import kotlinx.android.synthetic.main.activity_mobil.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MobilActivity : AppCompatActivity() {

    // import database
    val dbMobil by lazy {
        RentalDatabase(this)
    }

    private lateinit var adapterMobil:MobilAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobil)
        dataMobil()
        recylerViewMobil()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val dataMobil = dbMobil.mobilDao().selectAllMobil()
            Log.d("data mobil","$dataMobil")
            withContext(Dispatchers.Main){
                adapterMobil.setDataMobil(dataMobil)
            }
        }
    }

    private fun dataMobil(){
        CoroutineScope(Dispatchers.IO).launch {
            dbMobil.mobilDao().insertMobil(
                Mobil(0, "Pajero", "SUV", 7, "G 1234 GN")
            )
        }
    }

    private fun recylerViewMobil(){
        adapterMobil = MobilAdapter(arrayListOf())
        rv_mobil.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = adapterMobil
        }
    }

}