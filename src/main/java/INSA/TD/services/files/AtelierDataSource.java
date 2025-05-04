package INSA.TD.services.files;

import INSA.TD.services.files.filemanager.DataSource;

import java.util.List;

public abstract class AtelierDataSource implements DataSource {

    private final DataSource dataSource;

    AtelierDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public <E> void writeData(List<E> data) {
        dataSource.writeData(data);
    }

    @Override
    public <E> List<E> readData() {
        return dataSource.readData();
    }
}
