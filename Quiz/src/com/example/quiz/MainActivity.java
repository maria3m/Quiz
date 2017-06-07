package com.example.quiz;

import android.app.*;
import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Toast.makeText(this,
				"RECOMENDACION: LEA LAS REGLAS ANTES DE COMENZAR A JUGAR",
				Toast.LENGTH_LONG).show();
	}

	public void btnClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btnJugar:
			intent = new Intent(MainActivity.this, JugarMenu.class);
			startActivity(intent);
			finish();
			break;
		case R.id.btnReglas:
			intent = new Intent(MainActivity.this, Reglas.class);
			startActivity(intent);
			finish();
			break;
		case R.id.btnTop:
			intent = new Intent(MainActivity.this, Top3.class);
			startActivity(intent);
			finish();
			break;
		case R.id.btnSalir:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("¿Realmente quieres salir?")
					.setTitle("Confirmación de salida")
					.setCancelable(false)
					.setNegativeButton("Seguir jugando",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							})
					.setPositiveButton("Salir",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();
								}
							});
			AlertDialog dialogo = builder.create();
			dialogo.show();
			break;
		}
	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("¿Realmente quieres salir?")
				.setTitle("Confirmación de salida")
				.setCancelable(false)
				.setNegativeButton("Seguir jugando",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						})
				.setPositiveButton("Salir",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								finish();
							}
						});
		AlertDialog dialogo = builder.create();
		dialogo.show();
	}
}
