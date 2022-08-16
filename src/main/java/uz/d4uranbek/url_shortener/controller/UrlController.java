package uz.d4uranbek.url_shortener.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.d4uranbek.url_shortener.dto.ShortUrlDTO;
import uz.d4uranbek.url_shortener.dto.UrlCreateDTO;
import uz.d4uranbek.url_shortener.service.UrlService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

/**
 * @author D4uranbek
 * @since 08.08.2022
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService service;

    @GetMapping( "/test" )
    public ResponseEntity<String> getTest() {
        log.info( "testing" );
        return new ResponseEntity<>( "Test method response", HttpStatus.OK );
    }

    @PostMapping( "/create" )
    public ResponseEntity<ShortUrlDTO> shorten( @RequestBody UrlCreateDTO urlCreateDTO ) {
        log.info( "creating new short" );
        ShortUrlDTO shortUrlDTO = service.shorten( urlCreateDTO );
        return new ResponseEntity<>( shortUrlDTO, HttpStatus.CREATED );
    }

    @GetMapping( "/{shortUrl}" )
    public ResponseEntity<Void> redirect( HttpServletResponse response,
                                          @PathVariable String shortUrl ) throws IOException {
        String longUrl = service.getLongUrl( shortUrl );
        log.info( "redirecting" );
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation( URI.create( longUrl ) );
        return new ResponseEntity<>( headers, HttpStatus.MOVED_PERMANENTLY );
    }

}
