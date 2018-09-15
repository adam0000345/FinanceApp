package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finance.googlesheetsexample.androidlabs.gsheets1.MyArrayAdapter;
import com.example.finance.googlesheetsexample.androidlabs.gsheets1.MyDataModel;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

public class WACCDetailedPageOne extends AppCompatActivity {

    private ListView listView;
    private ArrayList<MyDataModel> list;
    private MyArrayAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private TextView textView;
    private TextView WACCDescription;
    private TextView FCFFDescription;
    private TextView CostOfCapitalDescription;
    private TextView TerminalValueDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waccdetailedpageone);

        Fresco.initialize(this);

        //!!!!!!!!!!!!!FORMAT THIS EVENTUALLY!!!!!!!!!!!!!!!!!!!!!
        //Below is repeat code from the MainPage, MainPage and Userlist use
        //the same code as below, see if there is a way to condense this

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        textView = (TextView) this.findViewById(R.id.WACCTextView);


        WACCDescription = (TextView) this.findViewById(R.id.WACCDescription);
        WACCDescription.setText("What is WACC Method of Valuation?");

        WACCDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WACCDetailedPageOne.this, pdf_viewer.class));
                //Logic

            }

        });

        FCFFDescription = (TextView) this.findViewById(R.id.FCFFDescription);
        FCFFDescription.setText("What is Free Cash Flow to Firm (FCFF)?");

        FCFFDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopUpWindow popUpWindow = new PopUpWindow();
                //TODO: look into setting text like above way
                Intent intent = new Intent(WACCDetailedPageOne.this, PopUpWindow.class);
                intent.putExtra("message", "FCFF is free cash flow to the firm.  It is" +
                        " the cash flow generated by the firm's operating assets," +
                        "net of taxes, after reinvestment needs have been met.  It is " +
                        "derived using the principle that we should focus on the money " +
                        "that actually comes into and goes out of the firm, without " +
                        "reflecting the effects of debt financing.  It is defined as:" +
                        "\n\nFCFF = EBITx(1-t) + Depreciation - ∆NWC - Capex" +
                        "\n\nwhere EBIT is operating income, t is the tax rate, Depreciation " +
                        "is the non-cash charge that is added back, ∆NWC is change in operating " +
                        "net working capital (i.e., change in non-cash current assets minus " +
                        "change in non-debt current liabilities), and Capex is Capital " +
                        "Expenditure." +
                        "\n\nWe can think of Capex-Depreciation+∆NWC as the firm's net " +
                        "reinvestment needs." +
                        "\n\nSimply put, if FCFF is a positive number, it is the total cash " +
                        "flow that is available to service debt payments and cash flows " +
                        "to equity, including dividends and stock buybacks.  If " +
                        "negative, it represents new capital that has to be raised by the " +
                        "firm from either debt or equity.");

                //



                startActivity(intent);

            }

        });

        CostOfCapitalDescription = (TextView) this.findViewById(R.id.CostOfCapitalDescription);
        CostOfCapitalDescription.setText("What is Cost of Capital?");

        //TODO: Get subscripts to work properly
        CostOfCapitalDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageOne.this, PopUpWindow.class);
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

        TerminalValueDescription = (TextView) this.findViewById(R.id.TerminalValueDescription);
        TerminalValueDescription.setText("What is Terminal Value?");

        TerminalValueDescription
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageOne.this, PopUpWindow.class);
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







    }


}
