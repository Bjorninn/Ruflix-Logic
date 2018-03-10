package eu.elieser.ruflix.logic.settings;

import eu.elieser.ruflix.logic.utils.FileLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SettingsManager
{
    private static final String DEFAULT_VLC_PATH = "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe";
    private static final String VLC_PATH_KEY = "VLC Path";
    private static final String VLC_FULLSCREEN_KEY = "Play Fullscreen";

    private static SettingsManager instance;

    private Properties properties;

    public SettingsManager()
    {
        instance = this;
        loadSettings();
    }

    private void loadSettings()
    {
        if (!FileLoader.hasPropertyFile())
        {
            FileLoader.createPropertyFile();
        }

        properties = FileLoader.getPropertyFile();
    }

    public static SettingsManager getInstance()
    {
        return instance;
    }

    public String getVlcPath()
    {
        return properties.getProperty(VLC_PATH_KEY, DEFAULT_VLC_PATH);
    }

    public List<String> getVlcOptions()
    {
        List<String> options = new ArrayList<>();

        if (!(properties.getProperty(VLC_FULLSCREEN_KEY, "0").equals("0")))
        {
            options.add("-f");
        }

        return options;
    }
}
