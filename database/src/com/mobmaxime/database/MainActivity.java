package com.mobmaxime.database;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DatabaseHandler db = new DatabaseHandler(this);

		db.addContact(new contact("Dharmik", "Vapi", "9999999999"));
		db.addContact(new contact("Jigar", "Valsad", "1111999999"));
		db.addContact(new contact("Sagar", "Surat", "9999991111"));
		db.addContact(new contact("Sani", "Aba", "9999111999"));
		db.addContact(new contact("Harshad", "Bkatha", "9991199999"));
		db.addContact(new contact("Kunal", "Jagudan", "9911999999"));

		List<contact> contacts = db.getAllContacts();
		LinearLayout startText = (LinearLayout) findViewById(R.id.view1);

		for (contact cn : contacts) {
			String log = "Id: " + cn.getId() + " ,Name: " + cn.getName()
					+ " ,Phone: " + cn.getAddress();

			TextView b1 = new TextView(this);

			b1.setText("Id: " + cn.getId() + " ,Name: " + cn.getName()
					+ " ,Phone: " + cn.getPhone_number() + " ,Address: "
					+ cn.getAddress());
			startText.addView(b1);
		}

	}

}
