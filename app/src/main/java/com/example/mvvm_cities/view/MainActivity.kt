package com.example.mvvm_cities.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.mvvm_cities.databinding.ActivityMainBinding
import com.example.mvvm_cities.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: CityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCityData().observe(this) { city ->
            binding.apply {
                cityImage.setImageDrawable(
                    ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
                )
                cityNameTv.text = city.name
                cityPopulationTv.text = city.population.toString()
            }
        }
    }
}