package com.example.examplefragment.view;

import com.example.examplefragment.OnCompleteDetails;
import com.example.examplefragment.R;
import com.example.examplefragment.utils.AppLog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentListLanguage extends Fragment {

	private OnCompleteDetails aparent;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return inflater.inflate(R.layout.fragment_list_language, container,false);
		View view=inflater.inflate(R.layout.fragment_list_language, container,false);
		
		//Log.v("CONSOLE","view "+view);
		AppLog.v(view, 1);
		
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		app();
	}
	private void app() {
		// TODO Auto-generated method stub
		
		final ListView lstDev =(ListView)getView().findViewById(R.id.lstdev);
		
		String[] data={"Python","Ruby","Go","DART","C++","C#",
				"Python","Ruby","Go","DART","C++","C#"};
		//lista
		
		//adapter
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
				data);
		//setear1 adapter
		lstDev.setAdapter(adapter);
		lstDev.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> aview, View view, int position,
					long arg3) {
				// TODO Auto-generated method stub
				
				String txt=String.valueOf(lstDev.getAdapter().getItem(position));
				aparent.setText(txt, position+" Descripción de Lenguaje");
			}
		});
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		

	}
	public void setActivityParent(OnCompleteDetails parent)
	{
		aparent=parent;
	}
}
