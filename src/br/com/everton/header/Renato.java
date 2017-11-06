package br.com.everton.header;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Renato {

	public static void main(String[] args) throws IOException {
		
		byte[] array = Files.readAllBytes(new File("C:\\arquivo").toPath());
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.printf("%02X ", array[i]);
			
		}
		
	}

}
