package db;

public class DbExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;//Numero da versao

	//A mensagem de excecao ser� transmitida para a super classe RuntimeException
	public DbExcecao(String msg) {//Construtor da exce��o
		super(msg);
	}
}
