package francescobuonocore.w6d5.repositories;

import francescobuonocore.w6d5.entities.Event;
import francescobuonocore.w6d5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long> {
    List<Event> findByUser(User user);
}
