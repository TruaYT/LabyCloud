package dev.trua;

public class Bootstrap {

    public static void main(String[] args) {
        // install colors
        AnsiConsole.systemInstall();

        final var cloudNode = new CloudNode();

        // shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(cloudNode::stop));
    }
}
