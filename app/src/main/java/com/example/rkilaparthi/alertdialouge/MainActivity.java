package com.example.rkilaparthi.alertdialouge;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final private static int DIALOG_LOGIN = 1;
    Button b1,b,b33;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b = (Button) findViewById(R.id.button12);
        b33 = (Button) findViewById(R.id.button33);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_LOGIN);

            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog dialogDetails = null;

        switch (id) {
            case DIALOG_LOGIN:
                LayoutInflater inflater = LayoutInflater.from(this);
                View dialogview = inflater.inflate(R.layout.sample, null);
                AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);
                dialogbuilder.setTitle(R.string.app);
                dialogbuilder.setView(dialogview);
                dialogDetails = dialogbuilder.create();
                break;
        }
        return dialogDetails;
    }
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {

        switch (id) {
            case DIALOG_LOGIN:
                final AlertDialog alertDialog = (AlertDialog) dialog;
                Button b2 = (Button) alertDialog
                        .findViewById(R.id.button2);
                Button b3 = (Button) alertDialog
                        .findViewById(R.id.button3);
                final EditText userName = (EditText) alertDialog
                        .findViewById(R.id.edit1);
                final EditText password = (EditText) alertDialog
                        .findViewById(R.id.edit2);

                b2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
      Toast.makeText(MainActivity.this,"First Name : " + userName.getText().toString()+" " + "Last Name :"+ password.getText().toString(),
                        Toast.LENGTH_LONG).show();
                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                break;
        }
    }
        public void toast(View view) {
            LayoutInflater li = getLayoutInflater();
            View layout = li.inflate(R.layout.customtoast,
                    (ViewGroup) findViewById(R.id.custom_toast_layout));

            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setView(layout);
            toast.show();
        }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure,You wanted to make decision");

        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
            public void fragment(View view) {
                if (view == b33) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Demo()).commit();
                }

    }
}

