package com.example.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import com.example.anmp_week1.databinding.ActivityMainBinding
import com.example.anmp_week1.databinding.FragmentMainBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    // untuk mengakses layoutnya, tombolnya
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
//            val action = MainFragmentDirections.actionGameFragment()
//            Navigation.findNavController(it).navigate(action)
            val playerName = binding.txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(playerName)
            Navigation.findNavController(it).navigate(action)
        }

        binding.btnOption.setOnClickListener {
            val action = MainFragmentDirections.actionOptionFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
}