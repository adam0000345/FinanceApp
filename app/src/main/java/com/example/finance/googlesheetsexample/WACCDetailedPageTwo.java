package com.example.finance.googlesheetsexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;
import android.widget.TextView;


import com.facebook.drawee.backends.pipeline.Fresco;

public class WACCDetailedPageTwo extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private TextView WACCDetailedPageTwoTitle;
    private TextView WACCDetailedPageTwoOperatingIncome;
    private Spinner WACCPageTwoOperatingIncomeSpinner;
    private TextView WACCDetailedPageTwoDepreciation;
    private Spinner WACCDetailedPageTwoDepreciationSpinner;
    private TextView WACCDetailedPage2WACC;
    private Spinner WACCDetailedPage2WACCSpinner;
    private TextView WACCDetailedPageTwoTerminalGrowthRate;
    private Spinner WACCDetailedPageTwoTerminalGrowthRateSpinner;
    private TextView WACCDetailedPageTwoNotes;

    //might have to use spinner adapters

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waccdetailedpagetwo);

        Fresco.initialize(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        WACCDetailedPageTwoTitle = (TextView) this.findViewById(R.id.WACCDetailedPageTwoTitle);
        WACCDetailedPageTwoTitle.setText("A Few Key Questions Before You Start" +
                "\n\nBefore putting in base-year numbers, think through how you wish " +
                "to input: Operating Income (i.e., EBIT), Depreciation, WACC, and " +
                "Terminal Growth Rate (g). Choose one option under each.");
    }
}
