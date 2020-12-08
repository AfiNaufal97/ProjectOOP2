class AdapterPengguna(private val dataPengguna:ArrayList<Pelanggan>):RecyclerView.Adapter<AdapterPengguna.MyListPengguna>(){
    class MyListPengguna(itemview: View) :RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterUser.MyListUser {
       return MyListPengguna(LayoutInflater.from(parent.context).inflate(R.layout.item_pengguna,parent, false))
    }

    override fun onBindViewHolder(holder: AdapterPengguna.MyListPengguna, position: Int) {
        val isiPengguna = dataPengguna[position]
        holder.itemView.tv_item_pengguna.text = isiPengguna.nama
    }

    override fun getItemCount() = dataPengguna.size

    fun setDataUser(listPengguna:List<Pelanggan>){
        dataPengguna.clear()
        dataPengguna.addAll(listUser)
        notifyDataSetChanged()
    }

}