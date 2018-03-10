
package eu.elieser.ruflix.logic.data.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Event
{
    @SerializedName("event_id")
    @Expose
    private String eventId;
    @SerializedName("serie_id")
    @Expose
    private String serieId;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("expires")
    @Expose
    private String expires;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("episode_number")
    @Expose
    private String episodeNumber;
    @SerializedName("number_of_episodes")
    @Expose
    private String numberOfEpisodes;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("media")
    @Expose
    private String media;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("record_web")
    @Expose
    private RecordWeb recordWeb;
    @SerializedName("media_ref")
    @Expose
    private String mediaRef;
    @SerializedName("field_duration")
    @Expose
    private String fieldDuration;

    public String getEventId()
    {
        return eventId;
    }

    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }

    public String getSerieId()
    {
        return serieId;
    }

    public void setSerieId(String serieId)
    {
        this.serieId = serieId;
    }

    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getExpires()
    {
        return expires;
    }

    public void setExpires(String expires)
    {
        this.expires = expires;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getScope()
    {
        return scope;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }

    public String getEpisodeNumber()
    {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber)
    {
        this.episodeNumber = episodeNumber;
    }

    public String getNumberOfEpisodes()
    {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(String numberOfEpisodes)
    {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getMedia()
    {
        return media;
    }

    public void setMedia(String media)
    {
        this.media = media;
    }

    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public RecordWeb getRecordWeb()
    {
        return recordWeb;
    }

    public void setRecordWeb(RecordWeb recordWeb)
    {
        this.recordWeb = recordWeb;
    }

    public String getMediaRef()
    {
        return mediaRef;
    }

    public void setMediaRef(String mediaRef)
    {
        this.mediaRef = mediaRef;
    }

    public String getFieldDuration()
    {
        return fieldDuration;
    }

    public void setFieldDuration(String fieldDuration)
    {
        this.fieldDuration = fieldDuration;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}