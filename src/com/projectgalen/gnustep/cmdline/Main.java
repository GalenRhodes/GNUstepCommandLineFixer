package com.projectgalen.gnustep.cmdline;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            boolean first = true;
            boolean semi = false;
            String regex = "^-fobjc-runtime\\=(gnustep)-([0-9]+\\.[0-9]+)";

            /*
             * Remove Duplicates
             */
            Set<String> argSet = new LinkedHashSet<>();
            List<String> argList = new ArrayList<>();
            Pattern p = Pattern.compile(regex);

            Collections.addAll(argSet, args);

            for(String s : argSet) {
                if(p.matcher(s).find()) argList.add(s);
            }

            if(argList.size() > 1) {
                Collections.sort(argList);
                argList.remove((argList.size() - 1));
                argSet.removeAll(argList);
            }

            try {
                semi = Boolean.getBoolean("com.projectgalen.gnustep.cmdline.semicolonseparator");
            }
            catch(Exception e) { System.err.println(e.getMessage()); }

            for(String s : argSet) {
                String item = s.replace("\\", "\\\\");

                if(semi) {
                    if(first) first = false;
                    else System.out.print(';');
                    System.out.print(item.replace(";", "\\;"));
                }
                else {
                    if(first) first = false;
                    else System.out.print(' ');
                    System.out.print(item.replace(" ", "\\ "));
                }
            }

            System.out.print(System.lineSeparator());
            System.exit(0);
        }
        catch(Exception e) {
            System.err.printf("EXCEPTION: %s%n", e.getMessage());
            System.exit(1);
        }
    }

}
