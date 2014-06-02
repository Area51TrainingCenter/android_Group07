package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.fragments.transformers.Depth2PageTransformer;
import com.example.fragments.transformers.DepthPageTransformer;
import com.example.fragments.transformers.ZoomOutPageTransformer;


public class MainActivity extends FragmentActivity {


	private ViewPager pager = null;
	private MyFragmentPagerAdapter pagerAdapter;

	@Override
	protected void onCreate(Bundle arg0) 
	{
		super.onCreate(arg0);
		this.setContentView(R.layout.main);

		this.pager = (ViewPager) this.findViewById(R.id.pager);

		//Transforms
		//this.pager.setPageTransformer(true, new ZoomOutPageTransformer());
		//this.pager.setPageTransformer(true, new Depth2PageTransformer());
		this.pager.setPageTransformer(true, new DepthPageTransformer());

		MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
				getSupportFragmentManager());
		
		adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
				.getColor(R.color.android_blue), 1,R.drawable.img01));
		adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
				.getColor(R.color.android_purple), 2,R.drawable.img02));
		adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
				.getColor(R.color.android_green), 3,R.drawable.img03));
		adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
				.getColor(R.color.android_yellow), 4,R.drawable.img04));
		adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
				.getColor(R.color.android_red), 5,R.drawable.img05));
		this.pager.setAdapter(adapter);


	}

	@Override
	public void onBackPressed() {

		if (this.pager.getCurrentItem() == 0)
			super.onBackPressed();
		else
			this.pager.setCurrentItem(this.pager.getCurrentItem() - 1);

	}
}
