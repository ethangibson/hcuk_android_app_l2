package com.impression11.lesson2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class getvalue extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getvalue);
    }


    public void sendData(View view){

        // get value input in field
        EditText send = (EditText)findViewById(R.id.send);
        // create an intent for sending back out value in the field
        Intent returnIntent = new Intent();
        // set the variable up for sending back
        returnIntent.putExtra("result", send.getText().toString());
        // send back a result ok status
        setResult(RESULT_OK,returnIntent);
        // close the activity
        finish();

    }

}
