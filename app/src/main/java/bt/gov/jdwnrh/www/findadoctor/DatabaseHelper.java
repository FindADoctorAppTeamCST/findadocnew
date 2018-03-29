/*package bt.gov.jdwnrh.www.findadoctor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Khushwanth on 07-Mar-18.
 * This CLASS File Consists the Methods to Manage the SQLite Database for the App.
 * The SQLite Database is used to store the app data in the phone Storage.
 * Features of the App such as the Notification Feature requires the Storage of notifications in the SQLite Database as the User may not * be always oline, and it would be impractical for the app to always downnload the already downloaded notifiation, causing more data *
 * usages and applag.
 * This Helper class is also used for temporary storage of the other app data that requires the SQLite implementation.
 * This Helper Class file is also used to temporarily store the availability status of the doctors, after retrieving it from the main Back End Database.
 */


<<<<<<< HEAD
/*public class DatabaseHelper extends SQLiteOpenHelper {
=======
<<<<<<< HEAD
/*public class DatabaseHelper extends SQLiteOpenHelper {
=======
public class DatabaseHelper extends SQLiteOpenHelper {
    //Final Variables Declarations go here
>>>>>>> 93d5079c6ed25bff1dd6090b0e2b166ad49f2a61
>>>>>>> 6ae399f94bb7e1e0cd6812ced1c10220f11b0b8e
    public static final String DATABASE_NAME="jdwnrh_findadoc";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }
<<<<<<< HEAD
<<<<<<< HEAD
}*/
=======
}
*/
>>>>>>> master
=======

    //Overriding Methods from SQLite Class
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate="";
        db.execSQL(queryCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL("");
    }

    //Other Methods go here...

}
*/
>>>>>>> 6ae399f94bb7e1e0cd6812ced1c10220f11b0b8e
