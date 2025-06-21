package com.example.fitmate.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitmate.R;

public class ExercisePlansActivity extends AppCompatActivity {

    private static final String TAG = "ExercisePlansActivity";
    private TextView tvExercisePlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_plans);

        tvExercisePlan = findViewById(R.id.tvExercisePlan);

        String status = getIntent().getStringExtra("BMI_STATUS");
        if (status == null) {
            status = "Normal";
            Log.w(TAG, "No BMI_STATUS received, using default");
        }

        Log.d(TAG, "Received BMI_STATUS: " + status);

        String exercisePlanText;

        switch (status.trim().toLowerCase()) {
            case "underweight":
                exercisePlanText = "Weekly Exercise Plan for Underweight:\n\n"
                        + "• Strength training 3-4 times/week\n"
                        + "• Compound exercises (squats, deadlifts)\n"
                        + "• Progressive overload\n"
                        + "• Moderate cardio (2-3 times/week)\n"
                        + "• Adequate rest between sessions";
                break;

            case "overweight":
                exercisePlanText = "Weekly Exercise Plan for Overweight:\n\n"
                        + "• Cardio 4-5 times/week (30-45 mins)\n"
                        + "• Low-impact exercises (walking, swimming)\n"
                        + "• Strength training 2-3 times/week\n"
                        + "• Bodyweight exercises\n"
                        + "• Stretching daily";
                break;

            case "obese":
                exercisePlanText = "Weekly Exercise Plan for Obese:\n\n"
                        + "• Daily walking (30 mins+)\n"
                        + "• Low-impact aerobic workouts\n"
                        + "• Seated or water-based strength exercises\n"
                        + "• Gentle stretching or yoga\n"
                        + "• Focus on consistency and gradual intensity";
                break;

            default:
                exercisePlanText = "Weekly Exercise Plan for Normal Weight:\n\n"
                        + "• Balanced routine (3-4 times/week)\n"
                        + "• Mix of cardio and strength\n"
                        + "• Flexibility exercises\n"
                        + "• Active rest days\n"
                        + "• Variety of activities";
                break;
        }

        tvExercisePlan.setText(exercisePlanText);
    }
}
