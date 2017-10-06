/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.simba.criptografia.assimetrica.encoder;

import java.math.BigInteger;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 06/10/2017, 01:32:48
 */
public interface EncoderEngine<T> {

    public T[] encodeMessage(String msg, BigInteger E, BigInteger N);

    public T[] encodeMessage(String msg, AsymKey key);

    public String decodeMessage(T[] msg, BigInteger D, BigInteger N);

    public String decodeMessage(T[] msg, AsymKey key);

}
