package com.example.guidedlab

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.guidedlab.R.*

class MainTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main_todo)
        val add = findViewById<Button>(R.id.button)
        val delete = findViewById<Button>(R.id.button2)
        val editText = findViewById<EditText>(R.id.txtAddItem)
        val listView = findViewById<ListView>(R.id.listView)
        var itemlist = arrayListOf<String>()
        var adapter =ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_multiple_choice
            , itemlist)
        // add button
        add.setOnClickListener {
            itemlist.add(editText.text.toString())
            listView.adapter =  adapter
            adapter.notifyDataSetChanged()
            editText.text.clear()
            Toast.makeText(this, "Successfully added objective!", Toast.LENGTH_LONG).show()
        }
        //remove button
        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist[item])
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Successfully removed objective!", Toast.LENGTH_LONG).show()

        }
    }
}
