package com.frontexas.exypnos;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.exypnos.R;

public class AdvanceSearchPage extends ExypnosDrawerActivity implements
		OnClickListener, OnEditorActionListener {
	EditText etDoctorsName, etDoctorSpeciality, etDoctorHospital,
			etDoctorGender, etZipCode, etDistance;
	RelativeLayout rlFind;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advance_search_page);
		initializeViews();

	}

	private void initializeViews() {
		etDoctorsName = (EditText) findViewById(R.id.etDoctorsName);
		etDoctorsName.setOnEditorActionListener(this);

		etDoctorSpeciality = (EditText) findViewById(R.id.etDoctorSpeciality);
		etDoctorSpeciality.setOnEditorActionListener(this);

		etDoctorHospital = (EditText) findViewById(R.id.etDoctorHospital);
		etDoctorHospital.setOnEditorActionListener(this);

		etDoctorGender = (EditText) findViewById(R.id.etDoctorGender);
		etDoctorGender.setOnEditorActionListener(this);

		etZipCode = (EditText) findViewById(R.id.etZipCode);
		etZipCode.setOnEditorActionListener(this);

		etDistance = (EditText) findViewById(R.id.etDistance);
		etDistance.setOnEditorActionListener(this);

		rlFind = (RelativeLayout) findViewById(R.id.rlFind);
		rlFind.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.rlFind) {

		}
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		return false;
	}

}
