package INSA.TD.services.filemanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.List;

public class JSONDataSource extends FileDataSource {

    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public JSONDataSource(String path) {
        setPath(path);
    }

    @Override
    public <E> void writeData(List<E> data) {
        try {
            checkDirectory();
            objectMapper.writeValue(getPathToFile(), data);
            System.out.println("Object successfully written to file.");
        } catch (Exception e) {
            System.err.println("Error writing object to file: " + e.getMessage());
        }
    }

    @Override
    public <E> List<E> readData() {
        try {
            checkDirectory();
            return objectMapper.readValue(getPathToFile(), new TypeReference<>() {
            });
        } catch (Exception e) {
            System.err.println("Erreur lors de la lecture du fichier JSON: " + e.getMessage());
        }
        return new ArrayList<>();
    }
    //TODO pousser plus loin (refactor)
}
