package com.example.BerkOdev

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.BerkOdev.databinding.ActivityMainBinding
class Main : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.fragment_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bb.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        binding.hakkNdaButtonone.setOnClickListener { view ->
            val intent = Intent(this,HakActivity::class.java)
            startActivity(intent)
        }
        val listView = findViewById<ListView>(R.id.listView)
        val names = arrayOf("", "Animasyon", "Aksiyon", "Belgesel", "Bilimkurgu", "Biyografi", "Casusluk", "Çizgi roman", "Dini")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, names
        )
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, DaBaActivity::class.java)
            val bundle = Bundle()
            bundle.putString("Text", names[i])
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}