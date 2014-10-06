package com.frontexas.exypnos;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.exypnos.R;

public class SearchPage extends Activity implements OnClickListener,
		OnEditorActionListener {

	private TypefaceExypnos tfe;

	private EditText etSearchBox;

	private TextView tvSortText, tvWaySorted;
	private RelativeLayout rlWaySorted;

	private TextView tvAdvanceSearchText;

	private LinearLayout llDoctorInfoViewsList;

	private DoctorDatabase doctorDB;

	/** To convert int to density pixels in android screen */
	float scaleDP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchpage);
		scaleDP = getResources().getDisplayMetrics().density;
		tfe = new TypefaceExypnos(getApplicationContext());
		createFakeDoctorList();
		initializeViews();

	}

	private void initializeViews() {

		etSearchBox = (EditText) findViewById(R.id.etSearchBox);
		etSearchBox.setOnEditorActionListener(this);

		tvSortText = (TextView) findViewById(R.id.tvSortText);
		tfe.setTypeface(tvSortText, TypefaceExypnos.OPEN_SANS);

		tvWaySorted = (TextView) findViewById(R.id.tvWaySorted);
		tfe.setTypeface(tvWaySorted, TypefaceExypnos.OPEN_SANS_BOLD);

		tvAdvanceSearchText = (TextView) findViewById(R.id.tvAdvanceSearchText);
		tfe.setTypeface(tvAdvanceSearchText, TypefaceExypnos.OPEN_SANS);

		rlWaySorted = (RelativeLayout) findViewById(R.id.rlWaySorted);
		rlWaySorted.setOnClickListener(this);

		llDoctorInfoViewsList = (LinearLayout) findViewById(R.id.llDoctorInfoViewsList);

	}

	private void createFakeDoctorList() {
		doctorDB = new DoctorDatabase();

		ArrayList<String> aboutMe = new ArrayList<String>();
		aboutMe.add("PhD Harvard Medical School - 1998");
		aboutMe.add("MD The University Of Texas at Austin - 1990");

		ArrayList<String> awardsList = new ArrayList<String>();
		awardsList.add("Best Doctor in Jakarta 2010-2014");

		String[] morning = { "9:00", "9:15", "9:30", "9:45", "10:00", "10:15",
				"10:30", "10:45", "11:00", "11:15", "11:30", "11:45" };
		String[] afternoon = { "12:00", "12:15", "12:30", "12:45", "13:00",
				"13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45" };
		String[] evening = { "17:00", "17:15", "17:30", "17:45", "18:00",
				"18:15", "18:30", "18:45", "19:00", "20:00", "20:15", "20:30" };

		Doctor fahran = new Doctor(getApplicationContext(), "Dr.Fahran",
				"Ebola expert", "10/3/2014", "RS Pondok Indah", tfe);
		fahran.setAboutMe(aboutMe);
		fahran.setAwardList(awardsList);
		fahran.setAvailableSchedule(morning, afternoon, evening);
		doctorDB.addDoctor(fahran);

		Doctor toto = new Doctor(getApplicationContext(), "Dr.Toto",
				"Heart Surgeon", "10/3/2014", "RS Pertamina", tfe);
		toto.setAboutMe(aboutMe);
		toto.setAwardList(awardsList);
		toto.setAvailableSchedule(morning, afternoon, evening);
		doctorDB.addDoctor(toto);

		Doctor buyung = new Doctor(getApplicationContext(), "Dr.Buyung",
				"Brain Surgeon", "10/3/2014", "RS Cipto Mangunkusumo", tfe);
		buyung.setAboutMe(aboutMe);
		buyung.setAwardList(awardsList);
		buyung.setAvailableSchedule(morning, afternoon, evening);
		doctorDB.addDoctor(buyung);

		Doctor kuncara = new Doctor(getApplicationContext(), "Dr.Kuncara",
				"Lung Surgeon", "10/3/2014", "RS Bintaro", tfe);
		kuncara.setAboutMe(aboutMe);
		kuncara.setAwardList(awardsList);
		kuncara.setAvailableSchedule(morning, afternoon, evening);
		doctorDB.addDoctor(kuncara);

	}

	@Override
	public void onClick(View v) {
		if (v instanceof DoctorInfoView) {
			// A doctorInfoView is clicked
			Intent i = new Intent(SearchPage.this, DoctorProfilePage.class);
			DoctorInfoView div = (DoctorInfoView) v;
			Bundle bundle = new Bundle();
			bundle.putParcelable("DoctorObject", div.getDoctor());
			i.putExtras(bundle);

			// Show DoctorProfilePage
			startActivity(i);
		}
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		switch (actionId) {
		case EditorInfo.IME_ACTION_SEARCH:
			ArrayList<Doctor> relevantDoctors = doctorDB
					.getRelevantDoctors(etSearchBox.getText().toString());
			for (int i = 0; i < relevantDoctors.size(); i++) {
				Doctor doctor = relevantDoctors.get(i);
				LayoutParams params = new LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				params.setMargins(0, (int) (10 * scaleDP + 0.5f), 0, 0);
				DoctorInfoView div = doctor.getDoctorInfoView();
				div.setOnClickListener(this);
				llDoctorInfoViewsList.addView(div, params);
			}

			break;
		default:
			break;
		}
		return false;
	}

}
