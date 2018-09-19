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

public class WACCDetailedPageTerminalValue extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private TextView WACCDetailedPageTerminalValueSubTitle;
    private TextView WACCDetailedPageTerminalValueTerminalROIC;
    private TextView WACCDetailedPageTerminalValueTerminalReinvestmentRate;
    private TextView WACCDetailedPageTerminalValueTerminalGrowthRate;
    private TextView WACCDetailedPageTerminalValueTerminalWACC;


    private TextView WACCDetailedPageTerminalValueTerminalROICValue;
    private TextView WACCDetailedPageTerminalValueTerminalReinvestmentRateValue;
    private TextView WACCDetailedPageTerminalValueTerminalGrowthRateValue;
    private TextView WACCDetailedPageTerminalValueTerminalWACCValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waccdetailedpageterminalvalue);

        Fresco.initialize(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);


        WACCDetailedPageTerminalValueSubTitle = (TextView) this.findViewById(R.id.
                WACCDetailedPageTerminalValueSubTitle);
        WACCDetailedPageTerminalValueSubTitle.setText("TERMINAL VALUE");


        //Terminal ROIC

        WACCDetailedPageTerminalValueTerminalROIC = (TextView) this.
                findViewById(R.id.WACCDetailedPageTerminalValueTerminalROIC);
        WACCDetailedPageTerminalValueTerminalROIC.setText("Terminal ROIC \n(%)");

        WACCDetailedPageTerminalValueTerminalROIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopUpWindow popUpWindow = new PopUpWindow();
                //TODO: look into setting text like above way
                Intent intent = new Intent(WACCDetailedPageTerminalValue.this, PopUpWindow.class);
                intent.putExtra("flagPDF", "false");
                intent.putExtra("message", "This is the sum of all cash and cash" +
                        "equivalents from the company's balance sheet, as of the end of the " +
                        "base year of valuation.  Input the most recent value.");

                //

                startActivity(intent);

            }

        });

        WACCDetailedPageTerminalValueTerminalROICValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageTerminalValueTerminalROICValue);


        // Terminal reinvestment rate

        WACCDetailedPageTerminalValueTerminalReinvestmentRate = (TextView) this.findViewById(R.id.
                WACCDetailedPageTerminalValueTerminalReinvestmentRate);
        WACCDetailedPageTerminalValueTerminalReinvestmentRate.setText("Terminal reinvestment rate \n(RR: %)");

        //TODO: Get subscripts to work properly
        WACCDetailedPageTerminalValueTerminalReinvestmentRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageTerminalValue.this, PopUpWindow.class);
                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "WACC is 'weighted average cost of capital.'" +
                        "It captures the idea that we must provide a 'fair' rate of return " +
                        "to each type of investor in our business, weighted by the proportion " +
                        "in which they are supplying its capital.  This rate is determined by the " +
                        "return on risk-equivalent assets - the notion is that, when investors " +
                        "give us their money, they are foregoing the opportunity to earn a " +
                        "risk-equivalent rate of return elsewhere; i.e., they are incurring " +
                        "an opportunity cost to the use of their capital." +
                        "\n\nCapital is of two types: owners' money (Equity, E) or borrowed money " +
                        "(Debt, D). If E expects a return rE, and D expects rD, and " +
                        "'f' is the tax rate, then WACC is defined as: " +
                        "\n\nWACC = rE x (E/(D+E)) + rD X (1-t) x (D/(D+E)) " +
                        "\n\nWe multiply rD by (1-t) to reflect the fact that tax laws " +
                        "allow for interest payments to debtholders to be deducted as a cost of " +
                        "doing business (while divdend payments to equityholders, with " +
                        "occasional exceptions, are not).  As a result, the true cost of " +
                        "borrowing is not all of rD, but the after-tax rD.  This provision" +
                        "in the tax laws is said to provide a 'tax shield benefit' to " +
                        "the company.");

                //


                startActivity(intent);


            }


        });

        WACCDetailedPageTerminalValueTerminalReinvestmentRateValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageTerminalValueTerminalReinvestmentRateValue);


        // Terminal growth rate (g: %)

        WACCDetailedPageTerminalValueTerminalGrowthRate = (TextView) this.findViewById
                (R.id.WACCDetailedPageTerminalValueTerminalGrowthRate);
        WACCDetailedPageTerminalValueTerminalGrowthRate.setText("Terminal growth rate \n(g: %)");

        //TODO: Get subscripts to work properly
        WACCDetailedPageTerminalValueTerminalGrowthRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageTerminalValue.this, PopUpWindow.class);
                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "WACC is 'weighted average cost of capital.'" +
                        "It captures the idea that we must provide a 'fair' rate of return " +
                        "to each type of investor in our business, weighted by the proportion " +
                        "in which they are supplying its capital.  This rate is determined by the " +
                        "return on risk-equivalent assets - the notion is that, when investors " +
                        "give us their money, they are foregoing the opportunity to earn a " +
                        "risk-equivalent rate of return elsewhere; i.e., they are incurring " +
                        "an opportunity cost to the use of their capital." +
                        "\n\nCapital is of two types: owners' money (Equity, E) or borrowed money " +
                        "(Debt, D). If E expects a return rE, and D expects rD, and " +
                        "'f' is the tax rate, then WACC is defined as: " +
                        "\n\nWACC = rE x (E/(D+E)) + rD X (1-t) x (D/(D+E)) " +
                        "\n\nWe multiply rD by (1-t) to reflect the fact that tax laws " +
                        "allow for interest payments to debtholders to be deducted as a cost of " +
                        "doing business (while divdend payments to equityholders, with " +
                        "occasional exceptions, are not).  As a result, the true cost of " +
                        "borrowing is not all of rD, but the after-tax rD.  This provision" +
                        "in the tax laws is said to provide a 'tax shield benefit' to " +
                        "the company.");

                //


                startActivity(intent);


            }


        });

        WACCDetailedPageTerminalValueTerminalGrowthRateValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageTerminalValueTerminalGrowthRateValue);

        //Terminal WACC


        WACCDetailedPageTerminalValueTerminalWACC = (TextView) this.findViewById
                (R.id.WACCDetailedPageTerminalValueTerminalWACC);
        WACCDetailedPageTerminalValueTerminalWACC.setText("Terminal WACC \n(%)");

        //TODO: Get subscripts to work properly
        WACCDetailedPageTerminalValueTerminalWACC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageTerminalValue.this, PopUpWindow.class);
                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "WACC is 'weighted average cost of capital.'" +
                        "It captures the idea that we must provide a 'fair' rate of return " +
                        "to each type of investor in our business, weighted by the proportion " +
                        "in which they are supplying its capital.  This rate is determined by the " +
                        "return on risk-equivalent assets - the notion is that, when investors " +
                        "give us their money, they are foregoing the opportunity to earn a " +
                        "risk-equivalent rate of return elsewhere; i.e., they are incurring " +
                        "an opportunity cost to the use of their capital." +
                        "\n\nCapital is of two types: owners' money (Equity, E) or borrowed money " +
                        "(Debt, D). If E expects a return rE, and D expects rD, and " +
                        "'f' is the tax rate, then WACC is defined as: " +
                        "\n\nWACC = rE x (E/(D+E)) + rD X (1-t) x (D/(D+E)) " +
                        "\n\nWe multiply rD by (1-t) to reflect the fact that tax laws " +
                        "allow for interest payments to debtholders to be deducted as a cost of " +
                        "doing business (while divdend payments to equityholders, with " +
                        "occasional exceptions, are not).  As a result, the true cost of " +
                        "borrowing is not all of rD, but the after-tax rD.  This provision" +
                        "in the tax laws is said to provide a 'tax shield benefit' to " +
                        "the company.");

                //


                startActivity(intent);


            }


        });

        WACCDetailedPageTerminalValueTerminalWACCValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageTerminalValueTerminalWACCValue);

    }




}




