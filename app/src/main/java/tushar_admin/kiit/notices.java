package tushar_admin.kiit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by 1305108 on 18-09-2015.
 */
public class notices extends ActionBarActivity {
    private Toolbar toolbar;
    int backCount;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        WebView wv=(WebView)findViewById(R.id.wv);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment frag = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        frag.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        wv.getSettings().setJavaScriptEnabled(true);
        String ua = "Mozilla/5.0 (Linux; Android 4.1.1; HTC One X Build/JRO03C) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.58 Mobile Safari/537.31";
        wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setJavaScriptEnabled(true);
        // wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUserAgentString(ua);

        wv.loadUrl("http://kiit.ac.in/notices.html");


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
