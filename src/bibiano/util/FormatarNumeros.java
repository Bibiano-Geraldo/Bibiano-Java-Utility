package bibiano.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatarNumeros {
    /**
     * Este programa foi criado no Java version "12.0.2" 2019-07-16,
     * Java(TM) SE Runtime Environment (build 12.0.2+10).
     * O método paraNumPersonalizado, personaliza os números de uma maneira fácil,
     * basta informar o número a ser personalizado, o tamanho dos digitos da casa
     * decimal, e para formatar o número baseando na tua localização informe também
     * a língua e o nome do país.
     * Não quer prencher todos parametros supra citados?
     * Não se preocupe, o método foi sobrecarregado quatro vezes, use a opcão que
     * melhor se encaixar no teu caso.
     * use o ponto e vírgula somente para separar a parte inteira da casa decimal.
     * para números longos use o delimitador espaço para separar os algarismos.
     * Este método lança a excessão java.lang.NumberFormatException caso o usuario não
     * passe nenhum parametro, ou use caracteres não permitidos.
     * como usar?
     * String teste = FormatarNumeros.paraNumPersonalizado(numero:"123456789,666", tamParteDecimal:3, lingua:"en", pais:"MZ");
     * System.out.println(teste);
     * A saída do teste será = 123,456,789.666;
     * Programa feito por Bibiano Geraldo Mangue -> Bhibyano@gmail.com
     */

    public static String paraNumPersonalizado(String numero, int tamParteDecimal, String lingua, String pais) {
        numero = numero.replaceAll("\\s+", "").replaceAll(",", ".");
        NumberFormat numeroFinal = NumberFormat.getNumberInstance(new Locale(lingua, pais));
        numeroFinal.setMaximumFractionDigits(tamParteDecimal);
        return numeroFinal.format(new BigDecimal(numero));
    }

    public static String paraNumPersonalizado(String numero, int tamParteDecimal) {
        numero = numero.replaceAll("\\s+", "").replaceAll(",", ".");
        NumberFormat numeroFinal = NumberFormat.getNumberInstance();
        numeroFinal.setMaximumFractionDigits(tamParteDecimal);
        return numeroFinal.format(new BigDecimal(numero));
    }

    public static String paraNumPersonalizado(String numero, String lingua, String pais) {
        numero = numero.replaceAll("\\s+", "").replaceAll(",", ".");
        NumberFormat numeroFinal = NumberFormat.getNumberInstance(new Locale(lingua, pais));
        return numeroFinal.format(new BigDecimal(numero));
    }

    public static String paraNumPersonalizado(String numero) {
        numero = numero.replaceAll("\\s+", "").replaceAll(",", ".");
        NumberFormat numeroFinal = NumberFormat.getNumberInstance();
        return numeroFinal.format(new BigDecimal(numero));
    }

    /**
     * Este programa foi criado no Java version "12.0.2" 2019-07-16,
     * Java(TM) SE Runtime Environment (build 12.0.2+10).
     * O método paraMoeda, converte os números para moeda de uma maneira fácil,
     * basta informar o número a ser convertido, o tamanho dos digitos da casa
     * decimal, e para mostrar a tipo de moeda baseando na tua localização informe também
     * a língua e o nome do país.
     * Não quer prencher todos parametros supra citados?
     * Não se preocupe, o método foi sobrecarregado quatro vezes, use a opcão que
     * melhor se encaixar no teu caso.
     * use o ponto e vírgula somente para separar a parte inteira da casa decimal.
     * para números longos use o delimitador espaço para separar os algarismos.
     * Este método lança a excessão java.lang.NumberFormatException caso o usuario não
     * passe nenhum parametro, ou use caracteres não permitidos.
     * como usar?
     * String teste = FormatarNumeros.paraMoeda("numero:123456", tamParteDecimal:2, lingua:"en", país:"US");
     * System.out.println(teste);
     * A saída do teste será = $123,456.00;
     * Programa feito por Bibiano Geraldo Mangue -> Bhibyano@gmail.com
     */
    public static String paraMoeda(String numero, int tamParteDecimal, String lingua, String pais) {
        numero = numero.replaceAll("\\s+", "").replaceAll(",", ".");
        NumberFormat numeroFinal = NumberFormat.getCurrencyInstance(new Locale(lingua, pais));
        numeroFinal.setMaximumFractionDigits(tamParteDecimal);
        return numeroFinal.format(new BigDecimal(numero));
    }

    public static String paraMoeda(String numero, int tamParteDecimal) {
        numero = numero.replaceAll("\\s+", "").replaceAll(",", ".");
        NumberFormat numeroFinal = NumberFormat.getCurrencyInstance();
        numeroFinal.setMaximumFractionDigits(tamParteDecimal);
        return numeroFinal.format(new BigDecimal(numero));
    }

    public static String paraMoeda(String numero, String lingua, String pais) {
        numero = numero.replaceAll("\\s+", "").replaceAll(",", ".");
        NumberFormat numeroFinal = NumberFormat.getCurrencyInstance(new Locale(lingua, pais));
        return numeroFinal.format(new BigDecimal(numero));
    }

    public static String paraMoeda(String numero) {
        numero = numero.replaceAll("\\s+", "").replaceAll(",", ".");
        NumberFormat numeroFinal = NumberFormat.getCurrencyInstance();
        return numeroFinal.format(new BigDecimal(numero));
    }
}
