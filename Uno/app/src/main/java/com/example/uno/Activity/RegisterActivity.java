package com.example.uno.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uno.Autres.Firebase;
import com.example.uno.R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "";
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    TextView goToLogin;
    EditText mailEditText, passwordEditText, confirmPasswordEditText, usernameEditText;
    Button registerButton;
    String mailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Firebase firebase = new Firebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        goToLogin = findViewById(R.id.register_text_view);
        usernameEditText = findViewById(R.id.username_edit_text);
        mailEditText = findViewById(R.id.mail_edit_text2);
        passwordEditText = findViewById(R.id.password1_edit_text);
        confirmPasswordEditText = findViewById(R.id.password2_edit_text);
        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerForAuth();
            }
        });

        confirmPasswordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    PerForAuth();
                }
                return false;
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }


    private void PerForAuth() {
        String username = usernameEditText.getText().toString();
        String mail = mailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        if (!mail.matches(mailPattern)) {
            mailEditText.setError("Enter Correct Email");
            return;
        }

        if (password.isEmpty() || password.length() < 6) {
            passwordEditText.setError("Enter proper password");
            return;
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordEditText.setError("Les mots de passe ne sont pas identiques");
            return;
        }

        mAuth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "createUserWithEmail:success");
                        sendUserToNextActivity();
                        firebase.créerDonnées("Username", username);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                });
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(RegisterActivity.this, AccueilActivity.class);
        startActivity(intent);
    }

    private void updateUI(GoogleSignInAccount account) {
        if (account != null) {
            Intent intent = new Intent(getApplicationContext(), AccueilActivity.class);
            startActivity(intent);
        }
    }
}
