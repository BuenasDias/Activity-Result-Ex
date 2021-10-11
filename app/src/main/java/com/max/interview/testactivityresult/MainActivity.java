package com.max.interview.testactivityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.max.interview.testactivityresult.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btn1.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent , REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE  && resultCode  == RESULT_OK) {
                String requiredValue = data.getStringExtra("key");
                binding.textMain.setText(requiredValue);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}