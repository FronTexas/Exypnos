package com.frontexas.exypnos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.exypnos.R;

public class DoctorConfirmationDialog extends DialogFragment {

	final static String FROM_QUEUE = "fromQueue";
	final static String FROM_GV = "fromGV";

	private Doctor doctor;

	private TextView tvConfirmationText;
	private ImageView ivXButton;

	private ImageView ivDoctorPhotoCD;
	private TextView tvDoctorNameCD, tvDoctorTypeCD, tvDoctorPhoneCD;

	private TextView tvHospitalName, tvTimeCD;
	private ImageView ivPlaceIcon;

	private TextView tvQueueNumberTextCD, tvQueueNumber;

	private RelativeLayout rlConfirmButton;
	private TextView tvConfirm;

	public DoctorConfirmationDialog() {
		// empty constructor is required
	}

	public static DoctorConfirmationDialog newInstance() {
		DoctorConfirmationDialog dcf = new DoctorConfirmationDialog();
		return dcf;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mDoctorConfirmDialog = inflater.inflate(
				R.layout.doctor_confirmation_fragment, container);
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		initializeView(mDoctorConfirmDialog);
		return mDoctorConfirmDialog;
	}

	private void initializeView(View v) {
		TypefaceExypnos tfe = new TypefaceExypnos(v.getContext());

		tvConfirmationText = (TextView) v.findViewById(R.id.tvConfimationText);
		tfe.setTypeface(tvConfirmationText, TypefaceExypnos.QUATTROSENTO_BOLD);
		ivXButton = (ImageView) v.findViewById(R.id.ivXButton);
		ivXButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				dismiss();
			}
		});

		ivDoctorPhotoCD = (ImageView) v.findViewById(R.id.ivDoctorPhotoCD);

		tvDoctorNameCD = (TextView) v.findViewById(R.id.tvDoctorNameCD);
		tvDoctorNameCD.setText(doctor.getName());
		tfe.setTypeface(tvDoctorNameCD, TypefaceExypnos.DENSE);

		tvDoctorTypeCD = (TextView) v.findViewById(R.id.tvDoctorTypeCD);
		tvDoctorTypeCD.setText(doctor.getSpeciality());
		tfe.setTypeface(tvDoctorTypeCD, TypefaceExypnos.QUATTROSENTO_BOLD);

		tvDoctorPhoneCD = (TextView) v.findViewById(R.id.tvDoctorPhoneCD);
		tfe.setTypeface(tvDoctorPhoneCD, TypefaceExypnos.OPEN_SANS);

		tvHospitalName = (TextView) v.findViewById(R.id.tvHospitalName);
		tvHospitalName.setText(doctor.getHospitalName());
		tfe.setTypeface(tvHospitalName, TypefaceExypnos.QUATTROSENTO_BOLD);

		ivPlaceIcon = (ImageView) v.findViewById(R.id.ivPlaceIcon);
		tvTimeCD = (TextView) v.findViewById(R.id.tvTimeCD);
		if (getTag().equals(FROM_QUEUE))
			tvTimeCD.setText(doctor.peekNextAvailableSchedule());
		else
			tvTimeCD.setText(doctor.peekSelectedSchedule());

		tfe.setTypeface(tvTimeCD, TypefaceExypnos.LEAGUE_GOTHIC);

		tvQueueNumberTextCD = (TextView) v
				.findViewById(R.id.tvQueueNumberTextCD);
		tfe.setTypeface(tvQueueNumberTextCD, TypefaceExypnos.QUATTROSENTO_BOLD);

		tvQueueNumber = (TextView) v.findViewById(R.id.tvQueueNumber);
		tfe.setTypeface(tvQueueNumber, TypefaceExypnos.LEAGUE_GOTHIC);

		rlConfirmButton = (RelativeLayout) v.findViewById(R.id.rlConfirmButton);
		tvConfirm = (TextView) v.findViewById(R.id.tvConfirm);
		rlConfirmButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getActivity().getApplicationContext(),
						Homepage.class);
				Bundle b = new Bundle();
				b.putParcelable("theDoctor", doctor);
				i.putExtras(b);
				startActivity(i);

			}
		});

		tfe.setTypeface(tvConfirm, TypefaceExypnos.LEAGUE_GOTHIC);

	}

	public void setDoctor(Doctor d) {
		doctor = d;
	}
}
