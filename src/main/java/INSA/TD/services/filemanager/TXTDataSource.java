package INSA.TD.services.filemanager;

import INSA.TD.utils.StringUtils;

import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TXTDataSource extends FileDataSource {

    public TXTDataSource(String path) {
        setPath(path);
    }

    @Override
    protected <E> void writeValue(List<E> data) throws Exception {
        Files.write(
                getPath(),
                StringUtils.convertToStringList(data),
                StandardOpenOption.CREATE
        );
    }

    @Override
    @SuppressWarnings("unchecked")
    protected <E> List<E> readValue() throws Exception {
        return (List<E>) Files.readAllLines(getPath());
    }
}

