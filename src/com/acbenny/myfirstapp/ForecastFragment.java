package com.acbenny.myfirstapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {
	
	private ArrayAdapter<String> arrAdapterForecast;
	
	public ForecastFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_sunshine_main,
				container, false);
		String[] forecastArray = {
				"Today - Sunny - 88/63",
				"Tomorrow - Foggy - 70/40",
				"Weds - Cloudy - 72/63",
				"Thurs - Astroids - 75/65",
				"Fri - Heavy Rain - 65/56",
				"Sat - Clear - 66/50",
				"Sun - Sunny - 80/68"
		};
		
		List <String> weekForecast = new ArrayList<String> (Arrays.asList(forecastArray));
		
		arrAdapterForecast = new ArrayAdapter<String> (getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForecast);
		
		ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
		listView.setAdapter(arrAdapterForecast);

		return rootView;
	}
}