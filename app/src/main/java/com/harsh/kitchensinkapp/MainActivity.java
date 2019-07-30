package com.harsh.kitchensinkapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.harsh.searchwidget.Model.ClientSuggestionsModel;
import com.harsh.searchwidget.Model.SearchPropModel;
import com.harsh.searchwidget.SearchBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SearchBar searchBar;
    ArrayList<String> dataFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchBar = (SearchBar) findViewById(R.id.searchBar);
        searchBar.setAppbaseClient("https://scalr.api.appbase.io", "shopify-flipkart-test", "xJC6pHyMz", "54fabdda-4f7d-43c9-9960-66ff45d8d4cf", "products");

        dataFields = new ArrayList<>();
        dataFields.add("title");
        dataFields.add("title.search");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_basic);
        final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                .setQueryFormat("or")
                .setHighlight(true)
                .setRedirectIcon(false)
                .setSearchResultImage(false)
                .setHitsEnabled(false)
                .build();

        searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
            @Override
            public void onClick(View view, int position, ClientSuggestionsModel result) {

            }

            @Override
            public void onLongClick(View view, int position, ClientSuggestionsModel result) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_basic) {
            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .build();

            searchBar.setSearchIconVisibility(true);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_without_search) {

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .build();

            searchBar.setSearchIconVisibility(false);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
