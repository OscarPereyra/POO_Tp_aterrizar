package test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import modelo.Fecha;

public class FechaTest {
	@Test
	public void stringADateIso_ConvierteStringAIso() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateIso("2019/12/10");
		Calendar fechaIso = Calendar.getInstance();
		fechaIso.set(2019, 12, 10);
		Assert.assertEquals(fechaIso.getTime(), nueva.fecha);
	}

	@Test
	public void stringADateIso_ConvierteStringErroneoAIso() throws ParseException {
		Fecha nueva = new Fecha();
		Assert.assertNull("No es un formato compatible", nueva.stringADateIso("2019/1/aa"));
	}

	@Test
	public void stringADateLatino_ConvierteStringALatino() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateLatino("1/02/2019");
		Calendar fechaLatino = Calendar.getInstance();
		fechaLatino.set(2019, 02, 01);
		Assert.assertEquals(fechaLatino.getTime(), nueva.fecha);
	}

	@Test
	public void stringADateLatino_ConvierteStringErroneoALatino() throws ParseException {
		Fecha nueva = new Fecha();
		Assert.assertNull("No es un formato compatible", nueva.stringADateLatino("2019/1/aa"));
	}

	@Test
	public void stringADateNorteamericano_ConvierteStringANorteamericano() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateNorteamericano("12/31/2019");
		Calendar fechaNorteamericano = Calendar.getInstance();
		fechaNorteamericano.set(2019, 12, 31);
		Assert.assertEquals(fechaNorteamericano.getTime(), nueva.fecha);
	}

	@Test
	public void stringADateNorteamericano_ConvierteStringErroneoANorteamericano() throws ParseException {
		Fecha nueva = new Fecha();
		Assert.assertNull("No es un formato compatible", nueva.stringADateNorteamericano("aa/02/2019"));
	}

	@Test
	public void stringADateFlexible_ConvierteStringAIso() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateIso("2019/12/01");
	}

	@Test
	public void stringADateFlexible_ConvierteStringALatino() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateIso("01/12/2019");
	}

	@Test
	public void stringADateFlexible_ConvierteStringANorteamericano() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateIso("31/11/2019");
	}

	@Test
	public void stringADateFlexible_ConvierteStringErroneoAIso() throws ParseException {
		Fecha nueva = new Fecha();
		Assert.assertNull("No es un formato compatible", nueva.stringADateIso("01/a2/2019"));
	}

	@Test
	public void stringADateFlexible_ConvierteStringErroneoALatino() throws ParseException {
		Fecha nueva = new Fecha();
		Assert.assertNull("No es un formato compatible", nueva.stringADateIso("01/a2/2019"));
	}

	@Test
	public void stringADateFlexible_ConvierteStringErroneoANorteamericano() throws ParseException {
		Fecha nueva = new Fecha();
		Assert.assertNull("No es un formato compatible", nueva.stringADateIso("31/a1/2019"));
	}

	@Test
	public void fechaAEsAnteriorAFechaB_1DeEnero2019EsAnteriorA1DeFebrero2019() throws ParseException {
		Fecha nueva = new Fecha();
		Date fechaA = nueva.stringADateLatino("01/01/2019");
		Date fechaB = nueva.stringADateLatino("01/02/2019");
		Assert.assertTrue(nueva.fechaAEsAnteriorAFechaB(fechaA, fechaB));
	}

	@Test
	public void fechaAEsAnteriorAFechaB_1DeFebrero2019NoEsAnteriorA1DeEnero2019() throws ParseException {
		Fecha nueva = new Fecha();
		Date fechaA = nueva.stringADateLatino("01/02/2019");
		Date fechaB = nueva.stringADateLatino("01/01/2019");
		Assert.assertFalse(nueva.fechaAEsAnteriorAFechaB(fechaA, fechaB));
	}

	@Test
	public void diasEntreFechas_Entre1DeEnero2019Y4DeEnero2019Hay3Dias() throws ParseException {
		Fecha nueva = new Fecha();
		Date fechaA = nueva.stringADateLatino("01/01/2019");
		Date fechaB = nueva.stringADateLatino("04/01/2019");
		Assert.assertEquals(3, nueva.diasEntreFechas(fechaA, fechaB));
	}
}
