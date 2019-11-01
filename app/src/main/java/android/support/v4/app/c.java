package android.support.v4.app;

import android.support.v4.g.e;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class c extends q implements m.h {
  final m a;
  
  ArrayList<a> b = new ArrayList();
  
  int c;
  
  int d;
  
  int e;
  
  int f;
  
  int g;
  
  int h;
  
  boolean i;
  
  boolean j = true;
  
  String k;
  
  boolean l;
  
  int m = -1;
  
  int n;
  
  CharSequence o;
  
  int p;
  
  CharSequence q;
  
  ArrayList<String> r;
  
  ArrayList<String> s;
  
  boolean t = false;
  
  ArrayList<Runnable> u;
  
  public c(m paramm) { this.a = paramm; }
  
  private void a(int paramInt1, g paramg, String paramString, int paramInt2) {
    Class clazz = paramg.getClass();
    int i1 = clazz.getModifiers();
    if (!clazz.isAnonymousClass() && Modifier.isPublic(i1) && (!clazz.isMemberClass() || Modifier.isStatic(i1))) {
      paramg.B = this.a;
      if (paramString != null)
        if (paramg.J == null || paramString.equals(paramg.J)) {
          paramg.J = paramString;
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Can't change tag of fragment ");
          stringBuilder1.append(paramg);
          stringBuilder1.append(": was ");
          stringBuilder1.append(paramg.J);
          stringBuilder1.append(" now ");
          stringBuilder1.append(paramString);
          throw new IllegalStateException(stringBuilder1.toString());
        }  
      if (paramInt1 != 0)
        if (paramInt1 != -1) {
          if (paramg.H == 0 || paramg.H == paramInt1) {
            paramg.H = paramInt1;
            paramg.I = paramInt1;
          } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Can't change container ID of fragment ");
            stringBuilder1.append(paramg);
            stringBuilder1.append(": was ");
            stringBuilder1.append(paramg.H);
            stringBuilder1.append(" now ");
            stringBuilder1.append(paramInt1);
            throw new IllegalStateException(stringBuilder1.toString());
          } 
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Can't add fragment ");
          stringBuilder1.append(paramg);
          stringBuilder1.append(" with tag ");
          stringBuilder1.append(paramString);
          stringBuilder1.append(" to container view with no id");
          throw new IllegalArgumentException(stringBuilder1.toString());
        }  
      a(new a(paramInt2, paramg));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(clazz.getCanonicalName());
    stringBuilder.append(" must be a public static class to be  properly recreated from");
    stringBuilder.append(" instance state.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private static boolean b(a parama) {
    g g1 = parama.b;
    return (g1 != null && g1.u && g1.S != null && !g1.L && !g1.K && g1.Y());
  }
  
  int a(boolean paramBoolean) {
    if (!this.l) {
      byte b1;
      if (m.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Commit: ");
        stringBuilder.append(this);
        Log.v("FragmentManager", stringBuilder.toString());
        PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
        a("  ", null, printWriter, null);
        printWriter.close();
      } 
      this.l = true;
      if (this.i) {
        b1 = this.a.a(this);
      } else {
        b1 = -1;
      } 
      this.m = b1;
      this.a.a(this, paramBoolean);
      return this.m;
    } 
    throw new IllegalStateException("commit already called");
  }
  
  g a(ArrayList<g> paramArrayList, g paramg) {
    g g1 = paramg;
    for (byte b1 = 0; b1 < this.b.size(); b1++) {
      boolean bool;
      byte b2;
      g g3;
      int i2;
      int i1;
      g g2;
      a a1 = (a)this.b.get(b1);
      switch (a1.a) {
        case 8:
          this.b.add(b1, new a(9, g1));
          b1++;
          g1 = a1.b;
          break;
        case 3:
        case 6:
          paramArrayList.remove(a1.b);
          if (a1.b == g1) {
            this.b.add(b1, new a(9, a1.b));
            b1++;
            g1 = null;
          } 
          break;
        case 2:
          g2 = a1.b;
          i1 = g2.I;
          i2 = paramArrayList.size() - 1;
          g3 = g1;
          b2 = b1;
          bool = false;
          while (i2 >= 0) {
            g g4 = (g)paramArrayList.get(i2);
            if (g4.I == i1)
              if (g4 == g2) {
                bool = true;
              } else {
                if (g4 == g3) {
                  this.b.add(b2, new a(9, g4));
                  b2++;
                  g3 = null;
                } 
                a a2 = new a(3, g4);
                a2.c = a1.c;
                a2.e = a1.e;
                a2.d = a1.d;
                a2.f = a1.f;
                this.b.add(b2, a2);
                paramArrayList.remove(g4);
                b2++;
              }  
            i2--;
          } 
          if (bool) {
            this.b.remove(b2);
            b2--;
          } else {
            a1.a = 1;
            paramArrayList.add(g2);
          } 
          b1 = b2;
          g1 = g3;
          break;
        case 1:
        case 7:
          paramArrayList.add(a1.b);
          break;
      } 
    } 
    return g1;
  }
  
  public q a(g paramg) {
    a(new a(3, paramg));
    return this;
  }
  
  public q a(g paramg, String paramString) {
    a(0, paramg, paramString, 1);
    return this;
  }
  
  public void a() {
    ArrayList arrayList = this.u;
    if (arrayList != null) {
      byte b1 = 0;
      int i1 = arrayList.size();
      while (b1 < i1) {
        ((Runnable)this.u.get(b1)).run();
        b1++;
      } 
      this.u = null;
    } 
  }
  
  void a(int paramInt) {
    if (!this.i)
      return; 
    if (m.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Bump nesting in ");
      stringBuilder.append(this);
      stringBuilder.append(" by ");
      stringBuilder.append(paramInt);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    int i1 = this.b.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      a a1 = (a)this.b.get(b1);
      if (a1.b != null) {
        g g1 = a1.b;
        g1.A = paramInt + g1.A;
        if (m.a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Bump nesting of ");
          stringBuilder.append(a1.b);
          stringBuilder.append(" to ");
          stringBuilder.append(a1.b.A);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
      } 
    } 
  }
  
  void a(a parama) {
    this.b.add(parama);
    parama.c = this.c;
    parama.d = this.d;
    parama.e = this.e;
    parama.f = this.f;
  }
  
  void a(g.c paramc) {
    for (byte b1 = 0; b1 < this.b.size(); b1++) {
      a a1 = (a)this.b.get(b1);
      if (b(a1))
        a1.b.a(paramc); 
    } 
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) { a(paramString, paramPrintWriter, true); }
  
  public void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean) {
    if (paramBoolean) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.k);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.m);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.l);
      if (this.g != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.g));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.h));
      } 
      if (this.c != 0 || this.d != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.c));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.d));
      } 
      if (this.e != 0 || this.f != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.e));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.f));
      } 
      if (this.n != 0 || this.o != null) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.n));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.o);
      } 
      if (this.p != 0 || this.q != null) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.p));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.q);
      } 
    } 
    if (!this.b.isEmpty()) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("    ");
      stringBuilder.toString();
      int i1 = this.b.size();
      for (byte b1 = 0; b1 < i1; b1++) {
        StringBuilder stringBuilder1;
        String str;
        a a1 = (a)this.b.get(b1);
        switch (a1.a) {
          default:
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("cmd=");
            stringBuilder1.append(a1.a);
            str = stringBuilder1.toString();
            break;
          case 9:
            str = "UNSET_PRIMARY_NAV";
            break;
          case 8:
            str = "SET_PRIMARY_NAV";
            break;
          case 7:
            str = "ATTACH";
            break;
          case 6:
            str = "DETACH";
            break;
          case 5:
            str = "SHOW";
            break;
          case 4:
            str = "HIDE";
            break;
          case 3:
            str = "REMOVE";
            break;
          case 2:
            str = "REPLACE";
            break;
          case 1:
            str = "ADD";
            break;
          case 0:
            str = "NULL";
            break;
        } 
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  Op #");
        paramPrintWriter.print(b1);
        paramPrintWriter.print(": ");
        paramPrintWriter.print(str);
        paramPrintWriter.print(" ");
        paramPrintWriter.println(a1.b);
        if (paramBoolean) {
          if (a1.c != 0 || a1.d != 0) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(a1.c));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(a1.d));
          } 
          if (a1.e != 0 || a1.f != 0) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(a1.e));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(a1.f));
          } 
        } 
      } 
    } 
  }
  
  boolean a(ArrayList<c> paramArrayList, int paramInt1, int paramInt2) {
    if (paramInt2 == paramInt1)
      return false; 
    int i1 = this.b.size();
    byte b1 = 0;
    byte b2 = -1;
    while (b1 < i1) {
      byte b3;
      a a1 = (a)this.b.get(b1);
      if (a1.b != null) {
        b3 = a1.b.I;
      } else {
        b3 = 0;
      } 
      if (b3 && b3 != b2) {
        for (int i2 = paramInt1; i2 < paramInt2; i2++) {
          c c1 = (c)paramArrayList.get(i2);
          int i3 = c1.b.size();
          for (byte b4 = 0; b4 < i3; b4++) {
            boolean bool;
            a a2 = (a)c1.b.get(b4);
            if (a2.b != null) {
              bool = a2.b.I;
            } else {
              bool = false;
            } 
            if (bool == b3)
              return true; 
          } 
        } 
        b2 = b3;
      } 
      b1++;
    } 
    return false;
  }
  
  public boolean a(ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2) {
    if (m.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Run: ");
      stringBuilder.append(this);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    paramArrayList1.add(this);
    paramArrayList2.add(Boolean.valueOf(false));
    if (this.i)
      this.a.b(this); 
    return true;
  }
  
  public int b() { return a(false); }
  
  g b(ArrayList<g> paramArrayList, g paramg) {
    byte b1 = 0;
    while (b1 < this.b.size()) {
      a a1 = (a)this.b.get(b1);
      int i1 = a1.a;
      if (i1 != 1)
        if (i1 != 3) {
          switch (i1) {
            case 9:
              paramg = a1.b;
              break;
            case 8:
              paramg = null;
              break;
            case 6:
              paramArrayList.add(a1.b);
              break;
            case 7:
              paramArrayList.remove(a1.b);
              break;
          } 
          b1++;
        }  
    } 
    return paramg;
  }
  
  void b(boolean paramBoolean) {
    for (int i1 = this.b.size() - 1; i1 >= 0; i1--) {
      a a1 = (a)this.b.get(i1);
      g g1 = a1.b;
      if (g1 != null)
        g1.a(m.d(this.g), this.h); 
      int i2 = a1.a;
      if (i2 != 1) {
        StringBuilder stringBuilder;
        switch (i2) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown cmd: ");
            stringBuilder.append(a1.a);
            throw new IllegalArgumentException(stringBuilder.toString());
          case 9:
            this.a.o(g1);
            break;
          case 8:
            this.a.o(null);
            break;
          case 7:
            g1.a(a1.f);
            this.a.k(g1);
            break;
          case 6:
            g1.a(a1.e);
            this.a.l(g1);
            break;
          case 5:
            g1.a(a1.f);
            this.a.i(g1);
            break;
          case 4:
            g1.a(a1.e);
            this.a.j(g1);
            break;
          case 3:
            g1.a(a1.e);
            this.a.a(g1, false);
            break;
        } 
      } else {
        g1.a(a1.f);
        this.a.h(g1);
      } 
      if (!this.t && a1.a != 3 && g1 != null)
        this.a.e(g1); 
    } 
    if (!this.t && paramBoolean) {
      m m1 = this.a;
      m1.a(m1.l, true);
    } 
  }
  
  boolean b(int paramInt) {
    int i1 = this.b.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      boolean bool;
      a a1 = (a)this.b.get(b1);
      if (a1.b != null) {
        bool = a1.b.I;
      } else {
        bool = false;
      } 
      if (bool && bool == paramInt)
        return true; 
    } 
    return false;
  }
  
  public int c() { return a(true); }
  
  void d() {
    int i1 = this.b.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      a a1 = (a)this.b.get(b1);
      g g1 = a1.b;
      if (g1 != null)
        g1.a(this.g, this.h); 
      int i2 = a1.a;
      if (i2 != 1) {
        StringBuilder stringBuilder;
        switch (i2) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown cmd: ");
            stringBuilder.append(a1.a);
            throw new IllegalArgumentException(stringBuilder.toString());
          case 9:
            this.a.o(null);
            break;
          case 8:
            this.a.o(g1);
            break;
          case 7:
            g1.a(a1.c);
            this.a.l(g1);
            break;
          case 6:
            g1.a(a1.d);
            this.a.k(g1);
            break;
          case 5:
            g1.a(a1.c);
            this.a.j(g1);
            break;
          case 4:
            g1.a(a1.d);
            this.a.i(g1);
            break;
          case 3:
            g1.a(a1.d);
            this.a.h(g1);
            break;
        } 
      } else {
        g1.a(a1.c);
        this.a.a(g1, false);
      } 
      if (!this.t && a1.a != 1 && g1 != null)
        this.a.e(g1); 
    } 
    if (!this.t) {
      m m1 = this.a;
      m1.a(m1.l, true);
    } 
  }
  
  boolean e() {
    for (byte b1 = 0; b1 < this.b.size(); b1++) {
      if (b((a)this.b.get(b1)))
        return true; 
    } 
    return false;
  }
  
  public String f() { return this.k; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("BackStackEntry{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.m >= 0) {
      stringBuilder.append(" #");
      stringBuilder.append(this.m);
    } 
    if (this.k != null) {
      stringBuilder.append(" ");
      stringBuilder.append(this.k);
    } 
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  static final class a {
    int a;
    
    g b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
    
    a() {}
    
    a(int param1Int, g param1g) {
      this.a = param1Int;
      this.b = param1g;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */