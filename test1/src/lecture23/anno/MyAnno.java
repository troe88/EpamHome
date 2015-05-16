package lecture23.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


//@Retention(RetentionPolicy.SOURCE)
//@Retention(RetentionPolicy.CLASS)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	String str();
	int val();
}
