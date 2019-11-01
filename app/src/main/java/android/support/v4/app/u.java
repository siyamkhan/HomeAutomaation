package android.support.v4.app;

import android.arch.lifecycle.q;
import android.support.v4.a.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class u {
  public static <T extends android.arch.lifecycle.e & q> u a(T paramT) { return new LoaderManagerImpl(paramT, ((q)paramT).b()); }
  
  public abstract void a();
  
  @Deprecated
  public abstract void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public static interface a<D> {
    void a(b<D> param1b);
    
    void a(b<D> param1b, D param1D);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\ap\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */