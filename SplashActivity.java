package com.bdl.willy_android_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.VideoView;
import android.os.Bundle;
import 	android.net.Uri;
import 	android.media.MediaPlayer;
import 	android.content.Intent;

public class SplashActivity extends AppCompatActivity {

    VideoView videoView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.yourmp4);
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        videoView.start();
    }

    private void startNextActivity() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }


}

