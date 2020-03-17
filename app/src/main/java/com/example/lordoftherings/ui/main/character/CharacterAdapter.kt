package com.example.lordoftherings.ui.main.character

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lordoftherings.R
import com.example.lordoftherings.model.CharacterModel
import com.example.lordoftherings.model.Docs
import com.example.lordoftherings.utils.UiManager

class CharacterAdapter(val context: Context) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var characterList : List<Docs> = listOf()


    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvId: TextView = itemView.findViewById(R.id.id_txt)
        val tvHeight: TextView = itemView.findViewById(R.id.height_txt)
        val tvRace: TextView = itemView.findViewById(R.id.race_txt)
        val tvGender: TextView = itemView.findViewById(R.id.gender_txt)
        val tvBirth: TextView = itemView.findViewById(R.id.birth_txt)
        val tvSpouse: TextView = itemView.findViewById(R.id.spouse_txt)
        val tvDeath: TextView = itemView.findViewById(R.id.death_txt)
        val tvRealm: TextView = itemView.findViewById(R.id.realm_txt)
        val tvHair: TextView = itemView.findViewById(R.id.hair_txt)
        val tvName: TextView = itemView.findViewById(R.id.name_txt)
        val tvWikiUrl: TextView = itemView.findViewById(R.id.wiki_url_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chararter,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        holder.tvId.text = "ID : ${characterList.get(position).id}"
        holder.tvHeight.text = "HEIGHT : ${characterList.get(position).height}"
        holder.tvRace.text = "RACE : ${characterList.get(position).race}"
        holder.tvGender.text = "GENDER : ${characterList.get(position).gender}"
        holder.tvBirth.text = "BIRTH : ${characterList.get(position).birth}"
        holder.tvSpouse.text = "SPOUSE : ${characterList.get(position).spouse}"
        holder.tvDeath.text = "DEATH : ${characterList.get(position).death}"
        holder.tvRealm.text = "REALM : ${characterList.get(position).realm}"
        holder.tvHair.text = "HAIR : ${characterList.get(position).hair}"
        holder.tvName.text = "NAME : ${characterList.get(position).name}"
        holder.tvWikiUrl.text = "WIKI : ${characterList.get(position).wikiUrl}"
    }
    fun setCharaterListItems(todoList: List<Docs>){
        this.characterList = todoList
        notifyDataSetChanged()
        UiManager.showShortToast(context, characterList.size.toString())
    }

}