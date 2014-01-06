package tw.nsysu.cloudfinalproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstScreen extends Activity implements LocationListener{
	
	private LocationManager lms;
	private Double longtitude;
	private Double latitude;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_firstscreen);
		
		Button strike = (Button)findViewById(R.id.Strike);
		strike.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View view) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
				Date curDate = new Date(System.currentTimeMillis()) ; // 獲取當前時間
		        String time = formatter.format(curDate);
				
				
		        Intent intent = new Intent();
				intent.setClass(FirstScreen.this, MainScreen.class);
				
				Bundle bundle = new Bundle();
				bundle.putString("Date", time);
				bundle.putDouble("Longtitude", longtitude);
				bundle.putDouble("Latitude", latitude);
				intent.putExtras(bundle);
				startActivity(intent); 
				//FirstScreen.this.finish(); 
				
			}
		
			
		});
		
		LocationManager status = (LocationManager) (this.getSystemService(Context.LOCATION_SERVICE));
		if (status.isProviderEnabled(LocationManager.GPS_PROVIDER) || status.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			//如果GPS或網路定位開啟，呼叫locationServiceInitial()更新位置
			locationServiceInitial();
		} else {
			Toast.makeText(this, "請開啟定位服務", Toast.LENGTH_LONG).show();
			startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));	//開啟設定頁面
		}
		

		
	
		
	}
	
	private void locationServiceInitial()
	{
		
		lms = (LocationManager) getSystemService(LOCATION_SERVICE);	//取得系統定位服務
		lms.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
		Location location = lms.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);	//使用GPS定位座標
		getLocation(location);
	}
	
	private void getLocation(Location location) {	//將定位資訊顯示在畫面中
		if(location != null) {
			
			longtitude = location.getLongitude();	//取得經度
			latitude = location.getLatitude();	//取得緯度
			System.out.println("經度為："+longtitude+",緯度為："+latitude);
			
		}
		else {
			Toast.makeText(this, "無法定位座標", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onLocationChanged(Location location) { //當地點改變時
		// TODO Auto-generated method stub
		getLocation(location);
		
	}


	@Override
	public void onProviderDisabled(String arg0) { //當GPS或網路定位功能關閉時
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String arg0) { //當GPS或網路定位功能開啟
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) { //定位狀態改變
		// TODO Auto-generated method stub
		
	}


	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_screen, menu);
		return true;
	}

}
