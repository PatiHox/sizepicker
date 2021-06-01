package com.example.sizepicker.fragments.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sizepicker.R
import com.example.sizepicker.data.entities.ClothingType
import com.example.sizepicker.data.viewmodels.ClothingTypeViewModel
import com.example.sizepicker.databinding.FragmentMainBinding
import com.example.sizepicker.fragments.main.recycler_view.ClothingTypeAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var clothingTypeViewModel: ClothingTypeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // ClothingTypeViewModel
        clothingTypeViewModel = ViewModelProvider(this).get(ClothingTypeViewModel::class.java)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings_menu_item -> {
                findNavController().navigate(R.id.action_MainFragment_to_settingsFragment)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ClothingTypeViewModel
        clothingTypeViewModel.getAll.observe(viewLifecycleOwner) { allClothingTypes ->
            binding.rvClothingTypes.adapter =
                ClothingTypeAdapter(allClothingTypes as MutableList<ClothingType>, findNavController())
            binding.rvClothingTypes.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}