package lecture23.anno;

import java.lang.reflect.Method;

public class UseMeta {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(final String[] args) throws NoSuchMethodException,
			SecurityException {
		Class clazz = Meta.class;

		Method m = clazz.getMethod("method1");

		MyAnno an = m.getAnnotation(MyAnno.class);
		
		System.out.println(m);
		System.out.println(an.str());

	}
}
