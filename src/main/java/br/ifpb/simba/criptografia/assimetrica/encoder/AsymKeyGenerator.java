package br.ifpb.simba.criptografia.assimetrica.encoder;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 05/10/2017, 04:49:44
 */
public class AsymKeyGenerator {

    private AsymKey privateKey = new AsymKey();
    private AsymKey publicKey = new AsymKey();
    private PairPrimeGenerator generator;
    private BigInteger P, Q, N, Z, D, E;

    public AsymKeyGenerator() {
        this.generator = new PairPrimeGenerator();
        generator.generate(new BigInteger("1000"));
        this.P = generator.getFirstNumber();
        this.Q = generator.getSecondNumber();
        generateAsymKeys(P, Q);;
    }

    public AsymKeyGenerator(BigInteger P, BigInteger Q) {
        this.P = P;
        this.Q = Q;
        generateAsymKeys(P, Q);
    }
    
    public void generateAsymKeys(BigInteger P, BigInteger Q){
        
        if(!generator.isPrimeBigInt(P)){
            throw new NotPrimeNumberException("Erro: O Numero P deve ser Primo!");
        }
        
        if(!generator.isPrimeBigInt(Q)){
            throw new NotPrimeNumberException("Erro: O Numero Q deve ser Primo!");
        }
        
        N = P.multiply(Q);
        Z = (P.subtract(BigInteger.ONE)).multiply(Q.subtract(BigInteger.ONE));
        D = generatePrimeEachOtherBI(Z);
//        E = generateEValueBI(D, Z);
        E = D.modInverse(Z);
        
        this.privateKey.setFistValue(D);
        this.privateKey.setSecondValue(N);
        
        this.publicKey.setFistValue(E);
        this.publicKey.setSecondValue(N);
    }
    
    
    private BigInteger generateEValueBI(BigInteger d, BigInteger z) {
        BigInteger i = BigInteger.ONE;
        while (true) {
            if (i.multiply(d).mod(z).equals(BigInteger.ONE)) {
                return i;
            }
            i = i.add(BigInteger.ONE);
        }
    }

    private BigInteger generatePrimeEachOtherBI(BigInteger Z) {
        
        BigInteger e = new BigInteger("3");
        while(Z.gcd(e).intValue() > 1) e = e.add(new BigInteger("2"));
        return e;
        
//        Random rnd = new Random();
//        do {
//            BigInteger i = new BigInteger(Z.bitLength(), rnd);
//            if (isPrimeEachOtherBI(Z, i) && !i.equals(Z)) { // PERMITE OU NEGA IGUAIS ??
//                return i;
//            }
//        } while (true);

    }

    private boolean isPrimeEachOtherBI(BigInteger more, BigInteger less) {

        BigInteger moreAux = more;
        BigInteger lessAux = less;

        if (moreAux.compareTo(lessAux) < 0) {
            lessAux = more;
            moreAux = less;
        }

        while (moreAux.mod(lessAux).compareTo(BigInteger.ZERO) != 0) {
            BigInteger aux = moreAux.mod(lessAux);
            moreAux = lessAux;
            lessAux = aux;
        }

        return lessAux.equals(BigInteger.ONE);
    }

    public PairPrimeGenerator getGenerator() {
        return generator;
    }

    public AsymKey getPrivateKey() {
        return privateKey;
    }

    public AsymKey getPublicKey() {
        return publicKey;
    }

    public BigInteger getP() {
        return P;
    }

    public BigInteger getQ() {
        return Q;
    }

    public BigInteger getN() {
        return N;
    }

    public BigInteger getZ() {
        return Z;
    }

    public BigInteger getD() {
        return D;
    }

    public BigInteger getE() {
        return E;
    }
    
}
