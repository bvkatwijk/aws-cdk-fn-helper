package nl.bvkatwijk.awscdkfnhelper;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class Generator {
    public static void main(String[] args) {
        new Generator().run();
    }

    @SneakyThrows
    private void run() {
        var path = Path.of(this.getClass().getResource("Fn.java").toURI());
        var file = Files.readString(path);
    }

    public record Method() { }
    public record MethodSource() { }
}
