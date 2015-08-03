package com.samsung.loginsample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class User extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_user, menu);
        //return true;
        MenuItem item = menu.add(R.string.external_url);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String webpage="http://developer.android.com/index.html";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                startActivity(intent);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
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

        //if(id==R.id.home){
            //finish();
        //}

        return super.onOptionsItemSelected(item);
    }

    public void implicitViewURL(View v){
        String webpage="http://developer.android.com/index.html";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
        startActivity(intent);
    }

    public void implicitSendText(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Hello from gang yin for the test");
        intent.setType("text/plain");
        startActivity(intent);
    }
}
