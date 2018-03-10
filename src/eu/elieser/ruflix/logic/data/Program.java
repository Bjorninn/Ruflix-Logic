package eu.elieser.ruflix.logic.data;

import eu.elieser.ruflix.logic.data.json.Event;
import eu.elieser.ruflix.logic.data.json.RecordWeb;
import eu.elieser.ruflix.logic.network.NetworkController;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.util.concurrent.TimeUnit;

public class Program
{
    public final int id;
    public final int seriesId;
    public final int channel;

    public final long duration;
    public final Instant startTime;
    public final Instant endTime;
    public final Instant expirationDate;

    public final String title;
    public final String description;
    public final String mediaReference;

    public final int scope;
    public final int episodeNumber;
    public final int episodeCount;

    public final RecordWeb recordWeb;

    public final String mediaUrl;
    public final String pageUrl;
    public final String pictureUrl;
    public final String pictureName;

    public Program(Event event)
    {
        id = Integer.parseInt(event.getEventId());

        if (event.getSerieId() == null)
        {
            seriesId = -1;
        }
        else
        {
            seriesId = Integer.parseInt(event.getSerieId());
        }

        channel = Integer.parseInt(event.getChannel());

        title = event.getTitle();
        description = event.getDescription();
        mediaReference = event.getMediaRef();

        scope = Integer.parseInt(event.getScope());
        episodeNumber = Integer.parseInt(event.getEpisodeNumber());
        episodeCount = Integer.parseInt(event.getNumberOfEpisodes());

        recordWeb = event.getRecordWeb();

        if (recordWeb == RecordWeb.ALLOWED)
        {
            mediaUrl = NetworkController.RUV_MEDIA_URL + event.getMedia() + NetworkController.STREAM_EXTENSION;
        }
        else
        {
            mediaUrl = null;
        }

        pageUrl = event.getUrl();
        pictureUrl = event.getPicture();

        if (pictureUrl != null)
        {
            String[] split = pictureUrl.split("/");
            pictureName = StringUtils.substringBefore(split[split.length - 1], "?");
        }
        else
        {
            pictureName = null;
        }

        long startUnix = Long.parseLong(event.getStartTime());
        startTime = Instant.ofEpochSecond(startUnix);

        long endUnix = Long.parseLong(event.getEndTime());
        endTime = Instant.ofEpochSecond(endUnix);

        if (event.getExpires() == null)
        {
            expirationDate = null;
        }
        else
        {
            long expUnix = Long.parseLong(event.getExpires());
            expirationDate = Instant.ofEpochSecond(expUnix);
        }

        String[] durationSplit = event.getFieldDuration().split(":");
        int hours = Integer.valueOf(durationSplit[0]);
        int minutes = Integer.valueOf(durationSplit[1]);
        int seconds = Integer.valueOf(durationSplit[2]);

        duration = TimeUnit.HOURS.toSeconds(hours) + TimeUnit.MINUTES.toSeconds(minutes) + seconds;
    }


    @Override
    public String toString()
    {
        return "Program{" +
                "id=" + id +
                ", seriesId=" + seriesId +
                ", channel=" + channel +
                ", duration=" + duration +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", expirationDate=" + expirationDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", mediaReference='" + mediaReference + '\'' +
                ", scope=" + scope +
                ", episodeNumber=" + episodeNumber +
                ", episodeCount=" + episodeCount +
                ", recordWeb=" + recordWeb +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", pageUrl='" + pageUrl + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
