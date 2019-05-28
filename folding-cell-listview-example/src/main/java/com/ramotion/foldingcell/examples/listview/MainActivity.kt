package com.ramotion.foldingcell.examples.listview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

import com.ramotion.foldingcell.FoldingCell
import com.ramotion.foldingcell.examples.R

import java.util.ArrayList

import androidx.appcompat.app.AppCompatActivity

/**
 * Example of using Folding Cell with ListView and ListAdapter
 */
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // get our list view
    val theListView = findViewById<ListView>(R.id.mainListView)

    // prepare elements to display
    val items = Item.testingList

    // add custom btn handler to first list item
    items[0].requestBtnClickListener = View.OnClickListener { Toast.makeText(applicationContext, "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show() }

    // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
    val adapter = FoldingCellListAdapter(this, items)

    // add default btn handler for each request btn on each item if custom handler not found
    adapter.defaultRequestBtnClickListener = View.OnClickListener { Toast.makeText(applicationContext, "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show() }

    // set elements to adapter
    theListView.adapter = adapter

    // set on click event listener to list view
    theListView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, pos, l ->
      // toggle clicked cell state
      (view as FoldingCell).toggle(false)
      // register in adapter that state for selected cell is toggled
      adapter.registerToggle(pos)
    }

  }
}
