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
import id.wahyu_ansari.dicoding_project.databinding.ActivityDetailsBinding
import id.wahyu_ansari.dicoding_project.utils.DataLoader
import id.wahyu_ansari.dicoding_project.utils.DataLoader.Companion.toBitmap

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val id = intent.extras!!.getInt("placeId")
        val data = DataLoader(this).getPlace(id)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val detailPic = binding.detailPic
        val start = if (data.build > 0) "${data.build}" else "${data.build}" + " BCE "
        val complete = if (data.complete > 0) "${data.complete}" else "${data.complete}" + " BCE "
        detailPic.setImageBitmap(data.icon.toBitmap())
        binding.detailsCountry.text = getString(R.string.country, data.country)
        binding.detailsStartBuild.text = getString(R.string.build_start, start)
        binding.detailsCompleteBuild.text = getString(R.string.build_complete, complete)
        binding.detailsText.text = data.details
        binding.toolbarDetails.setTitle(data.title)
        binding.toolbarDetails.setSubtitle(data.description)

        val menuHost: MenuHost = binding.toolbarDetails
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.add(Menu.NONE, R.id.about_page, Menu.NONE, getString(R.string.share))
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.about_page -> {
                        val imageUri = DataLoader.saveBitmapAndGetUri(
                            data.icon.toBitmap(), this@DetailsActivity
                        )

                        val sendIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            type = "image/*"
                            putExtra(Intent.EXTRA_STREAM, imageUri)
                            putExtra(Intent.EXTRA_TEXT, data.details)
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        startActivity(shareIntent)

                        true
                    }

                    else -> false
                }
            }
        })
    }
}