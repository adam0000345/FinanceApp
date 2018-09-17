package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.facebook.drawee.backends.pipeline.Fresco;

public class WACCDetailedPageModelInputsTwo extends AppCompatActivity {

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
    private TextView WACCDetailedPageModelInputsTwoStraightLine;
    private TextView WACCDetailedPageModelInputsTwoStraightLineValue;
    private TextView WACCDetailedPageModelInputsTwoTaxRate;
    private TextView WACCDetailedPageModelInputsTwoTaxRateValue;
    private TextView WACCDetailedPageModelInputsTwoBaseYearDepreciation;
    private TextView WACCDetailedPageModelInputsTwoBaseYearDepreciationValue;


    //TODO add ability to pull data from website

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waccdetailedpagemodelinputstwo);

        Fresco.initialize(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);





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

        WACCDetailedPageModelInputsTwoInitialEBIT.setText("Initial EBIT as % revenue");

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

        WACCDetailedPageModelInputsTwoLastPeriodEBIT.setText("Last-period EBIT as % revenue");

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

        WACCDetailedPageModelInputsTwoCapitalExpenditure.setText("Capital expenditure as % revenue");

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

        WACCDetailedPageModelInputsTwoOperatingNWC.setText("Operating NWC as % revenue");

        WACCDetailedPageModelInputsTwoOperatingNWC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoOperatingNWC.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsTwoOperatingNWCValue
                = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsTwoOperatingNWCValue);

        //Straight-line depreciation rule

        WACCDetailedPageModelInputsTwoStraightLine = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsTwoStraightLine );

        WACCDetailedPageModelInputsTwoStraightLine.setText("Straight-line depreciation rule (#years)");

        WACCDetailedPageModelInputsTwoStraightLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsTwoStraightLine.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsTwo.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsTwoStraightLineValue
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
