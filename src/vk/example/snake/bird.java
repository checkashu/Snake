package vk.example.snake;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
//import android.view.Menu;
import android.app.Activity;

public class bird extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogue ourView=new dialogue(this);
		//setContentView(ourView);
        setContentView(R.layout.board);

    }

	

 }
