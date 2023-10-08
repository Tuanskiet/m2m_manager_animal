package com.poly.World_animal.service;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class FirebaseService {
    public static String FIREBASE_SDK_JSON = "./firebase-adminsdk.json";
    public static String FIREBASE_BUCKET = "m2m-animals.appspot.com";
    public static String FIREBASE_PROJECT_ID = "m2m-animals";

    // maxsize : 1048576 bytes.
    public String uploadFile(MultipartFile multipartFile, String folder) throws IOException {
        String objectName = folder +  generateFileName(multipartFile);

        FileInputStream serviceAccount = new FileInputStream(FIREBASE_SDK_JSON);

        byte[] fileBytes = multipartFile.getBytes();

        Storage storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setProjectId(FIREBASE_PROJECT_ID).build()
                .getService();

        BlobId blobId = BlobId.of(FIREBASE_BUCKET, objectName);

        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(multipartFile.getContentType()).build();

        Blob blob = storage.create(blobInfo, fileBytes);

        //generate link download
//        Acl publicReadAcl = Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER);
//        storage.createAcl(blob.getBlobId(), publicReadAcl);
//        return blob.getMediaLink();


        //link access
        URL signedUrl = blob.signUrl(365, TimeUnit.DAYS);// duration access : 365 days

        System.out.println("link access : " + signedUrl.toString());
        return signedUrl.toString();
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" +
                Objects.requireNonNull(multiPart.getOriginalFilename())
                        .replace(" ", "_");
    }

}