package br.com.corp.ecommerce.security;


import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EcommerceCrypto {

	public static String encrypt(String original) throws Exception {
//		//Creating a Signature object
//	    Signature sign = Signature.getInstance("SHA256withRSA");

//		// 1 Preciso criar um Objeto do tipo KeyPairGenerator (para escolher meu algoritmo  de geração da chave)
//		KeyPairGenerator keyPair = KeyPairGenerator.getInstance("RSA");
//		
//		// escolhi o tamanho da chave de criptografia (neste caso 2048 bits, o equivalente a uma string de 256 caracteres)
//		keyPair.initialize(2048);

//		// gera essa chave
//		KeyPair pair = keyPair.generateKeyPair();
//				
//		// obtenho a chave pública a partir desta chave gerada
//		PublicKey publicKey = pair.getPublic();
		String strMinhaChave = "123456789 123456789 123456789 12"; 
		Key minhaChave = new SecretKeySpec(strMinhaChave.getBytes(), "AES");

		// preciso escolher o algoritmo de Criptografia
		Cipher cipher = Cipher.getInstance("AES");

		// inicializando o algoritmo de criptografia
		cipher.init(Cipher.ENCRYPT_MODE, minhaChave);
		
		//agora sim vamos trabalhar a "transformação" da nossa string
		cipher.update(original.getBytes());
		
		
		//gero a string criptografada
		String originalCripto = new String(cipher.doFinal(), "UTF-8");
				
		return originalCripto;
	}
}
