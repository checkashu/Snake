package vk.example.snake;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Settings extends ListActivity{
	
	String classes[]={"Restart","Resume","Mute"};
	String classes1[]={"cpu","GFXSurface","Mute"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Settings.this,android.R.layout.simple_expandable_list_item_1, classes));
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese=classes1[position];
		if(classes[position]=="Restart")
		{
			ArrayValue.count1=0;
			ArrayValue.count2=0;
		}
		try{
		Class ourClass=Class.forName("vk.example.snake."+cheese);
		Intent ourIntent=new Intent(Settings.this , ourClass);
		startActivity(ourIntent);
		
		
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		}
	}