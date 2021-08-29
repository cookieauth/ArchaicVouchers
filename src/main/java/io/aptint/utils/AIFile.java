package io.aptint.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class AIFile {

    private final File yamlFile;
    private FileConfiguration yamlConfiguration;
    private final File pluginDataFolder;
    private final String name;

    public AIFile(File pluginDataFolder, String name) {
        this.name = name + ".yml";

        yamlFile = new File(pluginDataFolder, this.name);
        this.pluginDataFolder = pluginDataFolder;
        yamlConfiguration = YamlConfiguration.loadConfiguration(yamlFile);
    }

    public void createConfig() {
        if(!yamlFile.exists()) {
            if(!this.pluginDataFolder.exists()) {
                this.pluginDataFolder.mkdir();
            }

            try {
                yamlFile.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public File getDirectory() {
        return pluginDataFolder;
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return yamlFile;
    }

    public FileConfiguration getConfig() {
        return yamlConfiguration;
    }

    public void addDefault(String key, String value) {
        if(yamlConfiguration.getString(key) == null) {
            yamlConfiguration.set(key, value);
            try {
                yamlConfiguration.save(yamlFile);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void addDefaults(Map<String, Object> defaults) {
        for (String s : defaults.keySet()) {
            this.yamlConfiguration.set(s, defaults.get(s));
            try {
                yamlConfiguration.save(yamlFile);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void save() {
        try {
            yamlConfiguration.save(yamlFile);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void reload() {
        yamlConfiguration = YamlConfiguration.loadConfiguration(yamlFile);
    }

    public void deleteFile() {
        yamlFile.delete();
    }

    public void deleteParentDir() {
        this.getDirectory().delete();
    }

    public void reset() {
        this.deleteFile();
        try {
            yamlFile.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void wipeDirectory() {
        this.getDirectory().delete();
        this.pluginDataFolder.mkdir();
    }

    public void createSubDirectory(String name) throws IOException {
        if (!pluginDataFolder.exists()) {
            throw new IOException("Root folder for BraveVouchers could not be found.");
        }

        File subDirectory = new File(pluginDataFolder, name);

        if(subDirectory.exists()) {
            throw new IOException("Subdirectory for BraveVoucher already exists.");
        }

        subDirectory.mkdir();
    }

    public boolean contains(String toCheck) {
        return yamlConfiguration.contains(toCheck);
    }
}
