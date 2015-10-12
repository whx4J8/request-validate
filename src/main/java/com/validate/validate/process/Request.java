package com.validate.validate.process;

/**
 * Created by wanghongxing on 15/10/11.
 */
public abstract class Request<T> {

    /**
     *
     * @return
     */
    public T toModel(){
        return (T) this;
    }

    /**
     * validate model method
     * this function execute after validate model field
     */
    public void validateModelMehtod(){

    }

}
