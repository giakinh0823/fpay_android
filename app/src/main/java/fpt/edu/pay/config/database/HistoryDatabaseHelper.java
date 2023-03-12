package fpt.edu.pay.config.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fpt.edu.pay.model.Book;
import fpt.edu.pay.model.histoty.History;


public  class HistoryDatabaseHelper extends DatabaseHelper<History> {
    private static final String TABLE_NAME = "bank_trans";
    private static final String ID_COLUMN = "id";
    private static final String[] COLUMNS = { "user_id", "transactionType", "transactionTime", "amount", "status", "description" };
    private static final String[] COLUMN_TYPES = { "INTEGER", "TEXT", "TEXT", "INTEGER", "INTEGER", "TEXT" };

    public HistoryDatabaseHelper(Context context, String tableName, String idColumn, String[] columns, String[] columnTypes) {
        super(context, tableName, idColumn, columns, columnTypes);
    }

    public HistoryDatabaseHelper(Context context) {
        super(context, TABLE_NAME, ID_COLUMN, COLUMNS, COLUMN_TYPES);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public List<History> getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<History> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                History history = new History();
                history.setId(cursor.getInt(1));
                history.setTransactionTime(cursor.getString(2));
                history.setDescription(cursor.getString(3));
                history.setTransactionType(cursor.getString(4));

                history.setStatus(cursor.getInt(5));
                history.setUser_id(cursor.getInt(6));
                list.add(history);
            } while (cursor.moveToNext());
        }
        return list;
    }

    @Override
    History getById(String id) {
        return null;
    }

    @Override
    void insert(History object) {

    }

    @Override
    void update(History history) {

    }

    @Override
    void delete(String id) {

    }
}
