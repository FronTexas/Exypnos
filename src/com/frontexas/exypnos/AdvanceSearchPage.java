package com.frontexas.exypnos;

import android.content.Intent;
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
			String name = etDoctorsName.getText().toString();
			String speciality = etDoctorSpeciality.getText().toString();
			String hospital = etDoctorHospital.getText().toString();
			String gender = etDoctorGender.getText().toString();
			String zipCode = etZipCode.getText().toString();
			String distance = etDistance.getText().toString();
			Intent i = new Intent(AdvanceSearchPage.this,
					SearchResultsPage.class);
			i.putExtra("name", name);
			i.putExtra("speciality", speciality);
			i.putExtra("hospital", hospital);
			i.putExtra("gender", gender);
			i.putExtra("zipCode", zipCode);
			i.putExtra("distance", distance);
			i.putExtra("CallingActivity", "AdvanceSearchPage");
			startActivity(i);
		}
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		return false;
	}

}
