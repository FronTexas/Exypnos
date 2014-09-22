package com.frontexas.exypnos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.exypnos.R;

public class DoctorProfile extends ExypnosDrawerActivity {
	private TextView tvDoctorNameHeader, tvDoctorTypeHeader, tvDoctorNameInfo,
			tvDoctorTypeInfo, tvDoctorAddres, tvDoctorPhone, tvDoctorReview,
			tvDoctorAboutMe;
	private String name;
	private String type;
	private String address;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor_profile);
		retreiveIntentExtras();
		initializeViews();

	}

	private void retreiveIntentExtras() {
		Intent i = getIntent();
		name = i.getExtras().getString("name");
		type = i.getExtras().getString("type");
		address = i.getExtras().getString("address");

	}

	private void initializeViews() {
		tvDoctorNameHeader = (TextView) findViewById(R.id.tvDoctorNameHeader);
		tvDoctorNameHeader.setText(name);

		tvDoctorTypeHeader = (TextView) findViewById(R.id.tvDoctorTypeHeader);
		tvDoctorTypeHeader.setText(type);

		tvDoctorNameInfo = (TextView) findViewById(R.id.tvDoctorNameInfo);
		tvDoctorNameInfo.setText(name);

		tvDoctorTypeInfo = (TextView) findViewById(R.id.tvDoctorTypeInfo);
		tvDoctorTypeInfo.setText(type);

		tvDoctorAddres = (TextView) findViewById(R.id.tvDoctorAddress);
		tvDoctorAddres.setText(address);

		tvDoctorAboutMe = (TextView) findViewById(R.id.tvDoctorAboutMe);

		tvDoctorPhone = (TextView) findViewById(R.id.tvDoctorPhone);

		tvDoctorReview = (TextView) findViewById(R.id.tvDoctorReview);
	}

}
