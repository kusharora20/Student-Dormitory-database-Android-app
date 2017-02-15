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

public class MoveStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.move_student);

    }

    public void moveStudent(View view){
        Intent returnIntent = new Intent();
        try {
            //Source floor
            EditText editText1 = (EditText) findViewById(R.id.editText9);
            String sourceFloor = editText1.getText().toString();
            int floor = Integer.parseInt(sourceFloor);

            //Source Room
            EditText editText2 = (EditText) findViewById(R.id.editText10);
            String sourceRoom = editText2.getText().toString();
            int room = Integer.parseInt(sourceRoom);

            //Destination Floor
            EditText editText3 = (EditText) findViewById(R.id.editText11);
            String destinationFloor = editText3.getText().toString();
            int destFloor = Integer.parseInt(destinationFloor);

            //Destination Floor
            EditText editText4 = (EditText) findViewById(R.id.editText12);
            String destinationRoom = editText4.getText().toString();
            int destRoom = Integer.parseInt(destinationRoom);

            returnIntent.putExtra("sourceFloor", floor);
            returnIntent.putExtra("sourceRoom", room);
            returnIntent.putExtra("destFloor", destFloor);
            returnIntent.putExtra("destRoom", destRoom);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }catch (Exception ex){
            Toast.makeText(MoveStudent.this, "Wrong input. Please try again later.", Toast.LENGTH_SHORT).show();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }

    }

}
