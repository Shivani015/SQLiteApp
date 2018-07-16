package com.example.shivanikoul.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBclass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Student";
    private static  final int DATABASE_VERSION = 1;

    public DBclass(Context context) { super(context,DATABASE_NAME,null,DATABASE_VERSION);}

      @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER (Name text, Password text, Number text,Type text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS USER");

        onCreate(db);

    }

    public  boolean onAddData(String name,String password, String number,String type){
        SQLiteDatabase db= getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Password",password);
        contentValues.put("Number",number);
        contentValues.put("Type",type);

        long status = db.insert("USER",null,contentValues);

        contentValues.clear();

        return  (status > -1);
    }

    Cursor getdata(){

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query("USER",null,null,null,null,null,null);
        return cursor;
    }


//    delete data

    public  void onDelete(String name){
        SQLiteDatabase db = getWritableDatabase();

        String[] arr = null;
        arr[0] = name;

        db.delete("USER","Name = ?",arr);

    }
//    update data
    void onUpdate(String mail) {
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues =new ContentValues();

        contentValues.put("mail",mail);

        String arr[] ={"",""};
        arr[0]=mail;
        db.update("user",contentValues,"mail=?",arr);
    }


}
