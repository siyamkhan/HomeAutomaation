package android.support.v4.app;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

public final class ab {
  private final String a;
  
  private final CharSequence b;
  
  private final CharSequence[] c;
  
  private final boolean d;
  
  private final Bundle e;
  
  private final Set<String> f;
  
  static RemoteInput a(ab paramab) { return (new RemoteInput.Builder(paramab.a())).setLabel(paramab.b()).setChoices(paramab.c()).setAllowFreeFormInput(paramab.e()).addExtras(paramab.f()).build(); }
  
  static RemoteInput[] a(ab[] paramArrayOfab) {
    if (paramArrayOfab == null)
      return null; 
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfab.length];
    for (byte b1 = 0; b1 < paramArrayOfab.length; b1++)
      arrayOfRemoteInput[b1] = a(paramArrayOfab[b1]); 
    return arrayOfRemoteInput;
  }
  
  public String a() { return this.a; }
  
  public CharSequence b() { return this.b; }
  
  public CharSequence[] c() { return this.c; }
  
  public Set<String> d() { return this.f; }
  
  public boolean e() { return this.d; }
  
  public Bundle f() { return this.e; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */