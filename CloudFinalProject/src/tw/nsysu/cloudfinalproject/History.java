package tw.nsysu.cloudfinalproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class History extends ListFragment{

private ListViewDBHelper dbHelper;
public String[] Climate = {"強風","大霧","下雨","陰天","晴天"};
public String[] Light = {"日間","晨間","暮間","夜間"};
public String[] Gender = {"男","女"};
public float speed;
public String[] RoadSituation = {"柏油","濕潤","有坑洞"};
public String[] TypeofAccident = {"人和汽車","機車和汽車","汽車和汽車"};
public String[] LocationofAccident = {"千光路","中山大學大門口","永和豆漿路口","建國路口"};
public String time;
	public History() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		Bundle bundle =this.getArguments();
		time = bundle.getString("Date");
		
		
	}



	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		dbHelper=new ListViewDBHelper(getActivity());
		
		/*ArrayAdapter<String> adapter 
        = new ArrayAdapter<String>(getActivity(),
             android.R.layout.simple_list_item_1,months);*/
        //System.out.println(time);
	    //longtitude = bundle.getDouble("Longtitude");
	    //latitude = bundle.getDouble("Latitude");
	    
		MyAdapter myadapter = new MyAdapter(getActivity(),Light,LocationofAccident,time);
        setListAdapter(myadapter);
        
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		//dbHelper = new ListViewDBHelper(getActivity());
		dbHelper.insert(0, 0, 0, 0.0, 0, 0, 0, time);
		dbHelper.close();
		
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_history,container,false);
				
	}
	

}
