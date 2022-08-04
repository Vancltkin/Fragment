package com.example.fragment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(BlankFragment1.newInstance(), R.id.place_holder)
        openFrag(BlankFragment2.newInstance(), R.id.place_holder2)

        dataModel.messageForActivity.observe(this) {
            binding.textView.text = it
        }
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f) //.replace(R.id.place_holder,BlankFragment2.newInstance())
            .commit()
    }

}