package com.example.finance.googlesheetsexample;

public class WACCDetailedObject {

    private String OperatingIncomeOption;
    private String DepreciationOption;
    private String WACCOption;
    private String TerminalGrowthRateOption;
    private String CompanyName;
    private int BaseYear;
    private int NumberOfForecastPeriods;
    private int BaseRevenue;
    private double AnnualRevenueGrowthPercentage;
    private boolean RevenueGrowthFadeToTerminalGrowth;
    private double CostOfGoodsSoldAsPercentage;

    public String getDepreciationOption() {
        return DepreciationOption;
    }

    public void setDepreciationOption(String depreciationOption) {
        DepreciationOption = depreciationOption;
    }

    public String getOperatingIncomeOption() {
        return OperatingIncomeOption;
    }

    public void setOperatingIncomeOption(String operatingIncomeOption) {
        DepreciationOption = operatingIncomeOption;
    }


    public String getWACCOption(){
        return WACCOption;
    }

    public void setWACCOption(String WACCOption) {
        DepreciationOption = WACCOption;
    }


    public String getTerminalGrowthRateOption(){
        return TerminalGrowthRateOption;
    }

    public void setTerminalGrowthRateOption(String terminalGrowthRateOption) {
        DepreciationOption = terminalGrowthRateOption;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getBaseYear() {
        return BaseYear;
    }

    public void setBaseYear(int baseYear) {
        BaseYear = baseYear;
    }


    public int getNumberOfForecastPeriods() {
        return NumberOfForecastPeriods;
    }

    public void setNumberOfForecastPeriods(int numberOfForecastPeriods) {
        NumberOfForecastPeriods = numberOfForecastPeriods;
    }

    public int getBaseRevenue() {
        return BaseRevenue;
    }

    public void setBaseRevenue(int baseRevenue) {
        BaseRevenue = baseRevenue;
    }

    public double getAnnualRevenueGrowthPercentage() {
        return AnnualRevenueGrowthPercentage;
    }

    public void setAnnualRevenueGrowthPercentage(double annualRevenueGrowthPercentage) {
        AnnualRevenueGrowthPercentage = annualRevenueGrowthPercentage;
    }

    public boolean getRevenueGrowthFadeToTerminalGrowth() {
        return RevenueGrowthFadeToTerminalGrowth;
    }

    public void setRevenueGrowthFadeToTerminalGrowth(boolean revenueGrowthFadeToTerminalGrowth) {
        RevenueGrowthFadeToTerminalGrowth = revenueGrowthFadeToTerminalGrowth;
    }


    public double getCostOfGoodsSoldAsPercentage() {
        return CostOfGoodsSoldAsPercentage;
    }

    public void setCostOfGoodsSoldAsPercentage(double costOfGoodsSoldAsPercentage) {
        CostOfGoodsSoldAsPercentage = costOfGoodsSoldAsPercentage;
    }





}
