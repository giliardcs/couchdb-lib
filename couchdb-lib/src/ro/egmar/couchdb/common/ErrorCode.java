/*
 * ErrorCode.java
 *
 * Created on September 16, 2006, 5:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ro.egmar.couchdb.common;

/**
 *
 * @author egor
 */
public enum ErrorCode {
    DB_NOT_FOUND (404),
    DB_ALREADY_EXISTS (409);
    
    private final int code;
    
    ErrorCode(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return this.code;
    }
}
