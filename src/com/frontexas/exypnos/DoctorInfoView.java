package com.frontexas.exypnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.example.exypnos.R;

public class DoctorInfoView extends RelativeLayout {
	private TypefaceExypnos tfe;
	private Context context;
	private Doctor doctor;
	private AutoResizeTextView tvDoctorNameDIV, tvDoctorSpecialityDIV,
			tvHospitalNameDIV, tvNextAvailableAptText, tvNextAvailableApt,
			tvCurrentQueueNumberText, tvCurrentQueueNumber,
			tvYourQueueNumberText, tvYourQueueNumber;

	public DoctorInfoView(Context context) {
		super(context);
		this.context = context;
	}

	public DoctorInfoView(Context context, Doctor doctor, TypefaceExypnos tfe) {
		super(context);
		this.doctor = doctor;
		this.context = context;
		this.tfe = tfe;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		addView(inflater.inflate(R.layout.doctor_info_view, null));
		initializeViews();

	}

	private void initializeViews() {

		tvDoctorNameDIV = (AutoResizeTextView) findViewById(R.id.tvDoctorNameDIV);
		tfe.setTypeface(tvDoctorNameDIV, TypefaceExypnos.OPEN_SANS_BOLD);
		tvDoctorNameDIV.setText(doctor.getName());

		tvDoctorSpecialityDIV = (AutoResizeTextView) findViewById(R.id.tvDoctorSpecialityDIV);
		tfe.setTypeface(tvDoctorSpecialityDIV, TypefaceExypnos.OPEN_SANS);
		tvDoctorSpecialityDIV.setText(doctor.getSpeciality());

		tvHospitalNameDIV = (AutoResizeTextView) findViewById(R.id.tvHospitalNameDIV);
		tfe.setTypeface(tvHospitalNameDIV, TypefaceExypnos.OPEN_SANS);
		tvHospitalNameDIV.setText(doctor.getHospitalName());

		tvNextAvailableAptText = (AutoResizeTextView) findViewById(R.id.tvNextAvailableAptText);
		tfe.setTypeface(tvNextAvailableAptText, TypefaceExypnos.OPEN_SANS);

		tvNextAvailableApt = (AutoResizeTextView) findViewById(R.id.tvNextAvailableApt);
		tfe.setTypeface(tvNextAvailableApt, TypefaceExypnos.OPEN_SANS_BOLD);

		tvCurrentQueueNumberText = (AutoResizeTextView) findViewById(R.id.tvCurrentQueueNumberText);
		tfe.setTypeface(tvCurrentQueueNumberText, TypefaceExypnos.OPEN_SANS);

		tvCurrentQueueNumber = (AutoResizeTextView) findViewById(R.id.tvCurrentQueueNumber);
		tfe.setTypeface(tvCurrentQueueNumber, TypefaceExypnos.OPEN_SANS_BOLD);

		tvYourQueueNumberText = (AutoResizeTextView) findViewById(R.id.tvYourQueueNumberText);
		tfe.setTypeface(tvYourQueueNumberText, TypefaceExypnos.OPEN_SANS);

		tvYourQueueNumber = (AutoResizeTextView) findViewById(R.id.tvYourQueueNumber);
		tfe.setTypeface(tvYourQueueNumber, TypefaceExypnos.OPEN_SANS_BOLD);

	}

	public Doctor getDoctor() {
		return this.doctor;
	}

}
