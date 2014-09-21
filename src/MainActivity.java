import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exypnos.R;

public class MainActivity extends ActionBarActivity implements
		OnItemClickListener {

	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle drawerListener;
	private ListView listView;
	private String[] planets;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer);
		planets = getResources().getStringArray(R.array.planets);
		listView = (ListView) findViewById(R.id.drawerList);
		//		listView.setAdapter(new ArrayAdapter<>(this,
		//				android.R.layout.simple_list_item_1, planets));
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
		Toast.makeText(this, planets[position] + " was selected",
				Toast.LENGTH_LONG).show();
		selectItem(position);
	}

	public void selectItem(int position) {
		// TODO Auto-generated method stub
		listView.setItemChecked(position, true);
		setTitle(planets[position]);
	}

	public void setTitle(String title) {
		getSupportActionBar().setTitle(title);
	}

}

class MyAdapter extends BaseAdapter {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
