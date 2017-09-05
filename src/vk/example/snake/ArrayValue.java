package vk.example.snake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ArrayValue extends Activity{
	
	public static String str=new String();
	public static String str1=new String();
	  static int count1=0,count2=0,d=0;int x,y;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addladder);

		Button add = (Button)findViewById(R.id.add);
		Button quit = (Button)findViewById(R.id.quit);
		final EditText n1=(EditText)findViewById(R.id.n1);
		final EditText n2=(EditText)findViewById(R.id.n2);
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 x = Integer.parseInt(n1.getText().toString());
				 y = Integer.parseInt(n2.getText().toString());
				
				if( x>=1 && x<=100 && y>=1 && y<=100)
				{
					for(int i=0;i<count1||i<count2;i++)
					{
						if(GFX.Hbird[i]==x||GFX.Hbird[i]==y||GFX.Hnest[i]==x||GFX.Hnest[i]==y||GFX.Abird[i]==x||GFX.Abird[i]==y||GFX.Anest[i]==x||GFX.Anest[i]==y)
						{
							d++;
							str1="you are giving a value which has already been accupied.\n try next.....";
							break;
						}
						if((count1+count2)>15)
						{
							d++;
							str1="No more than 15 birds or nests can be applied.\n please click done.....";
						}
					}
					if((x-1)/10 >(y-1)/10&&(d==0))
					{
						GFX.Hbird[count1]=x;
						GFX.Hnest[count1]=y;
						count1++;
					}
					else if((y-1)/10>(x-1)/10&&(d==0))
					{
						GFX.Abird[count2]=x;
						GFX.Anest[count2]=y;
						count2++;
					}
					else
					{
						str1="the bird and nest are falling in same row";
						warn();
					}
					
					n1.setText("");
					n2.setText("");
				}
				
				else
				{
					warn();
				}
				
				       
			}
		});
		
		quit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				GFXSurface.A=0;
				GFXSurface.B=0;
				try{
					Class ourClass=Class.forName("vk.example.snake."+cpu.str1);
					Intent ourIntent=new Intent(ArrayValue.this , ourClass);
					startActivity(ourIntent);
					
					
					}
					catch(ClassNotFoundException e){
						e.printStackTrace(); 
					} 
			}
		});
		
	}
	public void warn()
	{
		d=0;
		str="ArrayValue";
		Intent intent = new Intent(ArrayValue.this,Warn.class);
        startActivity(intent);
		
	}
	
}
