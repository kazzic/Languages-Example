package com.gordonzeng.gridlayoutdemo;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.widget.Button;
import android.util.Log;


public class MainActivity extends ActionBarActivity {


    MediaPlayer mPlayer;

    public void click(View view) {

        int id = view.getId();
        String ourId = "";
        ourId = view.getResources().getResourceEntryName(id);
        Log.i("button text", ourId);

//        int resourceId = getResources().getIdentifier(ourId, "raw", "com.gordonzeng.gridlayoutdemo");
//
//        MediaPlayer mplayer = MediaPlayer.create(this, resourceId);
//        mplayer.start();


        if (id == R.id.button1)
            mPlayer = MediaPlayer.create(this, R.raw.doyouspeakenglish);
        else if (id == R.id.button2)
            mPlayer = MediaPlayer.create(this, R.raw.hello);
        else if (id == R.id.button3)
            mPlayer = MediaPlayer.create(this, R.raw.goodevening);
        else if (id == R.id.button4)
            mPlayer = MediaPlayer.create(this, R.raw.howareyou);
        else if (id == R.id.button5)
            mPlayer = MediaPlayer.create(this, R.raw.ilivein);
        else if (id == R.id.button6)
            mPlayer = MediaPlayer.create(this, R.raw.mynameis);
        else if (id == R.id.button7)
            mPlayer = MediaPlayer.create(this, R.raw.please);
        else if (id == R.id.button8)
            mPlayer = MediaPlayer.create(this, R.raw.welcome);
        else
            return;
        mPlayer.start();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
