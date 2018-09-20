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

        double BaseYearRevenue = 1000;
        double TaxRate = .03;
        //Operating Profit Margin = Operating Income / Sales Revenue
        //EBIT in period t = Revenues in period t * Expected operating margin in period t
        //Thus, if you expect operating margins to change over time, you should not use the fundamental
        // growth equation developed in the last section as your base growth rate. Instead, you should forecast
        // revenues and margins over time, and estimate the operating income as the product of the two.
        double CostOfGoodsSoldAsPercentageOfRevenue = .04;


        //includes Research and Development costs
        double SellingGeneralAdministrativeExpensesAsPercentageOfRevenue = .04;
        //use above

        double InitialEBITPercentageOfRevenue = .03;
        //allows you to predict what the final EBIT would be in the last period, left to default at
        //InitialEBIT
        double LastPeriodEBITPercentageOfRevenue = .03;
        double CapitalExpenditurePercentageOfRevenue = .03;
        double BaseYearDepreciation = 200;
        //given multiple year input, different forecasted revenue numbers, different operating NWC calculated
        //as a result, different changes in non-cash working capital is calculated
        double ChangeInNonCashWorkingCapital = 300;

        //Free Cash Flows To Firm Calculation
        //(1-TaxRate)





    }

}
