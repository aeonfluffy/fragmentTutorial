package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragOneLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val change = findViewById<Button>(R.id.btn_change)
        ShowFragmentOne()
        change.setOnClickListener(
            {
                if(isFragOneLoaded)
                    ShowFragmentTwo()
                else
                    ShowFragmentOne()
            })
    }

    fun ShowFragmentOne()
    {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragOneLoaded = true
    }

    fun ShowFragmentTwo()
    {
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragOneLoaded = false
    }
}
