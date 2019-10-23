package bibiano.util;

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
     * Programa feito por Bibiano Geraldo Mangue -> Bhibyano@gmail.com
     */
    public static String paraExtenso(String numeroEmAlgarismo) {
        StringBuilder getNumeroEmAlgarismo = new StringBuilder(numeroEmAlgarismo.
                replaceAll("\\s+", "").
                replaceAll(",", "."));
        if (getNumeroEmAlgarismo.length() > 21)
            throw new IndexOutOfBoundsException("Ops! O número " +
                    getNumeroEmAlgarismo + " está fora do alcance.");

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

        boolean milhaoConcatValidation = Integer.parseInt(base) >= 1 || Integer.parseInt(mil) >= 1;
        boolean bilhaoConcatValidation = Integer.parseInt(base) >= 1 || Integer.parseInt(mil) >= 1
                || Integer.parseInt(milhao) >= 1;
        boolean trilhaoConcatValidation = Integer.parseInt(base) >= 1 || Integer.parseInt(mil) >= 1
                || Integer.parseInt(milhao) >= 1 || Integer.parseInt(bilhao) >= 1;
        boolean quatrilhaoConcatValidation = Integer.parseInt(base) >= 1 || Integer.parseInt(mil) >= 1
                || Integer.parseInt(milhao) > 1 || Integer.parseInt(bilhao) >= 1
                || Integer.parseInt(trilhao) >= 1;
        boolean quintilhaoConcatValidation = Integer.parseInt(base) >= 1 || Integer.parseInt(mil) >= 1
                || Integer.parseInt(milhao) > 1 || Integer.parseInt(bilhao) >= 1
                || Integer.parseInt(trilhao) >= 1 || Integer.parseInt(quatrilhao) >= 1;

        if (Integer.parseInt(mil) >= 1) {
            if (Integer.parseInt(base) >= 1) {
                concatMil = " mil e ";
            } else {
                concatMil = " mil ";
            }
        }
        if (Integer.parseInt(milhao) == 1) {
            if (milhaoConcatValidation) {
                concatMilhoes = " milhão e ";
            } else {
                concatMilhoes = " milhão ";
            }
        }
        if (Integer.parseInt(milhao) > 1) {
            if (milhaoConcatValidation) {
                concatMilhoes = " milhões e ";
            } else {
                concatMilhoes = " milhões ";
            }
        }
        if (Integer.parseInt(bilhao) == 1) {
            if (bilhaoConcatValidation) {
                concatBilhoes = " bilhão e ";
            } else {
                concatBilhoes = " bilhão ";
            }
        }
        if (Integer.parseInt(bilhao) > 1) {
            if (bilhaoConcatValidation) {
                concatBilhoes = " bilhões e ";
            } else {
                concatBilhoes = " bilhões ";
            }
        }
        if (Integer.parseInt(trilhao) == 1) {
            if (trilhaoConcatValidation) {
                concatTrilhoes = " trilhão e ";
            } else {
                concatTrilhoes = " trilhão ";
            }
        }
        if (Integer.parseInt(trilhao) > 1) {
            if (trilhaoConcatValidation) {
                concatTrilhoes = " trilhões e";
            } else {
                concatTrilhoes = " trilhões ";
            }
        }
        if (Integer.parseInt(quatrilhao) == 1) {
            if (quatrilhaoConcatValidation) {
                concatQuatrilhoes = " quatrilhão e ";
            } else {
                concatQuatrilhoes = " quatrilhão ";
            }
        }
        if (Integer.parseInt(quatrilhao) > 1) {
            if (quatrilhaoConcatValidation) {
                concatQuatrilhoes = " quatrilhões e ";
            } else {
                concatQuatrilhoes = " quatrilhões ";
            }
        }
        if (Integer.parseInt(quintilhao) == 1) {
            if (quintilhaoConcatValidation) {
                concatQuintilhoes = " quintilhão e ";
            } else {
                concatQuintilhoes = " quintilhão ";
            }
        }
        if (Integer.parseInt(quintilhao) > 1) {
            if (quintilhaoConcatValidation) {
                concatQuintilhoes = " quintilhões e ";
            } else {
                concatQuintilhoes = " quintilhões ";
            }
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
                strip().replaceAll("\\s+", " ").
                replaceAll("um mil ", "mil ");

        if (resultadoFinal.matches("um mil")) {
            resultadoFinal = resultadoFinal.replace("um mil", "mil");
        }
        return resultadoFinal;
    }
}

