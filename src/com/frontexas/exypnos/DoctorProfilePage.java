package com.frontexas.exypnos;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.exypnos.R;

public class DoctorProfilePage extends Activity implements OnClickListener {

	private Doctor doctor;
	private TypefaceExypnos tfe;
	private float scaleDP;

	private ScrollView svDoctorProfile;
	private RelativeLayout.LayoutParams paramsSvDoctorProfile;

	private AutoResizeTextView tvDoctorName, tvDoctorSpeciality,
			tvHospitalName, tvDoctorPhoneNumber;

	private TextView tvQueueStatus, tvPeoplesAhead;
	private RelativeLayout rlQueueButton;
	private TextView tvQueueText;

	private LinearLayout llAboutOnly;
	private LinearLayout llBookSpecificTime;

	private LinearLayout llBookByAvaialableSchedule;
	private TextView tvBookByAvailableSchedule;

	private TextView tvAboutMeText;
	private LinearLayout llAboutMeList;

	private TextView tvAwards;
	private LinearLayout llAwardsList;

	private TextView tvReadMoreReviewsText;

	private RelativeLayout rlArrowUpButton;

	/**
	 * BOOK_SPECIFIC_TIME AREA
	 * Contains all of the available schedule of a doctor
	 */
	private GridView gvMorningAvailableTime;
	private TextView tvBookForSpecificTimeText, tvDayAndDate, tvMorningText;

	private GridView gvAfternoonAvailableTime;
	private TextView tvAfternoonText;

	private GridView gvEveningAvailableTime;
	private TextView tvEveningText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor_profile);
		Intent i = getIntent();
		this.doctor = (Doctor) i.getParcelableExtra("DoctorObject");
		this.tfe = new TypefaceExypnos(getApplicationContext());
		this.scaleDP = getResources().getDisplayMetrics().density;

		initializeViews();

		fillAboutMeList();
		fillAwardList();

	}

	private void initializeViews() {
		paramsSvDoctorProfile = new RelativeLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		svDoctorProfile = (ScrollView) findViewById(R.id.svDoctorProfile);

		tvDoctorName = (AutoResizeTextView) findViewById(R.id.tvDoctorName);

		tvDoctorName.setText(doctor.getName());
		tfe.setTypeface(tvDoctorName, TypefaceExypnos.DENSE);

		tvDoctorSpeciality = (AutoResizeTextView) findViewById(R.id.tvDoctorSpeciality);
		tvDoctorSpeciality.setText(doctor.getSpeciality());
		tfe.setTypeface(tvDoctorSpeciality, TypefaceExypnos.QUATTROSENTO_BOLD);

		tvHospitalName = (AutoResizeTextView) findViewById(R.id.tvHospitalName);
		tvHospitalName.setText(doctor.getHospitalName());
		tfe.setTypeface(tvHospitalName, TypefaceExypnos.QUATTROSENTO_BOLD);

		tvDoctorPhoneNumber = (AutoResizeTextView) findViewById(R.id.tvDoctorPhoneNumber);
		//		tvDoctorPhoneNumber.setText(doctor.getPhoneNumber());
		tfe.setTypeface(tvDoctorPhoneNumber, TypefaceExypnos.QUATTROSENTO_BOLD);

		tvQueueStatus = (TextView) findViewById(R.id.tvQueueStatus);
		tfe.setTypeface(tvQueueStatus, TypefaceExypnos.QUATTROSENTO_BOLD);

		tvPeoplesAhead = (TextView) findViewById(R.id.tvPeoplesAhead);
		tfe.setTypeface(tvPeoplesAhead, TypefaceExypnos.LEAGUE_GOTHIC);

		rlQueueButton = (RelativeLayout) findViewById(R.id.rlQueueButton);
		rlQueueButton.setOnClickListener(this);

		tvQueueText = (TextView) findViewById(R.id.tvQueueText);
		tfe.setTypeface(tvQueueText, TypefaceExypnos.QUATTROSENTO_BOLD);

		llAboutOnly = (LinearLayout) findViewById(R.id.llAboutOnly);
		llBookSpecificTime = (LinearLayout) findViewById(R.id.llBookSpecificTime);

		llBookByAvaialableSchedule = (LinearLayout) findViewById(R.id.llBookByAvailableSchedule);
		llBookByAvaialableSchedule.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				paramsSvDoctorProfile.setMargins(0, 0, 0,
						(int) (20 * scaleDP + 0.5f));
				svDoctorProfile.setLayoutParams(paramsSvDoctorProfile);
				llAboutOnly.setVisibility(View.GONE);
				llBookSpecificTime.setVisibility(View.VISIBLE);
				rlArrowUpButton.setVisibility(View.VISIBLE);
			}
		});

		tvBookByAvailableSchedule = (TextView) findViewById(R.id.tvBookByAvailableScheduleText);
		tfe.setTypeface(tvBookByAvailableSchedule,
				TypefaceExypnos.LEAGUE_GOTHIC);

		tvAboutMeText = (TextView) findViewById(R.id.tvAboutMeText);
		tfe.setTypeface(tvAboutMeText, TypefaceExypnos.QUATTROSENTO_BOLD);

		llAboutMeList = (LinearLayout) findViewById(R.id.llAboutMeList);

		tvAwards = (TextView) findViewById(R.id.tvAwards);
		tfe.setTypeface(tvAwards, TypefaceExypnos.QUATTROSENTO_BOLD);

		llAwardsList = (LinearLayout) findViewById(R.id.llAwardsList);

		tvReadMoreReviewsText = (TextView) findViewById(R.id.tvReadMoreReviewsText);
		tfe.setTypeface(tvReadMoreReviewsText,
				TypefaceExypnos.QUATTROSENTO_BOLD);

		tvBookForSpecificTimeText = (TextView) findViewById(R.id.tvBookForSpecificTimeText);
		tfe.setTypeface(tvBookForSpecificTimeText,
				TypefaceExypnos.LEAGUE_GOTHIC);

		tvDayAndDate = (TextView) findViewById(R.id.tvDayAndDate);
		tfe.setTypeface(tvDayAndDate, TypefaceExypnos.QUATTROSENTO_BOLD);

		tvMorningText = (TextView) findViewById(R.id.tvMorningText);
		tfe.setTypeface(tvMorningText, TypefaceExypnos.QUATTROSENTO_BOLD);

		gvMorningAvailableTime = (GridView) findViewById(R.id.gvMorningAvailableTime);
		gvMorningAvailableTime.setAdapter(new DoctorScheduleAdapter(
				getApplicationContext(), doctor.getMorningSched()));

		tvAfternoonText = (TextView) findViewById(R.id.tvAfternoonText);
		tfe.setTypeface(tvAfternoonText, TypefaceExypnos.QUATTROSENTO_BOLD);

		gvAfternoonAvailableTime = (GridView) findViewById(R.id.gvAfternoonAvailableTime);
		gvAfternoonAvailableTime.setAdapter(new DoctorScheduleAdapter(
				getApplicationContext(), doctor.getAfternoonSched()));

		tvEveningText = (TextView) findViewById(R.id.tvEveningText);
		tfe.setTypeface(tvEveningText, TypefaceExypnos.QUATTROSENTO_BOLD);

		gvEveningAvailableTime = (GridView) findViewById(R.id.gvEveningAvailableTime);
		gvEveningAvailableTime.setAdapter(new DoctorScheduleAdapter(
				getApplicationContext(), doctor.getEveningSched()));

		rlArrowUpButton = (RelativeLayout) findViewById(R.id.rlArrowUpButton);
		rlArrowUpButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				llAboutOnly.setVisibility(View.VISIBLE);
				llBookSpecificTime.setVisibility(View.GONE);
				rlArrowUpButton.setVisibility(View.GONE);
				paramsSvDoctorProfile.setMargins(0, 0, 0, 0);
				svDoctorProfile.setLayoutParams(paramsSvDoctorProfile);
			}
		});

	}

	private void fillAboutMeList() {
		ArrayList<String> aboutMeList = doctor.getAboutMeList();

		for (int i = 0; i < aboutMeList.size(); i++) {
			TextView aboutMeTv = new TextView(getApplicationContext());
			tfe.setTypeface(aboutMeTv, TypefaceExypnos.QUATTROSENTO_BOLD);
			aboutMeTv.setText(aboutMeList.get(i));
			aboutMeTv.setTextColor(Color.rgb(77, 77, 77));
			LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 0, 0, (int) (3 * scaleDP + 0.5f));
			params.gravity = Gravity.CENTER_HORIZONTAL;
			llAboutMeList.addView(aboutMeTv, params);
		}
	}

	private void fillAwardList() {
		ArrayList<String> awardsList = doctor.getAwardsList();

		for (int i = 0; i < awardsList.size(); i++) {
			TextView awardMeTv = new TextView(getApplicationContext());
			tfe.setTypeface(awardMeTv, TypefaceExypnos.QUATTROSENTO_BOLD);
			awardMeTv.setText(awardsList.get(i));
			awardMeTv.setTextColor(Color.rgb(77, 77, 77));
			LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 0, 0, (int) (3 * scaleDP + 0.5f));
			params.gravity = Gravity.CENTER_HORIZONTAL;
			llAwardsList.addView(awardMeTv, params);
		}
	}

	@Override
	public void onClick(View v) {

	}

}
