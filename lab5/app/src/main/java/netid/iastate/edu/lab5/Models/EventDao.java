package netid.iastate.edu.lab5.Models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

@Dao
public interface EventDao {

    // create a @Query to get all events that returns a List<Event> type
    @Query("SELECT * FROM event")
    public List<Event> getAll();

    // create a @Query to get an event by ID that returns a Event type
    @Query("SELECT * FROM event WHERE uid = :id")
    public Event getEventBy(int id);

    // create an @Insert for an event object
    @Insert
    public void insertEvent(Event... events);

    // create an @Delete for an event object
    @Delete
    public void deleteEvents(Event... events);

}

