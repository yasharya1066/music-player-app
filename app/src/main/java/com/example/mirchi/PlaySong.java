package com.example.mirchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class PlaySong extends AppCompatActivity {

    Button btn_next,btn_previous,btn_pause;
    TextView songTextView;
    SeekBar songSeekbar;
    String sname;

    static MediaPlayer myMediaPlayer;
    int position;
    ArrayList<File> mySongs;
    Thread updateseekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btn_next=(Button)findViewById(R.id.next);
        btn_previous=(Button)findViewById(R.id.previous);
        btn_pause=(Button)findViewById(R.id.pause);

        songTextView= (TextView)findViewById(R.id.songLabel);
        songSeekbar = (SeekBar)findViewById(R.id.seekBar);

        updateseekbar = new Thread(){
            @Override
            public void run() {
                super.run();

                int totalDuration = myMediaPlayer.getDuration();
                int currentPosition=0;

                while(currentPosition<totalDuration){
                    try{
                        sleep(500);
                        currentPosition=myMediaPlayer.getCurrentPosition();
                        songSeekbar.setProgress(currentPosition);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        };

        if (myMediaPlayer != null) {
            myMediaPlayer.stop();
            myMediaPlayer.release();
        }

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        mySongs =(ArrayList) bundle.getParcelableArrayList("songs");

        sname= mySongs.get(position).getName();
        String songName =i.getStringExtra("songname");
        songTextView.setText(songName);
        songTextView.setSelected(true);

        position = bundle.getInt("pos",0);
        Uri u = Uri.parse(mySongs.get(position).toString());
        myMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
        myMediaPlayer.start();
        songSeekbar.setMax(myMediaPlayer.getDuration());

        updateseekbar.start();

        songSeekbar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.MULTIPLY);
        songSeekbar.getThumb().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_IN);

        songSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                myMediaPlayer.seekTo(seekBar.getProgress());

            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songSeekbar.setMax(myMediaPlayer.getDuration());
                if(myMediaPlayer.isPlaying()){
                    btn_pause.setBackgroundResource(R.drawable.icon_play);
                    myMediaPlayer.pause();
                }
                else{
                    btn_pause.setBackgroundResource(R.drawable.icon_pause);
                    myMediaPlayer.start();

                }
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMediaPlayer.stop();
                myMediaPlayer.release();
                position=((position+1)%mySongs.size());
                Uri u= Uri.parse(mySongs.get(position).toString());
                myMediaPlayer= MediaPlayer.create(getApplicationContext(),u);
                sname= mySongs.get(position).getName();
                songTextView.setText(sname);
                myMediaPlayer.start();
            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMediaPlayer.stop();
                myMediaPlayer.release();
                position = ((position-1)<0) ? (mySongs.size()-1):(position-1);
                Uri u = Uri.parse(mySongs.get(position).toString());
                myMediaPlayer = MediaPlayer.create(getApplicationContext(), u);
                sname = mySongs.get(position).getName();
                songTextView.setText(sname);
                myMediaPlayer.start();
            }
        });
    }


}