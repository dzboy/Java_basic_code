package com.ysoyso.generic.erased;

public class SubPair extends Pair<Employee> {
    @Override
    public void setT(Employee employee) {
        System.out.println("sub pair setT");
        this.t = employee;
    }
}
