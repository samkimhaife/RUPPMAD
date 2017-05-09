package kh.edu.rupp.fe.ruppmad.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import kh.edu.rupp.fe.ruppmad.adapter.Assignment;
import kh.edu.rupp.fe.ruppmad.adapter.Document;

/**
 * Created by KIMvHAI on 5/9/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String _DB_NAME = "RUPPMAD.db";
    public static final String _TABLE_NAME = "assTable";

    public static final String _ID = "_id";
    public static final String _TITLE = "_title";
    public static final String _DEADLINE = "_deadline";
    public static final String _THUMBNAILURL = "_thumbnailUrl";


    public DBHelper(Context context) {
        super(context, _DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tblAssignmentSql = "CREATE TABLE " + _TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                _TITLE + " TEXT, " +
                _DEADLINE + " TEXT, " +
                _THUMBNAILURL + " TEXT)";
        sqLiteDatabase.execSQL(tblAssignmentSql);

        long timestampMillis = System.currentTimeMillis();
        String currentDateTimeString = String.valueOf(timestampMillis);

        Assignment a1 = new Assignment(1, "MAD", currentDateTimeString, "http://www.corelynx.com/sites/default/files/technologies/mobile-application.png");
        Boolean inserted = insertAssignment(a1, sqLiteDatabase);
        Log.d("Inserted", inserted + "");
    }

    public boolean insertAssignment(Assignment assignment, SQLiteDatabase db) {
        ContentValues row = new ContentValues();
        row.put(_TITLE, assignment.getTitle());
        row.put(_THUMBNAILURL, assignment.getThumbnailUrl());
        row.put(_DEADLINE, assignment.getDateLine());
        long newId = db.insert(_TABLE_NAME, null, row);
        return (newId > -1);
    }

    private boolean insertAssignment(Assignment assignment) {
        return insertAssignment(assignment, getWritableDatabase());
    }

    public Assignment[] getAllAssignments() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {_ID, _TITLE, _DEADLINE, _THUMBNAILURL};

        Cursor cursor = db.query(_TABLE_NAME, columns, null, null, null, null, _ID);
        Assignment[] assignments = new Assignment[cursor.getCount()];

        int i = 0;
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String deadline = cursor.getString(2);
            String thumbnailUrl = cursor.getString(3);

            Assignment assignment = new Assignment(id, title, deadline, thumbnailUrl);
            assignments[i] = assignment;
            i++;
        }
        Log.d("size", assignments.length + "");
        return assignments;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
