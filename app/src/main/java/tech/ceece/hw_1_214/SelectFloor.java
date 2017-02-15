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

public class SelectFloor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_floor);

    }

    public void selectFloor(View view){
        Intent returnIntent = new Intent();

        try{
            EditText editText = (EditText) findViewById(R.id.editText13);
            String sourcefloor = editText.getText().toString();
            int floor = Integer.parseInt(sourcefloor);
            if(floor>=1 && floor <=3) {
                returnIntent.putExtra("floor", floor);
                setResult(Activity.RESULT_OK, returnIntent);
            }else{
                setResult(Activity.RESULT_CANCELED, returnIntent);
            }
            finish();
        }catch(Exception ex){
            Toast.makeText(SelectFloor.this, "Invalid input.", Toast.LENGTH_SHORT).show();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();

        }
    }

}
