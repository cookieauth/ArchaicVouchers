package io.aptint.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CodeHandler {

    private Map<UUID, String> codeTSAMap;

    public CodeHandler() {
        codeTSAMap = new HashMap<>();
    }

    public Map<UUID, String> getCodeTSAMap() {
        return codeTSAMap;
    }

    public void setCodeTSAMap(Map<UUID, String> codeTSAMap) {
        this.codeTSAMap = codeTSAMap;
    }

    public void saveCodeTSAMap() {

    }

    public void loadCodeTSAMap() {
    }

}
