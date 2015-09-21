package com.fauxbunnies.pokedatabase.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.fauxbunnies.pokedatabase.R;
import com.fauxbunnies.pokedatabase.Tools.XMLParser;

import java.io.InputStream;

public class MainActivity extends Activity {

    private static final int STOPSPLASH = 0;

    private static final long SPLASHTIME = 3000;

    private ImageView splash;
    private ListView pokemonSets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InputStream is = getResources().openRawResource(R.raw.cards);
        XMLParser.parseFile(is);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        GroupListFragment groupListFragment = new GroupListFragment();

        if(fm.findFragmentById(android.R.id.content) == null) {
            ft.add(android.R.id.content, groupListFragment);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

}
