package dev.trua.template;

import dev.trua.terminal.TerminalLogger;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public final class TemplateHandler {
    private final static String paperURL = "https://api.papermc.io/v2/projects/paper/versions/1.20.1/builds/196/downloads/paper-1.20.1-196.jar";
    private final static String velocityURL = "https://api.papermc.io/v2/projects/velocity/versions/3.3.0-SNAPSHOT/builds/412/downloads/velocity-3.3.0-SNAPSHOT-412.jar";
    private final String template;

    public TemplateHandler(@NonNull final String template) {
        this.template = template;
    }


    @SneakyThrows
    public void copyToTemplate(@NonNull final String path) {
        if (!new File(path).exists()) {
            return;
        }
        FileUtils.copyDirectory(new File("./template/" + this.template + "/"), new File(path));

    }
    @SneakyThrows
    public void copyToTask(@NonNull final String path) {
        if (!new File(path).exists()) {
            return;
        }
        FileUtils.copyDirectory(new File(path), new File("./template/" + this.template + "/"));
    }

    @SneakyThrows
    public void installTemplate(boolean useProxy) {
        if (isExists()) {
            return;
        }
        new File("./template/" + this.template + "/").mkdirs();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(useProxy ? velocityURL : paperURL).openStream())) {
            final FileOutputStream fileOutputStream = new FileOutputStream("./template/" + this.template + "/server.jar");
            final byte[] bytes = new byte[1024];
            int readBytes;
            while ((readBytes = bufferedInputStream.read(bytes, 0, 1024)) != -1) {
                fileOutputStream.write(bytes, 0, readBytes);
            }
        } catch (IOException exception) {
            TerminalLogger.error(exception.getMessage());
        }
    }

    public boolean isExists() {
        return new File("./template/" + this.template + "/").exists();
    }
}
