package INSA.TD.services.files.filemanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.List;

public class JSONDataSource extends FileDataSource {

    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public JSONDataSource(String path) {
        setPath(path);
    }

    @Override
    protected <E> void writeValue(List<E> data) throws IOException {
        objectMapper.writeValue(getPathToFile(), data);
    }

    @Override
    protected <E> List<E> readValue() throws Exception {
        return objectMapper.readValue(getPathToFile(), new TypeReference<>() {
        });
    }

    @Override
    protected String getExtension() {
        return ".json";
    }
}
