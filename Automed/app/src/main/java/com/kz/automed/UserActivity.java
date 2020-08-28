package com.kz.automed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

                    EditText pname, page, pdisease, gno;
                    Button btnsave;
                    DatabaseReference dbref;
                    Member member;
                    int patientid = 0;

 /*
  FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbref = database.getReference();
   /* myRef.setValue("Hello, World!");*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        /*

                EditText pname, page, pdisease, gno;
                Button btnsave;
                DatabaseReference dbref;
                Member member;
                long patientid = 0;

              /*  setContentView(R.layout.activity_patient); */

                pname = (EditText)findViewById(R.id.pname);
                page = (EditText)findViewById(R.id.page);
                pdisease = (EditText)findViewById(R.id.pdisease);
                gno = (EditText)findViewById(R.id.gno);

                btnsave = (Button)findViewById(R.id.btnsave);

                member = new Member();

               dbref = FirebaseDatabase.getInstance().getReference().child("Patient");
                dbref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.exists())
                            patientid= (int) dataSnapshot.getChildrenCount();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                btnsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                      String patient_name = pname.getText().toString();
                      int patient_age = Integer.parseInt(page.getText().toString());
                      String patient_disease = pdisease.getText().toString();
                     int patient_gno = Integer.parseInt(gno.getText().toString());

                        member.setPateint_name(pname.getText().toString());
                        member.setPatient_age(patient_age);
                        member.setPatient_diseae(pdisease.getText().toString());
                        member.setPatient_gno(patient_gno);
                        //myRef.push().setValue(member);
                        dbref.child(String.valueOf(patientid+1)).setValue(member);

                        Toast.makeText(UserActivity.this, "Patient registered Successfully",Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(new Intent(UserActivity.this, ActivityMedicine.class));


            }
        });



    }

}
