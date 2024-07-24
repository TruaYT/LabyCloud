package dev.trua;

public class Bootstrap {

    public static void main(String[] args) {
        final CloudNode cloudNode = new CloudNode();;
        cloudNode.start();
        Runtime.getRuntime().addShutdownHook(new Thread(cloudNode::stop));
    }
}
