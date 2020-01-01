package com.example.learnrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Dname = "DevSoc1.db";
    public static final String Tname = "Notes";

    public static final String ID = "ID";
    public static final String Heading = "Heading";
    public static final String Description = "Description";

    public DatabaseHelper(Context context) {
        super(context, Dname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Tname + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Heading + " TEXT, " +
                Description + " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tname);
    }

    public boolean insertdata(String Head, String Des){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Heading,Head);
        contentValues.put(Description,Des);

        long result = db.insert(Tname,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }


    public Cursor getnotes(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Tname, null);
        return cursor;
    }

    public boolean updatenote(int updateID, String Head, String Des){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,updateID);
        contentValues.put(Heading,Head);
        contentValues.put(Description,Des);
        db.update(Tname,contentValues,"ID = ?", new String[] {Integer.toString(updateID)});
        return true;
    }

    public Integer deletenote(int deleteID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Tname, "ID = ?", new String[] { Integer.toString(deleteID)});
    }
}
