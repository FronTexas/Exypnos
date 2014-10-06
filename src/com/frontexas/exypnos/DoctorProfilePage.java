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
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.exypnos.R;

public class DoctorProfilePage extends Activity implements OnClickListener {

	private Doctor doctor;
	private TypefaceExypnos tfe;
	private float scaleDP;

	private AutoResizeTextView tvDoctorName, tvDoctorSpeciality,
			tvHospitalName, tvDoctorPhoneNumber;

	private TextView tvQueueStatus, tvPeoplesAhead;
	private RelativeLayout rlQueueButton;
	private TextView tvQueueText;

	private LinearLayout llBookByAvaialableSchedule;
	private TextView tvBookByAvailableSchedule;

	private TextView tvAboutMeText;
	private LinearLayout llAboutMeList;

	private TextView tvAwards;
	private LinearLayout llAwardsList;

	private TextView tvReadMoreReviewsText;

	private GridView gvMorningAvailableTime;
	private TextView tvBookForSpecificTimeText, tvDayAndDate, tvMorningText;

	private GridView gvAfternoonAvailableTime;
	private TextView tvAfternoonText;

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
		tvDoctorName = (AutoResizeTextView) findViewById(R.id.tvDoctorName);

		tvDoctorName.setText(doctor.getName());
		tfe.setTypeface(tvDoctorName, TypefaceExypnos.OPEN_SANS_BOLD);

		tvDoctorSpeciality = (AutoResizeTextView) findViewById(R.id.tvDoctorSpeciality);
		tvDoctorSpeciality.setText(doctor.getSpeciality());
		tfe.setTypeface(tvDoctorSpeciality, TypefaceExypnos.OPEN_SANS);

		tvHospitalName = (AutoResizeTextView) findViewById(R.id.tvHospitalName);
		tvHospitalName.setText(doctor.getHospitalName());
		tfe.setTypeface(tvHospitalName, TypefaceExypnos.OPEN_SANS);

		tvDoctorPhoneNumber = (AutoResizeTextView) findViewById(R.id.tvDoctorPhoneNumber);
		//		tvDoctorPhoneNumber.setText(doctor.getPhoneNumber());
		tfe.setTypeface(tvDoctorPhoneNumber, TypefaceExypnos.OPEN_SANS);

		tvQueueStatus = (TextView) findViewById(R.id.tvQueueStatus);
		tfe.setTypeface(tvQueueStatus, TypefaceExypnos.OPEN_SANS_BOLD);

		tvPeoplesAhead = (TextView) findViewById(R.id.tvPeoplesAhead);
		tfe.setTypeface(tvPeoplesAhead, TypefaceExypnos.LEAGUE_GOTHIC);

		rlQueueButton = (RelativeLayout) findViewById(R.id.rlQueueButton);
		rlQueueButton.setOnClickListener(this);

		tvQueueText = (TextView) findViewById(R.id.tvQueueText);
		tfe.setTypeface(tvQueueText, TypefaceExypnos.OPEN_SANS);

		llBookByAvaialableSchedule = (LinearLayout) findViewById(R.id.llBookByAvailableSchedule);
		llBookByAvaialableSchedule.setOnClickListener(this);

		tvBookByAvailableSchedule = (TextView) findViewById(R.id.tvBookByAvailableScheduleText);
		tfe.setTypeface(tvBookByAvailableSchedule,
				TypefaceExypnos.LEAGUE_GOTHIC);

		tvAboutMeText = (TextView) findViewById(R.id.tvAboutMeText);
		tfe.setTypeface(tvAboutMeText, TypefaceExypnos.OPEN_SANS_BOLD);

		llAboutMeList = (LinearLayout) findViewById(R.id.llAboutMeList);

		tvAwards = (TextView) findViewById(R.id.tvAwards);
		tfe.setTypeface(tvAwards, TypefaceExypnos.OPEN_SANS_BOLD);

		llAwardsList = (LinearLayout) findViewById(R.id.llAwardsList);

		tvReadMoreReviewsText = (TextView) findViewById(R.id.tvReadMoreReviewsText);
		tfe.setTypeface(tvReadMoreReviewsText, TypefaceExypnos.OPEN_SANS);

		tvBookForSpecificTimeText = (TextView) findViewById(R.id.tvBookForSpecificTimeText);
		tfe.setTypeface(tvBookForSpecificTimeText,
				TypefaceExypnos.LEAGUE_GOTHIC);

		tvDayAndDate = (TextView) findViewById(R.id.tvDayAndDate);
		tfe.setTypeface(tvDayAndDate, TypefaceExypnos.OPEN_SANS);

		tvMorningText = (TextView) findViewById(R.id.tvMorningText);
		tfe.setTypeface(tvMorningText, TypefaceExypnos.LEAGUE_GOTHIC);

		gvMorningAvailableTime = (GridView) findViewById(R.id.gvMorningAvailableTime);

		ArrayAdapter<String> adapter_morning = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, doctor.getMorningSched());
		gvMorningAvailableTime.setAdapter(adapter_morning);

		tvAfternoonText = (TextView) findViewById(R.id.tvAfternoonText);
		tfe.setTypeface(tvAfternoonText, TypefaceExypnos.LEAGUE_GOTHIC);

		gvAfternoonAvailableTime = (GridView) findViewById(R.id.gvAfternoonAvailableTime);
		ArrayAdapter<String> adapter_afternoon = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, doctor.getAfternoonSched());
		gvAfternoonAvailableTime.setAdapter(adapter_afternoon);

	}

	private void fillAboutMeList() {
		ArrayList<String> aboutMeList = doctor.getAboutMeList();

		for (int i = 0; i < aboutMeList.size(); i++) {
			TextView aboutMeTv = new TextView(getApplicationContext());
			tfe.setTypeface(aboutMeTv, TypefaceExypnos.OPEN_SANS);
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
			tfe.setTypeface(awardMeTv, TypefaceExypnos.OPEN_SANS);
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
