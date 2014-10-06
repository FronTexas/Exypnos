package com.frontexas.exypnos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.exypnos.R;

public class HomePageWithoutApt extends RelativeLayout implements
		OnClickListener {
	private TextView tvYouDontHave, tvAnyAppointment;
	private ImageView ivCreateAppointment;
	private Context context;

	public HomePageWithoutApt(Context context) {
		super(context);
	}

	public HomePageWithoutApt(Context context, int x) {
		super(context);
		this.context = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		addView(inflater.inflate(R.layout.home_page_without_apt, null));
		intializeViews();
	}

	private void intializeViews() {
		TypefaceExypnos tfe = new TypefaceExypnos(context);

		tvYouDontHave = (TextView) findViewById(R.id.tvYouDontHave);
		tfe.setTypeface(tvYouDontHave, TypefaceExypnos.OPEN_SANS_BOLD);

		tvAnyAppointment = (TextView) findViewById(R.id.tvAnyAppointment);
		tfe.setTypeface(tvAnyAppointment, TypefaceExypnos.OPEN_SANS_BOLD);

		ivCreateAppointment = (ImageView) findViewById(R.id.ivCreateAppointment);
		ivCreateAppointment.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.ivCreateAppointment) {
			Intent i = new Intent(context, SearchPage.class);
			context.startActivity(i);
		}
	}

}
