package uz.d4uranbek.url_shortener.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.d4uranbek.url_shortener.dto.UrlCreateDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/**
 * @author D4uranbek
 * @since 08.08.2022
 */
@Component
@RequiredArgsConstructor
public class RequestValidator {

    public void validate( UrlCreateDTO urlCreateDTO ) {
        String longUrl = urlCreateDTO.getLongUrl();
        if ( Objects.isNull( longUrl ) || longUrl.isBlank() ) {
            throw new RuntimeException( "Url is empty" );
        }
        try {
            new URI( longUrl );
        } catch ( URISyntaxException e ) {
            throw new RuntimeException( "Invalid url" );
        }
    }
}
