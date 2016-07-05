package tushar_admin.kiit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 1305381 on 17-10-2015.
 */
public class KiitPortal extends ActionBarActivity {
    private Toolbar toolbar;
    int backCount;
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kiit_portal);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment frag = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        frag.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(KiitPortal.this, hlist.class));

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KiitPortal.this, acsch.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KiitPortal.this, notices.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KiitPortal.this, Result.class));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KiitPortal.this, notices.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (backCount == 2) {
            Toast.makeText(getBaseContext(), "press again to exit", Toast.LENGTH_SHORT).show();
            backCount = 0;
            new T().start();
        } else if (backCount == 0) {
            super.onBackPressed();
        }
    }

    class T extends Thread {

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