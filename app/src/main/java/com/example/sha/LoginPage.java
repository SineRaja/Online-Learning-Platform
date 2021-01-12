package com.example.sha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sha.mainpage.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {

    Button callSignUp, btN;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;
    private TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mAuth = FirebaseAuth.getInstance();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        progressbar = findViewById(R.id.progressbar);
        btN = findViewById(R.id.loginToHome);
        callSignUp = findViewById(R.id.CallSignUp);
        callSignUp.setOnClickListener(view -> {
            Intent signIntent = new Intent(LoginPage.this, Registration.class);
            startActivity(signIntent);
        });

        btN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUserAccount();
            }
        });
    }

    private void loginUserAccount() {
        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        String email, password1;
        email = username.getEditText().getText().toString();
        password1 = password.getEditText().getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(password1)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password1)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Login successful!!",
                                            Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                    progressbar.setVisibility(View.GONE);

                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent
                                            = new Intent(LoginPage.this,
                                            HomeActivity.class);
                                    startActivity(intent);
                                }

                                else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                            "Login failed!!",
                                            Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                    progressbar.setVisibility(View.GONE);
                                }
                            }
                        });
    }

}




 /*       password = findViewById(R.id.login_phone_number);
        phoneNumber = findViewById(R.id.login_password);

    }

    public void callForgetPassword(View view) {
    }

    public void callSignUpFromLogin(View view) {
        Intent intent1 =new Intent(getApplicationContext(), Registration.class);
        startActivity(intent1);
        finish();
    }

    public void letTheUserLoggedIn(View view) {

        if(!validatePassword() | !validatePhoneNumber()){
            return;
        }
        else {
            isUser();
        }

    }

    private void isUser() {
        String userEnteredPhoneNo = phoneNumber.getEditText().getText().toString().trim();
        String userEnteredPassword = password.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("phoneNo").equalTo(userEnteredPhoneNo);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    phoneNumber.setError(null);
                    phoneNumber.setErrorEnabled(false);
                    String passwordFromDB = dataSnapshot.child(userEnteredPhoneNo).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)){
                        phoneNumber.setError(null);
                        phoneNumber.setErrorEnabled(false);
                        String emailIDFromDB = dataSnapshot.child(userEnteredPhoneNo).child("emailID").getValue(String.class);
                        String phoneNoFromDB = dataSnapshot.child(userEnteredPhoneNo).child("phoneNo").getValue(String.class);
                        String userNameFromDB = dataSnapshot.child(userEnteredPhoneNo).child("userName").getValue(String.class);

                        SharedPrefernce sharedPrefernce = new SharedPrefernce(LoginPage.this);
                        sharedPrefernce.createLoginSession(userNameFromDB, userNameFromDB,emailIDFromDB,phoneNoFromDB,passwordFromDB);

                        Intent intent = new Intent(getApplicationContext(), ComingSoon.class);
                        intent.putExtra("userName", userNameFromDB);
                        intent.putExtra("email", emailIDFromDB);
                        intent.putExtra("phoneNo", phoneNoFromDB);
                        startActivity(intent);

                    }
                    else {
                        password.setError("Wrong Password!");
                        password.requestFocus();
                    }
                }
                else {
                    phoneNumber.setError("This Number is not registered!");
                    phoneNumber.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            phoneNumber.setError("Enter valid phone number");
            return false;
        }  else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
*/
