package br.ifpb.simba.criptografia.assimetrica.alphabet;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 06/10/2017, 03:13:31
 */
public class AlphabetStrategyImpSimple implements AlphabetStrategy {

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "
            + "abcdefghijklmnopqrstuvwxyz"
            + "1234567890"
            + "\"\'!@#$%*()-_+=`´{}[]^~:;?/,.|\\¹²³£¢¬§ªº°"
            + "ÀÁÂÃÈÉÊẼÌÍÎĨÒÓÔÕÙÚÛŨÇ"
            + "àáâãèéêẽìíîĩòóôõùúûũç";

    @Override
    public byte toByte(char letter) {
        return (byte) (alphabet.indexOf((letter)));
    }

    @Override
    public char toChar(byte letterValue) {
        try {
            return alphabet.charAt((int) letterValue);
        } catch (IndexOutOfBoundsException ex) {
        }
        return '☐';
    }
}
