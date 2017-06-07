package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JugarTop extends Activity {

	private Cursor cursor;
	private BBDD database;
	//private ImageView posicion1;
	//private ImageView posicion2;
	//private ImageView posicion3;
	private TextView usuario1;
	private TextView usuario2;
	private TextView usuario3;
	private TextView puntos1;
	private TextView puntos2;
	private TextView puntos3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jugartop);
		database = new BBDD(this);

		cursor = database.getReadableDatabase().rawQuery(
				"SELECT * FROM " + BBDD.TABLA_PTOS, null);
		//posicion1 = (ImageView) this.findViewById(R.id.posicion1);
		//posicion2 = (ImageView) this.findViewById(R.id.posicion2);
		//posicion3 = (ImageView) this.findViewById(R.id.posicion3);
		usuario1 = (TextView) this.findViewById(R.id.usuario1);
		usuario2 = (TextView) this.findViewById(R.id.usuario2);
		usuario3 = (TextView) this.findViewById(R.id.usuario3);
		puntos1 = (TextView) this.findViewById(R.id.puntos1);
		puntos2 = (TextView) this.findViewById(R.id.puntos2);
		puntos3 = (TextView) this.findViewById(R.id.puntos3);

		cursor.moveToPosition(0);
		usuario1.setText(cursor.getString(1));
		puntos1.setText(String.valueOf(cursor.getInt(2)));

		cursor.moveToNext();
		usuario2.setText(cursor.getString(1));
		puntos2.setText(String.valueOf(cursor.getInt(2)));

		cursor.moveToNext();
		usuario3.setText(cursor.getString(1));
		puntos3.setText(String.valueOf(cursor.getInt(2)));

		if (database != null) {
			database.close();
		}
	}

	public void btnClickPtos(View v) {
		Intent intent = null;
		if (v.getId() == R.id.btnReintentar) {
			switch (JugarMenu.materiaElegida) {
			case "GEOGRAFÍA":
				intent = new Intent(JugarTop.this, JugarGeo.class);
				break;
			case "DEPORTES":
				intent = new Intent(JugarTop.this, JugarDeportes.class);
				break;
			case "LÓGICA":
				intent = new Intent(JugarTop.this, JugarLogica.class);
				break;
			}

		} else if (v.getId() == R.id.btnMenuInicio) {
			intent = new Intent(JugarTop.this, MainActivity.class);
		}
		JugarMenu.contAciertos = 0;
		JugarMenu.ptosTotales = 0;
		JugarMenu.bonusAciertos = "";
		JugarMenu.bonusDificultad = "";
		startActivity(intent);
		finish();
	}

	@Override
	public void onBackPressed() {
	}
}
