package uz.d4uranbek.url_shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.d4uranbek.url_shortener.entity.UrlEntity;


/**
 * @author D4uranbek
 * @since 08.08.2022
 */
@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    UrlEntity findByShortUrl(String shortUrl);

}

