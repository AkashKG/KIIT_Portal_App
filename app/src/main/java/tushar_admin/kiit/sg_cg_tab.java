package tushar_admin.kiit;

/**
 * Created by 1305381 on 18-10-2015.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class sg_cg_tab extends ActionBarActivity {

    private Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    private int backCount;

    //private NavigationDrawerFragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        mPager = (ViewPager) findViewById(R.id.pager);
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment frag = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        frag.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs.setDistributeEvenly(true);
        mTabs.setViewPager(mPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(sg_cg_tab.this, "SETTINGS...", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] tabs;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public Fragment getItem(int position) {
            Fragment myFragment = null;
            if (position == 0) {
                myFragment = MyFragment.getInstance(position);

            }
            if (position == 1) {
                myFragment = FragmentB.getInstance(position);

            }
            return myFragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    public static class MyFragment extends Fragment {
        //private TextView tv1;
        float sgpa = 0.0f;
        String g1, g2, g3, g4, g5, g6, g7, g8;
        TextView sgres;
        Button res;
        Spinner s1, s2, s3, s4, s5, s6, s7, s8;
        float result;
        String[] grades = {"O", "E", "A", "B", "C", "D", "F"};

        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);
            return myFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.sgpa, container, false);
            //tv1 = (TextView)layout.findViewById(R.id.cgpa);
            res = (Button) layout.findViewById(R.id.get1);
            sgres = (TextView) layout.findViewById(R.id.cgpa);
            s1 = (Spinner) layout.findViewById(R.id.g1);
            s2 = (Spinner) layout.findViewById(R.id.g2);
            s3 = (Spinner) layout.findViewById(R.id.g3);
            s4 = (Spinner) layout.findViewById(R.id.g4);
            s5 = (Spinner) layout.findViewById(R.id.g5);
            s6 = (Spinner) layout.findViewById(R.id.g6);
            s7 = (Spinner) layout.findViewById(R.id.g7);
            s8 = (Spinner) layout.findViewById(R.id.g8);
            /*Bundle bundle = getArguments();
            if(bundle!=null)
            {
                tv1.setText("PAGE :"+bundle.getInt("position"));
            }*/
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (getActivity(), android.R.layout.simple_spinner_dropdown_item, grades);

            s1.setAdapter(adapter);
            s2.setAdapter(adapter);
            s3.setAdapter(adapter);
            s4.setAdapter(adapter);
            s5.setAdapter(adapter);
            s6.setAdapter(adapter);
            s7.setAdapter(adapter);
            s8.setAdapter(adapter);
            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g1 = s1.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    g1 = s1.getSelectedItem().toString();
                }
            });


            s2.setAdapter(adapter);
            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g2 = s2.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    g2 = s2.getSelectedItem().toString();
                }
            });


            s3.setAdapter(adapter);
            s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g3 = s3.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    g3 = s3.getSelectedItem().toString();
                }
            });


            s4.setAdapter(adapter);
            s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g4 = s4.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    g4 = s4.getSelectedItem().toString();
                }
            });


            s5.setAdapter(adapter);
            s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g5 = s5.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    g5 = s5.getSelectedItem().toString();
                }
            });

            s6.setAdapter(adapter);
            s6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g6 = s6.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    g6 = s6.getSelectedItem().toString();
                }
            });


            s7.setAdapter(adapter);
            s7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g7 = s7.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    g7 = s7.getSelectedItem().toString();
                }
            });


            s8.setAdapter(adapter);
            s8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g8 = s8.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    g8 = s8.getSelectedItem().toString();
                }
            });


            res.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sgpa = compute(g1, 4, 0);
                    sgpa = compute(g2, 4, sgpa);
                    sgpa = compute(g3, 4, sgpa);
                    sgpa = compute(g4, 4, sgpa);
                    sgpa = compute(g5, 4, sgpa);
                    sgpa = compute(g6, 2, sgpa);
                    sgpa = compute(g7, 2, sgpa);
                    sgpa = compute(g8, 1, sgpa);
                    result = (float) (sgpa / 25.0);
                    sgres.setText("" + result);
                    Toast.makeText(getActivity(), result + "", Toast.LENGTH_LONG).show();

                }
            });
            return layout;
        }

        public float compute(String g, int credit, float sgpa) {
            char grade = g.charAt(0);
            switch (grade) {
                case 'O':
                    sgpa = sgpa + (credit * 10);
                    break;
                case 'E':
                    sgpa = sgpa + (credit * 9);
                    break;
                case 'A':
                    sgpa = sgpa + (credit * 8);
                    break;
                case 'B':
                    sgpa = sgpa + (credit * 7);
                    break;
                case 'C':
                    sgpa = sgpa + (credit * 6);
                    break;
                case 'D':
                    sgpa = sgpa + (credit * 5);
                    break;
                case 'F':
                    sgpa = sgpa + (credit * 2);

            }
            return sgpa;
        }
    }

    public static class FragmentB extends Fragment {
        //private TextView tv1;
        public String b;
        public int sem;
        public Spinner sp1, sp2;
        public EditText sg, prevcgpa;
        TextView setcgpa;
        public float result, sumpoints;
        int civil[] = {25, 26, 29, 29, 26, 26, 26, 18};
        int csit[] = {25, 26, 27, 27, 25, 25, 27, 18};

        int elec[] = {25, 26, 27, 26, 27, 26, 25, 21};
        int etc[] = {26, 25, 27, 26, 26, 25, 27, 21};
        int eee[] = {26, 25, 28, 27, 27, 25, 26, 21};
        int ei[] = {26, 25, 27, 27, 27, 26, 25, 21};
        int mechauto[] = {26, 25, 29, 28, 28, 28, 22, 18};


        public static FragmentB getInstance(int position) {
            FragmentB myFragment = new FragmentB();
            Bundle args = new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);
            return myFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.cgpaest, container, false);
            /*tv1 = (TextView)layout.findViewById(R.id.cgpa);
            Bundle bundle = getArguments();
            if(bundle!=null)
            {
                tv1.setText("PAGE :"+bundle.getInt("position"));
            }*/

            String[] br = {"Civil", "Computer Science", "IT", "Electrical", "ETC", "EEE", "E&I", "Mech(Auto)", "Mechanical"};
            String[] s = {"1", "2", "3", "4", "5", "6", "7", "8"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (getActivity(), android.R.layout.simple_spinner_dropdown_item, br);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                    (getActivity(), android.R.layout.simple_spinner_dropdown_item, s);
            sp1 = (Spinner) layout.findViewById(R.id.bselect);
            sp1.setAdapter(adapter);

            sp2 = (Spinner) layout.findViewById(R.id.sselect);
            sp2.setAdapter(adapter1);

            sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    b = sp1.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    sem = Integer.parseInt(sp2.getSelectedItem().toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            sg = (EditText) layout.findViewById(R.id.sgpa);
            prevcgpa = (EditText) layout.findViewById(R.id.cgpa);
            setcgpa = (TextView) layout.findViewById(R.id.setcgpa);

            Button b1 = (Button) layout.findViewById(R.id.get1);


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    float sgpa = Float.valueOf(sg.getText().toString());
                    float pcgpa = Float.valueOf(prevcgpa.getText().toString());
                    if (b == "Civil") {
                        switch (sem) {
                            case 1:
                                result = sgpa;
                                break;
                            case 2:
                                sumpoints = pcgpa * (civil[0]) + sgpa * civil[1];
                                result = (sumpoints) / (civil[0] + civil[1]);
                                break;

                            case 3:
                                sumpoints = pcgpa * (civil[0] + civil[1]) + sgpa * civil[2];
                                result = (sumpoints) / (civil[0] + civil[1] + civil[2]);
                                break;

                            case 4:
                                sumpoints = pcgpa * (civil[0] + civil[1] + civil[2]) + sgpa * civil[3];
                                result = (sumpoints) / (civil[0] + civil[1] + civil[2] + civil[3]);
                                break;

                            case 5:
                                sumpoints = pcgpa * (civil[0] + civil[1] + civil[2] + civil[3]) + sgpa * civil[4];
                                result = (sumpoints) / (civil[0] + civil[1] + civil[2] + civil[3] + civil[4]);
                                break;

                            case 6:
                                sumpoints = pcgpa * (civil[0] + civil[1] + civil[2] + civil[3] + civil[4]) + sgpa * civil[5];
                                result = (sumpoints) / (civil[0] + civil[1] + civil[2] + civil[3] + civil[4] + civil[5]);
                                break;

                            case 7:
                                sumpoints = pcgpa * (civil[0] + civil[1] + civil[2] + civil[3] + civil[4] + civil[5]) + sgpa * civil[6];
                                result = (sumpoints) / (civil[0] + civil[1] + civil[2] + civil[3] + civil[4] + civil[5] + civil[6]);
                                break;

                            case 8:
                                sumpoints = pcgpa * (civil[0] + civil[1] + civil[2] + civil[3] + civil[4] + civil[5] + civil[6]) + sgpa * civil[7];
                                result = (sumpoints) / (civil[0] + civil[1] + civil[2] + civil[3] + civil[4] + civil[5] + civil[6] + civil[7]);
                                break;

                        }

                    }
                    if (b == "Computer Science" || b == "IT") {
                        switch (sem) {
                            case 1:
                                result = sgpa;
                                break;
                            case 2:
                                sumpoints = pcgpa * (csit[0]) + sgpa * csit[1];
                                result = (sumpoints) / (csit[0] + csit[1]);
                                break;

                            case 3:
                                sumpoints = pcgpa * (csit[0] + csit[1]) + sgpa * csit[2];
                                result = (sumpoints) / (csit[0] + csit[1] + csit[2]);
                                break;

                            case 4:
                                sumpoints = pcgpa * (csit[0] + csit[1] + csit[2]) + sgpa * csit[3];
                                result = (sumpoints) / (csit[0] + csit[1] + csit[2] + csit[3]);
                                break;

                            case 5:
                                sumpoints = pcgpa * (csit[0] + csit[1] + csit[2] + csit[3]) + sgpa * csit[4];
                                result = (sumpoints) / (csit[0] + csit[1] + csit[2] + csit[3] + csit[4]);
                                break;

                            case 6:
                                sumpoints = pcgpa * (csit[0] + csit[1] + csit[2] + csit[3] + csit[4]) + sgpa * csit[5];
                                result = (sumpoints) / (csit[0] + csit[1] + csit[2] + csit[3] + csit[4] + csit[5]);
                                break;

                            case 7:
                                sumpoints = pcgpa * (csit[0] + csit[1] + csit[2] + csit[3] + csit[4] + csit[5]) + sgpa * csit[6];
                                result = (sumpoints) / (csit[0] + csit[1] + csit[2] + csit[3] + csit[4] + csit[5] + csit[6]);
                                break;

                            case 8:
                                sumpoints = pcgpa * (csit[0] + csit[1] + csit[2] + csit[3] + csit[4] + csit[5] + csit[6]) + sgpa * csit[7];
                                result = (sumpoints) / (csit[0] + csit[1] + csit[2] + csit[3] + csit[4] + csit[5] + csit[6] + csit[7]);
                                break;

                        }

                    }
                    if (b == "Electrical") {
                        switch (sem) {
                            case 1:
                                result = sgpa;
                                break;
                            case 2:
                                sumpoints = pcgpa * (elec[0]) + sgpa * elec[1];
                                result = (sumpoints) / (elec[0] + elec[1]);
                                break;

                            case 3:
                                sumpoints = pcgpa * (elec[0] + elec[1]) + sgpa * elec[2];
                                result = (sumpoints) / (elec[0] + elec[1] + elec[2]);
                                break;

                            case 4:
                                sumpoints = pcgpa * (elec[0] + elec[1] + elec[2]) + sgpa * elec[3];
                                result = (sumpoints) / (elec[0] + elec[1] + elec[2] + elec[3]);
                                break;

                            case 5:
                                sumpoints = pcgpa * (elec[0] + elec[1] + elec[2] + elec[3]) + sgpa * elec[4];
                                result = (sumpoints) / (elec[0] + elec[1] + elec[2] + elec[3] + elec[4]);
                                break;

                            case 6:
                                sumpoints = pcgpa * (elec[0] + elec[1] + elec[2] + elec[3] + elec[4]) + sgpa * elec[5];
                                result = (sumpoints) / (elec[0] + elec[1] + elec[2] + elec[3] + elec[4] + elec[5]);
                                break;

                            case 7:
                                sumpoints = pcgpa * (elec[0] + elec[1] + elec[2] + elec[3] + elec[4] + elec[5]) + sgpa * elec[6];
                                result = (sumpoints) / (elec[0] + elec[1] + elec[2] + elec[3] + elec[4] + elec[5] + elec[6]);
                                break;

                            case 8:
                                sumpoints = pcgpa * (elec[0] + elec[1] + elec[2] + elec[3] + elec[4] + elec[5] + elec[6]) + sgpa * elec[7];
                                result = (sumpoints) / (elec[0] + elec[1] + elec[2] + elec[3] + elec[4] + elec[5] + elec[6] + elec[7]);
                                break;

                        }
                    }
                    if (b == "ETC") {
                        switch (sem) {
                            case 1:
                                result = sgpa;
                                break;
                            case 2:
                                sumpoints = pcgpa * (etc[0]) + sgpa * etc[1];
                                result = (sumpoints) / (etc[0] + etc[1]);
                                break;

                            case 3:
                                sumpoints = pcgpa * (etc[0] + etc[1]) + sgpa * etc[2];
                                result = (sumpoints) / (etc[0] + etc[1] + etc[2]);
                                break;

                            case 4:
                                sumpoints = pcgpa * (etc[0] + etc[1] + etc[2]) + sgpa * etc[3];
                                result = (sumpoints) / (etc[0] + etc[1] + etc[2] + etc[3]);
                                break;

                            case 5:
                                sumpoints = pcgpa * (etc[0] + etc[1] + etc[2] + etc[3]) + sgpa * etc[4];
                                result = (sumpoints) / (etc[0] + etc[1] + etc[2] + etc[3] + etc[4]);
                                break;

                            case 6:
                                sumpoints = pcgpa * (etc[0] + etc[1] + etc[2] + etc[3] + etc[4]) + sgpa * etc[5];
                                result = (sumpoints) / (etc[0] + etc[1] + etc[2] + etc[3] + etc[4] + etc[5]);
                                break;

                            case 7:
                                sumpoints = pcgpa * (etc[0] + etc[1] + etc[2] + etc[3] + etc[4] + etc[5]) + sgpa * etc[6];
                                result = (sumpoints) / (etc[0] + etc[1] + etc[2] + etc[3] + etc[4] + etc[5] + etc[6]);
                                break;

                            case 8:
                                sumpoints = pcgpa * (etc[0] + etc[1] + etc[2] + etc[3] + etc[4] + etc[5] + etc[6]) + sgpa * etc[7];
                                result = (sumpoints) / (etc[0] + etc[1] + etc[2] + etc[3] + etc[4] + etc[5] + etc[6] + etc[7]);
                                break;

                        }
                    }
                    if (b == "EEE") {
                        switch (sem) {
                            case 1:
                                result = sgpa;
                                break;
                            case 2:
                                sumpoints = pcgpa * (eee[0]) + sgpa * eee[1];
                                result = (sumpoints) / (eee[0] + eee[1]);
                                break;

                            case 3:
                                sumpoints = pcgpa * (eee[0] + eee[1]) + sgpa * eee[2];
                                result = (sumpoints) / (eee[0] + eee[1] + eee[2]);
                                break;

                            case 4:
                                sumpoints = pcgpa * (eee[0] + eee[1] + eee[2]) + sgpa * eee[3];
                                result = (sumpoints) / (eee[0] + eee[1] + eee[2] + eee[3]);
                                break;

                            case 5:
                                sumpoints = pcgpa * (eee[0] + eee[1] + eee[2] + eee[3]) + sgpa * eee[4];
                                result = (sumpoints) / (eee[0] + eee[1] + eee[2] + eee[3] + eee[4]);
                                break;

                            case 6:
                                sumpoints = pcgpa * (eee[0] + eee[1] + eee[2] + eee[3] + eee[4]) + sgpa * eee[5];
                                result = (sumpoints) / (eee[0] + eee[1] + eee[2] + eee[3] + eee[4] + eee[5]);
                                break;

                            case 7:
                                sumpoints = pcgpa * (eee[0] + eee[1] + eee[2] + eee[3] + eee[4] + eee[5]) + sgpa * eee[6];
                                result = (sumpoints) / (eee[0] + eee[1] + eee[2] + eee[3] + eee[4] + eee[5] + eee[6]);
                                break;

                            case 8:
                                sumpoints = pcgpa * (eee[0] + eee[1] + eee[2] + eee[3] + eee[4] + eee[5] + eee[6]) + sgpa * eee[7];
                                result = (sumpoints) / (eee[0] + eee[1] + eee[2] + eee[3] + eee[4] + eee[5] + eee[6] + eee[7]);
                                break;

                        }
                    }
                    if (b == "E&I") {
                        switch (sem) {
                            case 1:
                                result = sgpa;
                                break;
                            case 2:
                                sumpoints = pcgpa * (ei[0]) + sgpa * ei[1];
                                result = (sumpoints) / (ei[0] + ei[1]);
                                break;

                            case 3:
                                sumpoints = pcgpa * (ei[0] + ei[1]) + sgpa * ei[2];
                                result = (sumpoints) / (ei[0] + ei[1] + ei[2]);
                                break;

                            case 4:
                                sumpoints = pcgpa * (ei[0] + ei[1] + ei[2]) + sgpa * ei[3];
                                result = (sumpoints) / (ei[0] + civil[1] + ei[2] + ei[3]);
                                break;

                            case 5:
                                sumpoints = pcgpa * (ei[0] + ei[1] + ei[2] + ei[3]) + sgpa * ei[4];
                                result = (sumpoints) / (ei[0] + ei[1] + ei[2] + ei[3] + ei[4]);
                                break;

                            case 6:
                                sumpoints = pcgpa * (ei[0] + ei[1] + ei[2] + ei[3] + ei[4]) + sgpa * ei[5];
                                result = (sumpoints) / (ei[0] + ei[1] + ei[2] + ei[3] + ei[4] + ei[5]);
                                break;

                            case 7:
                                sumpoints = pcgpa * (ei[0] + ei[1] + ei[2] + ei[3] + ei[4] + ei[5]) + sgpa * ei[6];
                                result = (sumpoints) / (ei[0] + ei[1] + ei[2] + ei[3] + ei[4] + ei[5] + ei[6]);
                                break;

                            case 8:
                                sumpoints = pcgpa * (ei[0] + ei[1] + ei[2] + ei[3] + ei[4] + ei[5] + ei[6]) + sgpa * ei[7];
                                result = (sumpoints) / (ei[0] + ei[1] + ei[2] + ei[3] + ei[4] + ei[5] + ei[6] + ei[7]);
                                break;

                        }

                    }
                    if (b == "Mech(Auto)" || b == "Mechanical") {
                        switch (sem) {
                            case 1:
                                result = sgpa;
                                break;
                            case 2:
                                sumpoints = pcgpa * (mechauto[0]) + sgpa * mechauto[1];
                                result = (sumpoints) / (mechauto[0] + mechauto[1]);
                                break;

                            case 3:
                                sumpoints = pcgpa * (mechauto[0] + mechauto[1]) + sgpa * mechauto[2];
                                result = (sumpoints) / (mechauto[0] + mechauto[1] + mechauto[2]);
                                break;

                            case 4:
                                sumpoints = pcgpa * (mechauto[0] + mechauto[1] + mechauto[2]) + sgpa * mechauto[3];
                                result = (sumpoints) / (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3]);
                                break;

                            case 5:
                                sumpoints = pcgpa * (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3]) + sgpa * mechauto[4];
                                result = (sumpoints) / (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3] + mechauto[4]);
                                break;

                            case 6:
                                sumpoints = pcgpa * (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3] + mechauto[4]) + sgpa * mechauto[5];
                                result = (sumpoints) / (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3] + mechauto[4] + mechauto[5]);
                                break;

                            case 7:
                                sumpoints = pcgpa * (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3] + mechauto[4] + mechauto[5]) + sgpa * mechauto[6];
                                result = (sumpoints) / (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3] + mechauto[4] + mechauto[5] + mechauto[6]);
                                break;

                            case 8:
                                sumpoints = pcgpa * (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3] + mechauto[4] + mechauto[5] + mechauto[6]) + sgpa * mechauto[7];
                                result = (sumpoints) / (mechauto[0] + mechauto[1] + mechauto[2] + mechauto[3] + mechauto[4] + mechauto[5] + mechauto[6] + mechauto[7]);
                                break;

                        }

                    }
                    setcgpa.setText("Your CGPA till this academic session : " + result);
                    Toast.makeText(getActivity(), result + "", Toast.LENGTH_LONG).show();

                }
            });
            return layout;
        }
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
