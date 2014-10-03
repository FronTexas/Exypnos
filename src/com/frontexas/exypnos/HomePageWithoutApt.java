package com.frontexas.exypnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.exypnos.R;

public class HomePageWithoutApt extends RelativeLayout implements OnClickListener {
	private TextView tvYouDontHave, tvAnyAppointment;
	private ImageView ivCreateAppointment;

	public HomePageWithoutApt(Context context) {
		super(context);
	}

	public HomePageWithoutApt(Context context, int x) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		addView(inflater.inflate(R.layout.home_page_without_apt, null));
		intializeViews();
	}

	private void intializeViews() {
		tvYouDontHave = (TextView) findViewById(R.id.tvYouDontHave);
		tvAnyAppointment = (TextView) findViewById(R.id.tvAnyAppointment);

		ivCreateAppointment = (ImageView) findViewById(R.id.ivCreateAppointment);
		ivCreateAppointment.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
	}

}
