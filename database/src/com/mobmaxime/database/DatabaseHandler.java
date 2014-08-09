package com.mobmaxime.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DB_Version = 1; // DB version

	private static final String DB_Name = "Data_Db";// DB name

	private static final String DB_table = "Name_Table"; // table name here

	private static final String Key_ID = "id"; // Column Name
	private static final String Key_Name = "Name"; // Column Name
	private static final String Key_Address = "Address"; // Column Name
	private static final String Key_Number = "Number"; // Column Name

	public DatabaseHandler(Context context) {

		super(context, DB_Name, null, DB_Version);
		Log.e("DatabaseHandler", "DatabaseHandler");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String Create_Contacts_Table = "CREATE TABLE " + DB_table + "("
				+ Key_ID + " INTEGER PRIMARY KEY," + Key_Name + " TEXT,"
				+ Key_Address + " TEXT," + Key_Number + " TEXT" + ")";

		Log.e("onCreate", Create_Contacts_Table);

		db.execSQL(Create_Contacts_Table);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLE IF EXISTS " + DB_table);

		// Create tables again
		onCreate(db);

	}

	public void addContact(contact contact) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(Key_Name, contact.getName()); // Contact Name
		values.put(Key_Address, contact.getAddress()); // Contact Phone
		values.put(Key_Number, contact.getPhone_number());

		db.insert(DB_table, null, values);
		db.close(); // Closing database connection

	}

	// Getting All Contacts
	public List<contact> getAllContacts() {
		List<contact> contactList = new ArrayList<contact>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + DB_table;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				contact contact = new contact();
				contact.setId(Integer.parseInt(cursor.getString(0)));

				contact.setName(cursor.getString(1));
				contact.setAddress(cursor.getString(2));
				contact.setPhone_number(cursor.getString(3));
				// Adding contact to list
				contactList.add(contact);
			} while (cursor.moveToNext());
		}
		return contactList;
	}
}
