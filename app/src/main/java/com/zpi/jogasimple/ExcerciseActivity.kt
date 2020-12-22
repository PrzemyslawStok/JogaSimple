package com.zpi.jogasimple

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_excercise.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.mainView
import java.text.SimpleDateFormat
import java.util.*

class ExcerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val timeFormat = SimpleDateFormat("mm:ss", Locale.ENGLISH)
        var startTime : Long = 0;

        //val currentTime = System.currentTimeMillis()
        //val time: Int = 30-((currentTime-startTime)/1000).toInt()

        //timerView.setText("00:${time}")

        val thread = Thread {
            var number = 30
            for (i in 0..30) {

                runOnUiThread {
                    timerView.setText("00:${number}")
                }

                Thread.sleep(1000)
                number--
            }

            runOnUiThread{
                openStartDialog()
            }

        }

        startButton.setOnClickListener{
            startTime = System.currentTimeMillis()
            thread.start()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /*if(item.itemId==android.R.id.home)
            finish()
        */

        when(item.itemId){
            android.R.id.home->finish()
            R.id.id_start->{
                openStartDialog()
                return true
            }
            R.id.id_stop->{
                Snackbar.make(mainView, "Kliknięto menu stop...", Snackbar.LENGTH_SHORT).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun openStartDialog(){
        val dialogBuilder = AlertDialog.Builder(this)


        dialogBuilder.setMessage("Przykładowy opis ćwiczenia")
        dialogBuilder.setView(layoutInflater.inflate(R.layout.excercise_dialog_layout,null))

        dialogBuilder.setPositiveButton("OK"){
                dialog, id ->
        }


        val dialog = dialogBuilder.create()

        dialog.show()
    }
}