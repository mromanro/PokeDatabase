package com.fauxbunnies.pokedatabase;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    private static final int STOPSPLASH = 0;

    private static final long SPLASHTIME = 3000;

    private ImageView splash;
    private ListView pokemonSets;

    /*private Handler splashHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case STOPSPLASH:
                    splash.setVisibility(View.GONE);
                    break;
            }
            super.handleMessage(msg);
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ListsFragment listsFragment = new ListsFragment();

        //Temporary
        InputStream is = getResources().openRawResource(R.raw.cards);
        XMLParser.parseFile(is);
        String[] elements = XMLParser.getElementsByTagName("group");
        //String[] elements = XMLParser.getChildElementsByTagName("group");
        listsFragment.setArguments(createBundle(elements));
        //

        if(fm.findFragmentById(android.R.id.content) == null) {
            ft.add(android.R.id.content, listsFragment);
            ft.commit();
        }
        /*
        splash = (ImageView) findViewById(R.id.splashimage);
        Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Temporary functions

    public Bundle createBundle(String[] elements) {
        Bundle bundle = new Bundle();
        bundle.putStringArray("Elements", elements);

        return bundle;
    }


}
