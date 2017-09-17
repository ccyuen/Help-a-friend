package com.example.staff.helpafriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.view.*;

public class MainActivity extends AppCompatActivity {
    public static final String DEBUG = "AUTH";

    public TextView mStatusTextView;
    public TextView mDetailTextView;
    public EditText mEmailField;
    public EditText mPasswordField;

    private FirebaseAuth mAuth;
    private Authentication auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, googlemaps.class);
        startActivity(intent);
        // Views
//        mStatusTextView = (TextView) findViewById(R.id.status);
//        mDetailTextView = (TextView) findViewById(R.id.detail);
//        mEmailField = (EditText) findViewById(R.id.field_email);
//        mPasswordField = (EditText) findViewById(R.id.field_password);

        // Buttons
//        findViewById(R.id.email_sign_in_button).setOnClickListener(this);
//        findViewById(R.id.email_create_account_button).setOnClickListener(this);
//        findViewById(R.id.sign_out_button).setOnClickListener(this);
//        findViewById(R.id.verify_email_button).setOnClickListener(this);

        // [START initialize_auth]
        //mAuth = FirebaseAuth.getInstance();
        //auth = new Authentication(this, mAuth);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        auth.updateUI(currentUser);
//    }

//    @Override
//    public void onClick(View v) {
//        int i = v.getId();
//        if (i == R.id.email_create_account_button) {
//            auth.createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString());
//        } else if (i == R.id.email_sign_in_button) {
//            auth.signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
//        } else if (i == R.id.sign_out_button) {
//            auth.signOut();
//        } else if (i == R.id.verify_email_button) {
//            auth.sendEmailVerification();
//        }
//    }
}
