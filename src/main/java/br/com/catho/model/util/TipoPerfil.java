package br.com.catho.model.util;

public enum TipoPerfil {
	DEFAULT(1),
	UNILEVER(2),
	NIKE(3),
	APPLE(4),
	FORD(5);
	
	 private final int codigo;
	
	TipoPerfil(int codigo) {
	    this.codigo = codigo;
	}
	
	int codigo() { return codigo; }
}