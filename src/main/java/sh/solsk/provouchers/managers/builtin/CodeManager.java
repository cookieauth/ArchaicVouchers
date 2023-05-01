package sh.solsk.provouchers.managers.builtin;

import sh.solsk.provouchers.api.Code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CodeManager {

    private List<Code> codeList;
    private Map<UUID, String> twoStepMap;
    private boolean twoStepEnabled;

    public CodeManager() {
        this.twoStepMap = new HashMap<>();

    }

    public Map<UUID, String> getTwoStepMap() {
        return twoStepMap;
    }

    public void setTwoStepMap(Map<UUID, String> twoStepMap) {
        this.twoStepMap = twoStepMap;
    }

    public boolean isTwoStepEnabled() {
        return twoStepEnabled;
    }

    public void setTwoStepEnabled(boolean twoStepEnabled) {
        this.twoStepEnabled = twoStepEnabled;
    }

    public List<Code> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<Code> codeList) {
        this.codeList = codeList;
    }


}
