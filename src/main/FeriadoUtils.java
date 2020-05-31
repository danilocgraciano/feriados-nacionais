package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class FeriadoUtils {

	public static boolean isFeriado(LocalDate dia) {
		return getFeriados(dia.getYear()).stream().filter(d -> d.equals(dia)).count() > 0;
	}

	public static ArrayList<LocalDate> getFeriados(int ano) {

		var feriados = new ArrayList<LocalDate>();
		feriados.addAll(getFeriadosFixos(ano));
		feriados.add(getFeriadoPascoa(ano));
		feriados.add(getFeriadoCorpusChristi(ano));
		feriados.add(getFeriadoCarnaval(ano));
		feriados.add(getFeriadoSextaFeiraSanta(ano));
		return feriados;

	}

	public static ArrayList<LocalDate> getFeriadosFixos(int ano) {

		var feriados = new ArrayList<LocalDate>();
		feriados.add(LocalDate.of(ano, 1, 1));
		feriados.add(LocalDate.of(ano, 4, 21));
		feriados.add(LocalDate.of(ano, 5, 1));
		feriados.add(LocalDate.of(ano, 9, 7));
		feriados.add(LocalDate.of(ano, 10, 12));
		feriados.add(LocalDate.of(ano, 11, 2));
		feriados.add(LocalDate.of(ano, 11, 15));
		feriados.add(LocalDate.of(ano, 12, 25));

		return feriados;

	}

	/**
	 * 
	 * Este algoritmo é de J.-M. Oudin (1940) e impresso no Explanatory Supplement
	 * to the Astronomical Almanac, ed. P.K. Seidelmann (1992).
	 */
	public static LocalDate getFeriadoPascoa(int ano) {
		int c = ano / 100;
		int n = ano - (19 * (ano / 19));
		int k = (c - 17) / 25;
		int i = c - c / 4 - ((c - k) / 3) + (19 * n) + 15;

		i = i - (30 * (i / 30));
		i = i - ((i / 28) * (1 - (i / 28)) * (29 / (i + 1)) * ((21 - n) / 11));

		int j = ano + ano / 4 + i + 2 - c + c / 4;
		j = j - (7 * (j / 7));

		int l = i - j;

		int mes = 3 + ((l + 40) / 44);
		int dia = l + 28 - (31 * (mes / 4));

		return LocalDate.of(ano, mes, dia);
	}

	public static LocalDate getFeriadoCorpusChristi(int ano) {
		var pascoa = getFeriadoPascoa(ano);
		return pascoa.plusDays(60);
	}

	public static LocalDate getFeriadoCarnaval(int ano) {
		var pascoa = getFeriadoPascoa(ano);
		return pascoa.minusDays(47);
	}

	public static LocalDate getFeriadoSextaFeiraSanta(int ano) {
		var pascoa = getFeriadoPascoa(ano);
		return pascoa.minusDays(2);
	}

}
