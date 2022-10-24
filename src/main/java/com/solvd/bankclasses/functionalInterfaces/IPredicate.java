package com.solvd.bankclasses.functionalInterfaces;

@FunctionalInterface
public interface IPredicate<T> {
    boolean test(T t);
}