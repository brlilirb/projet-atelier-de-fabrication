package INSA.TD.services.files;

import INSA.TD.services.files.filemanager.JSONDataSource;

public class EntityDataSource extends AtelierDataSource {

    public static final String ENTITIES = "entities/";

    public EntityDataSource(Class<?> clazz) {
        super(new JSONDataSource(getPath(getFileName(clazz)), clazz));
    }

    private static String getPath(String fileName) {
        return ENTITIES + fileName;
    }

    private static String getFileName(Class<?> clazz) {
        return clazz.getSimpleName().toLowerCase(); // Récupère le nom de la classe pour le transformer en nom de fichier
    }
}
