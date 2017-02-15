package tech.ceece.hw_1_214;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class WriteupStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writeup_student);

    }

    public void writeupStudent(View view){
        Intent returnIntent = new Intent();

        //Enter student name
        EditText editText = (EditText) findViewById(R.id.editText16);
        String name = editText.getText().toString();
        returnIntent.putExtra("name", name);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
