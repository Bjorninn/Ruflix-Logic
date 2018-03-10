package eu.elieser.ruflix.logic.media;

import eu.elieser.ruflix.logic.data.Program;
import eu.elieser.ruflix.logic.settings.SettingsManager;

import java.io.IOException;
import java.util.List;

public class VlcPlayer
{
    private final String vlcPath;

    public VlcPlayer()
    {
        vlcPath = SettingsManager.getInstance().getVlcPath();
    }

    public void playProgram(Program program)
    {
        List<String> options = SettingsManager.getInstance().getVlcOptions();

        // TODO Check if we have saved this video locally

        // If not then play the stream
        options.add(0, program.mediaUrl);
        options.add(0, vlcPath);

        try
        {
            ProcessBuilder pb = new ProcessBuilder(options);
            Process start = pb.start();
        }
        catch (IOException e)
        {
            // TODO error handling
            e.printStackTrace();
        }
    }
}
