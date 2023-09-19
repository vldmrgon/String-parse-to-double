package microbenchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import com.company.ge.MyDouble;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1)
public class CheckDouble {

    private String message = "123456";
    private MyDouble myDouble;

    @Setup
    public void initObjectTest() {
        myDouble = new MyDouble();
    }

    @Benchmark
    public void myMethod() {
        double result = myDouble.parseToDouble(message);
    }

    @Benchmark
    public void defaultMethod() {
        double result = Double.parseDouble(message);
    }
}