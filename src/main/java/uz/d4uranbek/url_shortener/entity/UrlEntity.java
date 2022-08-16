package uz.d4uranbek.url_shortener.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author D4uranbek
 * @since 16.08.2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table( name = "url_table" )
public class UrlEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( unique = true )
    protected Long id;

    @Column( name = "user_id" )
    private Long userId;

    @Column( name = "long_url", length = 2048, nullable = false )
    private String longUrl;

    @Column( name = "short_url", length = 100, nullable = false, unique = true )
    private String shortUrl;

    @CreatedDate
    @CreationTimestamp
    @Column( name = "created_at", columnDefinition = "timestamp default now()" )
    private LocalDateTime createdAt;

}
