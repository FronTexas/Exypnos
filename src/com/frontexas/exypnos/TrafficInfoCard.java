package com.frontexas.exypnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.exypnos.R;

public class TrafficInfoCard extends RelativeLayout {
	private TypefaceExypnos tfe;
	private TextView tvRouteInfo, tvETAWithoutTraffic, tvETA, tvDistance;

	public TrafficInfoCard(Context context) {
		super(context);

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		addView(inflater.inflate(R.layout.traffic_info_card, null));

		tfe = new TypefaceExypnos(context);
		initializeViews();

	}

	private void initializeViews() {
		tvRouteInfo = (TextView) findViewById(R.id.tvRouteInfo);
		tfe.setTypeface(tvRouteInfo, TypefaceExypnos.DENSE);

		tvETAWithoutTraffic = (TextView) findViewById(R.id.tvETAWithoutTraffic);
		tfe.setTypeface(tvETAWithoutTraffic, TypefaceExypnos.DENSE);

		tvETA = (TextView) findViewById(R.id.tvETA);
		tfe.setTypeface(tvETA, TypefaceExypnos.LEAGUE_GOTHIC);

		tvDistance = (TextView) findViewById(R.id.tvDistance);
		tfe.setTypeface(tvDistance, TypefaceExypnos.DENSE);
	}

}
