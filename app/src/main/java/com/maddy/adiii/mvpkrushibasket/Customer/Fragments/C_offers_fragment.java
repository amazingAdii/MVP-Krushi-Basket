package com.maddy.adiii.mvpkrushibasket.Customer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.maddy.adiii.mvpkrushibasket.R;

public class C_offers_fragment extends Fragment {
	
	private View rootView;
	
	public C_offers_fragment(){
	
	}
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
	        @Nullable Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.fragment_c_offers, container, false);
		
		
		return rootView;
	}
	
}
