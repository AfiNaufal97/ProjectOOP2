package id.ac.politeknikharber.oop2.mobilfile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import id.ac.politeknikharber.oop2.R
import id.ac.politeknikharber.oop2.database.mobil.Mobil
import kotlinx.android.synthetic.main.item_mobil.view.*

class MobilAdapter(private val dataMobil:ArrayList<Mobil>, val onclickItem:OnClickItem) :RecyclerView.Adapter<MobilAdapter.MylistMobil>(){


    interface OnClickItem{
        fun klikItem(mobil:Mobil)
        fun klikEdit(mobil:Mobil)
        fun klikDelete(mobil:Mobil)
    }

//    fun setKlikItem(onClickItem: OnClickItem){
//        this.onClickItem = onClickItem
//    }

    class MylistMobil(itemview: View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobilAdapter.MylistMobil {
        return MylistMobil(LayoutInflater.from(parent.context).inflate(R.layout.item_mobil, parent, false))
    }

    override fun onBindViewHolder(holder: MobilAdapter.MylistMobil, position: Int) {
        val isiDataMobil = dataMobil[position]
        holder.itemView.tv_item_mobil.text = isiDataMobil.nama_mobil
        holder.itemView.tv_item_mobil.setOnClickListener {
            onclickItem.klikItem(isiDataMobil)
        }

        holder.itemView.btn_edit_mobil.setOnClickListener {
            onclickItem.klikEdit(isiDataMobil)
        }

        holder.itemView.btn_hps_mobil.setOnClickListener {
            onclickItem.klikDelete(isiDataMobil)
        }
    }

    override fun getItemCount() = dataMobil.size

    fun setDataMobil(listMobil:List<Mobil>){
        dataMobil.clear()
        dataMobil.addAll(listMobil)
        notifyDataSetChanged()
    }

}