package com.example.danhnc.staffmanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;

/**
 * Created by danhnc on 11/17/2017.
 */

public class LoginActivity extends Activity {
    private CallbackManager callbackManager;
    private LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(LoginActivity.this,"Successful", Toast.LENGTH_LONG).show();}

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this,"Login attempt canceled.", Toast.LENGTH_LONG).show();}

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(LoginActivity.this,"Login attempt failed.", Toast.LENGTH_LONG).show();}
        });





    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        data = new Intent(LoginActivity.this,MainActivity.class);
        LoginActivity.this.startActivity(data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
