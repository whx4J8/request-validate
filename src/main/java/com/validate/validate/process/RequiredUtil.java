package com.validate.validate.process;

import com.validate.exception.ValidateNotNullException;
import com.validate.validate.annotation.Required;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.net.Authenticator;
import java.util.*;

/**
 * Created by wanghongxing on 15/10/11.
 */
public class RequiredUtil {

    private static final Logger LOGGER = Logger.getLogger(RequiredUtil.class);

    public static void checkModel(Object object) {

        Class clazz = object.getClass();
        Map<String,PropertyDescriptor> propertyDescriptorMap =
                new HashMap<>();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor pd : propertyDescriptors){
                propertyDescriptorMap.put(pd.getName(),pd);
            }

        } catch (IntrospectionException e) {
            LOGGER.error(e.getMessage(),e);
        }

        Field[] fields = clazz.getDeclaredFields();
        try{

            for(Field field : fields) {
                Required requiredAno = field.getAnnotation(Required.class);
                if (requiredAno == null || requiredAno.value() == false) continue;

                Object fieldValue = field.get(object);

                if (fieldValue instanceof String) {
                    if(StringUtils.isBlank((String)fieldValue))
                        throw new ValidateNotNullException(field.getName() + " is not allow null");

                } else if (fieldValue instanceof Collection) {
                    if(fieldValue == null || ((Collection) fieldValue).size() == 0)
                        throw new ValidateNotNullException(field.getName() + " is not allow null");
                    checkInner((Collection) fieldValue);

                } else if (fieldValue instanceof Map) {
                    if(fieldValue == null || ((Map)fieldValue).size() == 0)
                        throw new ValidateNotNullException(field.getName() + " is not allow null");
                    checkInner((Map)fieldValue);

                } else if(fieldValue instanceof Request){
                    checkModel(fieldValue);

                } else{
                    if(field == null)
                        throw new ValidateNotNullException(field.getName() + " is not allow null");

                }
            }

            checkValidateModelMehtod((Request) object);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param collection
     */
    private static void checkInner(Collection collection){
        for(Object model  : collection){
            checkModel(model);
        }
    }

    /**
     *
     * @param map
     */
    private static void checkInner(Map map){
        Set<Map.Entry> entrySet = map.entrySet();
        for(Map.Entry entry : entrySet){
            checkModel(entry.getValue());
        }
    }

    /**
     *
     * @param model
     */
    private static void checkValidateModelMehtod(Request model){
        model.validateModelMehtod();
    }

}
