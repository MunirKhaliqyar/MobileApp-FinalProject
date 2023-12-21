package com.example.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.data.Datasource
import com.example.finalproject.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize data.
        val myDataset = Datasource().loadAllRooms()

        //val recyclerView = findViewById<RecyclerView>(R.id.nav_host_fragment_content_main)
        //recyclerView.adapter = RoomAdapter(this, myDataset)
        //recyclerView.setHasFixedSize(true)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.email.setOnClickListener { view ->
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:kingoftheworld45678@gmail.com")  // Only email apps should handle this

            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            } else {
                // Handle the case where the device doesn't have an email app installed
                Snackbar.make(view, "No email app installed", Snackbar.LENGTH_LONG).show()
            }
        }

        val fromEditText = binding.fromEditText
        val toEditText = binding.toEditText

        fromEditText.addTextChangedListener(DateInputMask())
        toEditText.addTextChangedListener(DateInputMask())

        // Assuming searchButton is in the MainActivity layout
        binding.searchButton.setOnClickListener {
            if (isDateFormatValid(fromEditText.text.toString()) && isDateFormatValid(toEditText.text.toString())) {
                val activeFragment = supportFragmentManager.primaryNavigationFragment

                if (activeFragment is NavHostFragment) {
                    val childFragment = activeFragment.childFragmentManager.primaryNavigationFragment

                    if (childFragment is HomeFragment) {
                        childFragment.performSearch(navController, fromEditText.text.toString(), toEditText.text.toString())
                    }
                }

            } else {
                Snackbar.make(binding.root, "Input should be a valid date for both 'from' and 'to' dates", Snackbar.LENGTH_LONG).show()
            }
        }

        val fromCalendar = binding.fromCalendar
        val toCalendar = binding.toCalendar

        val currentDate = System.currentTimeMillis() // Get the current date in milliseconds

        fromCalendar.visibility = View.GONE
        fromCalendar.minDate = currentDate

        toCalendar.visibility = View.GONE
        toCalendar.minDate = currentDate

        binding.fromButton.setOnClickListener {
            if (fromCalendar.visibility == View.VISIBLE) {
                fromCalendar.visibility = View.GONE
            } else {
                fromCalendar.visibility = View.VISIBLE
            }
        }
        binding.toButton.setOnClickListener {
            if (toCalendar.visibility == View.VISIBLE) {
                toCalendar.visibility = View.GONE
            } else {
                toCalendar.visibility = View.VISIBLE
            }
        }

        fromCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Handle the date selection
            val selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)

            // Update the EditText with the selected date
            binding.fromEditText.setText(selectedDate)

            // Hide the CalendarView
            fromCalendar.visibility = View.GONE
        }

        toCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Handle the date selection
            val selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)

            // Update the EditText with the selected date
            toEditText.setText(selectedDate)

            // Hide the CalendarView
            toCalendar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                // Open the device settings
                val intent = Intent(Settings.ACTION_SETTINGS)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    // Function to check if the input string is in the format DD/MM/YYYY
    private fun isDateFormatValid(input: String): Boolean {
        val regexPattern = """^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}$""".toRegex()
        return regexPattern.matches(input)
    }
}

class DateInputMask : TextWatcher {

    private var isRunning = false
    private var isDeleting = false

    override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
        // No implementation needed
    }

    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
        // No implementation needed
    }

    override fun afterTextChanged(editable: Editable?) {
        if (isRunning || isDeleting) {
            return
        }

        isRunning = true

        // Remove existing slashes to avoid duplication
        val cleanText = editable?.toString()?.replace("/", "") ?: ""
        val formattedText = formatDateString(cleanText)

        // Set the formatted text back to the EditText
        editable?.replace(0, editable.length, formattedText)

        isRunning = false
    }

    private fun formatDateString(input: String): String {
        val formattedString = StringBuilder()

        for (i in input.indices) {
            if (i == 2 || i == 4) {
                formattedString.append("/")
            }
            formattedString.append(input[i])
        }

        return formattedString.toString()
    }
}
