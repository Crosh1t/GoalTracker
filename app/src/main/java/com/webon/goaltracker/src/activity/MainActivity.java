package com.webon.goaltracker.src.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.webon.goaltracker.R;
import com.webon.goaltracker.src.db.AppDatabase;
import com.webon.goaltracker.src.model.Goal;

public class MainActivity extends AppCompatActivity {

    private EditText goalInput;
    private EditText interestsInput;
    private Button saveButton;
    private TextView displayText;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация базы данных
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "goal-database").build();

        goalInput = findViewById(R.id.goal_input);
        interestsInput = findViewById(R.id.interests_input);
        saveButton = findViewById(R.id.save_button);
        displayText = findViewById(R.id.display_text);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goal = goalInput.getText().toString().trim();
                String interests = interestsInput.getText().toString().trim();

                if (goal.isEmpty() || interests.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    // Сохранение в базу в отдельном потоке
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Goal newGoal = new Goal(goal, interests);
                            db.goalDao().insert(newGoal);

                            // Обновление UI в главном потоке
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    displayText.setText("Цель: " + goal + "\nИнтересы: " + interests);
                                    goalInput.setText("");
                                    interestsInput.setText("");
                                }
                            });
                        }
                    }).start();
                }
            }
        });
    }
}