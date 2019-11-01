package a.a.a.a.a.g;

import a.a.a.a.a.b.a;
import a.a.a.a.a.b.i;
import a.a.a.a.a.e.c;
import a.a.a.a.a.e.d;
import a.a.a.a.a.e.e;
import a.a.a.a.c;
import a.a.a.a.i;
import a.a.a.a.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class l extends a implements x {
  public l(i parami, String paramString1, String paramString2, e parame) { this(parami, paramString1, paramString2, parame, c.a); }
  
  l(i parami, String paramString1, String paramString2, e parame, c paramc) { super(parami, paramString1, paramString2, parame, paramc); }
  
  private d a(d paramd, w paramw) {
    a(paramd, "X-CRASHLYTICS-API-KEY", paramw.a);
    a(paramd, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
    a(paramd, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    a(paramd, "Accept", "application/json");
    a(paramd, "X-CRASHLYTICS-DEVICE-MODEL", paramw.b);
    a(paramd, "X-CRASHLYTICS-OS-BUILD-VERSION", paramw.c);
    a(paramd, "X-CRASHLYTICS-OS-DISPLAY-VERSION", paramw.d);
    a(paramd, "X-CRASHLYTICS-INSTALLATION-ID", paramw.e);
    return paramd;
  }
  
  private JSONObject a(String paramString) {
    try {
      return new JSONObject(paramString);
    } catch (Exception exception) {
      l l1 = c.g();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Failed to parse settings JSON from ");
      stringBuilder1.append(a());
      l1.a("Fabric", stringBuilder1.toString(), exception);
      l l2 = c.g();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Settings response ");
      stringBuilder2.append(paramString);
      l2.a("Fabric", stringBuilder2.toString());
      return null;
    } 
  }
  
  private void a(d paramd, String paramString1, String paramString2) {
    if (paramString2 != null)
      paramd.a(paramString1, paramString2); 
  }
  
  private Map<String, String> b(w paramw) {
    HashMap hashMap = new HashMap();
    hashMap.put("build_version", paramw.h);
    hashMap.put("display_version", paramw.g);
    hashMap.put("source", Integer.toString(paramw.i));
    if (paramw.j != null)
      hashMap.put("icon_hash", paramw.j); 
    String str = paramw.f;
    if (!i.d(str))
      hashMap.put("instance", str); 
    return hashMap;
  }
  
  JSONObject a(d paramd) {
    int i = paramd.b();
    l l1 = c.g();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Settings result was: ");
    stringBuilder1.append(i);
    l1.a("Fabric", stringBuilder1.toString());
    if (a(i))
      return a(paramd.d()); 
    l l2 = c.g();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Failed to retrieve settings from ");
    stringBuilder2.append(a());
    l2.e("Fabric", stringBuilder2.toString());
    return null;
  }
  
  public JSONObject a(w paramw) { // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial b : (La/a/a/a/a/g/w;)Ljava/util/Map;
    //   5: astore #16
    //   7: aload_0
    //   8: aload #16
    //   10: invokevirtual a : (Ljava/util/Map;)La/a/a/a/a/e/d;
    //   13: astore #17
    //   15: aload_0
    //   16: aload #17
    //   18: aload_1
    //   19: invokespecial a : (La/a/a/a/a/e/d;La/a/a/a/a/g/w;)La/a/a/a/a/e/d;
    //   22: astore_3
    //   23: invokestatic g : ()La/a/a/a/l;
    //   26: astore #18
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #19
    //   37: aload #19
    //   39: ldc 'Requesting settings from '
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload #19
    //   47: aload_0
    //   48: invokevirtual a : ()Ljava/lang/String;
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload #18
    //   57: ldc 'Fabric'
    //   59: aload #19
    //   61: invokevirtual toString : ()Ljava/lang/String;
    //   64: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;)V
    //   69: invokestatic g : ()La/a/a/a/l;
    //   72: astore #22
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore #23
    //   83: aload #23
    //   85: ldc 'Settings query params were: '
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #23
    //   93: aload #16
    //   95: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #22
    //   101: ldc 'Fabric'
    //   103: aload #23
    //   105: invokevirtual toString : ()Ljava/lang/String;
    //   108: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: aload_3
    //   115: invokevirtual a : (La/a/a/a/a/e/d;)Lorg/json/JSONObject;
    //   118: astore #9
    //   120: aload_3
    //   121: ifnull -> 256
    //   124: invokestatic g : ()La/a/a/a/l;
    //   127: astore #10
    //   129: ldc 'Fabric'
    //   131: astore #11
    //   133: new java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial <init> : ()V
    //   140: astore #12
    //   142: aload #12
    //   144: ldc 'Settings request ID: '
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload #12
    //   152: aload_3
    //   153: ldc 'X-REQUEST-ID'
    //   155: invokevirtual b : (Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload #10
    //   164: aload #11
    //   166: aload #12
    //   168: invokevirtual toString : ()Ljava/lang/String;
    //   171: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload #9
    //   178: areturn
    //   179: astore_2
    //   180: goto -> 212
    //   183: astore #4
    //   185: aload #17
    //   187: astore_3
    //   188: goto -> 261
    //   191: astore_2
    //   192: aload #17
    //   194: astore_3
    //   195: goto -> 212
    //   198: astore #15
    //   200: aload #15
    //   202: astore #4
    //   204: aconst_null
    //   205: astore_3
    //   206: goto -> 261
    //   209: astore_2
    //   210: aconst_null
    //   211: astore_3
    //   212: invokestatic g : ()La/a/a/a/l;
    //   215: ldc 'Fabric'
    //   217: ldc 'Settings request failed.'
    //   219: aload_2
    //   220: invokeinterface e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aconst_null
    //   226: astore #9
    //   228: aload_3
    //   229: ifnull -> 256
    //   232: invokestatic g : ()La/a/a/a/l;
    //   235: astore #10
    //   237: ldc 'Fabric'
    //   239: astore #11
    //   241: new java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial <init> : ()V
    //   248: astore #12
    //   250: aconst_null
    //   251: astore #9
    //   253: goto -> 142
    //   256: aload #9
    //   258: areturn
    //   259: astore #4
    //   261: aload_3
    //   262: ifnull -> 313
    //   265: invokestatic g : ()La/a/a/a/l;
    //   268: astore #5
    //   270: new java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial <init> : ()V
    //   277: astore #6
    //   279: aload #6
    //   281: ldc 'Settings request ID: '
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #6
    //   289: aload_3
    //   290: ldc 'X-REQUEST-ID'
    //   292: invokevirtual b : (Ljava/lang/String;)Ljava/lang/String;
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload #5
    //   301: ldc 'Fabric'
    //   303: aload #6
    //   305: invokevirtual toString : ()Ljava/lang/String;
    //   308: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload #4
    //   315: athrow
    // Exception table:
    //   from	to	target	type
    //   0	15	209	a/a/a/a/a/e/d$c
    //   0	15	198	finally
    //   15	23	191	a/a/a/a/a/e/d$c
    //   15	23	183	finally
    //   23	120	179	a/a/a/a/a/e/d$c
    //   23	120	259	finally
    //   212	225	259	finally }
  
  boolean a(int paramInt) { return (paramInt == 200 || paramInt == 201 || paramInt == 202 || paramInt == 203); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\g\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */