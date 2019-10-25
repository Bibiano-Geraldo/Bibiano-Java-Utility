package bibiano.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlgarismoParaExtenso {
    /**
     * Este programa foi criado no Java version "12.0.2" 2019-07-16,
     * Java(TM) SE Runtime Environment (build 12.0.2+10).
     * O método paraExtenso transforma qualquer número inteiro positivo
     * no intervalo 0 - 999 999 999 999 999 999 999.
     * Exemplo: 1523 irá retornar Mil e quinhentos vinte três.
     * Caso o número supra citado seja excedido o método irá
     * lançar a excessão IndexOutOfBoundsException.
     * Se o número em algarismo conter partes decimas, as mesmas serão descartadas
     * automaticamente covertendo apenas a parte inteira do mesmo.
     * Use o delimitador espaço para separar números caso necessário.
     * Como funciona o método?
     * Sabendo que os número contém centenas, dezenas e unidades, o número digitado
     * sempre que o tamanho (length) atingir 3 unidades o mesmo é dividido e agrupando
     * os 3 números encontrados em variáveis diferentes começando da direita para esquerda.
     * Para cada variavel salva, o ultimo caractere será para unidades, o segundo caractere
     * será para dezenas e o primeiro caractere será para centenas.
     * O grupo mais a direita não possui nenhuma formatação, o segundo grupo a direita
     * pertencerá a casa dos "Mil" o terceiro a direita pertencerá a casa dos "milhões"
     * e assim sucessivamente.
     * Idiomas disponíveis: Português (pt_PT), Inglês (en_US).
     * Programa feito por Bibiano Geraldo Mangue -> Bhibyano@gmail.com
     */
    public static String paraExtenso(String numeroEmAlgarismo, String lingua, String pais) {
        Locale locale = new Locale(lingua, pais);

        StringBuilder getNumeroEmAlgarismo = new StringBuilder(numeroEmAlgarismo.
                replaceAll("\\s+", "").
                replaceAll(",", "."));

        if (getNumeroEmAlgarismo.length() > 21) {

            String resourceBundle = ResourceBundle.getBundle(
                    "numbers_english", locale).getString("Ops!_O_número");
            String resourceBundle1 = ResourceBundle.getBundle(
                    "numbers_english", locale).getString("está_fora_do_alcance.");

            if (locale.toString().equalsIgnoreCase("en_US")) {
                throw new IndexOutOfBoundsException(resourceBundle + " " +
                        getNumeroEmAlgarismo + " " + resourceBundle1);

            } else {
                throw new IndexOutOfBoundsException("Ops! O número " +
                        getNumeroEmAlgarismo + " está fora do alcance.");
            }
        }

        final int posicaoDaUnidade = 2;
        final int posicaoDaDezena = 1;
        final int posicaoDaCentena = 0;
        String concatMil = "";
        String concatMilhoes = "";
        String concatBilhoes = "";
        String concatTrilhoes = "";
        String concatQuatrilhoes = "";
        String concatQuintilhoes = "";
        String unidadeBase, dezenaBase, centenaBase, unidadeMil, dezenaMil, centenaMil, unidadeMilhao,
                dezenaMilhao, centenaMilhao, unidadeBilhao, dezenaBilhao, centenaBilhao,
                unidadeTrilhao, dezenaTrilhao, centenaTrilhao, unidadeQuatrilhao,
                dezenaQuatrilhao, centenaQuatrilhao, unidadeQuintilhao,
                dezenaQuintilhao, centenaQuintilhao, resultadoFinal;
        String[] unidades = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete",
                "oito", "nove", "dez", "onze", "doze", "treze", "catorze", "quinze",
                "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta",
                "sessenta", "setenta", "oitenta", "noventa"};
        String[] centenas = {"", "cento ", "duzentos", "trezentos", "quatrocentos", "quinhentos",
                "seiscentos", "setecentos", "oitocentos", "novecentos"};

        Pattern pattern = Pattern.compile("[.]+\\d+");
        Matcher matcher = pattern.matcher(getNumeroEmAlgarismo.toString());
        while (matcher.find()) {
            getNumeroEmAlgarismo.delete(matcher.start(), matcher.end());
        }
        while (getNumeroEmAlgarismo.length() <= 21) {
            getNumeroEmAlgarismo.insert(0, 0);
        }

        String quintilhao = (getNumeroEmAlgarismo.substring(getNumeroEmAlgarismo.length() - 21, getNumeroEmAlgarismo.length() - 18));
        String quatrilhao = (getNumeroEmAlgarismo.substring(getNumeroEmAlgarismo.length() - 18, getNumeroEmAlgarismo.length() - 15));
        String trilhao = (getNumeroEmAlgarismo.substring(getNumeroEmAlgarismo.length() - 15, getNumeroEmAlgarismo.length() - 12));
        String bilhao = (getNumeroEmAlgarismo.substring(getNumeroEmAlgarismo.length() - 12, getNumeroEmAlgarismo.length() - 9));
        String milhao = (getNumeroEmAlgarismo.substring(getNumeroEmAlgarismo.length() - 9, getNumeroEmAlgarismo.length() - 6));
        String mil = (getNumeroEmAlgarismo.substring(getNumeroEmAlgarismo.length() - 6, getNumeroEmAlgarismo.length() - 3));
        String base = (getNumeroEmAlgarismo.substring(getNumeroEmAlgarismo.length() - 3, getNumeroEmAlgarismo.length()));

        if (Integer.parseInt(mil) >= 1) {
            concatMil = " mil ";
        }
        if (Integer.parseInt(milhao) == 1) {
            concatMilhoes = " milhão ";
        }
        if (Integer.parseInt(milhao) > 1) {
            concatMilhoes = " milhões ";
        }
        if (Integer.parseInt(bilhao) == 1) {
            concatBilhoes = " bilhão ";
        }
        if (Integer.parseInt(bilhao) > 1) {
            concatBilhoes = " bilhões ";
        }
        if (Integer.parseInt(trilhao) == 1) {
            concatTrilhoes = " trilhão ";
        }
        if (Integer.parseInt(trilhao) > 1) {
            concatTrilhoes = " trilhões ";
        }
        if (Integer.parseInt(quatrilhao) == 1) {
            concatQuatrilhoes = " quatrilhão ";
        }
        if (Integer.parseInt(quatrilhao) > 1) {
            concatQuatrilhoes = " quatrilhões ";
        }
        if (Integer.parseInt(quintilhao) == 1) {
            concatQuintilhoes = " quintilhão ";
        }
        if (Integer.parseInt(quintilhao) > 1) {
            concatQuintilhoes = " quintilhões ";
        }

        //aqui é a base
        centenaBase = (centenas[Integer.parseInt(String.valueOf(base.charAt(posicaoDaCentena)))]);
        if (Integer.parseInt(base) == 100) {
            centenaBase = "cem";
        }
        dezenaBase = (dezenas[Integer.parseInt(String.valueOf(base.charAt(posicaoDaDezena)))]);
        if (base.charAt(posicaoDaDezena) == '1') {
            unidadeBase = (unidades[Integer.parseInt(String.valueOf(base.charAt(posicaoDaDezena))
                    + base.charAt(posicaoDaUnidade))]);
        } else {
            unidadeBase = (unidades[Integer.parseInt(String.valueOf(base.charAt(posicaoDaUnidade)))]);
        }

        // aqui é o mil
        centenaMil = (centenas[Integer.parseInt(String.valueOf(mil.charAt(posicaoDaCentena)))]);
        if (Integer.parseInt(mil) == 100) {
            centenaMil = "cem";
        }
        dezenaMil = (dezenas[Integer.parseInt(String.valueOf(mil.charAt(posicaoDaDezena)))]);
        if (mil.charAt(posicaoDaDezena) == '1') {
            unidadeMil = (unidades[Integer.parseInt(String.valueOf(mil.charAt(posicaoDaDezena))
                    + mil.charAt(posicaoDaUnidade))]);
        } else {
            unidadeMil = (unidades[Integer.parseInt(String.valueOf(mil.charAt(posicaoDaUnidade)))]);
        }

        //aqui é milhao
        centenaMilhao = (centenas[Integer.parseInt(String.valueOf(milhao.charAt(posicaoDaCentena)))]);
        if (Integer.parseInt(milhao) == 100) {
            centenaMilhao = "cem";
        }
        dezenaMilhao = (dezenas[Integer.parseInt(String.valueOf(milhao.charAt(posicaoDaDezena)))]);
        if (milhao.charAt(posicaoDaDezena) == '1') {
            unidadeMilhao = (unidades[Integer.parseInt(String.valueOf(milhao.charAt(posicaoDaDezena))
                    + milhao.charAt(posicaoDaUnidade))]);
        } else {
            unidadeMilhao = (unidades[Integer.parseInt(String.valueOf(milhao.charAt(posicaoDaUnidade)))]);
        }

        //aqui e bilhao
        centenaBilhao = (centenas[Integer.parseInt(String.valueOf(bilhao.charAt(posicaoDaCentena)))]);
        if (Integer.parseInt(bilhao) == 100) {
            centenaBilhao = "cem";
        }
        dezenaBilhao = (dezenas[Integer.parseInt(String.valueOf(bilhao.charAt(posicaoDaDezena)))]);
        if (bilhao.charAt(posicaoDaDezena) == '1') {
            unidadeBilhao = (unidades[Integer.parseInt(String.valueOf(bilhao.charAt(posicaoDaDezena))
                    + bilhao.charAt(posicaoDaUnidade))]);
        } else {
            unidadeBilhao = (unidades[Integer.parseInt(String.valueOf(bilhao.charAt(posicaoDaUnidade)))]);
        }

        //aqui e trilhao
        centenaTrilhao = (centenas[Integer.parseInt(String.valueOf(trilhao.charAt(posicaoDaCentena)))]);
        if (Integer.parseInt(trilhao) == 100) {
            centenaTrilhao = "cem";
        }
        dezenaTrilhao = (dezenas[Integer.parseInt(String.valueOf(trilhao.charAt(posicaoDaDezena)))]);
        if (trilhao.charAt(posicaoDaDezena) == '1') {
            unidadeTrilhao = (unidades[Integer.parseInt(String.valueOf(trilhao.charAt(posicaoDaDezena))
                    + trilhao.charAt(posicaoDaUnidade))]);
        } else {
            unidadeTrilhao = (unidades[Integer.parseInt(String.valueOf(trilhao.charAt(posicaoDaUnidade)))]);
        }

        //aqui e quatrilhao
        centenaQuatrilhao = (centenas[Integer.parseInt(String.valueOf(quatrilhao.charAt(posicaoDaCentena)))]);
        if (Integer.parseInt(quatrilhao) == 100) {
            centenaQuatrilhao = "cem";
        }
        dezenaQuatrilhao = (dezenas[Integer.parseInt(String.valueOf(quatrilhao.charAt(posicaoDaDezena)))]);
        if (quatrilhao.charAt(posicaoDaDezena) == '1') {
            unidadeQuatrilhao = (unidades[Integer.parseInt(String.valueOf(quatrilhao.charAt(posicaoDaDezena))
                    + quatrilhao.charAt(posicaoDaUnidade))]);
        } else {
            unidadeQuatrilhao = (unidades[Integer.parseInt(String.valueOf(quatrilhao.charAt(posicaoDaUnidade)))]);
        }

        //aqui e quintilhao
        centenaQuintilhao = (centenas[Integer.parseInt(String.valueOf(quintilhao.charAt(posicaoDaCentena)))]);
        if (Integer.parseInt(quintilhao) == 100) {
            centenaQuintilhao = "cem";
        }
        dezenaQuintilhao = (dezenas[Integer.parseInt(String.valueOf(quintilhao.charAt(posicaoDaDezena)))]);
        if (quintilhao.charAt(posicaoDaDezena) == '1') {
            unidadeQuintilhao = (unidades[Integer.parseInt(String.valueOf(quintilhao.charAt(posicaoDaDezena))
                    + quintilhao.charAt(posicaoDaUnidade))]);
        } else {
            unidadeQuintilhao = (unidades[Integer.parseInt(String.valueOf(quintilhao.charAt(posicaoDaUnidade)))]);
        }

        resultadoFinal = (centenaQuintilhao + " " + dezenaQuintilhao + " " + unidadeQuintilhao + concatQuintilhoes +
                centenaQuatrilhao + " " + dezenaQuatrilhao + " " + unidadeQuatrilhao + concatQuatrilhoes +
                centenaTrilhao + " " + dezenaTrilhao + " " + unidadeTrilhao + concatTrilhoes +
                centenaBilhao + " " + dezenaBilhao + " " + unidadeBilhao + concatBilhoes +
                centenaMilhao + " " + dezenaMilhao + " " + unidadeMilhao + concatMilhoes +
                centenaMil + " " + dezenaMil + " " + unidadeMil + concatMil +
                centenaBase + " " + dezenaBase + " " + unidadeBase).
                replaceAll("\\s+", " ").
                replaceAll("um mil ", "mil ").strip();

        if (resultadoFinal.matches("um mil")) {
            resultadoFinal = resultadoFinal.replace("um mil", "mil");
        }

        resultadoFinal = resultadoFinal.replaceAll("\\s+|\\s[e]\\s", " e ");
        resultadoFinal = resultadoFinal.replaceAll("e mil", "mil").
                replaceAll("e bilhão", "bilhão").
                replaceAll("e bilhões", "bilhões").
                replaceAll("e trilhão", "trilhão").
                replaceAll("e trilhões", "trilhões").
                replaceAll("e quatrilhão", "quatrilhão").
                replaceAll("e quatrilhões", "quatrilhões").
                replaceAll("e quintilhão", "quintilhão").
                replaceAll("e quintilhões", "quintilhões");

        String regexToSearch = "\\w+([\\u00e3\\u00ea\\u00f5]\\w+)*";
        Pattern pattern1 = Pattern.compile(regexToSearch);
        Matcher matcher1 = pattern1.matcher(resultadoFinal);
        String resourceBundle;
        List<String> lista = new ArrayList<>();

        if (locale.toString().equalsIgnoreCase("en_US")) {
            while (matcher1.find()) {

                String i = (matcher1.group());
                resourceBundle = ResourceBundle.getBundle("numbers_english").getString(i);
                lista.add((resourceBundle));
                String regex = "[,]|\\[|[]]";
                resultadoFinal = lista.toString().replaceAll(regex, "").
                        replaceAll("\\s+one thousand", " thousand").
                        replaceAll("thousand and", "thousand,").
                        replaceAll("lion and", "lion,").
                        replaceAll("ty and ", "ty-");

            }
        } else {
            if (!locale.toString().equalsIgnoreCase("pt_PT")) {
                System.out.println("Região não disponível, traduzindo para português...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        return Capitalize.primeiroChar(resultadoFinal);
    }
}

