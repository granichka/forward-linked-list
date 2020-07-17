package local.nix.forward.linked.list.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringListHandler {

    public static Integer getNumbersFromStringFirstWay(List<String> strings) {
        String result = "";

        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);

        List<String> list = strings.stream().map(s -> {
            int counter = 0;
            Matcher matcher = pattern.matcher(s);
            while(matcher.find()) {
                ++counter;
                if(counter > 1) {
                    s += matcher.group();
                } else {
                    s = matcher.group();
                }
            }
            return s;

        }).collect(Collectors.toList());


        for(String s: list) {
            result += s;
        }

        Integer value = Integer.valueOf(result);
        return value;
    }

    public static Integer getNumbersFromStringSecondWay(List<String> list) {

        List<String> list1 = list.stream().map(s -> {
            char[] arr = s.toCharArray();
            String result = "";

            for(char value: arr) {
                if(Character.isDigit(value)) {
                    result += value;
                }
            }

            return result;
        }).collect(Collectors.toList());

        String number = "";
        for(String s: list1) {
            number += s;
        }

        Integer value = Integer.valueOf(number);
        return value;

    }
}
