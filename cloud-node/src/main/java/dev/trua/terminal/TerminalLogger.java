package dev.trua.terminal;

import lombok.experimental.UtilityClass;

import java.awt.Color;

import static org.fusesource.jansi.Ansi.*;

@UtilityClass
public final class TerminalLogger {
    private final Color PRIMARY = new Color(66, 135, 245);

    private void print() {
        System.out.print("Input > ");
    }
    
    public void empty(String line) {
        if(line.isEmpty()) {
            System.out.print("\r");
            System.out.println();
        } else {
            System.out.println(ansi().fg(0).a("@").fg(PRIMARY.getRGB()).a("LabyCloud: ").fg(0).a(line));
        }
        print();
    }

    public void info(String line) {
        System.out.print("\r");
        System.out.println(ansi().fg(0).a("@").fg(PRIMARY.getRGB()).a("LabyCloud").fg(0).a(" - ").fg(PRIMARY.getRGB()).a("INFO: ").fg(0).a(line));
        print();
    }

    public void error(String line) {
        System.out.println(ansi().fg(0).a("@").fg(PRIMARY.getRGB()).a("LabyCloud").fg(0).a(" - ").fg(PRIMARY.getRGB()).a("INFO: ").fg(0).a(line));
        print();
    }
}
