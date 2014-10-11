package com.frontexas.exypnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.exypnos.R;

public class DoctorScheduleAdapter extends BaseAdapter {
	private Context context;
	private String[] schedule;
	private TypefaceExypnos tfe;
	private float scaleDP;

	public DoctorScheduleAdapter(Context context, String[] schedule) {
		this.schedule = schedule;
		this.context = context;
		tfe = new TypefaceExypnos(context);

		this.scaleDP = context.getResources().getDisplayMetrics().density;

	}

	@Override
	public int getCount() {
		return schedule.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View grid_item;

		if (convertView == null) {
			grid_item = inflater.inflate(R.layout.schedule_grid_item, null);
			grid_item.setLayoutParams(new GridView.LayoutParams(
					GridView.AUTO_FIT, (int) (50 * scaleDP + 0.5f)));
			TextView schedule_item = (TextView) grid_item
					.findViewById(R.id.tvScheduleItem);
			schedule_item.setText(schedule[pos]);
			tfe.setTypeface(schedule_item, TypefaceExypnos.LEAGUE_GOTHIC);
		} else {
			grid_item = (View) convertView;
		}

		return grid_item;
	}
}
