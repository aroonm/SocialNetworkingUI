package com.example.socialnetworkingui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class UserInfo extends Activity {

	boolean firstTime = true;
	int HEIGHT, WIDTH;
	int padSize;
	Button profile, photos, likes, chat, about, loc, rel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.userinfo);
		profile = (Button) findViewById(R.id.profile);
		photos = (Button) findViewById(R.id.photos);
		likes = (Button) findViewById(R.id.likes);
		chat = (Button) findViewById(R.id.chat);
		about = (Button) findViewById(R.id.abouttitle);
		loc = (Button) findViewById(R.id.loctitle);
		rel = (Button) findViewById(R.id.reltitle);

		HEIGHT = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getHeight();
		WIDTH = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getWidth();
		padSize = (HEIGHT / 40) - 4;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
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
			about.setPadding(HEIGHT/30, HEIGHT/40, 0, 0);
			loc.setPadding(HEIGHT/30, HEIGHT/40, 0, 0);
			rel.setPadding(HEIGHT/30, HEIGHT/40, 0, 0);

			firstTime = false;
		}
	}

}
