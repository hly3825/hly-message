package hly.message.hly.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.component.DataRecord;
import dev.fastball.core.info.basic.DisplayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "message")
public class Message extends DataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "hibernate_sequences")
    @TableGenerator(name = "hibernate_sequences", allocationSize = 10)
    @Field(title = "唯一标示", display = DisplayType.Hidden)
    private Long id;

    @Field(title = "发送者姓名", tips = "会在消息体之前带着发送者姓名`")
    @NotNull(message = "发送者姓名不能为空")
    private String senderName;

    @Field(title = "消息体内容")
    @NotNull(message = "消息体内容不能为空")
    private String messageContent;
    /**
     * 创建时间
     */
    @Field(title = "创建时间")
    @CreationTimestamp
    private Date createdAt;

    /**
     * 最后一次修改时间
     */
    @Field(title = "最后更新时间")
    @UpdateTimestamp
    private Date updatedAt;
}
