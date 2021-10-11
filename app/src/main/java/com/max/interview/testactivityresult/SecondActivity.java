package com.max.interview.testactivityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.max.interview.testactivityresult.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btn1.setOnClickListener(v -> sendResult("click btn 1"));

        binding.btn2.setOnClickListener(v -> sendResult("click btn 2"));
    }

    private void sendResult(String s) {
        Intent intent = getIntent();
        intent.putExtra("key", s);
        setResult(RESULT_OK, intent);
        finish();
    }


}