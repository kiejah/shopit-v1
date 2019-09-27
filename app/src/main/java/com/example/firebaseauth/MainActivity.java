package com.example.firebaseauth;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseauth.ADS.AdsRecyclerAdapter;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    Button btn_sign_out;
    TextView headerTitle,subHeaderTitle;
    ImageView ic_cards;
    LinearLayout mainLayout;

    private RecyclerView recyclerView;

    private int[] ads= {
            R.drawable.ad1,
            R.drawable.ad2,
            R.drawable.ad3,
            R.drawable.ad4,
            R.drawable.ad5,
            R.drawable.ad6,
            R.drawable.ad7,
            R.drawable.ad8,
            R.drawable.ad9 };
    private AdsRecyclerAdapter asdAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppEventsLogger.activateApp(this);
        Animation ttb = AnimationUtils.loadAnimation(this,R.anim.ttb);
        Animation stb= AnimationUtils.loadAnimation(this,R.anim.scaletobig);
        //Animation button_anim= AnimationUtils.loadAnimation(this,R.anim.btn_nxt_btt);

        recyclerView = findViewById(R.id.activity_main_recycler_view);
        layoutManager = new GridLayoutManager(this,3);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);
        asdAdapter = new AdsRecyclerAdapter(ads);


        btn_sign_out = findViewById(R.id.signOutBtn);

        headerTitle = findViewById(R.id.activity_main_header_title);
        subHeaderTitle = findViewById(R.id.activity_main_header_sub_title);
        ic_cards = findViewById(R.id.activity_main_ic_cards);

        mainLayout = findViewById(R.id.header_container);

        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                btn_sign_out.setEnabled(false);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


         headerTitle.startAnimation(ttb);
         subHeaderTitle.startAnimation(ttb);
         ic_cards.startAnimation(stb);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        recyclerView.setAdapter(asdAdapter);
                    }
                },
                4000);
    }

//    @Override
//    public void onBackPressed() {
//        AuthUI.getInstance()
//                .signOut(MainActivity.this)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        btn_sign_out.setEnabled(false);
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MainActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

}
