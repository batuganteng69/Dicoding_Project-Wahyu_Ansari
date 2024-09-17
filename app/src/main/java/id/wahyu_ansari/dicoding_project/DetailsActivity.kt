package id.wahyu_ansari.dicoding_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
    }
}