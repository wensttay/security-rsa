/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifpb.simba.criptografia.assimetrica.alphabet;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 06/10/2017, 03:18:55
 */
public interface AlphabetStrategy {

    byte toByte(char letter);

    char toChar(byte letterValue);

}
