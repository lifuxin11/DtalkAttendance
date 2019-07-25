package com.taocares.dispatch.converter;

import com.taocares.commons.beans.AbstractTypeConverter;

import java.util.Date;

/**
 * @Description 长整型转日期
 * @Author yudunzhi
 * @Date 2018/11/16
 **/
public class LongToDateConverter extends AbstractTypeConverter {
    @Override
    protected Object doConvert(Object o) {
        if(o == null) return null;
        long time = new Long((Long) o);
        return new Date(time);
    }
}
