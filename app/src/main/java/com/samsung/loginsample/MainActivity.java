package com.samsung.loginsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.new_layout);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for(int i = 0; i < 3; i++){
            Button button = new Button(this);
            button.setText(R.string.click_me);
            layout.addView(button);
        }

        Toast msg = Toast.makeText(this,"MainActivity created", Toast.LENGTH_LONG);
        msg.show();

        /*
        List<Flower> flowers = new FlowerData().getFlowers();
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for ( final Flower flower : flowers){
            Button button = new Button(this);
            button.setText(flower.flowerName);
            layout.addView(button);

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("flowerName", flower.flowerName);
                    intent.putExtra("imageResource", flower.imageResource);
                    intent.putExtra("instructions", flower.instructions);
                    startActivity(intent);
                }
            });
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Toast.makeText(this, "You selected \"" + item.getTitle()+"\"", Toast.LENGTH_LONG).show();

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
