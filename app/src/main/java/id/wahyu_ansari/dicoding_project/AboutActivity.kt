package id.wahyu_ansari.dicoding_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.wahyu_ansari.dicoding_project.databinding.ActivityAboutBinding
import id.wahyu_ansari.dicoding_project.utils.DataLoader
import id.wahyu_ansari.dicoding_project.utils.DataLoader.Companion.centerCrop
import id.wahyu_ansari.dicoding_project.utils.DataLoader.Companion.toBitmap

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = binding.toolbarAbout
        val profilePic = binding.aboutPic
        profilePic.setImageBitmap(DataLoader(this).load("profilepic.jpg").toBitmap().centerCrop())
        toolbar.setTitle(getString(R.string.about))
    }
}