## No pacote bibiano.util você pode:
###1. Transformar números em algariso para extenso na classe AlgarismoParaExtenso.

#####Sobre o método paraExtenso:

      O método paraExtenso transforma qualquer número inteiro positivo
      no intervalo 0 - 999 999 999 999 999 999 999.
      Exemplo: 1523 irá retornar Mil e quinhentos vinte três.
      Caso o número supra citado seja excedido o método irá
      lançar a excessão IndexOutOfBoundsException.
      Se o número em algarismo conter partes decimas, as mesmas serão descartadas
      automaticamente covertendo apenas a parte inteira do mesmo.
      Use o delimitador espaço para separar números caso necessário.
      Como funciona o método?
      Sabendo que os número contém centenas, dezenas e unidades, o número digitado
      sempre que o tamanho (length) atingir 3 unidades o mesmo é dividido e agrupando
      os 3 números encontrados em variáveis diferentes começando da direita para esquerda.
      Para cada variavel salva, o ultimo caractere será para unidades, o segundo caractere
      será para dezenas e o primeiro caractere será para centenas.
      O grupo mais a direita não possui nenhuma formatação, o segundo grupo a direita
      pertencerá a casa dos "Mil" o terceiro a direita pertencerá a casa dos "milhões"
      e assim sucessivamente.

###2. Capitalizar Strings na classe Capitalize.

#####Sobre o método toTitle:

     O método toTitle transforma os primeiros caracteres de cada palavra depois do delemitador
     espaço em maiusculas incluindo o primeiro caractere do texto.
     Como usar?
     String seuTexto = Capitalize.capitalize("texto de ilustração aqui.");
     String seuTexto1 = Capitalize.capitalize("TEXTO DE ILUSTRACAO AQUI.");
     System.out.println(seuTexto);
     System.out.println(seuTexto1);
     A saída do seuTexto será = Texto De Ilustração Aqui.
     A saída do seuTexto1 será = Texto De Ilustração Aqui.
     Este método lança a exceção java.lang.StringIndexOutOfBoundsException,
     caso o usuário tente passar uma string sem nenhum caractere.

#####Sobre o método primeiroChar:

 	   O método primeiroChar transforma apenas o primeiro caractere do texto
       em maiuscula..
       Como usar?
       String seuTexto = Capitalize.capitalizeFirst("texto de ilustração aqui.");
       String seuTexto1 = Capitalize.capitalizeFirst("TEXTO DE ILUSTRACAO AQUI.");
       System.out.println(seuTexto);
       System.out.println(seuTexto1);
       A saída do seuTexto será = Texto de ilustração aqui.
       A saída do seuTexto1 será = Texto de ilustração aqui.
       Este método lança a exceção java.lang.StringIndexOutOfBoundsException,
       caso o usuário tente passar uma string sem nenhum caractere.


#####Sobre o método capitalizarTexto:

      O método capitalizarTexto transforma os primeiros caracteres de cada palavra depois do
      ponto final (.) ou depois do ponto de exclamação (!) ou depos do ponto de interrogação (?)
      em maiusculas incluindo o primeiro caractere do texto.
      Como usar?
      String seuTexto = Capitalize.capitalize("java é java! será a melhor linguagem? texto de exemplo. fim! ");
      System.out.println(seuTexto);
      A saída do seuTexto será = Java é java! Será a melhor linguagem? Texto de exemplo. Fim!
      Este método lança a exceção java.lang.StringIndexOutOfBoundsException,
      caso o usuário tente passar uma string sem nenhum caractere.

###3. Formatar números na classe FormatarNumeros.


#####Sobre o método paraNumPersonalizado:

      O método paraNumPersonalizado, personaliza os números de uma maneira fácil,
      basta informar o número a ser personalizado, o tamanho dos digitos da casa
      decimal, e para formatar o número baseando na tua localização informe também
      a língua e o nome do país.
      Não quer prencher todos parametros supra citados?
      Não se preocupe, o método foi sobrecarregado quatro vezes, use a opcão que
      melhor se encaixar no teu caso.
      use o ponto e vírgula somente para separar a parte inteira da casa decimal.
      para números longos use o delimitador espaço para separar os algarismos.
      Este método lança a excessão java.lang.NumberFormatException caso o usuario não
      passe nenhum parametro, ou use caracteres não permitidos.
      como usar?
      String teste = FormatarNumeros.paraNumPersonalizado(numero:"123456789,666", tamParteDecimal:3, lingua:"en", pais:"MZ");
      System.out.println(teste);
      A saída do teste será = 123,456,789.666;

#####Sobre o método paraMoeda:

      O método paraMoeda, converte os números para moeda de uma maneira fácil,
      basta informar o número a ser convertido, o tamanho dos digitos da casa
      decimal, e para mostrar a tipo de moeda baseando na tua localização informe também
      a língua e o nome do país.
      Não quer prencher todos parametros supra citados?
      Não se preocupe, o método foi sobrecarregado quatro vezes, use a opcão que
      melhor se encaixar no teu caso.
      use o ponto e vírgula somente para separar a parte inteira da casa decimal.
      para números longos use o delimitador espaço para separar os algarismos.
      Este método lança a excessão java.lang.NumberFormatException caso o usuario não
      passe nenhum parametro, ou use caracteres não permitidos.
      como usar?
      String teste = FormatarNumeros.paraMoeda("numero:123456", tamParteDecimal:2, lingua:"en", país:"US");
      System.out.println(teste);
      A saída do teste será = $123,456.00;


## Autor:
**Nome:** Bibiano Geraldo Mangue

**Email:** Bhibyano@gmail.com

**Tel:** (+258) 843 440 69

> ###Linguagem usada:
> 
> Este programa foi criado no Java version "12.0.2" 2019-07-16,
     Java(TM) SE Runtime Environment (build 12.0.2+10).

> ###IDE usada:

> Intellij IDEA (Community edition) 2019.2


     


"# Bibiano-Java-Utility" 
"# Bibiano-Java-Utility" 
