package id.ac.politeknikharber.oop2.filepengguna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.politeknikharber.oop2.R
import id.ac.politeknikharber.oop2.database.RentalDatabase
import id.ac.politeknikharber.oop2.database.pelanggan.Pelanggan
import kotlinx.android.synthetic.main.activity_tambah_palanggan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TambahPalangganActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_palanggan)
    }
}