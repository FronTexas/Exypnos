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

import com.example.exypnos.R;

public class DrawerOptions extends ActionBarActivity implements
		OnItemClickListener {

	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle drawerListener;
	private MyAdapter myAdapter;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer);

		listView = (ListView) findViewById(R.id.drawerList);
		myAdapter = new MyAdapter(this);
		listView.setAdapter(myAdapter);

		listView.setOnItemClickListener(this);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerListener = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_navigation_drawer, R.string.openDrawer,
				R.string.closeDrawer);
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
		// what does this do???
		selectItem(position);
	}

	private void selectItem(int position) {
		listView.setItemChecked(position, true);
	}
}

class MyAdapter extends BaseAdapter {
	Context context;
	String[] drawerOptions;
	int[] drawerIcons = { R.drawable.ic_home, R.drawable.ic_time,
			R.drawable.ic_settings, R.drawable.ic_mail, R.drawable.ic_calendar,
			R.drawable.ic_user, R.drawable.ic_app, R.drawable.ic_help };

	public MyAdapter(Context context) {
		this.context = context;
		drawerOptions = context.getResources().getStringArray(
				R.array.drawerOptions);
	}

	@Override
	public int getCount() {
		return drawerOptions.length;
	}

	@Override
	public Object getItem(int position) {
		return drawerOptions[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = null;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			inflater.inflate(R.layout.custom_row, parent, false);
		} else {
			row = convertView;
		}
		TextView tvDrawerOption = (TextView) row
				.findViewById(R.id.tvDrawerOption);
		ImageView ivDrawerOption = (ImageView) row
				.findViewById(R.id.ivDrawerOptions);
		tvDrawerOption.setText(drawerOptions[position]);
		ivDrawerOption.setImageResource(drawerIcons[position]);
		return row;
	}

}