package com.kz.automed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityMedicine extends AppCompatActivity {

    EditText mname, dosg, mtime, mday;
    Button btnaddmr, btnsbmt, btnvew;
    DatabaseReference dbref;
    Medicines medicines;
    int medicineid = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_medicine);

        mname = (EditText) findViewById(R.id.mname);
        dosg = (EditText) findViewById(R.id.dosg);
        mtime = (EditText) findViewById(R.id.mtime);
        mday = (EditText) findViewById(R.id.mday);

        btnaddmr = (Button) findViewById(R.id.btnaddmr);
        btnsbmt = (Button) findViewById(R.id.btnsbmt);



        medicines = new Medicines();

        dbref = FirebaseDatabase.getInstance().getReference().child("Patient").child("Medicines");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                    medicineid = (int) dataSnapshot.getChildrenCount();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btnsbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String medicine_name = mname.getText().toString().trim();
                String medicine_day = mname.getText().toString().trim();
                String medicne_time = mtime.getText().toString().trim();
                String medicne_doasge = dosg.getText().toString().trim();

              /*  int patient_age = Integer.parseInt(page.getText().toString().trim());
                int patient_gno = Integer.parseInt(gno.getText().toString().trim());  */

                medicines.setMedicne_name(mname.getText().toString().trim());
                medicines.setMedicne_dosage(dosg.getText().toString().trim());
                medicines.setMedicne_time(mtime.getText().toString().trim());
                medicines.setPatient_day(mday.getText().toString().trim());

                dbref.child(String.valueOf(medicineid + 1)).setValue(medicines);

                Toast.makeText(ActivityMedicine.this, "Medicine Addeed Successfully", Toast.LENGTH_LONG).show();

                finish();
                Intent I = new Intent(ActivityMedicine.this, ActivityResult.class);
                startActivity(I);


            }
        });

        btnaddmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String medicine_name = mname.getText().toString();
                String medicine_day = mname.getText().toString();
                String medicne_time = mtime.getText().toString();
                String medicne_doasge = dosg.getText().toString();

              /*  int patient_age = Integer.parseInt(page.getText().toString().trim());
                int patient_gno = Integer.parseInt(gno.getText().toString().trim());  */

                medicines.setMedicne_name(mname.getText().toString());
                medicines.setMedicne_dosage(dosg.getText().toString());
                medicines.setMedicne_time(mtime.getText().toString());
                medicines.setPatient_day(mday.getText().toString());

                dbref.child(String.valueOf(medicineid + 1)).setValue(medicines);

                Toast.makeText(ActivityMedicine.this, "Medicine Addeed Successfully", Toast.LENGTH_LONG).show();


                Intent I = new Intent(ActivityMedicine.this, ActivityMedicine.class);
                startActivity(I);
            }
        });



    }
    }