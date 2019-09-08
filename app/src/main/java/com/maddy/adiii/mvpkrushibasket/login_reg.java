package com.maddy.adiii.mvpkrushibasket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class login_reg extends AppCompatActivity {

    private LinearLayout gotologin;
    private LinearLayout gotoRegister;
    private MaterialButton regBtn;
    private MaterialButton loginBtn;
    private TextInputEditText nameInput;
    private TextView textLog;
    private TextView textReg;
    private TextInputEditText regAddres;
    private TextInputEditText regMobno;
    private FirebaseAuth mAuth;
    private TextInputEditText login_email;
    private TextInputEditText login_pass;
    private DatabaseReference mCustomerDataRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_login_reg);

        getIds();

        mAuth = FirebaseAuth.getInstance();
//        if(mAuth.getCurrentUser() != null){
//            //TODO: Intent to CustomerHomePage
//        }

        mCustomerDataRef = FirebaseDatabase.getInstance().getReference().child("Customer Details");

        //Changing button Bar layout
        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameInput.setVisibility(View.VISIBLE);
                gotoRegister.setBackground(getDrawable(R.drawable.button_styling_right_rev));
                gotologin.setBackground(getDrawable(R.drawable.button_styling_left_rev));
                textLog.setTextColor(getResources().getColor(R.color.greenColor));
                textReg.setTextColor(getResources().getColor(R.color.whiteColor));
                loginBtn.setVisibility(View.INVISIBLE);
                regBtn.setVisibility(View.VISIBLE);
                regAddres.setVisibility(View.VISIBLE);
                regMobno.setVisibility(View.VISIBLE);

            }
        });

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameInput.setVisibility(View.GONE);
                gotologin.setBackground(getDrawable(R.drawable.button_styling_left));
                gotoRegister.setBackground(getDrawable(R.drawable.button_styling_right));
                textLog.setTextColor(getResources().getColor(R.color.whiteColor));
                textReg.setTextColor(getResources().getColor(R.color.greenColor));
                loginBtn.setVisibility(View.VISIBLE);
                regBtn.setVisibility(View.INVISIBLE);
                regAddres.setVisibility(View.GONE);
                regMobno.setVisibility(View.GONE);
            }
        });


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String Remail = login_email.getText().toString();
                final String Rpassword = login_pass.getText().toString();


                if (Remail.isEmpty() || Rpassword.isEmpty()) {
                    show_message("Some thing went wrong");

                } else {
                    createuserAcc(Remail, Rpassword);
                }
            }

        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String Remail = login_email.getText().toString();
                final String Rpassword = login_pass.getText().toString();

                if (Remail.isEmpty() || Rpassword.isEmpty()) {
                    show_message("Some thing went wrong");

                } else {
                    loginuserAcc(Remail, Rpassword);
                }

            }
        });
    }


    private void show_message(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void createuserAcc(String Remail, String Rpassword) {

        mAuth.createUserWithEmailAndPassword(Remail, Rpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String name = nameInput.getText().toString();
                            //TODO: get values and set value i database

                            mCustomerDataRef.child("cName").setValue(name);
                            show_message("Account Created");
                            //TODO: Intent to CustomerHomepAge

                        } else {

                            show_message("Account creation failed" + task.getException().toString());

                        }
                    }
                });
    }

    private void loginuserAcc(String Remail, String Rpassword) {

        mAuth.signInWithEmailAndPassword(Remail, Rpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            show_message("login Success");
                            //TODO: Intent to CustomerHomePage
                        } else {
                            show_message("login failed" + task.getException().toString());
                        }
                    }
                });
    }

    public void getIds() {

        gotologin = (LinearLayout) findViewById(R.id.goto_login);
        gotoRegister = (LinearLayout) findViewById(R.id.gotoregister);
        regBtn = (MaterialButton) findViewById(R.id.regBtn);
        loginBtn = (MaterialButton) findViewById(R.id.loginBtn);
        nameInput = (TextInputEditText) findViewById(R.id.reg_name);
        textLog = (TextView) findViewById(R.id.textLogin);
        textReg = (TextView) findViewById(R.id.textReg);
        regAddres = (TextInputEditText) findViewById(R.id.reg_address);
        regMobno = (TextInputEditText) findViewById(R.id.reg_mobno);

        login_email = (TextInputEditText) findViewById(R.id.login_email);
        login_pass = (TextInputEditText) findViewById(R.id.login_pass);
    }
}


