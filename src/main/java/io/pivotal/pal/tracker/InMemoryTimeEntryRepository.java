package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();
    private long counter = 0;


    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        counter = counter+1;
        timeEntry.setId(counter);
        timeEntryMap.put(counter, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {

        return timeEntryMap.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryMap.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (timeEntryMap.containsKey(id)){
            timeEntry.setId(id);
            timeEntryMap.put(id, timeEntry);
           return timeEntry;
        }
        return null;
    }

    @Override
    public TimeEntry delete(long timeEntryId) {
        if (timeEntryMap.containsKey(timeEntryId)){
            timeEntryMap.remove(timeEntryId);
        }
        return null;
    }
}
