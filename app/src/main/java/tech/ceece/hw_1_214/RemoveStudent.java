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
import android.widget.Toast;

import java.util.InputMismatchException;

public class RemoveStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_student);

    }

    public void removeStudent(View view){
        Intent returnIntent = new Intent();
        try {
            EditText editText1 = (EditText) findViewById(R.id.editText4);
            String position = editText1.getText().toString();
            int spot = Integer.parseInt(position);
            System.out.println("Hello");
            returnIntent.putExtra("spot", spot);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
            //onBackPressed();

        }catch (Exception ex){
            Toast.makeText(RemoveStudent.this, "Wrong input. Please try again later.", Toast.LENGTH_SHORT).show();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
    }

}
