package com.frontexas.exypnos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.exypnos.R;

public class Coverpage extends Activity implements OnEditorActionListener,
		OnClickListener {
	private ImageView ivSignInGoogle, ivSignInFacebook, ivSignInBox,
			ivSignUpBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coverpage);
		initializeViews();
	}

	private void initializeViews() {
		ivSignInGoogle = (ImageView) findViewById(R.id.ivSignInGoogle);
		ivSignInGoogle.setOnClickListener(this);

		ivSignInFacebook = (ImageView) findViewById(R.id.ivSignInFacebook);
		ivSignInFacebook.setOnClickListener(this);

		ivSignInBox = (ImageView) findViewById(R.id.ivSignInBox);
		ivSignInBox.setOnClickListener(this);

		ivSignUpBox = (ImageView) findViewById(R.id.ivSignUpBox);
		ivSignUpBox.setOnClickListener(this);

	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		if (actionId == EditorInfo.IME_ACTION_SEARCH) {
			Intent i = new Intent(Coverpage.this, SearchResultsPage.class);
			i.putExtra("relevantSearch", v.getText().toString());
			i.putExtra("CallingActivity", "Coverpage");
			startActivity(i);
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		if (true) {
			Intent i = new Intent(Coverpage.this, AdvanceSearchPage.class);
			startActivity(i);
		}
	}

}
