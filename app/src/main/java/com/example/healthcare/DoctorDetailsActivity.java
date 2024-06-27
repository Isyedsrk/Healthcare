package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1  =
            {
                    {"Doctor Name : Dr.Ajit Saste","Hospital Address : Hazratganj", "Exp : 5yrs", "Mobile No:9898989898","600"},
                    {"Doctor Name : Dr.A.K.Das","Hospital Address : Gomti Nagar", "Exp : 15yrs", "Mobile No:6213458974","900"},
                    {"Doctor Name : Dr.Shivam","Hospital Address : Daliganj", "Exp : 8yrs", "Mobile No:9768905437","500"},
                    {"Doctor Name : Dr.Fareed Khan","Hospital Address : Hussainabad", "Exp : 6yrs", "Mobile No:8210934562","700"},
                    {"Doctor Name : Dr.Ashok Pandey","Hospital Address : Vikas Nagar", "Exp : 7yrs", "Mobile No:7433471122","800"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ms.Luna Jaiswal","Hospital Address : Gokhley Marg", "Exp : 19yrs", "Mobile No:9898989898","2000"},
                    {"Doctor Name : Dr.A.K Jain","Hospital Address : Hazratganj", "Exp : 42yrs", "Mobile No:6213458974","610"},
                    {"Doctor Name : Dr.Devandra Singh","Hospital Address : Aalambagh", "Exp : 51yrs", "Mobile No:9768905437","500"},
                    {"Doctor Name : Dr.Ravi Singh ","Hospital Address : Indira Nagar", "Exp : 24yrs", "Mobile No:8210934562","300"},
                    {"Doctor Name : Dr.Imran Ahmad Khan","Hospital Address : Hazratganj", "Exp : 17yrs", "Mobile No:7433471122","300"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr.Ashish Mathur","Hospital Address : Mahanagar", "Exp : 19yrs", "Mobile No:9898989898","500"},
                    {"Doctor Name : Dr.Damini Ramchandani","Hospital Address : Gomti Nagar", "Exp : 14yrs", "Mobile No:6213458974","Free"},
                    {"Doctor Name : Dr.Ankit Bahal","Hospital Address : Ashiyana", "Exp : 21yrs", "Mobile No:9768905437","500"},
                    {"Doctor Name : Dr.Dheerak K","Hospital Address : Krishna Nagar", "Exp : 23yrs", "Mobile No:8210934562","700"},
                    {"Doctor Name : Dr.Rohit Madan","Hospital Address : Gokhley Marg", "Exp : 22yrs", "Mobile No:7433471122","500"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr.Vivek Agarwal","Hospital Address : Puliya Indira Nagar", "Exp : 25yrs", "Mobile No:9898989898","600"},
                    {"Doctor Name : Dr.Naveen","Hospital Address : Vikas Nagar", "Exp : 15yrs", "Mobile No:6213458974","900"},
                    {"Doctor Name : Dr.Mohd Ashraf","Hospital Address : Jankipuram", "Exp : 34yrs", "Mobile No:9768905437","500"},
                    {"Doctor Name : Dr.Mayank Kumar","Hospital Address : Hussainabad", "Exp : 6yrs", "Mobile No:8210934562","700"},
                    {"Doctor Name : Dr.Abhijit Sr","Hospital Address : Vikas Nagar", "Exp : 7yrs", "Mobile No:7433471122","800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr.Rajiv Rastogi","Hospital Address : Chowk", "Exp : 29yrs", "Mobile No:9898989898","500"},
                    {"Doctor Name : Dr.Madhurakar Kapoor","Hospital Address : Golaganj", "Exp : 51yrs", "Mobile No:6213458974","400"},
                    {"Doctor Name : Dr.Amit Chaudhary","Hospital Address : Krishna Nagar", "Exp : 18yrs", "Mobile No:9768905437","500"},
                    {"Doctor Name : Dr.Ajay Bahadur","Hospital Address : LDA Colony ", "Exp : 37yrs", "Mobile No:8210934562","700"},
                    {"Doctor Name : Dr.Lt.Col RP Singh","Hospital Address : Vikas Nagar", "Exp : 20yrs", "Mobile No:7433471122","800"}
            };
    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    ArrayList list;
    ListView lst;
    HashMap<String,String> item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonCartBack);
        lst = findViewById(R.id.listViewDD);
        Intent it = getIntent();
        String title =  it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
            list = new ArrayList();
            for (int i = 0; i<doctor_details.length;i++){
                item = new HashMap<String,String>();
                item.put("line1",doctor_details[i][0]);
                item.put("line2",doctor_details[i][1]);
                item.put("line3",doctor_details[i][2]);
                item.put("line4",doctor_details[i][3]);
                item.put("line5","Cons Fees:" +doctor_details[i][4]+"/-");
                list.add(item);
            }
            sa = new SimpleAdapter(this,list,R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                    );

            lst.setAdapter(sa);

            //when we click on book appointment list of doctors then it shows book appointment activity
            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it = new Intent(DoctorDetailsActivity.this,BookApointmentActivity.class);
                    it.putExtra("text1",title);
                    it.putExtra("text2",doctor_details[i][0]);
                    it.putExtra("text3",doctor_details[i][1]);
                    it.putExtra("text4",doctor_details[i][3]);
                    it.putExtra("text5",doctor_details[i][4]);
                    startActivity(it);
                }
            });


    }
}