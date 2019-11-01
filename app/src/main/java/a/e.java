package a.a.a.a;

import a.a.a.a.a.b.i;
import android.os.SystemClock;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.jd.gui.api.API;

class e extends Object implements Callable<Map<String, k>> {
  final String a;
  
  e(String paramString) { this.a = paramString; }
  
  private k a(ZipEntry paramZipEntry, ZipFile paramZipFile) {
    try {
      closeable = paramZipFile.getInputStream(paramZipEntry);
    } catch (IOException iOException) {
    
    } finally {
      API aPI = null;
    } 
    l l = c.g();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Error when parsing fabric properties ");
    stringBuilder.append(paramZipEntry.getName());
    l.e("Fabric", stringBuilder.toString(), iOException);
    i.a(closeable);
    return null;
  }
  
  private Map<String, k> c() {
    HashMap hashMap = new HashMap();
    try {
      Class.forName("com.google.android.gms.ads.AdView");
      k k = new k("com.google.firebase.firebase-ads", "0.0.0", "binary");
      hashMap.put(k.a(), k);
      c.g().b("Fabric", "Found kit: com.google.firebase.firebase-ads");
    } catch (Exception exception) {}
    return hashMap;
  }
  
  private Map<String, k> d() { // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual b : ()Ljava/util/zip/ZipFile;
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual entries : ()Ljava/util/Enumeration;
    //   17: astore_3
    //   18: aload_3
    //   19: invokeinterface hasMoreElements : ()Z
    //   24: ifeq -> 140
    //   27: aload_3
    //   28: invokeinterface nextElement : ()Ljava/lang/Object;
    //   33: checkcast java/util/zip/ZipEntry
    //   36: astore #5
    //   38: aload #5
    //   40: invokevirtual getName : ()Ljava/lang/String;
    //   43: ldc 'fabric/'
    //   45: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   48: ifeq -> 18
    //   51: aload #5
    //   53: invokevirtual getName : ()Ljava/lang/String;
    //   56: invokevirtual length : ()I
    //   59: bipush #7
    //   61: if_icmple -> 18
    //   64: aload_0
    //   65: aload #5
    //   67: aload_2
    //   68: invokespecial a : (Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipFile;)La/a/a/a/k;
    //   71: astore #6
    //   73: aload #6
    //   75: ifnull -> 18
    //   78: aload_1
    //   79: aload #6
    //   81: invokevirtual a : ()Ljava/lang/String;
    //   84: aload #6
    //   86: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: invokestatic g : ()La/a/a/a/l;
    //   95: astore #8
    //   97: iconst_2
    //   98: anewarray java/lang/Object
    //   101: astore #9
    //   103: aload #9
    //   105: iconst_0
    //   106: aload #6
    //   108: invokevirtual a : ()Ljava/lang/String;
    //   111: aastore
    //   112: aload #9
    //   114: iconst_1
    //   115: aload #6
    //   117: invokevirtual b : ()Ljava/lang/String;
    //   120: aastore
    //   121: aload #8
    //   123: ldc 'Fabric'
    //   125: ldc 'Found kit:[%s] version:[%s]'
    //   127: aload #9
    //   129: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   132: invokeinterface b : (Ljava/lang/String;Ljava/lang/String;)V
    //   137: goto -> 18
    //   140: aload_2
    //   141: ifnull -> 151
    //   144: aload_2
    //   145: invokevirtual close : ()V
    //   148: goto -> 152
    //   151: pop
    //   152: aload_1
    //   153: areturn
    // Exception table:
    //   from	to	target	type
    //   144	148	151	java/io/IOException }
  
  public Map<String, k> a() {
    HashMap hashMap = new HashMap();
    long l = SystemClock.elapsedRealtime();
    hashMap.putAll(c());
    hashMap.putAll(d());
    l l1 = c.g();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("finish scanning in ");
    stringBuilder.append(SystemClock.elapsedRealtime() - l);
    l1.b("Fabric", stringBuilder.toString());
    return hashMap;
  }
  
  protected ZipFile b() { return new ZipFile(this.a); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */