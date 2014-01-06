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
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy�~MM��dd��HH:mm:ss");
				Date curDate = new Date(System.currentTimeMillis()) ; // �����e�ɶ�
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
			//�p�GGPS�κ����w��}�ҡA�I�slocationServiceInitial()��s��m
			locationServiceInitial();
		} else {
			Toast.makeText(this, "�ж}�ҩw��A��", Toast.LENGTH_LONG).show();
			startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));	//�}�ҳ]�w����
		}
		

		
	
		
	}
	
	private void locationServiceInitial()
	{
		
		lms = (LocationManager) getSystemService(LOCATION_SERVICE);	//���o�t�Ωw��A��
		lms.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
		Location location = lms.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);	//�ϥ�GPS�w��y��
		getLocation(location);
	}
	
	private void getLocation(Location location) {	//�N�w���T��ܦb�e����
		if(location != null) {
			
			longtitude = location.getLongitude();	//���o�g��
			latitude = location.getLatitude();	//���o�n��
			System.out.println("�g�׬��G"+longtitude+",�n�׬��G"+latitude);
			
		}
		else {
			Toast.makeText(this, "�L�k�w��y��", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onLocationChanged(Location location) { //��a�I���ܮ�
		// TODO Auto-generated method stub
		getLocation(location);
		
	}


	@Override
	public void onProviderDisabled(String arg0) { //��GPS�κ����w��\��������
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String arg0) { //��GPS�κ����w��\��}��
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) { //�w�쪬�A����
		// TODO Auto-generated method stub
		
	}


	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_screen, menu);
		return true;
	}

}
