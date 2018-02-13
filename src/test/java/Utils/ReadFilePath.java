package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadFilePath {
    static String fileType=null;
    static String mimeType=null;
    static String fileName;
    static String fileExtension;
    static String end ="Illegal File Type";
    public static List<String> regNumber=new ArrayList<>();

    public static String nameOfFile(String filePath) {
        File file = new File(filePath);
        fileName = file.getName();
        return fileName;
    }

    public static String returnFileExtension(String file){
        String fileType="";
        String[] splitting = file.split("\\.");
        fileType = splitting[1];
        return fileType;
    }

    public static void returnMimeType(String file){

        String[] splitting = file.split("\\.");
        fileType = splitting[1];

        switch (fileType){
            case "DOCX": mimeType = "office document file type";
            break;
            case "docx": mimeType = "office document file type";
            break;
            case "CSS": mimeType = "css file type";
            break;
            case "css": mimeType = "css file type";
            break;
            case "CSV": mimeType = "csv file type";
            break;
            case "csv": mimeType = "csv file type";
            break;
            case "DOC": mimeType = "office document file type - msword";
            break;
            case "doc": mimeType = "office document file type - msword";
            break;
            default:mimeType = "Not sure about this";
            break;


        }

        System.out.println("Mime type is: "+ mimeType);
    }

    public static String fileType(String file, String endText) {
        String[] splitting = file.split("\\.");
        String[] acceptedFileType = {"xlsx", "csv"};
        int l = splitting.length;
        for (int i = 0; i < acceptedFileType.length; i++) {
            if (acceptedFileType[i].equalsIgnoreCase(splitting[1])) {
                if (splitting[1].equalsIgnoreCase(endText)) {
                    end = endText;
                }
            }
        }
        return end;
    }

    public static void getFileSize(String path) {
        File file = new File(path);
        System.out.println("File size in bytes is  :" + file.length());
    }

    public static void returnFileProperties(String file){
        System.out.println("File name is :"+nameOfFile(file));
        System.out.println("File extension type is :"+returnFileExtension(file));
        returnMimeType(file);
        getFileSize(file);

    }

    public static void readCsvFile(){
        String fileLine = "";
        int row = 0;
        returnMimeType("VehicleReg.csv");
        try {
            FileReader fl = new FileReader("VehicleReg.csv");


            if(mimeType != "Not sure about this") {
                BufferedReader reader = new BufferedReader(fl);

                while ((fileLine = reader.readLine()) != null) {
                    if(fileLine.equals("")){
                        break;
                    }
                        String[] vehicleDetails = fileLine.split(",");

                        regNumber.add(vehicleDetails[2]);


                }
            }
        }

        catch(Exception ex){
            ex.printStackTrace();
        }
    }



}
