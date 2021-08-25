package io.aptint.handlers;

import io.aptint.api.Voucher;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TSAVHandler {

    private final Map<UUID, Voucher> tsaMap;
    private boolean tsaEnabled;

    public TSAVHandler() {
        tsaMap = new HashMap<>();
        tsaEnabled = false;
    }

    public boolean getTSAEnabled() {
        return this.tsaEnabled;
    }

    public void setTSAEnabled(boolean tsaEnabled) {
        this.tsaEnabled = tsaEnabled;
    }

    public Map<UUID, Voucher> getTSAMap() {
        return tsaMap;
    }

}
