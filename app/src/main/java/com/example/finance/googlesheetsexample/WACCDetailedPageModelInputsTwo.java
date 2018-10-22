package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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


    //TODO add ability to pull data from website, intent.putExtra("flagExcelViewer", "false");

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

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "SG&A - selling, general, and administrative " +
                        "expenditures or SGA - captures, in principle, the indirect costs of producing " +
                        "and selling the company's goods and services. (R&D expenses are assumed to " +
                        "be included, so if it is reported separately in the company's financial " +
                        "statements, R&D should be included here.) In most financial reporting, SGA " +
                        "typically includes the associated Depreciation (make in italics) charges.");

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

        //do error checking, implement Excel here

        WACCDetailedPageModelInputsTwoSGAValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject().setSGAValue(Double.valueOf(WACCDetailedPageModelInputsTwoSGAValue.getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().);
                }

            }
        });

        //Initial EBIT

        WACCDetailedPageModelInputsTwoInitialEBIT
                = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoInitialEBIT);

        WACCDetailedPageModelInputsTwoInitialEBIT.setText("Initial EBIT as % revenue (Operating Income)");

        WACCDetailedPageModelInputsTwoInitialEBIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "EBIT = Operating Income = Revenue - CGS - SGA " +
                        "(if Depreciation (italics) is not already included in CGS and SGA, it has to be " +
                        "subtracted). \n\n The input here is the percent operating margin for Year 1 " +
                        "of the valuation. (Note that initial EBIT can be a negative number; in that event, " +
                        "last-period EBIT as % revenue should be input as a positive number; see below.)");

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

        WACCDetailedPageModelInputsTwoInitialEBITValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject()
                            .setInitialEBIT(Double.
                                    valueOf(WACCDetailedPageModelInputsTwoInitialEBITValue.getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().);
                }

            }
        });


        //Last-period EBIT

        WACCDetailedPageModelInputsTwoLastPeriodEBIT = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoLastPeriodEBIT);

        WACCDetailedPageModelInputsTwoLastPeriodEBIT.setText("Last-period/last year EBIT as % revenue");

        WACCDetailedPageModelInputsTwoLastPeriodEBIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "This is the targeted operating margin for the " +
                        "last year of the forecast period.  The defualt value is set to the initial EBIT as " +
                        "% revenue, but you can change it.  \n\n The model changes the percent operating margin " +
                        "linearly between the first period and last.  It is, therefore, possible to model a " +
                        "situation where the firm has negative initial EBIT but its EBIT grows positive over time" +
                        " ; or the firm has a supra-normal initial EBIT but its EBIT declines over time.");

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

        WACCDetailedPageModelInputsTwoLastPeriodEBITValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject()
                            .setLastYearEBIT(Double.
                                    valueOf(
                                            WACCDetailedPageModelInputsTwoLastPeriodEBITValue
                                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().);
                }

            }
        });


        //Capital expenditure as % revenue

        WACCDetailedPageModelInputsTwoCapitalExpenditure = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoCapitalExpenditure);

        WACCDetailedPageModelInputsTwoCapitalExpenditure.setText("Capital expenditure as % revenue (Capex)");

        WACCDetailedPageModelInputsTwoCapitalExpenditure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "You have three choices for this input.  You " +
                        "can divide the capital expenditure in the most recent period by revenues " +
                        "and use the value; while simple, it could be affected by unusually high or low" +
                        " numbers in the base year.  You can choose an average value over 3-5 years to smooth " +
                        "the input.  Or, you can use an industry average. (If you are using the Cash Flow " +
                        "Statement to get this number, know that is may how up with a negative sign!).");

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

        WACCDetailedPageModelInputsTwoCapitalExpenditureValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoCapitalExpenditureValue);

        WACCDetailedPageModelInputsTwoCapitalExpenditureValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject()
                            .setCapitalExpenditure(Double.
                                    valueOf(
                                            WACCDetailedPageModelInputsTwoCapitalExpenditureValue
                                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().);
                }

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

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "Operating net working capital (NWC) is " +
                        "the non-cash (needs to be underlined) current assets minus non-debt (underlined) " +
                        "current liabilities.  You can use the last year's number, or a 'normalized' " +
                        "number for your company over time, or an industry average.\n\n" +
                        "In principle, NWC can be negative (i.e., a source of cash) if non-cash " +
                        "current assets are smaller than the non-debt current liabilities.  In our " +
                        "model, we do not allow negative NWC.  The reason is, allowing negative NWC " +
                        "to grow over time (as revenue grows) can not only inflate cash flows forecasts, " +
                        "but also make accounts payable unsustainable thereby impacting credit risk.  " +
                        "Hence, we put a floor of zero for this input.  \n\n" +
                        "When inputting the assumption for 'Operating NWC as % revenue', " +
                        "note that you are inputting the percentage for total (i.e., not " +
                        "incremental) revenue for the forecasted year.  In other words, the " +
                        "input you provide will calculate the total NWC for the year, based on" +
                        " which, the model will calculate the Change in NWC.");


                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoOperatingNWCValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoOperatingNWCValue);

        WACCDetailedPageModelInputsTwoOperatingNWCValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject()
                            .setOperatingNWC(Double.
                                    valueOf(
                                            WACCDetailedPageModelInputsTwoOperatingNWCValue
                                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().);
                }

            }
        });

        //Straight-line depreciation rule
        //Straight-line method; Depreciation Expense = Depreciable Amount/ Useful Life

        WACCDetailedPageModelInputsTwoStraightLineYears = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoStraightLineYears);

        WACCDetailedPageModelInputsTwoStraightLineYears.setText("Straight-line depreciation rule (#years)");

        WACCDetailedPageModelInputsTwoStraightLineYears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", ".");

                startActivity(intent);

            }

        });


        WACCDetailedPageModelInputsTwoStraightLineYearsValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoStraightLineValue);

        WACCDetailedPageModelInputsTwoStraightLineYearsValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject()
                            .setStraightLineDepreciationYears(Integer.
                                    valueOf(
                                            WACCDetailedPageModelInputsTwoStraightLineYearsValue
                                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().);
                }

            }
        });

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

        WACCDetailedPageModelInputsTwoTaxRateValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject()
                            .setTaxRate(Double.
                                    valueOf(
                                            WACCDetailedPageModelInputsTwoTaxRateValue
                                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().);
                }

            }
        });

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

        WACCDetailedPageModelInputsTwoBaseYearDepreciationValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject()
                            .setBaseYearDepreciation(Double.
                                    valueOf(
                                            WACCDetailedPageModelInputsTwoBaseYearDepreciationValue
                                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().);
                }

            }
        });

    }




}
