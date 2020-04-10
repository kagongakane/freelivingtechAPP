package com.example.freelivingtechapp

import android.Manifest
import android.content.pm.PackageManager
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.itextpdf.text.Document
import com.itextpdf.text.Image
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.nav_header_main.*
import java.io.FileOutputStream
import java.util.*


class Main2Activity : AppCompatActivity() {


    private val STORAGE_CODE: Int = 101;
    private lateinit var appBarConfiguration: AppBarConfiguration

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        fab.setOnClickListener {
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
            if (Build.VERSION.SDK_INT>Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    ==PackageManager.PERMISSION_DENIED){
                    val permission= arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permission,STORAGE_CODE)
                }
                else{
                    createPDF()
                }
            }
            else{
                createPDF()
            }
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_history, R.id.nav_statistics,
                R.id.nav_info, R.id.nav_menu
            ), drawerLayout
        )


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)




    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun createPDF(){
//        val logo= imageView
        val myDoc =Document()
        val mFileName=SimpleDateFormat("ddMMyyyy_HHmmss", Locale.getDefault()).format(System.currentTimeMillis())
        val mFilePath = Environment.getExternalStorageDirectory().toString()+"/"+mFileName+".pdf"
        try {
            PdfWriter.getInstance(myDoc,FileOutputStream(mFilePath))

            myDoc.open()

//            val mText =textEt.toString()
            val mText = "this is my pdf hope this works"

            myDoc.addAuthor("FREELIVINGTECH")

            myDoc.add(Paragraph(mText))

            myDoc.close()

            Toast.makeText(this,"$mFileName.pdf\nis saved to \n$mFilePath",Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
       when(requestCode){
           STORAGE_CODE -> {
               if(grantResults.size>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){

                   createPDF()
               }
               else{
                   Toast.makeText(this,"Permission Denied...",Toast.LENGTH_SHORT).show()

               }

           }
       }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
