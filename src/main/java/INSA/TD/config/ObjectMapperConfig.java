package INSA.TD.config;

import INSA.TD.models.etat.machine.EtatMachine;
import INSA.TD.models.etat.machine.EtatMachineMixin;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectMapperConfig {

    private ObjectMapperConfig() {
    }

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .addMixIn(EtatMachine.class, EtatMachineMixin.class);
    }
}
