package com.example.finance.googlesheetsexample;

import android.app.ProgressDialog;
import android.graphics.ColorSpace;
import android.media.audiofx.DynamicsProcessing;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import com.example.finance.googlesheetsexample.androidlabs.gsheets1.JSONparser;
import com.example.finance.googlesheetsexample.androidlabs.gsheets1.MyArrayAdapter;
import com.example.finance.googlesheetsexample.androidlabs.gsheets1.MyDataModel;
import com.example.finance.googlesheetsexample.post.PostData;
import com.example.finance.googlesheetsexample.util.InternetConnection;
import com.example.finance.googlesheetsexample.util.Keys;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;


public class EquityValueFirmValue extends AppCompatActivity {


        TextView tvStockTickerSymbol;
        String StockTickerSymbol;
        String ModelLabel;
        Button button;
        private ArrayList<MyDataModel> list;
        private MyArrayAdapter adapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.equityvaluefirmvalue);
            Fresco.initialize(this);

            //button=(Button)findViewById(R.id.EquityValueFirmValueSubmitButton);
            tvStockTickerSymbol=(EditText)findViewById(R.id.SavedStockSymbol);



            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            ActionBar actionbar = getSupportActionBar();
            //actionbar.setDisplayHomeAsUpEnabled(true);
            //actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    StockTickerSymbol = tvStockTickerSymbol.getText().toString();
//                    ModelLabel="EquityValueFirmValue";
//
//                    if (InternetConnection.checkConnection(getApplicationContext())) {
//                        new GetDataTask().execute();
//
//                    } else {
//                        Snackbar.make(view, "Internet Connection Not Available", Snackbar.LENGTH_LONG).show();
//                    }
//                }
//
//            }   );

            list = new ArrayList<>();

            adapter = new MyArrayAdapter(this, list);




        }

    /**
     * Creating Get Data Task for Getting Data From Web
     */
    class GetDataTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog;
        int jIndex;
        int x;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /**
             * Progress Dialog for User Interaction
             */

            x=list.size();

            if(x==0)
                jIndex=0;
            else
                jIndex=x;

            dialog = new ProgressDialog(EquityValueFirmValue.this);
            dialog.setTitle("Hey Wait Please..."+x);
            dialog.setMessage("I am getting your JSON");
            dialog.show();
        }

        @Nullable
        @Override
        protected Void doInBackground(Void... params) {

            /**
             * Getting JSON Object from Web Using okHttp
             */
            JSONObject jsonObject = JSONparser.getDataByStockSymbol(StockTickerSymbol, ModelLabel);

            try {
                /**
                 * Check Whether Its NULL???
                 */
                if (jsonObject != null) {
                    /**
                     * Check Length...
                     *
                     *
                     */
                    if(jsonObject.length() > 0) {
                        /**
                         * Getting Array named "contacts" From MAIN Json Object
                         */
                        JSONArray array = jsonObject.getJSONArray(Keys.KEY_ENTRY);

                        /**
                         * Check Length of Array...
                         */


                        int lenArray = array.length();
                        if(lenArray > 0) {
                            for(jIndex = 0; jIndex <= lenArray; jIndex++) {

                                /**
                                 * Creating Every time New Object
                                 * and
                                 * Adding into List
                                 */
                                MyDataModel model = new MyDataModel();

                                /**
                                 * Getting Inner Object from contacts array...
                                 * and
                                 * From that We will get Name of that Contact
                                 *
                                 */
                                JSONObject innerObject = array.getJSONObject(jIndex);

                                //Log.e("MYAPP", "unexpected JSON exception", e);

                                try {
                                    int year = innerObject.getInt(Keys.KEY_YEAR);
                                    int cashflowtoequity = innerObject.getInt(Keys.KEY_CFTOEQUITY);
                                    int cashflowtofirm = innerObject.getInt(Keys.KEY_CFTOFIRM);
                                    int difference = innerObject.getInt(Keys.KEY_DIFFERENCE);

                                    model.setYear(year);
                                    model.setCashFlowToEquity(cashflowtoequity);
                                    model.setCashFlowToFirm(cashflowtofirm);
                                    model.setDifference(difference);

                                }
                                //probably not best practice here, this can be improved
                                catch (JSONException je) {
                                    Log.i(JSONparser.TAG, "JSONPARSER error" + je.getLocalizedMessage());

                                    //not needed
                                    model.flipTerminalboolean();

                                    try {

                                        int terminalcashflowtoequity = innerObject.getInt(Keys.KEY_TERMINALCFTOEQUITY);
                                        int terminalcashflowtofirm = innerObject.getInt(Keys.KEY_TERMINALCFTOFIRM);
                                        int terminaldifference = innerObject.getInt(Keys.KEY_TERMINALDIFFERENCE);

                                        model.setTerminalCashFlowToEquity(terminalcashflowtoequity);
                                        model.setTerminalCashFlowToFirm(terminalcashflowtofirm);
                                        model.setTerminaldifference(terminaldifference);
                                    }
                                    catch(JSONException JE){
                                        Log.i(JSONparser.TAG, "JSONPARSER error" + JE.getLocalizedMessage());
                                    }


                                }


                                /**
                                 * Getting Object from Object "phone"
                                 */
                                //JSONObject phoneObject = innerObject.getJSONObject(Keys.KEY_PHONE);
                                //String phone = phoneObject.getString(Keys.KEY_MOBILE);


                                /**
                                 * Adding numeric values from excel sheet to List...
                                 */
                                list.add(model);
                            }
                        }
                    }
                } else {

                }
            } catch (JSONException je) {
                Log.i(JSONparser.TAG, "JSONPARSER error" + je.getLocalizedMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            /**
             * Checking if List size if more than zero then
             * Update ListView
             */


            if(list.size() > 0) {
                adapter.notifyDataSetChanged();
                //use the fetched data for calculations here

                double EquityValue = 0;
                double ValueOfFirm = 0;

                for (int i=0; i < adapter.getCount(); i++){
                    MyDataModel dataModel = adapter.getItem(i);

                    //cost of equity and cost of capital can either be asked for or calculated based off on inputs
                    double CostOfEquity = .12;
                    double CostOfCapital = .09;

                    //int FreeCashFlowToEquity = Net Income - (Capital Expenditures - Depreciation) -
                    //(Change in Non-cash Working Capital)+ (New Debt Issued - Debt Repayments)

                    //assuming Two-stage FCFE model, designed to value a firm which is expected to grow
                    //much faster than a stable firm in the initial period and at a stable rate after that.

                    //calculate Return on Equity
                    //Return on Equity = Net Income/Shareholder's Equity
                    //int ReturnOnEquity = 0/0;


                    int TerminalValueCFToEquity  = 0;
                    int TerminalValueDifference = 0;
                    int TerminalValueCFToFirm = 0;

                    EquityValue = EquityValue += ((Double.valueOf(dataModel.getCashFlowToEquity()))/(Math.pow(1+CostOfEquity, i+1)));
                    ValueOfFirm = ValueOfFirm += ((Double.valueOf(dataModel.getCashFlowToFirm()))/(Math.pow(1+CostOfEquity, i+1)));
                }

            } else {
                Snackbar.make(findViewById(R.id.parentLayout), "No Data Found", Snackbar.LENGTH_LONG).show();
            }
        }


    }


}
