package vk.example.snake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Choose extends Activity{
	static int count1=0,count2=0;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose);
		
		Button def=(Button)findViewById(R.id.def);
		def.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				GFX.Hbird[0]=36;
				GFX.Hbird[1]=56;
				GFX.Hbird[2]=73;
				GFX.Hbird[3]=85;
				
				GFX.Hnest[0]=8;
				GFX.Hnest[1]=17;
				GFX.Hnest[2]=32;
				GFX.Hnest[3]=45;
		
				GFX.Abird[0]=6;
				GFX.Abird[1]=16;
				GFX.Abird[2]=33;
				GFX.Abird[3]=41;
				GFX.Anest[0]=71;
				GFX.Anest[1]=47;
				GFX.Anest[2]=68;
				GFX.Anest[3]=83;
				//ArrayValue.count1=6;
				ArrayValue.count2=4;
				ArrayValue.count1=4;
				try{
					Class ourClass=Class.forName("vk.example.snake."+cpu.str1);
					Intent ourIntent=new Intent(Choose.this , ourClass);
					startActivity(ourIntent);
					
					
					}
					catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				
			}
		});
		
		Button cus=(Button)findViewById(R.id.cus);
		cus.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent(Choose.this,ArrayValue.class);
		        startActivity(intent);
			}
		    
		});
		
	}
}
