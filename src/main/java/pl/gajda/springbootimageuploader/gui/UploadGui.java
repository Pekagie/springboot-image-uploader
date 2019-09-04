package pl.gajda.springbootimageuploader.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.gajda.springbootimageuploader.ImageUploader;

@Route("upload-image")
public class UploadGui extends VerticalLayout {

    private ImageUploader imageUploader;

    @Autowired
    public UploadGui(ImageUploader imageUploader) {
        this.imageUploader = imageUploader;

        Label label = new Label();
//        TextField textField = new TextField();


        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);

        upload.addSucceededListener(event -> {
            String uploadedImage = imageUploader.uploadFileAndSaveToDb(event.getFileName());
                    Image image = new Image(uploadedImage, "Nie ma obrazka :(");
                    label.setText("Upload udany!");
                    add(label);
                    add(image);
        });


//        Button button = new Button("UPLOAD");
//        button.addClickListener(buttonClickEvent ->
//                {
//                    String uploadedImage = imageUploader.uploadFileAndSaveToDb(textField.getValue());
//                    Image image = new Image(uploadedImage, "Nie ma obrazka :(");
//                    label.setText("Upload udany!");
//                    add(label);
//                    add(image);
//                });
        add(upload);
//        add(button);

    }
}
