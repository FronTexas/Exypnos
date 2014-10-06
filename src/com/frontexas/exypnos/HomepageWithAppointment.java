package com.frontexas.exypnos;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.exypnos.R;

public class HomepageWithAppointment extends RelativeLayout {

	Context context;

	// Doctor Infos
	private Doctor doctor;
	private TextView tvNEXT, tvDoctorSpeciality, tvHospitalName,
			tvDoctorPhoneNumber;
	private AutoResizeTextView tvDoctorName;

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
		// this constructor is required

		super(context);
		this.context = context;
	}

	public HomepageWithAppointment(Context context, Doctor doctor) {
		super(context);
		this.context = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		addView(inflater.inflate(R.layout.homepage_with_apt, null));

		this.doctor = doctor;

		intializeViews();
	}

	private void intializeViews() {
		TypefaceExypnos tfe = new TypefaceExypnos(context);

		// Doctor Infos
		tvNEXT = (TextView) findViewById(R.id.tvNEXT);
		Log.d("font error", "FE -- tvNEXT = " + tvNEXT);
		tfe.setTypeface(tvNEXT, TypefaceExypnos.OPEN_SANS);

		tvDoctorName = (AutoResizeTextView) findViewById(R.id.tvDoctorName);
		tfe.setTypeface(tvDoctorName, TypefaceExypnos.OPEN_SANS_BOLD);
		tvDoctorName.setText(doctor.getName());

		tvDoctorSpeciality = (TextView) findViewById(R.id.tvDoctorSpeciality);
		tfe.setTypeface(tvDoctorSpeciality, TypefaceExypnos.OPEN_SANS);
		tvDoctorSpeciality.setText(doctor.getSpeciality());

		tvHospitalName = (TextView) findViewById(R.id.tvHospitalName);
		tfe.setTypeface(tvHospitalName, TypefaceExypnos.OPEN_SANS);
		tvHospitalName.setText(doctor.getHospitalName());

		tvDoctorPhoneNumber = (TextView) findViewById(R.id.tvDoctorPhoneNumber);
		tfe.setTypeface(tvDoctorPhoneNumber, TypefaceExypnos.OPEN_SANS);
		tvDoctorPhoneNumber.setText(doctor.getPhoneNumber());

		// Updates on the appointment text. TEXT ONLY
		tvUpdatesOnTheApt = (TextView) findViewById(R.id.tvUpdatesOnTheApt);
		tfe.setTypeface(tvUpdatesOnTheApt, TypefaceExypnos.OPEN_SANS_BOLD);

		/** Appointment Updates */
		// Queue status
		llQueueStatus = (LinearLayout) findViewById(R.id.llQueueStatus);

		tvQueueStatus = (TextView) findViewById(R.id.tvQueueStatus);
		tfe.setTypeface(tvQueueStatus, TypefaceExypnos.OPEN_SANS_BOLD);

		tvPeoplesAhead = (TextView) findViewById(R.id.tvPeoplesAhead);
		tfe.setTypeface(tvPeoplesAhead, TypefaceExypnos.LEAGUE_GOTHIC);

		// Expected travel time
		rlExpectedTravelTime = (RelativeLayout) findViewById(R.id.rlExpectedTravelTime);

		tvExpectedTravelTimeText = (TextView) findViewById(R.id.tvExpectedTravelTimeText);
		tfe.setTypeface(tvExpectedTravelTimeText,
				TypefaceExypnos.OPEN_SANS_BOLD);

		tvExpectedTravelTime = (TextView) findViewById(R.id.tvExpectedTravelTime);
		tfe.setTypeface(tvExpectedTravelTime, TypefaceExypnos.OPEN_SANS_BOLD);

		// Estimated time to be called
		tvEstimatedTimeToBeCalledText = (TextView) findViewById(R.id.tvEstimatedTimeToBeCalledText);
		tfe.setTypeface(tvEstimatedTimeToBeCalledText,
				TypefaceExypnos.OPEN_SANS_BOLD);

		tvEstimatedTimeToBeCalled = (TextView) findViewById(R.id.tvEstimatedTimeToBeCalled);
		tfe.setTypeface(tvEstimatedTimeToBeCalled,
				TypefaceExypnos.OPEN_SANS_BOLD);
	}
}
