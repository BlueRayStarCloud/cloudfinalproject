package tw.nsysu.cloudfinalproject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainScreen extends FragmentActivity{

	private TabHost mTabHost;
	private TabManager mTabManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup();
		
		mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
		
		mTabHost.setCurrentTab(0);//�]�w�@�}�l�N����Ĥ@�Ӥ���
        mTabManager.addTab(
            mTabHost.newTabSpec("History").setIndicator("Histroy"),
            History.class, null);
        mTabManager.addTab(
            mTabHost.newTabSpec("Map").setIndicator("Map"),
            Map.class, null);
        mTabManager.addTab(
            mTabHost.newTabSpec("Info").setIndicator("Info"),
            Info.class, null);
        
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //�����o�ù��ѪR��  
        int screenWidth = dm.widthPixels;   //���o�ù����e
           
           
        TabWidget tabWidget = mTabHost.getTabWidget();   //���otab������
        int count = tabWidget.getChildCount();   //���otab���������X��
        if (count >= 3) {   
            for (int i = 0; i < count; i++) {   
                tabWidget.getChildTabViewAt(i)
                      .setMinimumWidth((screenWidth)/3);//�]�w�C�@�Ӥ����̤p���e��   
            }   
        }
      
		
		
	}

	

}