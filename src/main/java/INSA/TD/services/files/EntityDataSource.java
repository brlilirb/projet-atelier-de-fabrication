package INSA.TD.services.files;

import INSA.TD.services.files.filemanager.JSONDataSource;

public class EntityDataSource extends AtelierDataSource {

    public static final String ENTITIES = "entities/";

    public EntityDataSource(String fileName, Class<?> clazz) {
        super(new JSONDataSource(ENTITIES + fileName, clazz));
    }
}
