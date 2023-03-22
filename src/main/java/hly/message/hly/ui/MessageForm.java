package hly.message.hly.ui;

import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.ui.components.form.Form;
import hly.message.hly.model.Message;
import hly.message.hly.repo.MessageRepo;
import lombok.RequiredArgsConstructor;

@UIComponent
@RequiredArgsConstructor
public class MessageForm implements Form<Message> {

    private final MessageRepo messageRepo;

    @RecordAction(name = "提交")
    public void submit(Message message) {
        messageRepo.save(message);
    }
}
