package com.example.lordoftherings.ui.main.character

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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class CharacterDetailsFragment : Fragment() {

    var retrofit: ApiService? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_details, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        retrofit = App().getAppInstance(context!!).getRetrofitService()
        val call = retrofit?.getCharacterDetail("5cd99d4bde30eff6ebccfdf3")
        call?.enqueue(object : Callback<CharacterModel>{
            override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                UiManager.showShortToast(context!!, "onFailure")
            }

            override fun onResponse(call: Call<CharacterModel>, response: Response<CharacterModel>) {
                UiManager.showShortToast(context!!, "onFailure")
            }
        })
    }

}
