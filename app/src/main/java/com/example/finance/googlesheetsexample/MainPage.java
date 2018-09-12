package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

import com.example.finance.googlesheetsexample.post.PostData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ADJ on 2/21/2017.
 */
public class MainPage extends AppCompatActivity{

    Button getData;
    Button sendData;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();


    private DrawerLayout mDrawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        expandableListView = findViewById(R.id.expandableListView);


        prepareMenuData();
        populateExpandableList();


        mDrawerLayout = findViewById(R.id.drawer_layout);


        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();


        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {


                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        //displaySelectedScreen(menuItem.getItemId());


                        return true;
                    }


                });


    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void displaySelectedScreen(String MenuName) {



        //initializing the Activity object which is selected
        switch (MenuName) {
            case "EquityvalueFirmvalue":
                Intent i = new Intent(getApplicationContext(), EquityValueFirmValue.class);
                startActivity(i);
                break;

        }

        //initializing the Activity object which is selected
        switch (MenuName) {
            case "WACCDetailedPageOne":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageOne.class);
                startActivity(i);
                break;

        }

        switch (MenuName) {
            case "WACCDetailedPageTwo":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageTwo.class);
                startActivity(i);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            case R.id.viweruser:
                Intent intent = new Intent(getApplicationContext(), UserList.class);
                startActivity(intent);
                return true;

            case R.id.adduser:
                intent = new Intent(getApplicationContext(), PostData.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel("EquityvalueFirmvalue", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("WACCDetailedPageOne", true, true);
        headerList.add(menuModel);
        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel("WACCDetailedPageOne", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageTwo", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageThree", false, false);
        childModelsList.add(childModel);


        if (menuModel.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel, childModelsList);
        }


        menuModel = new MenuModel("WACSimple", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("APVDetailed", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("APVSimple", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Dividend Growth Model", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Real Options Valuation", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Not Sure", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {

//                        WebView webView = findViewById(R.id.webView);
//                        webView.loadUrl(headerList.get(groupPosition).url);
                        displaySelectedScreen(headerList.get(groupPosition).menuName);
                        onBackPressed();

                        // close drawer when item is tapped
                        //mDrawerLayout.closeDrawers();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                        //WebView webView = findViewById(R.id.webView);
                        //webView.loadUrl(model.url);
                        displaySelectedScreen(model.menuName);

                        onBackPressed();

                }

                return false;
            }
        });
    }



}
