package br.ifpb.simba.criptografia.assimetrica.encoder;

import java.math.BigInteger;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 05/10/2017, 04:50:53
 */
public class AsymKey {

    private BigInteger fistValue;
    private BigInteger secondValue;

    public AsymKey() {
    }

    public AsymKey(BigInteger fistValue, BigInteger secondValue) {
        this.fistValue = fistValue;
        this.secondValue = secondValue;
    }
    
    public BigInteger getFistValue() {
        return fistValue;
    }

    public void setFistValue(BigInteger fistValue) {
        this.fistValue = fistValue;
    }

    public BigInteger getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(BigInteger secondValue) {
        this.secondValue = secondValue;
    }
    
    public boolean isMissAValue(){
        return fistValue == null || secondValue == null;
    }
    
    @Override
    public String toString() {
        return "AsymKey{" + fistValue + ", " + secondValue + '}';
    }
    
}
