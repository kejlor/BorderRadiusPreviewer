package com.example.borderradiuspreviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.borderradiuspreviewer.utils.resToPx
import com.example.borderradiuspreviewer.utils.toColorInt
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val orangeColor = R.color.orange.toColorInt(this)
        val cardWidth = ViewGroup.LayoutParams.MATCH_PARENT
        val cardHeight = R.dimen.profile_card_height.resToPx(this).toInt()
        val profileCardContainer = findViewById<FrameLayout>(R.id.profileCardContainer)
        val painter = DrawRectangle(
            color = orangeColor
        )
        profileCardContainer.addView(
            CustomPainter(
                context = this,
                width = cardWidth,
                height = cardHeight,
                painter = painter
            )
        )
//        TODO: need to implement EditText fields which will allow user to change each corner radius
    }
}