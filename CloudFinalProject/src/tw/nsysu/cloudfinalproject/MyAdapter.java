package tw.nsysu.cloudfinalproject;

import android.content.Context;
import android.support.v4.app.ListFragment;
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
		return light.length;//���H�K���w�@��list
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return light[position];//���H�K���w�@��list
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
