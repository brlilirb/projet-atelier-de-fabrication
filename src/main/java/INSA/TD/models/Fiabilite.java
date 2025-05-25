package INSA.TD.models;

import java.time.Duration;

public record Fiabilite(String reference, double fiabilite, Duration totalDowntime, Duration totalUptime,
                        long activeDays) {
}
