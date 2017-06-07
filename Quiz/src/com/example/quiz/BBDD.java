package com.example.quiz;

import android.content.Context;
import android.database.sqlite.*;

public class BBDD extends SQLiteOpenHelper {

	static final int VERSION = 1;
	static final String NOMBRE = "database";
	static final String TABLA_PTOS = "top";
	static final String TABLA_GEO = "geografia";
	static final String TABLA_DEP = "deportes";
	static final String TABLA_LOG = "logica";

	public BBDD(Context context) {
		super(context, NOMBRE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLA_PTOS
				+ " (_id INTEGER PRIMARY KEY,"
				+ " nombreUsuario TEXT,puntos INTEGER)");

		db.execSQL("CREATE TABLE " + TABLA_GEO
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, pregunta TEXT,"
				+ " respC TEXT, respI1 TEXT, respI2 TEXT, respI3 TEXT);");
		
		db.execSQL("CREATE TABLE " + TABLA_DEP
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, pregunta TEXT,"
				+ " respC TEXT, respI1 TEXT, respI2 TEXT, respI3 TEXT);");
		
		db.execSQL("CREATE TABLE " + TABLA_LOG
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, pregunta TEXT,"
				+ " respC TEXT, respI1 TEXT, respI2 TEXT, respI3 TEXT);");

		DatosBBDD.insertarDatos(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
