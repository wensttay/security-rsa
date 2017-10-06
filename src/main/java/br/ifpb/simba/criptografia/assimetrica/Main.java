package br.ifpb.simba.criptografia.assimetrica;

import br.ifpb.simba.criptografia.assimetrica.encoder.PairPrimeGenerator;
import br.ifpb.simba.criptografia.assimetrica.encoder.AsymKeyGenerator;
import br.ifpb.simba.criptografia.assimetrica.encoder.EncoderEngineImp;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 25/09/2017, 13:43:11
 */
public class Main {

    public static PairPrimeGenerator generator = new PairPrimeGenerator();
    public static EncoderEngineImp engineImp = new EncoderEngineImp();

    public static void main(String[] args) {
        
        AsymKeyGenerator akg = new AsymKeyGenerator(
//                new BigInteger("5"), new BigInteger("7")
        );
        
        System.out.println("p = " + akg.getP());
        System.out.println("q = " + akg.getQ());
        System.out.println("n = " + akg.getN());
        System.out.println("z = " + akg.getZ());
        System.out.println("d = " + akg.getD());
        System.out.println("e = " + akg.getE());
        System.out.println("Chave Privada: " + akg.getPrivateKey().toString());
        System.out.println("Chave Publica: " + akg.getPublicKey().toString());
        
        String text = "É você pode ver que agora funciona? Não sei você, mas eu gostei! Você gostou?";
        BigInteger[] encodeMessage = engineImp.encodeMessage(text, akg.getE(), akg.getN());
        String decodeMessage = engineImp.decodeMessage(encodeMessage, akg.getD(), akg.getN());
        
        StringBuilder encoded = new StringBuilder("");
        for (BigInteger bigInteger : encodeMessage) {
            encoded.append(new String(bigInteger.toByteArray()));
        }
        
        System.out.println("Encripted Menssage: " + encoded.toString());
        System.out.println("Decripted Menssage: " + decodeMessage);

//        String msg = "A";
//        String msgcifrada = null;
//        String msgdecifrada = null;
//        BigInteger n, d, e;
//        int bitlen = 2048;
//
//        //Escolha de forma aleatória dois números primos grandes p e q
//        SecureRandom r = new SecureRandom();
//        BigInteger p = new BigInteger(bitlen / 2, 100, r);
//        BigInteger q = new BigInteger(bitlen / 2, 100, r);
//
//        //Compute n = p * q
//        n = p.multiply(q);
//
//        //Compute a função totiente phi(n) = (p -1) (q -1)
//        BigInteger m = (p.subtract(BigInteger.ONE))
//                       .multiply(q.subtract(BigInteger.ONE));
//
//        //Escolha um inteiro  "e"  , 1 < "e" < phi(n) ,  "e" e phi(n) sejam primos entre si.
//        e = new BigInteger("3");
//        while(m.gcd(e).intValue() > 1) e = e.add(new BigInteger("2"));
//
//        // d seja inverso multiplicativo de "e"
//        d = e.modInverse(m);
//
//        System.out.println("p:"+p);
//        System.out.println("q:"+q);
//        System.out.println("n:"+n);
//        System.out.println("e:"+e);
//        System.out.println("d:"+d);
//
//        //mensagem cifrada - RSA_encrypt()
//        msgcifrada = new BigInteger(msg.getBytes()).modPow(e, n).toString();
//        System.out.println("msg cifrada: "+ msgcifrada);
//
//        //mensagem decifrada - RSA_decrypt()
//        msgdecifrada = new String(new BigInteger(msgcifrada).modPow(d, n).toByteArray());
//        System.out.println("msg decifrada: " +msgdecifrada);
        
    }

//    public static BigInteger gerateEValueBI(BigInteger d, BigInteger z) {
//        BigInteger i = BigInteger.ONE;
//        while (true) {
//            if (i.multiply(d).mod(z).equals(BigInteger.ONE)) {
//                return i;
//            }
//            i = i.add(BigInteger.ONE);
//        }
//    }
//
//    public static BigInteger geratePrimeEachOtherBI(BigInteger num) {
//
//        Random rnd = new Random();
//        do {
//            BigInteger i = new BigInteger(num.bitLength(), rnd);
//            if (isPrimeEachOtherBI(num, i) && !i.equals(num)) { // PERMITE OU NEGA IGUAIS ??
//                return i;
//            }
//        } while (true);
//
//    }
//
//    public static boolean isPrimeEachOtherBI(BigInteger more, BigInteger less) {
//
//        BigInteger moreAux = more;
//        BigInteger lessAux = less;
//
//        if (moreAux.compareTo(lessAux) < 0) {
//            lessAux = more;
//            moreAux = less;
//        }
//
//        while (moreAux.mod(lessAux).compareTo(BigInteger.ZERO) != 0) {
//            BigInteger aux = moreAux.mod(lessAux);
//            moreAux = lessAux;
//            lessAux = aux;
//        }
//
//        return lessAux.equals(BigInteger.ONE);
//    }

}
