package com.example.socialnetworkingui;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DemoActivity extends Activity {
    private static final String TAG = "DemoActivity";
    public static final String SAVED_STATE_ACTION_BAR_HIDDEN = "saved_state_action_bar_hidden";
    
    boolean firstTime = true;
	int HEIGHT, WIDTH;
	Button profile, photos, likes, chat;
	int padSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        setContentView(R.layout.activity_demo);

        SlidingUpPanelLayout layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        layout.setShadowDrawable(getResources().getDrawable(R.drawable.above_shadow));
        layout.setAnchorPoint(0.3f);
        layout.setPanelSlideListener(new PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
                /*if (slideOffset < 0.2) {
                    if (getActionBar().isShowing()) {
                        getActionBar().hide();
                    }
                } else {
                    if (!getActionBar().isShowing()) {
                        getActionBar().show();
                    }
                }*/
            }

            @Override
            public void onPanelExpanded(View panel) {
                Log.i(TAG, "onPanelExpanded");

            }

            @Override
            public void onPanelCollapsed(View panel) {
                Log.i(TAG, "onPanelCollapsed");

            }

            @Override
            public void onPanelAnchored(View panel) {
                Log.i(TAG, "onPanelAnchored");

            }
        });
        
        
        profile = (Button) findViewById(R.id.follow);
		photos = (Button) findViewById(R.id.photos);
		likes = (Button) findViewById(R.id.likes);
		chat = (Button) findViewById(R.id.chat);
		
		
		HEIGHT = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getHeight();
		WIDTH = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getWidth();
		padSize = (HEIGHT / 40) - 4;
		
        
/*
        TextView t = (TextView) findViewById(R.id.main);
        t.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.umanoapp.com"));
                startActivity(i);
            }
        });

        t = (TextView) findViewById(R.id.name);
        t.setText(Html.fromHtml(getString(R.string.hello)));*/
        Button f = (Button) findViewById(R.id.follow);
        f.setText(Html.fromHtml(getString(R.string.slide)));
        f.setMovementMethod(LinkMovementMethod.getInstance());
        f.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Intent.ACTION_VIEW);
                //i.setData(Uri.parse("http://www.twitter.com/umanoapp"));
                //startActivity(i);
            }
        });


        boolean actionBarHidden = savedInstanceState != null ?
                savedInstanceState.getBoolean(SAVED_STATE_ACTION_BAR_HIDDEN, false): false;
        if (actionBarHidden) {
            getActionBar().hide();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_STATE_ACTION_BAR_HIDDEN, !getActionBar().isShowing());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.demo, menu);
        return true;
    }
    @Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (firstTime == true) {
			profile.setPadding((profile.getWidth() - 32) / 2,
					(profile.getHeight() / 2 - 16) + padSize,
					(profile.getWidth() - 32) / 2,
					(profile.getHeight() / 2 - 16) + padSize);
			photos.setPadding((photos.getWidth() - 32) / 2,
					(photos.getHeight() / 2 - 16) + padSize,
					(photos.getWidth() - 32) / 2, (photos.getHeight() / 2 - 16)
							+ padSize);
			likes.setPadding((likes.getWidth() - 32) / 2,
					(likes.getHeight() / 2 - 16) + padSize,
					(likes.getWidth() - 32) / 2, (likes.getHeight() / 2 - 16)
							+ padSize);
			chat.setPadding((chat.getWidth() - 32) / 2,
					(chat.getHeight() / 2 - 16) + padSize,
					(chat.getWidth() - 32) / 2, (chat.getHeight() / 2 - 16)
							+ padSize);

			// likes.setPadding(left, top, right, bottom)

			// likes.setPadding((likes.getWidth() - 32) / 2, 50,
			// (likes.getWidth() -
			// 32) / 2, 50);

			Button marker = (Button) findViewById(R.id.markerpos);
			Button pointer = (Button) findViewById(R.id.pointerpos);
			Button lastSeen = (Button) findViewById(R.id.lastseentime);

			marker.setPadding(20, 0, 0, 0);
			pointer.setPadding(20, 0, 0, 0);
			lastSeen.setPadding(20, 0, 0, 0);
			firstTime = false;
		}
	}


}
