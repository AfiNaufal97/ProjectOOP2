class PenggunaActivity : AppCompatActivity() {

    val dbPengguna by lazy {
        RentalDatabase(this)
    }

    private lateinit var adapterPengguna:AdapterPengguna

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengguna)

        dataPengguna()
        onklikPengguna()
        recyclerViewPengguna()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val dataPengguana = dbPengguna.penggunaDao().selectAllPengguna()
            Log.d("pengguna activity", "$dataPengguna")
            withContext(Dispatchers.Main){
                adapterUser.setDataUser(dataPengguana)
            }
        }
    }

    private fun dataPengguana(){
        CoroutineScope(Dispatchers.IO).launch {
            dbPengguna.pengguanaDao().insertPengguna(
                User(0, "Budi", 123456789, "Kab.Tegal", "budi@mail.com", "123456789", "pria")
            )
        }
    }

    private fun onklikPengguna(){
        //
    }

    private fun recyclerViewPengguna(){
        adapterPengguana = AdapterPengguna(arrayListOf())

        rv_user.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = adapterPengguna
        }
    }



}