package com.github.qcha.io;

import com.google.common.base.Charsets;
import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
public class FileTextWriter {
    private final String name;
    private final Path file;
    private final boolean appendable;

    public FileTextWriter(String name, boolean appendable) {
        file = Paths.get(name);

        if (Files.notExists(file)) {
            throw new IllegalArgumentException(String.format("File with name: %s , doesn't exist.", name));
        }

        if (!Files.isWritable(file)) {
            throw new IllegalArgumentException(String.format("File with name: %s , hasn't write permissions.", name));
        }

        this.name = name;
        this.appendable = appendable;
    }

    public void writeLine(String line) throws IOException {
        if (appendable) {
            com.google.common.io.Files.append(line, file.toFile(), Charsets.UTF_8);
        } else {
            com.google.common.io.Files.write(line, file.toFile(), Charsets.UTF_8);
        }
    }
}
