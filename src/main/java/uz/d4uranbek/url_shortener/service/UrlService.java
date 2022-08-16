package uz.d4uranbek.url_shortener.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.d4uranbek.url_shortener.dto.ShortUrlDTO;
import uz.d4uranbek.url_shortener.dto.UrlCreateDTO;
import uz.d4uranbek.url_shortener.entity.UrlEntity;
import uz.d4uranbek.url_shortener.mapper.UrlMapper;
import uz.d4uranbek.url_shortener.repository.UrlRepository;
import uz.d4uranbek.url_shortener.validator.RequestValidator;

/**
 * @author D4uranbek
 * @since 08.08.2022
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UrlService {
    private final RequestValidator validator;
    private final ShortenService shortenService;
    private final UrlRepository urlRepository;

    private final UrlMapper urlMapper;

    public ShortUrlDTO shorten( UrlCreateDTO urlCreateDTO ) {
        validator.validate( urlCreateDTO );
        String longUrl = urlCreateDTO.getLongUrl();
        String shortUrl = shortenService.getShort( longUrl );

        UrlEntity urlEntity = UrlEntity.builder()
                .longUrl( longUrl )
                .shortUrl( shortUrl )
                .build();
        UrlEntity saved = urlRepository.save( urlEntity );
        return urlMapper.toDTO( saved );
    }

    public String getLongUrl( String shortUrl ) {
        UrlEntity byShortUrl = urlRepository.findByShortUrl( shortUrl );
        String longUrl = byShortUrl.getLongUrl();
        return longUrl;
    }
}
