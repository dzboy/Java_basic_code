package com.ysoyso.generic.erased;

public class Demo {
    public static void main(String[] args) {
        Object employee = new Employee();
        Pair pair = new SubPair();
        pair.setT(employee);

        Object car = new Car();
        Parent parent = new Child();
        parent.set(car);

//        Car car = new Car();
//        Pair<Car> pair = new Pair<>();
//        CarPair<Car> carPair = new CarPair<>();
//
//        pair.setT(car);
//        carPair.setT(car);
//
//        Car car0 = pair.getT();
//        Car car1 = carPair.getT();
    }
}
