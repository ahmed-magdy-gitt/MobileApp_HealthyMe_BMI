package com.example.healthyme

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthyme.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        entranceAnimation()
    }

    private fun setupUI() {
        // مراقبة الحقول لتفعيل الزر
        binding.weightInput.addTextChangedListener(inputWatcher)
        binding.heightInput.addTextChangedListener(inputWatcher)

        // الزر
        binding.calculateButton.setOnClickListener {
            // أنيميشن بسيطة عند الضغط
            it.animate().scaleX(0.94f).scaleY(0.94f).setDuration(90).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(120).start()
            }.start()

            calculateAndNavigate()
        }

        // لما المستخدم يضغط "Done" في الكيبورد
        binding.heightInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                calculateAndNavigate()
                true
            } else false
        }
    }

    private val inputWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val isWeightValid = binding.weightInput.text?.isNotBlank() == true
            val isHeightValid = binding.heightInput.text?.isNotBlank() == true
            binding.calculateButton.isEnabled = isWeightValid && isHeightValid
        }
        override fun afterTextChanged(s: Editable?) {}
    }

    private fun calculateAndNavigate() {
        val weightText = binding.weightInput.text.toString().trim()
        val heightText = binding.heightInput.text.toString().trim()

        val weight = weightText.toFloatOrNull()
        val heightCm = heightText.toFloatOrNull()

        if (weight == null || weight <= 0f) {
            Toast.makeText(this, "Enter a valid weight (kg).", Toast.LENGTH_SHORT).show()
            return
        }
        if (heightCm == null || heightCm <= 0f) {
            Toast.makeText(this, "Enter a valid height (cm).", Toast.LENGTH_SHORT).show()
            return
        }

        val heightM = heightCm / 100f
        val rawBmi = weight / (heightM * heightM)
        val bmiRounded = (rawBmi * 10).roundToInt() / 10.0

        val category = categorizeBmi(rawBmi)

        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("EXTRA_BMI", bmiRounded)
            putExtra("EXTRA_CATEGORY", category.first)
            putExtra("EXTRA_DESCRIPTION", category.second)
            putExtra("EXTRA_COLOR", category.third)
        }
        startActivity(intent)
    }

    private fun categorizeBmi(bmi: Float): Triple<String, String, Int> {
        return when {
            bmi < 18.5 -> Triple(
                "Underweight",
                "Your BMI indicates you are under the normal weight range. Consider a balanced diet and consult a professional if needed.",
                R.color.bmi_under
            )
            bmi < 25 -> Triple(
                "Normal",
                "Great — your BMI is within the normal range. Keep maintaining a balanced lifestyle!",
                R.color.bmi_normal
            )
            bmi < 30 -> Triple(
                "Overweight",
                "Your BMI indicates overweight. Consider regular exercise and dietary adjustments.",
                R.color.bmi_over
            )
            else -> Triple(
                "Obese",
                "BMI in the obese range. Please consult a healthcare professional for personalized advice.",
                R.color.bmi_obese
            )
        }
    }

    private fun entranceAnimation() {
        // تأثير دخول للعناصر
        binding.appTitle.alpha = 0f
        binding.appSubtitle.alpha = 0f
        binding.inputCard.alpha = 0f
        binding.calculateButton.alpha = 0f

        binding.appTitle.translationY = 40f
        binding.appSubtitle.translationY = 40f
        binding.inputCard.translationY = 60f
        binding.calculateButton.translationY = 60f

        binding.appTitle.animate().alpha(1f).translationY(0f)
            .setDuration(500).setInterpolator(DecelerateInterpolator()).start()

        binding.appSubtitle.animate().alpha(1f).translationY(0f)
            .setStartDelay(100).setDuration(500).setInterpolator(DecelerateInterpolator()).start()

        binding.inputCard.animate().alpha(1f).translationY(0f)
            .setStartDelay(200).setDuration(600).setInterpolator(DecelerateInterpolator()).start()

        binding.calculateButton.animate().alpha(1f).translationY(0f)
            .setStartDelay(350).setDuration(600).setInterpolator(DecelerateInterpolator()).start()
    }
}