package com.example.quiz;

import android.app.*;
import android.content.*;
import android.database.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Top3 extends Activity {

	private Cursor cursor;
	private BBDD database;
	private TextView usuario1;
	private TextView usuario2;
	private TextView usuario3;
	private TextView puntos1;
	private TextView puntos2;
	private TextView puntos3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puntuaciones);
		database = new BBDD(this);

		cursor = database.getReadableDatabase().rawQuery("SELECT * FROM " + BBDD.TABLA_PTOS,
				null);
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
		
		if (database != null){
			database.close();
		}
	}

	public void btnClickTopPtos(View v) {
		Intent intent;
		if (v.getId() == R.id.btnVolver) {
			intent = new Intent(Top3.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(Top3.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
