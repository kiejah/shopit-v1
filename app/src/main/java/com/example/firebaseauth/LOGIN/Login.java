package com.example.firebaseauth.LOGIN;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.firebaseauth.LOCATION.LocationActivity;
import com.example.firebaseauth.MainActivity;
import com.example.firebaseauth.R;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class Login extends AppCompatActivity {

    Boolean isRegistered;
    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        isRegistered = isUserRegistered();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(isRegistered){
                        // If registered and token is available
                        Intent i = new Intent(Login.this, MainActivity.class);
                        startActivity(i);

                    }else{
                        // If not registered
                        showSignInOptions();
                    }

                }
            }
        };
        thread.start();
    }

    private void showSignInOptions() {
        // mainLayout.setVisibility(LinearLayout.GONE);
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.Mytheme)
                        .build(),MY_REQUEST_CODE
        );
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MY_REQUEST_CODE){
            IdpResponse idpResponse= IdpResponse.fromResultIntent(data);

            if(resultCode==RESULT_OK){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Toast.makeText(this,""+user.getEmail(),Toast.LENGTH_SHORT).show();
                // btn_sign_out.setEnabled(true);
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                Intent intent = new Intent(Login.this, LocationActivity.class);
                                startActivity(intent);

                            }
                        },
                        5000);

            }else{
                Toast.makeText(this,"Bye Bye",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    private Boolean isUserRegistered(){
        return true;
    }
}
