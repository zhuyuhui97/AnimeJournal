package com.tanmaku.animejournal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;
import java.util.GregorianCalendar;

import android.support.design.*;


public class AddItemActivity extends ActionBarActivity {
    DatePicker datePicker;
    EditText animeNumber;
    EditText animeEpisode;
    ItemClass newItem;
    public final static String CHANGED_MESSAGE="com.tanmaku.animejournal.LIST_CHANGED";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        datePicker=(DatePicker)findViewById(R.id.addItemDatePicker);
        animeNumber=(EditText)findViewById(R.id.addItemAnimeNumber);
        animeEpisode=(EditText)findViewById(R.id.addItemAnimeEpisode);
        Date currentDate=new Date();
        datePicker.setMaxDate(currentDate.getTime());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
        return true;
    }
//====================================================================================================================
    public void trySave(View view){
        long animeNumberInt;
        int animeEpisodeInt;
        GregorianCalendar date=new GregorianCalendar(
                datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
        //检查数值是否为空
        if (animeEpisode.length()==0||animeNumber.length()==0){
            //若空
            AlertDialog.Builder emptyAlert=new AlertDialog.Builder(this);
            emptyAlert.setMessage(R.string.anime_inf_incorrect);
            emptyAlert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            emptyAlert.show();
            //若非空
        }else{
            animeNumberInt=Long.parseLong(animeNumber.getText().toString());
            animeEpisodeInt=Integer.parseInt(animeEpisode.getText().toString());
            newItem=new ItemClass(animeNumberInt,animeEpisodeInt,date);
            //TODO
            Intent listChangedIntent=new Intent(this,MainActivity.class);
            listChangedIntent.putExtra(CHANGED_MESSAGE,true);

            AddItemActivity.super.finish();
        }
    }
//====================================================================================================================
    public void exit(View view){
        AddItemActivity.super.finish();
    }
//====================================================================================================================

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_save_item) {
       //     return true;
       // }

        return super.onOptionsItemSelected(item);
    }
}
