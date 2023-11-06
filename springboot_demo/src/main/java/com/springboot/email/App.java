package com.springboot.email;

import com.synis.util.MockUtil;

import javax.script.ScriptException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            System.out.println(MockUtil.cname());
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }
}
