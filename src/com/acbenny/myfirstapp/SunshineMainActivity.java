package com.acbenny.myfirstapp;

import android.app.Activity;
import android.os.Bundle;

public class SunshineMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sunshine_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new ForecastFragment()).commit();
		}
	}
}
