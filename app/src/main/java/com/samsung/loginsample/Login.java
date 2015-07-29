package com.samsung.loginsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends ActionBarActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button  login_btn;
    int attemp_counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    public void LoginButton() {
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        attempts = (TextView)findViewById(R.id.textView_attempts_count);

        login_btn = (Button)findViewById(R.id.button_login);
        attempts.setText(Integer.toString(attemp_counter));

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("gang.yin") && password.getText().toString().equals("gang.yin")) {
                            Toast.makeText(Login.this, "user and password is correct", Toast.LENGTH_SHORT).show();
                            android.content.Intent intent = new android.content.Intent("com.samsung.loginsample.User");
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "user and password is not correct", Toast.LENGTH_SHORT).show();
                            attemp_counter--;
                            attempts.setText(Integer.toString(attemp_counter));
                            if (attemp_counter == 0) {
                                login_btn.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
