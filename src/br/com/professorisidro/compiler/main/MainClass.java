package br.com.professorisidro.compiler.main;

import br.com.professorisidro.compiler.exceptions.IsiLexicalException;
import br.com.professorisidro.compiler.exceptions.IsiSyntaxException;
import br.com.professorisidro.compiler.lexico.IsiScanner;
import br.com.professorisidro.compiler.parser.IsiParser;

public class MainClass {
	public static void main(String[] args) {
		try {
			IsiScanner sc = new IsiScanner("input.isi");
			IsiParser  pa = new IsiParser(sc);
			
			pa.E();
			
			System.out.println("Compilation Successful!");
		} catch (IsiLexicalException ex) {
			System.out.println("Lexical Error "+ex.getMessage());
		}
		catch (IsiSyntaxException ex) {
			System.out.println("Syntax Error "+ex.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Generic Error!!");
			System.out.println(ex.getClass().getName());
		}
	}
}
