package com.example.sizepicker.utils

import android.content.Context
import android.util.Log
import com.example.sizepicker.R
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object DataUtils {

    @Throws(IOException::class)
    fun readText(context: Context, resId: Int): String {
        val inputStream: InputStream = context.resources.openRawResource(resId)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var s: String?
        while (bufferedReader.readLine().also { s = it } != null) {
            stringBuilder.append(s)
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    private fun getRIdFromCTId(CTId: Int): Int {
        return when (CTId) {
            0 -> {
                R.raw.tshirt
            }
            else -> {
                Log.w(this::class.qualifiedName, "Unknown id: $CTId")
            }
        }
    }

    fun getBodyParts(context: Context, clothingTypeId: Int): List<String> {
        val jsonText: String = readText(context, getRIdFromCTId(clothingTypeId))
        val jsonObject = JSONObject(jsonText)
        val bodyPartsCount = jsonObject.get("bodyParts") as Int
        val jsonArray = jsonObject.getJSONArray("array")
        return List(bodyPartsCount) {
            (jsonArray[0] as JSONArray)[it] as String
        }
    }

    fun getHeaderRow(context: Context, clothingTypeId: Int): List<String> {
        val jsonText: String = readText(context, getRIdFromCTId(clothingTypeId))
        val jsonObject = JSONObject(jsonText)
        val jsonArray = jsonObject.getJSONArray("array")
        val firstRow = jsonArray[0] as JSONArray
        return List(firstRow.length()) {
            firstRow[it] as String
        }
    }

    fun getRows(context: Context, clothingTypeId: Int): List<List<String>> {
        val jsonText: String = readText(context, getRIdFromCTId(clothingTypeId))
        val jsonObject = JSONObject(jsonText)
        val jsonArray = jsonObject.getJSONArray("array")
        return List(jsonArray.length() - 1) { i ->
            val row = jsonArray[i + 1] as JSONArray
            List(row.length()) { j ->
                row[j] as String
            }
        }
    }
}