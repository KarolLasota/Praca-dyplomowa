import com.lasota.praca_dyplomowa.classes.GetFiles;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTest {
    String dirPath;

    @Before
    public void init() throws IOException {
        File dir = new File("folder");
        if(!dir.exists()) {
            dir.mkdirs();
            for(int i=0; i<10; i++){
                File firstFile = new File(dirPath+"/file"+i+".txt");
                firstFile.createNewFile();
            }
        }
        dirPath = dir.getAbsolutePath();
    }

    @Test
    public void testGetAllFilesFromDirec() {
        GetFiles getFiles = new GetFiles();
        getFiles.getAllFilesFromDirectoryName(dirPath);
        assertEquals(10,getFiles.getSizeFileList());

    }

}
