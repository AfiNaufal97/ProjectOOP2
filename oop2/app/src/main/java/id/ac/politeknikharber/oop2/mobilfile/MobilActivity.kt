package id.ac.politeknikharber.oop2.mobilfile

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import id.ac.politeknikharber.oop2.R
import id.ac.politeknikharber.oop2.database.RentalDatabase
import id.ac.politeknikharber.oop2.database.mobil.Mobil
import kotlinx.android.synthetic.main.activity_mobil.*
import kotlinx.android.synthetic.main.activity_mobil.view.*
import kotlinx.android.synthetic.main.activity_tambah_mobil.*
import kotlinx.android.synthetic.main.item_mobil.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MobilActivity : AppCompatActivity(){

    // import database
    private lateinit var dbMobil:RentalDatabase

    lateinit var databse:FirebaseDatabase
    lateinit var reference:DatabaseReference

    private lateinit var adapterMobil:MobilAdapter
    lateinit var dataMobil:List<Mobil>
    lateinit var destinationList:MutableList<Mobil>
    lateinit var rev :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobil)
        reference = FirebaseDatabase.getInstance().reference
//        reference = databse.getReference("mobil")
        dbMobil = RentalDatabase(this)

        recylerViewMobil()
        tambahData()
        sinkronisasi()
    }

    private fun sinkronisasi(){
        destinationList = ArrayList<Mobil>()
        float_sinkron_mobil.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val dataMobil = dbMobil.mobilDao().selectAllMobil()
                if(dataMobil.isNotEmpty()) {
                    val mobilId = "mobil"
                    val model = dataMobil
                    reference.child(mobilId).setValue(model)
                }else{
                    reference.addValueEventListener(object :ValueEventListener{
                        override fun onDataChange(snapshot: DataSnapshot) {
                            for(i in snapshot.children){
                                val isi = i.getValue(Mobil::class.java)
                                if(isi != null){
                                    destinationList.add(isi)
                                }
                            }

//                            layoutManager = LinearLayoutManager(applicationContext)
//                            adapter = adapterMobil
                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                    })
                }
            }
        }
    }


    // menampilkan hasil tambah data
    override fun onStart() {
        super.onStart()
        loadData()
    }

    // load data
    private fun loadData(){
        CoroutineScope(Dispatchers.IO).launch {
            val dataMobil = dbMobil.mobilDao().selectAllMobil()
            Log.d("data mobil","$dataMobil")
            withContext(Dispatchers.Main){
                adapterMobil.setDataMobil(dataMobil)
            }
        }
    }


    // fungsi untuk melakukan tambah data
    private fun tambahData(){
        float_add_mobil.setOnClickListener{
            tampilkanData(0, ConstPilihan.CREATE_DATA)
        }
    }


    private fun recylerViewMobil(){
        adapterMobil = MobilAdapter(arrayListOf(), object:MobilAdapter.OnClickItem{
            override fun klikItem(mobil: Mobil) {
                tampilkanData(mobil.id, ConstPilihan.READ_DATA)
//                Toast.makeText(applicationContext, "Read", Toast.LENGTH_SHORT).show()
            }

            override fun klikEdit(mobil: Mobil) {
                tampilkanData(mobil.id, ConstPilihan.UPDATE_DATA)
//                Toast.makeText(applicationContext, "Edit", Toast.LENGTH_SHORT).show()
            }

            // fungsi delete
            override fun klikDelete(mobil: Mobil) {
               alertDelete(mobil)
            }
        })
        rv_mobil.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = adapterMobil
        }
    }

    private fun tampilkanData(mobilId:Int, type:Int){
        startActivity(Intent(applicationContext, TambahMobilActivity::class.java)
                .putExtra("id", mobilId)
                .putExtra("type", type)
        )
    }

    private fun alertDelete(mobil:Mobil){
        val alert = AlertDialog.Builder(this)
        alert.apply {
            setTitle("Hapus Data")
            setMessage("Apakah Yakin Akan Menghapus, ${mobil.nama_mobil} ???")
            setNegativeButton("Tidak") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    dbMobil.mobilDao().deleteMobil(mobil)
                    loadData()
                }
            }
        }
        alert.show()
        }
}