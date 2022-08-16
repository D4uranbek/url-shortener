package uz.d4uranbek.url_shortener.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.d4uranbek.url_shortener.dto.ShortUrlDTO;
import uz.d4uranbek.url_shortener.entity.UrlEntity;

/**
 * @author D4uranbek
 * @since 16.08.2022
 */
@Component
@Mapper( componentModel = "spring" )
public interface UrlMapper {

    ShortUrlDTO toDTO( UrlEntity entity );
}
