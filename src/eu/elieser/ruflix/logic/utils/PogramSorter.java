package eu.elieser.ruflix.logic.utils;

import eu.elieser.ruflix.logic.data.Program;
import eu.elieser.ruflix.logic.type.SortingOrder;
import eu.elieser.ruflix.logic.type.SortingType;

import java.util.Comparator;
import java.util.List;

public class PogramSorter
{
    private final Comparator<Program> titleAsc = Comparator.comparing(o -> o.title);

    private final Comparator<Program> titleDesc = (o1, o2) -> o2.title.compareTo(o1.title);

    private final Comparator<Program> startTimeAsc = Comparator.comparing(o -> o.startTime);

    private final Comparator<Program> startTimeDesc = (o1, o2) -> o2.startTime.compareTo(o1.startTime);

    private final Comparator<Program> episodeNumberAsc = Comparator.comparingInt(o -> o.episodeNumber);

    private final Comparator<Program> episodeNumberDesc = (o1, o2) -> Integer.compare(o2.episodeNumber, o1.episodeNumber);

    public PogramSorter()
    {

    }

    public void SortPrograms(List<Program> programs, SortingType sortingType, SortingOrder order)
    {
        Comparator<Program> comp = null;

        switch (sortingType)
        {
            case EPISODE_NUMBER:
                comp = order == SortingOrder.ASCENDING ? episodeNumberAsc : episodeNumberDesc;
                break;
            case START_TIME:
                comp = order == SortingOrder.ASCENDING ? startTimeAsc : startTimeDesc;
                break;
            case TITLE:
                comp = order == SortingOrder.ASCENDING ? titleAsc : titleDesc;
                break;
            default:
                comp = titleAsc;
        }

        programs.sort(comp);
    }

}
