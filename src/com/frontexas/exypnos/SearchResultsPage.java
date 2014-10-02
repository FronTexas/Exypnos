package com.frontexas.exypnos;

import java.util.ArrayList;
import java.util.LinkedList;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.exypnos.R;

public class SearchResultsPage extends ExypnosDrawerActivity implements
		OnEditorActionListener, OnClickListener {
	private EditText etSearchMP2;
	private LinearLayout llDoctorList;
	private RelativeLayout rlYourOptions;
	private RelativeLayout rlSearchBox;
	private ArrayList<Doctors> doctorsList;
	private String relevantSearch;

	private final String ADVANCE_SEARCH_PAGE = "AdvanceSearchPage";
	private final String COVER_PAGE = "Coverpage";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_results);

		// Make fake data about list of the doctors
		initializeFakeDoctors();

		initializeViews();

		// Retreive user search 
		Intent i = getIntent();
		String callingActivities = i.getExtras().getString("CallingActivity");
		if (callingActivities.equals(ADVANCE_SEARCH_PAGE)) {
			rlYourOptions.setVisibility(View.VISIBLE);
			rlSearchBox.setVisibility(View.GONE);
			checkRelevanceAdvance(i);
		} else if (callingActivities.equals(COVER_PAGE)) {
			relevantSearch = i.getExtras().getString("relevantSearch");
			rlYourOptions.setVisibility(View.GONE);
			rlSearchBox.setVisibility(View.VISIBLE);
			checkRelevance();
		}
	}

	private void checkRelevanceAdvance(Intent intent) {
		for (int i = 0; i < doctorsList.size(); i++) {
			String name = intent.getExtras().getString("name");
			String speciality = intent.getExtras().getString("speciality");
			String hospital = intent.getExtras().getString("hospital");
			String gender = intent.getExtras().getString("gender");
			String zipcode = intent.getExtras().getString("zipcode");
			String distance = intent.getExtras().getString("distance");
			Doctors doctor = doctorsList.get(i);
			if (doctor.isRelelvantAdvance(name, speciality, hospital, gender,
					zipcode, distance)) {
				DoctorInfoView div = new DoctorInfoView(
						getApplicationContext(), doctor, doctor.getName(),
						doctor.getType(), doctor.getAppointmentDate(),
						doctor.getAddress());
				div.setOnClickListener(this);
				llDoctorList.addView(div);
			}

		}
	}

	private void initializeViews() {
		etSearchMP2 = (EditText) findViewById(R.id.etSearchMP2);
		if (relevantSearch != null && relevantSearch.length() > 0)
			etSearchMP2.setText(relevantSearch);
		etSearchMP2.setOnEditorActionListener(this);
		llDoctorList = (LinearLayout) findViewById(R.id.llDoctorList);

		rlSearchBox = (RelativeLayout) findViewById(R.id.rlSearchBox);
		rlYourOptions = (RelativeLayout) findViewById(R.id.rlYourOptions);
	}

	private void checkRelevance() {
		if (llDoctorList.getChildCount() > 0)
			llDoctorList.removeAllViews();
		for (int i = 0; i < doctorsList.size(); i++) {
			Doctors doctor = doctorsList.get(i);
			if (doctor.isRelelvant(relevantSearch)) {
				DoctorInfoView div = new DoctorInfoView(
						getApplicationContext(), doctor, doctor.getName(),
						doctor.getType(), doctor.getAppointmentDate(),
						doctor.getAddress());
				div.setOnClickListener(this);
				llDoctorList.addView(div);
			}
		}
	}

	private void initializeFakeDoctors() {
		String[] names = { "Buyung", "Kuncara", "Toto", "Fron" };
		String[] type = { "Surgeon Doctor", "Family Doctor",
				"Internal Organs Doctor", "Kids Doctor" };
		doctorsList = new ArrayList<>();
		String[] address = { "1234 X Drive Houston, TX 7700",
				"1234 X Drive Houston, TX 7700",
				"1234 X Drive Houston, TX 7700", "1234 X Drive Austin, TX 7700" };
		String[] dates = { "01/01/2014", "01/01/2014", "01/01/2014",
				"01/01/2014" };
		for (int i = 0; i < names.length; i++) {
			Doctors d = new Doctors(names[i], type[i], dates[i], address[i]);
			doctorsList.add(d);
		}
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		if (actionId == EditorInfo.IME_ACTION_SEARCH) {
			relevantSearch = etSearchMP2.getText().toString();
			checkRelevance();
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(SearchResultsPage.this, DoctorProfile.class);
		DoctorInfoView div = (DoctorInfoView) v;
		Doctors d = div.getDoctor();
		i.putExtra("name", d.getName());
		i.putExtra("type", d.getType());
		i.putExtra("address", d.getAddress());
		startActivity(i);

	}
}
