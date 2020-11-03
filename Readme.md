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
*TO DO*