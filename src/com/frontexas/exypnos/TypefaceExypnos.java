package com.frontexas.exypnos;

import java.io.Serializable;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

@SuppressWarnings("serial")
public class TypefaceExypnos implements Serializable {
	public static final String LEAGUE_GOTHIC = "leagueGothic";
	public static final String LEAGUE_GOTHIC_ITALIC = "leagueGothicItalic";
	public static final String OPEN_SANS = "openSans";
	public static final String OPEN_SANS_BOLD = "openSansBolds";

	private Typeface leagueGothic, leagueGothicItalic, openSans, openSansBold;

	public TypefaceExypnos(Context context) {
		leagueGothic = Typeface.createFromAsset(context.getAssets(),
				"fonts/leaguegothic.otf");
		leagueGothicItalic = Typeface.createFromAsset(context.getAssets(),
				"fonts/leaguegothic_italic.ttf");
		openSans = Typeface.createFromAsset(context.getAssets(),
				"fonts/opensans_regular.ttf");
		openSansBold = Typeface.createFromAsset(context.getAssets(),
				"fonts/opensans_bold.ttf");
	}

	public void setTypeface(TextView v, String typeface) {
		switch (typeface) {
		case LEAGUE_GOTHIC:
			v.setTypeface(leagueGothic);
			break;
		case LEAGUE_GOTHIC_ITALIC:
			v.setTypeface(leagueGothicItalic);
			break;
		case OPEN_SANS:
			v.setTypeface(openSans);
			break;
		case OPEN_SANS_BOLD:
			v.setTypeface(openSansBold);
			break;
		}
	}
}
