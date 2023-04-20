package com.example.baithuchanh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.baithuchanh.model.Work;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "workmanager";
    private final static int DATABASE_VERSION =1;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table work("+
                "id integer primary key autoincrement,"+
                "name text,"+
                "description text,"+
                "status text,"+
                "collab integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertWork(Work w) {
        ContentValues values = new ContentValues();
        values.put("name",w.getName());
        values.put("description",w.getDescription());
        values.put("status",w.getStatus());
        if (w.isCollaboration())
            values.put("collab",1);
        else
            values.put("collab",0);
        SQLiteDatabase st = getWritableDatabase();
        return st.insert("work",null,values);
    }

    public List<Work> getWork(){
        List<Work> list = new ArrayList<>();
        String sql="select w.id,w.name,w.description,w.status,w.collab "+
                "from work w";
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs=st.rawQuery(sql,null);
        while (rs != null && rs.moveToNext()){
            boolean x;
            if (rs.getInt(4) == 1) x = true;
                else x = false;
            list.add(new Work (rs.getInt(0),rs.getString(1),rs.getString(2),rs.getString(3),x));
        }
        rs.close();
        return list;
    }

    public List<Work> searchWorkByName(String name){
        List<Work> list = new ArrayList<>();
        String sql="select w.id,w.name,w.description,w.status,w.collab "+
                "from work w "+
                "where name like ?";
        String[] agrs ={"%"+name+"%"};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs=st.rawQuery(sql,agrs);
        while (rs != null && rs.moveToNext()){
            boolean x;
            if (rs.getInt(4) == 1) x = true;
            else x = false;
            list.add(new Work (rs.getInt(0),rs.getString(1),rs.getString(2),rs.getString(3),x));
        }
        rs.close();
        return list;
    }

//    public void deleteAll(){
//        List<Work> list = getWork();
//        String sql = "delete from work where id <= ?";
//        SQLiteDatabase st = getWritableDatabase();
//        String[] agrs= {Integer.toString(list.size())};
//        st.execSQL(sql,agrs);
//
//    }
}
