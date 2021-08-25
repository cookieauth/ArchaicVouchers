package io.aptint.handlers;

import org.bukkit.Bukkit;

public enum VersionHandler {
    TOO_OLD(-1),
    v1_8_R1(181),
    v1_8_R2(182),
    v1_8_R3(183),
    v1_9_R1(191),
    v1_9_R2(192),
    v1_10_R1(1101),
    v1_11_R1(1111),
    v1_12_R1(1121),
    v1_13_R2(1132),
    v1_14_R1(1141),
    v1_15_R1(1151),
    v1_15_R2(1152),
    V1_16_R1(1161),
    TOO_NEW(-2);

    private static VersionHandler currentVersion;

    private static VersionHandler latest;

    private final int versionInteger;

    VersionHandler(int versionInteger) {
        this.versionInteger = versionInteger;
    }

    public static VersionHandler getCurrentVersion() {
        if (currentVersion == null) {
            String str = Bukkit.getServer().getClass().getPackage().getName();
            int i = Integer.parseInt(str.substring(str.lastIndexOf('.') + 1).replace("_", "").replace("R", "").replace("v", ""));
            for (VersionHandler version : values()) {
                if (version.getVersionInteger() == i) {
                    currentVersion = version;
                    break;
                }
            }
            if (i > getLatestVersion().getVersionInteger())
                currentVersion = getLatestVersion();
            if (currentVersion == null)
                currentVersion = TOO_NEW;
        }
        return currentVersion;
    }

    public static VersionHandler getLatestVersion() {
        if (latest == null) {
            VersionHandler version = TOO_OLD;
            for (VersionHandler version1 : values()) {
                if (version1.comparedTo(version) == 1)
                    version = version1;
            }
            return version;
        }
        return latest;
    }

    public static boolean isNewerThan(VersionHandler version) {
        if (currentVersion == null)
            getCurrentVersion();
        return (currentVersion.versionInteger > version.versionInteger || currentVersion.versionInteger == -2);
    }

    public static boolean isSameThan(VersionHandler version) {
        if (currentVersion == null)
            getCurrentVersion();
        return (currentVersion.versionInteger == version.versionInteger);
    }

    public static boolean isOlderThan(VersionHandler version) {
        if (currentVersion == null)
            getCurrentVersion();
        return (currentVersion.versionInteger < version.versionInteger || currentVersion.versionInteger == -1);
    }

    public int getVersionInteger() {
        return this.versionInteger;
    }

    public int comparedTo(VersionHandler version) {
        byte b = -1;
        int i = getVersionInteger();
        int j = version.getVersionInteger();
        if (i > j || j == -2) {
            b = 1;
        } else if (i == j) {
            b = 0;
        } else if (j == -1) {
            b = -1;
        }
        return b;
    }
}