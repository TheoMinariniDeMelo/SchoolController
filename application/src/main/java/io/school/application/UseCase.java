package io.school.application;
public interface UseCase<In, Out> {
    Out execute(In in);
}
