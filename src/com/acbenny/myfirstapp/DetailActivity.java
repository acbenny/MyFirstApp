package com.acbenny.myfirstapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new DetailFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			startActivity(new Intent(this, SettingsActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class DetailFragment extends Fragment {

		private static final String LOG_TAG = DetailFragment.class
				.getSimpleName();
		private static final String FORECAST_SHARE_HASHTAG = "#SunshineApp";
		private String mForecastStr;

		public DetailFragment() {
			setHasOptionsMenu(true);
		}

		@Override
		public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
			inflater.inflate(R.menu.detail_fragment, menu);
			MenuItem shareItem = menu.findItem(R.id.action_share);
			ShareActionProvider shareProvider = (ShareActionProvider) shareItem
					.getActionProvider();

			if (shareProvider != null) {
				shareProvider.setShareIntent(createShareForecastIntent());
			} else {
				Log.d(LOG_TAG, "ShareProvider is null");
			}
			super.onCreateOptionsMenu(menu, inflater);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Intent intent = getActivity().getIntent();
			View rootView = inflater.inflate(R.layout.fragment_detail,
					container, false);

			if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
				mForecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
				((TextView) rootView.findViewById(R.id.detail_text))
						.setText(mForecastStr);
			}
			return rootView;
		}

		private Intent createShareForecastIntent() {
			Intent shareIntent = new Intent(Intent.ACTION_SEND);
			shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
			shareIntent.setType("text/plain");
			shareIntent.putExtra(Intent.EXTRA_TEXT, mForecastStr
					+ FORECAST_SHARE_HASHTAG);
			return shareIntent;
		}
	}
}
