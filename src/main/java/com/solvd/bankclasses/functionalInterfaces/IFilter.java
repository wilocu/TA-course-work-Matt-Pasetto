package com.solvd.bankclasses.functionalInterfaces;

@FunctionalInterface
public interface IFilter<T, R> {
    R filter(T item);
}