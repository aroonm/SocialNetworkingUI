package com.example.socialnetworkingui;

import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Contacts extends ListActivity {

	ArrayList<String> nameList = new ArrayList<String>();
	
	public class InitUserData {
		String userName;
		String userStatus;
	}
	
	UserAdapter userAdapter;
	ImportInfo imp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.list_view_list_activity);
		
		imp = new ImportInfo();
		imp.fetchContacts();

		userAdapter = new UserAdapter();
		setListAdapter(userAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		InitUserData userData = userAdapter.getUser(position);
		
		
		Intent userIntent = new Intent("com.example.socialnetworkingui.DEMOACTIVITY");
		startActivity(userIntent);
		
		//Toast.makeText(Contacts.this, userData.userName, Toast.LENGTH_LONG).show();
	}

	public class UserAdapter extends BaseAdapter {

		List<InitUserData> contactList = getDataForListView();
		
		@Override
		public int getCount() {
			return contactList.size();
		}

		@Override
		public InitUserData getItem(int pos) {
			return contactList.get(pos);
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int arg0, View view, ViewGroup vg) {

			if (view == null) {
				LayoutInflater inflater = (LayoutInflater) Contacts.this
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.listitem, vg, false);
			}
	
			TextView userName = (TextView) view.findViewById(R.id.textView1);
			TextView userStatus = (TextView) view.findViewById(R.id.textView2);

			InitUserData user = contactList.get(arg0);

			userName.setText(user.userName);
			userStatus.setText(user.userStatus);

			return view;
		}

		public InitUserData getUser(int position) {
			return contactList.get(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(
				R.menu.list_view_with_simple_adapter, menu);
		return true;
	}

	public List<InitUserData> getDataForListView() {
		List<InitUserData> initUserList = new ArrayList<InitUserData>();
		for (int i = 0; i < nameList.size(); i++) {
			InitUserData userObject = new InitUserData();
			userObject.userName = nameList.get(i);
			userObject.userStatus = "This is a description for " + nameList.get(i);
			initUserList.add(userObject);
		}
		return initUserList;
	}
	
	class ImportInfo{
		public void fetchContacts() {
			//String phoneNumber = null;
			//String email = null;
			Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
			//String _ID = ContactsContract.Contacts._ID;
			String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
			String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;
			//Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
			//String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
			//String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
			//Uri EmailCONTENT_URI =  ContactsContract.CommonDataKinds.Email.CONTENT_URI;
			//String EmailCONTACT_ID = ContactsContract.CommonDataKinds.Email.CONTACT_ID;
			//String DATA = ContactsContract.CommonDataKinds.Email.DATA;

			ContentResolver contentResolver = getContentResolver();
			Cursor cursor = contentResolver.query(CONTENT_URI, null,null, null, null);	

			// Loop for every contact in the phone
			if (cursor.getCount() > 0) {
				while (cursor.moveToNext()) {
					//String contact_id = cursor.getString(cursor.getColumnIndex( _ID ));
					String name = cursor.getString(cursor.getColumnIndex( DISPLAY_NAME ));
					int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex( HAS_PHONE_NUMBER )));

					if (hasPhoneNumber > 0) {
						//output.append("\n First Name:" + name);
						nameList.add(name);
						// Query and loop for every phone number of the contact
						//Cursor phoneCursor = contentResolver.query(PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?", new String[] { contact_id }, null);
						//while (phoneCursor.moveToNext()) {
							//phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
						//}
						//phoneCursor.close();
						// Query and loop for every email of the contact
						//Cursor emailCursor = contentResolver.query(EmailCONTENT_URI,	null, EmailCONTACT_ID+ " = ?", new String[] { contact_id }, null);
						//while (emailCursor.moveToNext()) {
							//email = emailCursor.getString(emailCursor.getColumnIndex(DATA));
						//}
						//emailCursor.close();
					}
				}
			}
			sortList();
		}

		private void sortList() {
			for(int i=0; i<nameList.size(); i++){
				for(int j=(i+1); j<nameList.size();j++){
					if((nameList.get(i).compareTo(nameList.get(j)))>0){
						String swap = nameList.get(i);
						nameList.set(i, nameList.get(j));
						nameList.set(j, swap);
					}
				}
			}
		}
	}

}
