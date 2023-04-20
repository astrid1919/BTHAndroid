package com.example.baithuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baithuchanh.model.Work;
import com.google.android.material.badge.BadgeUtils;

public class AddWorkActivity extends AppCompatActivity {
    private EditText eName,eDes,eStatus;
    private CheckBox collab;
    private Button bt;
    private Database db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);
        eName = findViewById(R.id.eName);
        eDes = findViewById(R.id.eDes);
        eStatus = findViewById(R.id.eStatus);
        collab = findViewById(R.id.check);
        bt = findViewById(R.id.bt);
        db = new Database(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eName.getText().toString().isEmpty() || eDes.getText().toString().isEmpty() || eStatus.getText().toString().isEmpty())
                    Toast.makeText(AddWorkActivity.this, "Please fill all the blanks", Toast.LENGTH_SHORT).show();
                else {
                    Work w = new Work(eName.getText().toString(), eDes.getText().toString(), eStatus.getText().toString(), collab.isChecked());
                    db.insertWork(w);
                    Toast.makeText(AddWorkActivity.this, "Add Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddWorkActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}