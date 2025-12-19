package com.example.healthyme

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.healthyme.databinding.ActivityResultBinding
import kotlin.math.roundToInt

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindData()
        entranceAnimation()
        setupBack()
    }

    private fun bindData() {
        val bmi = intent.getDoubleExtra("EXTRA_BMI", 0.0)
        val category = intent.getStringExtra("EXTRA_CATEGORY") ?: "—"
        val description = intent.getStringExtra("EXTRA_DESCRIPTION") ?: ""
        val colorRes = intent.getIntExtra("EXTRA_COLOR", R.color.bmi_normal)

        binding.bmiValueText.text = String.format("%.1f", bmi)
        binding.categoryText.text = category
        binding.descriptionText.text = description

        val color = resources.getColor(colorRes, theme)
        val bg = GradientDrawable(
            GradientDrawable.Orientation.BL_TR,
            intArrayOf(color, resources.getColor(R.color.background_end, theme))
        )
        bg.cornerRadius = resources.getDimension(R.dimen.card_corner_radius)
        binding.resultCard.background = bg

        // progress-like scale
        val progress = calculateProgressFromBmi(bmi)
        binding.bmiProgressBar.scaleX = if (progress > 0.02f) progress else 0.02f

        // color the back button to match category (tinted)
        binding.backButton.setBackgroundColor(color)
        binding.backButton.setTextColor(resources.getColor(R.color.white, theme))
    }

    private fun setupBack() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun calculateProgressFromBmi(bmi: Double): Float {
        val clamped = bmi.coerceIn(12.0, 40.0)
        val t = (clamped - 12.0) / (40.0 - 12.0)
        return 0.1f + (t * 0.9f).toFloat()
    }

    private fun entranceAnimation() {
        binding.resultCard.alpha = 0f
        binding.resultCard.translationY = 30f
        binding.resultCard.animate().alpha(1f).translationY(0f).setDuration(420).start()

        // animate bmi number pop
        binding.bmiValueText.scaleX = 0.9f
        binding.bmiValueText.scaleY = 0.9f
        binding.bmiValueText.animate().scaleX(1f).scaleY(1f).setDuration(450).start()
    }
}