package modelo;

import java.text.SimpleDateFormat;  
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;
import java.lang.Math;

public class Fecha {
	private SimpleDateFormat formatoIso8601 = new SimpleDateFormat("yyyy/MM/dd");  
	private SimpleDateFormat formatoLatino = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatoNorteamericano = new SimpleDateFormat("MM/dd/yyyy");
	
	private String regexpIso = "^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$";
	private String regexpNorte = "^(?:0?[1-9]|1[1-2])([\\-/.])(3[01]|[12][0-9]|0?[1-9])\\1\\d{4}$";
	private String regexpLat = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$";
    public Date fecha = null;
    
    public Date stringADateIso(String fechaIso) throws ParseException {
    	try {
    		fecha = formatoIso8601.parse(fechaIso);
    	}
    	catch(ParseException ex) {
			System.out.println("No es un formato compatible");
    	}
    	return fecha;
    }
    public Date stringADateLatino(String fechaLatino) throws ParseException {
    	try {
    	fecha = formatoLatino.parse(fechaLatino);
    	}
		catch(ParseException ex) {
			System.out.println("No es un formato compatible");
		}
    	return fecha;
    }
    public Date stringADateNorteamericano(String fechaNorteamericano) throws ParseException {
    	try {
    	fecha = formatoNorteamericano.parse(fechaNorteamericano);
    	}
		catch(ParseException ex) {
			System.out.println("No es un formato compatible");
		}
    	return fecha;
    }
    public Date stringADateFlexible(String fechaFlexible) throws ParseException {
    	if(Pattern.matches(regexpIso, fechaFlexible)) {
    		fecha = stringADateIso(fechaFlexible);
    	}else if(Pattern.matches(regexpLat, fechaFlexible)) {
    		fecha = stringADateLatino(fechaFlexible);
    	}else if(Pattern.matches(regexpNorte, fechaFlexible)) {
    		fecha = stringADateNorteamericano(fechaFlexible);
    	}
    	return fecha;
    }
    public boolean fechaAEsAnteriorAFechaB(Date fechaA, Date fechaB) {
    	return fechaA.before(fechaB);
    }
    public int diasEntreFechas(Date fecha1,Date fecha2) {
    	return Math.abs((int) ((fecha1.getTime()-fecha2.getTime())/86400000));
    }
}