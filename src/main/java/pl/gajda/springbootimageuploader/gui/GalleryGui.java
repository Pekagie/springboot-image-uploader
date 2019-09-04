package pl.gajda.springbootimageuploader.gui;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.gajda.springbootimageuploader.model.Image;
import pl.gajda.springbootimageuploader.repo.ImageRepo;

import java.util.List;

@Route("gallery")
public class GalleryGui extends VerticalLayout {

    private ImageRepo imageUploader;

    @Autowired
    public GalleryGui(ImageRepo imageUploader) {
        this.imageUploader = imageUploader;

       List<Image> all =  imageUploader.findAll();

       all.stream().forEach(element -> {
           com.vaadin.flow.component.html.Image image =
                   new com.vaadin.flow.component.html.Image(element.getImageAdress(), "brak");
           add(image);
       });
    }
}
