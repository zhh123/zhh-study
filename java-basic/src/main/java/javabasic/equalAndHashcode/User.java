package javabasic.equalAndHashcode;


import org.apache.commons.lang3.StringUtils;

/**
 * @Author:zhh
 * @Date:Created in 16:08 2019/8/31 0031
 */
public class User {
    private String name;

    public User(String vName){
        this.name = vName;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj instanceof User){
            User other = (User)obj;
            //需要比较的字段相等，则这两个对象相等
            if(equalsStr(this.name, other.name)){
                return true;
            }

        }
        return false;
    }

   /* @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        return result;
    }*/

    private boolean equalsStr(String str1, String str2){

        if(StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)){
            return true;
        }
        if(!StringUtils.isEmpty(str1) && str1.equals(str2)){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}