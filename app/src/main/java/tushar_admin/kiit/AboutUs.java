package tushar_admin.kiit;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

/**
 * Created by 1305381 on 20-10-2015.
 */
public class AboutUs extends ActionBarActivity {

    private Toolbar toolbar;
    int backCount;
    //private NavigationDrawerFragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment frag = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        frag.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);
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

