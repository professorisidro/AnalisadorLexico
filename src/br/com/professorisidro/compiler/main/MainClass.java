package br.com.professorisidro.compiler.main;

import br.com.professorisidro.compiler.exceptions.IsiLexicalException;
import br.com.professorisidro.compiler.lexico.IsiScanner;
import br.com.professorisidro.compiler.lexico.Token;

public class MainClass {
	public static void main(String[] args) {
		try {
			IsiScanner sc = new IsiScanner("input.isi");
			Token token = null;
			do {
				token = sc.nextToken();
				if (token != null) {
					System.out.println(token);
				}

			} while (token != null);
		} catch (IsiLexicalException ex) {
			System.out.println("Lexical ERROR "+ex.getMessage());

		}
		catch (Exception ex) {
			System.out.println("Generic Error!!");
			System.out.println(ex.getClass().getName());
		}
	}
}
