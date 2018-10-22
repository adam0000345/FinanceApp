package com.example.finance.googlesheetsexample;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class WACCDetailedPageResults extends NavBarAndTitle {

    private double BaseYearRevenue;
    private double TaxRate;
    private double CostOfGoodsSoldAsPercentageOfRevenue;
    private double GrossProfit;
    private double SellingGeneralAdministrativeExpensesAsPercentageOfRevenue;
    private double InitialEBITPercentageOfRevenue;
    private double LastPeriodEBITPercentageOfRevenue;
    private double CapitalExpenditurePercentageOfRevenue;
    private double CustomEBIT;
    private double StraightLineDepreciationNumberOfYears;
    private double BaseYearDepreciation;
    private double ChangeInNonCashWorkingCapital;
    private double YearEarlierWorkingCapital;
    private double CurrentYearWorkingCapital;
    private double FreeCashFlow;
    private double WACC;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private Map<Integer, HashMap<String, String>> data;


    private TextView WACCDetailedResultsYearNumber;
    private TextView WACCDetailedResultsRevenueNumber;
    private TextView WACCDetailedResultsCostOfGoodsNumber;
    private TextView WACCDetailedResultsSGANumber;
    private TextView WACCDetailedResultsEBITNumber;
    private TextView WACCDetailedResultsDepreciationNumber;
    private TextView WACCDetailedResultsOperatingCashFlowNumber;
    private TextView WACCDetailedResultsCashExpenditureNumber;
    private TextView WACCDetailedResultsChangeInNetWorkingCapitalNumber;
    private TextView WACCDetailedResultsFreeCashFlowNumber;
    private TextView WACCDetailedResultsWACCNumber;
    private TextView WACCDetailedResultsDiscountFactorNumber;
    private TextView WACCDetailedResultsPVNumber;


    //decided to use card views instead of layout views
    //because on every year, I wanted to leave the option
    //to post comments or remarks to justify possible growth
    //projections on any given year


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.waccdetailedpageresults, frameLayout);

        data = new HashMap<Integer, HashMap<String,String>>();

        for (int i = 0; i < 5; i++) {

            data.put(i, innerDataGenerator("WACCDetailedResultsYearNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsRevenueNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsCostOfGoodsNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedPageResultsSGANumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsEBITNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsDepreciationNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsOperatingCashFlowNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsCashExpenditureNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsChangeInNetWorkingCapitalNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsFreeCashFlowNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsWACCNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsDiscountFactorNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsWACCNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsPVVNumber", ""));

            Log.d("TESTER", data.get(0).toString());

        }


//        getLayoutInflater().inflate(R.layout.waccdetailedpageresults, frameLayout);
//
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new MainAdapter(data);
//        mRecyclerView.setAdapter(mAdapter);


        //http://pages.stern.nyu.edu/~adamodar/New_Home_Page/AccPrimer/accstate.htm

        //http://people.stern.nyu.edu/adamodar/pdfiles/eqnotes/valenhdcf.pdf8


        //iterate through the multiple years selected and do
        //following calculations

        //currentyear<getWaccDetailedObject().getNumberOfForecastPeriods()

        for (int currentyear = 0; currentyear < 5;
             currentyear++) {


            //set current year
            //TextView WACCDetailedResultsYearNumber =
            //        this.findViewById(R.id.WACCDetailedResultsYearNumber);
            //WACCDetailedResultsYearNumber.setText(String.valueOf(currentyear));

            data.get(currentyear).put("WACCDetailedResultsYearNumber",
                    "Year " + String.valueOf(currentyear));




            //handle Net Working Capital calculation here
            if (currentyear == 0) {
                YearEarlierWorkingCapital = 0;
                CurrentYearWorkingCapital =
                        getWaccDetailedObject().getOperatingNWC();
            } else {
                YearEarlierWorkingCapital = CurrentYearWorkingCapital;
                CurrentYearWorkingCapital =
                        getWaccDetailedObject().getOperatingNWC();
            }



            //Free Cash Flows To Firm Calculation
            //EBIT(1-t) - (Capital Expenditures- Depreciation) - Change in non-cash working capital=

            //Free Cash Flow to Firm (FCFF)

            //Cash Flows To Equity Investors
            //Net income - (Capital Expenditures - Depreciation) - Change in non-cash
            //Working Capital - (Principal Repaid - New Debt Issues) - Preferred Dividend
            //-new Debt Issues = Free Cash Flow to Equity
            BaseYearRevenue = getWaccDetailedObject().getBaseRevenue();

            //Revenue

            data.get(currentyear).put("WACCDetailedResultsRevenueNumber", String.valueOf(BaseYearRevenue));

            TaxRate = getWaccDetailedObject().getTaxRate();


            //Operating Profit Margin = Operating Income / Sales Revenue
            //EBIT in period t = Revenues in period t * Expected operating margin in period t
            //Thus, if you expect operating margins to change over time, you should not use the fundamental
            // growth equation developed in the last section as your base growth rate. Instead, you should forecast
            // revenues and margins over time, and estimate the operating income as the product of the two.
            CostOfGoodsSoldAsPercentageOfRevenue =
                    getWaccDetailedObject().getCostOfGoodsSoldAsPercentage();

            //Cost Of Goods Sold

            data.get(currentyear).put("WACCDetailedResultsCostOfGoodsNumber",
                    String.valueOf(CostOfGoodsSoldAsPercentageOfRevenue));


            //Calculate Gross Profit
            //Gross Profit = Revenue - COGS
            GrossProfit = BaseYearRevenue - CostOfGoodsSoldAsPercentageOfRevenue;


            //includes Research and Development costs
            SellingGeneralAdministrativeExpensesAsPercentageOfRevenue =
                    getWaccDetailedObject().getSGAValue();

            //SGA & R+D

            data.get(currentyear).put("WACCDetailedPageResultsSGANumber",
                    String.valueOf(SellingGeneralAdministrativeExpensesAsPercentageOfRevenue));


            //use above
            //Operating Income Calculation
            InitialEBITPercentageOfRevenue =
                    getWaccDetailedObject().getInitialEBIT();

            //EBIT (Operating Income)

            data.get(currentyear).put("WACCDetailedResultsEBITNumber",
                    String.valueOf(InitialEBITPercentageOfRevenue));


            //allows you to predict what the final EBIT would be in the last period, left to default at
            //InitialEBIT
            LastPeriodEBITPercentageOfRevenue =
                    getWaccDetailedObject().getLastYearEBIT();


            CapitalExpenditurePercentageOfRevenue =
                    getWaccDetailedObject().getCapitalExpenditure();


            //Calculate Cash Expenditure
            data.get(currentyear).put("WACCDetailedResultsCashExpenditureNumber",
                    String.valueOf(BaseYearRevenue * CapitalExpenditurePercentageOfRevenue));

            //Working capital, also known as net working capital, is the difference between a company’s current assets,
            // like cash, accounts receivable (customers’ unpaid bills) and inventories of raw materials and finished
            // goods, and its current liabilities, like accounts payable.

            //Working Capital = Current Assets - Current Liabilities





            //       OperatingIncome (EBIT) = Gross Income -
            //                (Operating Expenses + Depreciation & Amortization); if Capex is equal to Depreciation
            if (getWaccDetailedObject().getDepreciationOption()
                    == "Will assume Depreciation = Capex") {
                CustomEBIT = GrossProfit
                        - (SellingGeneralAdministrativeExpensesAsPercentageOfRevenue
                        + CapitalExpenditurePercentageOfRevenue);
            } else {
                //       OperatingIncome (EBIT) = Gross Income -
                //       (Operating Expenses + Depreciation & Amortization); if Straight-line approach is used
                CustomEBIT = GrossProfit - (SellingGeneralAdministrativeExpensesAsPercentageOfRevenue
                        + (BaseYearDepreciation / StraightLineDepreciationNumberOfYears));
            }

            //EBIT (Operating Income)

            data.get(currentyear).put("WACCDetailedResultsEBITNumber",
                    String.valueOf(CustomEBIT));


            StraightLineDepreciationNumberOfYears
                    = getWaccDetailedObject()
                    .getStraightLineDepreciationYears();


            BaseYearDepreciation
                    = getWaccDetailedObject()
                    .getBaseYearDepreciation();

            //Depreciation

            data.get(currentyear).put("WACCDetailedResultsDepreciationNumber",
                    String.valueOf(BaseYearDepreciation));






            //given multiple year input, different forecasted revenue numbers, different operating NWC calculated
            //as a result, different changes in non-cash working capital is calculated
            ChangeInNonCashWorkingCapital =
                    CurrentYearWorkingCapital - YearEarlierWorkingCapital;

            //Set Change in Net Working Capital Here
            data.get(currentyear).put("WACCDetailedResultsChangeInNetWorkingCapitalNumber",
                    String.valueOf(ChangeInNonCashWorkingCapital));



            //Free Cash Flows To Firm Calculation
            //Free Cash Flow to Firm (FCFF)
            //EBIT(1-t) - (Capital Expenditures- Depreciation)
            // //- Change in non-cash working capital
            //assumption EBIT is provided, depreciation = capex
            if (getWaccDetailedObject()
                    .getDepreciationOption() == "Will assume Depreciation = Capex"
                    &&
                    getWaccDetailedObject().getOperatingIncomeOption()
                            == "Will input percent EBIT (Operating Margin)") {
                FreeCashFlow = InitialEBITPercentageOfRevenue * (1 - TaxRate)
                        - (CapitalExpenditurePercentageOfRevenue - BaseYearDepreciation
                ) - ChangeInNonCashWorkingCapital;
            }




            ////assumption EBIT is provided, depreciation = straightline
            if (getWaccDetailedObject().getOperatingIncomeOption()
                    == "Will input percent EBIT (Operating Margin)"
                    && getWaccDetailedObject().getDepreciationOption()
                    == "Will use straight line rule") {

                FreeCashFlow = InitialEBITPercentageOfRevenue * (1 - TaxRate)
                        - (CapitalExpenditurePercentageOfRevenue -
                        BaseYearDepreciation / StraightLineDepreciationNumberOfYears
                ) - ChangeInNonCashWorkingCapital;
            }


            ////assumption EBIT is not provided, CustomEBIT, depreciation = capex
            if (getWaccDetailedObject().getOperatingIncomeOption()
                    == "Will input percent EBIT (Operating Margin)"
                    && getWaccDetailedObject()
                    .getDepreciationOption()
                    == "Will input percent CGS and percent SGA") {

                //calculate EBIT here
                FreeCashFlow = CustomEBIT * (1 - TaxRate)
                        - (CapitalExpenditurePercentageOfRevenue -
                        BaseYearDepreciation
                ) - ChangeInNonCashWorkingCapital;
            }

            //Free Cash Flow (FCFF)

            data.get(currentyear).put("WACCDetailedResultsFreeCashFlowNumber",
                    String.valueOf(FreeCashFlow));




            //Operating Cash Flow, this is Free Cash Flow (FCFF) - cash or capital expenditure

            data.get(currentyear).put("WACCDetailedResultsOperatingCashFlowNumber",
                    String.valueOf(FreeCashFlow -
                            (BaseYearRevenue * CapitalExpenditurePercentageOfRevenue)));

            //WACC Calculation
            //https://www.investopedia.com/terms/w/wacc.asp
            data.get(currentyear).put("WACCDetailedResultsWACCNumber",
                    String.valueOf(getWaccDetailedObject().getWACC()));

        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainAdapter(data);
        mRecyclerView.setAdapter(mAdapter);


    }

    protected HashMap<String, String> innerDataGenerator(String key, String value) {
        final HashMap<String, String> innerdata = new HashMap<String, String>();
        innerdata.put(key,value);

        return innerdata;
    }


}
