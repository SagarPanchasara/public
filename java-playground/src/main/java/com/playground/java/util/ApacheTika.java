package com.playground.java.util;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.mime.MimeTypesFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class ApacheTika {

    private final static String FILE_PATH = "D:\\Work\\playground\\java-playground\\src\\main\\resources\\static\\sample.bmp";

    private final static String DOC = "D:\\Work\\playground\\java-playground\\src\\main\\resources\\org.apache.tika.mime\\custom-mimetypes.xml.xml";

    public static void main(String[] args) throws Exception {
        System.out.println("Required type is 'image/x-ms-bmp'");

        MimeTypes mimeTypes = MimeTypesFactory.create(new File(DOC).toURI().toURL());

        Metadata metaData = new Metadata();
        metaData.set(TikaCoreProperties.RESOURCE_NAME_KEY, FILE_PATH);
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(FILE_PATH));
        MediaType detect1 = mimeTypes.detect(is, metaData);
        System.out.println("detect: " + detect1);
    }
}
