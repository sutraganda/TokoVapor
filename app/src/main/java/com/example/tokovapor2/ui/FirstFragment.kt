package com.example.tokovapor2.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tokovapor2.R
import com.example.tokovapor2.aplication.VaporsApp
import com.example.tokovapor2.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val vaporsViewModel: VaporsViewModel by viewModels {
        VaporViewModelFactory((applicationContext as VaporsApp).repository)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = VaporListAdapter { vapor ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(vapor)
            findNavController().navigate(action)
        }
        binding.dataRecyclerView.adapter = adapter
        binding.dataRecyclerView.layoutManager = LinearLayoutManager(context)
        vaporsViewModel.allVapors.observe(viewLifecycleOwner) { vapors ->
            vapors.let {
                if (vapors.isEmpty()) {
                    binding.empetytextView.visibility = View.VISIBLE
                    binding.ilustrasionImageView.visibility = View.VISIBLE
                } else {
                    binding.empetytextView.visibility = View.GONE
                    binding.ilustrasionImageView.visibility = View.GONE
                }
                adapter.submitList(vapors)
            }
        }

        binding.addFAB.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(null)
            findNavController().navigate(action)
        }
        binding.contactFAB.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ContactFragment)
        }
        binding.catalogFAB.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_CatalogFragment)
        }
        binding.aboutFAB.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_AboutFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}