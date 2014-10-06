package com.frontexas.exypnos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.example.exypnos.R;

public class Homepage extends Activity {
	private RelativeLayout rootHomepage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		boolean haveAppointment = false;
		rootHomepage = (RelativeLayout) findViewById(R.id.rootHomepage);
		TypefaceExypnos tfe = new TypefaceExypnos(getApplicationContext());

		// check wether there are appointment or not
		if (haveAppointment) {
			Doctor fahran = new Doctor(getApplicationContext(), "Dr.Fahran",
					"Cancer Surgeoun", "10/3/2014", "RS Pondok Indah", tfe);
			HomepageWithAppointment hp_with = new HomepageWithAppointment(this,
					fahran);
			rootHomepage.addView(hp_with);
		} else {
			HomePageWithoutApt hp_without = new HomePageWithoutApt(this, 0);
			LayoutParams hp_without_params = new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			hp_without_params.addRule(RelativeLayout.CENTER_IN_PARENT);
			rootHomepage.addView(hp_without, hp_without_params);
		}

	}
}
