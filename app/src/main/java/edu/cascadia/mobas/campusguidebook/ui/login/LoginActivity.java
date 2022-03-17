package edu.cascadia.mobas.campusguidebook.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import edu.cascadia.mobas.campusguidebook.MainActivity;
import edu.cascadia.mobas.campusguidebook.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    //private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final Button registerButton = binding.login2;
        final ProgressBar loadingProgressBar = binding.loading;

        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        });

        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent( LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}