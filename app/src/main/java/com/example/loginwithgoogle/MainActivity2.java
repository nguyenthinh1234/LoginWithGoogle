package com.example.loginwithgoogle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity2 extends AppCompatActivity {
    TextView tvPersonName, tvGivenName, tvFamilyName, tvEmail, tvID;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvPersonName = findViewById(R.id.personName);
        tvGivenName = findViewById(R.id.personGivenName);
        tvFamilyName = findViewById(R.id.personFamilyName);
        tvEmail = findViewById(R.id.personEmail);
        tvID = findViewById(R.id.personId);
        btnLogout = findViewById(R.id.Logout);

        setData();
        
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    private void signOut() {
      MainActivity.mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                        Toast.makeText(MainActivity2.this, "Logout", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
    private void setData() {
        String personName= (String) getIntent().getExtras().get("personName");
        String personGivenName= (String) getIntent().getExtras().get("personGivenName");
        String personFamilyName= (String) getIntent().getExtras().get("personFamilyName");
        String personEmail= (String) getIntent().getExtras().get("personEmail");
        String personId= (String) getIntent().getExtras().get("personId");
        String url = (String) getIntent().getExtras().get("personPhoto");
      //  Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        tvPersonName.setText(personName);
        tvGivenName.setText(personGivenName);
        tvFamilyName.setText(personFamilyName);
        tvEmail.setText(personEmail);
        tvID.setText(personId);
  //      imgAvatar.setImageResource(url);

    }

}
