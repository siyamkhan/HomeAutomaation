package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.jd.gui.api.API;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class d extends DataSetObservable {
  static final String a = "d";
  
  private static final Object e = new Object();
  
  private static final Map<String, d> f = new HashMap();
  
  final Context b;
  
  final String c;
  
  boolean d;
  
  private final Object g;
  
  private final List<a> h;
  
  private final List<c> i;
  
  private Intent j;
  
  private b k;
  
  private int l;
  
  private boolean m;
  
  private boolean n;
  
  private boolean o;
  
  private d p;
  
  private boolean a(c paramc) {
    boolean bool = this.i.add(paramc);
    if (bool) {
      this.n = true;
      h();
      c();
      e();
      notifyChanged();
    } 
    return bool;
  }
  
  private void c() {
    if (this.m) {
      if (!this.n)
        return; 
      this.n = false;
      if (!TextUtils.isEmpty(this.c)) {
        e e1 = new e(this);
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = new ArrayList(this.i);
        arrayOfObject[1] = this.c;
        e1.executeOnExecutor(executor, arrayOfObject);
      } 
      return;
    } 
    throw new IllegalStateException("No preceding call to #readHistoricalData");
  }
  
  private void d() {
    boolean bool = f() | g();
    h();
    if (bool) {
      e();
      notifyChanged();
    } 
  }
  
  private boolean e() {
    if (this.k != null && this.j != null && !this.h.isEmpty() && !this.i.isEmpty()) {
      this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
      return true;
    } 
    return false;
  }
  
  private boolean f() {
    boolean bool = this.o;
    byte b1 = 0;
    if (bool && this.j != null) {
      this.o = false;
      this.h.clear();
      List list = this.b.getPackageManager().queryIntentActivities(this.j, 0);
      int i1 = list.size();
      while (b1 < i1) {
        ResolveInfo resolveInfo = (ResolveInfo)list.get(b1);
        this.h.add(new a(resolveInfo));
        b1++;
      } 
      return true;
    } 
    return false;
  }
  
  private boolean g() {
    if (this.d && this.n && !TextUtils.isEmpty(this.c)) {
      this.d = false;
      this.m = true;
      i();
      return true;
    } 
    return false;
  }
  
  private void h() {
    int i1 = this.i.size() - this.l;
    if (i1 <= 0)
      return; 
    this.n = true;
    for (byte b1 = 0; b1 < i1; b1++)
      (c)this.i.remove(0); 
  }
  
  private void i() {
    try {
      FileInputStream fileInputStream = this.b.openFileInput(this.c);
      try {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(fileInputStream, "UTF-8");
        int i1;
        for (i1 = 0; i1 != 1 && i1 != 2; i1 = xmlPullParser.next());
        if ("historical-records".equals(xmlPullParser.getName())) {
          List list = this.i;
          list.clear();
          while (true) {
            int i2 = xmlPullParser.next();
            if (i2 == 1) {
              if (fileInputStream != null) {
                fileInputStream.close();
                return;
              } 
              break;
            } 
            if (i2 == 3 || i2 == 4)
              continue; 
            if ("historical-record".equals(xmlPullParser.getName())) {
              list.add(new c(xmlPullParser.getAttributeValue(null, "activity"), Long.parseLong(xmlPullParser.getAttributeValue(null, "time")), Float.parseFloat(xmlPullParser.getAttributeValue(null, "weight"))));
              continue;
            } 
            throw new XmlPullParserException("Share records file not well-formed.");
          } 
        } else {
          throw new XmlPullParserException("Share records file does not start with historical-records tag.");
        } 
      } catch (XmlPullParserException xmlPullParserException) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error reading historical recrod file: ");
        stringBuilder.append(this.c);
        Log.e(str, stringBuilder.toString(), xmlPullParserException);
        if (fileInputStream != null) {
          fileInputStream.close();
          return;
        } 
      } catch (IOException iOException) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error reading historical recrod file: ");
        stringBuilder.append(this.c);
        Log.e(str, stringBuilder.toString(), iOException);
        if (fileInputStream != null) {
          fileInputStream.close();
          return;
        } 
      } finally {
        API aPI;
      } 
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      return;
    } 
  }
  
  public int a() {
    synchronized (this.g) {
      d();
      return this.h.size();
    } 
  }
  
  public int a(ResolveInfo paramResolveInfo) {
    synchronized (this.g) {
      d();
      List list = this.h;
      int i1 = list.size();
      for (byte b1 = 0;; b1++) {
        if (b1 < i1) {
          if (((a)list.get(b1)).a == paramResolveInfo)
            return b1; 
        } else {
          return -1;
        } 
      } 
    } 
  }
  
  public ResolveInfo a(int paramInt) {
    synchronized (this.g) {
      d();
      return ((a)this.h.get(paramInt)).a;
    } 
  }
  
  public Intent b(int paramInt) {
    synchronized (this.g) {
      if (this.j == null)
        return null; 
      d();
      a a1 = (a)this.h.get(paramInt);
      ComponentName componentName = new ComponentName(a1.a.activityInfo.packageName, a1.a.activityInfo.name);
      Intent intent = new Intent(this.j);
      intent.setComponent(componentName);
      if (this.p != null) {
        Intent intent1 = new Intent(intent);
        if (this.p.a(this, intent1))
          return null; 
      } 
      a(new c(componentName, System.currentTimeMillis(), 1.0F));
      return intent;
    } 
  }
  
  public ResolveInfo b() {
    synchronized (this.g) {
      d();
      if (!this.h.isEmpty())
        return ((a)this.h.get(0)).a; 
      return null;
    } 
  }
  
  public void c(int paramInt) {
    synchronized (this.g) {
      float f1;
      d();
      a a1 = (a)this.h.get(paramInt);
      a a2 = (a)this.h.get(0);
      if (a2 != null) {
        f1 = 5.0F + a2.b - a1.b;
      } else {
        f1 = 1.0F;
      } 
      a(new c(new ComponentName(a1.a.activityInfo.packageName, a1.a.activityInfo.name), System.currentTimeMillis(), f1));
      return;
    } 
  }
  
  public static final class a extends Object implements Comparable<a> {
    public final ResolveInfo a;
    
    public float b;
    
    public a(ResolveInfo param1ResolveInfo) { this.a = param1ResolveInfo; }
    
    public int a(a param1a) { return Float.floatToIntBits(param1a.b) - Float.floatToIntBits(this.b); }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      a a1 = (a)param1Object;
      return !(Float.floatToIntBits(this.b) != Float.floatToIntBits(a1.b));
    }
    
    public int hashCode() { return 31 + Float.floatToIntBits(this.b); }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append("resolveInfo:");
      stringBuilder.append(this.a.toString());
      stringBuilder.append("; weight:");
      stringBuilder.append(new BigDecimal(this.b));
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  public static interface b {
    void a(Intent param1Intent, List<d.a> param1List1, List<d.c> param1List2);
  }
  
  public static final class c {
    public final ComponentName a;
    
    public final long b;
    
    public final float c;
    
    public c(ComponentName param1ComponentName, long param1Long, float param1Float) {
      this.a = param1ComponentName;
      this.b = param1Long;
      this.c = param1Float;
    }
    
    public c(String param1String, long param1Long, float param1Float) { this(ComponentName.unflattenFromString(param1String), param1Long, param1Float); }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      c c1 = (c)param1Object;
      ComponentName componentName = this.a;
      if (componentName == null) {
        if (c1.a != null)
          return false; 
      } else if (!componentName.equals(c1.a)) {
        return false;
      } 
      return (this.b != c1.b) ? false : (!(Float.floatToIntBits(this.c) != Float.floatToIntBits(c1.c)));
    }
    
    public int hashCode() {
      int i;
      ComponentName componentName = this.a;
      if (componentName == null) {
        i = 0;
      } else {
        i = componentName.hashCode();
      } 
      int j = 31 * (i + 31);
      long l = this.b;
      return 31 * (j + (int)(l ^ l >>> 32)) + Float.floatToIntBits(this.c);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append("; activity:");
      stringBuilder.append(this.a);
      stringBuilder.append("; time:");
      stringBuilder.append(this.b);
      stringBuilder.append("; weight:");
      stringBuilder.append(new BigDecimal(this.c));
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  public static interface d {
    boolean a(d param1d, Intent param1Intent);
  }
  
  private final class e extends AsyncTask<Object, Void, Void> {
    e(d this$0) {}
    
    public Void a(Object... param1VarArgs) {
      List list = (List)param1VarArgs[0];
      String str = (String)param1VarArgs[1];
      try {
        FileOutputStream fileOutputStream = this.a.b.openFileOutput(str, 0);
        XmlSerializer xmlSerializer = Xml.newSerializer();
        try {
          xmlSerializer.setOutput(fileOutputStream, null);
          xmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
          xmlSerializer.startTag(null, "historical-records");
          int i = list.size();
          for (byte b = 0; b < i; b++) {
            d.c c = (d.c)list.remove(0);
            xmlSerializer.startTag(null, "historical-record");
            xmlSerializer.attribute(null, "activity", c.a.flattenToString());
            xmlSerializer.attribute(null, "time", String.valueOf(c.b));
            xmlSerializer.attribute(null, "weight", String.valueOf(c.c));
            xmlSerializer.endTag(null, "historical-record");
          } 
          xmlSerializer.endTag(null, "historical-records");
          xmlSerializer.endDocument();
          this.a.d = true;
          if (fileOutputStream != null) {
            fileOutputStream.close();
            return null;
          } 
        } catch (IllegalArgumentException illegalArgumentException) {
          String str1 = d.a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Error writing historical record file: ");
          stringBuilder.append(this.a.c);
          Log.e(str1, stringBuilder.toString(), illegalArgumentException);
          this.a.d = true;
          if (fileOutputStream != null) {
            fileOutputStream.close();
            return null;
          } 
        } catch (IllegalStateException illegalStateException) {
          String str1 = d.a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Error writing historical record file: ");
          stringBuilder.append(this.a.c);
          Log.e(str1, stringBuilder.toString(), illegalStateException);
          this.a.d = true;
          if (fileOutputStream != null) {
            fileOutputStream.close();
            return null;
          } 
        } catch (IOException iOException) {
          String str1 = d.a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Error writing historical record file: ");
          stringBuilder.append(this.a.c);
          Log.e(str1, stringBuilder.toString(), iOException);
          this.a.d = true;
          if (fileOutputStream != null) {
            fileOutputStream.close();
            return null;
          } 
        } finally {
          API aPI;
        } 
        return null;
      } catch (FileNotFoundException fileNotFoundException) {
        String str1 = d.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error writing historical record file: ");
        stringBuilder.append(str);
        Log.e(str1, stringBuilder.toString(), fileNotFoundException);
        return null;
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */