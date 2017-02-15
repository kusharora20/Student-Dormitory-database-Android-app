package tech.ceece.hw_1_214;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PrintFloor extends AppCompatActivity {
    int floor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.print_floor);

        Intent intent = getIntent();
        floor = intent.getIntExtra("floor",1);

        String printfloor = printMessage();
        TextView textView = new TextView(this);
        textView.setTextSize(12);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setText(printfloor);

        ViewGroup layout = (ViewGroup) findViewById(R.id.print_floor);
        layout.addView(textView);
    }

    public String printMessage() {
        String printfloor = "Floor " + floor + ":\n";
        printfloor += String.format("%s%12s%12s%15s", "Room", "Name", "ID", "Writeups");
        for (int i = 1; i <= Statics.toFloor.count(); i++) {
            printfloor += String.format("\n%d%20.20s%15d%5d",(i),Statics.toFloor.getStudent(i).getName(),Statics
            .toFloor.getStudent(i).getID(),Statics.toFloor.getStudent(i).getWrite_ups());//Statics.toFloor.
            //printfloor += "\n" + (i) + "   " + Statics.toFloor.getStudent(i).getName();
        }
        System.out.println(printfloor);
        return printfloor;
    }
}
