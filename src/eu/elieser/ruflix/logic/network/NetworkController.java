package eu.elieser.ruflix.logic.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.elieser.ruflix.logic.data.Program;
import eu.elieser.ruflix.logic.data.json.Entry;
import eu.elieser.ruflix.logic.data.json.Sarpur;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NetworkController
{
    public static final String RUV_URL = "http://www.ruv.is";
    public static final String RUV_JSON_URL = "http://www.ruv.is/sarpur/app/json/1/";
    public static final String RUV_MEDIA_URL = "http://sip-ruv-vod.dcp.adaptive.level3.net/lokad/";
    public static final String STREAM_EXTENSION = ".m3u8";
    public static final String TEST = "http://cdn-img.ruv.is/sites/default/files/styles/1600x1000/public/kringlumyndir/24703-1_5.jpg?itok=C7ME5Bec";

    public NetworkController()
    {

    }

    public List<Program> loadProgramFromRuv(LocalDate date)
    {
        String url = RUV_JSON_URL + date.format(DateTimeFormatter.BASIC_ISO_DATE);

        String responseBody = getResponseFromURL(url);

        Gson gson = new GsonBuilder().create();
        Sarpur sarpur = gson.fromJson(responseBody, Sarpur.class);
        List<Entry> entries = sarpur.getEntries();

        List<Program> urls = new ArrayList<>(entries.size());
        for (Entry entry : entries)
        {
            urls.add(new Program(entry.getEvent()));
        }

        return urls;
    }

    public static Image downloadImage(String urlString)
    {
        String[] split = urlString.split("/");
        String name = StringUtils.substringBefore(split[split.length - 1], "?");
        String format = StringUtils.substringAfter(name, ".");

        BufferedImage image = null;
        try
        {
            URL url = new URL(urlString);
            image = ImageIO.read(url);

            ImageIO.write(image, format, new File("Images\\" + name));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }

        return image;
    }

    public static String getProgramHtmlResponse(Program program)
    {
        return getResponseFromURL(program.pageUrl);
    }

    // TODO exception handling
    private static String getResponseFromURL(String urlString)
    {
        String response = null;
        BufferedReader br = null;

        try
        {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();

            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            response = IOUtils.toString(br);

            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return response;
    }
}