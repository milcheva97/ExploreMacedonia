package main.java.com.exploreCity.service.impl;

import main.java.com.exploreCity.model.About;
import main.java.com.exploreCity.repository.AboutRepository;
import main.java.com.exploreCity.service.AboutService;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;

    public AboutServiceImpl(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @Override
    public About getAboutMacedoniaInfo(String aboutURI) {
        About about = new About();
        this.aboutRepository.addMacedoniaInfo(aboutURI);
        return about;
    }
}
