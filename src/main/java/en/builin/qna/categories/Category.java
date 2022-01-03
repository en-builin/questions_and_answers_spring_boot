package en.builin.qna.categories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "categories")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Category parent;
    @Column(length = 150)
    private String name;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
