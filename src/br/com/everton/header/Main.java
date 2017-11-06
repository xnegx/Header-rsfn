package br.com.everton.header;
import java.io.IOException;
public class Main {

	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			String temp = new String(args[0]);
			Header entrada = new Header();
			String buffer = entrada.preparaArquivo(temp);
			//System.out.println(entrada.preparaArquivo(temp));
			System.out.println("Tamanho do cabe�alho: " + entrada.getTamanhoDoHeader(buffer));
			System.out.println("Versao do protocolo: " + entrada.getVersaoProtocolo(buffer));
			System.out.println("C�digo de erro: " + entrada.getCodigoDeErro(buffer));
			System.out.println("Indica��o de tratamento especial: " + entrada.getTratamentoEspecial(buffer));
			System.out.println("Reservado para uso futuro: " + entrada.getUsoFuturo(buffer));
			System.out.println("Algoritmo da chave assim�trica do destino: " + entrada.getChaveAssimetricaDestino(buffer));
			System.out.println("Algoritmo da chave sim�trica: " + entrada.getAlgoritimoChaveSimetrica(buffer));
			System.out.println("Algoritmo da chave assim�trica local: " + entrada.getChaveAssimetricaLocal(buffer));
			System.out.println("Algoritmo de \"hash\": " + entrada.getHash(buffer));
			System.out.println("Certificado digital do destino: " + entrada.getAcCertificadoDestino(buffer));
			System.out.println("S�rie do certificado digital do destino: " + entrada.getNumeroDeSerieDoDestino(buffer));
			System.out.println("Certificado digital do destinatario: " + entrada.getAcCertificadoLocal(buffer));
			System.out.println("S�rie do certificado digital de origem: " + entrada.getNumeroDeSerieDoLocal(buffer));

		}
		else {
			System.out.println("nenhuma argumento foi passado");
		}
		
	}
	
}
