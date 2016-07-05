package tushar_admin.kiit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by 1305108 on 17-10-2015.
 */
public class cgpatracker extends ActionBarActivity {
    private Toolbar toolbar;
    Spinner bselect,sselect;
    EditText currcgpa,reqcgpa,result;
    Button b1;
    int i,credits;
    float sumcurr=0,sumreq=0,diff,res;
    int civil[]={25,26,29,29,26,26,26,18};
    int csit[]={25,26,27,27,25,25,27,18};

    int elec[]={25,26,27,26,27,26,25,21};
    int etc[]={26,25,27,26,26,25,27,21};
    int eee[]={26,25,28,27,27,25,26,21};
    int ei[]={26,25,27,27,27,26,25,21};
    int mechauto[]={26,25,29,28,28,28,22,18};
    String[] br={"Civil","Computer Science","IT","Electrical","ETC","EEE","E&I","Mech(Auto)","Mechanical"};
    String[] s={"1","2","3","4","5","6","7"};

    String b;
    int sem;
    private int backCount;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgpatracker);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment frag = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        frag.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        bselect=(Spinner)findViewById(R.id.bselect);
        sselect=(Spinner)findViewById(R.id.sselect);
        b1=(Button)findViewById(R.id.get1);

        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,br);
        ArrayAdapter<String> ad2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,s);
        bselect.setAdapter(ad1);
        sselect.setAdapter(ad2);

        bselect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                b = bselect.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sselect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sem=Integer.parseInt(sselect.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currcgpa=(EditText)findViewById(R.id.currcgpa);
                reqcgpa=(EditText)findViewById(R.id.reqcgpa);
                result=(EditText)findViewById(R.id.result);
                float curr=Float.valueOf(currcgpa.getText().toString());
                float req= Float.valueOf(reqcgpa.getText().toString());
                sumcurr=0;sumreq=0;
                if(b=="Civil") {
                    for (i = 0; i < sem; i++) {
                        sumcurr = sumcurr + civil[i];
                        sumreq = sumcurr;
                    }
                    credits=civil[i];
                    sumreq = sumreq + civil[i];
                }
                if(b=="Computer Science" || b=="IT") {
                    for (i = 0; i < sem; i++) {
                        sumcurr = sumcurr + csit[i];
                        sumreq = sumcurr;
                    }
                    credits=csit[i];
                    sumreq = sumreq + csit[i];
                }

                if(b=="Electrical") {
                    for (i = 0; i < sem; i++) {
                        sumcurr = sumcurr + elec[i];
                        sumreq = sumcurr;
                    }
                    credits=elec[i];
                    sumreq = sumreq + elec[i];
                }

                if(b=="ETC") {
                    for (i = 0; i < sem; i++) {
                        sumcurr = sumcurr + etc[i];
                        sumreq = sumcurr;
                    }
                    credits=etc[i];
                    sumreq = sumreq + etc[i];
                }

                if(b=="EEE") {
                    for (i = 0; i < sem; i++) {
                        sumcurr = sumcurr + eee[i];
                        sumreq = sumcurr;
                    }
                    credits=eee[i];
                    sumreq = sumreq + eee[i];
                }

                if(b=="E&I") {
                    for (i = 0; i < sem; i++) {
                        sumcurr = sumcurr + ei[i];
                        sumreq = sumcurr;
                    }
                    credits=ei[i];
                    sumreq = sumreq + ei[i];
                }

                if(b=="Mech(Auto)" || b=="Mechanical"){
                    for(i=0;i<sem;i++){
                        sumcurr=sumcurr+mechauto[i];
                        sumreq=sumcurr;
                    }
                    credits=mechauto[i];
                    sumreq=sumreq+mechauto[i];
                }


                sumcurr=sumcurr*curr;
                sumreq=sumreq*req;
                if(sumcurr > sumreq)
                    diff=sumcurr-sumreq;
                else
                    diff=sumreq-sumcurr;

                res=(float)diff/credits;
                result.setText(""+res);
                Toast.makeText(cgpatracker.this, res + "",Toast.LENGTH_LONG).show();


            }
        });



    }
    @Override
    public void onBackPressed()
    {
        if(backCount == 2)
        {
            Toast.makeText(getBaseContext(), "press again to exit", Toast.LENGTH_SHORT).show();
            backCount = 0;
            new T().start();
        }
        else if(backCount == 0)
        {
            super.onBackPressed();
        }
    }
    class T extends Thread
    {

        @Override
        public void run() {
            try {
                sleep(3000);// the flag will expire in three seconds
                backCount = 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
