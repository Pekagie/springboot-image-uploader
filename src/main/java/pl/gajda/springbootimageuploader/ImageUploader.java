package pl.gajda.springbootimageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gajda.springbootimageuploader.model.Image;
import pl.gajda.springbootimageuploader.repo.ImageRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {


    private static Cloudinary cloudinary;

    private ImageRepo imageRepo;

    @Autowired
    public ImageUploader(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "db2w8bmcq",
                "api_key", "289411656751478",
                "api_secret", "a9A2Em178BZXuKt4Po823ieH_MY"
        ));
    }

    public String uploadFileAndSaveToDb(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepo.save(new Image(uploadResult.get("url").toString()));
        } catch (IOException e) {
            // todo
        }
        return uploadResult.get("url").toString();
    }

    public static void main(String[] args) throws IOException {


    }
}
