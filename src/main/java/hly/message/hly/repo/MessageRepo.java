package hly.message.hly.repo;

import hly.message.hly.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepo extends JpaRepository<Message, Long> {
    @Query(nativeQuery = true, value = "select * from message m order by m.created_at desc limit 1")
    Message findLastestOne();
}
