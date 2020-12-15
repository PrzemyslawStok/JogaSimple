package com.zpi.jogasimple

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class ExcerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

        dialogBuilder.setPositiveButton("OK"){
                dialog, id ->
        }
        val dialog = dialogBuilder.create()

        dialog.show()
    }
}