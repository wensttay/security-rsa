package br.ifpb.simba.criptografia.assimetrica.alphabet;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 06/10/2017, 03:13:31
 */
public class AlphabetStrategyImp implements AlphabetStrategy {

    @Override
    public byte toByte(char letter) {
        return (byte) letter;
    }

    @Override
    public char toChar(byte letterValue) {
        return (char) letterValue;
    }
}
