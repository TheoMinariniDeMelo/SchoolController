package io.pro.educare;

public @interface Production {
    enum Stage {
        IN_PRODUCTION, PRODUCED, NOT_STARTED
    }

    Stage value() default Stage.IN_PRODUCTION;
}
