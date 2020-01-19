package com.example.jobhunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobhunter.utils.CommonUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class profile_activity extends AppCompatActivity {

    Button continueBT;
    EditText nameET,contactET,mailET,passwordET;
    GifImageView progress;
    FirebaseAuth mAuth= FirebaseAuth.getInstance();

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference usercolref = db.collection("userprofile");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        initUI();

        continueBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtils.hideKeyboard(profile_activity.this);
                progress.setVisibility(View.VISIBLE);
                if (nameET.getText().toString().isEmpty() || contactET.getText().toString().isEmpty() || mailET.getText().toString().isEmpty() || passwordET.getText().toString().isEmpty()) {
                    Toast.makeText(profile_activity.this, "Please fill all required Fields", Toast.LENGTH_SHORT).show();
                    progress.setVisibility(View.GONE);
                } else {
                    final Map<String, Object> jobdetailsMAP = new HashMap<>();
                    jobdetailsMAP.put("name", nameET.getText().toString().trim());
                    jobdetailsMAP.put("contact", contactET.getText().toString().trim());
                    jobdetailsMAP.put("email", mailET.getText().toString().trim());
                    jobdetailsMAP.put("password", passwordET.getText().toString().trim());



                    usercolref.add(jobdetailsMAP)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    if (documentReference != null) {
                                        mAuth.createUserWithEmailAndPassword(mailET.getText().toString().trim(), passwordET.getText().toString().trim())
                                                .addOnCompleteListener(profile_activity.this, new OnCompleteListener<AuthResult>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                        if (task.isSuccessful()) {
                                                            // Sign in success, update UI with the signed-in user's information
                                                            Intent intent = new Intent(getApplicationContext(),StatusActivity.class);
                                                            intent.putExtra(CommonUtils.Iemail,mailET.getText().toString().trim());
                                                            startActivity(intent);
                                                            Toast.makeText(profile_activity.this, "Upload successful !!!", Toast.LENGTH_SHORT).show();
                                                            progress.setVisibility(View.GONE);
                                                        } else {
                                                            // If sign in fails, display a message to the user.
                                                            Toast.makeText(profile_activity.this, "User Creation Failed",
                                                                    Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });

                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(profile_activity.this, "Upload failure", Toast.LENGTH_SHORT).show();
                                    progress.setVisibility(View.GONE);
                                }
                            });

                }

            }
        });


    }

    private void initUI() {
        continueBT = findViewById(R.id.continueBT);
        nameET = findViewById(R.id.nameTV);
        contactET = findViewById(R.id.mobileTV);
        mailET=findViewById(R.id.emailTV);
        passwordET = findViewById(R.id.passwordTV);
        progress=findViewById(R.id.progressIV);
    }
}
