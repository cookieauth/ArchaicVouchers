package io.aptint.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TSACHandler {

    private final Map<UUID, String> tsaMap;
    private boolean tsaEnabled;

    public TSACHandler() {
        tsaMap = new HashMap<>();
        tsaEnabled = false;
    }

    public boolean getTSAEnabled() {
        return this.tsaEnabled;
    }

    public void setTSAEnabled(boolean tsaEnabled) {
        this.tsaEnabled = tsaEnabled;
    }

    public Map<UUID, String> getTSAMap() {
        return tsaMap;
    }

}
