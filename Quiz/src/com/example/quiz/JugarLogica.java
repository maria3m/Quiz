package com.example.quiz;

import java.util.*;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.*;
import android.view.View;
import android.widget.*;


public class JugarLogica extends Activity {

	private TextView pregLog;
	private RadioButton respLog1;
	private RadioButton respLog2;
	private RadioButton respLog3;
	private RadioButton respLog4;
	private TextView tiempoLog;
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
		setContentView(R.layout.jugarpreglog);

		cuentaAtras = new CountDownTimer(180000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				long t = millisUntilFinished / 1000;
				JugarMenu.tRestSeg = Integer.parseInt(String.valueOf(t));
				long min = t / 60;
				long seg = t % 60;

				if (seg >= 10) {
					tiempoLog.setText("0" + Long.toString(min) + ":"
							+ Long.toString(seg));
				} else {
					tiempoLog.setText("0" + Long.toString(min) + ":0"
							+ Long.toString(seg));
				}
			}

			@Override
			public void onFinish() {
				Intent intent;
				intent = new Intent(JugarLogica.this, JugarPtos.class);
				JugarMenu.tRest = tiempoLog.getText().toString();
				startActivity(intent);
				finish();
			}
		};

		preguntaRnd = rnd.nextInt(24) + 1;
		database = new BBDD(this);
		db = database.getReadableDatabase();

		pregLog = (TextView) this.findViewById(R.id.pregLog);
		respLog1 = (RadioButton) this.findViewById(R.id.respLog1);
		respLog2 = (RadioButton) this.findViewById(R.id.respLog2);
		respLog3 = (RadioButton) this.findViewById(R.id.respLog3);
		respLog4 = (RadioButton) this.findViewById(R.id.respLog4);
		tiempoLog = (TextView) this.findViewById(R.id.tiempoLog);
		cuentaAtras.onTick(180000);
		cuentaAtras.start();
		pregLog.setText(DatosBBDD.obtenerPregunta(db, BBDD.TABLA_LOG,
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
						pregLog.setText(DatosBBDD.obtenerPregunta(db,
								BBDD.TABLA_LOG, preguntaRnd));
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
				cuentaAtras.onFinish();
			} else {
				JugarMenu.tRest = "00:00";
			}
		}
	}

	public void sacarRespuestas() {
		respCorrecta = DatosBBDD.obtenerRespC(db, BBDD.TABLA_LOG, preguntaRnd);
		respIncorrecta1 = DatosBBDD.obtenerRespI1(db, BBDD.TABLA_LOG,
				preguntaRnd);
		respIncorrecta2 = DatosBBDD.obtenerRespI2(db, BBDD.TABLA_LOG,
				preguntaRnd);
		respIncorrecta3 = DatosBBDD.obtenerRespI3(db, BBDD.TABLA_LOG,
				preguntaRnd);

		respuestas = new ArrayList<String>();
		respuestas.add(respCorrecta);
		respuestas.add(respIncorrecta1);
		respuestas.add(respIncorrecta2);
		respuestas.add(respIncorrecta3);
		Collections.shuffle(respuestas);
		respLog1.setText(respuestas.get(0));
		respLog2.setText(respuestas.get(1));
		respLog3.setText(respuestas.get(2));
		respLog4.setText(respuestas.get(3));
		respLog1.setChecked(true);
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
		if (respLog1.isChecked()) {
			respFinal = respLog1.getText().toString();
		} else if (respLog2.isChecked()) {
			respFinal = respLog2.getText().toString();
		} else if (respLog3.isChecked()) {
			respFinal = respLog3.getText().toString();
		} else if (respLog4.isChecked()) {
			respFinal = respLog4.getText().toString();
		} else {
			respFinal = "";
		}
		return respFinal;
	}

	@Override
	public void onBackPressed() {
	}
}
