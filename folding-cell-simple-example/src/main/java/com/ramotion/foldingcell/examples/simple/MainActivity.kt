package com.ramotion.foldingcell.examples.simple

import android.os.Bundle
import android.view.View
import android.widget.Button

import com.ramotion.foldingcell.FoldingCell

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // get our folding cell
    val fc = findViewById<View>(R.id.folding_cell) as FoldingCell

    // attach click listener to fold btn
    val toggleBtn = findViewById<View>(R.id.toggle_btn) as Button
    toggleBtn.setOnClickListener { fc.toggle(false) }

    // attach click listener to toast btn
    val toggleInstantlyBtn = findViewById<View>(R.id.toggle_instant_btn) as Button
    toggleInstantlyBtn.setOnClickListener { fc.toggle(true) }

  }
}
