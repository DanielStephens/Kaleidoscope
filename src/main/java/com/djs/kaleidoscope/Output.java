package com.djs.kaleidoscope;


public class Output {

    public static final int SUCCESS_CODE = 1;

    public static final int FAIL_CODE = -1;

    private Output() {
    }

    public static void pass() {
        System.exit(SUCCESS_CODE);
    }

    public static void fail() {
        System.exit(FAIL_CODE);
    }

}

