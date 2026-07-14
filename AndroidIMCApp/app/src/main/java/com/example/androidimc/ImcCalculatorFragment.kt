package com.example.androidimc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androidimc.databinding.FragmentImcCalculatorBinding

/**
 * Fragmento que actua como formulario para calcular tu IMC
 */
class ImcCalculatorFragment : Fragment() {
    // Instancia del binding
    private var _binding: FragmentImcCalculatorBinding? = null
    val binding: FragmentImcCalculatorBinding
        get() = _binding!!

    /**
     * Crea la vista del fragmento
     *
     * @param inflater El inflador de la vista
     * @param container El contenedor de la vista
     * @param savedInstanceState El estado de la instancia
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentImcCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root

        // Reduce la edad en 1 al clickar en el boton
        binding.menosEdad.setOnClickListener {
            binding.edadValor.text =
                (
                    binding.edadValor.text
                        .toString()
                        .toInt() - 1
                ).toString()
        }

        // Aumenta la edad en 1 al clickar en el boton
        binding.masEdad.setOnClickListener {
            binding.edadValor.text =
                (
                    binding.edadValor.text
                        .toString()
                        .toInt() + 1
                ).toString()
        }

        // Reduce el peso en 1 al clickar en el boton
        binding.menosPeso.setOnClickListener {
            binding.pesoValor.text =
                (
                    binding.pesoValor.text
                        .toString()
                        .toInt() - 1
                ).toString()
        }

        // Aumenta el peso en 1 al clickar en el boton
        binding.masPeso.setOnClickListener {
            binding.pesoValor.text =
                (
                    binding.pesoValor.text
                        .toString()
                        .toInt() + 1
                ).toString()
        }

        // Cambia el valor de la altura al cambiar el valor del slider
        binding.sliderAltura.addOnChangeListener { _, value, _ ->
            binding.altura.text = "${value.toInt()} cm"
        }

        // Navega a la pantalla de resultados
        binding.moverseResultado.setOnClickListener {
            view.findNavController().navigate(
                ImcCalculatorFragmentDirections.actionImcCalculatorFragmentToResultIMCFragment(
                    binding.altura.text
                        .toString()
                        .split(" ")[0]
                        .toInt(),
                    binding.pesoValor.text
                        .toString()
                        .toInt(),
                    binding.edadValor.text
                        .toString()
                        .toInt(),
                ),
            )
        }

        // Seleccion genero
        // Hombre
        binding.hombreSelecionado.setOnClickListener {
            binding.hombreSelecionado.setBackgroundTintList(resources.getColorStateList(R.color.selecionado))
            binding.mujerSelecionada.setBackgroundTintList(resources.getColorStateList(R.color.fondo_recuadros))
        }

        // Mujer
        binding.mujerSelecionada.setOnClickListener {
            binding.hombreSelecionado.setBackgroundTintList(resources.getColorStateList(R.color.fondo_recuadros))
            binding.mujerSelecionada.setBackgroundTintList(resources.getColorStateList(R.color.selecionado))
        }

        return view
    }

    /**
     * Destruye la vista del fragmento
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
