package eu.elieser.ruflix.logic.utils;

import java.io.*;
import java.util.Properties;

public final class FileLoader
{
    private static final String pathname = "config.properties";

    public static boolean hasPropertyFile()
    {
        File f = new File(pathname);

        return f.isFile();
    }

    public static void saveToPropertyFile(Properties prop)
    {
        OutputStream output = null;

        try
        {
            output = new FileOutputStream(pathname);

            // save properties to project root folder
            prop.store(output, null);
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
        finally
        {
            if (output != null)
            {
                try
                {
                    output.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void createPropertyFile()
    {
        saveToPropertyFile(new Properties());
    }

    public static Properties getPropertyFile()
    {
        Properties prop = new Properties();
        InputStream input = null;

        try
        {
            input = new FileInputStream(pathname);
            prop.load(input);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return prop;
    }
}
