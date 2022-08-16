package uz.d4uranbek.url_shortener.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author D4uranbek
 * @since 16.08.2022
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ShortenService {
    public String getShort( String longUrl ) {
        try {
            MessageDigest digest = MessageDigest.getInstance( "SHA-256" );
            byte[] hash = digest.digest( longUrl.getBytes( StandardCharsets.UTF_8 ) );
            return Base64.getEncoder().encodeToString( hash ).replaceAll( "[+=/]+", "" ).substring( 0, 8 );
        } catch ( NoSuchAlgorithmException e ) {
            throw new RuntimeException( "Server error" );
        }
    }
}
