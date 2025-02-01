package com.example.roomdatabase.ui.Fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.appcompat.widget.Toolbar
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.ActivityMain1Binding
import dagger.hilt.android.AndroidEntryPoint

// Use @AndroidEntryPoint instead of @HiltAndroidApp for activities
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain1Binding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize NavController
        navController = findNavController(R.id.fragmentContainerView2)

        // Set up the Toolbar as the ActionBar
        val toolbar: Toolbar = binding.toolbar // Ensure your layout includes a Toolbar with this ID
        setSupportActionBar(toolbar)

        // Link the ActionBar with NavController for navigation support
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // Handle the Up navigation correctly
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
