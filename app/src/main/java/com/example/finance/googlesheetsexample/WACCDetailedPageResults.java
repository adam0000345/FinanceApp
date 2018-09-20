package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;

public class WACCDetailedPageResults extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waccdetailedpageresults);

        Fresco.initialize(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        //Free Cash Flows To Firm Calculation
        //EBIT(1-t) - (Capital Expenditures- Depreciation) - Change in non-cash working capital=
        //Free Cash Flow to Firm (FCFF)

        //Cash Flows To Equity Investors
        //Net income - (Capital Expenditures - Depreciation) - Change in non-cash
        //Working Capital - (Principal Repaid - New Debt Issues) - Preferred Dividend
        //-new Debt Issues = Free Cash Flow to Equity






    }

}
