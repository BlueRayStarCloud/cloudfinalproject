package tw.nsysu.cloudfinalproject;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class History extends ListFragment{

private ListViewDBHelper dbHelper;
private Cursor cursor;
private ArrayList<String> arrayList_time;
public String[] Climate = {"�j��","�j��","�U�B","����","����"};
public String[] Light = {"�鶡","�ᶡ","�Ƕ�","�]��"};
public String[] Gender = {"�k","�k"};
public float speed;
public String[] RoadSituation = {"�f�o","���","���|�}"};
public String[] TypeofAccident = {"�H�M�T��","�����M�T��","�T���M�T��"};
public String[] LocationofAccident = {"�d����","���s�j�Ǥj���f","�éM���߸��f","�ذ���f"};
public String time;
private double longtitude;
private double latitude;

	public History() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		Bundle bundle =this.getArguments();
		time = bundle.getString("Date");
		longtitude = bundle.getDouble("Longtitude");
		latitude = bundle.getDouble("Latitude");
		
		
		
	}



	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		/*ArrayAdapter<String> adapter 
        = new ArrayAdapter<String>(getActivity(),
             android.R.layout.simple_list_item_1,months);*/
        //System.out.println(time);
	    //longtitude = bundle.getDouble("Longtitude");
	    //latitude = bundle.getDouble("Latitude");
		//cursor=dbHelper.loadAll();
		
		
		
		
        
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		dbHelper=new ListViewDBHelper(getActivity());
		dbHelper.insert(0,0,0,0,0,0,0,time);
		cursor=dbHelper.loadAll();
		arrayList_time = new ArrayList<String>();
		int rows_num = cursor.getCount();	//���o��ƪ�C��
		//arrayList_time = new ArrayList(rows_num);
		 
		if(rows_num != 0) {
			cursor.moveToFirst();			//�N���в��ܲĤ@�����
			for(int i=0; i<rows_num; i++) {
				String temp = cursor.getString(0);	//���o��0�檺��ơA�ھ����type�ϥξA��y�k
				arrayList_time.add(temp);
				cursor.moveToNext();		//�N���в��ܤU�@�����
			}
		}
		cursor.close();		//����Cursor
		
		MyAdapter myadapter = new MyAdapter(getActivity(),Light,LocationofAccident,time,arrayList_time);
        setListAdapter(myadapter);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_history,container,false);
				
	}
	

}
