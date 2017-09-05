package vk.example.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyBringBack extends View{
	
	Bitmap gBall;

	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//gBall=BitmapFactory.decodeResource(getResource(), id)
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.draw(canvas);
		canvas.drawColor(Color.WHITE);
		Rect rect[][] = new Rect[10][10];
		int x=canvas.getHeight();
		x=x - x/10;
		int y=canvas.getWidth();
		
		Paint block[]=new Paint[4];
		block[0].setColor(Color.BLUE);
		block[1].setColor(Color.GREEN);
		block[2].setColor(Color.RED);
		block[3].setColor(Color.YELLOW);
		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				rect[i][j].set(i*(x/10), j*(y/10),i*(x/10)+x/10, j*(y/10)+y/10);
				
				canvas.drawRect(rect[i][j], block[(i*10+j)%4]);
		
	           invalidate();
			}
	   }
		
   }
	
}