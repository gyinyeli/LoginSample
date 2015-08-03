package com.samsung.loginsample;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
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

    private static final String LOGTAG="Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher);

        //actionBar().setLogo(R.mipmap.ic_launcher);

        setContentView(R.layout.activity_login);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.ic_launcher);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);

//        SetApplicationAttribute(android:icon, "@mipmap/ic_launcher");
        LoginButton();

        Toast msg = Toast.makeText(this, "Login create", Toast.LENGTH_LONG);
        msg.show();

        Log.d(LOGTAG, "onCreate");
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

                            //android.content.Intent intent = new android.content.Intent("com.samsung.loginsample.User");
                            Intent intent = new Intent(Login.this, User.class);

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
        Toast.makeText(this, "You selected " + item.getTitle(), Toast.LENGTH_LONG).show();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        Intent intent=null;
        switch(id) {
            case R.id.action_activity_two:
                intent = new Intent(Login.this, User.class);
                startActivity(intent);
                break;
            case R.id.action_external_url:
                String webpage="http://developer.android.com/index.html";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                startActivity(intent);
                break;
            case R.id.action_send_message:
                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Hello from gang yin for the test");
                intent.setType("text/plain");
                startActivity(intent);
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void gotoActivity(View v){
        Intent intent = new Intent(this, User.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGTAG, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOGTAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOGTAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOGTAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOGTAG, "onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "Landscape!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Portrait!", Toast.LENGTH_LONG).show();

        }
    }

}
