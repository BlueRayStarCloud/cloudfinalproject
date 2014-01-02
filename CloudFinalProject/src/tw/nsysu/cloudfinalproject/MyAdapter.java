package tw.nsysu.cloudfinalproject;

import android.content.Context;
import android.support.v4.app.ListFragment;
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
	private long time;
	
	private String[] light;
	private String[] location;
	
	private LayoutInflater myInflater;
	
	public MyAdapter(Context ctx,String[] light,String[] location) {
		myInflater = LayoutInflater.from(ctx);
		this.light=light;
		this.location=location;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return light.length;//先隨便指定一個list
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return light[position];//先隨便指定一個list
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
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
	 
	
	
	 viewtag.probability.setText(light[position]);
	 viewtag.location.setText(location[position]);
		
		
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
