/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsps.plugins.exceptions;

/**
 *
 * @author Admin
 */
public class MissingFileException extends Exception {
    public MissingFileException(String s) {
     super(s);   
    }
}
