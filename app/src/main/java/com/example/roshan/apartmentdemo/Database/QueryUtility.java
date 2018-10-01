package com.example.roshan.apartmentdemo.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class QueryUtility extends SQLiteOpenHelper{

    private final static String TENANTS_TABLE = "tenants";
    private final static String FLATS_TABLE = "flats";
    private final static String SESSION_TABLE = "session";

    private final static String DATABASE_NAME = "apartment";
    private final static int DATABASE_VERSION = 1;
    private Context context;

    String CREATE_FLAT_TABLE_QUERY = "CREATE TABLE " + FLATS_TABLE + " (name text, address text, city text, image blob)";
    String CREATE_SESSION_TABLE_QUERY = "CREATE TABLE " + SESSION_TABLE + " (userID text, password text)";
    String CREATE_TENANT_TABLE_QUERY = "CREATE TABLE " + TENANTS_TABLE + " (id text PRIMARY KEY, name text, flat text, FOREIGNKEY flat references flats(name), contact text, email text, password text, rent int, charges int, image blob)";


    private static QueryUtility instance;

    public static synchronized QueryUtility getInstance(Context context) {
        if (instance == null) {
            instance = new QueryUtility(context.getApplicationContext());
        }
        return instance;
    }

    private QueryUtility(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FLAT_TABLE_QUERY);
        db.execSQL(CREATE_TENANT_TABLE_QUERY);
        db.execSQL(CREATE_SESSION_TABLE_QUERY);
        ContentValues sessionValues = new ContentValues();
        sessionValues.put("userID", "null");
        sessionValues.put("password", "null");
        db.insert(SESSION_TABLE, null, sessionValues);
        Toast.makeText(context, "Created new Database", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String getSession() {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * from session;", null);
        if(cursor.moveToLast()) {
            if(cursor.getString(cursor.getColumnIndex("userID")).equals("null")) {
                return null;
            } else {
                return cursor.getString(cursor.getColumnIndex("userID"));
            }
        }
        return null;
    }

    public void setSessionTable(String userID, String password) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        db.delete("session", null, null);
        ContentValues sessionValues = new ContentValues();
        sessionValues.put("userID", userID);
        sessionValues.put("password", password);
        db.insert(SESSION_TABLE, null, sessionValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public ArrayList<String> getTenantNames(String tenantID) {
        Cursor cursor;
        if(tenantID == null) {
             cursor = getReadableDatabase().rawQuery("SELECT name from tenants", null);
        } else {
             cursor = getReadableDatabase().rawQuery("SELECT name from tenants WHERE id = '" + tenantID + "';", null);
        }
        ArrayList<String> nameList = new ArrayList<String>();
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false) {
            nameList.add(cursor.getString(0));
            cursor.moveToNext();
        }
        for(String name : nameList) {
            Log.i("NAMES", name);
        }
        return nameList;
    }



}