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

	
	private String[] Climate = {"強風","大霧","下雨","陰天","晴天"};
	private String[] Light = {"日間","晨間","暮間","夜間"};
	private String[] Gender = {"男","女"};
	private float speed;
	private String[] RoadSituation = {"柏油","濕潤","有坑洞"};
	private String[] TypeofAccident = {"人和汽車","機車和汽車","汽車和汽車"};
	private String[] LocationofAccident = {"千光路","中山大學大門口","永和豆漿路口","建國路口","五福路口"};
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
		System.out.println("個數為："+arrayList_time.size());
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
	viewtag.probability.setText("時間："+arrayList_time.get(position));
	viewtag.location.setText("地點："+location[0]);
		
		
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
