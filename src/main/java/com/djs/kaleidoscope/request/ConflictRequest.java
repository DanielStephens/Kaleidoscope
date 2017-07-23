package com.djs.kaleidoscope.request;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.djs.kaleidoscope.merger.Merger;

public class ConflictRequest {

    private final String originalFile;

    private final String currentFile;

    private final String branchFile;

    private final String targetPath;

    public ConflictRequest(final String originalFile, final String currentFile, final String branchFile,
            final String targetPath) {
        this.originalFile = originalFile;
        this.currentFile = currentFile;
        this.branchFile = branchFile;
        this.targetPath = targetPath;
    }

    public String merge(final Merger merger) throws IOException {
        return merger.merge(originalFile, currentFile, branchFile);
    }

    public OutputStream retrieveOutputStream() throws IOException {
        return new FileOutputStream(targetPath);
    }
}

