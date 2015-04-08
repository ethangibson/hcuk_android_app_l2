package com.impression11.lesson2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Below is the onclick listener code - you generally won't use this over the XML method
        // Also there's not speed or efficency gain in using either method!

        Button setDetails = (Button) findViewById(R.id.details);
        setDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent = new Intent(getApplicationContext(), details.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "Clicked!", Toast.LENGTH_LONG).show();
            }
        }
        );

        // On long click listener - so if a user presses and holds on a button

        setDetails.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicked Long!", Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }

    public void return_value(View view){
        // Create a new intent object and link it to out get value activity
        Intent intent = new Intent(this, getvalue.class);
        // start the activity for a result - this means we expect to get some variables back once the actitity closes
        // define the request code we need to listen for - in this case 0
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to - we're looking for 0
        if (requestCode == 0) {
            // Check that it sent back okay and wasn't canceled by a back button
            if (resultCode == RESULT_OK) {

            // get the input value from the activity
            String result = data.getStringExtra("result");
            // output that variable to Toast
            Toast.makeText(this,result,Toast.LENGTH_LONG).show();
            }
        }
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
