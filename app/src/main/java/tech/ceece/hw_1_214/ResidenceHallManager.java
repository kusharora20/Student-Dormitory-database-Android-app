package tech.ceece.hw_1_214;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ResidenceHallManager extends AppCompatActivity {
    String choice, name;

    // Floor objects
    Floor floor1 = new Floor();
    Floor floor2 = new Floor();
    Floor floor3 = new Floor();
    Floor[] floor = new Floor[] { floor1, floor2, floor3 };
    int floor_num = 1, spot =0, writeups, floor_num2=1, spot2=0; // Default floor number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence_hall_manager);
        populateListView();
        registerClickCallback();
    }

    private void populateListView() {
        //Create list of items
        String[] myItems =  {"Add Student", "Remove  Student", "Swap Students", "Move Student", "Select Floor", "Copy Floor", "Print Current Floor", "Write Up Student", "Quit"};

        //Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.da_item,myItems){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);

                // Get the Layout Parameters for ListView Current Item View
                LayoutParams params = view.getLayoutParams();

                // Set the height of the Item View
                params.height = 100;
                view.setLayoutParams(params);

                return view;
            }
        };

        //Configure the list view.
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listView);
        final Intent intent = new Intent(this, AddStudent.class);
        final Intent intent2 = new Intent(this, RemoveStudent.class);
        final Intent intent3 = new Intent(this,SwapStudent.class);
        final Intent intent4 = new Intent(this, MoveStudent.class);
        final Intent intent5 = new Intent(this, SelectFloor.class);
        final Intent intent6 = new Intent(this, CopyFloor.class);
        final Intent intent7 = new Intent(this, PrintFloor.class);
        final Intent intent8 = new Intent(this, WriteupStudent.class);

        assert list != null;
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String message;

                if (position == 0) {
                    startActivityForResult(intent, 1);
                } else if(position == 1) {
                    startActivityForResult(intent2, 2);
                } else if(position == 2){
                    startActivityForResult(intent3, 3);
                } else if(position == 3){
                    startActivityForResult(intent4, 4);
                } else if(position == 4){
                    startActivityForResult(intent5, 5);
                } else if(position == 5){
                    startActivityForResult(intent6, 6);
                }else if (position == 6) {
                   /* floor[floor_num - 1].getFloorPrint(floor_num);
                    System.out.println("Size: " + floor[floor_num-1].count());*/
                    System.out.println(floor_num + " floor");
                    intent7.putExtra("floor",floor_num);
                    Statics.toFloor = floor[floor_num-1];
                    startActivityForResult(intent7, 7);
                }else if (position == 7) {
                    startActivityForResult(intent8, 8);
                } else {
                    AlertDialog.Builder a_builder = new AlertDialog.Builder(ResidenceHallManager.this);
                    a_builder.setMessage("Are you sure you want to exit?");
                    a_builder.setCancelable(true);

                    //Positive button
                    a_builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    //Negative button
                    a_builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = a_builder.create();
                    alert.setTitle("Quit");
                    alert.show();
                }
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){

                    name = data.getStringExtra("name");
                    int ID = data.getIntExtra("id",0);
                    spot = data.getIntExtra("spot",0);

                try {
                    // Student object
                    Student student = new Student();
                    student.setName(name);
                    student.setID(ID);
                    floor[floor_num - 1].addStudent(student, spot);
                    Toast.makeText(ResidenceHallManager.this, "Student added.", Toast.LENGTH_SHORT).show();
                } catch (FullFloorException ex) {
                    Toast.makeText(ResidenceHallManager.this, "Floor is full", Toast.LENGTH_SHORT).show();
                } catch (IllegalArgumentException ex) {
                    Toast.makeText(ResidenceHallManager.this, "Invalid spot number", Toast.LENGTH_SHORT).show();
                }
            }
            /*
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }*/
        }else if(requestCode == 2){
            if(resultCode == Activity.RESULT_OK){
                spot = data.getIntExtra("spot",0);
                try{
                    Student student = floor[floor_num-1].removeStudent(spot);
                    Toast.makeText(ResidenceHallManager.this, student.getName() + " has been removed", Toast.LENGTH_SHORT).show();
                }catch(EmptyFloorException ex){
                    Toast.makeText(ResidenceHallManager.this, "The floor is empty!", Toast.LENGTH_SHORT).show();
                }catch(IllegalArgumentException ex){
                    Toast.makeText(ResidenceHallManager.this, "Invalid room number.", Toast.LENGTH_SHORT).show();
                }
            }
        }else if(requestCode == 3){
            if(resultCode == Activity.RESULT_OK){
                //Student 1 and 2 objects
                Student student1 = new Student();
                Student student2 = new Student();

                //Retrieve data from activity
                spot = data.getIntExtra("spot", 0);
                System.out.println("Spot: "+ spot);
                spot2 = data.getIntExtra("spot2", 0);
                System.out.println("Spot2: "+ spot2);
                floor_num = data.getIntExtra("floor", 1);
                System.out.println("Floor: "+ floor_num);
                floor_num2 = data.getIntExtra("floor2",0);
                System.out.println("Floor2: "+ floor_num2);
                try{
                    //Student 1
                    student1 = floor[floor_num-1].getStudent(spot);

                    //Student 2
                    student2 = floor[floor_num2-1].getStudent(spot2);

                    //Swap
                    floor[floor_num2-1].setStudent(student1, spot2);
                    floor[floor_num-1].setStudent(student2, spot);
                    Toast.makeText(ResidenceHallManager.this, "Students swapped.", Toast.LENGTH_SHORT).show();
                }catch(IllegalArgumentException ex){
                    Toast.makeText(ResidenceHallManager.this, "Invalid room number or floor.", Toast.LENGTH_SHORT).show();
                }
            }
        }else if(requestCode == 4){
            if(resultCode == Activity.RESULT_OK){
                //Retrieve data from activity
                floor_num=data.getIntExtra("sourceFloor", 0);
                spot=data.getIntExtra("sourceRoom", 0);
                floor_num2=data.getIntExtra("destFloor",0);
                spot2=data.getIntExtra("destRoom",0);

                Student student3 = new Student(); //Local student object
                student3=floor[floor_num-1].getStudent(spot); //Retrieve the student at specified floor and room

                try {
                    floor[floor_num2-1].addStudent(student3, spot2);
                    floor[floor_num-1].removeStudent(spot);
                    Toast.makeText(ResidenceHallManager.this, "Student moved.", Toast.LENGTH_SHORT).show();
                } catch (IllegalArgumentException e1) {
                    Toast.makeText(ResidenceHallManager.this, "Invalid room number.", Toast.LENGTH_SHORT).show();
                } catch (FullFloorException e1) {
                    Toast.makeText(ResidenceHallManager.this, "Floor is full.", Toast.LENGTH_SHORT).show();
                } catch (EmptyFloorException ex){
                    Toast.makeText(ResidenceHallManager.this, "Floor is empty.", Toast.LENGTH_SHORT).show();
                }
            }

        }else if(requestCode == 5){
            if(resultCode == Activity.RESULT_OK){
                floor_num=data.getIntExtra("floor", 1);
                Toast.makeText(ResidenceHallManager.this, "Floor " + floor_num + " selected.", Toast.LENGTH_SHORT).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(ResidenceHallManager.this, "Invalid floor. Please try again later.", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == 6){
            if(resultCode == Activity.RESULT_OK){
                floor_num2 = data.getIntExtra("destFloor",0);
                floor_num = data.getIntExtra("sourceFloor",0);
                try {
                    floor[floor_num2-1]=(Floor)floor[floor_num-1].clone();
                    Toast.makeText(ResidenceHallManager.this, "Floor " + floor_num2 + " cloned.", Toast.LENGTH_SHORT).show();

                } catch (CloneNotSupportedException e) {
                    Toast.makeText(ResidenceHallManager.this, "Cloning failed.", Toast.LENGTH_SHORT).show();
                }
            }
            if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(ResidenceHallManager.this, "Invalid floor. Please try again later.", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == 7){

        }else if(requestCode == 8){
            if(resultCode == Activity.RESULT_OK){
                //Retrieve data
                name=data.getStringExtra("name");

                //Student object
                Student student = new Student();

                for(int i=0; i<floor[floor_num-1].count();i++){
                    student = floor[floor_num-1].getStudent(i+1);
                    if(name.equals(student.getName())){		//Search for student name
                        writeups=student.getWrite_ups();	//get the current number of writeups
                        writeups++;							//Increment the writeups
                        student.setWrite_ups(writeups);		//Set the new amount
                        spot=i+1;
                        Toast.makeText(ResidenceHallManager.this, student.getName() + " has " + student.getWrite_ups() + " writeup.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                try{
                    if(student.getWrite_ups()==3){
                        floor[floor_num-1].removeStudent(spot);
                        Toast.makeText(ResidenceHallManager.this, name + " has 3 writeups and has been removed from the building.", Toast.LENGTH_SHORT).show();
                    }
                }catch(EmptyFloorException ex){
                    Toast.makeText(ResidenceHallManager.this, "Empty floor", Toast.LENGTH_SHORT).show();
                }catch(IllegalArgumentException ex){
                    Toast.makeText(ResidenceHallManager.this,"Student not found" , Toast.LENGTH_SHORT).show();
                }
            }
        }else if(requestCode == 9){

        }
    }


}
