package uz.d4uranbek.url_shortener.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
public class ShortUrlDTO {

    @JsonProperty("short_url")
    private String shortUrl;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

}
