package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    int currPos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String text = getIntent().getStringExtra("item");
        currPos  = getIntent().getIntExtra("position", 0);
        EditText etEditItem =  (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(text);
        etEditItem.setSelection(etEditItem.getText().length());


    }


    public void onEditItem(View v) {
        EditText etNewItem =  (EditText) findViewById(R.id.etNewItem);
        String itemText =  etNewItem.getText().toString();
        //itemsAdapter.add(itemText);
        //etNewItem.setText("");
       // writeItems();
    }


    public void onSubmit(View v) {
        EditText etName = (EditText) findViewById(R.id.etEditItem);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("name", etName.getText().toString());
        data.putExtra("position",currPos);
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }

}
