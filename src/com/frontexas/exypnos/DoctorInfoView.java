package com.frontexas.exypnos;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.exypnos.R;

public class DoctorInfoView extends LinearLayout implements OnClickListener {

	private TextView tvDoctorNameOnSearch, tvDoctorTypeOnSearch,
			tvDoctorDateOnSearch, tvDoctorAddressOnSearch;
	private ImageView ivOptionBars;
	private Doctors doctor;

	public DoctorInfoView(Context context, Doctors doctor, String doctorName,
			String doctorType, String appointmentDate, String doctorAddress) {
		super(context);
		this.doctor = doctor;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		addView(inflater.inflate(R.layout.doctor_info_view, null));
		initializeViews(doctorName, doctorType, appointmentDate, doctorAddress);
	}

	private void initializeViews(String doctorName, String doctorType,
			String appointmentDate, String doctorAddress) {
		tvDoctorNameOnSearch = (TextView) findViewById(R.id.tvDoctorNameOnSearch);
		if (tvDoctorNameOnSearch == null) {
			Log.d("doctorNameNull", "dnn -- NULL");
		} else {
			Log.d("doctorNameNull", "dnn -- !NULL");
		}
		tvDoctorNameOnSearch.setText(doctorName);

		tvDoctorTypeOnSearch = (TextView) findViewById(R.id.tvDoctorTypeOnSearch);
		tvDoctorTypeOnSearch.setText(doctorType);

		tvDoctorDateOnSearch = (TextView) findViewById(R.id.tvDoctorDateOnSearch);
		tvDoctorDateOnSearch.setText(appointmentDate);

		tvDoctorAddressOnSearch = (TextView) findViewById(R.id.tvDoctorAddressOnSearch);
		tvDoctorAddressOnSearch.setText(doctorAddress);

		ivOptionBars = (ImageView) findViewById(R.id.ivOptionBars);
		ivOptionBars.setOnClickListener(this);
	}

	public Doctors getDoctor() {
		return doctor;
	}

	@Override
	public void onClick(View v) {

	}

}
