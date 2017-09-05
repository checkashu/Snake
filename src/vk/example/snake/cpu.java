package vk.example.snake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class cpu extends Activity{
	static int count1=0,count2=0;
	static String str1;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cpu);
		
		Button one=(Button)findViewById(R.id.one);
		one.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			str1="GFX1";
				
														
						Intent intent = new Intent(cpu.this,Choose.class);
				        startActivity(intent);
					
				
			}
		});
		
		Button two=(Button)findViewById(R.id.two);
		two.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				str1="GFXSurface";
				Intent intent = new Intent(cpu.this,Choose.class);
		        startActivity(intent);
			}
		    
		});
		
	}
}
