package com.example.sizepicker.data.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*

@Entity(tableName = "clothing_types")
data class ClothingType(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "instruction") val instruction: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(instruction)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ClothingType> {
        override fun createFromParcel(parcel: Parcel): ClothingType {
            return ClothingType(parcel)
        }

        override fun newArray(size: Int): Array<ClothingType?> {
            return arrayOfNulls(size)
        }
    }
}

data class ClothingTypeWithBodyParts(
    @Embedded
    val clothingType: ClothingType,
    @Relation(
        parentColumn = "id",
        entity = BodyPart::class,
        entityColumn = "id",
        associateBy = Junction(
            value = ClothingTypeToBodyPart::class,
            parentColumn = "clothingTypeId",
            entityColumn = "bodyPartId"
        )
    )
    val bodyParts: List<BodyPart>
)

data class ClothingTypeWithStandards(
    @Embedded
    val clothingType: ClothingType,
    @Relation(
        parentColumn = "id",
        entity = Standard::class,
        entityColumn = "id",
        associateBy = Junction(
            value = SizeByStandard::class,
            parentColumn = "clothingTypeId",
            entityColumn = "standardId"
        )
    )
    val standards: List<Standard>
)