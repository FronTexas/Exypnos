package com.frontexas.exypnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.exypnos.R;

public class HomepageWithAppointment extends RelativeLayout {
	// Doctor Infos
	private TextView tvNEXT, tvDoctorName, tvDoctorSpeciality, tvHospitalName,
			tvDoctorPhoneNumber;

	// Updates on the appointment text
	private TextView tvUpdatesOnTheApt;

	/** Appointment Updates */

	// Queues status
	private LinearLayout llQueueStatus;
	private TextView tvQueueStatus, tvPeoplesAhead;

	// Expected travel time
	private RelativeLayout rlExpectedTravelTime;
	private TextView tvExpectedTravelTimeText, tvExpectedTravelTime;

	// Estimated time to be called
	private TextView tvEstimatedTimeToBeCalledText, tvEstimatedTimeToBeCalled;

	public HomepageWithAppointment(Context context) {
		super(context);
	}

	public HomepageWithAppointment(Context context, int x) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		addView(inflater.inflate(R.layout.home_page_without_apt, null));
		intializeViews();
	}

	private void intializeViews() {
		// Doctor Infos
		tvNEXT = (TextView) findViewById(R.id.tvNEXT);
		tvDoctorName = (TextView) findViewById(R.id.tvDoctorName);
		tvDoctorSpeciality = (TextView) findViewById(R.id.tvDoctorSpeciality);
		tvHospitalName = (TextView) findViewById(R.id.tvHospitalName);
		tvDoctorPhoneNumber = (TextView) findViewById(R.id.tvDoctorPhoneNumber);

		// Updates on the appointment text
		tvUpdatesOnTheApt = (TextView) findViewById(R.id.tvUpdatesOnTheApt);

		/** Appointment Updates */

		// Queue status
		llQueueStatus = (LinearLayout) findViewById(R.id.llQueueStatus);
		tvQueueStatus = (TextView) findViewById(R.id.tvQueueStatus);
		tvPeoplesAhead = (TextView) findViewById(R.id.tvPeoplesAhead);

		// Expected travel time
		rlExpectedTravelTime = (RelativeLayout) findViewById(R.id.rlExpectedTravelTime);
		tvExpectedTravelTimeText = (TextView) findViewById(R.id.tvExpectedTravelTimeText);
		tvExpectedTravelTime = (TextView) findViewById(R.id.tvExpectedTravelTime);

		// Estimated time to be called
		tvEstimatedTimeToBeCalledText = (TextView) findViewById(R.id.tvEstimatedTimeToBeCalledText);
		tvEstimatedTimeToBeCalled = (TextView) findViewById(R.id.tvEstimatedTimeToBeCalled);
	}

}
