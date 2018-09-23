package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;

public class WACCDetailedPageModelInputsTwo extends NavBarAndTitle {

    private DrawerLayout mDrawerLayout;
    private TextView WACCDetailedPageModelInputsTwoSGA;
    private TextView WACCDetailedPageModelInputsTwoSGAValue;
    private TextView WACCDetailedPageModelInputsTwoInitialEBIT;
    private TextView WACCDetailedPageModelInputsTwoInitialEBITValue;
    private TextView WACCDetailedPageModelInputsTwoLastPeriodEBIT;
    private TextView WACCDetailedPageModelInputsTwoLastPeriodEBITValue;
    private TextView WACCDetailedPageModelInputsTwoCapitalExpenditure;
    private TextView WACCDetailedPageModelInputsTwoCapitalExpenditureValue;
    private TextView WACCDetailedPageModelInputsTwoOperatingNWC;
    private TextView WACCDetailedPageModelInputsTwoOperatingNWCValue;
    private TextView WACCDetailedPageModelInputsTwoStraightLineYears;
    private TextView WACCDetailedPageModelInputsTwoStraightLineYearsValue;
    private TextView WACCDetailedPageModelInputsTwoTaxRate;
    private TextView WACCDetailedPageModelInputsTwoTaxRateValue;
    private TextView WACCDetailedPageModelInputsTwoBaseYearDepreciation;
    private TextView WACCDetailedPageModelInputsTwoBaseYearDepreciationValue;


    //TODO add ability to pull data from website

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpagemodelinputstwo, frameLayout);




        //SG&A as % revenue

        WACCDetailedPageModelInputsTwoSGA
                = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoSGA);

        WACCDetailedPageModelInputsTwoSGA.setText("SG&A (incl. R&D) as % revenue");
        WACCDetailedPageModelInputsTwoSGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoSGA.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsTwoSGAValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoSGAValue);

        //Initial EBIT

        WACCDetailedPageModelInputsTwoInitialEBIT
                = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoInitialEBIT);

        WACCDetailedPageModelInputsTwoInitialEBIT.setText("Initial EBIT as % revenue (Operating Income)");

        WACCDetailedPageModelInputsTwoInitialEBIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoInitialEBIT.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsTwoInitialEBITValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoInitialEBITValue);


        //Last-period EBIT

        WACCDetailedPageModelInputsTwoLastPeriodEBIT = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoLastPeriodEBIT);

        WACCDetailedPageModelInputsTwoLastPeriodEBIT.setText("Last-period/last year EBIT as % revenue");

        WACCDetailedPageModelInputsTwoLastPeriodEBIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoLastPeriodEBIT.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsTwoLastPeriodEBITValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoLastPeriodEBITValue);


        //Capital expenditure as % revenue

        WACCDetailedPageModelInputsTwoCapitalExpenditure = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoCapitalExpenditure);

        WACCDetailedPageModelInputsTwoCapitalExpenditure.setText("Capital expenditure as % revenue (Capex)");

        WACCDetailedPageModelInputsTwoCapitalExpenditure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoCapitalExpenditure.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        //Operating NWC as % revenue

        WACCDetailedPageModelInputsTwoOperatingNWC = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoOperatingNWC );

        WACCDetailedPageModelInputsTwoOperatingNWC.setText("Operating NWC (Non-cash working capital)" +
                " as % revenue");

        WACCDetailedPageModelInputsTwoOperatingNWC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoOperatingNWCValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoOperatingNWCValue);

        //Straight-line depreciation rule
        //Straight-line method; Depreciation Expense = Depreciable Amount/ Useful Life

        WACCDetailedPageModelInputsTwoStraightLineYears = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoStraightLineYears);

        WACCDetailedPageModelInputsTwoStraightLineYears.setText("Straight-line depreciation rule (#years)");

        WACCDetailedPageModelInputsTwoStraightLineYears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });


        WACCDetailedPageModelInputsTwoStraightLineYearsValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoStraightLineValue);

        //Tax rate

        WACCDetailedPageModelInputsTwoTaxRate = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoTaxRate );

        WACCDetailedPageModelInputsTwoTaxRate.setText("Tax rate (T; %)");

        WACCDetailedPageModelInputsTwoTaxRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoTaxRate.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsTwoTaxRateValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoTaxRateValue);

        //Base year depreciation

        WACCDetailedPageModelInputsTwoBaseYearDepreciation = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoBaseYearDepreciation);

        WACCDetailedPageModelInputsTwoBaseYearDepreciation.setText("Base year depreciation ($ millions)");

        WACCDetailedPageModelInputsTwoBaseYearDepreciation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoBaseYearDepreciation.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsTwoBaseYearDepreciationValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoBaseYearDepreciationValue);

    }




}
