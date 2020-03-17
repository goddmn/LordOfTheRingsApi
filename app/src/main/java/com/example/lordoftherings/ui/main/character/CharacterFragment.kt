package com.example.lordoftherings.ui.main.character

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lordoftherings.App
import com.example.lordoftherings.R
import com.example.lordoftherings.model.CharacterModel
import com.example.lordoftherings.network.ApiService
import com.example.lordoftherings.ui.main.MainActivity
import com.example.lordoftherings.utils.UiManager
import kotlinx.android.synthetic.main.fragment_character.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class CharacterFragment : Fragment() {
    var retrofit: ApiService? = null

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character, container, false)
        recyclerView = view.findViewById(R.id.characters_recycler)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_character_back.setOnClickListener {
            val intent = Intent(getActivity(), MainActivity::class.java)
            getActivity()?.startActivity(intent)
        }
        recyclerAdapter = CharacterAdapter(context!!)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.adapter = recyclerAdapter


        retrofit = App().getAppInstance(context!!).getRetrofitService()
        btn_show_charaters.setOnClickListener {
            val call = retrofit?.getCharacters()
            call?.enqueue(object : Callback<CharacterModel> {
                override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                    UiManager.showShortToast(context!!, "onFailure")
                }

                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    val listOfDocs = response.body()!!.docs
                    recyclerAdapter.setCharaterListItems(listOfDocs)
                    UiManager.showShortToast(context!!, "onResponse")
                    btn_show_charaters.visibility = View.GONE
                }

            })
        }
    }
}

