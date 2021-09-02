package com.example.borderradiuspreviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.borderradiuspreviewer.utils.resToPx
import com.example.borderradiuspreviewer.utils.toColorInt
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val orangeColor = R.color.orange.toColorInt(this)
        val cardWidth = ViewGroup.LayoutParams.MATCH_PARENT
        val cardHeight = R.dimen.profile_card_height.resToPx(this).toInt()
        val profileCardContainer = findViewById<FrameLayout>(R.id.profileCardContainer)
        var editTextTopLeftRadius = findViewById<EditText>(R.id.editTextTopLeftRadius)
        var editTextTopRightRadius = findViewById<EditText>(R.id.editTextTopRightRadius)
        var editTextBottomLeftRadius = findViewById<EditText>(R.id.editTextBottomLeftRadius)
        var editTextBottomRightRadius = findViewById<EditText>(R.id.editTextBottomRightRadius)
        val button = findViewById<Button>(R.id.buttonDraw)
        var topLeftRadiusFromInput = 0f
        var topRightRadiusFromInput = 0f
        var bottomLeftRadiusFromInput = 0f
        var bottomRightRadiusFromInput = 0f

        editTextBottomLeftRadius.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                bottomLeftRadiusFromInput = editTextBottomLeftRadius.text.toString().toFloat()
                val painter = DrawRectangle(
                    color = orangeColor,
                    topLeftRadius = topLeftRadiusFromInput,
                    topRightRadius = topRightRadiusFromInput,
                    bottomLeftRadius = editTextBottomLeftRadius.text.toString().toFloat(),
                    bottomRightRadius = bottomRightRadiusFromInput
                )
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        button.setOnClickListener {
            profileCardContainer.addView(
                CustomPainter(
                    context = this,
                    width = cardWidth,
                    height = cardHeight,
                    painter = DrawRectangle(
                        color = orangeColor, topLeftRadius = topLeftRadiusFromInput,
                        topRightRadius = topRightRadiusFromInput,
                        bottomLeftRadius = bottomLeftRadiusFromInput,
                        bottomRightRadius = bottomRightRadiusFromInput
                    )
                )
            )
        }
    }
}