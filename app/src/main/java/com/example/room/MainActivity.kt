package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MhsDatabase(this)

        GlobalScope.launch {
            val data = db.mhsDao().getAll()

            data?.forEach {
                Log.d("DATABASE", it.toString())
            }
        }

        an_btn.setOnClickListener {

            var nama = i_nama.text.toString()
            var alamat = i_alamat.text.toString()

            an_input.setText("nama = $nama \nalamat = $alamat")

            GlobalScope.launch {
                db.mhsDao().insertAll(MhsEntity(0, "$nama", "$alamat"))
                val data = db.mhsDao().getAll()

                data?.forEach {
                    Log.d("DATABASE", it.toString())
                }
            }

        }

    }

    fun inputtBtn(view: View) {

    }
}
