package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

open class MainActivity : AppCompatActivity() {
    lateinit var textview: TextView
    lateinit var button: Button
    lateinit var edittext: EditText
    var userinput: String =""
    var colors = mutableListOf<String>()
    lateinit var adapter : RecyclerViewAdapter
    lateinit var myLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myLayout = findViewById(R.id.clMain)
        textview = findViewById(R.id.textView)
        edittext = findViewById(R.id.editText)
        button = findViewById(R.id.button)


        colors = mutableListOf<String>("red", "black", "blue", "yellow","green","white")
        val myRV = findViewById<RecyclerView>(R.id.rvMain)
        myRV.adapter = RecyclerViewAdapter(colors)
        myRV.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            myRV.adapter = RecyclerViewAdapter(colors)
            myRV.layoutManager = LinearLayoutManager(this)
            onClick() }

    }

    private fun onClick() {
        userinput = edittext.text!!.toString()
        if (userinput==""){Snackbar.make(myLayout,"the entry can't be empty",Snackbar.LENGTH_LONG).show()}
        else{
            colors.add(userinput)
            edittext.setText("")}
    }

}


