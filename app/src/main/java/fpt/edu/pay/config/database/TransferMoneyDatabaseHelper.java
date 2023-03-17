package fpt.edu.pay.config.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpt.edu.pay.model.Money;

public class TransferMoneyDatabaseHelper extends DatabaseHelper<Money> {
    private static final String TABLE_NAME = "money";
    private static final String ID_COLUMN = "id";
    private static final String[] COLUMNS = { "total_money", "friend_name", "is_zalo_pay", "number_phone" };
    private static final String[] COLUMN_TYPES = { "REAL", "TEXT", "INTEGER", "TEXT" };

    public TransferMoneyDatabaseHelper(Context context, String tableName, String idColumn, String[] columns, String[] columnTypes) {
        super(context, tableName, idColumn, columns, columnTypes);
    }

    public TransferMoneyDatabaseHelper(Context context) {
        super(context, TABLE_NAME, ID_COLUMN, COLUMNS, COLUMN_TYPES);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public List<Money> getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Money> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                Money money = new Money();
                money.setId(cursor.getInt(0));
                money.setTotalMoney(cursor.getFloat(1));
                money.setFriendName(cursor.getString(2));
                money.setZaloPay(cursor.getInt(3));
                money.setNumberPhone(cursor.getString(4));
                list.add(money);
            } while (cursor.moveToNext());
        }
        return list;
    }

    @Override
    Money getById(String id) {
        return null;
    }


    @Override
    public void insert(Money money) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS[0],money.getTotalMoney());
        contentValues.put(COLUMNS[1],money.getFriendName());
        contentValues.put(COLUMNS[2],money.isZaloPay());
        contentValues.put(COLUMNS[3],money.getNumberPhone());

        db.insert(TABLE_NAME,null ,contentValues);
    }

    @Override
    void update(Money money) {

    }

    @Override
    void delete(String id) {

    }


}
