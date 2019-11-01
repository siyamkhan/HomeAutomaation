package android.support.v4.g;

public class d {
  public static void a(Object paramObject, StringBuilder paramStringBuilder) {
    String str;
    if (paramObject == null) {
      str = "null";
    } else {
      String str1 = paramObject.getClass().getSimpleName();
      if (str1 == null || str1.length() <= 0) {
        str1 = paramObject.getClass().getName();
        int i = str1.lastIndexOf('.');
        if (i > 0)
          str1 = str1.substring(i + 1); 
      } 
      paramStringBuilder.append(str1);
      paramStringBuilder.append('{');
      str = Integer.toHexString(System.identityHashCode(paramObject));
    } 
    paramStringBuilder.append(str);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */