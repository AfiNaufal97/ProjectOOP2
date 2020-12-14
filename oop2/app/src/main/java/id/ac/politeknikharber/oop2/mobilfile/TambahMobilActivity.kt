package id.ac.politeknikharber.oop2.mobilfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.politeknikharber.oop2.R
import id.ac.politeknikharber.oop2.database.RentalDatabase
import id.ac.politeknikharber.oop2.database.mobil.Mobil
import kotlinx.android.synthetic.main.activity_tambah_mobil.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TambahMobilActivity : AppCompatActivity() {

    val db by lazy {
        RentalDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_mobil)

        masukan()
    }

    private fun masukan(){
        btn_tambah_data.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.mobilDao().insertMobil(
                    Mobil(0, tv_nama_mobil.text.toString(), tv_jenis_mobil.text.toString(), tv_kapasitas_mobil.text.toString().toInt())
                )
                startActivity(Intent(applicationContext, MobilActivity::class.java))
            }
        }
    }
}