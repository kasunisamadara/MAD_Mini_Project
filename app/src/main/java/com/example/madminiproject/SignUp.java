package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {
    UserDBHelper db;
    EditText uemail, upass, ucpass, uname;
    Button submit, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = new UserDBHelper(this);


        uemail = (EditText) findViewById(R.id.email1);
        upass = (EditText) findViewById(R.id.password3);
        ucpass = (EditText) findViewById(R.id.cpassword);
        uname = findViewById(R.id.editText2);
        submit = (Button) findViewById(R.id.button5);
        login = findViewById(R.id.button6);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = uemail.getText().toString();
                String a2 = upass.getText().toString();
                String a3 = ucpass.getText().toString();
                String a4 = uname.getText().toString();

                if (a1.equals("") || a2.equals("") || a3.equals("") || a4.equals("")) {
                    Toast.makeText(getApplicationContext(), "Feilds are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (a2.equals(a3)) {
                        Boolean checkemail = db.checkemail(a1);
                        if (checkemail == true) {
                            Boolean insert = db.insert(a1, a2, a4);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Rejistered Succuessfully", Toast.LENGTH_SHORT).show();
                            }


                        } else {

                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();
                        }


                    }else
                    Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
            }


        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloging();
            }
        });

    }

    public void openloging() {
        Intent i1;
        i1 = new Intent(this, Login.class);
        startActivity(i1);
    }

}
