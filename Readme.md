# Compilador Java
Exemplo de um pequeno compilador feito em Java para analisar expressões aritméticas.
Feito de forma manual para apresentar os conceitos de autômatos e parsers visto na disciplina de Compiladores

## Analisador Léxico

Tokens Reconhecidos:
Identificadores := LETRA (LETRA | DIGITO)*
Numeros := DIGITO+ (. DIGITO*)?
Operadores := > | < | = | ! | + | - | * | /

Autômato de reconhecimento

![Automato de reconhecimento dos Tokens](http://www.professorisidro.com.br/wp-content/uploads/Automato.png)

## Analisador Sintático
Dada a gramática

G = (Vn, Vt, P, S)

Vn = E, T, OP

Vt = id, num, + , - , * , /

P = dado pelas regras abaixo

		1. E ->   E OP T | T
		2. T ->  id | num
		3. OP ->  + | - | * | /

*precisamos reescrever a regra 1, transformando-a nas seguintes regras*

	1a.  E  ->  T E'
	1b.  E' -> OP T E' | &
	2.   T  -> id | num
	3.   OP -> + | - | * | /
	
Tranformamos a gramática em LL(1). A partir daí temos o nosso grafo de análise Sintática, dado pela figura abaixo.

![Automato de reconhecimento dos Tokens](http://www.professorisidro.com.br/wp-content/uploads/AnalisadorSintatico.png)

O Código está disponível no restante do repo.