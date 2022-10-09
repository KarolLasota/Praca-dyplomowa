package com.lasota.praca_dyplomowa.classes;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GetFiles {

   ArrayList<File> fileList;

    public GetFiles(){
        fileList = new ArrayList<>();
    }

    public int getSizeFileList(){
       return fileList.size();
    }

    public void getAllFilesFromDirectoryName(String directory){
        try{
            File dir = new File(directory);
            ArrayList<File> fileList2 = new ArrayList<>(Arrays.asList((Objects.requireNonNull(dir.listFiles()))));
            if(fileList2.size() >0 ){
                for(int i=0; i<fileList2.size(); i++){
                    if(fileList2.get(i).isFile()){
                        fileList.add(fileList2.get(i));
                    }
                    else if (fileList2.get(i).isDirectory()){
                        getAllFilesFromDirectoryName(fileList2.get(i).getAbsolutePath());
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void showFilesFromDirectory(){
        for(File file : fileList){
            System.out.println(file.getName());
        }
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }
}
