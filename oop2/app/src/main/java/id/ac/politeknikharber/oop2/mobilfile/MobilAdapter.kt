package id.ac.politeknikharber.oop2.mobilfile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.politeknikharber.oop2.R
import id.ac.politeknikharber.oop2.database.mobil.Mobil
import kotlinx.android.synthetic.main.item_mobil.view.*

class MobilAdapter(private val dataMobil:ArrayList<Mobil>) :RecyclerView.Adapter<MobilAdapter.MylistMobil>(){
    class MylistMobil(itemview: View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobilAdapter.MylistMobil {
        return MylistMobil(LayoutInflater.from(parent.context).inflate(R.layout.item_mobil, parent, false))
    }

    override fun onBindViewHolder(holder: MobilAdapter.MylistMobil, position: Int) {
        val isiDataMobil = dataMobil[position]
        holder.itemView.tv_item_mobil.text = isiDataMobil.nama_mobil
    }

    override fun getItemCount() = dataMobil.size

    fun setDataMobil(listMobil:List<Mobil>){
        dataMobil.clear()
        dataMobil.addAll(listMobil)
        notifyDataSetChanged()
    }

}