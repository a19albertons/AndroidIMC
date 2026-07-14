package com.example.androidimc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidimc.databinding.FragmentResultIMCBinding

/**
 * Fragmento que muestra el resultado del IMC
 */
class ResultIMCFragment : Fragment() {
    // Instancia del binding
    private var _binding: FragmentResultIMCBinding? = null
    val binding: FragmentResultIMCBinding
        get() = _binding!!

    // Crea la vista del fragmento
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentResultIMCBinding.inflate(inflater, container, false)

        // Recuperamos todo lo enviado
        val view = binding.root
        val altura = ResultIMCFragmentArgs.fromBundle(requireArguments()).altura
        val peso = ResultIMCFragmentArgs.fromBundle(requireArguments()).peso
        val edad = ResultIMCFragmentArgs.fromBundle(requireArguments()).edad

        // Calculos a partir de los datos previos
        val alturaMetros = altura.toDouble() / 100
        val imc = peso.toDouble() / (alturaMetros * alturaMetros)
        binding.valorIMC.text = "%.2f".format(imc)

        // Devuelve una información a partir de los datos del IMC
        when {
            imc < 18.5 -> {
                binding.situacionIMC.text = getString(R.string.underweight)
                binding.descripcionIMC.text = getString(R.string.underweight_desc)
            }
            imc in 18.5..24.9 -> {
                binding.situacionIMC.text = getString(R.string.normal_weight)
                binding.descripcionIMC.text = getString(R.string.normal_weight_desc)
            }
            imc in 25.0..29.9 -> {
                binding.situacionIMC.text = getString(R.string.overweight)
                binding.descripcionIMC.text = getString(R.string.overweight_desc)
            }
            else -> {
                binding.situacionIMC.text = getString(R.string.obesity)
                binding.descripcionIMC.text = getString(R.string.obesity_desc)
            }
        }

        return view
    }

    /**
     * Destruye la vista del fragmento
     */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
