package br.com.everton.header;
import java.io.IOException;
public class Main {

	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			String temp = new String(args[0]);
			Header entrada = new Header();
			String buffer = Header.preparaArquivo(temp);
			System.out.println(entrada.getHeader(buffer));

		}
		else {
			System.out.println("nenhuma argumento foi passado");
		}
		
	}
	
}
