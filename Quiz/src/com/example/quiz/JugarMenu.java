package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class JugarMenu extends Activity {

	private Spinner spinner1;
	private Spinner spinner2;
	public static String materiaElegida;
	public static String nivelDificultad;
	public static int ptosTotales;
	public static int contAciertos;
	public static String tRest;
	public static int tRestSeg;
	public static String bonusDificultad;
	public static String bonusAciertos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jugarmenu);
		spinner1 = (Spinner) this.findViewById(R.id.spinner1);
		spinner2 = (Spinner) this.findViewById(R.id.spinner2);

		ptosTotales = 0;
		contAciertos = 0;
		materiaElegida = "";
		nivelDificultad = "";
		tRest = "";
		tRestSeg = 0;
		bonusDificultad = "";
		bonusAciertos = "";
	}

	public void btnClickJugar(View v) {
		Intent intent = null;
		materiaElegida = spinner1.getSelectedItem().toString();
		switch (v.getId()) {
		case R.id.btnComenzar:
			if (materiaElegida.equals("DEPORTES")) {

				intent = new Intent(JugarMenu.this, JugarDeportes.class);

			} else if (materiaElegida.equals("LÓGICA")) {

				intent = new Intent(JugarMenu.this, JugarLogica.class);

			} else if (materiaElegida.equals("GEOGRAFÍA")) {

				intent = new Intent(JugarMenu.this, JugarGeo.class);

			}

			nivelDificultad = spinner2.getSelectedItem().toString();
			startActivity(intent);
			break;

		case R.id.btnVolver:

			intent = new Intent(JugarMenu.this, MainActivity.class);
			startActivity(intent);
		}

		finish();
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(JugarMenu.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
