package com.frontexas.exypnos;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exypnos.R;

public class MainActivity extends ActionBarActivity implements
		OnItemClickListener {

	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle drawerListener;
	private MyAdapterDummy myAdapter;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer);
		listView = (ListView) findViewById(R.id.drawerList);
		myAdapter = new MyAdapterDummy(this);
		listView.setAdapter(myAdapter);
		listView.setOnItemClickListener(this);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerListener = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_navigation_drawer, R.string.openDrawer,
				R.string.closeDrawer) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				Toast.makeText(MainActivity.this, "Drawer Closed",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				Toast.makeText(MainActivity.this, "Drawer Opened",
						Toast.LENGTH_SHORT).show();
			}
		};
		drawerLayout.setDrawerListener(drawerListener);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerListener.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerListener.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		selectItem(position);
	}

	public void selectItem(int position) {
		// TODO Auto-generated method stub
		listView.setItemChecked(position, true);
	}

	public void setTitle(String title) {
		getSupportActionBar().setTitle(title);
	}

}

class MyAdapterDummy extends BaseAdapter {
	Context context;
	String[] drawerOptions;
	int[] drawerIcons = { R.drawable.ic_home, R.drawable.ic_time,
			R.drawable.ic_settings, R.drawable.ic_mail, R.drawable.ic_calendar,
			R.drawable.ic_user, R.drawable.ic_app, R.drawable.ic_help };

	public MyAdapterDummy(Context context) {
		this.context = context;
		drawerOptions = context.getResources().getStringArray(
				R.array.drawerOptions);

	}

	@Override
	public int getCount() {
		return drawerOptions.length;
	}

	@Override
	public Object getItem(int pos) {
		return drawerOptions[pos];
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		View row = null;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.custom_row, parent, false);
		} else {
			row = convertView;
		}
		TextView titleTextView = (TextView) row
				.findViewById(R.id.tvDrawerOption);
		ImageView titleImageView = (ImageView) row
				.findViewById(R.id.ivDrawerOptions);
		titleTextView.setText(drawerOptions[pos]);
		titleImageView.setImageResource(drawerIcons[pos]);
		return row;
	}
}
