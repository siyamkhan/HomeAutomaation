package android.support.v4.g;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

public class i {
  public static int a(Object... paramVarArgs) { return (Build.VERSION.SDK_INT >= 19) ? Objects.hash(paramVarArgs) : Arrays.hashCode(paramVarArgs); }
  
  public static boolean a(Object paramObject1, Object paramObject2) { return (Build.VERSION.SDK_INT >= 19) ? Objects.equals(paramObject1, paramObject2) : ((paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2))) ? 1 : 0); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */