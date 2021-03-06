package com.stuypulse.stuylib.streams.filters;

import com.stuypulse.stuylib.streams.filters.OnDerivative;
import com.stuypulse.stuylib.exception.ConstructionError;
import com.stuypulse.stuylib.math.SLMath;

/**
 * This class lets you rate limit a stream of inputs
 * 
 * That means that the value can not change more than a specified amount in one
 * update
 * 
 * @author Sam (sam.belliveau@gmail.com)
 */

public class RateLimit extends OnDerivative {

    /**
     * Makes a new rate limiter with specified rate limit
     * 
     * @param rateLimit desired rate limit
     */
    public RateLimit(double rateLimit) throws ConstructionError {
        super((x) -> SLMath.limit(x, rateLimit));

        if (rateLimit <= 0) {
            throw new ConstructionError("RateLimit(double rateLimit)", "rateLimit must be greater than 0!");
        }
    }
}