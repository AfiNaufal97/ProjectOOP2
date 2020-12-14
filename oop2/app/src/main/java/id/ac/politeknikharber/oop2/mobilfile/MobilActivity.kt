package id.ac.politeknikharber.oop2.mobilfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.politeknikharber.oop2.R
import id.ac.politeknikharber.oop2.database.RentalDatabase
import id.ac.politeknikharber.oop2.database.mobil.Mobil
import kotlinx.android.synthetic.main.activity_mobil.*
import kotlinx.android.synthetic.main.activity_mobil.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MobilActivity : AppCompatActivity(), View.OnClickListener {

    // import database
    val dbMobil by lazy {
        RentalDatabase(this)
    }

    private lateinit var adapterMobil:MobilAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobil)
//        dataMobil()
        recylerViewMobil()
        onClickTombol()
    }

    // menampilkan hasil tambah data
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

    // fungsi untuk melakukan tambah data
    private fun onClickTombol(){
        float_add_mobil.setOnClickListener{
            startActivity(Intent(this, TambahMobilActivity::class.java))
        }
    }



//    // data dalam database
//    private fun dataMobil(){
//        CoroutineScope(Dispatchers.IO).launch {
//            dbMobil.mobilDao().insertMobil(
//                Mobil(0, "Pajero", "SUV", 7, "G 1234 GN")
//            )
//        }
//    }

    private fun recylerViewMobil(){
        adapterMobil = MobilAdapter(arrayListOf())
        rv_mobil.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = adapterMobil
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}