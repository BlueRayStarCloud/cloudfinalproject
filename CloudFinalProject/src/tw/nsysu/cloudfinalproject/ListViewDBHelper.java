package tw.nsysu.cloudfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ListViewDBHelper extends SQLiteOpenHelper{

	private final static String DATABASE_NAME = "listview_database";
	private final static int DATABASE_VERSION = 1;
	private final static String TABLE_NAME = "listview_table";
	private final static String FEILD_ID = "_id";
	private final static String FEILD_CLIMATE = " Climate";
	private final static String FEILD_LIGHT = "light";
	private final static String FEILD_GENDER = "Gender";
	private final static String FEILD_SPEED = "Speed";
	private final static String FEILD_ROADSITUATION = "RoadSituation";
	private final static String FEILD_TYPEofACCIDENT = "TypeofAccident";
	private final static String FEILD_LOCATIONofACCIDENT = "LocationofAccident";
	private final static String FEILD_TIME = "Time";
	private final String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( " +
			FEILD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," +
			FEILD_CLIMATE+" INTEGER," +
			FEILD_LIGHT+" INTEGER," +
			FEILD_GENDER+" INTEGER," +
			FEILD_SPEED+" DOUBLE,"+
			FEILD_ROADSITUATION+" INTEGER,"+
			FEILD_TYPEofACCIDENT+" INTEGER,"+
			FEILD_LOCATIONofACCIDENT+" INTEGER,"+
			FEILD_TIME+" STRING"+
			")";
	private SQLiteOpenHelper dbHelper;
   
	public ListViewDBHelper(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		//database = dbHelper.getWritableDatabase();// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL(SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //刪除舊有的資料表
		onCreate(db);
		
	}
	
	public void insert(int climate,int light,int gender,double speed,int roadsituation,int typeofaccident,int locationofaccident,String time)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues(); 
        cv.put(FEILD_CLIMATE,climate);
        cv.put(FEILD_LIGHT,light);
        cv.put(FEILD_GENDER,gender);
        cv.put(FEILD_SPEED,speed);
        cv.put(FEILD_ROADSITUATION,roadsituation);
        cv.put(FEILD_TYPEofACCIDENT,typeofaccident);
        cv.put(FEILD_LOCATIONofACCIDENT,locationofaccident);
        cv.put(FEILD_TIME,time);
        db.insert(TABLE_NAME, null, cv);
     
    }
	
	/*public void insert(int locationofaccident,String time)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues(); 
        cv.put(FEILD_LOCATIONofACCIDENT,locationofaccident);
        cv.put(FEILD_TIME,time);
        db.insert(TABLE_NAME, null, cv);
     
    }
	
	public void insert(String time)
	{
		 SQLiteDatabase db=this.getWritableDatabase();
	     ContentValues cv=new ContentValues(); 
	     cv.put(FEILD_TIME,time);
	     db.insert(TABLE_NAME, null, cv);
	}*/


	@Override
	public synchronized void close() {
		// TODO Auto-generated method stub
		super.close();
	}

	
	
	
	

}
