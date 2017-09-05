package vk.example.snake;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
public class dialogue extends View{
	public dialogue(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void draw (Canvas canvas)
	{
		canvas.drawColor(Color.WHITE);
		Paint paint=new Paint();
		paint.setColor(Color.BLUE);
		canvas.drawText("my name is vikash", 10, 10, paint);
	}

}
