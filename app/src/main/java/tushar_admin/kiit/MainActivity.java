package tushar_admin.kiit;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    int backCount;
    //private NavigationDrawerFragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment frag = (NavigationDrawerFragment)
               getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        frag.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);
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
            Toast.makeText(MainActivity.this,"SETTINGS...",Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
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
