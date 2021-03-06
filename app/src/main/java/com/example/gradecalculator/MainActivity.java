package com.example.gradecalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    public ActionBar actionBar;
    public Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {
            @Override
            public void onDrawerClosed(View drawerView)
            {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                if (inputMethodManager != null)
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                if (inputMethodManager != null)
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageButton ib = navigationView.getHeaderView(0).findViewById(R.id.home_button);
        ib.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                fragmentManager.beginTransaction().replace(R.id.content_frame, new Home()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       if(id == R.id.action_settings)
        {
            startActivity(new Intent(MainActivity.this, Settings.class));
        }
        else if(id == R.id.action_about)
        {
            startActivity(new Intent(MainActivity.this, Settings.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch(id)
        {
            case R.id.nav_class1_cg:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CLASS1cg()).commit();
                break;

            case R.id.nav_class2_cg:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CLASS2cg()).commit();
                break;

            case R.id.nav_class3_cg:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CLASS3cg()).commit();
                break;

            case R.id.nav_class4_cg:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CLASS4cg()).commit();
                break;

            case R.id.nav_class1_fe:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CLASS1fe()).commit();
                break;

            case R.id.nav_class2_fe:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CLASS2fe()).commit();
                break;

            case R.id.nav_class3_fe:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CLASS3fe()).commit();
                break;

            case R.id.nav_class4_fe:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CLASS4fe()).commit();
                break;

            case R.id.nav_points_lost:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new PercentLost()).commit();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setActionBarTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }
/*
    public void setActionBarColor(String s)
    {
         if(s == "Red")
        {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.colorRedDark));
            }
        }
    }
*/
}
