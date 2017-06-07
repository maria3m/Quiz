package com.example.quiz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatosBBDD {

	public static void insertarUsuario(SQLiteDatabase db, int id,
			String nombre, int puntos) {

		db.execSQL("INSERT INTO " + BBDD.TABLA_PTOS + " VALUES(" + id + ", '"
				+ nombre + "', " + puntos + ");");
	}

	public static void modificarUsuario(SQLiteDatabase db, int id,
			String nombre, int puntos) {
		db.execSQL("UPDATE " + BBDD.TABLA_PTOS + " SET nombreUsuario = '" + nombre
				+ "', puntos = " + puntos + " WHERE _id = " + id + ";");
	}

	public static void insertarPregunta(SQLiteDatabase db, String tabla,
			String pregunta, String respC, String respI1, String respI2,
			String respI3) {

		db.execSQL("INSERT INTO " + tabla
				+ "(pregunta,respC,respI1,respI2,respI3) VALUES('" + pregunta
				+ "','" + respC + "','" + respI1 + "','" + respI2 + "','"
				+ respI3 + "');");
	}

	public static String obtenerUsuario(SQLiteDatabase db, int id) {

		Cursor cursor = null;
		cursor = db.rawQuery("SELECT nombreUsuario FROM " + BBDD.TABLA_PTOS
				+ " WHERE _id = " + id + ";", null);
		cursor.moveToNext();
		return cursor.getString(0);
	}

	public static int obtenerPtos(SQLiteDatabase db, int id) {

		Cursor cursor;
		cursor = db.rawQuery("SELECT puntos FROM " + BBDD.TABLA_PTOS
				+ " WHERE _id = " + id + ";", null);
		cursor.moveToNext();
		return Integer.parseInt(cursor.getString(0));
	}

	public static String obtenerPregunta(SQLiteDatabase db, String tabla, int id) {

		Cursor cursor;
		cursor = db.rawQuery("SELECT pregunta FROM " + tabla + " WHERE _id = "
				+ id + ";", null);
		cursor.moveToNext();
		return cursor.getString(0);
	}

	public static String obtenerRespC(SQLiteDatabase db, String tabla, int id) {

		Cursor cursor;
		cursor = db.rawQuery("SELECT respC FROM " + tabla + " WHERE _id = "
				+ id + ";", null);
		cursor.moveToNext();
		return cursor.getString(0);
	}

	public static String obtenerRespI1(SQLiteDatabase db, String tabla, int id) {

		Cursor cursor;
		cursor = db.rawQuery("SELECT RespI1 FROM " + tabla + " WHERE _id = "
				+ id + ";", null);
		cursor.moveToNext();
		return cursor.getString(0);
	}

	public static String obtenerRespI2(SQLiteDatabase db, String tabla, int id) {

		Cursor cursor;
		cursor = db.rawQuery("SELECT RespI2 FROM " + tabla + " WHERE _id = "
				+ id + ";", null);
		cursor.moveToNext();
		return cursor.getString(0);
	}

	public static String obtenerRespI3(SQLiteDatabase db, String tabla, int id) {

		Cursor cursor;
		cursor = db.rawQuery("SELECT RespI3 FROM " + tabla + " WHERE _id = "
				+ id + ";", null);
		cursor.moveToNext();
		return cursor.getString(0);
	}

	public static void insertarDatos(SQLiteDatabase db) {

		insertarUsuario(db, 1, "Usuario", 0);
		insertarUsuario(db, 2, "Usuario", 0);
		insertarUsuario(db, 3, "Usuario", 0);

		insertarPregunta(db, BBDD.TABLA_GEO,
				"�C�mo se conoce a los habitantes de M�laga?", "Boquerones",
				"Jureles", "Sardinas", "Calamares");
		insertarPregunta(
				db,
				BBDD.TABLA_GEO,
				"�Cu�l de los siguientes pa�ses considera a la vaca como un animal sagrado?",
				"India", "Argentina", "Arabia Saud�", "China");
		insertarPregunta(
				db,
				BBDD.TABLA_GEO,
				"�Cu�l de los siguientes pa�ses NO tiene una bandera de color azul, rojo y amarillo?",
				"Per�", "Colombia", "Ecuador", "Venezuela");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Qu� pa�s es considerado el pa�s de los mil lagos?",
				"Finlandia", "Suecia", "Islandia", "Noruega");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Cu�l es la capital del estado de Arkansas?", "Little Rock",
				"Kansas", "Hot Springs", "Washington");
		insertarPregunta(db, BBDD.TABLA_GEO, "�Cu�l es la capital de Suiza?",
				"Berna", "Z�rich", "Ginebra", "Basilea");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Cu�l de las siguientes islas est� m�s al sur?", "Malta",
				"Sicilia", "C�rcega", "Cerde�a");
		insertarPregunta(
				db,
				BBDD.TABLA_GEO,
				"�Qu� accidente geogr�fico se define como un conjunto de islas, islotes y diminutas masas de tierra cercanas entre s�?",
				"Archipi�lago", "Islotes", "Pen�nsula", "Continente");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�En qu� mar desemboca el r�o Segura?", "Mar Mediterr�neo",
				"Mar Cant�brico", "Oc�ano Atl�ntico", "Ninguna es correcta");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�En qu� continente est� la India?", "Asia", "Ocean�a",
				"Europa", "Am�rica");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Cu�l es la capital de Alemania?", "Berl�n", "Munich",
				"Dubl�n", "Frankfurt");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Cu�l de estos pa�ses no est� en una isla?", "Ghana",
				"Madagascar", "Jap�n", "Jamaica");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Cu�l de las grandes monta�as ha sido escalada m�s veces?",
				"El Everest", "El K2", "El Annapurna I", "El Annapurna II");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�De qu� colores es la bandera de B�lgica?",
				"Rojo, amarillo y negro", "Rojo y negro",
				"Negro, rojo y naranja", "Negro y amarillo");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�D�nde se celebra el Oktoberfest?", "Alemania", "Ucrania",
				"Rusia", "Reino Unido");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Cu�ndo es verano en el hemisferio sur?",
				"De Diciembre a Marzo", "De Marzo a Junio",
				"De Junio a Septiembre", "De Noviembre a Febrero");
		insertarPregunta(db, BBDD.TABLA_GEO, "�Cu�l es la capital de Jap�n?",
				"Tokyo", "Kyoto", "Pek�n", "Hong Kong");
		insertarPregunta(db, BBDD.TABLA_GEO, "�De q�e tiene forma Italia?",
				"Bota", "Gorro", "Nube", "Submarino");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Qu� dos ciudades de Espa�a son famosas por sus carnavales?",
				"C�diz y Santa Cruz de Tenerife", "C�diz y Sevilla",
				"M�laga y C�diz", "Las Palmas de Gran Canaria y C�diz");
		insertarPregunta(
				db,
				BBDD.TABLA_GEO,
				"�Con cu�l de las siguientes provincias no limita la Comunidad de Madrid?",
				"Salamanca", "Segovia", "Toledo", "�vila");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�En qu� ciudad est� situado El Barrio del Albaic�n?",
				"Granada", "C�rdoba", "Sevilla", "Ja�n");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Qu� pa�ses forman parte de la Pen�nsula Ib�rica?",
				"Espa�a, Portugal y Andorra", "Espa�a y Portugal",
				"Espa�a, Portugal y Francia", "Espa�a, Portugal e Italia");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�De d�nde es tradicional la paella?", "Comunidad Valenciana",
				"Pa�s Vasco", "Andaluc�a", "Catalun�a");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Cu�ntas comunidades aut�nomas hay en Espa�a?", "17", "15",
				"16", "18");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"�Cu�l es el r�o m�s caudaloso del mundo?", "El Amazonas",
				"El Nilo", "El Ganges", "El Danubio");

		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"�Cu�ntas finales del mundo ha disputado la Selecci�n Argentina de F�tbol?",
				"5", "6", "4", "7");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Qu� estilo de nataci�n es el m�s r�pido?", "Crol", "Espalda",
				"Mariposa", "Son todos igual de r�pidos");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�En qu� pa�s se invent� el voleibol?", "Estados Unidos",
				"Reino Unido", "Francia", "Rusia");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Cu�ntos puntos vale un tiro libre en baloncesto?", "1", "2",
				"3", "Depende");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Qu� tipo de competici�n es el Giro de Italia?",
				"Una carrera ciclista", "Una competici�n de vela",
				"Una marat�n", "Una carrera de F�rmula 1");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Cu�nto dura un partido de f�tbol?", "90 minutos",
				"75 minutos", "80 minutos", "85 minutos");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Qu� equipos juegan el derbi de Andaluc�a?",
				"Betis y Sevilla", "Sevilla y M�laga", "M�laga y Granada",
				"M�laga y Betis");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Cu�l de estos pilotos no pertenece a la F�rmula 1?",
				"Marc M�rquez", "Fernando Alonso", "Sebastian Vettel",
				"Lewis Hamilton");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�C�mo se llama a la cantera del FC Barcelona?", "La Mas�a",
				"El Chalet", "La F�brica", "La Depuradora");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Qu� selecci�n de f�tbol gan� el mundial del a�o 2002?",
				"Brasil", "Alemania", "Italia", "Francia");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�D�nde se invent� el tenis de mesa?", "Inglaterra", "China",
				"Jap�n", "Korea del Sur");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Qu� pa�s gan� el Mundial de Balonmano en 2013?", "Espa�a",
				"Serbia", "Croacia", "Francia");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Qui�n era el n�mero 1 de tenis en 2008?", "Rafael Nadal",
				"Roger Federer", "Andy Murray", "Novak Djokovic");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Cu�l es el equipo de f�tbol m�s antiguo de Espa�a?",
				"Recreativo de Huelva", "Real Madrid", "FC Barcelona",
				"Athletic Club de Bilbao");
		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"�Cu�ntas veces ha sido Fernando Alonso campe�n del mundo de F�rmula 1 hasta 2017?",
				"2", "3", "Ninguna", "1");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�C�mo se llama la liga espa�ola de balonmano?", "ASOBAL",
				"Liga de Balonmano Profesional", "Liga de Balonmano de Espa�a",
				"Abobal");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Cu�ntos cuadrados tiene un tablero de ajedrez?", "64", "81",
				"63", "75");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Cu�l era el apodo de Emilio Butrague�o?", "El Buitre",
				"El Halc�n", "El Pajarraco", "El �guila");
		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"�Qu� peso est� entre el peso gallo y el peso ligero en el boxeo?",
				"Peso pluma", "Peso mosca", "Peso ideal", "Sobrepeso");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Cu�ntos anillos de la NBA gan� Michael Jordan?", "6", "5",
				"4", "7");
		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"�Qui�n marc� el gol que le di� a Espa�a su primer Mundial de f�tbol?",
				"Andr�s Iniesta", "Ra�l", "David Villa", "Fernando Torres");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�Qu� deporte practicas si juegas en la NFL?",
				"F�tbol americano", "Rugby", "Hockey sobre hielo", "Golf");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�A qu� deporte pertenece el torneo 6 Naciones?", "Rugby",
				"F�tbol", "Baloncesto", "Balonmano");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"�C�mo se llama el palo utilizado en hockey?", "Stick",
				"Stack", "Bate", "Vara");
		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"�A cu�ntos metros de la porter�a est� el punto de penalti en el f�tbol?",
				"11", "15", "10", "7");

		insertarPregunta(db, BBDD.TABLA_LOG,
				"Completa la frase: _____ es a JOS� como _____ es a Francisco",
				"Pepe y Paco", "Pepe y To�o", "Pepe y Panto", "Toni y Paco");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"Completa la serie: 6, 1, 8, 3, 10...", "5", "12", "7", "4");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Cada uno de tres hermanos tiene una hermana �cu�ntos son entre todos?",
				"4", "6", "3", "9");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"�Cu�ntas veces al d�a las manecillas del reloj forman una l�nea recta?",
				"44", "12", "55", "34");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Algunos meses tienen 30 d�as, otros 31, pero �cu�ntos tienen 28 d�as?",
				"Todos", "Ninguno", "1", "10");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"�Cu�ntas veces puedes restar 2 a 100?", "50", "40", "100",
				"25");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Si el hijo de John es el padre de mi hijo, �qu� parentesco tengo yo con John?",
				"Soy su hijo", "Soy su abuelo", "Yo soy John",
				"No somos parientes");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Una madre tiene 40 a�os y su hijo 10. �Cu�ntos a�os han de transcurrir para que la edad de la madre sea el triple de la edad del hijo?",
				"5", "10", "3", "6");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"Dos n�meros pares consecutivos suman 66, �cu�l es el mayor?",
				"34", "30", "22", "28");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Si participo en una marat�n y adelanto al segundo, �en qu� posici�n llego?",
				"Segundo", "Primero", "Tercero", "Cuarto");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Pablo es mayor que Luis; Alba tiene la misma edad que Carmen, la cual es mayor que Pablo. �Qui�n es el menor de los cuatro?",
				"Luis", "Pablo", "Carmen", "Alba");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Si Juan es hermano de Mar�a y Luis es t�o de Juan �Qu� es Mar�a con respecto a Luis?",
				"Sobrina", "Hija", "Hermana", "Madre");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"�Cu�ntos animales de cada sexo meti� Mois�s en el arca?",
				"Ninguno", "1", "2", "3");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"�Qu� pas� ayer en Zaragoza de seis a siete?", "Una hora",
				"Nada", "Toc� un premio", "Hubo un accidente");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"�Tienen 4 de Julio en Inglaterra?", "S�", "Depende",
				"No se sabe", "No");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"En una pecera hay 5 peces, 2 se mueren y 3 se ahogan, �cu�ntos quedan dentro de la pecera?",
				"5", "2", "3", "Ninguno");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"�Cu�l es el n�mero que si lo pones al rev�s vale menos?", "9",
				"6", "2", "3");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"En una hilera de cuatro casas, los L�pez viven al lado de los Fern�ndez pero no al lado de los P�rez.Si los P�rez no viven al lado de los Garc�a, �qui�nes son los vecinos inmediatos de los Garc�a?",
				"Los L�pez", "Los Fern�ndez", "Los P�rez",
				"Se necesitan m�s datos para averiguarlo");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"�Qu� te pertenece a ti y sin embargo los dem�s lo usan m�s que t�?",
				"Tu nombre", "Tu ropa", "Tu PS4", "Tu tiempo");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"�Cu�ntas veces se encuentra la letra A contando de 0 a 100?",
				"0", "1", "50", "25");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"�Cu�ntas postales de veinte c�ntimos hay en una docena?",
				"12", "4", "20", "10");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"Completa la serie: 7, 21, 36, 52...", "69", "65", "7", "14");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Un granjero tiene 17 ovejas y todas mueren menos 9. �Cu�ntas ovejas quedan?",
				"9", "17", "8", "1");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"Si hay 7 manzanas y te llevas 4, �cu�ntas tienes?", "4", "3",
				"5", "0");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"�Cu�ntos meses tienen 29 d�as cada 4 a�os?", "Todos", "1",
				"Ninguno", "4");
	}
}
