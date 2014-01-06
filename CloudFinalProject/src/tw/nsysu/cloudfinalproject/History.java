package tw.nsysu.cloudfinalproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class History extends ListFragment{

private ListViewDBHelper dbHelper;
public String[] Climate = {"�j��","�j��","�U�B","����","����"};
public String[] Light = {"�鶡","�ᶡ","�Ƕ�","�]��"};
public String[] Gender = {"�k","�k"};
public float speed;
public String[] RoadSituation = {"�f�o","���","���|�}"};
public String[] TypeofAccident = {"�H�M�T��","�����M�T��","�T���M�T��"};
public String[] LocationofAccident = {"�d����","���s�j�Ǥj���f","�éM���߸��f","�ذ���f"};
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
