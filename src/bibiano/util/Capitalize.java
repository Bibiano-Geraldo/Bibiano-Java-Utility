package bibiano.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Capitalize {
    /**
     * Este programa foi criado no Java version "12.0.2" 2019-07-16,
     * Java(TM) SE Runtime Environment (build 12.0.2+10).
     * O método toTitle transforma os primeiros caracteres de cada palavra depois do delemitador
     * espaço em maiusculas incluindo o primeiro caractere do texto.
     * Como usar?
     * String seuTexto = Capitalize.capitalize("texto de ilustração aqui.");
     * String seuTexto1 = Capitalize.capitalize("TEXTO DE ILUSTRACAO AQUI.");
     * System.out.println(seuTexto);
     * System.out.println(seuTexto1);
     * A saída do seuTexto será = Texto De Ilustração Aqui.
     * A saída do seuTexto1 será = Texto De Ilustração Aqui.
     * Este método lança a exceção java.lang.StringIndexOutOfBoundsException,
     * caso o usuário tente passar uma string sem nenhum caractere.
     * Programa feito por Bibiano Geraldo Mangue -> Bhibyano@gmail.com
     */
    public static String toTitle(String str) {

        String tudoParaLowerCase = str.toLowerCase().strip();
        String regexToSearch = "\\s\\w";
        Pattern pattern = Pattern.compile(regexToSearch);
        Matcher matcher = pattern.matcher(tudoParaLowerCase);
        String toTitle = primeiroChar(tudoParaLowerCase);

        while (matcher.find()) {
            final int i = (matcher.start());
            char c = toTitle.charAt(i + 1);

            toTitle = (toTitle.replaceAll("\\s" + c, " " +
                    Character.toString(c).toUpperCase()));
        }
        return toTitle;
    }

    /**
     * Este programa foi criado no Java version "12.0.2" 2019-07-16,
     * Java(TM) SE Runtime Environment (build 12.0.2+10).
     * O método primeiroChar transforma apenas o primeiro caractere do texto
     * em maiuscula..
     * Como usar?
     * String seuTexto = Capitalize.capitalizeFirst("texto de ilustração aqui.");
     * String seuTexto1 = Capitalize.capitalizeFirst("TEXTO DE ILUSTRACAO AQUI.");
     * System.out.println(seuTexto);
     * System.out.println(seuTexto1);
     * A saída do seuTexto será = Texto de ilustração aqui.
     * A saída do seuTexto1 será = Texto de ilustração aqui.
     * Este método lança a exceção java.lang.StringIndexOutOfBoundsException,
     * caso o usuário tente passar uma string sem nenhum caractere.
     * Programa feito por Bibiano Geraldo Mangue -> Bhibyano@gmail.com
     */
    public static String primeiroChar(String str) {

        String tudoParaLowerCase = str.toLowerCase().strip();

        return (tudoParaLowerCase.replaceFirst(Character.toString(tudoParaLowerCase.charAt(0)),
                Character.toString(tudoParaLowerCase.charAt(0)).toUpperCase()));
    }

    /**
     * Este programa foi criado no Java version "12.0.2" 2019-07-16,
     * Java(TM) SE Runtime Environment (build 12.0.2+10).
     * O método capitalizarTexto transforma os primeiros caracteres de cada palavra depois do
     * ponto final (.) ou depois do ponto de exclamação (!) ou depos do ponto de interrogação (?)
     * em maiusculas incluindo o primeiro caractere do texto.
     * Como usar?
     * String seuTexto = Capitalize.capitalize("java é java! será a melhor linguagem? texto de exemplo. fim! ");
     * System.out.println(seuTexto);
     * A saída do seuTexto será = Java é java! Será a melhor linguagem? Texto de exemplo. Fim!
     * Este método lança a exceção java.lang.StringIndexOutOfBoundsException,
     * caso o usuário tente passar uma string sem nenhum caractere.
     * Programa feito por Bibiano Geraldo Mangue -> Bhibyano@gmail.com
     */
    public static String capitalizarTexto(String str) {
        String tudoParaLowerCase = str.toLowerCase().strip();
        String regexToSearch = "\\.+\\s+\\w+|[!]+\\s+\\w+|[?]+\\s+\\w+";
        Pattern pattern = Pattern.compile(regexToSearch);
        Matcher matcher = pattern.matcher(tudoParaLowerCase);
        String capitalizarTexto = primeiroChar(tudoParaLowerCase);

        while (matcher.find()) {
            final int i = (matcher.start());
            char charEncontrado = capitalizarTexto.charAt(i + 2);
            char pontuacaoEncontrada = capitalizarTexto.charAt(i);

            capitalizarTexto = (capitalizarTexto.replaceAll("(\\.|[!]|[?])+\\s+" + charEncontrado,
                    pontuacaoEncontrada + " " + Character.toString(charEncontrado).toUpperCase()));
        }
        return capitalizarTexto;
    }
}
