package com.example.mastermime.meme.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory


fun getImagesFromAssets(context: Context): List<String> {

    // Get a list of all files in the assets folder
    return listFilesFromAssets(context, "")
}

// Helper function to list files from assets

fun listFilesFromAssets(context: Context, folder: String): List<String> {
    return try {
        context.assets.list(folder)?.toList() ?: emptyList()
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}

// Helper function to load a bitmap from assets
fun loadBitmapFromAssets(context: Context, fileName: String): Bitmap? {
    return try {
        val inputStream = context.assets.open(fileName)
        BitmapFactory.decodeStream(inputStream)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}