package com.projectgalen.gnustep.cmdline;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        try {
            /*
             * Remove Duplicates
             */
            Set<String> argSet = new TreeSet<>();
            for (int i = 0; i < args.length; i++) {
                argSet.add(args[i]);
            }

            for (String s : argSet) {
                System.out.printf("Arg> \"%s\"%n", s);
            }

            System.exit(0);
        } catch (Exception e) {
            System.err.printf("EXCEPTION: %s%n", e.getMessage());
            System.exit(1);
        }
    }
}
