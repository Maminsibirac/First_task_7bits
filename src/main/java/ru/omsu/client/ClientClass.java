package ru.omsu.client;


import org.apache.log4j.Logger;
import ru.omsu.formatter_code.FormatterJavaCode;
import ru.omsu.reader.file.ReaderFile;
import ru.omsu.reader.stream.IReaderStream;
import ru.omsu.writer.file.WriterFile;
import ru.omsu.writer.stream.IWriterStream;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class ClientClass {
    private static final Logger logger = Logger.getLogger(ClientClass.class);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ReaderFile readerFile;
        WriterFile writerFile;
        String fileName = new String();
        FormatterJavaCode formatterJavaCode = new FormatterJavaCode();

        do {
            System.out.print("Enter the file name with the Java code: ");
            try {
                fileName = scan.nextLine();
            }
            catch(NoSuchElementException e) {
                logger.warn("Possibly the program crashes!");
            }
            readerFile = new ReaderFile(fileName);
        } while(!readerFile.existsFile());


        do {
            System.out.print("Enter the file name where to put the result: ");
            try {
                fileName = scan.nextLine();
            }
            catch(NoSuchElementException e) {
                logger.warn("Possibly the program crashes!");
            }

            writerFile = new WriterFile(fileName);
        } while(!writerFile.existsFile());

        formatterJavaCode.formatter(readerFile, writerFile);

        logger.info("Program is done!");
    }
}
