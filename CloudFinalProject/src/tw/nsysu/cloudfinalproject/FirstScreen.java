package tw.nsysu.cloudfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class FirstScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_firstscreen);
		
		Button strike = (Button)findViewById(R.id.Strike);
		strike.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View view) {
				
				Intent intent = new Intent();
				intent.setClass(FirstScreen.this, MainScreen.class);
				startActivity(intent); 
				FirstScreen.this.finish(); 
				
			}
		
			
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_screen, menu);
		return true;
	}

}
