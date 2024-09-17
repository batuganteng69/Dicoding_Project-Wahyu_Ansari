package id.wahyu_ansari.dicoding_project

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import id.wahyu_ansari.dicoding_project.databinding.ActivityMainBinding
import id.wahyu_ansari.dicoding_project.recycler_adapter.RecViewAdapter
import id.wahyu_ansari.dicoding_project.utils.DataLoader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rv = binding.recyclerView
        val dataset = DataLoader(this).loadHistoricalPlaces().toMutableList()
        val rvAdapter = RecViewAdapter(dataset)
        rv.adapter = rvAdapter
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rvAdapter.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("placeId", dataset.indexOf(it))
            startActivity(intent)
        }

        val menuHost: MenuHost = binding.toolbar
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.add(Menu.NONE, R.id.about_page, Menu.NONE, getString(R.string.about))
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.about_page -> {
                        Intent(this@MainActivity, AboutActivity::class.java).also {
                            startActivity(it)
                        }

                        true
                    }

                    else -> false
                }
            }
        })
    }

}