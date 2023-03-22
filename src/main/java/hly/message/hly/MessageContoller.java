package hly.message.hly;


import hly.message.hly.model.Message;
import hly.message.hly.repo.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hly/messager")
@RequiredArgsConstructor
public class MessageContoller {
    private final MessageRepo messageRepo;

    @GetMapping("/lastest")
    public Message findLastestOne() {
        return messageRepo.findLastestOne();
    }
}
