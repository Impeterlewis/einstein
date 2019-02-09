package com.night.einstein;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static com.google.android.youtube.player.YouTubePlayer.PlayerStyle.MINIMAL;


@SuppressLint("Registered")
public class YoutubeEinsteinPlayer extends YouTubeBaseActivity {

    private static final String API_KEY = "AIzaSyBCebRfltYk1crlrvk8zdwEZVQz9Nmsu2Y";

    static String getApiKey(){
        return API_KEY;

    }
    private static final String TAG = "YoutubeEinsteinPlayer";

    YouTubePlayerView mYoutubePlayerView;
    //Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {

        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            Log.d(TAG, "onCreate: Done initializing.");
            youTubePlayer.loadPlaylist("PLSV9jDSU47bAfg9lLxJsYi6EwaGy8qTZX");
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            Intent intent = new Intent(getApplicationContext(), YoutubeEinsteinPlayer.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "There was an error, try to reopen the app",
                    Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einstein_youtube_player);
        Log.d(TAG, "onCreate: Starting.");
        //btnPlay = (Button) findViewById(R.id.buttonPlay);
        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);
        mYoutubePlayerView.initialize(getApiKey(), mOnInitializedListener);

        public static YouTubePlayer.PlayerStyle valueOf (MINIMAL);

       /* btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Initialize Youtube Player.");
                mYoutubePlayerView.initialize(getApiKey(), mOnInitializedListener);
            }
        }); */
    }
}
