package francescobuonocore.w6d5.controllers;

import francescobuonocore.w6d5.entities.Event;
import francescobuonocore.w6d5.payloads.NewEventPayload;
import francescobuonocore.w6d5.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventsService eventsService;

    @GetMapping
    public List<Event> getEvents(@RequestParam(required = false) Integer userId) {
        if (userId != null)
            return eventsService.findByUser(userId);
        else {
            return eventsService.getEvents();
        }
    }
    @GetMapping("/{eventId}")
    public Event findById(@PathVariable long eventId) {
        return eventsService.findById(eventId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event saveEvents(@RequestBody NewEventPayload newEvent) {
        return eventsService.save(newEvent);
    }
    @PutMapping("/{eventId}")
    public Event findAndUpdate(@PathVariable long eventId, @RequestBody NewEventPayload newEvent) {
        return eventsService.findAndUpdate(eventId, newEvent);
    }
    @DeleteMapping("/{eventId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable long eventId) {
        this.eventsService.findAndDelete(eventId);
    }
}
