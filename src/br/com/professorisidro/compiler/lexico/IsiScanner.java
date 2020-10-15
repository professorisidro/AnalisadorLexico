package br.com.professorisidro.compiler.lexico;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.professorisidro.compiler.exceptions.IsiLexicalException;

public class IsiScanner {
	
	private char[] content;
	private int    estado;
	private int    pos;
	
	public IsiScanner(String filename) {
		try {
			String txtConteudo;
			txtConteudo = new String(Files.readAllBytes(Paths.get(filename)),StandardCharsets.UTF_8);
			System.out.println("DEBUG --------");
			System.out.println(txtConteudo);
			System.out.println("--------------");
			content = txtConteudo.toCharArray();
			pos=0;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Token nextToken() {
		char currentChar;
		Token token;
		String term="";
		if (isEOF()) {
			return null;
		}
		estado = 0;
		while (true) {
			currentChar = nextChar();
			
			switch(estado) {
			case 0:
				if (isChar(currentChar)) {
					term += currentChar;
					estado = 1;
				}
				else if (isDigit(currentChar)) {
					estado = 3;
					term += currentChar;
				}
				else if (isSpace(currentChar)) {
					estado = 0;
				}
				else if (isOperator(currentChar)) {
					estado = 5;
				}
				else {
					throw new IsiLexicalException("Unrecognized SYMBOL");
				}
				break;
			case 1:
				if (isChar(currentChar) || isDigit(currentChar)) {
					estado = 1;
					term += currentChar;
				}
				else if (isSpace(currentChar) || isOperator(currentChar)){
					estado = 2;
				}
				else {
					throw new IsiLexicalException("Malformed Identifier");
				}
				break;
			case 2:
				back();
				token = new Token();
				token.setType(Token.TK_IDENTIFIER);
				token.setText(term);
				return token;
			case 3:
				if (isDigit(currentChar)) {
					estado = 3;
					term += currentChar;
				}
				else if (!isChar(currentChar)) {
					estado = 4;
				}
				else {
					throw new IsiLexicalException("Unrecognized Number");
				}
				break;
			case 4:
				token = new Token();
				token.setType(Token.TK_NUMBER);
				token.setText(term);
				back();
				return token;
			case 5:
				term += currentChar;
				token = new Token();
				token.setType(Token.TK_OPERATOR);
				token.setText(term);
				return token;
		    }
		}
		
		
		
	}

	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	private boolean isChar(char c) {
		return (c >= 'a' && c <= 'z') || (c>='A' && c <= 'Z');
	}
	
	private boolean isOperator(char c) {
		return c == '>' || c == '<' || c == '=' || c=='!';
	}
	private boolean isSpace(char c) {
		return c == ' ' || c == '\t' || c == '\n' || c == '\r'; 
	}
	
	private char nextChar() {
		return content[pos++];
	}
	private boolean isEOF() {
		return pos == content.length;
	}
	
    private void back() {
    	pos--;
    }
	
	
	
	
	
}
