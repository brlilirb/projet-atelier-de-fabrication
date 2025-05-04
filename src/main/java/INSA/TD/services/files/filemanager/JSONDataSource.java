package INSA.TD.services.files.filemanager;

import INSA.TD.config.ObjectMapperConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JSONDataSource extends FileDataSource {

    private final ObjectMapper objectMapper = ObjectMapperConfig.getObjectMapper();
    private final Class<?> clazz;

    public JSONDataSource(String path, Class<?> clazz) {
        setPath(path);
        this.clazz = clazz;
    }

    @Override
    protected <E> void writeValue(List<E> data) throws IOException {
        objectMapper.writeValue(getPathToFile(), data);
    }

    @Override
    protected <E> List<E> readValue() throws Exception {
        return objectMapper.readValue(getPathToFile(), getJavaType());
    }

    @Override
    protected String getExtension() {
        return ".json";
    }

    private JavaType getJavaType() {
        return objectMapper.getTypeFactory()
                .constructParametricType(List.class, clazz);
    }
}
