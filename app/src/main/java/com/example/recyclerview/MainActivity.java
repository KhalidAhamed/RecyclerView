package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerContactAdapter adapter;
    ArrayList<Contact_Model> arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton Actionbtn = findViewById(R.id.flbtn);

        Actionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.add_update_layout);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.acbtn);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "",number = "";

                        if(!edtName.getText().toString().equals("") && !edtNumber.getText().toString().equals("")){
                            name = edtName.getText().toString();
                            number = edtNumber.getText().toString();

                            arrContacts.add(new Contact_Model(name,number));
                            adapter.notifyItemInserted(arrContacts.size()-1);
                            recyclerView.scrollToPosition(arrContacts.size()-1);

                            dialog.dismiss();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Fill to add", Toast.LENGTH_SHORT).show();
                        }






                    }
                });
                dialog.show();
            }

        });






        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 1","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 2","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 3","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 4","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 5","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 6","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 7","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 8","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 9","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 10","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 11","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 12","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 13","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 14","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 15","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 16","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 17","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 18","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 20","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 21","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 22","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 23","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 24","987654321"));
        arrContacts.add(new Contact_Model(R.drawable.contact,"Name 25","987654321"));

         adapter = new RecyclerContactAdapter(this,arrContacts);

        recyclerView.setAdapter(adapter);






    }
}