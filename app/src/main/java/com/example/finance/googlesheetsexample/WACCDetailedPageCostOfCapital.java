package com.example.finance.googlesheetsexample;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;

public class WACCDetailedPageCostOfCapital extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waccdetailedpagecostofcapital);

        Fresco.initialize(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        //textView = (TextView) this.findViewById(R.id.WACCTextView);
    }
}
