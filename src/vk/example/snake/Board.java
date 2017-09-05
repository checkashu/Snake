package vk.example.snake;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class Board extends View {
	
	Bitmap aBird,hBird,aNest,hNest,m1,m2;
	/*int a[]={4,8,18,32};
	int countA=0,countB=0,b[]={20,65,92,75};
	*/
	//ArrayValue arrayValue=new ArrayValue();
	
	public  static int x,y;
	public Board(Context context) {
		
		// TODO Auto-generated constructor stub
		super(context);
		
	}
	public Board(Context context, AttributeSet attrs) {
	    super(context, attrs);
	    init(context);
	}

	public Board(Context context, AttributeSet attrs, int defStyle) {
	    super(context, attrs, defStyle);
	    init(context);
	}

	private void init(Context context) {
		
	    //do stuff that was in your original constructor...
		
		aBird=BitmapFactory.decodeResource(getResources(), R.drawable.images132x45);
		hBird=BitmapFactory.decodeResource(getResources(), R.drawable.images232x45);
		aNest=BitmapFactory.decodeResource(getResources(), R.drawable.index32x45);
		hNest=BitmapFactory.decodeResource(getResources(), R.drawable.indexq32x45);
		m1=BitmapFactory.decodeResource(getResources(), R.drawable.m1);
		m2=BitmapFactory.decodeResource(getResources(), R.drawable.m2);
	}

	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.draw(canvas);
		//canvas.drawColor(Color.WHITE);
		Rect rect= new Rect();

		 y=canvas.getHeight();
		 Paint textPaint=new Paint();
		 textPaint.setColor(Color.BLACK);
		 textPaint.setTextSize(y/30);
	    y = y - y/10;
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
		int x1,x2,k=100;
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(i%2==0)
				{x1=j*(x/10);x2=j*(x/10)+x/10;}
				
				else
					{x1=(10-j-1)*(x/10);x2=(10-j)*(x/10);}
					rect.set(x1,i*y/10,x2, i*(y/10)+y/10);	
				
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
		
			int sx=0, sy=0, stx=0, sty=0;
			for(int c=0;c<ArrayValue.count1;c++)
			{
				int left=sx=GFX.Hbird[c]%10;
				int top =sy=GFX.Hbird[c]/10;
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
			
				int left1=stx=GFX.Hnest[c]%10;
				int top1=sty=GFX.Hnest[c]/10;
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
				int left=sx=GFX.Abird[c]%10;
				int top =sy=GFX.Abird[c]/10;
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
			
				int left1=stx=GFX.Anest[c]%10;
				int top1=sty=GFX.Anest[c]/10;
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
			//canvas.drawBitmap(m1, GFX.A, GFX.B, null);
			//canvas.drawBitmap(m2, GFA, B, null);
		}
	
	

	}