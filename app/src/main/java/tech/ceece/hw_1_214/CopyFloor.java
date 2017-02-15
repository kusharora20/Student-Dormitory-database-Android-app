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

public class CopyFloor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.copy_floor);

    }

    public void copyFloor(View view){
        Intent returnIntent = new Intent();

        try{
            //Source Floor
            EditText editText = (EditText) findViewById(R.id.editText14);
            String sourceFloor = editText.getText().toString();
            int floor = Integer.parseInt(sourceFloor);

            //Destination floor
            EditText editText1 = (EditText) findViewById(R.id.editText15);
            String destFloor = editText1.getText().toString();
            int dest_floor = Integer.parseInt(destFloor);

            if(floor >=1 && floor <=3 && dest_floor >= 1 &&dest_floor <= 3){
                returnIntent.putExtra("sourceFloor",floor);
                returnIntent.putExtra("destFloor", dest_floor);
                setResult(Activity.RESULT_OK, returnIntent);
            }else{
                setResult(Activity.RESULT_CANCELED,returnIntent);
            }
            finish();
        }catch(Exception ex){
            Toast.makeText(CopyFloor.this, "Invalid input. Please try again later.", Toast.LENGTH_SHORT).show();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
    }
}
