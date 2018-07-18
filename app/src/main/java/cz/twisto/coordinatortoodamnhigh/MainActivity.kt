package cz.twisto.coordinatortoodamnhigh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ItemAdapter()
    }
}

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.CharacterHolder>() {

    var characters = listOf("Dave Lister","Arnold Judas Rimmer","Cat","Kryten","Holly","Kristine Kochanski")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.CharacterHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CharacterHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ItemAdapter.CharacterHolder, position: Int) {
        holder.bind(characters[position])
    }


    class CharacterHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(nameString: String) = with(itemView){
            name.text = nameString
        }
    }

}