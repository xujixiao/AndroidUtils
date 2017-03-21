package cn.test.mylibrary.utils;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 去重复ArrayList <br>
 * 创建日期：2015-6-16 <br>
 */
public class RepeatArrayList extends ArrayList<Long> {

    private static final long serialVersionUID = -2059391548445874626L;

    @Override
    public boolean add(Long object) {
        boolean contains = contains(object);
        if (contains) {
            return true;
        } else {
            return super.add(object);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Long> iterator = iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(iterator.next());
            if (iterator.hasNext()) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

}
