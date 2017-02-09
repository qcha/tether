package com.github.qcha.io;

import lombok.Getter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
public class FileTextWriter implements AutoCloseable {
    private final String name;
    private final BufferedWriter writer;

    public FileTextWriter(String name, boolean appendable) throws IOException {
        this.name = name;
        final Path file = Paths.get(name);

        if (Files.notExists(file)) {
            throw new IllegalArgumentException(String.format("File with name: %s , doesn't exist.", name));
        }

        if (!Files.isWritable(file)) {
            throw new IllegalArgumentException(String.format("File with name: %s , hasn't write permissions.", name));
        }

        writer = new BufferedWriter(new FileWriter(name, appendable));
    }

    public void writeLine(String line) throws IOException {
        writer.write(line);
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}
