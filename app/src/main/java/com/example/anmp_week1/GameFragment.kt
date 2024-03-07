package com.example.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.anmp_week1.databinding.FragmentGameBinding
import com.example.anmp_week1.databinding.FragmentMainBinding
import kotlin.random.Random


class GameFragment : Fragment() {
    private lateinit var binding:FragmentGameBinding

    private var number1: Int = 0
    private var number2: Int = 0
    private var score: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        number1 = Random.nextInt(1, 100)
        number2 = Random.nextInt(1, 100)
        binding.txtNum1.text = number1.toString()
        binding.txtNum2.text = number2.toString()

        binding.btnAnswer.setOnClickListener {
            var jawaban = binding.txtJawaban.text.toString()
            var correctAnswer = (number1 + number2).toString()
            if (jawaban == correctAnswer) {
                score += 1
                number1 = Random.nextInt(1, 100)
                number2 = Random.nextInt(1, 100)
                binding.txtNum1.text = number1.toString()
                binding.txtNum2.text = number2.toString()
                binding.txtJawaban.text?.clear()

            }
            else {
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }

        }


        if (arguments != null) {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.textView2.text = "$playerName's Turn"
        }
    }



}