package com.taocares.dispatch.converter;

import com.taocares.commons.beans.AbstractTypeConverter;

import java.util.Date;

/**
 * @Description 日期转时间戳
 * @Author yudunzhi
 * @Date 2018/11/16
 **/
public class DateToLongConverter extends AbstractTypeConverter {
    @Override
    protected Object doConvert(Object o) {
        if(o == null) return null;
        Date date = (Date) o;
        return date.getTime();
    }
}
