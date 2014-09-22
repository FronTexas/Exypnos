package com.frontexas.exypnos;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.exypnos.R;

public class Coverpage extends ExypnosDrawerActivity implements
		OnEditorActionListener, OnClickListener {
	private EditText etSearchMP;
	private RelativeLayout rlAdvanceSearch;
	private ImageView ivLogin, ivSignUp;
	private RelativeLayout rlLoginWithFacebook, rlLoginWithGoogle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coverpage);
		initializeViews();
	}

	private void initializeViews() {
		etSearchMP = (EditText) findViewById(R.id.etSearchMP);
		etSearchMP.setOnEditorActionListener(this);

		rlAdvanceSearch = (RelativeLayout) findViewById(R.id.rlAdvanceSearch);
		rlAdvanceSearch.setOnClickListener(this);

		ivLogin = (ImageView) findViewById(R.id.ivLogin);
		ivSignUp = (ImageView) findViewById(R.id.ivSignUp);
		rlLoginWithFacebook = (RelativeLayout) findViewById(R.id.rlLoginWithFacebook);
		rlLoginWithGoogle = (RelativeLayout) findViewById(R.id.rlLoginWithGoogle);
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		if (actionId == EditorInfo.IME_ACTION_SEARCH) {
			Intent i = new Intent(Coverpage.this, SearchResultsPage.class);
			i.putExtra("relevantSearch", v.getText().toString());
			startActivity(i);
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.rlAdvanceSearch) {
			Intent i = new Intent(Coverpage.this, AdvanceSearchPage.class);
			startActivity(i);
		}
	}

}
