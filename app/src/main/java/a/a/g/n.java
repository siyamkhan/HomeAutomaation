package a.a.a.a.a.g;

import a.a.a.a.a.b.i;
import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import android.graphics.BitmapFactory;

public class n {
  public final String a;
  
  public final int b;
  
  public final int c;
  
  public final int d;
  
  public n(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public static n a(Context paramContext, String paramString) {
    if (paramString != null)
      try {
        int i = i.l(paramContext);
        l l = c.g();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("App icon resource ID is ");
        stringBuilder.append(i);
        l.a("Fabric", stringBuilder.toString());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramContext.getResources(), i, options);
        return new n(paramString, i, options.outWidth, options.outHeight);
      } catch (Exception exception) {
        c.g().e("Fabric", "Failed to load icon", exception);
      }  
    return null;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\g\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */