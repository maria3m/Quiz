package com.example.quiz;

import java.util.*;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.*;
import android.view.View;
import android.widget.*;

public class JugarDeportes extends Activity {

	private TextView pregDep;
	private RadioButton respDep1;
	private RadioButton respDep2;
	private RadioButton respDep3;
	private RadioButton respDep4;
	private TextView tiempoDep;
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
		setContentView(R.layout.jugarpregdep);

		cuentaAtras = new CountDownTimer(180000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				long t = millisUntilFinished / 1000;
				JugarMenu.tRestSeg = Integer.parseInt(String.valueOf(t));
				long min = t / 60;
				long seg = t % 60;

				if (seg >= 10) {
					tiempoDep.setText("0" + Long.toString(min) + ":"
							+ Long.toString(seg));
				} else {
					tiempoDep.setText("0" + Long.toString(min) + ":0"
							+ Long.toString(seg));
				}
			}

			@Override
			public void onFinish() {
				Intent intent;
				intent = new Intent(JugarDeportes.this, JugarPtos.class);
				startActivity(intent);
				finish();
			}
		};

		preguntaRnd = rnd.nextInt(24) + 1;
		database = new BBDD(this);
		db = database.getReadableDatabase();

		pregDep = (TextView) this.findViewById(R.id.pregDep);
		respDep1 = (RadioButton) this.findViewById(R.id.respDep1);
		respDep2 = (RadioButton) this.findViewById(R.id.respDep2);
		respDep3 = (RadioButton) this.findViewById(R.id.respDep3);
		respDep4 = (RadioButton) this.findViewById(R.id.respDep4);
		tiempoDep = (TextView) this.findViewById(R.id.tiempoDep);
		cuentaAtras.onTick(180000);
		cuentaAtras.start();
		pregDep.setText(DatosBBDD.obtenerPregunta(db, BBDD.TABLA_DEP,
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
						pregDep.setText(DatosBBDD.obtenerPregunta(db,
								BBDD.TABLA_DEP, preguntaRnd));
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
				JugarMenu.tRest = tiempoDep.getText().toString();
				cuentaAtras.onFinish();
			} else {
				JugarMenu.tRest = "00:00";
			}
		}
	}

	public void sacarRespuestas() {
		respCorrecta = DatosBBDD.obtenerRespC(db, BBDD.TABLA_DEP, preguntaRnd);
		respIncorrecta1 = DatosBBDD.obtenerRespI1(db, BBDD.TABLA_DEP,
				preguntaRnd);
		respIncorrecta2 = DatosBBDD.obtenerRespI2(db, BBDD.TABLA_DEP,
				preguntaRnd);
		respIncorrecta3 = DatosBBDD.obtenerRespI3(db, BBDD.TABLA_DEP,
				preguntaRnd);

		respuestas = new ArrayList<String>();
		respuestas.add(respCorrecta);
		respuestas.add(respIncorrecta1);
		respuestas.add(respIncorrecta2);
		respuestas.add(respIncorrecta3);
		Collections.shuffle(respuestas);
		respDep1.setText(respuestas.get(0));
		respDep2.setText(respuestas.get(1));
		respDep3.setText(respuestas.get(2));
		respDep4.setText(respuestas.get(3));
		respDep1.setChecked(true);
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
		if (respDep1.isChecked()) {
			respFinal = respDep1.getText().toString();
		} else if (respDep2.isChecked()) {
			respFinal = respDep2.getText().toString();
		} else if (respDep3.isChecked()) {
			respFinal = respDep3.getText().toString();
		} else if (respDep4.isChecked()) {
			respFinal = respDep4.getText().toString();
		} else {
			respFinal = "";
		}
		return respFinal;
	}

	@Override
	public void onBackPressed() {
	}
}
