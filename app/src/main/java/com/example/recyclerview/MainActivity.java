package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact_Model> arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContacts);

        recyclerView.setAdapter(adapter);






    }
}