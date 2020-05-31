package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class FeriadoUtils {

	public static boolean isFeriado(LocalDate dia) {
		return getFeriados(dia.getYear()).stream().filter(d -> d.equals(dia)).count() > 0;
	}

	public static ArrayList<LocalDate> getFeriados(int year) {

		var feriados = new ArrayList<LocalDate>();
		feriados.addAll(getFeriadosFixos(year));
		feriados.add(getFeriadoPascoa(year));
		feriados.add(getFeriadoCorpusChristi(year));
		feriados.add(getFeriadoCarnaval(year));
		feriados.add(getFeriadoSextaFeiraSanta(year));
		return feriados;

	}

	public static ArrayList<LocalDate> getFeriadosFixos(int year) {

		var feriados = new ArrayList<LocalDate>();
		feriados.add(LocalDate.of(year, 1, 1));
		feriados.add(LocalDate.of(year, 4, 21));
		feriados.add(LocalDate.of(year, 5, 1));
		feriados.add(LocalDate.of(year, 9, 7));
		feriados.add(LocalDate.of(year, 10, 12));
		feriados.add(LocalDate.of(year, 11, 2));
		feriados.add(LocalDate.of(year, 11, 15));
		feriados.add(LocalDate.of(year, 12, 25));

		return feriados;

	}

	/**
	 * 
	 * Este algoritmo é de J.-M. Oudin (1940) e impresso no Explanatory Supplement
	 * to the Astronomical Almanac, ed. P.K. Seidelmann (1992).
	 */
	public static LocalDate getFeriadoPascoa(int year) {
		int c = year / 100;
		int n = year - (19 * (year / 19));
		int k = (c - 17) / 25;
		int i = c - c / 4 - ((c - k) / 3) + (19 * n) + 15;

		i = i - (30 * (i / 30));
		i = i - ((i / 28) * (1 - (i / 28)) * (29 / (i + 1)) * ((21 - n) / 11));

		int j = year + year / 4 + i + 2 - c + c / 4;
		j = j - (7 * (j / 7));

		int l = i - j;

		int mes = 3 + ((l + 40) / 44);
		int dia = l + 28 - (31 * (mes / 4));

		return LocalDate.of(year, mes, dia);
	}

	public static LocalDate getFeriadoCorpusChristi(int year) {
		var pascoa = getFeriadoPascoa(year);
		return pascoa.plusDays(60);
	}

	public static LocalDate getFeriadoCarnaval(int year) {
		var pascoa = getFeriadoPascoa(year);
		return pascoa.minusDays(47);
	}

	public static LocalDate getFeriadoSextaFeiraSanta(int year) {
		var pascoa = getFeriadoPascoa(year);
		return pascoa.minusDays(2);
	}

}
