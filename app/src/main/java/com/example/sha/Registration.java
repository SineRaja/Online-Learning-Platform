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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class Registration extends AppCompatActivity {

    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button backToLogin, regBtn;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        regName = findViewById(R.id.reg_name);
        regUsername = findViewById(R.id.reg_username);
        regEmail =findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        backToLogin = findViewById(R.id.backToLogin);
        regBtn = findViewById(R.id.signInHome);
        progressbar = findViewById(R.id.progressbar);

        backToLogin.setOnClickListener(view -> {
            Intent toLoginIntent = new Intent(Registration.this,LoginPage.class);
            startActivity(toLoginIntent);
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }
        });

    }
    private void registerNewUser() {
        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);
        String email, password,phone, name, username;
        email = regEmail.getEditText().getText().toString();
        password = regPassword.getEditText().getText().toString();
        phone = regPhoneNo.getEditText().getText().toString();
        name = regName.getEditText().getText().toString();
        username = regUsername.getEditText().getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter phone No!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter name!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter username!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        // create new user or register new user
        mAuth
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "Registration successful!",
                                    Toast.LENGTH_LONG)
                                    .show();

                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);

                            // if the user created intent to login activity
                            Intent intent
                                    = new Intent(Registration.this,
                                    HomeActivity.class);
                            startActivity(intent);
                        }
                        else {

                            // Registration failed
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Registration failed!!"
                                            + " Please try again later",
                                    Toast.LENGTH_LONG)
                                    .show();

                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}



  /*      userName = findViewById(R.id.signup_fullname);
        email = findViewById((R.id.signup_email));
        password = findViewById(R.id.signup_password);
        phoneNumber = findViewById(R.id.phone_number);
        countryCodePicker = findViewById(R.id.login_country_code_picker);
    }

    public void callNextHomeScreen(View view) {



        if(!validateUserName() | !validateEmail() | !validatePhoneNumber() | !validatePassword()){
            return;
        }
        else {
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("users");

            String name = userName.getEditText().getText().toString();
            String emailid = email.getEditText().getText().toString();
            String phone = phoneNumber.getEditText().getText().toString();
            String pswd = password.getEditText().getText().toString();

            UserHelperClass helperClass = new UserHelperClass(name, emailid, phone, pswd);
            reference.child(phone).setValue(helperClass);

            // String userName = getIntent().getStringExtra("userName");
         //    String email = getIntent().getStringExtra("email");
         //    String password = getIntent().getStringExtra("password");

           //  String _getUserPhoneNo = phoneNumber.getEditText().getText().toString().trim();
           //  String phoneNumber = "+" + countryCodePicker.getFullNumber() + _getUserPhoneNo;

            Intent i1 = new Intent(getApplicationContext(), ComingSoon.class);
           //     i1.putExtra("userName",userName);
         //       i1.putExtra("email",email);
           //     i1.putExtra("password",password);
            //    i1.putExtra("phoneNo", phoneNumber);
            startActivity(i1);

        }

    }

    private boolean validateUserName(){
        String val = userName.getEditText().getText().toString().trim();

        if(val.isEmpty()){
            userName.setError("Field can not be empty");
            return false;
        }
        else {
            userName.setError(null);
            userName.setErrorEnabled(false);
            return true;

        }

    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
        String checkSpaces = "[0-9]{10}";
        if (val.isEmpty()) {
            phoneNumber.setError("Enter valid phone number");
            return false;
        } else if (!val.matches(checkSpaces)) {
            phoneNumber.setError("No White spaces are allowed!");
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword =  "[a-zA-Z0-9]{8,24}";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain 4 characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

}*/