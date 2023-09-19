package microbenchmark;

import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.Runner;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;

import lombok.SneakyThrows;

public class JmhConfiguration {

    public static void main(String[] args) {
        runMicrobenchmark(CheckDouble.class);
    }

    @SneakyThrows
    public static void runMicrobenchmark(List<Class<?>> classes) {
        new Runner(new OptionsBuilder().include(getBenchmarkNames(classes)).build()).run();
    }

    public static void runMicrobenchmark(Class<?> clazz) {
        runMicrobenchmark(Collections.singletonList(clazz));
    }

    private static String getBenchmarkNames(List<Class<?>> benchmarkClasses) {
        return benchmarkClasses.stream().map(Class::getSimpleName).collect(Collectors.joining("|"));
    }
}