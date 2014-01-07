package tw.nsysu.cloudfinalproject;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

	
	private String[] Climate = {"�j��","�j��","�U�B","����","����"};
	private String[] Light = {"�鶡","�ᶡ","�Ƕ�","�]��"};
	private String[] Gender = {"�k","�k"};
	private float speed;
	private String[] RoadSituation = {"�f�o","���","���|�}"};
	private String[] TypeofAccident = {"�H�M�T��","�����M�T��","�T���M�T��"};
	private String[] LocationofAccident = {"�d����","���s�j�Ǥj���f","�éM���߸��f","�ذ���f","���ָ��f"};
	private String time;
	private ArrayList<String> arrayList_time;
	
	private String[] light;
	private String[] location;
	
	private LayoutInflater myInflater;
	
	public MyAdapter(Context ctx,String[] light,String[] location, String time,ArrayList<String> arrayList_time) {
		
		myInflater = LayoutInflater.from(ctx);
		this.light=light;
		this.location=location;
		this.time=time;
		this.arrayList_time=arrayList_time;
		System.out.println("�ӼƬ��G"+arrayList_time.size());
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayList_time.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrayList_time.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return Long.valueOf(arrayList_time.get(position));
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		// TODO Auto-generated method stub
	 ViewTag viewtag;
	 
	 if(contentView == null)
	 {
		 contentView = myInflater.inflate(R.layout.listview,null);
		 
		 viewtag = new ViewTag((TextView)contentView.findViewById(R.id.probability),
				              (TextView)contentView.findViewById(R.id.location));
		 
		 contentView.setTag(viewtag);
	 }
	 else
		 viewtag = (ViewTag)contentView.getTag();
	 
	//System.out.println(""+arrayList_time.get(0));
	viewtag.probability.setText("�ɶ��G"+arrayList_time.get(position));
	viewtag.location.setText("�a�I�G"+location[0]);
		
		
	return contentView;
	}
	

}

class ViewTag
{
	public TextView probability;
	public TextView location;
	public ViewTag(TextView probability, TextView location)
	{
		this.probability=probability;
		this.location=location;
	}
}
