

package vk.example.snake;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

public class GFXSurface extends Activity implements OnTouchListener{

	MyBringBackSurface ourSurfaceView;
   	float xv,yv;
	
	Bitmap aBird,hBird,aNest,hNest,m1,m2,dice,sett,m3,m4;
	SurfaceHolder ourHolder;
	Thread ourThread=null;
	boolean isRunning=false;
	int a[]={4,8,18,32};
	int b[]={20,65,92,75};
	float changeX;
	static float x,y,y1,m1x=0,m2x=0,m2y=0,m1y=0,sx=0,sy=0;
	static int c=0,A=0,B=0,f=0;
	int z=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ourSurfaceView=new MyBringBackSurface(this);
		ourSurfaceView.setOnTouchListener(this);
		m2x=0;m2y=0;m1x=0;m1y=0;
		changeX=0;
		setContentView(ourSurfaceView);
	}
 
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
	if(event.getY()>9*y1/10 &&event.getX()<2*x/10)
	{	
		
		z=((int)(Math.random()*10000)%6)+1;
		if(c%2==0)
		{				
	        
			
	        int t=A+z+1;
	        
	        A+=z;
	        
	        if(A<99)
	        {
	          m1x=left(A)*x/10;
	          m1y=top(A)*y/10;	
	  
	             if(search(t)!=0)
	              {
	        	       A=search(t);
	                   m1x=left(A)*x/10;
		               m1y=top(A)*y/10;	
	      
	               } c++;
	        }
	        else if(A>99)
	        { 
	        	A-=z;c++;
	        }
	        
	        else
	        {
	        	Intent intent = new Intent(GFXSurface.this,WinA.class);
	            startActivity(intent);	
	        }
	        	
		}
		else
		{
			
			
			        int t=B+z+1;
			    	B+=z;
			    	if(B<99)
			    	{
			    		 m2x=left(B)*x/10;
			 	        m2y=top(B)*	y/10;
			        if(search(t)!=0)
			        {
			        	B=search(t);
			        	 m2x=left(B)*x/10;
			 	        m2y=top(B)*	y/10;
			       
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
			    		Intent intent = new Intent(GFXSurface.this,WinB.class);
			            startActivity(intent);
			    	}
			    	
			}
		}	
		else if(event.getY()>9*y1/10 &&event.getX()>8*x/10)
		{
			Intent intent = new Intent(GFXSurface.this,Settings.class);
			startActivity(intent); 
		}
		return false;
			
	}
	
	
	
	
	
	public int search(int n)
	{
		
		for(int i=0;i<25;i++)
		{
			if(GFX.Abird[i]==n)
				return (GFX.Anest[i]-1);
			
			else if(GFX.Hbird[i]==n)
				return (GFX.Hnest[i]-1);
			
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
	
///////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	public class MyBringBackSurface extends SurfaceView implements Runnable{
		
		
		public MyBringBackSurface(Context context) {
			// TODO Auto-generated constructor stub
			
			super(context);
			aBird=BitmapFactory.decodeResource(getResources(), R.drawable.images132x45);
			hBird=BitmapFactory.decodeResource(getResources(), R.drawable.images232x45);
			aNest=BitmapFactory.decodeResource(getResources(), R.drawable.index32x45);
			hNest=BitmapFactory.decodeResource(getResources(), R.drawable.indexq32x45);
			m1=BitmapFactory.decodeResource(getResources(), R.drawable.m1);
			m3=BitmapFactory.decodeResource(getResources(), R.drawable.m1);
			m2=BitmapFactory.decodeResource(getResources(), R.drawable.m2);
			m4=BitmapFactory.decodeResource(getResources(), R.drawable.m2);
			dice=BitmapFactory.decodeResource(getResources(), R.drawable.die);
			sett=BitmapFactory.decodeResource(getResources(), R.drawable.settings);
			ourHolder=getHolder();
			ourThread=new Thread(this);
			ourThread.start();
		}
		public void pause()
		{
			isRunning=false;
			while(true){
				
					try {
						ourThread.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			}
			ourThread=null;
		}
		public void resume()
		{
			isRunning=true;
			ourThread=new Thread(this);
			ourThread.start();
		}
	 
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning){
				if(!ourHolder.getSurface().isValid()) 
					continue;
		   		Canvas canvas = ourHolder.lockCanvas();
		   		canvas.drawColor(Color.YELLOW);
		   		Rect rect= new Rect();

				 y1=canvas.getHeight();
				 Paint textPaint=new Paint();
				 textPaint.setColor(Color.BLACK);
				 textPaint.setTextSize(y/30);
				 Paint textPaint1=new Paint();
				 textPaint1.setColor(Color.GRAY);
				 
				 textPaint1.setTextSize(y/10);
				 canvas.drawText(""+z,7*x/10, y1-y1/100, textPaint1);
				 canvas.drawText("TURN",3*x/10, y1-y1/100, textPaint1);
			    y = y1 - y1/10;
				 x=canvas.getWidth();
				
				int block[]=new int[4];
				block[0]=Color.BLUE;
				block[1]=(Color.GREEN);
				block[2]=(Color.RED);
				block[3]=Color.YELLOW;
				Paint paint=new Paint();
				
				
				Paint cFont=new Paint();
				cFont.setColor(Color.MAGENTA);
				cFont.setPathEffect(new DashPathEffect(new float[] {10,5}, 5));
			    //
				cFont.setStrokeWidth(4);
				float x1,x2; 
				
				int k=100;
				for(int i=0;i<10;i++)
				{
					for(int j=0;j<10;j++)
					{
						if(i%2==0)
						{x1=j*(x/10);x2=j*(x/10)+x/10;}
						
						else
							{x1=(10-j-1)*(x/10);x2=(10-j)*(x/10);}
						int a=(int)x1;
						int b=(int)(i*y/10);
						int c=(int)x2;
						int d=(int)(i*(y/10)+y/10);
							rect.set(a,b,c, d);	
						
						paint.setColor(block[(i*10+j)%4]);
						canvas.drawRect(rect,paint);
						/*if(k!=100)
						{
							if(k==a[countA])
							{
								canvas.drawBitmap(aBird,  x1+x/100, i*(y/10)+y/10-y/80, null);countA++;
							}
							else if(k==b[countB])
							{
								canvas.drawBitmap(aNest,  x1+x/100, i*(y/10)+y/10-y/80, null);countB++;
							}
							else
							
						}*/
						canvas.drawText(""+k, x1+x/100, i*(y/10)+y/10-y/80, textPaint);
						k--;
			           
					}
				}
				textPaint.setTextSize(300);
				
					float sx=0, sy=0, stx=0, sty=0;
					for(int c=0;c<ArrayValue.count1;c++)
					{
						float left=sx=GFX.Hbird[c]%10;
						float top =sy=GFX.Hbird[c]/10;
						if(sx!=0)
						{
					
							if(sy%2==0)
							{
								sx=(sx-1)*x/10+x/100;left=left-1;
							}
							else
							{
								sx=(10-sx)*x/10+x/100;
								left=10-left;
							}
						
							sy=(10-sy)*y/10-y/100;
						}
						else
						{
							if(sy%2==0)
							{
								sx=(sx-1)*x/10+x/100;left=0;
							}
								
							else
							{
								sx=(10-sx)*x/10+x/100;left=9;
							}
								
							top=top-1;sy=(10-sy)*y/10-y/100;
						}
					
						float left1=stx=GFX.Hnest[c]%10;
						float top1=sty=GFX.Hnest[c]/10;
						if(stx!=0)
						{
							if(sty%2==0)
							{
								stx=(stx-1)*x/10+x/100;left1=left1-1;
							}
							else
							{
								stx=(10-stx)*x/10+x/100;
								left1=10-left1;
							}
							sty=(10-sty)*y/10-y/100;
					
						}
						else
						{
							if(sty%2==0)
							{
								stx=(stx-1)*x/10+x/100;left1=0;
							}	
							else
							{
								stx=(10-stx)*x/10+x/100;left1=9;
							}
								
							top1=top1-1;sty=(10-sty)*y/10-y/100;
						}
						//canvas.drawPoints(pts, textPaint); 
						canvas.drawLine(sx, sy, stx, sty, cFont);
						canvas.drawBitmap(hBird, left*x/10, (9-top)*y/10, null);
						canvas.drawBitmap(hNest, left1*x/10, (9-top1)*y/10, null);
					
					}
				
				/*paint.setColor(block[3]);
				canvas.drawCircle(x/20, 19*y/20, 3*x/100,paint);*/
				//Path path=new Path();
				
				
					for(int c=0;c<ArrayValue.count2;c++)
					{
						float left=sx=GFX.Abird[c]%10;
						float top =sy=GFX.Abird[c]/10;
						if(sx!=0)
						{
					
							if(sy%2==0)
							{
								sx=(sx-1)*x/10+x/100;left=left-1;
							}
							else
							{
								sx=(10-sx)*x/10+x/100;
								left=10-left;
							}
						
							sy=(10-sy)*y/10-y/100;
						}
						else
						{
							if(sy%2==0) 
							{
								sx=(sx-1)*x/10+x/100;left=0;
							}
								
							else
							{
								sx=(10-sx)*x/10+x/100;left=9;
							}
								
							top=top-1;sy=(10-sy)*y/10-y/100;
						}
					
						float left1=stx=GFX.Anest[c]%10;
						float top1=sty=GFX.Anest[c]/10;
						if(stx!=0)
						{
							if(sty%2==0)
							{
								stx=(stx-1)*x/10+x/100;left1=left1-1;
							}
							else
							{
								stx=(10-stx)*x/10+x/100;
								left1=10-left1;
							}
							sty=(10-sty)*y/10-y/100;
					
						}
						else
						{
							if(sty%2==0)
							{
								stx=(stx-1)*x/10+x/100;left1=0;
							}	
							else
							{
								stx=(10-stx)*x/10+x/100;left1=9;
							}
								
							top1=top1-1;sty=(10-sty)*y/10-y/100;
						}
						canvas.drawLine(sx, sy, stx, sty, cFont);
						canvas.drawBitmap(aBird, left*x/10, (9-top)*y/10, null);
						canvas.drawBitmap(aNest, left1*x/10, (9-top1)*y/10, null);
					}
					//canvas.drawBitmap(dice, 0,y, null);
					if(f==0)
					{
						m2y=y-(y/10);
						m1y=y-(y/10)+6;
						f++;

					
					}
					
					canvas.drawBitmap(m2, m2x, m2y, null);
					canvas.drawBitmap(m1, m1x, m1y, null);
					if(c%2==0)
						canvas.drawBitmap(m3, x/2, y+y/50, null);
					else
						canvas.drawBitmap(m4,  x/2, y+y/50, null);
					canvas.drawBitmap(sett, x-x/7,y, null);
					canvas.drawBitmap(dice, 0,y, null);
				
						ourHolder.unlockCanvasAndPost(canvas);
						
					
			
			}
			
		
		}

	}
	
	
}
