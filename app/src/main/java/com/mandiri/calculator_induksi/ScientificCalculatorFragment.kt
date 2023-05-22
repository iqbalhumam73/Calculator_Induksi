package com.mandiri.calculator_induksi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.mandiri.calculator_induksi.databinding.FragmentScientificCalculatorBinding

class ScientificCalculatorFragment : Fragment() {

    private lateinit var binding: FragmentScientificCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScientificCalculatorBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val simpleCalculatorFragment = SimpleCalculatorFragment()
        val fragmentTransaction = parentFragmentManager.beginTransaction()

        binding.apply {
            btnGoToSimple.setOnClickListener(){
                fragmentTransaction.replace(R.id.fragmentContainerView, simpleCalculatorFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScientificCalculatorFragment()
    }
}