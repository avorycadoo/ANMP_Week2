package com.example.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.anmp_week1.databinding.FragmentResultBinding

class resultFragment : Fragment() {
    lateinit var binding : FragmentResultBinding
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val score = resultFragmentArgs.fromBundle(requireArguments()).score
            binding.txtScore.text = "Your score is " + score
        }

        binding.btnBack.setOnClickListener(){
            val action = resultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}