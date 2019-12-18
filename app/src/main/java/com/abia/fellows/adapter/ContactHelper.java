package com.abia.fellows.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.abia.fellows.models.ContactModel;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION= 1;


    private static final String DATABASE_NAME = "contact_db";


    public ContactHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContactModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertUserDetails (String fullname,String phone, String email, String gender,
                                   String state){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  values = new ContentValues();
        values.put(ContactModel.COLUMN_FULLNAME, fullname);
        values.put(ContactModel.COLUMN_PHONE, phone);
        values.put(ContactModel.COLUMN_EMAIL,email);
        values.put(ContactModel.COLUMN_GENDER,gender);
        values.put(ContactModel.COLUMN_STATE,state);
        long newData = db.insert(ContactModel.TABLE_NAME, null, values);
        db.close();

     }

     //get user details
    public ArrayList<HashMap<String, String >>getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT fullname, phone, email, gender, state FROM " + ContactModel.TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            HashMap<String, String> user = new HashMap<>();
            user.put("fullname", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_FULLNAME)));
            user.put("phone", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_PHONE)));
            user.put("email", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_EMAIL)));
            user.put("gender", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_GENDER)));
            user.put("state", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_STATE)));

            userList.add(user);
        }

        return userList;
    }
    public ArrayList<HashMap<String, String >>getUsersID(int userid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT fullname, phone, email, gender, state FROM" + ContactModel.TABLE_NAME;

        Cursor cursor = db.query(ContactModel.TABLE_NAME, new String[] {ContactModel.COLUMN_FULLNAME, ContactModel.COLUMN_PHONE,
        ContactModel.COLUMN_EMAIL, ContactModel.COLUMN_GENDER, ContactModel.COLUMN_STATE}, ContactModel.COLUMN_ID+ "=?",
                new String[] {String.valueOf(userid)}, null,null,null,null);

        while (cursor.moveToNext()){
            HashMap<String, String> user = new HashMap<>();
            user.put("fullname", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_FULLNAME)));
            user.put("phone", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_PHONE)));
            user.put("email", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_EMAIL)));
            user.put("gender", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_GENDER)));
            user.put("state", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_STATE)));

            userList.add(user);
        }

        return userList;
    }
     //public void getUserDetails (String fullname, String phone, )
     //public void showfullnamengender(SQLiteDatabase db) {

         //we used rawQuery(sql, selectionargs) for fetching all the employees
        // Cursor cursorEmployees = db.qu("SELECT ContactModel., FROM ContactModel.contacts", null);
 //    }
}
