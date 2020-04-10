package com.example.freelivingtechapp

//import android.content.Intent
import android.graphics.Color
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.util.*

//import android.Manifest
//import android.content.Context
//import android.graphics.Bitmap
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.graphics.pdf.PdfDocument
//import android.os.Build
////import android.support.annotation.RequiresApi
//import androidx.annotation.RequiresApi
//import android.util.DisplayMetrics
//import android.util.Log
//import android.view.View
//import android.view.WindowManager
//import android.view.Display
//import android.widget.Button
//import android.widget.LinearLayout
//import android.widget.Toast
//import androidx.constraintlayout.widget.ConstraintLayout
//import com.karumi.dexter.Dexter
//import com.karumi.dexter.MultiplePermissionsReport
//import com.karumi.dexter.PermissionToken
//import com.karumi.dexter.listener.DexterError
//import com.karumi.dexter.listener.PermissionRequest
//import com.karumi.dexter.listener.PermissionRequestErrorListener
//import com.karumi.dexter.listener.multi.MultiplePermissionsListener
//import kotlinx.android.synthetic.main.app_bar_main.*
//import java.io.File
//import java.io.FileOutputStream
//import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graphs)

        setupbarchartData()

        setupLineChartData()

    }
    private fun setupLineChartData() {
        val lineChart= LineChart(this)
//        setContentView(lineChart)
//        val barchart= BarChart(this)
//        setContentView(barchart)

        val yVals = ArrayList<Entry>()
        yVals.add(Entry(0f, 30f, "0"))
        yVals.add(Entry(1f, 2f, "1"))
        yVals.add(Entry(2f, 4f, "2"))
        yVals.add(Entry(3f, 6f, "3"))
        yVals.add(Entry(4f, 8f, "4"))
        yVals.add(Entry(5f, 10f, "5"))
        yVals.add(Entry(6f, 22f, "6"))
        yVals.add(Entry(7f, 12.5f, "7"))
        yVals.add(Entry(8f, 22f, "8"))
        yVals.add(Entry(9f, 32f, "9"))
        yVals.add(Entry(10f, 54f, "10"))
        yVals.add(Entry(11f, 28f, "11"))

        val set1: LineDataSet
        set1 = LineDataSet(yVals, "DataSet 1")

        // set1.fillAlpha = 110
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        // set1.enableDashedLine(5f, 5f, 0f);
        // set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.color = Color.BLUE
        set1.setCircleColor(Color.BLUE)
        set1.lineWidth = 1f
        set1.circleRadius = 3f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 0f
        set1.setDrawFilled(false)

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1)
        val data = LineData(dataSets)

        // set data
        lineChart.setData(data)
        lineChart.description.isEnabled = false
        lineChart.legend.isEnabled = false
        lineChart.setPinchZoom(true)
        lineChart.xAxis.enableGridDashedLine(5f, 5f, 0f)
        lineChart.axisRight.enableGridDashedLine(5f, 5f, 0f)
        lineChart.axisLeft.enableGridDashedLine(5f, 5f, 0f)
//        lineChart.setDrawGridBackground()
        lineChart.xAxis.labelCount = 11
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.invalidate()
    }
    private fun setupbarchartData() {
        // create BarEntry for Bar Group

        val ecgspace = BarChart(this)
//        setContentView(barchart)

        val bargroup = ArrayList<BarEntry>()
        bargroup.add(BarEntry(0f, 30f, "0"))
        bargroup.add(BarEntry(1f, 2f, "1"))
        bargroup.add(BarEntry(2f, 4f, "2"))
        bargroup.add(BarEntry(3f, 6f, "3"))
        bargroup.add(BarEntry(4f, 8f, "4"))
        bargroup.add(BarEntry(5f, 10f, "5"))
        bargroup.add(BarEntry(6f, 22f, "6"))
        bargroup.add(BarEntry(7f, 12.5f, "7"))
        bargroup.add(BarEntry(8f, 22f, "8"))
        bargroup.add(BarEntry(9f, 32f, "9"))
        bargroup.add(BarEntry(10f, 54f, "10"))
        bargroup.add(BarEntry(11f, 28f, "11"))

        // creating dataset for Bar Group
        val barDataSet = BarDataSet(bargroup, "dataset")

        barDataSet.color = ContextCompat.getColor(this,R.color.amber)

        val data = BarData(barDataSet)
        ecgspace.data = data
        ecgspace.xAxis.position = XAxis.XAxisPosition.BOTTOM
        ecgspace.xAxis.labelCount = 11
        ecgspace.xAxis.enableGridDashedLine(5f, 5f, 0f)
        ecgspace.axisRight.enableGridDashedLine(5f, 5f, 0f)
        ecgspace.axisLeft.enableGridDashedLine(5f, 5f, 0f)
        ecgspace.description.isEnabled = false
        ecgspace.animateY(2000)
        ecgspace.legend.isEnabled = false
        ecgspace.setPinchZoom(true)
        ecgspace.data.setDrawValues(true)
        ecgspace.invalidate()

    }



}
