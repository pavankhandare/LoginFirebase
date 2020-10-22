package com.example.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUser extends AppCompatActivity {

    EditText stdroll, stdname, stdemail, stdpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);
    }
    public void process(View view) {

        stdroll = (EditText)findViewById(R.id.roll);
        stdname = (EditText)findViewById(R.id.name);
        stdemail = (EditText)findViewById(R.id.email);
        stdpass = (EditText)findViewById(R.id.password);

        String roll = stdroll.getText().toString();
        String name = stdname.getText().toString();
        String email = stdemail.getText().toString();
        String pass = stdpass.getText().toString();

        DataHolder dataHolder = new DataHolder(name,email,pass);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference node = database.getReference("users");
        node.child(roll).setValue(dataHolder);

        stdroll.setText("");
        stdname.setText("");
        stdemail.setText("");
        stdpass.setText("");

        Toast.makeText(getApplicationContext(),"User Successfully Created....!",Toast.LENGTH_SHORT).show();
    }
}