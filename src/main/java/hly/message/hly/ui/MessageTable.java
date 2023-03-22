package hly.message.hly.ui;

import dev.fastball.core.annotation.*;
import dev.fastball.core.component.DataResult;
import dev.fastball.core.info.basic.PopupType;
import dev.fastball.ui.components.table.SearchTable;
import hly.message.hly.model.Message;
import hly.message.hly.repo.MessageRepo;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@UIComponent
@RequiredArgsConstructor
@ViewActions(@ViewAction(key = "new", name = "新增消息", popup = @Popup(value = @RefComponent(MessageForm.class), popupType = PopupType.Modal)))
@RecordViewActions(@ViewAction(key = "edit", name = "编辑", popup = @Popup(value = @RefComponent(MessageForm.class))))
public class MessageTable implements SearchTable<Message, Message> {

    private final MessageRepo messageRepo;

    @Override
    public DataResult<Message> loadData(Message search) {
        Collection<Message> messages = messageRepo.findAll();
        return DataResult.build(messages);
    }

    @RecordAction(name = "删除")
    public void deleteEmployee(Message message) {
        messageRepo.delete(message);
    }
}
