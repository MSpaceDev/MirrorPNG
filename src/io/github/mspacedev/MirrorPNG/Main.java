package io.github.mspacedev.MirrorPNG;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © MSpace-Dev 2018
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class Main {
    private static List<String> listFilesForFolder(final File folder) {
        List<String> files = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            String extension;
            try {
                extension = fileEntry.getName().substring(fileEntry.getName().length() - 4, fileEntry.getName().length());
            } catch (Exception e){
                continue;
            }

            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else if((extension.equalsIgnoreCase(".png"))){
                files.add(fileEntry.getName().substring(0, fileEntry.getName().length() - 4));
            }
        }
        return files;
    }

    public static void main(String[] args) {
        ImageHandler imageHandler = new ImageHandler();

        String dir = ".";

        final File folder = new File(dir + "/");
        List<String> files = new ArrayList<>(listFilesForFolder(folder));

        for (String s : files){
            imageHandler.mirrorImage(s);
        }

        // JOptionPane.showMessageDialog(null, "Program finished running!");
    }
}
