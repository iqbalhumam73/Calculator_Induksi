package com.mandiri.calculator_induksi

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mandiri.calculator_induksi.databinding.FragmentSimpleCalculatorBinding

class SimpleCalculatorFragment : Fragment(), OperationChange {

    private lateinit var binding : FragmentSimpleCalculatorBinding
    private var interactionListener: FragmentInteraction? = null

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

        var currentOperation = ""

        binding.apply {
            btnGoToScientific.setOnClickListener(){
                fragmentTransaction.replace(R.id.fragmentContainerView, scientificCalculatorFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            btnClear.setOnClickListener(){
                interactionListener?.tvOperationChange("")
                interactionListener?.tvResultChange("")
                Log.d("afafafa", "afafaafafag")
            }
            btnDelete.setOnClickListener(){
                currentOperation = deleteLastOperation("${interactionListener?.getTvOperation()}")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
                Log.d("deletee", "delete clicked")
            }

            btn0.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "0")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn1.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "1")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn2.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "2")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn3.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "3")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn4.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "4")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn5.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "5")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn6.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "6")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn7.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "7")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn8.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "8")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btn9.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "9")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btnDot.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", ".")
                interactionListener?.tvOperationChange(currentOperation)
            }
            btnDivide.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "÷")
                interactionListener?.tvOperationChange(currentOperation)
            }
            btnMultiple.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "×")
                interactionListener?.tvOperationChange(currentOperation)
            }
            btnSubstraction.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "-")
                interactionListener?.tvOperationChange(currentOperation)
            }
            btnSum.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "+")
                interactionListener?.tvOperationChange(currentOperation)
            }
            btnCloseBracket.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", ")")
                interactionListener?.tvOperationChange(currentOperation)
                interactionListener?.tvResultChange(getResult(currentOperation))
            }
            btnPercent.setOnClickListener(){
                currentOperation = addToOperation("${interactionListener?.getTvOperation()}", "%")
                interactionListener?.tvOperationChange(currentOperation)
            }
        }
    }

    //kurang paham
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentInteraction) {
            interactionListener = context
        } else {
            throw IllegalArgumentException("Parent activity must implement FragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        interactionListener = null
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SimpleCalculatorFragment()
    }
}