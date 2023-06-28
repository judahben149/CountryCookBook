package com.judahben149.countrycookbook.utils

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import androidx.core.text.HtmlCompat
import androidx.palette.graphics.Palette

fun createPalette(drawable: Drawable): Palette {
    val bitmap = drawable.toBitmap()
    return Palette.from(bitmap).generate()
}

fun String.getEmojiDrawable(context: Context, alpha: Int = 255): BitmapDrawable {
    val htmlString = HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)

    val textView = TextView(context) // Replace 'context' with your actual context
    textView.textSize = 24.toFloat() // Adjust the text size as per your requirement
    textView.text = htmlString
    textView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
    textView.layout(0, 0, textView.measuredWidth, textView.measuredHeight)

    val bitmap = Bitmap.createBitmap(textView.measuredWidth, textView.measuredHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    canvas.translate(-textView.scrollX.toFloat(), -textView.scrollY.toFloat())

    val paint = Paint()
    paint.alpha = alpha

    textView.draw(canvas)

    val editedBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true)
    val editedCanvas = Canvas(editedBitmap)
    editedCanvas.drawBitmap(bitmap, 0f, 0f, paint)

    return BitmapDrawable(context.resources, editedBitmap)
}