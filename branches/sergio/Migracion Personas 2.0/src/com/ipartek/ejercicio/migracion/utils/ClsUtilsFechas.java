package com.ipartek.ejercicio.migracion.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Clase de recopilación de funciones útiles para trabajar con fechas.
 * 
 * @author baskito
 * @version 20.11.2014
 */
public final class ClsUtilsFechas {

    	/**
    	 * Constructor vacío.
    	 */
	private ClsUtilsFechas() {
		// Utility classes should always be final and have an private
		// constructor
	}

	/**
	 * Formato utilizado para las fechas en sqlite.
	 */
	private static final SimpleDateFormat FORM_FECH_SQLITE = 
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	/**
	 * Convierte una fecha en formato sqlite a timestamp.
	 * 
	 * @param fecha Date fecha a convertir
	 * @return Timestap con la echa
	 */
	public static Timestamp sqlLiteDateToSql(final Date fecha) {
		final Timestamp timeStampDate = new Timestamp(fecha.getTime());
		return timeStampDate;
	}

	/**
	 * Convierte una fecha de string a date.
	 * @param fecha String fecha a convertir
	 * @return Date con la fecha
	 */
	public static Date sqlLiteSqlToDate(final String fecha) {
		try {
			// return new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(fecha);
			return FORM_FECH_SQLITE.parse(fecha);
		} catch (ParseException ex) {
			return null;
		}
	}

	/**
	 * Metodo usado para obtener la fecha actual.
	 * 
	 * @return Retorna un <b>STRING</b> con la fecha actual formato "dd-MM-yyyy"
	 */
	public static String getFechaActual() {
		final Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		return formateador.format(ahora);
	}

	/**
	 * Metodo usado para obtener la hora actual del sistema.
	 * @return Retorna un <b>STRING</b> con la hora actual formato "hh:mm:ss"
	 */
	public static String getHoraActual() {
		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
		return formateador.format(ahora);
	}

	/**
	 * Sumarle dias a una fecha determinada.
	 * @param fch La fecha para sumarle los dias
	 * @param dias Numero de dias a agregar
	 * @return La fecha agregando los dias
	 */ 
	public static java.sql.Date sumarFechasDias(final java.sql.Date fch, 
		final int dias) {
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(fch.getTime());
		cal.add(Calendar.DATE, dias);
		return new java.sql.Date(cal.getTimeInMillis());
	}

	/**
	* Restarle dias a una fecha determinada.
	* @param fch La fecha
	* @param dias Dias a restar
	* @return La fecha restando los dias
	*/
	public static synchronized java.sql.Date restarFechasDias(
			final Date fch, final int dias) {
		final Calendar cal = new GregorianCalendar();

		cal.setTimeInMillis(fch.getTime());
		cal.add(Calendar.DATE, -dias);

		return new java.sql.Date(cal.getTimeInMillis());
	}

	/**
	* Diferencias entre dos fechas.
	* @param fechaInicial La fecha de inicio
	* @param fechaFinal La fecha de fin
	* @return Retorna el numero de dias entre dos fechas
	*/
	public static synchronized int diferenciasDeFechas(final Date fechaInicial,
			final Date fechaFinal) {

		Date lFechaInicial = fechaInicial;
		Date lFechaFinal = fechaFinal;

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String fechaInicioString = df.format(lFechaInicial);
		try {
			lFechaInicial = df.parse(fechaInicioString);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		String fechaFinalString = df.format(lFechaFinal);
		try {
			lFechaFinal = df.parse(fechaFinalString);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		// long fechaInicialMs = lFechaInicial.getTime();
		// long fechaFinalMs = lFechaFinal.getTime();

		final long diferencia = lFechaInicial.getTime() - lFechaFinal.getTime();

		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

		return ((int) dias);
	}

	/**
	* Devuele un java.util.Date desde un String en formato dd-MM-yyyy.
	* @param fecha fecha a convertir a formato date
	* @return Retorna la fecha en formato Date
	*/
	public static synchronized Date deStringToDate(final String fecha) {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaEnviar = null;

		try {
			fechaEnviar = formatoDelTexto.parse(fecha);

		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		return fechaEnviar;
	}

	/**
	 * Calcula la diferencia entre dos horas.
	 * 
	 * @param fInicial fecha inicial
	 * @param fFinal fecha final
	 * @return timeLapse objeto con los datos de la diferencia
	 */
	public static timeLapse diferenciaHoras(final Date fInicial,
			final Date fFinal) {
		// Crear 2 instancias de Calendar
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		cal1.setTime(fInicial);
		cal2.setTime(fFinal);

		// conseguir la representacion de la fecha en milisegundos
		long milis1 = cal1.getTimeInMillis();
		long milis2 = cal2.getTimeInMillis();

		// calcular la diferencia en milisengundos
		long diff = milis2 - milis1;

		// calcular la diferencia en segundos
		long diffSeconds = diff / 1000;

		// calcular la diferencia en minutos
		long diffMinutes = diff / (60 * 1000);

		// calcular la diferencia en horas
		long diffHours = diff / (60 * 60 * 1000);

		// calcular la diferencia en dias
		long diffDays = diff / (24 * 60 * 60 * 1000);

		/*
		 * System.out.println("En milisegundos: " + diff + " milisegundos.");
		 * System.out.println("En segundos: " + diffSeconds + " segundos.");
		 * System.out.println("En minutos: " + diffMinutes + " minutos.");
		 * System.out.println("En horas: " + diffHours + " horas.");
		 * System.out.println("En dias: " + diffDays + " dias.");
		 */
		// Log.e("diferenciaHoras", "En milisegundos: " + diff +
		// " milisegundos.");
		// Log.e("diferenciaHoras", "En segundos: " + diffSeconds +
		// " segundos.");

		timeLapse tiempo = new timeLapse();
		tiempo.diffMilisegundos = diff;
		tiempo.diffSegundos = diffSeconds;
		tiempo.diffMinutos = diffMinutes;
		tiempo.diffHoras = diffHours;
		tiempo.diffDias = diffDays;

		return tiempo;
	}

	public static class timeLapse {
		// TODO un toString para convertir a fecha (date o calendar)

		/**
		 * keep numbers of diff milliseconds
		 */
		private Long diffMilisegundos;

		/**
		 * keep numbers of diff seconds
		 */
		private Long diffSegundos;

		/**
		 * keep numbers of diff minutes
		 */
		private Long diffMinutos;

		/**
		 * keep numbers of diff hours
		 */
		private Long diffHoras;

		/**
		 * keep numbers of diff days
		 */
		private Long diffDias;

		public Long getDiffMilisegundos() {
			return diffMilisegundos;
		}

		public void setDiffMilisegundos(final Long _diffMilisegundos) {
			this.diffMilisegundos = _diffMilisegundos;
		}

		public Long getDiffSegundos() {
			return diffSegundos;
		}

		public void setDiffSegundos(final Long _diffSegundos) {
			this.diffSegundos = _diffSegundos;
		}

		public Long getDiffMinutos() {
			return diffMinutos;
		}

		public void setDiffMinutos(final Long _diffMinutos) {
			this.diffMinutos = _diffMinutos;
		}

		public Long getDiffHoras() {
			return diffHoras;
		}

		public void setDiffHoras(final Long _diffHoras) {
			this.diffHoras = _diffHoras;
		}

		public Long getDiffDias() {
			return diffDias;
		}

		public void setDiffDias(final Long _diffDias) {
			this.diffDias = _diffDias;
		}

	}

	public static String milisegundosToTimeString(final Long milisegundos) {

		int seconds = (int) (milisegundos / 1000) % 60;
		int minutes = (int) ((milisegundos / (1000 * 60)) % 60);
		int hours = (int) ((milisegundos / (1000 * 60 * 60)) % 24);

		String sSeconds = String.valueOf(seconds).length() == 2 ? String
				.valueOf(seconds) : String.format("%02d", seconds);
				
		String sMinutes = String.valueOf(minutes).length() == 2 ? String
				.valueOf(minutes) : String.format("%02d", minutes);
				
		String sHours = String.valueOf(hours).length() == 2 ? String
				.valueOf(hours) : String.format("%02d", hours);

		return sHours + ":" + sMinutes + ":" + sSeconds;

	}

	public static Timestamp getCurrentTimestamp() {
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();
		// 2) get a java.util.Date from the calendar instance.
		// this date will represent the current instant, or "now".
		Date now = calendar.getTime();
		// 3) a java current time (now) instance
		Timestamp currentTimestamp = new Timestamp(now.getTime());

		return currentTimestamp;
	}

	public static Timestamp longToTimestamp(final Long timestamp) {
		return new Timestamp(timestamp);
	}

	public static Long timestampToLong(final Timestamp timestamp) {
		return timestamp.getTime();
	}

	/**
	 * Devuelve la fecha pasada dependiendo de la zona temporal.
	 * 
	 * @param strTimeZone
	 *            String con el time zone
	 * @param fecha
	 *            fecha a convertir
	 * @return Date 
	 */
	public static Date convertOtherTimeZone(final String strTimeZone, final Date fecha) {
		// creamos la instancia del calendario
		Calendar calendar = Calendar.getInstance();

		// Le añadimos la fecha
		calendar.setTime(fecha);

		// Obtenemos el actual time zone ?¿?¿?¿
		TimeZone fromTimeZone = calendar.getTimeZone();

		// Obtenemos el timeZoneDestino
		TimeZone toTimeZone = TimeZone.getTimeZone(strTimeZone);

		calendar.setTimeZone(fromTimeZone);
		calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
		if (fromTimeZone.inDaylightTime(calendar.getTime())) {
			calendar.add(Calendar.MILLISECOND, calendar.getTimeZone()
					.getDSTSavings() * -1);
		}

		calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
		if (toTimeZone.inDaylightTime(calendar.getTime())) {
			calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
		}

		return calendar.getTime();
	}

	/**
	 * Devuelve milisegundos en un string con formato Horas y Minutos.
	 * 
	 * @param milliseconds
	 *            milisegundos a convertir
	 * @return String con formato horas y minutos
	 */
	public static String millisecondsToHourMinute(final int milliseconds) {
		// TODO: Crear clase de timezone
		String formateado = String.format(
				"%02d:%02d",
				TimeUnit.MILLISECONDS.toHours(milliseconds),
				TimeUnit.MILLISECONDS.toMinutes(milliseconds)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
								.toHours(milliseconds)));
		return formateado;
	}
	
	

	/**
	 * Get a hashMap with Key string TimeZoneId 
	 * and String with offset and TimeZone name value.
	 * 
	 * @return hashMap
	 */
	public static synchronized HashMap<String, String> getMapTZIdTZString() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		StringBuffer texto = null;

		for (TimeZone tim : ClsUtilsFechas.getListTimeZones()) {
			texto = new StringBuffer();
			// Preparamos el texto
			texto.append("(");
			texto.append(ClsUtilsFechas.formatTimeZoneOffset(tim));
			texto.append(")");
			texto.append(" - ").append(tim.getID()).append(" - ");
			texto.append(tim.getDisplayName());
			// añadimos los datos al mapa
			map.put(tim.getID(), texto.toString());
			// reiniciamos el texto
			texto = null;
		}

		return map;
	}

	/** 
	 * Filter for Timezones.	 
	 */
	private static final String TZ_ID_PREF 
	= "^(Africa|America|Asia|Atlantic|Australia|Europe|Indian|Pacific)/.*";

	/**
	 * Return a collection with timeZones. Ordena primero por el offset y luego
	 * por nombre.
	 * 
	 * (filtradas por
	 * "^(Africa|America|Asia|Atlantic|Australia|Europe|Indian|Pacific)/.*"
	 * 
	 * @see http
	 *      ://blog.lunatech.com/2008/12/20/getting-list-time-zones-java-and-
	 *      seam
	 * @return List with the TimeZones filters
	 */
	public static List<TimeZone> getListTimeZones() {

		String[] timeZoneIds = TimeZone.getAvailableIDs();
		List<TimeZone> timeZones = new ArrayList<TimeZone>();

		// Realizamos el filtro
		timeZones = new ArrayList<TimeZone>();
		timeZoneIds = TimeZone.getAvailableIDs();
		for (final String id : timeZoneIds) {
			if (id.matches(TZ_ID_PREF)) {
				timeZones.add(TimeZone.getTimeZone(id));
			}
		}

		// Ordenamos
		Collections.sort(timeZones, new Comparator<TimeZone>() {
			public int compare(final TimeZone tza, final TimeZone tzb) {
				// return a.getID().compareTo(b.getID());
				int res = Long.compare(
						tza.getOffset(System.currentTimeMillis()),
						tzb.getOffset(System.currentTimeMillis()));

				if (res == 0) {
					return tza.getID().compareTo(tzb.getID());
				} else {
					return res;
				}

			}
		});

		return timeZones;
	}

	/**
	 * Devuelve un string con formato (+00:00) o (-00:00) dependiendo del time.
	 * zone pasado
	 * 
	 * @param tim
	 *            TimeZone
	 * @return String con formato (+00:00) o (-00:00)
	 */
	public static String formatTimeZoneOffset(final TimeZone tim) {
	    // TODO: Crear clase de timezone
	    boolean negative = false;
	    int milliOffSet = tim.getOffset(System.currentTimeMillis());

	    // lo ponemos positivo pero marcamos que es negativo
	    if (milliOffSet < 0) {
		milliOffSet *= -1;
		negative = true;
	    }

	    // lo pasamos a string
	    String strMilliOffSet = millisecondsToHourMinute(milliOffSet);

	    // le añadimos los 0 que le falten
	    strMilliOffSet = ClsUtilsTextos.padLeft(strMilliOffSet, 5, "0");

	    // ponemos el signo
	    if (!negative) {
		strMilliOffSet = "+".concat(strMilliOffSet);
	    } else {
		strMilliOffSet = "-".concat(strMilliOffSet);
	    }

	    return strMilliOffSet;
	}

}
