package INSA.TD.services.files.filemanager;

import java.util.List;

public interface DataSource {

    <E> void writeData(List<E> data);

    <E> List<E> readData();

}
