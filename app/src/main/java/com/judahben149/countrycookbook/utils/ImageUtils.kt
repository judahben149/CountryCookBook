package com.judahben149.countrycookbook.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import androidx.core.text.HtmlCompat
import androidx.palette.graphics.Palette
import com.judahben149.countrycookbook.R

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

fun String.returnContinentDrawable(): Int {
    return when(this) {
        "AF" -> R.drawable.img_africa
        "AN" -> R.drawable.img_antartica
        "AS" -> R.drawable.img_asia_other
        "EU" -> R.drawable.img_europe
        "NA" -> R.drawable.img_north_america
        "OC" -> R.drawable.img_oceania
        "SA" -> R.drawable.img_south_america
        else -> R.drawable.img_africa
    }
}