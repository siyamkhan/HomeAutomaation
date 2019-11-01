package android.support.v4.e;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.a.a.c;
import android.support.v4.a.a.f;
import android.support.v4.g.g;
import android.support.v4.g.k;
import android.support.v4.g.l;
import android.support.v4.graphics.c;
import android.support.v4.graphics.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class b {
  static final g<String, Typeface> a = new g(16);
  
  static final Object b;
  
  static final l<String, ArrayList<c.a<c>>> c;
  
  private static final c d = new c("fonts", 10, 10000);
  
  private static final Comparator<byte[]> e;
  
  static  {
    b = new Object();
    c = new l();
    e = new Comparator<byte[]>() {
        public int a(byte[] param1ArrayOfByte1, byte[] param1ArrayOfByte2) {
          if (param1ArrayOfByte1.length != param1ArrayOfByte2.length) {
            int i = param1ArrayOfByte1.length;
            int j = param1ArrayOfByte2.length;
            return i - j;
          } 
          for (byte b = 0; b < param1ArrayOfByte1.length; b++) {
            if (param1ArrayOfByte1[b] != param1ArrayOfByte2[b]) {
              byte b1 = param1ArrayOfByte1[b];
              byte b2 = param1ArrayOfByte2[b];
              return b1 - b2;
            } 
          } 
          return 0;
        }
      };
  }
  
  public static ProviderInfo a(PackageManager paramPackageManager, a parama, Resources paramResources) {
    String str = parama.a();
    byte b1 = 0;
    ProviderInfo providerInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (providerInfo != null) {
      if (providerInfo.packageName.equals(parama.b())) {
        List list1 = a((paramPackageManager.getPackageInfo(providerInfo.packageName, 64)).signatures);
        Collections.sort(list1, e);
        List list2 = a(parama, paramResources);
        while (b1 < list2.size()) {
          ArrayList arrayList = new ArrayList((Collection)list2.get(b1));
          Collections.sort(arrayList, e);
          if (a(list1, arrayList))
            return providerInfo; 
          b1++;
        } 
        return null;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Found content provider ");
      stringBuilder1.append(str);
      stringBuilder1.append(", but package was not ");
      stringBuilder1.append(parama.b());
      throw new PackageManager.NameNotFoundException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No package found for authority: ");
    stringBuilder.append(str);
    throw new PackageManager.NameNotFoundException(stringBuilder.toString());
  }
  
  public static Typeface a(Context paramContext, a parama, f.a parama1, Handler paramHandler, boolean paramBoolean, int paramInt1, int paramInt2) {
    c.a<c> a1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parama.f());
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    String str = stringBuilder.toString();
    Typeface typeface1 = (Typeface)a.a(str);
    if (typeface1 != null) {
      if (parama1 != null)
        parama1.a(typeface1); 
      return typeface1;
    } 
    if (paramBoolean && paramInt1 == -1) {
      c c1 = a(paramContext, parama, paramInt2);
      if (parama1 != null)
        if (c1.b == 0) {
          parama1.a(c1.a, paramHandler);
        } else {
          parama1.a(c1.b, paramHandler);
        }  
      return c1.a;
    } 
    Callable<c> callable = new Callable<c>(paramContext, parama, paramInt2, str) {
        public b.c a() {
          b.c c1 = b.a(this.a, this.b, this.c);
          if (c1.a != null)
            b.a.a(this.d, c1.a); 
          return c1;
        }
      };
    Typeface typeface2 = null;
    if (paramBoolean) {
      try {
        typeface2 = ((c)d.a(callable, paramInt1)).a;
      } catch (InterruptedException interruptedException) {}
      return typeface2;
    } 
    if (parama1 == null) {
      a1 = null;
    } else {
      a1 = new c.a<c>(parama1, paramHandler) {
          public void a(b.c param1c) {
            if (param1c == null) {
              this.a.a(1, this.b);
              return;
            } 
            if (param1c.b == 0) {
              this.a.a(param1c.a, this.b);
              return;
            } 
            this.a.a(param1c.b, this.b);
          }
        };
    } 
    synchronized (b) {
      if (c.containsKey(str)) {
        if (a1 != null)
          ((ArrayList)c.get(str)).add(a1); 
        return null;
      } 
      if (a1 != null) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a1);
        c.put(str, arrayList);
      } 
      d.a(callable, new c.a<c>(str) {
            public void a(b.c param1c) {
              synchronized (b.b) {
                ArrayList arrayList = (ArrayList)b.c.get(this.a);
                if (arrayList == null)
                  return; 
                b.c.remove(this.a);
                for (byte b = 0; b < arrayList.size(); b++)
                  ((a)arrayList.get(b)).a(param1c); 
                return;
              } 
            }
          });
      return null;
    } 
  }
  
  public static a a(Context paramContext, CancellationSignal paramCancellationSignal, a parama) {
    ProviderInfo providerInfo = a(paramContext.getPackageManager(), parama, paramContext.getResources());
    return (providerInfo == null) ? new a(1, null) : new a(0, a(paramContext, parama, providerInfo.authority, paramCancellationSignal));
  }
  
  static c a(Context paramContext, a parama, int paramInt) {
    try {
      a a1 = a(paramContext, null, parama);
      int i = a1.a();
      byte b1 = -3;
      if (i == 0) {
        Typeface typeface = c.a(paramContext, null, a1.b(), paramInt);
        if (typeface != null)
          b1 = 0; 
        return new c(typeface, b1);
      } 
      if (a1.a() == 1)
        b1 = -2; 
      return new c(null, b1);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return new c(null, -1);
    } 
  }
  
  private static List<List<byte[]>> a(a parama, Resources paramResources) { return (parama.d() != null) ? parama.d() : c.a(paramResources, parama.e()); }
  
  private static List<byte[]> a(Signature[] paramArrayOfSignature) {
    ArrayList arrayList = new ArrayList();
    for (byte b1 = 0; b1 < paramArrayOfSignature.length; b1++)
      arrayList.add(paramArrayOfSignature[b1].toByteArray()); 
    return arrayList;
  }
  
  public static Map<Uri, ByteBuffer> a(Context paramContext, b[] paramArrayOfb, CancellationSignal paramCancellationSignal) {
    HashMap hashMap = new HashMap();
    int i = paramArrayOfb.length;
    for (byte b1 = 0; b1 < i; b1++) {
      b b2 = paramArrayOfb[b1];
      if (b2.e() == 0) {
        Uri uri = b2.a();
        if (!hashMap.containsKey(uri))
          hashMap.put(uri, i.a(paramContext, paramCancellationSignal, uri)); 
      } 
    } 
    return Collections.unmodifiableMap(hashMap);
  }
  
  private static boolean a(List<byte[]> paramList1, List<byte[]> paramList2) {
    if (paramList1.size() != paramList2.size())
      return false; 
    for (byte b1 = 0; b1 < paramList1.size(); b1++) {
      if (!Arrays.equals((byte[])paramList1.get(b1), (byte[])paramList2.get(b1)))
        return false; 
    } 
    return true;
  }
  
  static b[] a(Context paramContext, a parama, String paramString, CancellationSignal paramCancellationSignal) {
    arrayList = new ArrayList();
    Uri uri1 = (new Uri.Builder()).scheme("content").authority(paramString).build();
    Uri uri2 = (new Uri.Builder()).scheme("content").authority(paramString).appendPath("file").build();
    cursor = null;
    try {
      Cursor cursor1;
      int i = Build.VERSION.SDK_INT;
      cursor = null;
      if (i > 16) {
        ContentResolver contentResolver = paramContext.getContentResolver();
        String[] arrayOfString1 = { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" };
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = parama.c();
        cursor1 = contentResolver.query(uri1, arrayOfString1, "query = ?", arrayOfString2, null, paramCancellationSignal);
      } else {
        ContentResolver contentResolver = paramContext.getContentResolver();
        String[] arrayOfString1 = { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" };
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = parama.c();
        cursor1 = contentResolver.query(uri1, arrayOfString1, "query = ?", arrayOfString2, null);
      } 
      cursor = cursor1;
      if (cursor != null && cursor.getCount() > 0) {
        int j = cursor.getColumnIndex("result_code");
        ArrayList arrayList1 = new ArrayList();
        int k = cursor.getColumnIndex("_id");
        int m = cursor.getColumnIndex("file_id");
        int n = cursor.getColumnIndex("font_ttc_index");
        int i1 = cursor.getColumnIndex("font_weight");
        int i2 = cursor.getColumnIndex("font_italic");
        while (true) {
          if (cursor.moveToNext()) {
            boolean bool;
            char c1;
            Uri uri3;
            byte b2;
            byte b1;
            if (j != -1) {
              b1 = cursor.getInt(j);
            } else {
              b1 = 0;
            } 
            if (n != -1) {
              b2 = cursor.getInt(n);
            } else {
              b2 = 0;
            } 
            if (m == -1) {
              uri3 = ContentUris.withAppendedId(uri1, cursor.getLong(k));
            } else {
              uri3 = ContentUris.withAppendedId(uri2, cursor.getLong(m));
            } 
            Uri uri4 = uri3;
            if (i1 != -1) {
              c1 = cursor.getInt(i1);
            } else {
              c1 = 'Ɛ';
            } 
            if (i2 != -1 && cursor.getInt(i2) == 1) {
              bool = true;
            } else {
              bool = false;
            } 
            b b3 = new b(uri4, b2, c1, bool, b1);
            arrayList1.add(b3);
            continue;
          } 
          arrayList = arrayList1;
          return (b[])arrayList.toArray(new b[0]);
        } 
      } 
      return (b[])arrayList.toArray(new b[0]);
    } finally {
      if (cursor != null)
        cursor.close(); 
    } 
  }
  
  public static class a {
    private final int a;
    
    private final b.b[] b;
    
    public a(int param1Int, b.b[] param1ArrayOfb) {
      this.a = param1Int;
      this.b = param1ArrayOfb;
    }
    
    public int a() { return this.a; }
    
    public b.b[] b() { return this.b; }
  }
  
  public static class b {
    private final Uri a;
    
    private final int b;
    
    private final int c;
    
    private final boolean d;
    
    private final int e;
    
    public b(Uri param1Uri, int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      this.a = (Uri)k.a(param1Uri);
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1Boolean;
      this.e = param1Int3;
    }
    
    public Uri a() { return this.a; }
    
    public int b() { return this.b; }
    
    public int c() { return this.c; }
    
    public boolean d() { return this.d; }
    
    public int e() { return this.e; }
  }
  
  private static final class c {
    final Typeface a;
    
    final int b;
    
    c(Typeface param1Typeface, int param1Int) {
      this.a = param1Typeface;
      this.b = param1Int;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */