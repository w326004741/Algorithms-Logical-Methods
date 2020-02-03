package com.cbdmp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = readTxtContent();
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }

    public String solution(String S) {
        ArrayList<Integer> musicSizeList = new ArrayList<>();
        ArrayList<Integer> moviesSizeList = new ArrayList<>();
        ArrayList<Integer> imagesSizeList = new ArrayList<>();
        ArrayList<Integer> otherSizeList = new ArrayList<>();
        String[] split = S.split("\\\\");
        for (String str : split) {
            int i = str.indexOf(" ");
            String fileName = str.substring(0, i);
            int i1 = fileName.lastIndexOf(".");
            String fileType = fileName.substring(i1, i);
            String fileSize = str.substring(i + 1).replaceAll("b", "");
            if (isNumeric(fileSize)) {
                Integer num = Integer.valueOf(fileSize);
                if (movieMap.containsKey(fileType)) {
                    moviesSizeList.add(num);
                } else if (musicMap.containsKey(fileType)) {
                    musicSizeList.add(num);
                } else if (imagesMap.containsKey(fileType)) {
                    imagesSizeList.add(num);
                } else {
                    otherSizeList.add(num);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        int musicSize = musicSizeList.stream().mapToInt(Integer::intValue).sum();
        int movieSize = moviesSizeList.stream().mapToInt(Integer::intValue).sum();
        int imageSize = imagesSizeList.stream().mapToInt(Integer::intValue).sum();
        int otherSize = otherSizeList.stream().mapToInt(Integer::intValue).sum();
        sb.append("music " + musicSize + "b\n");
        sb.append("images " + imageSize + "b\n");
        sb.append("movies " + movieSize + "b\n");
        sb.append("other " + otherSize + "b");
        return sb.toString();
    }

    static String readTxtContent() {
        File file = new File("/Users/weichenwang/Year 1 - Master-GitRepository/Semester I/Algorithms-Logical-Methods/src/TestDemo/test-input.txt");
        if (file.isFile() && file.exists()) {
            try {
                // deserialization
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer sb = new StringBuffer();
                String text = null;
                while ((text = bufferedReader.readLine()) != null) {
                    sb.append(text);
//                    sb.append("\n");
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static final Map<String, String> musicMap;
    private static final Map<String, String> movieMap;
    private static final Map<String, String> imagesMap;

    static {
        musicMap = new HashMap<>();
        movieMap = new HashMap<>();
        imagesMap = new HashMap<>();
        musicMap.put(".mp3", "music");
        musicMap.put(".flac", "music");
        movieMap.put(".mp4", "movies");
        movieMap.put(".mkv", "movies");
        imagesMap.put(".png", "images");
        imagesMap.put(".jpg", "images");
        imagesMap.put(".jpeg", "images");
    }
}
