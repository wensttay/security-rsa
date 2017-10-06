package br.ifpb.simba.criptografia.assimetrica.encoder;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 05/10/2017, 01:35:45
 */
public class PairPrimeGenerator {

    private BigInteger firstNumber = BigInteger.ONE;
    private BigInteger secondNumber = BigInteger.ONE;

    public PairPrimeGenerator() {
        generateBigValues();
    }

    public PairPrimeGenerator generate(BigInteger max) {
        firstNumber = randomBigInt(max);

        while (secondNumber.equals(BigInteger.ONE)) {
            BigInteger randomBigInt = randomBigInt(max);

            if (!randomBigInt.equals(firstNumber)) {
                secondNumber = randomBigInt;
            }
        }

        return this;
    }

    public PairPrimeGenerator generateBigValues() {

        SecureRandom r = new SecureRandom();
        firstNumber = new BigInteger(25 / 2, 100, r);

        do {
            BigInteger aux = new BigInteger(25 / 2, 100, r);
            if (!aux.equals(firstNumber)) {
                secondNumber = aux;
            }
        } while (secondNumber.equals(BigInteger.ONE));

        return this;
    }

    private BigInteger randomBigInt(BigInteger max) {
        Random rnd = new Random();
        do {
            BigInteger i = new BigInteger(max.bitLength(), rnd);
            if (i.compareTo(max) <= 0 && isPrimeBigInt(i)) {
                return i;
            }
        } while (true);
    }

    public boolean isPrimeBigInt(BigInteger number) {

        BigInteger two = new BigInteger("2");
        BigInteger tree = new BigInteger("3");

        if (!number.isProbablePrime(5)) {
            return false;
        }

        if (!two.equals(number)
                && BigInteger.ZERO.equals(number.mod(two))) {
            return false;
        }

        for (BigInteger i = tree; i.multiply(i).compareTo(number) < 1; i = i.add(two)) {
            if (BigInteger.ZERO.equals(number.mod(i))) {
                return false;
            }
        }

        return true;
    }

    public BigInteger getFirstNumber() {
        return firstNumber;
    }

    public BigInteger getSecondNumber() {
        return secondNumber;
    }

}
