package INSA.TD.models.etat.machine;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Arret.class, name = "arret"),
        @JsonSubTypes.Type(value = Disponible.class, name = "disponible"),
        @JsonSubTypes.Type(value = Maintenance.class, name = "maintenance"),
        @JsonSubTypes.Type(value = Occupe.class, name = "occupe"),
        @JsonSubTypes.Type(value = Operationnel.class, name = "operationnel"),
        @JsonSubTypes.Type(value = Panne.class, name = "panne")
})
public abstract class EtatMachineMixin {
}
