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
		Assert.assertEquals("No es la fecha esperada",fechaIso.getTime(), nueva.getFecha());
	}

	@Test
	public void stringADateIso_ConvierteStringErroneoAIso() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateIso("2019/1/aa");
		Assert.assertNull("No es un formato compatible", nueva.getFecha());
	}

	@Test
	public void stringADateLatino_ConvierteStringALatino() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateLatino("1/02/2019");
		Calendar fechaLatino = Calendar.getInstance();
		fechaLatino.set(2019, 02, 01);
		Assert.assertEquals("No es la fecha esperada",fechaLatino.getTime(), nueva.getFecha());
	}

	@Test
	public void stringADateLatino_ConvierteStringErroneoALatino() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateLatino("aa/02/2019");
		Assert.assertNull("No es un formato compatible", nueva.getFecha());
	}

	@Test
	public void stringADateNorteamericano_ConvierteStringANorteamericano() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateNorteamericano("12/31/2019");
		Calendar fechaNorteamericano = Calendar.getInstance();
		fechaNorteamericano.set(2019, 12, 31);
		Assert.assertEquals("No es la fecha esperada",fechaNorteamericano.getTime(), nueva.getFecha());
	}

	@Test
	public void stringADateNorteamericano_ConvierteStringErroneoANorteamericano() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateNorteamericano("12/31/2019");
		Assert.assertNull("No es un formato compatible", nueva.getFecha());
	}

	@Test
	public void stringADateFlexible_ConvierteStringAIso() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateFlexible("2019/12/10");
		Assert.assertNull("No es un formato compatible", nueva.getFecha());
	}

	@Test
	public void stringADateFlexible_ConvierteStringALatino() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateFlexible("1/02/2019");
		Assert.assertNull("No es un formato compatible", nueva.getFecha());
	}

	@Test
	public void stringADateFlexible_ConvierteStringErroneoAIso() throws ParseException {
		Fecha nueva = new Fecha();
		nueva.stringADateIso("01/a2/2019");
		Assert.assertNull("No es un formato compatible", nueva.getFecha());
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
