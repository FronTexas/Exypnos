package com.frontexas.exypnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.exypnos.R;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;

public class HomepageWithAppointment extends RelativeLayout {

	Context context;

	// Doctor Infos
	private Doctor doctor;
	private TextView tvNEXT, tvDoctorSpeciality, tvHospitalName,
			tvDoctorPhoneNumber;
	private AutoResizeTextView tvDoctorName;

	// Updates on the appointment text

	/** Appointment Updates */

	// Queues status
	private TextView tvQueueStatus, tvPeoplesAhead;

	// Listview that will contain : traffic info, estimated time to be called, and any other updates
	private ListView lvAppointmentUpdates;

	LinearLayout ll;

	public HomepageWithAppointment(Context context) {
		// this constructor is required
		super(context);
		this.context = context;
	}

	public HomepageWithAppointment(Context context, Doctor doctor,
			LinearLayout llHomepageWithApt) {
		super(context);
		this.context = context;
		this.ll = llHomepageWithApt;

		this.doctor = doctor;

		intializeViews();
	}

	private void intializeViews() {
		TypefaceExypnos tfe = new TypefaceExypnos(context);
		// Doctor Infos
		tvNEXT = (TextView) ll.findViewById(R.id.tvNEXT);
		tfe.setTypeface(tvNEXT, TypefaceExypnos.OPEN_SANS);

		tvDoctorName = (AutoResizeTextView) ll.findViewById(R.id.tvDoctorName);
		tfe.setTypeface(tvDoctorName, TypefaceExypnos.DENSE);
		tvDoctorName.setText(doctor.getName());

		tvDoctorSpeciality = (TextView) ll
				.findViewById(R.id.tvDoctorSpeciality);
		tfe.setTypeface(tvDoctorSpeciality, TypefaceExypnos.QUATTROSENTO_BOLD);
		tvDoctorSpeciality.setText(doctor.getSpeciality());

		tvHospitalName = (TextView) ll.findViewById(R.id.tvHospitalName);
		tfe.setTypeface(tvHospitalName, TypefaceExypnos.QUATTROSENTO_BOLD);
		tvHospitalName.setText(doctor.getHospitalName());

		tvDoctorPhoneNumber = (TextView) ll
				.findViewById(R.id.tvDoctorPhoneNumber);
		tfe.setTypeface(tvDoctorPhoneNumber, TypefaceExypnos.OPEN_SANS);
		//		tvDoctorPhoneNumber.setText(doctor.getPhoneNumber());

		/** Appointment Updates */

		tvQueueStatus = (TextView) ll.findViewById(R.id.tvQueueStatus);
		tfe.setTypeface(tvQueueStatus, TypefaceExypnos.OPEN_SANS_BOLD);

		tvPeoplesAhead = (TextView) ll.findViewById(R.id.tvPeoplesAhead);
		tfe.setTypeface(tvPeoplesAhead, TypefaceExypnos.LEAGUE_GOTHIC);

		lvAppointmentUpdates = (ListView) ll
				.findViewById(R.id.lvAppointmentUpdates);
		AppointmentUpdatesAdapter aptAdapter = new AppointmentUpdatesAdapter();
		SwingBottomInAnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(
				aptAdapter);
		animationAdapter.setAbsListView(lvAppointmentUpdates);
		lvAppointmentUpdates.setAdapter(animationAdapter);
	}

	class AppointmentUpdatesAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			return new TrafficInfoCard(context);
		}
	}
}
