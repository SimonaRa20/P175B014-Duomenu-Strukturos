package edu.ktu.ds.lab2.demo;

import edu.ktu.ds.lab2.utils.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = TimeUnit.SECONDS)
public class Benchmark {

    @State(Scope.Benchmark)
    public static class FullSet {
        Car[] cars;
        BstSet<Car> carSet;
        @Setup(Level.Iteration)
        public void generateElements(BenchmarkParams params) {
            cars = Benchmark.generateElements(Integer.parseInt(params.getParam("elementCount")));
        }
    }

    @Param({"10000", "20000", "40000", "80000"})
    public int elementCount;

    static Car[] cars;

    @Setup(Level.Iteration)
    public void generateElements() {
        cars = generateElements(elementCount);
    }

    static Car[] generateElements(int count) {
        return new CarsGenerator().generateShuffle(count, 1.0);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public BstSet<Car> addAllBst() {
        BstSet<Car> carSet = new BstSet<>(Car.byPrice);
        addAllBstElements(cars, carSet);
        return carSet;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public AvlSet<Car> addAllAvl() {
        AvlSet<Car> carSet = new AvlSet<>(Car.byPrice);
        addAllAvlElements(cars, carSet);
        return carSet;
    }

    private void addAllAvlElements(Car[] cars, AvlSet<Car> carSet) {
        Set<Car> list = new AvlSet<>();
        for(Car car:cars) {
            list.add(car);
        }
        carSet.addAll(list);
    }

    private void addAllBstElements(Car[] cars, BstSet<Car> carSet) {
        Set<Car>list = new BstSet<>();
        for(Car car:cars) {
            list.add(car);
        }
        carSet.addAll(list);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
