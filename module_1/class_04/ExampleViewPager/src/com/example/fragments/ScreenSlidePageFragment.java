package com.example.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ScreenSlidePageFragment extends Fragment {

	private static final String BACKGROUND_COLOR = "color";
	private static final String INDEX = "index";
	private static final String IMAGE_ID = "imageid";

	private int color;
	private int index;
	private int imgID;

	public static ScreenSlidePageFragment newInstance(int color, int index,int _imgID) {

		ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();

		Bundle bundle = new Bundle();
		bundle.putInt(BACKGROUND_COLOR, color);
		bundle.putInt(INDEX, index);
		bundle.putInt(IMAGE_ID, _imgID);
		fragment.setArguments(bundle);
		fragment.setRetainInstance(true);

		return fragment;

	}
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		this.color = Color.WHITE;
		this.index = (getArguments() != null) ? getArguments().getInt(INDEX)
				: -1;
		this.imgID = (getArguments() != null) ? getArguments().getInt(IMAGE_ID)
				: 0;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.fragment_screen_slide_page, container, false);

		TextView tvIndex = (TextView) rootView.findViewById(R.id.tvIndex);
		tvIndex.setText(String.valueOf(this.index));

		rootView.setBackgroundColor(this.color);
		ImageView img=(ImageView)rootView.findViewById(R.id.img);
		img.setImageResource(imgID);

		return rootView;

	}
}
