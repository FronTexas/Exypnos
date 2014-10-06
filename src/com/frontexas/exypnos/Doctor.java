package com.frontexas.exypnos;

import java.util.ArrayList;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class Doctor implements Parcelable {

	public static final Parcelable.Creator<Doctor> CREATOR = new Parcelable.Creator<Doctor>() {
		public Doctor createFromParcel(Parcel in) {
			return new Doctor(in);
		}

		public Doctor[] newArray(int size) {
			return new Doctor[size];
		}
	};

	private TypefaceExypnos tfe;

	/** The context of the application */
	private Context context;

	/** The doctorInfoView that will be listed in search page */
	private DoctorInfoView div;

	/** The doctor's Profile page view */
	private DoctorProfilePage doctorProfile;

	/** The name of the doctor */
	private String name;

	/** The type of the doctor. e.g. : General family Doctor */
	private String speciality;

	/** The address of the doctor operates */
	private String hospitalName;

	/** The phone number to contact the doctor */
	private String phoneNumber;

	/** The appointment date with the doctor in DD/MM/YYYY */
	private String appointmentDate;

	/** The list of about me section of this doctor */
	private ArrayList<String> aboutMeList;

	/** The list of award this doctor has */
	private ArrayList<String> awardsList;

	/** The list of this doctor available schedules */
	private String[] morningAvailableSchedules;
	private String[] afternoonAvailableSchedules;
	private String[] eveningAvailableSchedules;

	public Doctor(Parcel in) {
		name = in.readString();
		speciality = in.readString();
		hospitalName = in.readString();
		phoneNumber = in.readString();
		appointmentDate = in.readString();
		aboutMeList = new ArrayList<String>();
		in.readStringList(aboutMeList);
		awardsList = new ArrayList<String>();
		in.readStringList(awardsList);
		morningAvailableSchedules = new String[12];
		in.readStringArray(morningAvailableSchedules);
		afternoonAvailableSchedules = new String[12];
		in.readStringArray(afternoonAvailableSchedules);
		eveningAvailableSchedules = new String[12];
		in.readStringArray(eveningAvailableSchedules);

	}

	public Doctor(Context context, String name, String type,
			String appointmentDate, String hospitalName, TypefaceExypnos tfe) {
		this.name = name;
		this.speciality = type;
		this.hospitalName = hospitalName;
		this.appointmentDate = appointmentDate;
		this.context = context;
		this.tfe = tfe;
		buildDoctorInfoView(this);
	}

	private void buildDoctorInfoView(Doctor doctor) {
		this.div = new DoctorInfoView(context, doctor, tfe);
	}

	public DoctorInfoView getDoctorInfoView() {
		return div;
	}

	public DoctorProfilePage getDoctorProfile() {
		return doctorProfile;
	}

	public String getName() {
		return name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAboutMe(ArrayList<String> aboutMeList) {
		this.aboutMeList = aboutMeList;
	}

	public ArrayList<String> getAboutMeList() {
		return aboutMeList;
	}

	public void setAwardList(ArrayList<String> awardsList) {
		this.awardsList = awardsList;
	}

	public ArrayList<String> getAwardsList() {
		return awardsList;
	}

	public void setAvailableSchedule(String[] morning, String[] afternoon,
			String[] evening) {
		morningAvailableSchedules = morning;
		afternoonAvailableSchedules = afternoon;
		eveningAvailableSchedules = evening;
	}

	public String[] getMorningSched() {
		return morningAvailableSchedules;
	}

	public String[] getAfternoonSched() {
		return afternoonAvailableSchedules;
	}

	public String[] getEveningSched() {
		return eveningAvailableSchedules;
	}

	/**
	 * @param info
	 *            a String that contains info that user want to search
	 * @return wether this doctor have something relevant (e.g. the name or the
	 *         type contains the info).
	 * */
	public boolean isRelelvant(String info) {
		return name.contains(info) || speciality.contains(info)
				|| hospitalName.contains(info);
	}

	/**
	 * @param all
	 *            infos about the doctor that user search from advance search
	 *            page
	 * @return wether this doctor have something relevant (e.g. the name or the
	 *         type contains the info).
	 * */
	public boolean isRelelvantAdvance(String name, String speciality,
			String hospital, String gender, String zipcode, String distance) {
		return (name.length() < 0 || (this.name.contains(name)))
				&& (speciality.length() < 0 || this.speciality
						.contains(speciality))
				&& (hospital.length() < 0 || this.hospitalName
						.contains(hospital));

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(name);
		out.writeString(speciality);
		out.writeString(hospitalName);
		out.writeString(phoneNumber);
		out.writeString(appointmentDate);
		out.writeStringList(aboutMeList);
		out.writeStringList(awardsList);
		out.writeStringArray(morningAvailableSchedules);
		out.writeStringArray(afternoonAvailableSchedules);
		out.writeStringArray(eveningAvailableSchedules);
	}
}
