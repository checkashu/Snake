package vk.example.snake;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class GFX extends Activity{
	
	public  static int Abird[]=new int[25];
	public static int Anest[]=new int[25];
	
	public  static int Hbird[]=new int[25];
	public static int Hnest[]=new int[25];
	
	Board ourView;
	 int A=0,B=0;
	Button dice; 
	static int i=0,c=0;
    ImageView image1,image2;
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		//ourView=new Board(this);			
		setContentView(R.layout.board);
		
		
		Button dice=(Button)findViewById(R.id.dice);
		 image1 = (ImageView) findViewById(R.id.img);
		 image2 = (ImageView) findViewById(R.id.img1);
		 RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams) 
			        image1.getLayoutParams();	
		 
		 RelativeLayout.LayoutParams mParams1 = (RelativeLayout.LayoutParams) 
			        image2.getLayoutParams();	
		 
		 Display display = getWindowManager().getDefaultDisplay(); 
		final int width = display.getWidth();  // deprecated
		 final int height = display.getHeight();
			
		 final int top=height;
		 
		 mParams.topMargin  =top;
		 mParams.leftMargin = 0;
		 image2.setLayoutParams(mParams);
		 mParams1.topMargin  =top+4;
		 mParams1.leftMargin = 0;
		 image2.setLayoutParams(mParams1);
		 ImageView setting=(ImageView)findViewById(R.id.setting);
		
		setting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GFX.this,Settings.class);
	            startActivity(intent); 
			}
		});
		dice.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView text=(TextView)findViewById(R.id.value);
				TextView turn=(TextView)findViewById(R.id.turn);
				int z=((int)(Math.random()*10000)%6)+1;
				 text.setText(z+" ");
				int w=width/10;
				
				if(c%2==0)
				{				
			        RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams) 
			        image1.getLayoutParams();	
			        turn.setText("turnB");
			        int t=A+z+1;
			        
			        A+=z;
			        if(A<99)
			        {
			        mParams.topMargin=top(A)*(top/11);
				       mParams.leftMargin=left(A)*w;
				       image1.setLayoutParams(mParams);
			        if(search(t)!=0)
			        {
			        	A=search(t);
			        
			        
			       mParams.topMargin=top(A)*(top/11);
			       mParams.leftMargin=left(A)*w;
			      
			       image1.setLayoutParams(mParams);
			      
			        } c++;
			        }
			        else if(A>99)
			        { 
			        	A-=z;c++;
			        }
			        
			        else
			        {
			        	Intent intent = new Intent(GFX.this,WinA.class);
			            startActivity(intent);	
			        }
			        	
				}
				else
				{
					RelativeLayout.LayoutParams mParams1 = (RelativeLayout.LayoutParams) 
					        image2.getLayoutParams();	
					turn.setText("turnA");
					        int t=B+z+1;
					    	B+=z;
					    	if(B<99)
					    	{
					    	 mParams1.topMargin=top(B)*(top/11);
						       mParams1.leftMargin=left(B)*w;
						       image2.setLayoutParams(mParams1);
					        if(search(t)!=0)
					        {
					        	B=search(t);
					        
					        mParams1.topMargin=top(B)*(top/11);
						       mParams1.leftMargin=left(B)*w;
						      
						       image2.setLayoutParams(mParams1);
					        }
					       c++;
					    	}
					    	else if(B>99)
					    	{
					    		B-=z;
					    		c++;
					    	}
					    	else
					    	{
					    		Intent intent = new Intent(GFX.this,WinB.class);
					            startActivity(intent);
					    	}
					    	
				}
			
				
			}
		});
	}
	
	public int search(int n)
	{
		
		for(int i=0;i<25;i++)
		{
			if(Abird[i]==n)
				return (Anest[i]-1);
			
			else if(Hbird[i]==n)
				return (Hnest[i]-1);
			
		}
		return 0;
	}
	public int left(int n)
	{
		int m=n/10;
		if(m%2==0)
			return n%10;
		else 
			return (9-n%10);
			
	}
	public int top(int n)
	{
		int m=n/10;
		return (9-m);
	}
	
	
}	
	
	