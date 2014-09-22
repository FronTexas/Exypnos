package com.frontexas.exypnos;

public class Doctors {
	/** The name of the doctor */
	private String name;

	/** The type of the doctor. e.g. : General family Doctor */
	private String type;

	/** The address of the doctor operates */
	private String address;

	/** The appointment date with the doctor in DD/MM/YYYY */
	private String appointmentDate;

	public Doctors(String name, String type, String appointmentDate,
			String address) {
		this.name = name;
		this.type = type;
		this.address = address;
		this.appointmentDate = appointmentDate;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getAddress() {
		return address;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param info
	 *            a String that contains info that user want to search
	 * @return wether this doctor have something relevant (e.g. the name or the
	 *         type contains the info).
	 * */
	public boolean isRelelvant(String info) {
		return name.contains(info) || type.contains(info);
	}
}
