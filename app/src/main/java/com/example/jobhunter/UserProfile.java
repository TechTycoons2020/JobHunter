package com.example.jobhunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobhunter.adapter.PrivateJobAdapter;
import com.example.jobhunter.models.Jobs;
import com.example.jobhunter.models.userdetails;
import com.example.jobhunter.utils.SharedPref;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class UserProfile extends AppCompatActivity {

    TextView username,email,contact,qualification,course,lang,percent;
    ImageView dpIV;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference prijobscolref = db.collection("userprofile");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        username = findViewById(R.id.usernameTV);
        email = findViewById(R.id.emailTV);
        qualification= findViewById(R.id.qualTV);
        contact= findViewById(R.id.contactTV);
        course = findViewById(R.id.courseTV);
        lang= findViewById(R.id.langTV);
        percent= findViewById(R.id.percentTV);

        dpIV =findViewById(R.id.dpIV);
        if(SharedPref.getString(getApplicationContext(), "sp_image_url")!=null){
            Picasso.get().load(SharedPref.getString(getApplicationContext(), "sp_image_url")).into(dpIV);
        }

        prijobscolref.whereEqualTo("email",SharedPref.getString(getApplicationContext(), "sp_email"))
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            userdetails item = new userdetails();
                            item.setName(document.getString("name"));
                            item.setContact(document.getString("contact"));
                            item.setCourse(document.getString("course"));
                            item.setEmail(document.getString("email"));
                            item.setLang(document.getString("lang"));
                            item.setPercent(document.getString("Marks"));
                            item.setQual(document.getString("qual"));

                            username.setText(item.getName());
                            email.setText(item.getEmail());
                            qualification.setText(item.getQual());
                            contact.setText(item.getContact());
                            course.setText(item.getCourse());
                            lang.setText(item.getLang());
                            percent.setText(item.getPercent());
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UserProfile.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
