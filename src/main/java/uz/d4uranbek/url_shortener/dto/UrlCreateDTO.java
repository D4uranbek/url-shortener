package uz.d4uranbek.url_shortener.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author D4uranbek
 * @since 08.08.2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UrlCreateDTO {

    @JsonProperty( "long_url" )
    private String longUrl;

}
