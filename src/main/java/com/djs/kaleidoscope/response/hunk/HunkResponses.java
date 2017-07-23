package com.djs.kaleidoscope.response.hunk;

import org.hamcrest.Description;

import com.djs.kaleidoscope.Output;

public class HunkResponses {

    public static HunkResponse failure(final String message) {
        return new HunkResponse() {

            @Override
            public int collect(final Description description, final int exitCode) {
                description.appendText("FAILED ").appendText(message);
                return Output.SUCCESS_CODE;
            }
        };
    }

    public static HunkResponse pass(final String message) {
        return new HunkResponse() {

            @Override
            public int collect(final Description description, final int exitCode) {
                description.appendText("PASSED ").appendText(message);
                return exitCode;
            }
        };
    }

}

