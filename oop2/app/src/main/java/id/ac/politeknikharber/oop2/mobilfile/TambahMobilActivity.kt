package id.ac.politeknikharber.oop2.mobilfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.ac.politeknikharber.oop2.R
import id.ac.politeknikharber.oop2.database.RentalDatabase
import id.ac.politeknikharber.oop2.database.mobil.Mobil
import kotlinx.android.synthetic.main.activity_tambah_mobil.*
import kotlinx.android.synthetic.main.item_mobil.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TambahMobilActivity : AppCompatActivity() {

    val db by lazy {
        RentalDatabase(this)
    }

    var mobil:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_mobil)
        pilihanMenu()
    }

    private fun masukan(){
        btn_tambah_data.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.mobilDao().insertMobil(
                    Mobil(0, tv_nama_mobil.text.toString(), tv_jenis_mobil.text.toString(), tv_kapasitas_mobil.text.toString().toInt(), tv_nopol.text.toString())
                )
                startActivity(Intent(applicationContext, MobilActivity::class.java))
            }
        }
    }


    private fun pilihanMenu(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mobil = intent.getIntExtra("id", 0)
        val type = intent.getIntExtra("type", 0)

        when(type){
            ConstPilihan.CREATE_DATA -> {
                masukan()
                btn_update_data.visibility = View.GONE
            }
            ConstPilihan.READ_DATA -> {
                btn_tambah_data.visibility = View.GONE
                btn_update_data.visibility = View.GONE
                readData()
            }
            ConstPilihan.UPDATE_DATA ->{
                btn_tambah_data.visibility = View.GONE
                readData()
                editData()
            }

        }
    }

    private fun readData(){
        CoroutineScope(Dispatchers.IO).launch {
            val isi = db.mobilDao().selectMobilById(mobil)[0]
            tv_nama_mobil.setText(isi.nama_mobil)
            tv_jenis_mobil.setText(isi.jenis_mobil)
            tv_kapasitas_mobil.setText(isi.kapasitas.toString())
            tv_nopol.setText(isi.no_polisi)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun editData(){
       btn_update_data.setOnClickListener {
           CoroutineScope(Dispatchers.IO).launch {
               db.mobilDao().updateMobil(
                       Mobil(mobil, tv_nama_mobil.text.toString(), tv_jenis_mobil.text.toString(), tv_kapasitas_mobil.text.toString().toInt(), tv_nopol.text.toString())
               )
               finish()
           }
       }
    }


}