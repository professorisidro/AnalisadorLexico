package br.com.professorisidro.compiler.parser;

import br.com.professorisidro.compiler.exceptions.IsiSyntaxException;
import br.com.professorisidro.compiler.lexico.IsiScanner;
import br.com.professorisidro.compiler.lexico.Token;

public class IsiParser {

	private IsiScanner scanner; // analisador léxico
	private Token      token;   // o token atual
	
	/* o Parser recebe o analisador léxico como parâmetro no construtor
	 * pois a cada procedimento invoca-o sob demanda
	 */
	public IsiParser(IsiScanner scanner) {
		this.scanner = scanner;
	}
	
	public void E() {
		T();
		El();
		
	}
	
	public void El() {
		token = scanner.nextToken();
		if (token != null) {
			OP();
			T();
			El();
		}
	}
	
	public void T() {
		token = scanner.nextToken();
		if (token.getType() != Token.TK_IDENTIFIER && token.getType() != Token.TK_NUMBER) {
			throw new IsiSyntaxException("ID or NUMBER Expected!, found "+Token.TK_TEXT[token.getType()]+" ("+token.getText()+") at LINE "+token.getLine()+" and COLUMN "+token.getColumn());
		}
		
	}
	
	public void OP() {
		if (token.getType() != Token.TK_OPERATOR) {
			throw new IsiSyntaxException("Operator Expected, found "+Token.TK_TEXT[token.getType()]+" ("+token.getText()+")  at LINE "+token.getLine()+" and COLUMN "+token.getColumn());
		}
	}
}
