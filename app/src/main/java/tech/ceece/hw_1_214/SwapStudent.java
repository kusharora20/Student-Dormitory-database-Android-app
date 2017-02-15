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

public class SwapStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swap_student);

    }

    public void swapStudent(View view){
        Intent returnIntent = new Intent();
        try {
            EditText editText1 = (EditText) findViewById(R.id.editText5);
            String student1_floor = editText1.getText().toString();
            int floor = Integer.parseInt(student1_floor);

            EditText editText2 = (EditText) findViewById(R.id.editText6);
            String student2_floor = editText2.getText().toString();
            int floor2 = Integer.parseInt(student1_floor);

            EditText editText3 = (EditText) findViewById(R.id.editText7);
            String room1 = editText3.getText().toString();
            int spot = Integer.parseInt(room1);

            EditText editText4 = (EditText) findViewById(R.id.editText8);
            String room2 = editText4.getText().toString();
            int spot2 = Integer.parseInt(room2);

            System.out.println("Hello");
            returnIntent.putExtra("spot", spot);
            returnIntent.putExtra("spot2", spot2);
            returnIntent.putExtra("floor", floor);
            returnIntent.putExtra("floor2", floor2);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }catch (Exception ex){
            Toast.makeText(SwapStudent.this, "Wrong input. Please try again later.", Toast.LENGTH_SHORT).show();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
    }

}
