package cn.com.kid.util;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 以静态变量保存Spring ApplicationContext.
 * 
 * 
 */
public class SpringContextUtil implements ApplicationContextAware{
	private static ApplicationContext applicationContext;

	/**
	 * ApplicationContextAware接口的context注入函数.
	 */
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}
	
	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextUtil");
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T) applicationContext.getBean(name);
	}
	public static void main(String []args){
		ApplicationContext ac=SpringContextUtil.getApplicationContext();
		System.out.print(ac);
	}
}
