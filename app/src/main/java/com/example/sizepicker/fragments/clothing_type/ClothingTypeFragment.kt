package com.example.sizepicker.fragments.clothing_type

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sizepicker.R
import com.example.sizepicker.data.data_holders.SizeByStandardDataHolder
import com.example.sizepicker.data.data_holders.SizeDataHolder
import com.example.sizepicker.data.entities.*
import com.example.sizepicker.databinding.EditFieldItemBinding
import com.example.sizepicker.databinding.FragmentClothingTypeBinding
import com.example.sizepicker.fragments.clothing_type.recycler_view.TableAdapter
import com.example.sizepicker.utils.DataUtils


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

    lateinit var clothingTypeWithBodyParts: ClothingTypeWithBodyParts
    lateinit var clothingTypeWithStandards: ClothingTypeWithStandards

    val clothingTypesToBodyParts = mutableListOf(
        ClothingTypeToBodyPart(0, 0),
        ClothingTypeToBodyPart(0, 1)
    )

    val bodyParts = mutableListOf(
        BodyPart(0, "Зріст"),
        BodyPart(1, "Обхват грудей, см")
    )

    val standards = mutableListOf(
        Standard(0, "Український розмір"),
        Standard(1, "Європейський розмір"),
        Standard(2, "Розмір США"),
        Standard(3, "Літерний розмір")
    )

    val sizesByStandards = mutableListOf(
        SizeByStandard(0, "48", 0, 0),
        SizeByStandard(1, "50", 0, 0),
        SizeByStandard(2, "52", 0, 0),

        SizeByStandard(3, "48", 1, 0),
        SizeByStandard(4, "50", 1, 0),
        SizeByStandard(5, "52", 1, 0),

        SizeByStandard(6, "38", 2, 0),
        SizeByStandard(7, "40", 2, 0),
        SizeByStandard(8, "42", 2, 0),

        SizeByStandard(9, "S", 3, 0),
        SizeByStandard(10, "M", 3, 0),
        SizeByStandard(11, "L", 3, 0),
    )

    val sizesToSizesByStandards = mutableListOf(
        SizeToSizeByStandard(0, 0),
        SizeToSizeByStandard(0, 3),
        SizeToSizeByStandard(0, 6),
        SizeToSizeByStandard(0, 9),

        SizeToSizeByStandard(1, 1),
        SizeToSizeByStandard(1, 4),
        SizeToSizeByStandard(1, 7),
        SizeToSizeByStandard(1, 10),

        SizeToSizeByStandard(2, 2),
        SizeToSizeByStandard(2, 5),
        SizeToSizeByStandard(2, 8),
        SizeToSizeByStandard(2, 11),

        SizeToSizeByStandard(3, 0),
        SizeToSizeByStandard(3, 3),
        SizeToSizeByStandard(3, 6),
        SizeToSizeByStandard(3, 9),

        SizeToSizeByStandard(4, 1),
        SizeToSizeByStandard(4, 4),
        SizeToSizeByStandard(4, 7),
        SizeToSizeByStandard(4, 10),

        SizeToSizeByStandard(5, 2),
        SizeToSizeByStandard(5, 5),
        SizeToSizeByStandard(5, 8),
        SizeToSizeByStandard(5, 11),
    )

    val sizes = mutableListOf(
        // Обхват грудей
        Size(0, 0, 94f, 98f),
        Size(1, 0, 98f, 102f),
        Size(2, 0, 102f, 106f),

        // Зріст
        Size(3, 1, 176f, 179f),
        Size(4, 1, 179f, 182f),
        Size(5, 1, 182f, 184f)
    )

    private var manager: RecyclerView.LayoutManager? = null
    private var adapter: TableAdapter? = null
    val list = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // this ClothingType
        this.clothingType = requireArguments().getParcelable<ClothingType>("clothingType")!!

        // Fragment title
        val activity = requireActivity() as AppCompatActivity
        val actionBar = activity.supportActionBar
        val name = clothingType.name
        actionBar!!.title = name

        // BodyParts for this ClothingType
        val bodyPartPerClothingType = mutableListOf<BodyPart>()
        for (bodyPart in bodyParts) {
            val bodyPartId = bodyPart.id
            val clothingTypeId = clothingType.id
            for (clothingTypeToBodyPart in clothingTypesToBodyParts) {
                if (clothingTypeToBodyPart.bodyPartId == bodyPartId && clothingTypeToBodyPart.clothingTypeId == clothingTypeId)
                    bodyPartPerClothingType.add(bodyPart)
            }
        }
        this.clothingTypeWithBodyParts =
            ClothingTypeWithBodyParts(clothingType, bodyPartPerClothingType)

        // Standards for this ClothingType
        val standardPerClothingType = mutableListOf<Standard>()
        for (standard in standards) {
            val standardId = standard.id
            val clothingTypeId = clothingType.id
            for (sizeByStandard in sizesByStandards) {
                if (sizeByStandard.clothingTypeId == clothingTypeId && sizeByStandard.standardId == standardId) {
                    standardPerClothingType.add(standard)
                }
            }
        }
        this.clothingTypeWithStandards =
            ClothingTypeWithStandards(clothingType, standardPerClothingType)

        // SizesByStandards for this ClothingType
        val sizeByStandardsPerClothingType = mutableListOf<SizeByStandard>()
        for (sizeByStandard in sizesByStandards) {
            val clothingTypeId = clothingType.id
            if (sizeByStandard.clothingTypeId == clothingTypeId) {

            }
        }

        // Ультимативная переменная, которая содержит все размеры частей тела
        val sizeDataHolders = mutableListOf<SizeDataHolder>()
        for (bodyPart in bodyPartPerClothingType) {
            for (size in sizes) {
                if (size.bodyPartId == bodyPart.id) {
                    val sizeDataHolder =
                        SizeDataHolder(size.id!!, bodyPart, size.minSizeCm, size.maxSizeCm)
                    sizeDataHolders.add(sizeDataHolder)
                }
            }
        }


        // Ультимативная переменная, которая содержит ВСЕ данные
        val sizeByStandardDataHolders = mutableListOf<SizeByStandardDataHolder>()
        for (sizeByStandard in sizesByStandards) {
            var standard: Standard? = null
            for (std in standards) {
                if (std.id == sizeByStandard.standardId)
                    standard = std
            }
            standard!!
            val size = sizeByStandard.size
            val sizes = mutableListOf<SizeDataHolder>()
            for (sizeDataHolder in sizeDataHolders) {
                for (sizeToSizeByStandard in sizesToSizesByStandards) {
                    if (sizeToSizeByStandard.sizeId == sizeDataHolder.sizeId && sizeToSizeByStandard.sizeByStandardId == sizeByStandard.id)
                        sizes.add(sizeDataHolder)
                }
            }

            val sizeByStandardDataHolder =
                SizeByStandardDataHolder(clothingType, standard, size, sizes)
            sizeByStandardDataHolders.add(sizeByStandardDataHolder)
        }

        /*for (groupedSizeByStandardDataHolder in groupedSizeByStandardDataHolders) {
            for (size in groupedSizeByStandardDataHolder[0].sizes)
                list.add("${size.minSizeCm} - ${size.maxSizeCm}")


            for (sizeByStandardDataHolder in groupedSizeByStandardDataHolder) {
                list.add(sizeByStandardDataHolder.size)
            }

            val tableRow = TableRow(context)
            for (row in list) {
                tableRow.addView(
                    TextView(context).also {
                        it.text = row
                    }
                )
            }
        }*/

        val groupedSizeByStandardDataHolders: MutableList<MutableList<SizeByStandardDataHolder>> =
            mutableListOf()
        for (sizeByStandardDataHolder in sizeByStandardDataHolders) {
            if (groupedSizeByStandardDataHolders.isNotEmpty()) {
                var groupIndex: Int? = null
                var i = 0
                for (groupedSizeByStandardDataHolder in groupedSizeByStandardDataHolders) {
                    if (groupedSizeByStandardDataHolder[0].sizes == sizeByStandardDataHolder.sizes) {
                        groupIndex = i
                        break
                    }
                    i++
                }

                if (groupIndex != null) {
                    groupedSizeByStandardDataHolders[groupIndex].add(sizeByStandardDataHolder)
                }
            } else {
                groupedSizeByStandardDataHolders.add(mutableListOf(sizeByStandardDataHolder))
            }
        }


        val clothingTypeId = clothingType.id!!

        val header = DataUtils.getHeaderRow(requireContext(), clothingTypeId)

        for (item in header) {
            list.add(item)
        }

        for (row in DataUtils.getRows(requireContext(), clothingTypeId)) {
            for (item in row) {
                list.add(item)
            }
        }


        // RecyclerView
        binding.rvTable.setHasFixedSize(true)
        manager = GridLayoutManager(
            context,
            header.size,
            GridLayoutManager.VERTICAL,
            false
        )
        binding.rvTable.layoutManager = manager
        adapter = TableAdapter(list, requireContext())
        binding.rvTable.adapter = adapter


        // llcEditFields
        val bodyParts = DataUtils.getBodyParts(requireContext(), clothingType.id!!)
        for (bodyPartName in bodyParts) {
            val viewBinding = EditFieldItemBinding.inflate(
                LayoutInflater.from(context),
                binding.llcEditFields,
                true
            )

            viewBinding.tvLabel.setText(bodyPartName)
            val userBodyPartSize = PreferenceManager.getDefaultSharedPreferences(context)
                .getFloat(bodyPartName, 0f)

            viewBinding.ibEdit.setOnClickListener {
                viewBinding.ibEdit.isVisible = false
                viewBinding.editText.isEnabled = true
            }
            if (userBodyPartSize > 0) {
                viewBinding.ibEdit.isVisible = true
                viewBinding.editText.isEnabled = false
                viewBinding.editText.setText(userBodyPartSize.toString())
            } else {
                viewBinding.ibEdit.isVisible = false
                viewBinding.editText.isEnabled = true
            }
        }


        // TableViewCalcResultTable
        binding.tlCalcResultTable.isVisible = false


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.setGroupVisible(R.id.misc_group, false)
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