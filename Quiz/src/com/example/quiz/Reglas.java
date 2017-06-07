package com.example.quiz;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class Reglas extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reglas);
	}

	public void btnClickReglas(View v) {
		Intent intent;
		if (v.getId() == R.id.btnVolver) {
			intent = new Intent(Reglas.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(Reglas.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
