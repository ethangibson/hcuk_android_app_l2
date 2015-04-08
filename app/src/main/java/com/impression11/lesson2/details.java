package com.impression11.lesson2;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class details extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // if they exist get shared preferences
        SharedPreferences prefs = getSharedPreferences("details", MODE_PRIVATE);

        // get the name, age and number values - if they don't exist they will be set as null, null & 0
        String selected_name = prefs.getString("name", null);
        String selected_number = prefs.getString("number", null);
        int selected_age = prefs.getInt("age", 0);

        // use the values from the shared preferences to fill in out fields
        EditText fullname = (EditText) findViewById(R.id.name);
        fullname.setText(selected_name);

        EditText number = (EditText) findViewById(R.id.number);
        number.setText(selected_number);

        // Spinner is basically a drop down menu - you have to use an adapter to get set the values and it's appearance
        // in this example we're using a string array in out strings.xml file as a data source (R.array.age_array)
        Spinner age = (Spinner) findViewById(R.id.age);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set the spinner with the values from the adapter
        age.setAdapter(adapter);
        // set the position of the spinner using the value from our shared preferences
        age.setSelection(selected_age);


    }

    public void save(View view){
        // if they exist get shared preferences and set it up for editing values
        // if the shared preferences file doesn't exist it will create one for us!
        SharedPreferences.Editor editor = getSharedPreferences("details", MODE_PRIVATE).edit();

        // grab the values in the fields and create a new variable to contain these values
        EditText fullname = (EditText) findViewById(R.id.name);
        String entered_name = fullname.getText().toString();

        EditText number = (EditText) findViewById(R.id.number);
        String entered_number = number.getText().toString();

        Spinner age = (Spinner)findViewById(R.id.age);
        int selected_age = age.getSelectedItemPosition();

        // provisionally put the values into the shared preferences
        editor.putString("name", entered_name);
        editor.putString("number", entered_number);
        editor.putInt("age", selected_age);

        // apply the changes
        editor.apply();

        // close the activity
        finish();

    }

}
