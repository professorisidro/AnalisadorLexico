package br.com.professorisidro.compiler.lexico;

public class Token {
	public static final int TK_IDENTIFIER  = 0;
	public static final int TK_NUMBER      = 1;
	public static final int TK_OPERATOR    = 2;
	public static final int TK_PONCTUATION = 3;
	public static final int TK_ASSIGN      = 4;
	
	private int    type;
	private String text;
	
	public Token(int type, String text) {
		super();
		this.type = type;
		this.text = text;
	}

	public Token() {
		super();
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", text=" + text + "]";
	}
	
	

}
