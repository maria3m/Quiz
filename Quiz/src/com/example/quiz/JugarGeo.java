package com.example.quiz;

import java.util.*;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.*;
import android.view.View;
import android.widget.*;


public class JugarGeo extends Activity {

	private TextView pregGeo;
	private RadioButton respGeo1;
	private RadioButton respGeo2;
	private RadioButton respGeo3;
	private RadioButton respGeo4;
	private TextView tiempoGeo;
	private int cont = 0;
	private Random rnd = new Random();
	private int preguntaRnd;
	private BBDD database;
	private String respCorrecta;
	private String respIncorrecta1;
	private String respIncorrecta2;
	private String respIncorrecta3;
	private String respFinal;
	private CountDownTimer cuentaAtras;
	private ArrayList<String> respuestas;
	private SQLiteDatabase db;

	private ArrayList<Integer> repetidos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jugarpreggeo);

		cuentaAtras = new CountDownTimer(180000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				long t = millisUntilFinished / 1000;
				JugarMenu.tRestSeg = Integer.parseInt(String.valueOf(t));
				long min = t / 60;
				long seg = t % 60;

				if (seg >= 10) {
					tiempoGeo.setText("0" + Long.toString(min) + ":"
							+ Long.toString(seg));
				} else {
					tiempoGeo.setText("0" + Long.toString(min) + ":0"
							+ Long.toString(seg));
				}
			}

			@Override
			public void onFinish() {
				Intent intent;
				intent = new Intent(JugarGeo.this, JugarPtos.class);
				startActivity(intent);
				finish();
			}
		};

		preguntaRnd = rnd.nextInt(24) + 1;
		database = new BBDD(this);
		db = database.getReadableDatabase();

		pregGeo = (TextView) this.findViewById(R.id.pregGeo);
		respGeo1 = (RadioButton) this.findViewById(R.id.respGeo1);
		respGeo2 = (RadioButton) this.findViewById(R.id.respGeo2);
		respGeo3 = (RadioButton) this.findViewById(R.id.respGeo3);
		respGeo4 = (RadioButton) this.findViewById(R.id.respGeo4);
		tiempoGeo = (TextView) this.findViewById(R.id.tiempoGeo);
		cuentaAtras.onTick(180000);
		cuentaAtras.start();
		pregGeo.setText(DatosBBDD.obtenerPregunta(db, BBDD.TABLA_GEO,
				preguntaRnd));

		sacarRespuestas();

		repetidos = new ArrayList<Integer>();
		repetidos.add(preguntaRnd);

	}

	public void btnClickPreg(View v) {
		boolean repetido = false;
		if (v.getId() == R.id.btnContPreg) {
			preguntaRnd = rnd.nextInt(25) + 1;
			System.out.println(preguntaRnd);
			while (cont < 8) {

				for (int i = 0; i < repetidos.size(); i++) {
					if (repetidos.get(i) == preguntaRnd) {
						repetido = true;
					}
				}
				if (!repetido) {

					if (esCorrecta()) {
						JugarMenu.ptosTotales += 100;
						MediaPlayer mp = MediaPlayer.create(this, R.raw.acierto);
				        mp.start();
						JugarMenu.contAciertos++;
					} else {
						MediaPlayer mp = MediaPlayer.create(this, R.raw.error);
				        mp.start();
					}
					if (cont < 7) {
						pregGeo.setText(DatosBBDD.obtenerPregunta(db,
								BBDD.TABLA_GEO, preguntaRnd));
						sacarRespuestas();
					}

					cont++;
					repetidos.add(preguntaRnd);
					break;
				} else {

					preguntaRnd = rnd.nextInt(25) + 1;
					repetido = false;
				}
			}
			if (cont == 8) {
				cuentaAtras.cancel();
				JugarMenu.tRest = tiempoGeo.getText().toString();
				cuentaAtras.onFinish();
			} else {
				JugarMenu.tRest = "00:00";
			}
		}
	}

	public void sacarRespuestas() {
		respCorrecta = DatosBBDD.obtenerRespC(db, BBDD.TABLA_GEO, preguntaRnd);
		respIncorrecta1 = DatosBBDD.obtenerRespI1(db, BBDD.TABLA_GEO,
				preguntaRnd);
		respIncorrecta2 = DatosBBDD.obtenerRespI2(db, BBDD.TABLA_GEO,
				preguntaRnd);
		respIncorrecta3 = DatosBBDD.obtenerRespI3(db, BBDD.TABLA_GEO,
				preguntaRnd);

		respuestas = new ArrayList<String>();
		respuestas.add(respCorrecta);
		respuestas.add(respIncorrecta1);
		respuestas.add(respIncorrecta2);
		respuestas.add(respIncorrecta3);
		Collections.shuffle(respuestas);
		respGeo1.setText(respuestas.get(0));
		respGeo2.setText(respuestas.get(1));
		respGeo3.setText(respuestas.get(2));
		respGeo4.setText(respuestas.get(3));
		respGeo1.setChecked(true);
	}

	public boolean esCorrecta() {

		boolean correcta;

		if (respuestaFinal().equals(respCorrecta)) {
			correcta = true;
		} else {
			correcta = false;
		}
		return correcta;
	}

	public String respuestaFinal() {
		if (respGeo1.isChecked()) {
			respFinal = respGeo1.getText().toString();
		} else if (respGeo2.isChecked()) {
			respFinal = respGeo2.getText().toString();
		} else if (respGeo3.isChecked()) {
			respFinal = respGeo3.getText().toString();
		} else if (respGeo4.isChecked()) {
			respFinal = respGeo4.getText().toString();
		} else {
			respFinal = "";
		}
		return respFinal;
	}

	@Override
	public void onBackPressed() {
	}
}
