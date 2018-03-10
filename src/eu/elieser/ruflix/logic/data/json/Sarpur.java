
package eu.elieser.ruflix.logic.data.json;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Sarpur
{
    @SerializedName("server_time")
    @Expose
    private Integer serverTime;
    @SerializedName("events")
    @Expose
    private List<Entry> entries = null;

    public Integer getServerTime()
    {
        return serverTime;
    }

    public void setServerTime(Integer serverTime)
    {
        this.serverTime = serverTime;
    }

    public List<Entry> getEntries()
    {
        return entries;
    }

    public void setEntries(List<Entry> entries)
    {
        this.entries = entries;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}