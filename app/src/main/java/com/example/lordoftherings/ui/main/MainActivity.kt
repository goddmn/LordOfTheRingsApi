package com.example.lordoftherings.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lordoftherings.App
import com.example.lordoftherings.R
import com.example.lordoftherings.model.LotrModel
import com.example.lordoftherings.ui.main.character.CharacterFragment
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start_character.setOnClickListener {
            val fragment = CharacterFragment()
            val fm = supportFragmentManager
            val transaction = fm?.beginTransaction()
            btn_start_character.visibility = View.GONE
            transaction?.replace(R.id.main_container, fragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }
}