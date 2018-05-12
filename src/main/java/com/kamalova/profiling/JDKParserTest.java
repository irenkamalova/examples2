package com.kamalova.profiling;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import oracle.jrockit.jfr.parser.*;

public class JDKParserTest {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {
        File recordingFile = new File("D:\\Projects\\examples2\\myrecording.jfr");
        File f = new File("D:\\Projects\\examples2\\parsedRecord.txt");
        Parser parser = new Parser(recordingFile);
        int count = 0;
        Iterator<ChunkParser> chunkIter = parser.iterator();
        while (chunkIter.hasNext()) {
            ChunkParser chunkParser = chunkIter.next();
            for (FLREvent event : chunkParser) {
                event.getProducerId();
                event.getTimestamp();
                count++;
                //System.out.println(event.toString()); 
            }
        }
        parser.close();
        System.out.println("Found " + count + " events");
    }
}