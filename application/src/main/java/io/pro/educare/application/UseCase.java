package io.pro.educare.application;
public interface UseCase<In, Out> {
    Out execute(In in) throws Exception;
}
