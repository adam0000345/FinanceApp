package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class WACCDetailedPageModelInputsOne extends NavBarAndTitle {

    private DrawerLayout mDrawerLayout;
    private TextView WACCDetailedPageModelInputsOneTitle;
    private TextView WACCDetailedPageModelInputsOneCompanyNameValue;
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
    private ToggleButton WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton;
    private TextView WACCDetailedPageModelInputsOneCostGoodsSoldButton;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateButton;
    private boolean WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButtonCondition;


    //TODO add ability to pull data from website
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpagemodelinputsone, frameLayout);




        WACCDetailedPageModelInputsOneTitle = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneTitle);
        WACCDetailedPageModelInputsOneTitle.setText("'WACC: Detailed' Model Inputs: Free Cash Flow " +
                "(FCFF)");


        WACCDetailedPageModelInputsOneCompanyNameText = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneCompanyNameText);
        WACCDetailedPageModelInputsOneCompanyNameText.setText("Company Name");


        WACCDetailedPageModelInputsOneCompanyNameValue = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsOneCompanyNameInput);



        //do error checking, implement Excel here

        WACCDetailedPageModelInputsOneCompanyNameValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus) {
                        //SAVE THE DATA

                        getWaccDetailedObject().setCompanyName(WACCDetailedPageModelInputsOneCompanyNameValue.getText().toString());
                        Log.d("TEST", getWaccDetailedObject().getCompanyName());
                    }

                }
            });







        WACCDetailedPageModelInputsOneBaseYear = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneBaseYear);
        WACCDetailedPageModelInputsOneBaseYear.setText("Base Year");

        WACCDetailedPageModelInputsOneBaseYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);



                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "If you are doing a valuation mid-year" +
                        ", the base year may span two years. for instance, you may have a fiscal " +
                        "year that ends in June 2011, or use trailing 12-month data from July " +
                        "2010 to June 2011.  The first year of the forecast will be labeled 2012 " +
                        "but it will represent the cash flow from July 2011 to " +
                        "June 2012.");

                startActivity(intent);

            }

        });


        WACCDetailedPageModelInputsOneBaseYearValue = (EditText)
                this.findViewById
                        (R.id.
                                WACCDetailedPageModelInputsOneBaseYearValue);

        WACCDetailedPageModelInputsOneBaseYearValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject().setBaseYear(Integer.parseInt(
                            WACCDetailedPageModelInputsOneBaseYearValue.getText().toString()));
                    Log.d("TEST", String.valueOf(getWaccDetailedObject().getBaseYear()));
                }

            }
        });




        //Number of Forecast Periods

        WACCDetailedPageModelInputsOneNumberForecastPeriods = (TextView) this.findViewById
                (R.id.WACCDetailedPageModelInputsOneNumberForecastPeriods);
        WACCDetailedPageModelInputsOneNumberForecastPeriods.setText("Number of forecast periods");

        WACCDetailedPageModelInputsOneNumberForecastPeriods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "We recommend using at least five " +
                        "forecast periods, but perhaps no more than ten.");

                startActivity(intent);

            }

        });


        WACCDetailedPageModelInputsOneNumberForecastPeriodsValue = (EditText)
                this.findViewById
                        (R.id.
                                WACCDetailedPageModelInputsOneNumberForecastPeriodsValue);

        WACCDetailedPageModelInputsOneNumberForecastPeriodsValue
                .setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject().setBaseYear(Integer.parseInt(
                            WACCDetailedPageModelInputsOneNumberForecastPeriodsValue.getText().toString()));
                    Log.d("TEST", String.valueOf(getWaccDetailedObject().getNumberOfForecastPeriods()));
                }

            }
        });



        //Base year revenue input

        WACCDetailedPageModelInputsOneBaseYearRevenue = (TextView) this.findViewById
                (R.id.WACCDetailedPageModelInputsOneBaseYearRevenue);

        WACCDetailedPageModelInputsOneBaseYearRevenue .setText("Base your revenue ($ millions)");

        WACCDetailedPageModelInputsOneBaseYearRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "This is the total revenue (sales) " +
                                "during the base year in US dollars (or in absolute terms). " +
                                "Once you have picked your units, make sure to stay consistent " +
                                "with those same units for your other inputs. \n\n " +
                                "In some instances, base year revenue may require to be " +
                                "'normalized.' This requries judgment, especially in " +
                                "cyclical businesses, industries whose revenues are " +
                                "dependent on commodity prices, or when base-year revenue " +
                                "and profits of the firms were subject to extraordinary " +
                                "exogenous shocks (e.g., a dotcom firm in the early 2000s, " +
                                "or a financial services firm in 2008-09).");


                startActivity(intent);

            }

        });


        WACCDetailedPageModelInputsOneBaseYearRevenueValue = (EditText)
                this.findViewById
                        (R.id.WACCDetailedPageModelInputsOneBaseYearRevenueValue);


        WACCDetailedPageModelInputsOneBaseYearRevenueValue
                .setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus) {
                            //SAVE THE DATA


                            getWaccDetailedObject().setBaseRevenue(Double.parseDouble(
                                    WACCDetailedPageModelInputsOneBaseYearRevenueValue.getText().toString()));
                            Log.d("TEST", String.valueOf(getWaccDetailedObject().getNumberOfForecastPeriods()));
                        }

                    }
                });

        //Annual revenue growth rate

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate);

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate.setText("Annual revenue growth rate (%)");

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "This is one where mistakes are often made! " +
                                "Just calculating the firm's past compounded annual growth rates (CAGR) " +
                                "in revenue, and treating that as a basis for a future forecast will " +
                                "likely over- or underestimate growth rates. \n\n " +
                                "For instance, past CAGRs reflect revenue gained from acquisitions " +
                                "(overestimate) or that lost from divestitures and asset sales " +
                                "(underestimate). Similarly, they could reflect the positive or " +
                                "negative effects of a home currency depreciation or appreciation.  " +
                                "We recommend that revenue CAGR forecasts be based on organic (bolded) " +
                                "(i.e., non-acquisition), constant-currency (bolded) (i.e., no real " +
                                "exchange rate effects) growth rates.  In some instances, " +
                                "the industry growth rate can give you a better estimate, but even then, " +
                                "recognize that currency or cross-border acquisition effects might be " +
                                "present. \n\n Also, note that you can input negative revenue growth rates " +
                                "(but note they can't be negative forever!).  If you input a negative number " +
                                "here, a new screen will open up which will require you to input year-by-year " +
                                "growth rates (i.e., to allow you to change rates from negative to positive) " +
                                "during the forecast period.");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });


        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateValue = (EditText)
                this.findViewById(R.id.WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateValue);

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateValue
                .setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus) {
                            //SAVE THE DATA


                            getWaccDetailedObject().setAnnualRevenueGrowthPercentage(Double.valueOf(
                                    WACCDetailedPageModelInputsOneBaseYearRevenueValue.getText().toString()));
                            Log.d("TEST", String.valueOf(getWaccDetailedObject().getNumberOfForecastPeriods()));
                        }

                    }
                });

        //Revenue growth fade to terminal growth

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminal = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminal);

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminal.setText("Revenue growth fade to terminal growth?");

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton = (ToggleButton) this.findViewById(R.id.WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton);

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButtonCondition = true;
                    getWaccDetailedObject().setRevenueGrowthFadeToTerminalGrowth(true);
                }
                else{
                    WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButtonCondition = false;
                    getWaccDetailedObject().setRevenueGrowthFadeToTerminalGrowth(false);
                }
            }



        });

        //TO BE USED IN DIFFERENT PER_PERIOD REVENUE GROWTH RATES
//        intent.putExtra("isExcelPopup", "false");
//        intent.putExtra("message", "The default is set to 'NO'. If you wish to " +
//                "input a different revenue growth rate for each period, touch the " +
//                "button to change it to 'YES'. A new screen will open up which " +
//                "will give you the option to do so. \n\n The screen will also " +
//                "open up if you input a negative revenue growth rate in the previous " +
//                "cell, requiring you to input year-by-year growth rates" +
//                "(thereby allowing you to change rates from negative to positive) " +
//                "during the forecast period.");
//
//        startActivity(intent);


        //Cost of goods sold as % revenue

        WACCDetailedPageModelInputsOneCostGoodsSold = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneCostGoodsSold);

        WACCDetailedPageModelInputsOneCostGoodsSold.setText("Cost of goods sold as % revenue");

        WACCDetailedPageModelInputsOneCostGoodsSold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "Cost of goods sold (CGS) captures, in principle, " +
                        "the direct costs of producing and selling the company's goods and services. " +
                        "In most financial reporting, CGS-typically includes associated Depreciation " +
                        " (make in italics) charges.");

                startActivity(intent);


                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsOneCostGoodsSold.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsOneCostGoodsSoldValue = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsOneCostGoodsSoldValue);


        WACCDetailedPageModelInputsOneCostGoodsSoldValue
                .setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus) {
                            //SAVE THE DATA


                            getWaccDetailedObject().setCostOfGoodsSoldAsPercentage(Double.valueOf(
                                    WACCDetailedPageModelInputsOneCostGoodsSoldValue.getText().toString()));
                            Log.d("TEST", String.valueOf(getWaccDetailedObject().getCostOfGoodsSoldAsPercentage()));
                        }

                    }
                });





    }


}
