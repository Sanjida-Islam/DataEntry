package com.example.dataentry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperClass extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME = "mydb";
    private static  final String TABLE_NAME = "mytbl";

    private static  final String col_ID = "myid";
    private static  final String col_NAME = "myname";
    private static  final String col_PHONE = "myphone";

    public HelperClass(Context c) {
        super(c, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase data) {

        String s = "CREATE TABLE "+TABLE_NAME+"( "+col_ID+" INTIGER PRIMARY KEY, "+ col_NAME+" TEXT, "+col_PHONE+" TEXT)";
        data.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void AddDataToTable(ModelClass dt){


        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(col_NAME,dt.getName());
        cv.put(col_PHONE,dt.getPhone());

        sql.insert(TABLE_NAME,null,cv);
        sql.close();
    }



    public String[] viewData (){

        SQLiteDatabase sq =this.getReadableDatabase();
        String q="SELECT * FROM "+TABLE_NAME;
        Cursor c= sq.rawQuery(q,null);
        String[] recvied_data = new String[c.getCount()];
        c.moveToFirst();

        if(c.moveToFirst()){
            int count = 0;
            do{
                recvied_data[count] = "Name: "+c.getString(c.getColumnIndex(col_NAME+""))+"  "+"  Phone: "+c.getString(c.getColumnIndex(col_PHONE+""));
                count = count+1;
            }while (c.moveToNext());
        }

        return recvied_data;
    }


    public  void Delete_Bus(String bus_num){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE "+ col_NAME+"='"+bus_num+"'");
        db.close();

    }
}
