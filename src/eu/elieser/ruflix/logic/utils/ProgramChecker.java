package eu.elieser.ruflix.logic.utils;

import eu.elieser.ruflix.logic.data.Program;
import eu.elieser.ruflix.logic.data.json.RecordWeb;
import eu.elieser.ruflix.logic.network.NetworkController;

import java.time.Instant;

public final class ProgramChecker
{

    public boolean checkProgramMediaAvailability(Program program, boolean checkHtml)
    {
        if (program.recordWeb == RecordWeb.DENIED)
        {
            return false;
        }

        if (program.expirationDate != null)
        {
            if (Instant.now().compareTo(program.expirationDate) > 0)
            {
                return false;
            }
        }
        else
        {
            return checkHtml(program);
        }

        if (checkHtml)
        {
            return checkHtml(program);
        }

        return true;
    }

    private boolean checkHtml(Program program)
    {
        if (program.mediaUrl == null)
        {
            return false;
        }
        else
        {
            String htmlResponse = NetworkController.getProgramHtmlResponse(program);

            return htmlResponse.contains(program.mediaUrl);
        }
    }
}
