package INSA.TD.services.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class FileDataSource {

    private Path path;

    public void checkDirectory() throws IOException {
        Files.createDirectories(path.getParent());
    }

    public abstract <E> void writeData(List<E> data);

    public abstract <E> List<E> readData();

    public Path getPath() {
        return path;
    }

    public File getPathToFile() {
        return getPath().toFile();
    }

    public void setPath(String path) {
        this.path = Path.of(path);
    }
}

