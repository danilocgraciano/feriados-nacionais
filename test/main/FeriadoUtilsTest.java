package main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class FeriadoUtilsTest {

	@Test
	public void deceCalularFeriadoPascoa2016() {
		var date = FeriadoUtils.getFeriadoPascoa(2016);
		assertTrue(date.getYear() == 2016);
		assertTrue(date.getMonth().getValue() == 3);
		assertTrue(date.getDayOfMonth() == 27);
	}

	@Test
	public void deceCalularFeriadoPascoa2017() {
		var date = FeriadoUtils.getFeriadoPascoa(2017);
		assertTrue(date.getYear() == 2017);
		assertTrue(date.getMonth().getValue() == 4);
		assertTrue(date.getDayOfMonth() == 16);
	}

	@Test
	public void deceCalularFeriadoPascoa2018() {
		var date = FeriadoUtils.getFeriadoPascoa(2018);
		assertTrue(date.getYear() == 2018);
		assertTrue(date.getMonth().getValue() == 4);
		assertTrue(date.getDayOfMonth() == 1);
	}

	@Test
	public void deceCalularFeriadoPascoa2019() {
		var date = FeriadoUtils.getFeriadoPascoa(2019);
		assertTrue(date.getYear() == 2019);
		assertTrue(date.getMonth().getValue() == 4);
		assertTrue(date.getDayOfMonth() == 21);
	}

	@Test
	public void deceCalularFeriadoPascoa2020() {
		var date = FeriadoUtils.getFeriadoPascoa(2020);
		assertTrue(date.getYear() == 2020);
		assertTrue(date.getMonth().getValue() == 4);
		assertTrue(date.getDayOfMonth() == 12);
	}

	@Test
	public void deceCalularCorpusChristi2018() {
		var date = FeriadoUtils.getFeriadoCorpusChristi(2018);
		assertTrue(date.getYear() == 2018);
		assertTrue(date.getMonth().getValue() == 5);
		assertTrue(date.getDayOfMonth() == 31);
	}

	@Test
	public void deceCalularCorpusChristi2019() {
		var date = FeriadoUtils.getFeriadoCorpusChristi(2019);
		assertTrue(date.getYear() == 2019);
		assertTrue(date.getMonth().getValue() == 6);
		assertTrue(date.getDayOfMonth() == 20);
	}

	@Test
	public void deceCalularCorpusChristi2020() {
		var date = FeriadoUtils.getFeriadoCorpusChristi(2020);
		assertTrue(date.getYear() == 2020);
		assertTrue(date.getMonth().getValue() == 6);
		assertTrue(date.getDayOfMonth() == 11);
	}

	@Test
	public void deceCalularCarnaval2018() {
		var date = FeriadoUtils.getFeriadoCarnaval(2018);
		assertTrue(date.getYear() == 2018);
		assertTrue(date.getMonth().getValue() == 2);
		assertTrue(date.getDayOfMonth() == 13);
	}

	@Test
	public void deceCalularCarnaval2019() {
		var date = FeriadoUtils.getFeriadoCarnaval(2019);
		assertTrue(date.getYear() == 2019);
		assertTrue(date.getMonth().getValue() == 3);
		assertTrue(date.getDayOfMonth() == 5);
	}

	@Test
	public void deceCalularCarnaval2020() {
		var date = FeriadoUtils.getFeriadoCarnaval(2020);
		assertTrue(date.getYear() == 2020);
		assertTrue(date.getMonth().getValue() == 2);
		assertTrue(date.getDayOfMonth() == 25);
	}

	@Test
	public void deceCalularSextaFeiraSanta2018() {
		var date = FeriadoUtils.getFeriadoSextaFeiraSanta(2018);
		assertTrue(date.getYear() == 2018);
		assertTrue(date.getMonth().getValue() == 3);
		assertTrue(date.getDayOfMonth() == 30);
	}

	@Test
	public void deceCalularSextaFeiraSanta2019() {
		var date = FeriadoUtils.getFeriadoSextaFeiraSanta(2019);
		assertTrue(date.getYear() == 2019);
		assertTrue(date.getMonth().getValue() == 4);
		assertTrue(date.getDayOfMonth() == 19);
	}

	@Test
	public void deceCalularSextaFeiraSanta2020() {
		var date = FeriadoUtils.getFeriadoSextaFeiraSanta(2020);
		assertTrue(date.getYear() == 2020);
		assertTrue(date.getMonth().getValue() == 4);
		assertTrue(date.getDayOfMonth() == 10);
	}

	@Test
	public void deveValidarFeriado() {
		var date = LocalDate.of(2020, 12, 25);
		assertTrue(FeriadoUtils.isFeriado(date));
	}

	@Test
	public void deveInvalidarFeriado() {
		var date = LocalDate.of(2020, 12, 26);
		assertFalse(FeriadoUtils.isFeriado(date));
	}

}
