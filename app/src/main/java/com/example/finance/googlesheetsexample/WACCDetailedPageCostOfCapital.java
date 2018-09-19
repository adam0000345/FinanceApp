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
//test
import com.facebook.drawee.backends.pipeline.Fresco;

public class WACCDetailedPageCostOfCapital extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private TextView WACCDetailedPageCostOfCapitalTitle;
    private TextView WACCDetailedPageCostOfCapitalSubTitle;
    private TextView WACCDetailedPageCostOfCapitalCash;
    private TextView WACCDetailedPageCostOfCapitalDebt;
    private TextView WACCDetailedPageCostOfCapitalMarketCap;
    private TextView WACCDetailedPageCostOfCapitalEquityBeta;
    private TextView WACCDetailedPageCostOfCapitalRiskFreeRate;
    private TextView WACCDetailedPageCostOfCapitalMarketRiskPremium;
    private TextView WACCDetailedPageCostOfCapitalLeveredCostOfEquity;
    private TextView WACCDetailedPageCostOfCapitalCostOfDebt;
    private TextView WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital;
    private TextView WACCDetailedPageCostOfCapitalNumberOfShares;

    private TextView WACCDetailedPageCostOfCapitalCashValue;
    private TextView WACCDetailedPageCostOfCapitalDebtValue;
    private TextView WACCDetailedPageCostOfCapitalMarketCapValue;
    private TextView WACCDetailedPageCostOfCapitalEquityBetaValue;
    private TextView WACCDetailedPageCostOfCapitalRiskFreeRateValue;
    private TextView WACCDetailedPageCostOfCapitalMarketRiskPremiumValue;
    private TextView WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue;
    private TextView WACCDetailedPageCostOfCapitalCostOfDebtValue;
    private TextView WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue;
    private TextView WACCDetailedPageCostOfCapitalNumberOfSharesValue;



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


        WACCDetailedPageCostOfCapitalTitle = (TextView) this.findViewById(R.id.
                WACCDetailedPageCostOfCapitalTitle);
        WACCDetailedPageCostOfCapitalTitle.setText("'WACC: Detailed' Model Inputs: Cost of Capital " +
                "and Terminal Value");

        WACCDetailedPageCostOfCapitalSubTitle = (TextView) this.findViewById(R.id.
                WACCDetailedPageCostOfCapitalSubTitle);
        WACCDetailedPageCostOfCapitalSubTitle.setText("COST OF CAPITAL");


        WACCDetailedPageCostOfCapitalCash = (TextView) this.
                findViewById(R.id.WACCDetailedPageCostOfCapitalCash);
        WACCDetailedPageCostOfCapitalCash.setText("Cash (C: $millions)");

        WACCDetailedPageCostOfCapitalCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopUpWindow popUpWindow = new PopUpWindow();
                //TODO: look into setting text like above way
                Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                intent.putExtra("flagPDF", "false");
                intent.putExtra("message", "This is the sum of all cash and cash" +
                        "equivalents from the company's balance sheet, as of the end of the " +
                        "base year of valuation.  Input the most recent value.");

                //

                startActivity(intent);

            }

        });

        WACCDetailedPageCostOfCapitalCashValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalCashValue);

        WACCDetailedPageCostOfCapitalDebt = (TextView) this.findViewById(R.id.WACCDetailedPageCostOfCapitalDebt);
        WACCDetailedPageCostOfCapitalDebt.setText("Debt (D: $ millions)");

        //TODO: Get subscripts to work properly
        WACCDetailedPageCostOfCapitalDebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
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

        WACCDetailedPageCostOfCapitalDebtValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalDebtValue);

        WACCDetailedPageCostOfCapitalMarketCap = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketCap);
        WACCDetailedPageCostOfCapitalMarketCap.setText("Market capitalization \n(E: $millions)");

        WACCDetailedPageCostOfCapitalMarketCap
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "'Operating Income' is a company's " +
                                "'Earnings before Interest and Taxes,' or 'EBIT'.  If Depreciation " +
                                "charges are already included in a company's costs (as they " +
                                "typically are), then Operating Income is defined as: " +
                                " EBIT = Revenue - Cost of Goods Sold (CGS) - Selling " +
                                ", General & Administrative Expense (SGA). " +
                                "\n\nIf Depreciation charges are not already in CGS " +
                                "and SGA, then it would have to be additionally subtracted " +
                                "to get correct EBIT; Depreciation can be found in " +
                                "the Cash Flow Statement. " +
                                "\n\nIf you choose the option 'Will input percent EBIT,' " +
                                "the CGS and SGA ells will be greyed out.  If you choose " +
                                "the option 'Will input percent CGS and percent SGA,' the " +
                                "initial EBIT will be calculated by default.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalMarketCapValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketCapValue);



        //Equity Beta

        WACCDetailedPageCostOfCapitalEquityBeta = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalEquityBeta);
        WACCDetailedPageCostOfCapitalEquityBeta.setText("Equity beta ß)");

        WACCDetailedPageCostOfCapitalEquityBeta
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "'Operating Income' is a company's " +
                                "'Earnings before Interest and Taxes,' or 'EBIT'.  If Depreciation " +
                                "charges are already included in a company's costs (as they " +
                                "typically are), then Operating Income is defined as: " +
                                " EBIT = Revenue - Cost of Goods Sold (CGS) - Selling " +
                                ", General & Administrative Expense (SGA). " +
                                "\n\nIf Depreciation charges are not already in CGS " +
                                "and SGA, then it would have to be additionally subtracted " +
                                "to get correct EBIT; Depreciation can be found in " +
                                "the Cash Flow Statement. " +
                                "\n\nIf you choose the option 'Will input percent EBIT,' " +
                                "the CGS and SGA ells will be greyed out.  If you choose " +
                                "the option 'Will input percent CGS and percent SGA,' the " +
                                "initial EBIT will be calculated by default.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalEquityBetaValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalEquityBetaValue);

        //Risk-free rate (rF: %)

        WACCDetailedPageCostOfCapitalRiskFreeRate = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalRiskFreeRate);
        WACCDetailedPageCostOfCapitalRiskFreeRate.setText("Risk-free rate (rF: %)");

        WACCDetailedPageCostOfCapitalRiskFreeRate
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "'Operating Income' is a company's " +
                                "'Earnings before Interest and Taxes,' or 'EBIT'.  If Depreciation " +
                                "charges are already included in a company's costs (as they " +
                                "typically are), then Operating Income is defined as: " +
                                " EBIT = Revenue - Cost of Goods Sold (CGS) - Selling " +
                                ", General & Administrative Expense (SGA). " +
                                "\n\nIf Depreciation charges are not already in CGS " +
                                "and SGA, then it would have to be additionally subtracted " +
                                "to get correct EBIT; Depreciation can be found in " +
                                "the Cash Flow Statement. " +
                                "\n\nIf you choose the option 'Will input percent EBIT,' " +
                                "the CGS and SGA ells will be greyed out.  If you choose " +
                                "the option 'Will input percent CGS and percent SGA,' the " +
                                "initial EBIT will be calculated by default.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalRiskFreeRateValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalRiskFreeRateValue);

        //Market risk premium (MRP: %)

        WACCDetailedPageCostOfCapitalMarketRiskPremium = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketRiskPremium);
        WACCDetailedPageCostOfCapitalMarketRiskPremium.setText("Market risk premium \n(MRP: %)");

        WACCDetailedPageCostOfCapitalMarketRiskPremium
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "'Operating Income' is a company's " +
                                "'Earnings before Interest and Taxes,' or 'EBIT'.  If Depreciation " +
                                "charges are already included in a company's costs (as they " +
                                "typically are), then Operating Income is defined as: " +
                                " EBIT = Revenue - Cost of Goods Sold (CGS) - Selling " +
                                ", General & Administrative Expense (SGA). " +
                                "\n\nIf Depreciation charges are not already in CGS " +
                                "and SGA, then it would have to be additionally subtracted " +
                                "to get correct EBIT; Depreciation can be found in " +
                                "the Cash Flow Statement. " +
                                "\n\nIf you choose the option 'Will input percent EBIT,' " +
                                "the CGS and SGA ells will be greyed out.  If you choose " +
                                "the option 'Will input percent CGS and percent SGA,' the " +
                                "initial EBIT will be calculated by default.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalMarketRiskPremiumValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketRiskPremiumValue);

        //Levered cost of equity

        WACCDetailedPageCostOfCapitalLeveredCostOfEquity = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalLeveredCostOfEquity);
        WACCDetailedPageCostOfCapitalLeveredCostOfEquity.setText("Levered cost of equity \n(rE: %)");

        WACCDetailedPageCostOfCapitalLeveredCostOfEquity
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "'Operating Income' is a company's " +
                                "'Earnings before Interest and Taxes,' or 'EBIT'.  If Depreciation " +
                                "charges are already included in a company's costs (as they " +
                                "typically are), then Operating Income is defined as: " +
                                " EBIT = Revenue - Cost of Goods Sold (CGS) - Selling " +
                                ", General & Administrative Expense (SGA). " +
                                "\n\nIf Depreciation charges are not already in CGS " +
                                "and SGA, then it would have to be additionally subtracted " +
                                "to get correct EBIT; Depreciation can be found in " +
                                "the Cash Flow Statement. " +
                                "\n\nIf you choose the option 'Will input percent EBIT,' " +
                                "the CGS and SGA ells will be greyed out.  If you choose " +
                                "the option 'Will input percent CGS and percent SGA,' the " +
                                "initial EBIT will be calculated by default.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue);

        //Cost of debt

        WACCDetailedPageCostOfCapitalCostOfDebt = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalCostOfDebt);
        WACCDetailedPageCostOfCapitalCostOfDebt.setText("Cost of debt (rD: %)");

        WACCDetailedPageCostOfCapitalCostOfDebt
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "'Operating Income' is a company's " +
                                "'Earnings before Interest and Taxes,' or 'EBIT'.  If Depreciation " +
                                "charges are already included in a company's costs (as they " +
                                "typically are), then Operating Income is defined as: " +
                                " EBIT = Revenue - Cost of Goods Sold (CGS) - Selling " +
                                ", General & Administrative Expense (SGA). " +
                                "\n\nIf Depreciation charges are not already in CGS " +
                                "and SGA, then it would have to be additionally subtracted " +
                                "to get correct EBIT; Depreciation can be found in " +
                                "the Cash Flow Statement. " +
                                "\n\nIf you choose the option 'Will input percent EBIT,' " +
                                "the CGS and SGA ells will be greyed out.  If you choose " +
                                "the option 'Will input percent CGS and percent SGA,' the " +
                                "initial EBIT will be calculated by default.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalCostOfDebtValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalCostOfDebtValue);


        //Weighted average cost of capital
        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital);
        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital.setText("Weighted average cost of" +
                " capital \n(WACC: %)");

        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "'Operating Income' is a company's " +
                                "'Earnings before Interest and Taxes,' or 'EBIT'.  If Depreciation " +
                                "charges are already included in a company's costs (as they " +
                                "typically are), then Operating Income is defined as: " +
                                " EBIT = Revenue - Cost of Goods Sold (CGS) - Selling " +
                                ", General & Administrative Expense (SGA). " +
                                "\n\nIf Depreciation charges are not already in CGS " +
                                "and SGA, then it would have to be additionally subtracted " +
                                "to get correct EBIT; Depreciation can be found in " +
                                "the Cash Flow Statement. " +
                                "\n\nIf you choose the option 'Will input percent EBIT,' " +
                                "the CGS and SGA ells will be greyed out.  If you choose " +
                                "the option 'Will input percent CGS and percent SGA,' the " +
                                "initial EBIT will be calculated by default.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue =
                (EditText) this.findViewById(R.id
                        .WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue);

        //Number of shares (millions)
        WACCDetailedPageCostOfCapitalNumberOfShares = (TextView)
                this.findViewById(R.id. WACCDetailedPageCostOfCapitalNumberOfShares);
        WACCDetailedPageCostOfCapitalNumberOfShares.setText("Number of shares \n(millions)");

        WACCDetailedPageCostOfCapitalNumberOfShares
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapital.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "'Operating Income' is a company's " +
                                "'Earnings before Interest and Taxes,' or 'EBIT'.  If Depreciation " +
                                "charges are already included in a company's costs (as they " +
                                "typically are), then Operating Income is defined as: " +
                                " EBIT = Revenue - Cost of Goods Sold (CGS) - Selling " +
                                ", General & Administrative Expense (SGA). " +
                                "\n\nIf Depreciation charges are not already in CGS " +
                                "and SGA, then it would have to be additionally subtracted " +
                                "to get correct EBIT; Depreciation can be found in " +
                                "the Cash Flow Statement. " +
                                "\n\nIf you choose the option 'Will input percent EBIT,' " +
                                "the CGS and SGA ells will be greyed out.  If you choose " +
                                "the option 'Will input percent CGS and percent SGA,' the " +
                                "initial EBIT will be calculated by default.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalNumberOfSharesValue =
                (EditText) this.findViewById(R.id
                        .WACCDetailedPageCostOfCapitalNumberOfSharesValue);

    }
}

