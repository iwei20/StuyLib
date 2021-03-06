package com.stuypulse.stuylib.streams.filters;

import com.stuypulse.stuylib.streams.filters.IStreamFilter;

/**
 * This class lets you take a simple filter like "x * 0.5" and apply it
 * to the derivative of the IStream. This lets you build more complex filters
 * more easily
 * 
 * @author Sam (sam.belliveau@gmail.com)
 * @author William (he thought it was cool)
 */

public class OnDerivative implements IStreamFilter {

    private double mLastValue;
    private IStreamFilter mFilter;

    /**
     * This will take the filter and make it apply to the derivative of stream givin
     * too it
     * 
     * @param filter filter that gets applied to the derivative of the stream
     */
    public OnDerivative(IStreamFilter filter) {
        mLastValue = 0;
        mFilter = filter;
    }

    public double get(double next) {
        return mLastValue += mFilter.get(next - mLastValue);
    }
}