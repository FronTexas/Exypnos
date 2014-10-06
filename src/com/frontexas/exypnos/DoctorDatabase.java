package com.frontexas.exypnos;

import java.util.ArrayList;

public class DoctorDatabase {
	private ArrayList<Doctor> DoctorList;

	public DoctorDatabase() {
		DoctorList = new ArrayList<>();
	}

	public void addDoctor(Doctor newDoctor) {
		DoctorList.add(newDoctor);
	}

	public void addDoctor(ArrayList<Doctor> newDoctorList) {
		for (int i = 0; i < newDoctorList.size(); i++) {
			DoctorList.add(newDoctorList.get(i));
		}
	}

	public ArrayList<Doctor> getRelevantDoctors(String relevance) {
		ArrayList<Doctor> relevantDoctors = new ArrayList<>();
		for (int i = 0; i < DoctorList.size(); i++) {
			if (DoctorList.get(i).isRelelvant(relevance)) {
				relevantDoctors.add(DoctorList.get(i));
			}
		}
		return relevantDoctors;
	}

}
