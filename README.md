

```
# JMH version: 1.27
# VM version: JDK 13.0.12, OpenJDK 64-Bit Server VM, 13.0.12+4-MTS
# VM invoker: /home/dev/.jdks/azul-13.0.12/bin/java
# VM options: -javaagent:/home/dev/.local/share/JetBrains/Toolbox/apps/IDEA-C
# JMH blackhole mode: full blackhole + dont-inline hint

# Warmup: 5 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: microbenchmark.CheckDouble.defaultMethod
```

### Run complete. Total time: 00:02:39

```
Benchmark                  Mode  Cnt   Score   Error  Units
CheckDouble.defaultMethod  avgt   50  40.778 ± 1.609  ns/op
CheckDouble.myMethod       avgt   50  27.848 ± 0.832  ns/op
```
