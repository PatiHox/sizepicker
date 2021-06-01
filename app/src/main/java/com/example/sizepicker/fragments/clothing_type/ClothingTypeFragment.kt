package com.example.sizepicker.fragments.clothing_type

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sizepicker.R
import com.example.sizepicker.data.entities.ClothingType
import com.example.sizepicker.databinding.FragmentClothingTypeBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ClothingTypeFragment : Fragment() {

    private var _binding: FragmentClothingTypeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClothingTypeBinding.inflate(inflater, container, false)
        return binding.root

    }

    lateinit var clothingType: ClothingType

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.clothingType = requireArguments().getParcelable<ClothingType>("clothingType")!!

        val activity = requireActivity() as AppCompatActivity
        val actionBar = activity.supportActionBar
        val name = clothingType.name
        actionBar!!.title = name

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_ClothingTypeFragment_to_MainFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings_menu_item -> {
                findNavController().navigate(R.id.action_ClothingTypeFragment_to_settingsFragment)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}