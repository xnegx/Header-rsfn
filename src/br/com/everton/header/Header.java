package br.com.everton.header;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Header {

	private String tamanhoDoHeader;
	private String versaoProtocolo;
	private String codigoDeErro;
	private String tratamentoEspecial;
	private String usoFuturo;
	private String chaveAssimetricaDestino;
	private String algoritimoChaveSimetrica;
	private String chaveAssimetricaLocal;
	private String hash;
	private String acCertificadoDestino;
	private String numeroDeSerieDoDestino;
	private String acCertificadoLocal;
	private String numeroDeSerieDoLocal;
	private String bufferCriptografiaChaveSimetrica;
	private String bufferCriptogramaAuteticacaoMensagem;
	
	
	public static String preparaArquivo(String arquivo) throws IOException {	
		InputStream entrada = new FileInputStream(arquivo);
		BufferedInputStream entradaBuffer = new BufferedInputStream(entrada);
		ByteArrayOutputStream saidaBuffer = new ByteArrayOutputStream();
		int x;
		while((x = entradaBuffer.read()) != -1){
			saidaBuffer.write(x);
		}
		byte[] binariobuff = saidaBuffer.toByteArray();
	    StringBuilder sb = new StringBuilder();
	    for (byte b : binariobuff) {
	        sb.append(String.format("%02X", b));
	    }
		return sb.toString();		
		
	}


	public String getTamanhoDoHeader(String arquivo) throws IOException {
		String resultado = arquivo.substring(0,4);
		if (resultado.equals("024C")) {
			return "588 Bytes";
		}
		return "ERRO no tamanho do Header: " + resultado;
	}

	public String getVersaoProtocolo(String arquivo) {
		String resultado = arquivo.substring(4,6);
		if (resultado.equals("02")) {
			return "02 - Versao 2"; 
		}
		return "ERRO na versão do Protocolo: "  + resultado;
	}


	public String getCodigoDeErro(String arquivo) {
		String resultado = arquivo.substring(6,8);
		if (resultado.equals("00")) {
			resultado = "00 Sem erros, segurança conferida";
		}
		return resultado;
	}


	public String getTratamentoEspecial(String arquivo) {
		String resultado = arquivo.substring(8,10);
		return resultado;
	}


	public String getUsoFuturo(String arquivo) {
		String resultado = arquivo.substring(10,12);
		return resultado;
	}

	public String getChaveAssimetricaDestino(String arquivo) {
		String resultado = arquivo.substring(12,14);
		if (resultado.equals("02")) {
			resultado = "02 - RSA com 2048 bits";
			return resultado;
		}
		if (resultado.equals("01")) {
			resultado = "01 - RSA com 1024 bits";
			return resultado;
		}
		return resultado;
	}

	public String getAlgoritimoChaveSimetrica(String arquivo) {
		String resultado = arquivo.substring(14,16);
		if(resultado.equals("01")) {
			resultado = "01 - Triple-DES com 168 bits (3x56 bits)";
			return resultado;
		}
		return resultado;
	}

	public String getChaveAssimetricaLocal(String arquivo) {
		String resultado = arquivo.substring(16,18);
		if(resultado.equals("02")) {
			resultado = "02 - RSA com 2048 bits";
			return resultado;
		}
		if(resultado.equals("01")) {
			resultado = "01 - RSA com 1024 bits";
			return resultado;
		}
		return resultado;
	}

	public String getHash(String arquivo) {
		String resultado = arquivo.substring(18, 20);
		if(resultado.equals("03")) {
			resultado = "03- SHA-256";
			return resultado;
		}
		if(resultado.equals("01")) {
			resultado = "01 - SHA-1";
			return resultado;
		}
		return resultado;
	}


	public String getAcCertificadoDestino(String arquivo) {
		String resultado = arquivo.substring(20,22);
		return resultado;
	}


	public String getNumeroDeSerieDoDestino(String arquivo) throws UnsupportedEncodingException {
		String temp = arquivo.substring(22,86);
		String resultado = "";
		StringBuilder temp1 = new StringBuilder();
	    for (int i = 0; i < temp.length(); i+=2) {
	        String str = temp.substring(i, i+2);
	        temp1.append((char)Integer.parseInt(str, 16));
	        resultado = temp1.toString();
	    }
		return resultado.replace("00","");
	}

	public String getAcCertificadoLocal(String arquivo) {
		String resultado = arquivo.substring(86, 88);
		
		
		return resultado;
	}

	public String getNumeroDeSerieDoLocal(String arquivo) {
		String temp = arquivo.substring(88, 152);
		String resultado = "";
		StringBuilder temp1 = new StringBuilder();
	    for (int i = 0; i < temp.length(); i+=2) {
	        String str = temp.substring(i, i+2);
	        temp1.append((char)Integer.parseInt(str, 16));
	        resultado = temp1.toString();
	    }
		return resultado.replace("00","");
	}

}
