package advance.iak.advance3.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydata";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_PEOPLE =
            "CREATE TABLE " + PeopleContract.PeopleEntry.TABLE_NAME + " (" +
                    PeopleContract.PeopleEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    PeopleContract.PeopleEntry.PEOPLE_NAME + " TEXT, " +
                    PeopleContract.PeopleEntry.PEOPLE_ADDRESS + " TEXT " +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
