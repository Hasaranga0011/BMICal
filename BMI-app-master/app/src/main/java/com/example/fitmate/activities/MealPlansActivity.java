package com.example.fitmate.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitmate.R;

public class MealPlansActivity extends AppCompatActivity {

    private static final String TAG = "MealPlansActivity";
    private TextView tvMealPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plans);

        tvMealPlan = findViewById(R.id.tvMealPlan);

        String status = getIntent().getStringExtra("BMI_STATUS");
        if (status == null) {
            status = "Normal";
            Log.w(TAG, "No BMI_STATUS received, using default");
        }

        Log.d(TAG, "Received BMI_STATUS: " + status);

        String mealPlanText;

        switch (status.trim().toLowerCase()) {
            case "underweight":
                mealPlanText = "Daily Meal Plan for Underweight:\n\n"
                        + "• High-calorie, nutrient-dense foods\n"
                        + "• 5-6 meals/day with protein\n"
                        + "• Healthy fats (nuts, avocados)\n"
                        + "• Whole grains, dairy, smoothies";
                break;

            case "overweight":
                mealPlanText = "Daily Meal Plan for Overweight:\n\n"
                        + "• Controlled portions\n"
                        + "• Lean protein and veggies\n"
                        + "• Moderate carbs and healthy fats\n"
                        + "• Avoid sugary and processed foods";
                break;

            case "obese":
                mealPlanText = "Daily Meal Plan for Obese:\n\n"
                        + "• Low-calorie, fiber-rich meals\n"
                        + "• Focus on vegetables and lean protein\n"
                        + "• Hydration and portion control\n"
                        + "• No sugary drinks or fried foods";
                break;

            default:
                mealPlanText = "Daily Meal Plan for Normal Weight:\n\n"
                        + "• Balanced meals with all macros\n"
                        + "• Whole foods and proper hydration\n"
                        + "• Occasional treats in moderation\n"
                        + "• Mindful eating and regular schedules";
                break;
        }

        tvMealPlan.setText(mealPlanText);
    }
}
