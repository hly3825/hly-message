package hly.message.hly.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.component.DataRecord;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import java.util.Date;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasicModel extends DataRecord {
    private static final int DEFAULT_ALLOCATION_SIZE = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "hibernate_sequences")
    @TableGenerator(name = "hibernate_sequences", allocationSize = DEFAULT_ALLOCATION_SIZE)
    @Field(title = "唯一标示")
    protected Long id;

    /**
     * 创建时间
     */
    @Field(title = "创建时间")
    @CreationTimestamp
    protected Date createdAt;

    /**
     * 最后一次修改时间
     */
    @Field(title = "最后更新时间")
    @UpdateTimestamp
    protected Date updatedAt;
}
