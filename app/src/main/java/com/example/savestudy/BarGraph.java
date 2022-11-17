package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BarGraph extends AppCompatActivity {

    private BarChart barChart;
    private Button button;
    private EditText editText;
    private DBHelper db;
    private long date = System.currentTimeMillis();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        barChart = findViewById(R.id.barchart);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        addDataToGraph();
        barChart.invalidate();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveToDatabase();
            }
        });
    }

    public void SaveToDatabase(){
        db = new DBHelper(this);
        //it decides the format of xvalues.
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");
        String xvalues = sdf.format(date);

        String yvalue = editText.getText().toString();

        db.saveData(xvalues,yvalue);
        //addDataToGraph();
        barChart.invalidate();
        db.close();
    }

    public void addDataToGraph(){
        db = new DBHelper(this);
        final ArrayList<BarEntry> yvals = new ArrayList<BarEntry>();
        final ArrayList<String> ydata = db.queryYData();

        for(int i = 0; i < db.queryYData().size(); i++){
            BarEntry newBarEntry = new BarEntry(i, Float.parseFloat(db.queryYData().get(i)));
            yvals.add(newBarEntry);
        }

        final ArrayList<String> xvals = new ArrayList<String>();
        final ArrayList<String> xdata = db.queryXData();

        for(int i = 0; i < db.queryXData().size(); i++){
            xvals.add(xdata.get(i));
        }

        BarDataSet dataSet = new BarDataSet(yvals, "Example graph");

        ArrayList<IBarDataSet> dataSets1 = new ArrayList<>();
        dataSets1.add(dataSet);

        BarData data = new BarData(dataSets1);

        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xvals));

        barChart.setData(data);

        XAxis xAxis = barChart.getXAxis();

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setDrawLabels(true);
        xAxis.isCenterAxisLabelsEnabled();
        xAxis.setGranularityEnabled(true);

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);

        barChart.setMaxVisibleValueCount(5);
        barChart.setFitBars(true);
    }
}