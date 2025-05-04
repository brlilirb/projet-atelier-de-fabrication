package INSA.TD.services.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class FileDataSource {

    private Path path;

    private void checkDirectory() throws IOException {
        Files.createDirectories(path.getParent());
    }

    protected abstract <E> void writeValue(List<E> data) throws Exception;

    protected abstract <E> List<E> readValue() throws Exception;

    public <E> void writeData(List<E> data) {
        try {
            checkDirectory();
            writeValue(data);
            System.out.println("Object successfully written to file.");
        } catch (Exception e) {
            System.err.println("Error writing object to file: " + e.getMessage());
        }
    }

    public <E> List<E> readData() {
        try {
            checkDirectory();
            return readValue();
        } catch (Exception e) {
            System.err.println("Error while reading file: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    protected Path getPath() {
        return path;
    }

    protected File getPathToFile() {
        return getPath().toFile();
    }

    protected void setPath(String path) {
        this.path = Path.of(path);
    }
}

