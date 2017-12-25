package com.example.yash.chatapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Message messages, m;
    ImageButton send;
    EditText input;
    View.OnClickListener send_listener;
    SharedPreferences message_Store;
    FirebaseDatabase message_Database;
    DatabaseReference message_Ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        message_Database = FirebaseDatabase.getInstance();

        send = (ImageButton) findViewById(R.id.send_Button);
        input =  (EditText) findViewById(R.id.input_editText);

        message_Ref = message_Database.getReference("messages");

        message_Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                m = dataSnapshot.getValue(Message.class);
                //Log.d(Tag, "RETRIEVED");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                m = new Message();
            }
        });

        messages = new Message(m);

        send_listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messages.newMesage(input.getText().toString());
                m = new Message(m);
            }
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Adapter adapter = new Adapter(MainActivity.this, messages);
        recyclerView.setAdapter(adapter);

    }
}
