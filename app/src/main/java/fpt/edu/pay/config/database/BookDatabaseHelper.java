package fpt.edu.pay.config.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import fpt.edu.pay.model.Book;

public class BookDatabaseHelper extends DatabaseHelper<Book> {
    private static final String TABLE_NAME = "books";

    private static final String ID_COLUMN = "id";
    private static final String[] COLUMNS = { "user_id", "year_published", "price" };
    private static final String[] COLUMN_TYPES = { "TEXT", "INTEGER", "REAL" };


    public BookDatabaseHelper(Context context) {
        super(context, TABLE_NAME, ID_COLUMN, COLUMNS, COLUMN_TYPES);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public List<Book> getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Book> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId(cursor.getInt(1));
                book.setTitle(cursor.getString(2));
                book.setAuthor(cursor.getString(3));
                book.setYear(cursor.getInt(4));
                list.add(book);
            } while (cursor.moveToNext());
        }
        return list;
    }

    @Override
    public Book getById(String id) {
        Book book = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID_COLUMN + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            book = new Book();
            book.setId(cursor.getInt(1));
            book.setTitle(cursor.getString(2));
            book.setAuthor(cursor.getString(3));
            book.setYear(cursor.getInt(4));
        }
        cursor.close();
        db.close();

        return book;
    }

    @Override
    public void insert(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS[0],book.getTitle());
        contentValues.put(COLUMNS[1],book.getYear());
        contentValues.put(COLUMNS[2],book.getAuthor());
        db.insert(TABLE_NAME,null ,contentValues);
    }

    @Override
    public void update(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS[0],book.getTitle());
        contentValues.put(COLUMNS[1],book.getYear());
        contentValues.put(COLUMNS[2],book.getAuthor());
        db.update(TABLE_NAME, contentValues, ID_COLUMN + " = ?", new String[] { String.valueOf(book.getId()) });

        db.close();
    }

    @Override
    public void delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID_COLUMN + " = ?", new String[] { String.valueOf(id) });
        db.close();
    }
}
