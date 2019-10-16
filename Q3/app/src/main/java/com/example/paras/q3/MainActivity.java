package com.example.paras.q3;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                if (menuItem.getItemId() == R.id.contacts)
                    startActivity(new Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI));
                else if (menuItem.getItemId() == R.id.browser) {
                    String url = "http://www.google.com";
                    Intent google = new Intent(Intent.ACTION_VIEW);
                    google.setData(Uri.parse(url));
                    startActivity(google);
                }
                else if (menuItem.getItemId() == R.id.search)
                    startActivity(new Intent(getApplicationContext(), SearchViewHandler.class));
                else if (menuItem.getItemId() == R.id.map)
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?z=4&q=current+location")));
                return true;
            }
        });
    }
}
