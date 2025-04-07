package com.webon.goaltracker.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.webon.goaltracker.R;

public class MainActivity extends AppCompatActivity {

    private EditText goalInput;      // Поле для ввода цели
    private EditText interestsInput; // Поле для ввода интересов
    private Button saveButton;       // Кнопка сохранения
    private TextView displayText;    // Текст для отображения результата

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Привязка элементов интерфейса
        goalInput = findViewById(R.id.goal_input);
        interestsInput = findViewById(R.id.interests_input);
        saveButton = findViewById(R.id.save_button);
        displayText = findViewById(R.id.display_text);

        // Обработчик нажатия на кнопку
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goal = goalInput.getText().toString().trim();
                String interests = interestsInput.getText().toString().trim();

                if (goal.isEmpty() || interests.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    // Пока просто отображаем введённые данные
                    String result = "Цель: " + goal + "\nИнтересы: " + interests;
                    displayText.setText(result);

                    // Очищаем поля после сохранения
                    goalInput.setText("");
                    interestsInput.setText("");
                }
            }
        });
    }
}