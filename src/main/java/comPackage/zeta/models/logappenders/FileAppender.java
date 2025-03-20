package comPackage.zeta.models.logappenders;

import comPackage.zeta.models.LogMessage;

import java.io.FileWriter;

public class FileAppender implements LogAppender{
//    private final String filePath;
//
//    public FileAppender(String filePath) {
//        this.filePath = filePath;
//    }

    @Override
    public void append(LogMessage logMessage) {
//        try(FileWriter fw = new FileWriter()) {
            // writing to a file
//        }
//        catch{

//        }
        if(!logMessage.getContent().isEmpty()){
            System.out.println("writing to a file: "+logMessage);
        }

    }
}
