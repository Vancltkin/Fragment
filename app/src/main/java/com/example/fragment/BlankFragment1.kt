package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragment.databinding.Fragment1Binding

class BlankFragment1 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment1.observe(activity as LifecycleOwner) {
            binding.tvMessageFrag1.text = it
        }
        super.onViewCreated(view, savedInstanceState)
        binding.bSendToFrag2.setOnClickListener {
            dataModel.messageForFragment2.value = "Hello from fragment 1"
        }
        binding.bSendToActiviti.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment 1"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment1()
    }
}