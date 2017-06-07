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
				"¿Cómo se conoce a los habitantes de Málaga?", "Boquerones",
				"Jureles", "Sardinas", "Calamares");
		insertarPregunta(
				db,
				BBDD.TABLA_GEO,
				"¿Cuál de los siguientes países considera a la vaca como un animal sagrado?",
				"India", "Argentina", "Arabia Saudí", "China");
		insertarPregunta(
				db,
				BBDD.TABLA_GEO,
				"¿Cuál de los siguientes países NO tiene una bandera de color azul, rojo y amarillo?",
				"Perú", "Colombia", "Ecuador", "Venezuela");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Qué país es considerado el país de los mil lagos?",
				"Finlandia", "Suecia", "Islandia", "Noruega");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Cuál es la capital del estado de Arkansas?", "Little Rock",
				"Kansas", "Hot Springs", "Washington");
		insertarPregunta(db, BBDD.TABLA_GEO, "¿Cuál es la capital de Suiza?",
				"Berna", "Zúrich", "Ginebra", "Basilea");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Cuál de las siguientes islas está más al sur?", "Malta",
				"Sicilia", "Córcega", "Cerdeña");
		insertarPregunta(
				db,
				BBDD.TABLA_GEO,
				"¿Qué accidente geográfico se define como un conjunto de islas, islotes y diminutas masas de tierra cercanas entre sí?",
				"Archipiélago", "Islotes", "Península", "Continente");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿En qué mar desemboca el río Segura?", "Mar Mediterráneo",
				"Mar Cantábrico", "Océano Atlántico", "Ninguna es correcta");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿En qué continente está la India?", "Asia", "Oceanía",
				"Europa", "América");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Cuál es la capital de Alemania?", "Berlín", "Munich",
				"Dublín", "Frankfurt");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Cuál de estos países no está en una isla?", "Ghana",
				"Madagascar", "Japón", "Jamaica");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Cuál de las grandes montañas ha sido escalada más veces?",
				"El Everest", "El K2", "El Annapurna I", "El Annapurna II");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿De qué colores es la bandera de Bélgica?",
				"Rojo, amarillo y negro", "Rojo y negro",
				"Negro, rojo y naranja", "Negro y amarillo");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Dónde se celebra el Oktoberfest?", "Alemania", "Ucrania",
				"Rusia", "Reino Unido");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Cuándo es verano en el hemisferio sur?",
				"De Diciembre a Marzo", "De Marzo a Junio",
				"De Junio a Septiembre", "De Noviembre a Febrero");
		insertarPregunta(db, BBDD.TABLA_GEO, "¿Cuál es la capital de Japón?",
				"Tokyo", "Kyoto", "Pekín", "Hong Kong");
		insertarPregunta(db, BBDD.TABLA_GEO, "¿De qúe tiene forma Italia?",
				"Bota", "Gorro", "Nube", "Submarino");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Qué dos ciudades de España son famosas por sus carnavales?",
				"Cádiz y Santa Cruz de Tenerife", "Cádiz y Sevilla",
				"Málaga y Cádiz", "Las Palmas de Gran Canaria y Cádiz");
		insertarPregunta(
				db,
				BBDD.TABLA_GEO,
				"¿Con cuál de las siguientes provincias no limita la Comunidad de Madrid?",
				"Salamanca", "Segovia", "Toledo", "Ávila");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿En qué ciudad está situado El Barrio del Albaicín?",
				"Granada", "Córdoba", "Sevilla", "Jaén");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Qué países forman parte de la Península Ibérica?",
				"España, Portugal y Andorra", "España y Portugal",
				"España, Portugal y Francia", "España, Portugal e Italia");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿De dónde es tradicional la paella?", "Comunidad Valenciana",
				"País Vasco", "Andalucía", "Catalunña");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Cuántas comunidades autónomas hay en España?", "17", "15",
				"16", "18");
		insertarPregunta(db, BBDD.TABLA_GEO,
				"¿Cuál es el río más caudaloso del mundo?", "El Amazonas",
				"El Nilo", "El Ganges", "El Danubio");

		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"¿Cuántas finales del mundo ha disputado la Selección Argentina de Fútbol?",
				"5", "6", "4", "7");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Qué estilo de natación es el más rápido?", "Crol", "Espalda",
				"Mariposa", "Son todos igual de rápidos");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿En qué país se inventó el voleibol?", "Estados Unidos",
				"Reino Unido", "Francia", "Rusia");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cuántos puntos vale un tiro libre en baloncesto?", "1", "2",
				"3", "Depende");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Qué tipo de competición es el Giro de Italia?",
				"Una carrera ciclista", "Una competición de vela",
				"Una maratón", "Una carrera de Fórmula 1");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cuánto dura un partido de fútbol?", "90 minutos",
				"75 minutos", "80 minutos", "85 minutos");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Qué equipos juegan el derbi de Andalucía?",
				"Betis y Sevilla", "Sevilla y Málaga", "Málaga y Granada",
				"Málaga y Betis");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cuál de estos pilotos no pertenece a la Fórmula 1?",
				"Marc Márquez", "Fernando Alonso", "Sebastian Vettel",
				"Lewis Hamilton");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cómo se llama a la cantera del FC Barcelona?", "La Masía",
				"El Chalet", "La Fábrica", "La Depuradora");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Qué selección de fútbol ganó el mundial del año 2002?",
				"Brasil", "Alemania", "Italia", "Francia");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Dónde se inventó el tenis de mesa?", "Inglaterra", "China",
				"Japón", "Korea del Sur");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Qué país ganó el Mundial de Balonmano en 2013?", "España",
				"Serbia", "Croacia", "Francia");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Quién era el número 1 de tenis en 2008?", "Rafael Nadal",
				"Roger Federer", "Andy Murray", "Novak Djokovic");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cuál es el equipo de fútbol más antiguo de España?",
				"Recreativo de Huelva", "Real Madrid", "FC Barcelona",
				"Athletic Club de Bilbao");
		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"¿Cuántas veces ha sido Fernando Alonso campeón del mundo de Fórmula 1 hasta 2017?",
				"2", "3", "Ninguna", "1");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cómo se llama la liga española de balonmano?", "ASOBAL",
				"Liga de Balonmano Profesional", "Liga de Balonmano de España",
				"Abobal");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cuántos cuadrados tiene un tablero de ajedrez?", "64", "81",
				"63", "75");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cuál era el apodo de Emilio Butragueño?", "El Buitre",
				"El Halcón", "El Pajarraco", "El Águila");
		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"¿Qué peso está entre el peso gallo y el peso ligero en el boxeo?",
				"Peso pluma", "Peso mosca", "Peso ideal", "Sobrepeso");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cuántos anillos de la NBA ganó Michael Jordan?", "6", "5",
				"4", "7");
		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"¿Quién marcó el gol que le dió a España su primer Mundial de fútbol?",
				"Andrés Iniesta", "Raúl", "David Villa", "Fernando Torres");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Qué deporte practicas si juegas en la NFL?",
				"Fútbol americano", "Rugby", "Hockey sobre hielo", "Golf");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿A qué deporte pertenece el torneo 6 Naciones?", "Rugby",
				"Fútbol", "Baloncesto", "Balonmano");
		insertarPregunta(db, BBDD.TABLA_DEP,
				"¿Cómo se llama el palo utilizado en hockey?", "Stick",
				"Stack", "Bate", "Vara");
		insertarPregunta(
				db,
				BBDD.TABLA_DEP,
				"¿A cuántos metros de la portería está el punto de penalti en el fútbol?",
				"11", "15", "10", "7");

		insertarPregunta(db, BBDD.TABLA_LOG,
				"Completa la frase: _____ es a JOSÉ como _____ es a Francisco",
				"Pepe y Paco", "Pepe y Toño", "Pepe y Panto", "Toni y Paco");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"Completa la serie: 6, 1, 8, 3, 10...", "5", "12", "7", "4");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Cada uno de tres hermanos tiene una hermana ¿cuántos son entre todos?",
				"4", "6", "3", "9");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"¿Cuántas veces al día las manecillas del reloj forman una línea recta?",
				"44", "12", "55", "34");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Algunos meses tienen 30 días, otros 31, pero ¿cuántos tienen 28 días?",
				"Todos", "Ninguno", "1", "10");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"¿Cuántas veces puedes restar 2 a 100?", "50", "40", "100",
				"25");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Si el hijo de John es el padre de mi hijo, ¿qué parentesco tengo yo con John?",
				"Soy su hijo", "Soy su abuelo", "Yo soy John",
				"No somos parientes");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Una madre tiene 40 años y su hijo 10. ¿Cuántos años han de transcurrir para que la edad de la madre sea el triple de la edad del hijo?",
				"5", "10", "3", "6");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"Dos números pares consecutivos suman 66, ¿cuál es el mayor?",
				"34", "30", "22", "28");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Si participo en una maratón y adelanto al segundo, ¿en qué posición llego?",
				"Segundo", "Primero", "Tercero", "Cuarto");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Pablo es mayor que Luis; Alba tiene la misma edad que Carmen, la cual es mayor que Pablo. ¿Quién es el menor de los cuatro?",
				"Luis", "Pablo", "Carmen", "Alba");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Si Juan es hermano de María y Luis es tío de Juan ¿Qué es María con respecto a Luis?",
				"Sobrina", "Hija", "Hermana", "Madre");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"¿Cuántos animales de cada sexo metió Moisés en el arca?",
				"Ninguno", "1", "2", "3");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"¿Qué pasó ayer en Zaragoza de seis a siete?", "Una hora",
				"Nada", "Tocó un premio", "Hubo un accidente");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"¿Tienen 4 de Julio en Inglaterra?", "Sí", "Depende",
				"No se sabe", "No");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"En una pecera hay 5 peces, 2 se mueren y 3 se ahogan, ¿cuántos quedan dentro de la pecera?",
				"5", "2", "3", "Ninguno");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"¿Cuál es el número que si lo pones al revés vale menos?", "9",
				"6", "2", "3");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"En una hilera de cuatro casas, los López viven al lado de los Fernández pero no al lado de los Pérez.Si los Pérez no viven al lado de los García, ¿quiénes son los vecinos inmediatos de los García?",
				"Los López", "Los Fernández", "Los Pérez",
				"Se necesitan más datos para averiguarlo");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"¿Qué te pertenece a ti y sin embargo los demás lo usan más que tú?",
				"Tu nombre", "Tu ropa", "Tu PS4", "Tu tiempo");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"¿Cuántas veces se encuentra la letra A contando de 0 a 100?",
				"0", "1", "50", "25");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"¿Cuántas postales de veinte céntimos hay en una docena?",
				"12", "4", "20", "10");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"Completa la serie: 7, 21, 36, 52...", "69", "65", "7", "14");
		insertarPregunta(
				db,
				BBDD.TABLA_LOG,
				"Un granjero tiene 17 ovejas y todas mueren menos 9. ¿Cuántas ovejas quedan?",
				"9", "17", "8", "1");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"Si hay 7 manzanas y te llevas 4, ¿cuántas tienes?", "4", "3",
				"5", "0");
		insertarPregunta(db, BBDD.TABLA_LOG,
				"¿Cuántos meses tienen 29 días cada 4 años?", "Todos", "1",
				"Ninguno", "4");
	}
}
