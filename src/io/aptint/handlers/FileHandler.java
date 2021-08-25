package io.aptint.handlers;

import io.aptint.BraveVouchers;
import io.aptint.utils.AIFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {

    private final BraveVouchers braveVouchers;

    private Map<AIFile, String> voucherFiles;

    public FileHandler() throws IOException {
        braveVouchers = BraveVouchers.getBraveVouchers();
        voucherFiles = new HashMap<>();
        loadVouchersAsFiles();
    }

    private void loadVouchersAsFiles() throws IOException {
        List<String> files = new ArrayList<>();
        Map<AIFile, String> fileMap = new HashMap<>();
        for (String name : (new File(braveVouchers.getDataFolder(), "/vouchers")).list()) {
            if (name.endsWith(".yml")) {
                name = name.replaceAll(".yml", "");
                fileMap.put(new AIFile(braveVouchers.getDataFolder(), name), name);
            }
        }
        this.voucherFiles = fileMap;
        //voucherNamesFromFiles().forEach(n -> voucherFiles.put(new AIFile(braveVouchers.getDataFolder(), n), n));
    }

}
