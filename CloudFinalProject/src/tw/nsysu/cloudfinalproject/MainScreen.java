package tw.nsysu.cloudfinalproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainScreen extends FragmentActivity{

	private TabHost mTabHost;
	private TabManager mTabManager;
	private String time;
	private double longtitude;
	private double latitude;
	private SQLiteDatabase db;
	private ListViewDBHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);
		
		
		Bundle bundle =this.getIntent().getExtras();
		
		
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup();
		
		mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
		
		mTabHost.setCurrentTab(0);//設定一開始就跳到第一個分頁
        mTabManager.addTab(
            mTabHost.newTabSpec("History").setIndicator("Histroy"),
            History.class, bundle);
        mTabManager.addTab(
            mTabHost.newTabSpec("Map").setIndicator("Map"),
            Map.class, null);
        mTabManager.addTab(
            mTabHost.newTabSpec("Info").setIndicator("Info"),
            Info.class, null);
        
        
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //先取得螢幕解析度  
        int screenWidth = dm.widthPixels;   //取得螢幕的寬
           
           
        TabWidget tabWidget = mTabHost.getTabWidget();   //取得tab的物件
        int count = tabWidget.getChildCount();   //取得tab的分頁有幾個
        if (count >= 3) {   
            for (int i = 0; i < count; i++) {   
                tabWidget.getChildTabViewAt(i)
                      .setMinimumWidth((screenWidth)/3);//設定每一個分頁最小的寬度   
            }   
        }
        
        
      
	
        
        
		
	}
	
	  public String getHistoryData(){
	    return "Apple 123";
	  }
	  public String getMapData(){
	    return "Google 456";
	  }
	  public String getInfoData(){
	    return "Facebook 789";
	  }
	 

	

}
