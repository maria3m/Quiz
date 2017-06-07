package com.example.quiz;

import android.app.Activity;
import android.content.*;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

public class JugarPtos extends Activity {

	private TextView aciertos;
	private TextView tRestante;
	private TextView dificultad;
	private TextView bonusAciertos;
	private TextView bonusDificultad;
	private TextView puntosFinal;
	private EditText campoUsuario;
	public static String nombreUsuario;
	private BBDD database;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jugarpuntos);

		aciertos = (TextView) this.findViewById(R.id.aciertos);
		tRestante = (TextView) this.findViewById(R.id.tRestante);
		dificultad = (TextView) this.findViewById(R.id.dificultad);
		bonusAciertos = (TextView) this.findViewById(R.id.bonusAciertos);
		bonusDificultad = (TextView) this.findViewById(R.id.bonusDificultad);
		puntosFinal = (TextView) this.findViewById(R.id.puntosFinal);
		campoUsuario = (EditText) this.findViewById(R.id.campoUsuario);

		if (JugarMenu.contAciertos == 8) {
			JugarMenu.bonusAciertos = "50";
		} else {
			JugarMenu.bonusAciertos = "0";
		}
		switch (JugarMenu.nivelDificultad) {
		case "FÁCIL":
			JugarMenu.bonusDificultad = "x1";
			break;
		case "MEDIO":
			JugarMenu.bonusDificultad = "x2";
			break;
		case "DIFÍCIL":
			JugarMenu.bonusDificultad = "x3";
			break;
		case "EXPERTO":
			JugarMenu.bonusDificultad = "x4";
			break;
		}

		aciertos.setText("Aciertos:\t" + JugarMenu.contAciertos + "/8");
		tRestante.setText("Tiempo restante:\t" + JugarMenu.tRest);
		dificultad.setText("Dificultad:\t" + JugarMenu.nivelDificultad);
		bonusAciertos.setText("Bonus aciertos:\t" + JugarMenu.bonusAciertos);
		bonusDificultad.setText("Bonus dificultad:\t"
				+ JugarMenu.bonusDificultad);
		puntosFinal.setText("Puntos totales:\t" + calcularPtosTotales());

		database = new BBDD(this);
		db = database.getWritableDatabase();

		campoUsuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					ocultarTeclado(v);
				}
			}
		});

	}

	public void btnClickFinal(View v) {
		Intent intent;
		if (campoUsuario.getText().toString().trim().equalsIgnoreCase("")) {
			campoUsuario.setError("Escriba un nombre");
		} else {
			if (v.getId() == R.id.btnFinPreg) {
				nombreUsuario = campoUsuario.getText().toString();
				intent = new Intent(JugarPtos.this, JugarTop.class);
				actualizarTop();
				startActivity(intent);
				finish();
			}
		}
	}

	@Override
	public void onBackPressed() {
	}

	public String calcularPtosTotales() {
		int segundosRestantes = JugarMenu.tRestSeg;
		int ptosPorDificultad = segundosRestantes;
		String resultado;
		if (JugarMenu.contAciertos == 8) {
			JugarMenu.ptosTotales += 50;
		}

		if (!JugarMenu.tRest.equals("00:00")) {
			switch (JugarMenu.nivelDificultad) {
			case "FÁCIL":
				break;
			case "MEDIO":
				ptosPorDificultad = segundosRestantes * 2;
				break;
			case "DIFÍCIL":
				ptosPorDificultad = segundosRestantes * 3;
				break;
			case "EXPERTO":
				ptosPorDificultad = segundosRestantes * 4;
				break;
			}
		} else {
			ptosPorDificultad = 0;
		}
		JugarMenu.ptosTotales += ptosPorDificultad;
		resultado = String.valueOf(JugarMenu.ptosTotales);
		return resultado;
	}

	public void actualizarTop() {
		if (DatosBBDD.obtenerPtos(db, 3) < JugarMenu.ptosTotales) {
			if (DatosBBDD.obtenerPtos(db, 2) < JugarMenu.ptosTotales) {
				if (DatosBBDD.obtenerPtos(db, 1) < JugarMenu.ptosTotales) {
					DatosBBDD.modificarUsuario(db, 3,
							DatosBBDD.obtenerUsuario(db, 2),
							DatosBBDD.obtenerPtos(db, 2));
					DatosBBDD.modificarUsuario(db, 2,
							DatosBBDD.obtenerUsuario(db, 1),
							DatosBBDD.obtenerPtos(db, 1));
					DatosBBDD.modificarUsuario(db, 1, nombreUsuario,
							JugarMenu.ptosTotales);
				} else {
					DatosBBDD.modificarUsuario(db, 3,
							DatosBBDD.obtenerUsuario(db, 2),
							DatosBBDD.obtenerPtos(db, 2));
					DatosBBDD.modificarUsuario(db, 2, nombreUsuario,
							JugarMenu.ptosTotales);
				}
			} else {
				DatosBBDD.modificarUsuario(db, 3, nombreUsuario,
						JugarMenu.ptosTotales);
			}
		}
	}

	public void ocultarTeclado(View v) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
	}
}
