package com.maddy.adiii.mvpkrushibasket.Customer.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.maddy.adiii.mvpkrushibasket.Customer.Fragments.C_basket_fragment;
import com.maddy.adiii.mvpkrushibasket.Customer.Fragments.C_categories_fragment;
import com.maddy.adiii.mvpkrushibasket.Customer.Fragments.C_home_fragment;
import com.maddy.adiii.mvpkrushibasket.Customer.Fragments.C_offers_fragment;
import com.maddy.adiii.mvpkrushibasket.Customer.Fragments.C_search_fragment;
import com.maddy.adiii.mvpkrushibasket.R;

public class CustomerHomePage extends AppCompatActivity {
	
	//private TextView mTextMessage;
	
	private FrameLayout mMainFrame;
	
	//Fragment Initiliaze
	private C_home_fragment homeFragment;
	private C_categories_fragment categoryFragment;
	private C_offers_fragment offersFragment;
	private C_search_fragment searchFragment;
	private C_basket_fragment basketFragment;
	
	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
	        = new BottomNavigationView.OnNavigationItemSelectedListener() {
		
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_home:
					changeFragment(homeFragment);
					return true;
				case R.id.navigation_categories:
					changeFragment(categoryFragment);
					return true;

				case R.id.navigation_offers:
					changeFragment(offersFragment);
					return true;
				case R.id.navigation_basket:
					changeFragment(basketFragment);
					return true;
			}
			return false;
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_homepage);
		
		//mTextMessage = (TextView) findViewById(R.id.message);
		mMainFrame = (FrameLayout)findViewById(R.id.mainframe);
		
		homeFragment = new C_home_fragment();
		categoryFragment = new C_categories_fragment();
		offersFragment = new C_offers_fragment();
		basketFragment = new C_basket_fragment();
		searchFragment = new C_search_fragment();
		
		BottomNavigationView navigation = (BottomNavigationView) findViewById(
		        R.id.navigation);
		navigation
		        .setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
	}
	
	
	private void changeFragment(Fragment fragment){
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.mainframe, fragment);
		fragmentTransaction.commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.customer_homepage_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.scanner :
				startActivity(new Intent(this, ScannerActivity.class));
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
		
	}
}
