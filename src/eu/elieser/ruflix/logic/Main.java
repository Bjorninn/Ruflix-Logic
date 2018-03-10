package eu.elieser.ruflix.logic;

import eu.elieser.ruflix.logic.data.Program;
import eu.elieser.ruflix.logic.media.VlcPlayer;
import eu.elieser.ruflix.logic.network.NetworkController;
import eu.elieser.ruflix.logic.settings.SettingsManager;

import java.time.LocalDate;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        try
        {
            SettingsManager manager = new SettingsManager();

            NetworkController controller = new NetworkController();
            List<Program> programs = controller.loadProgramFromRuv(LocalDate.of(2017, 07, 25));

            VlcPlayer player = new VlcPlayer();
            player.playProgram(programs.get(0));

            //ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", programs.get(0).mediaUrl, "-f");
            //Process start = pb.start();

            //NetworkController.downloadImage(NetworkController.TEST);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
