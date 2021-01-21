package id.ac.politeknikharber.oop2.database.pelanggan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.politeknikharber.oop2.R
import kotlinx.android.synthetic.main.item_pengguna.view.*

class AdapterPelanggan(val data:ArrayList<Pelanggan>) : RecyclerView.Adapter<AdapterPelanggan.DaftarPelanggan>(){
    class DaftarPelanggan(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaftarPelanggan {
       return DaftarPelanggan(LayoutInflater.from(parent.context).inflate(R.layout.item_pengguna, parent, false))
    }

    override fun onBindViewHolder(holder: DaftarPelanggan, position: Int) {
        val isiData = data[position]
        holder.itemView.tv_nama_pengguna.text = isiData.nama
    }

    override fun getItemCount() = data.size

}