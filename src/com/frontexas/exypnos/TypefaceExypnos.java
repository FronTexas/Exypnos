package com.frontexas.exypnos;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

public class TypefaceExypnos {
	public static final String LEAGUE_GOTHIC = "leagueGothic";
	public static final String LEAGUE_GOTHIC_ITALIC = "leagueGothicItalic";
	public static final String OPEN_SANS_SEMIBOLD = "openSansSemiBold";
	public static final String OPEN_SANS = "openSans";

	private Typeface leagueGothic, leagueGothicItalic, openSansSemiBold,
			openSans;

	public TypefaceExypnos(Context context) {
		leagueGothic = Typeface.createFromAsset(context.getAssets(),
				"fonts/leaguegothic.otf");
		leagueGothicItalic = Typeface.createFromAsset(context.getAssets(),
				"fonts/leaguegothic_italic.ttf");
		openSansSemiBold = Typeface.createFromAsset(context.getAssets(),
				"fonts/opensans_semibold.ttf");
		openSans = Typeface.createFromAsset(context.getAssets(),
				"fonts/opensans_regular.ttf");
	}

	public void setTypeface(TextView v, String typeface) {
		switch (typeface) {
		case LEAGUE_GOTHIC:
			Log.d("Inflating Error", "IE -- v = " + v);
			Log.d("Inflating Error", "IE -- leagueGothic = " + leagueGothic);
			v.setTypeface(leagueGothic);
			break;
		case LEAGUE_GOTHIC_ITALIC:
			v.setTypeface(leagueGothicItalic);
			break;
		case OPEN_SANS_SEMIBOLD:
			v.setTypeface(openSansSemiBold);
		case OPEN_SANS:
			v.setTypeface(openSans);
		}
	}
}
