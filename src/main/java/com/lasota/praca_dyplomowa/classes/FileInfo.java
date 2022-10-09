package com.lasota.praca_dyplomowa.classes;


public class FileInfo {
    String fileName;
    String checksum;
    String duplicateFiles;

    public FileInfo() {

    }

    public FileInfo(String fileName, String checksum, String duplicateFiles) {
        this.fileName = fileName;
        this.checksum = checksum;
        this.duplicateFiles = duplicateFiles;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getDuplicateFiles() {
        return duplicateFiles;
    }

    public void setDuplicateFiles(String duplicateFiles) {
        this.duplicateFiles = duplicateFiles;
    }
}
