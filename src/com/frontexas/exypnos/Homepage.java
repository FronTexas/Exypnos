package com.frontexas.exypnos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.example.exypnos.R;

public class Homepage extends Activity {
	private RelativeLayout mainContainer;
	private LinearLayout llHomepageWithApt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);

		Intent i = getIntent();
		Doctor theDoctor = (Doctor) i.getParcelableExtra("theDoctor");

		mainContainer = (RelativeLayout) findViewById(R.id.rootHomepage);
		llHomepageWithApt = (LinearLayout) findViewById(R.id.llHomepageWithApt);

		// check wether there are appointment or not	
		if (theDoctor != null) {
			HomepageWithAppointment hp_with = new HomepageWithAppointment(this,
					theDoctor, llHomepageWithApt);
			llHomepageWithApt.setVisibility(View.VISIBLE);
		} else {
			HomePageWithoutApt hp_without = new HomePageWithoutApt(this, 0);
			LayoutParams hp_without_params = new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			hp_without_params.addRule(RelativeLayout.CENTER_IN_PARENT);
			mainContainer.addView(hp_without, hp_without_params);
		}

	}
}
