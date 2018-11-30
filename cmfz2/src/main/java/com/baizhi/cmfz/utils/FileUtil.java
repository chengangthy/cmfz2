package com.baizhi.cmfz.utils;


import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;

public class FileUtil {
    public static String getDuration(File file) {
        try {
            MP3File f = (MP3File) AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
            int length = audioHeader.getTrackLength();
            String length1= String.valueOf(length/60);
            String length2= String.valueOf(length%60);
            String langg= length1+":分"+length2+"秒";
            return langg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
