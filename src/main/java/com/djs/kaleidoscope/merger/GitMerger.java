package com.djs.kaleidoscope.merger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GitMerger implements Merger {

    @Override
    public String merge(final String originalFile, final String currentFile,
            final String branchFile) throws IOException {
        // @formatter:off
        Process gitMergeFile = new ProcessBuilder()
                .command(
                    Arrays.asList(
                        "git",
                        "merge-file",
                        "-p",
                        originalFile,
                        currentFile,
                        branchFile
                    )
                )
                .redirectErrorStream(true)
                .start();
        // @formatter:on

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(gitMergeFile.getInputStream()))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

}

