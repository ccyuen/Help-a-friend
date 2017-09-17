package com.example.staff.helpafriend;

import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
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

public class Authentication {

    private MainActivity m;
    private FirebaseAuth mAuth;

    public Authentication(MainActivity _m, FirebaseAuth _mAuth) {
        m = _m;
        mAuth = _mAuth;
    }

    public void createAccount(String email, String password) {
        Log.d(m.DEBUG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(m, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(m.DEBUG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(m.DEBUG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(m.getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                          //  updateUI(null);
                        }
                    }
                });
    }

    public void signIn(String email, String password) {
        Log.d(MainActivity.DEBUG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(m, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(m.DEBUG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(m.DEBUG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(m.getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                          //  updateUI(null);
                        }

                        if (!task.isSuccessful()) {
                           // m.mStatusTextView.setText(R.string.auth_failed);
                        }
                    }
                });
    }

    public void signOut() {
        mAuth.signOut();
        //updateUI(null);
    }

//    public void sendEmailVerification() {
//        // Disable button
//        m.findViewById(R.id.verify_email_button).setEnabled(false);
//        // Send verification email
//        final FirebaseUser user = mAuth.getCurrentUser();
//        user.sendEmailVerification()
//                .addOnCompleteListener(m, new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // Re-enable button
//                        m.findViewById(R.id.verify_email_button).setEnabled(true);
//
//                        if (task.isSuccessful()) {
//                            Toast.makeText(m.getApplicationContext(),
//                                    "Verification email sent to " + user.getEmail(),
//                                    Toast.LENGTH_SHORT).show();
//                        } else {
//                            Log.e(m.DEBUG, "sendEmailVerification", task.getException());
//                            Toast.makeText(m.getApplicationContext(),
//                                    "Failed to send verification email.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }

    private boolean validateForm() {
        boolean valid = true;

        String email = m.mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            m.mEmailField.setError("Required.");
            valid = false;
        } else {
            m.mEmailField.setError(null);
        }

        String password = m.mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            m.mPasswordField.setError("Required.");
            valid = false;
        } else {
            m.mPasswordField.setError(null);
        }

        return valid;
    }

//    public void updateUI(FirebaseUser user) {
//        if (user != null) {
//            m.mStatusTextView.setText(R.string.emailpassword_status_fmt + "  " + user.getEmail() + "  " +  user.isEmailVerified()));
//            m.mDetailTextView.setText(R.string.firebase_status_fmt + "  " + user.getUid());
//
//            m.findViewById(R.id.email_password_buttons).setVisibility(View.GONE);
//            m.findViewById(R.id.email_password_fields).setVisibility(View.GONE);
//            m.findViewById(R.id.signed_in_buttons).setVisibility(View.VISIBLE);
//
//            m.findViewById(R.id.verify_email_button).setEnabled(!user.isEmailVerified());
//        } else {
//            m.mStatusTextView.setText(R.string.signed_out);
//            m.mDetailTextView.setText(null);
//
//            m.findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
//            m.findViewById(R.id.email_password_fields).setVisibility(View.VISIBLE);
//            m.findViewById(R.id.signed_in_buttons).setVisibility(View.GONE);
//        }
//    }
}
