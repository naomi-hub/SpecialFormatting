package com.company;

import java.util.ArrayList;
import java.util.Random;

public class FileFormatting {
    private Random rand = new Random();

    public String parseString(String str) {
        String[] delimiterColon = str.split(":");
        String result = "";
        if (delimiterColon[1] != null) {
            char[] chars = delimiterColon[1].toCharArray();
            try {
                String[] minMax = delimiterColon[1].split("]");
                if (minMax[1] != null) {
                    String[] extractedInt = minMax[1].split(",");
                    int min = Integer.parseInt(extractedInt[0].replace("[", ""));
                    int max = Integer.parseInt(extractedInt[1]);
                    int randomNum = rand.nextInt((max - min) + 1) + min;
                    for (int i = 0; i < randomNum; i++) {
                        int randomChar = rand.nextInt((chars[3] - chars[1]) + 1) + chars[1];
                        result += (char) randomChar;
                    }
                }
            } catch (NumberFormatException e) {
                return str;
            }
        }
        return result;
    }


    /**
     * split at the colon so we would have two arrays, then the first element would be i: and the second would be
     * [67,467]%. we split the already split array into by the,which would give us two strings, one [67 and another
     * 467]
     *
     * @param format
     * @return
     */
    public String parseInteger(String format) {
        String one = "";
        try {
            String[] formattedArray = format.split(":");
            if (formattedArray[1] != null) {
                String[] minAndMax = formattedArray[1].split(",");
                int min = Integer.parseInt(minAndMax[0].replace("[", ""));
                int max = Integer.parseInt(minAndMax[1].replace("]%", ""));
                one += rand.nextInt(max - min + 1) + min;
            }
        } catch (NumberFormatException e) {
            return format;
        }
        return one;
    }

    public String parseDouble(String format) {
        String[] formatArray = format.split(":");
        String res = "";
        try {
            if (formatArray[1] != null) {
                String[] minMax = formatArray[1].split(",");
                String minString = minMax[0].replace("[", "");
                Integer.parseInt(minString);
                String maxString = minMax[1].replace("]%", "");
                res += Integer.parseInt(minString) + (Integer.parseInt(maxString) - Integer.parseInt(minString)) * rand.nextDouble();
            }
        } catch (NumberFormatException e) {
            return format;
        }
        return res;
    }

    public ArrayList<String> formattedArray(ArrayList<String> file) {
        ArrayList<String> resultArray = new ArrayList();

        for (int i = 0; i < file.size(); ++i) {
            if ((file.get(i)).startsWith("%s:[")) {
                resultArray.add(parseString(file.get(i)));
            } else if ((file.get(i)).startsWith("%i:[")) {
                resultArray.add(parseInteger(file.get(i)));
            } else if (file.get(i).startsWith("%d:[")) {
                resultArray.add(parseDouble(file.get(i)));
            } else {
                resultArray.add(file.get(i));
            }
        }
        return resultArray;
    }

}
