package com.maddy.adiii.mvpkrushibasket.Customer.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.maddy.adiii.mvpkrushibasket.R;
import com.maddy.adiii.mvpkrushibasket.login_reg;

public class C_offers_fragment extends Fragment {
	
	private View rootView;
	/*private Button GotoLogin;
	*/
	public C_offers_fragment(){
	
	}
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
	        @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_c_offers, container, false);

		/*rootView = inflater.inflate(R.layout.fragment_c_offers, container, false);

		GotoLogin=(Button)rootView.findViewById(R.id.btnGotologin);
		GotoLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i= new Intent(getContext(), login_reg.class);
				startActivity(i);
			}
		});*/
		return rootView;
	}

}
