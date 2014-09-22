package com.frontexas.exypnos;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.exypnos.R;

public class SearchResultsPage extends ExypnosDrawerActivity implements
		OnEditorActionListener {
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
		} else {

			relevantSearch = i.getExtras().getString("relevantSearch");
			rlYourOptions.setVisibility(View.GONE);
			rlSearchBox.setVisibility(View.VISIBLE);
		}
		checkRelevance();
	}

	private void initializeViews() {
		etSearchMP2 = (EditText) findViewById(R.id.etSearchMP2);
		if (relevantSearch.length() > 0)
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
						getApplicationContext(), doctor.getName(),
						doctor.getType(), doctor.getAppointmentDate(),
						doctor.getAddress());
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
}
