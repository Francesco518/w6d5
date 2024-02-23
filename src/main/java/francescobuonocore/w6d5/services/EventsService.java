package francescobuonocore.w6d5.services;

import francescobuonocore.w6d5.entities.Event;
import francescobuonocore.w6d5.entities.User;
import francescobuonocore.w6d5.exceptions.NotFoundException;
import francescobuonocore.w6d5.payloads.NewEventPayload;
import francescobuonocore.w6d5.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UsersService usersService;

    public Event save(NewEventPayload body) {
        User user = usersService.findById(body.getUserId());
        Event event = new Event();
        event.setTitle(body.getTitle());
        event.setDescription(body.getDescription());
        event.setDate(body.getDate());
        event.setLocation(body.getLocation());
        event.setAvailableSeats(body.getAvailableSeats());
        event.setUser(user);
        return this.eventsRepository.save(event);
    }
    public List<Event> getEvents() {
        return this.eventsRepository.findAll();
    }
    public Event findById(long id) {
        return this.eventsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public void findAndDelete(long id) {
        Event found = this.findById(id);
        this.eventsRepository.delete(found);
    }
    public Event findAndUpdate(long id, NewEventPayload newEvent) {
        Event found = this.findById(id);
        found.setTitle(newEvent.getTitle());
        found.setDescription(newEvent.getDescription());
        found.setDate(newEvent.getDate());
        found.setLocation(newEvent.getLocation());
        found.setAvailableSeats(newEvent.getAvailableSeats());


        if (found.getUser().getId()!= newEvent.getUserId()) {
            User brandNewDevice = usersService.findById(newEvent.getUserId());
            found.setUser(brandNewDevice);
        }
        return eventsRepository.save(found);
    }
    public List<Event> findByUser(int user_id) {
        User user = usersService.findById(user_id);
        return eventsRepository.findByUser(user);
    }
}
