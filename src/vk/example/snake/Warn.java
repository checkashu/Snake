
package vk.example.snake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Warn extends Activity{

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.warn);
		TextView text=(TextView)findViewById(R.id.text1);
		text.setText("you are giving wrong input");
		Button ok=(Button)findViewById(R.id.ok);
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try{
					Class ourClass=Class.forName("vk.example.snake."+ArrayValue.str);
					Intent ourIntent=new Intent(Warn.this , ourClass);
					startActivity(ourIntent);
					
					
					}
					catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				
				       
			}
		});
	}

}
