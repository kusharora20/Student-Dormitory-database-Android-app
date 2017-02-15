package tech.ceece.hw_1_214;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import java.util.InputMismatchException;

public class AddStudent extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);

    }

    public void saveData(View view){
        Intent returnIntent = new Intent();
        try {
            EditText editText1 = (EditText) findViewById(R.id.editText);
            String name = editText1.getText().toString();
            EditText editText2 = (EditText) findViewById(R.id.editText2);
            String Id = editText2.getText().toString();
            int ID = Integer.parseInt(Id);
            EditText editText3 = (EditText) findViewById(R.id.editText3);
            String position = editText3.getText().toString();
            int spot = Integer.parseInt(position);
            System.out.println("Hello");
            returnIntent.putExtra("name", name);
            returnIntent.putExtra("id", ID);
            returnIntent.putExtra("spot", spot);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
            //onBackPressed();

        }catch(InputMismatchException | IllegalStateException ex){
            Toast.makeText(AddStudent.this, "Wrong input detected.", Toast.LENGTH_SHORT).show();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }catch (Exception ex){
            Toast.makeText(AddStudent.this, "Error. Please try again later", Toast.LENGTH_SHORT).show();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
    }

}
