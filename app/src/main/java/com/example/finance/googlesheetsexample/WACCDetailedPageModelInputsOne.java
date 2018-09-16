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

public class WACCDetailedPageModelInputsOne extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private TextView WACCDetailedPageModelInputsOneTitle;
    private TextView WACCDetailedPageModelInputsOneCompanyNameInput;
    private TextView WACCDetailedPageModelInputsOneCompanyNameText;
    private TextView WACCDetailedPageModelInputsOneBaseYear;
    private TextView WACCDetailedPageModelInputsOneBaseYearValue;
    private TextView WACCDetailedPageModelInputsOneNumberForecastPeriods;
    private TextView WACCDetailedPageModelInputsOneNumberForecastPeriodsValue;
    private TextView WACCDetailedPageModelInputsOneBaseYearRevenue;
    private TextView WACCDetailedPageModelInputsOneBaseYearRevenueValue;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateValue;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminal;
    private TextView WACCDetailedPageModelInputsOneCostGoodsSold;
    private TextView WACCDetailedPageModelInputsOneCostGoodsSoldValue;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton;
    private TextView WACCDetailedPageModelInputsOneCostGoodsSoldButton;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waccdetailedpagemodelinputsone);

        Fresco.initialize(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        //textView = (TextView) this.findViewById(R.id.WACCTextView);


        WACCDetailedPageModelInputsOneTitle = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneTitle);
        WACCDetailedPageModelInputsOneTitle.setText("'WACC: Detailed' Model Inputs: Free Cash Flow " +
                "(FCFF)");


        WACCDetailedPageModelInputsOneCompanyNameText = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneCompanyNameText);
        WACCDetailedPageModelInputsOneCompanyNameText.setText("Company Name");


        WACCDetailedPageModelInputsOneCompanyNameInput = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsOneCompanyNameInput);


        WACCDetailedPageModelInputsOneBaseYear = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneBaseYear);
        WACCDetailedPageModelInputsOneBaseYear.setText("Base Year");

        WACCDetailedPageModelInputsOneBaseYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsOneBaseYearValue = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsOneBaseYearValue);




        WACCDetailedPageModelInputsOneNumberForecastPeriods = (TextView) this.findViewById
                (R.id.WACCDetailedPageModelInputsOneNumberForecastPeriods);
        WACCDetailedPageModelInputsOneNumberForecastPeriods.setText("Number of forecast periods");

        WACCDetailedPageModelInputsOneNumberForecastPeriods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsOneNumberForecastPeriods.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);
                return false;
            }

        });
    }


}
