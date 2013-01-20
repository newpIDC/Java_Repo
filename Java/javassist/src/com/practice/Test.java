package com.practice;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javassist.*;

public class Test {
	
    public int f(int i) {
	return i + 1;
    }

    public static void main(String[] args) throws Exception {
    	ClassPool pool = ClassPool.getDefault();
    	CtClass myClass = pool.makeClass("myClass");
    	CtField f = new CtField(CtClass.intType, "hiddenValue", myClass);
    	f.setModifiers(Modifier.PUBLIC);
    	myClass.addField(f);
    	myClass.writeFile("c://");
    	Class clazz = myClass.toClass();  
    	
    	Object obj = clazz.newInstance();
    	Field field = clazz.getDeclaredField("hiddenValue");    	
    	field.set(obj, 5);
    	List myList = new ArrayList();
    	myList.add(obj);
    	//String  json ="";
    	DataObject objdata = new DataObject();
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss::SSS");
    	Calendar cal = Calendar.getInstance();
    	Date date = dateFormat.parse("2012/09/8 09:09:55::676");
    	objdata.setDate(date);
    	Gson gson = new GsonBuilder()
    				.setPrettyPrinting()
    				.setDateFormat("yyyy-dd-MM HH:mm:ss::SSS")
    				.create();
    	String json = gson.toJson(objdata);
    	System.out.println(json);

    	/*GsonBuilder gsonBuilder = new GsonBuilder();
    	gsonBuilder.setDateFormat("");
    	
    	
    	Gson gson = new Gson();
    	gson.
    	json = new Gson().toJson(objdata);
    
    			System.out.println(json);*/
    	
    /*CtClass evalClass = pool.makeClass("Eval");
    	 
    	evalClass.addMethod(
    	        CtNewMethod.make(
    	            "public double eval (double x) { return (" + 2.0 + ") ; }",
    	            evalClass));
    	 Class clazz = evalClass.toClass();
    	Object obj = clazz.newInstance();
    	Class[] formalParams = new Class[] { double.class };
    	Method meth = clazz.getDeclaredMethod("eval", formalParams);

    	Object[] actualParams = new Object[] { new Double(17) };
    	double result = ((Double) meth.invoke(obj, actualParams)).doubleValue();
    	System.out.println(result);
*/  
    }
}
