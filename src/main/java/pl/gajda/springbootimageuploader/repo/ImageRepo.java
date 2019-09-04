package pl.gajda.springbootimageuploader.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gajda.springbootimageuploader.model.Image;

public interface ImageRepo extends JpaRepository<Image, Long> {

    
}
