package com.example.socialnetworkingui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

//https://dl-ssl.google.com/android/eclipse/

public class User extends Activity {
	boolean firstTime = true;
	int HEIGHT, WIDTH;
	Button profile, photos, likes, chat;
	int padSize;
	View likePanel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.userlayout);

		profile = (Button) findViewById(R.id.profile);
		photos = (Button) findViewById(R.id.photos);
		likes = (Button) findViewById(R.id.likes);
		chat = (Button) findViewById(R.id.chat);

		HEIGHT = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getHeight();
		WIDTH = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getWidth();
		padSize = (HEIGHT / 40) - 4;

		profile.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent playIntent = new Intent(
						"com.example.socialnetworkingui.USERINFO");
				startActivity(playIntent);
			}
		});
		photos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent playIntent = new Intent(
						"com.example.socialnetworkingui.PHOTOS");
				startActivity(playIntent);
			}
		});
		likes.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent playIntent = new Intent(
						"com.example.socialnetworkingui.LIKES");
				startActivity(playIntent);
			}
		});
		chat.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent playIntent = new Intent(
						"com.example.socialnetworkingui.CHAT");
				startActivity(playIntent);
			}
		});

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
