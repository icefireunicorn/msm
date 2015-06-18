package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Hello{
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            //一般尽量采用这种形式
            demo=Class.forName("reflection.Demo");
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
			Method method = demo.getMethod("doSth",String.class);
			method.invoke(demo.newInstance(),"play game!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
