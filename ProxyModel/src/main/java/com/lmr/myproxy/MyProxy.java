package com.lmr.myproxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class MyProxy {

	public static Object newProxyInstance(Object target,Class<?> interf) throws ClassNotFoundException, IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		String rt="\r\n";
		
		String methodstr="";
		for(Method m:interf.getMethods()){
			
			methodstr+=
			"	@Override" + rt +
			"	public void "+m.getName()+"() {" + rt +
			"		System.out.println(\"汽车开始行驶...\");" + rt +
			"		long starttime = System.currentTimeMillis();" + rt +
			"		ma."+m.getName()+"();" + rt +
			"		long endtime = System.currentTimeMillis();" + rt +
			"		System.out.println(\"汽车结束行驶...  行驶时间: \" + (endtime - starttime) + \" 毫秒\");" + rt +
			"	}";
					
		}
		
		String codestr=
		"package com.lmr.myproxy;" + rt +
		"public class $Proxy0 implements "+interf.getName()+"{" + rt +
		"	private "+interf.getName()+" ma;" + rt +
		"	public $Proxy0("+interf.getName()+" ma) {" + rt +
		"		super();" + rt +
		"		this.ma = ma;" + rt +
		"	}" + rt + methodstr +
		"}";
		
		
		String filename=System.getProperty("user.dir")+"/src/main/java/com/lmr/myproxy/$Proxy0.java";
		System.out.println(filename);
		File file=new File(filename);
		FileUtils.writeStringToFile(file, codestr);
		
		JavaCompiler complier=ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr=complier.getStandardFileManager(null, null, null);
		Iterable units=fileMgr.getJavaFileObjects(filename);
		CompilationTask comtask=complier.getTask(null, fileMgr, null, null, null, units);
		comtask.call();
		fileMgr.close();
		
		ClassLoader cl=ClassLoader.getSystemClassLoader();
//		Class c=cl.loadClass(System.getProperty("user.dir")+"\\src\\main\\java\\com\\lmr\\myproxy\\$Proxy0.class");
		Class c=cl.loadClass("com.lmr.myproxy.$proxy0");
		
		System.out.println(c.getName());
		
//		Constructor ctr=c.getConstructor(interf);
//		
//		return ctr.newInstance(target);
		
		return null;
		
	}
	
}
