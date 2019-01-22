package ru.job4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveProjects {
    private void Archive(String path) {
        try (
                ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("c:\\Projects\\out.zip"));
                FileInputStream fs = new FileInputStream(path);
                ) {
            ZipEntry entry1=new ZipEntry("notes.txt");
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fs.available()];
            fs.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArchiveProjects ap = new ArchiveProjects();
        ap.Archive("C:\\Users\\aprozorov\\IdeaProjects\\rukejam");
        if (new File("c:\\Projects\\out.zip").exists()) {
            System.out.println("Archive exist");
        }
    }
}
