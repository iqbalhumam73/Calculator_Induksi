package com.mandiri.calculator_induksi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mandiri.calculator_induksi.databinding.FragmentSimpleCalculatorBinding

class SimpleCalculatorFragment : Fragment() {

    private lateinit var binding : FragmentSimpleCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSimpleCalculatorBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scientificCalculatorFragment = ScientificCalculatorFragment()
        val fragmentTransaction = parentFragmentManager.beginTransaction()

        binding.apply {
            btnGoToScientific.setOnClickListener(){
                fragmentTransaction.replace(R.id.fragmentContainerView, scientificCalculatorFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SimpleCalculatorFragment()
    }
}