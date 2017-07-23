package com.djs.kaleidoscope.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Responses {

    private static final Logger LOGGER = LoggerFactory.getLogger(Responses.class);

    private Responses() {
    }


    public static ChainResponse chain() {
        return new CombinationResponse();
    }

    public static ConflictResponse pass() {
        return pass("");
    }

    public static ConflictResponse pass(final String message) {
        return new ConflictResponse() {

            @Override
            public void respond() {
                LOGGER.error("MERGED {}", message);
                System.exit(0);
            }
        };
    }

    public static ConflictResponse fail() {
        return fail("");
    }

    public static ConflictResponse fail(final String message) {
        return new ConflictResponse() {

            @Override
            public void respond() {
                LOGGER.error("FAILED {}", message);
                System.exit(-1);
            }
        };
    }
}

