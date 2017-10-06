package br.ifpb.simba.criptografia.assimetrica.encoder;

import br.ifpb.simba.criptografia.assimetrica.alphabet.AlphabetStrategyImpSimple;
import br.ifpb.simba.criptografia.assimetrica.alphabet.AlphabetStrategy;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 05/10/2017, 05:59:11
 */
public class EncoderEngineImp implements EncoderEngine<BigInteger> {

    private AlphabetStrategy strategy = new AlphabetStrategyImpSimple();

    @Override
//    public byte[] encodeMessage(String msg, BigInteger E, BigInteger N) {
    public BigInteger[] encodeMessage(String msg, BigInteger E, BigInteger N) {
//        BigInteger C = new BigInteger(msg.getBytes()).modPow(E, N);
//        return C.toByteArray();

        int length = msg.length();
        BigInteger[] integers = new BigInteger[length];

        for (int i = 0; i < length; i++) {
            byte letter = strategy.toByte(msg.charAt(i));
            integers[i] = BigInteger.valueOf(letter).modPow(E, N);
        }

        return integers;
    }
    
    @Override
    public BigInteger[] encodeMessage(String msg, AsymKey key) {
        return encodeMessage(msg, key.getFistValue(), key.getSecondValue());
    }

    @Override
//    public String decodeMessage(byte[] msg, BigInteger D, BigInteger N) {
    public String decodeMessage(BigInteger[] msg, BigInteger D, BigInteger N) {
//        BigInteger C = new BigInteger(msg);
//        BigInteger P = C.modPow(D, N);
//        return new String(P.toByteArray());

        int intsLength = msg.length;
        char[] letters = new char[intsLength];

        for (int i = 0; i < intsLength; i++) {
            BigInteger C = msg[i];
            BigInteger P = C.modPow(D, N);
            letters[i] = strategy.toChar((byte) P.intValue());
        }

        return new String(letters);
    }
    
    @Override
    public String decodeMessage(BigInteger[] msg, AsymKey key) {
        return decodeMessage(msg, key.getFistValue(), key.getSecondValue());
    }

}
