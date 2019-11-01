package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.g.a;
import android.support.v4.h.r;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class r {
  private static final int[] a;
  
  private static final t b;
  
  private static final t c;
  
  static  {
    Object object;
    a = new int[] { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
    if (Build.VERSION.SDK_INT >= 21) {
      object = new s();
    } else {
      object = null;
    } 
    b = object;
    c = a();
  }
  
  private static a a(a parama, SparseArray<a> paramSparseArray, int paramInt) {
    if (parama == null) {
      parama = new a();
      paramSparseArray.put(paramInt, parama);
    } 
    return parama;
  }
  
  private static t a() {
    try {
      return (t)Class.forName("android.support.e.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static t a(g paramg1, g paramg2) {
    ArrayList arrayList = new ArrayList();
    if (paramg1 != null) {
      Object object1 = paramg1.y();
      if (object1 != null)
        arrayList.add(object1); 
      Object object2 = paramg1.x();
      if (object2 != null)
        arrayList.add(object2); 
      Object object3 = paramg1.B();
      if (object3 != null)
        arrayList.add(object3); 
    } 
    if (paramg2 != null) {
      Object object1 = paramg2.w();
      if (object1 != null)
        arrayList.add(object1); 
      Object object2 = paramg2.z();
      if (object2 != null)
        arrayList.add(object2); 
      Object object3 = paramg2.A();
      if (object3 != null)
        arrayList.add(object3); 
    } 
    if (arrayList.isEmpty())
      return null; 
    t t1 = b;
    if (t1 != null && a(t1, arrayList))
      return b; 
    t t2 = c;
    if (t2 != null && a(t2, arrayList))
      return c; 
    if (b == null && c == null)
      return null; 
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  private static a<String, String> a(int paramInt1, ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt2, int paramInt3) {
    a a1 = new a();
    for (int i = paramInt3 - 1; i >= paramInt2; i--) {
      c c1 = (c)paramArrayList1.get(i);
      if (c1.b(paramInt1)) {
        boolean bool = ((Boolean)paramArrayList2.get(i)).booleanValue();
        if (c1.r != null) {
          ArrayList arrayList2;
          ArrayList arrayList1;
          int j = c1.r.size();
          if (bool) {
            arrayList1 = c1.r;
            arrayList2 = c1.s;
          } else {
            ArrayList arrayList = c1.r;
            arrayList1 = c1.s;
            arrayList2 = arrayList;
          } 
          for (byte b1 = 0; b1 < j; b1++) {
            String str1 = (String)arrayList2.get(b1);
            String str2 = (String)arrayList1.get(b1);
            String str3 = (String)a1.remove(str2);
            if (str3 != null) {
              a1.put(str1, str3);
            } else {
              a1.put(str1, str2);
            } 
          } 
        } 
      } 
    } 
    return a1;
  }
  
  static a<String, View> a(t paramt, a<String, String> parama, Object paramObject, a parama1) {
    ArrayList arrayList;
    ac ac;
    g g = parama1.a;
    View view = g.q();
    if (parama.isEmpty() || paramObject == null || view == null) {
      parama.clear();
      return null;
    } 
    a a1 = new a();
    paramt.a(a1, view);
    c c1 = parama1.c;
    if (parama1.b) {
      ac = g.U();
      arrayList = c1.r;
    } else {
      ac = g.T();
      arrayList = c1.s;
    } 
    if (arrayList != null) {
      a1.a(arrayList);
      a1.a(parama.values());
    } 
    if (ac != null) {
      ac.a(arrayList, a1);
      for (int i = -1 + arrayList.size(); i >= 0; i--) {
        String str = (String)arrayList.get(i);
        View view1 = (View)a1.get(str);
        if (view1 == null) {
          String str1 = a(parama, str);
          if (str1 != null)
            parama.remove(str1); 
        } else if (!str.equals(r.n(view1))) {
          String str1 = a(parama, str);
          if (str1 != null)
            parama.put(str1, r.n(view1)); 
        } 
      } 
    } else {
      a(parama, a1);
    } 
    return a1;
  }
  
  static View a(a<String, View> parama, a parama1, Object paramObject, boolean paramBoolean) {
    c c1 = parama1.c;
    if (paramObject != null && parama != null && c1.r != null && !c1.r.isEmpty()) {
      ArrayList arrayList;
      if (paramBoolean) {
        arrayList = c1.r;
      } else {
        arrayList = c1.s;
      } 
      return (View)parama.get((String)arrayList.get(0));
    } 
    return null;
  }
  
  private static Object a(t paramt, g paramg1, g paramg2, boolean paramBoolean) {
    Object object;
    if (paramg1 == null || paramg2 == null)
      return null; 
    if (paramBoolean) {
      object = paramg2.B();
    } else {
      object = paramg1.A();
    } 
    return paramt.c(paramt.b(object));
  }
  
  private static Object a(t paramt, g paramg, boolean paramBoolean) {
    Object object;
    if (paramg == null)
      return null; 
    if (paramBoolean) {
      object = paramg.z();
    } else {
      object = paramg.w();
    } 
    return paramt.b(object);
  }
  
  private static Object a(t paramt, ViewGroup paramViewGroup, View paramView, a<String, String> parama, a parama1, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2) {
    g g1 = parama1.a;
    g g2 = parama1.d;
    if (g1 != null)
      g1.q().setVisibility(0); 
    if (g1 != null) {
      Rect rect;
      View view;
      Object object2;
      Object object1;
      if (g2 == null)
        return null; 
      boolean bool = parama1.b;
      if (parama.isEmpty()) {
        object1 = null;
      } else {
        object1 = a(paramt, g1, g2, bool);
      } 
      a a1 = b(paramt, parama, object1, parama1);
      a a2 = a(paramt, parama, object1, parama1);
      if (parama.isEmpty()) {
        if (a1 != null)
          a1.clear(); 
        if (a2 != null)
          a2.clear(); 
        object2 = null;
      } else {
        a(paramArrayList1, a1, parama.keySet());
        a(paramArrayList2, a2, parama.values());
        object2 = object1;
      } 
      if (paramObject1 == null && paramObject2 == null && object2 == null)
        return null; 
      a(g1, g2, bool, a1, true);
      if (object2 != null) {
        paramArrayList2.add(paramView);
        paramt.a(object2, paramView, paramArrayList1);
        boolean bool1 = parama1.e;
        c c1 = parama1.f;
        a(paramt, object2, paramObject2, a1, bool1, c1);
        Rect rect1 = new Rect();
        View view1 = a(a2, parama1, paramObject1, bool);
        if (view1 != null)
          paramt.a(paramObject1, rect1); 
        rect = rect1;
        view = view1;
      } else {
        view = null;
        rect = null;
      } 
      Runnable runnable = new Runnable(g1, g2, bool, a2, view, paramt, rect) {
          public void run() {
            r.a(this.a, this.b, this.c, this.d, false);
            View view = this.e;
            if (view != null)
              this.f.a(view, this.g); 
          }
        };
      aa.a(paramViewGroup, runnable);
      return object2;
    } 
    return null;
  }
  
  private static Object a(t paramt, Object paramObject1, Object paramObject2, Object paramObject3, g paramg, boolean paramBoolean) {
    boolean bool;
    if (paramObject1 != null && paramObject2 != null && paramg != null) {
      if (paramBoolean) {
        bool = paramg.D();
      } else {
        bool = paramg.C();
      } 
    } else {
      bool = true;
    } 
    return bool ? paramt.a(paramObject2, paramObject1, paramObject3) : paramt.b(paramObject2, paramObject1, paramObject3);
  }
  
  private static String a(a<String, String> parama, String paramString) {
    int i = parama.size();
    for (byte b1 = 0; b1 < i; b1++) {
      if (paramString.equals(parama.c(b1)))
        return (String)parama.b(b1); 
    } 
    return null;
  }
  
  static ArrayList<View> a(t paramt, Object paramObject, g paramg, ArrayList<View> paramArrayList, View paramView) {
    ArrayList<View> arrayList;
    if (paramObject != null) {
      arrayList = new ArrayList();
      View view = paramg.q();
      if (view != null)
        paramt.a(arrayList, view); 
      if (paramArrayList != null)
        arrayList.removeAll(paramArrayList); 
      if (!arrayList.isEmpty()) {
        arrayList.add(paramView);
        paramt.a(paramObject, arrayList);
        return arrayList;
      } 
    } else {
      arrayList = null;
    } 
    return arrayList;
  }
  
  private static void a(c paramc, c.a parama, SparseArray<a> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2) { // Byte code:
    //   0: aload_1
    //   1: getfield b : Landroid/support/v4/app/g;
    //   4: astore #5
    //   6: aload #5
    //   8: ifnonnull -> 12
    //   11: return
    //   12: aload #5
    //   14: getfield I : I
    //   17: istore #6
    //   19: iload #6
    //   21: ifne -> 25
    //   24: return
    //   25: iload_3
    //   26: ifeq -> 42
    //   29: getstatic android/support/v4/app/r.a : [I
    //   32: aload_1
    //   33: getfield a : I
    //   36: iaload
    //   37: istore #7
    //   39: goto -> 48
    //   42: aload_1
    //   43: getfield a : I
    //   46: istore #7
    //   48: iconst_0
    //   49: istore #8
    //   51: iload #7
    //   53: iconst_1
    //   54: if_icmpeq -> 286
    //   57: iload #7
    //   59: tableswitch default -> 92, 3 -> 197, 4 -> 146, 5 -> 104, 6 -> 197, 7 -> 286
    //   92: iconst_0
    //   93: istore #10
    //   95: iconst_0
    //   96: istore #11
    //   98: iconst_0
    //   99: istore #12
    //   101: goto -> 336
    //   104: iload #4
    //   106: ifeq -> 136
    //   109: aload #5
    //   111: getfield Y : Z
    //   114: ifeq -> 323
    //   117: aload #5
    //   119: getfield K : Z
    //   122: ifne -> 323
    //   125: aload #5
    //   127: getfield u : Z
    //   130: ifeq -> 323
    //   133: goto -> 317
    //   136: aload #5
    //   138: getfield K : Z
    //   141: istore #9
    //   143: goto -> 326
    //   146: iload #4
    //   148: ifeq -> 178
    //   151: aload #5
    //   153: getfield Y : Z
    //   156: ifeq -> 245
    //   159: aload #5
    //   161: getfield u : Z
    //   164: ifeq -> 245
    //   167: aload #5
    //   169: getfield K : Z
    //   172: ifeq -> 245
    //   175: goto -> 239
    //   178: aload #5
    //   180: getfield u : Z
    //   183: ifeq -> 245
    //   186: aload #5
    //   188: getfield K : Z
    //   191: ifne -> 245
    //   194: goto -> 175
    //   197: iload #4
    //   199: ifeq -> 251
    //   202: aload #5
    //   204: getfield u : Z
    //   207: ifne -> 245
    //   210: aload #5
    //   212: getfield S : Landroid/view/View;
    //   215: ifnull -> 245
    //   218: aload #5
    //   220: getfield S : Landroid/view/View;
    //   223: invokevirtual getVisibility : ()I
    //   226: ifne -> 245
    //   229: aload #5
    //   231: getfield Z : F
    //   234: fconst_0
    //   235: fcmpl
    //   236: iflt -> 245
    //   239: iconst_1
    //   240: istore #16
    //   242: goto -> 270
    //   245: iconst_0
    //   246: istore #16
    //   248: goto -> 270
    //   251: aload #5
    //   253: getfield u : Z
    //   256: ifeq -> 245
    //   259: aload #5
    //   261: getfield K : Z
    //   264: ifne -> 245
    //   267: goto -> 239
    //   270: iload #16
    //   272: istore #12
    //   274: iconst_1
    //   275: istore #11
    //   277: iconst_0
    //   278: istore #10
    //   280: iconst_0
    //   281: istore #8
    //   283: goto -> 336
    //   286: iload #4
    //   288: ifeq -> 301
    //   291: aload #5
    //   293: getfield X : Z
    //   296: istore #9
    //   298: goto -> 326
    //   301: aload #5
    //   303: getfield u : Z
    //   306: ifne -> 323
    //   309: aload #5
    //   311: getfield K : Z
    //   314: ifne -> 323
    //   317: iconst_1
    //   318: istore #9
    //   320: goto -> 326
    //   323: iconst_0
    //   324: istore #9
    //   326: iload #9
    //   328: istore #8
    //   330: iconst_1
    //   331: istore #10
    //   333: goto -> 95
    //   336: aload_2
    //   337: iload #6
    //   339: invokevirtual get : (I)Ljava/lang/Object;
    //   342: checkcast android/support/v4/app/r$a
    //   345: astore #13
    //   347: iload #8
    //   349: ifeq -> 381
    //   352: aload #13
    //   354: aload_2
    //   355: iload #6
    //   357: invokestatic a : (Landroid/support/v4/app/r$a;Landroid/util/SparseArray;I)Landroid/support/v4/app/r$a;
    //   360: astore #13
    //   362: aload #13
    //   364: aload #5
    //   366: putfield a : Landroid/support/v4/app/g;
    //   369: aload #13
    //   371: iload_3
    //   372: putfield b : Z
    //   375: aload #13
    //   377: aload_0
    //   378: putfield c : Landroid/support/v4/app/c;
    //   381: aload #13
    //   383: astore #14
    //   385: iload #4
    //   387: ifne -> 465
    //   390: iload #10
    //   392: ifeq -> 465
    //   395: aload #14
    //   397: ifnull -> 416
    //   400: aload #14
    //   402: getfield d : Landroid/support/v4/app/g;
    //   405: aload #5
    //   407: if_acmpne -> 416
    //   410: aload #14
    //   412: aconst_null
    //   413: putfield d : Landroid/support/v4/app/g;
    //   416: aload_0
    //   417: getfield a : Landroid/support/v4/app/m;
    //   420: astore #15
    //   422: aload #5
    //   424: getfield k : I
    //   427: iconst_1
    //   428: if_icmpge -> 465
    //   431: aload #15
    //   433: getfield l : I
    //   436: iconst_1
    //   437: if_icmplt -> 465
    //   440: aload_0
    //   441: getfield t : Z
    //   444: ifne -> 465
    //   447: aload #15
    //   449: aload #5
    //   451: invokevirtual f : (Landroid/support/v4/app/g;)V
    //   454: aload #15
    //   456: aload #5
    //   458: iconst_1
    //   459: iconst_0
    //   460: iconst_0
    //   461: iconst_0
    //   462: invokevirtual a : (Landroid/support/v4/app/g;IIIZ)V
    //   465: iload #12
    //   467: ifeq -> 512
    //   470: aload #14
    //   472: ifnull -> 483
    //   475: aload #14
    //   477: getfield d : Landroid/support/v4/app/g;
    //   480: ifnonnull -> 512
    //   483: aload #14
    //   485: aload_2
    //   486: iload #6
    //   488: invokestatic a : (Landroid/support/v4/app/r$a;Landroid/util/SparseArray;I)Landroid/support/v4/app/r$a;
    //   491: astore #14
    //   493: aload #14
    //   495: aload #5
    //   497: putfield d : Landroid/support/v4/app/g;
    //   500: aload #14
    //   502: iload_3
    //   503: putfield e : Z
    //   506: aload #14
    //   508: aload_0
    //   509: putfield f : Landroid/support/v4/app/c;
    //   512: iload #4
    //   514: ifne -> 543
    //   517: iload #11
    //   519: ifeq -> 543
    //   522: aload #14
    //   524: ifnull -> 543
    //   527: aload #14
    //   529: getfield a : Landroid/support/v4/app/g;
    //   532: aload #5
    //   534: if_acmpne -> 543
    //   537: aload #14
    //   539: aconst_null
    //   540: putfield a : Landroid/support/v4/app/g;
    //   543: return }
  
  public static void a(c paramc, SparseArray<a> paramSparseArray, boolean paramBoolean) {
    int i = paramc.b.size();
    for (byte b1 = 0; b1 < i; b1++)
      a(paramc, (c.a)paramc.b.get(b1), paramSparseArray, false, paramBoolean); 
  }
  
  static void a(g paramg1, g paramg2, boolean paramBoolean1, a<String, View> parama, boolean paramBoolean2) {
    ac ac;
    if (paramBoolean1) {
      ac = paramg2.T();
    } else {
      ac = paramg1.T();
    } 
    if (ac != null) {
      int i;
      ArrayList arrayList1 = new ArrayList();
      ArrayList arrayList2 = new ArrayList();
      byte b1 = 0;
      if (parama == null) {
        b1 = 0;
        i = 0;
      } else {
        i = parama.size();
      } 
      while (b1 < i) {
        arrayList2.add(parama.b(b1));
        arrayList1.add(parama.c(b1));
        b1++;
      } 
      if (paramBoolean2) {
        ac.a(arrayList2, arrayList1, null);
        return;
      } 
      ac.b(arrayList2, arrayList1, null);
    } 
  }
  
  private static void a(m paramm, int paramInt, a parama, View paramView, a<String, String> parama1) {
    Object object4;
    Object object;
    if (paramm.n.a()) {
      object = (ViewGroup)paramm.n.a(paramInt);
    } else {
      object = null;
    } 
    ViewGroup viewGroup = object;
    if (viewGroup == null)
      return; 
    g g1 = parama.a;
    g g2 = parama.d;
    t t1 = a(g2, g1);
    if (t1 == null)
      return; 
    boolean bool1 = parama.b;
    boolean bool2 = parama.e;
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    Object object1 = a(t1, g1, bool1);
    Object object2 = b(t1, g2, bool2);
    Object object3 = a(t1, viewGroup, paramView, parama1, parama, arrayList2, arrayList1, object1, object2);
    if (object1 == null && object3 == null) {
      object4 = object2;
      if (object4 == null)
        return; 
    } else {
      object4 = object2;
    } 
    ArrayList arrayList3 = a(t1, object4, g2, arrayList2, paramView);
    ArrayList arrayList4 = a(t1, object1, g1, arrayList1, paramView);
    a(arrayList4, 4);
    Object object5 = a(t1, object1, object4, object3, g1, bool1);
    if (object5 != null) {
      a(t1, object4, g2, arrayList3);
      ArrayList arrayList = t1.a(arrayList1);
      t1.a(object5, object1, arrayList4, object4, arrayList3, object3, arrayList1);
      t1.a(viewGroup, object5);
      t1.a(viewGroup, arrayList2, arrayList1, arrayList, parama1);
      a(arrayList4, 0);
      t1.a(object3, arrayList2, arrayList1);
    } 
  }
  
  static void a(m paramm, ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramm.l < 1)
      return; 
    SparseArray sparseArray = new SparseArray();
    for (int i = paramInt1; i < paramInt2; i++) {
      c c1 = (c)paramArrayList1.get(i);
      if (((Boolean)paramArrayList2.get(i)).booleanValue()) {
        b(c1, sparseArray, paramBoolean);
      } else {
        a(c1, sparseArray, paramBoolean);
      } 
    } 
    if (sparseArray.size() != 0) {
      View view = new View(paramm.m.g());
      int j = sparseArray.size();
      for (byte b1 = 0; b1 < j; b1++) {
        int k = sparseArray.keyAt(b1);
        a a1 = a(k, paramArrayList1, paramArrayList2, paramInt1, paramInt2);
        a a2 = (a)sparseArray.valueAt(b1);
        if (paramBoolean) {
          a(paramm, k, a2, view, a1);
        } else {
          b(paramm, k, a2, view, a1);
        } 
      } 
    } 
  }
  
  private static void a(t paramt, ViewGroup paramViewGroup, g paramg, View paramView, ArrayList<View> paramArrayList1, Object paramObject1, ArrayList<View> paramArrayList2, Object paramObject2, ArrayList<View> paramArrayList3) {
    Runnable runnable = new Runnable(paramObject1, paramt, paramView, paramg, paramArrayList1, paramArrayList2, paramArrayList3, paramObject2) {
        public void run() {
          Object object = this.a;
          if (object != null) {
            this.b.c(object, this.c);
            ArrayList arrayList = r.a(this.b, this.a, this.d, this.e, this.c);
            this.f.addAll(arrayList);
          } 
          if (this.g != null) {
            if (this.h != null) {
              ArrayList arrayList = new ArrayList();
              arrayList.add(this.c);
              this.b.b(this.h, this.g, arrayList);
            } 
            this.g.clear();
            this.g.add(this.c);
          } 
        }
      };
    aa.a(paramViewGroup, runnable);
  }
  
  private static void a(t paramt, Object paramObject, g paramg, ArrayList<View> paramArrayList) {
    if (paramg != null && paramObject != null && paramg.u && paramg.K && paramg.Y) {
      paramg.h(true);
      paramt.b(paramObject, paramg.q(), paramArrayList);
      aa.a(paramg.R, new Runnable(paramArrayList) {
            public void run() { r.a(this.a, 4); }
          });
    } 
  }
  
  private static void a(t paramt, Object paramObject1, Object paramObject2, a<String, View> parama, boolean paramBoolean, c paramc) {
    if (paramc.r != null && !paramc.r.isEmpty()) {
      ArrayList arrayList;
      if (paramBoolean) {
        arrayList = paramc.s;
      } else {
        arrayList = paramc.r;
      } 
      View view = (View)parama.get((String)arrayList.get(0));
      paramt.a(paramObject1, view);
      if (paramObject2 != null)
        paramt.a(paramObject2, view); 
    } 
  }
  
  private static void a(a<String, String> parama1, a<String, View> parama2) {
    for (int i = -1 + parama1.size(); i >= 0; i--) {
      if (!parama2.containsKey((String)parama1.c(i)))
        parama1.d(i); 
    } 
  }
  
  static void a(ArrayList<View> paramArrayList, int paramInt) {
    if (paramArrayList == null)
      return; 
    for (int i = -1 + paramArrayList.size(); i >= 0; i--)
      ((View)paramArrayList.get(i)).setVisibility(paramInt); 
  }
  
  private static void a(ArrayList<View> paramArrayList, a<String, View> parama, Collection<String> paramCollection) {
    for (int i = -1 + parama.size(); i >= 0; i--) {
      View view = (View)parama.c(i);
      if (paramCollection.contains(r.n(view)))
        paramArrayList.add(view); 
    } 
  }
  
  private static boolean a(t paramt, List<Object> paramList) {
    int i = paramList.size();
    for (byte b1 = 0; b1 < i; b1++) {
      if (!paramt.a(paramList.get(b1)))
        return false; 
    } 
    return true;
  }
  
  private static a<String, View> b(t paramt, a<String, String> parama, Object paramObject, a parama1) {
    ArrayList arrayList;
    ac ac;
    if (parama.isEmpty() || paramObject == null) {
      parama.clear();
      return null;
    } 
    g g = parama1.d;
    a a1 = new a();
    paramt.a(a1, g.q());
    c c1 = parama1.f;
    if (parama1.e) {
      ac = g.T();
      arrayList = c1.s;
    } else {
      ac = g.U();
      arrayList = c1.r;
    } 
    a1.a(arrayList);
    if (ac != null) {
      ac.a(arrayList, a1);
      for (int i = -1 + arrayList.size(); i >= 0; i--) {
        String str = (String)arrayList.get(i);
        View view = (View)a1.get(str);
        if (view == null) {
          parama.remove(str);
        } else if (!str.equals(r.n(view))) {
          String str1 = (String)parama.remove(str);
          parama.put(r.n(view), str1);
        } 
      } 
    } else {
      parama.a(a1.keySet());
    } 
    return a1;
  }
  
  private static Object b(t paramt, g paramg, boolean paramBoolean) {
    Object object;
    if (paramg == null)
      return null; 
    if (paramBoolean) {
      object = paramg.x();
    } else {
      object = paramg.y();
    } 
    return paramt.b(object);
  }
  
  private static Object b(t paramt, ViewGroup paramViewGroup, View paramView, a<String, String> parama, a parama1, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2) {
    g g1 = parama1.a;
    g g2 = parama1.d;
    if (g1 != null) {
      Rect rect;
      Object object2;
      a<String, String> a1;
      Object object1;
      if (g2 == null)
        return null; 
      boolean bool = parama1.b;
      if (parama.isEmpty()) {
        a1 = parama;
        object1 = null;
      } else {
        object1 = a(paramt, g1, g2, bool);
        a1 = parama;
      } 
      a a2 = b(paramt, a1, object1, parama1);
      if (parama.isEmpty()) {
        object2 = null;
      } else {
        paramArrayList1.addAll(a2.values());
        object2 = object1;
      } 
      if (paramObject1 == null && paramObject2 == null && object2 == null)
        return null; 
      a(g1, g2, bool, a2, true);
      if (object2 != null) {
        rect = new Rect();
        paramt.a(object2, paramView, paramArrayList1);
        boolean bool1 = parama1.e;
        c c1 = parama1.f;
        a(paramt, object2, paramObject2, a2, bool1, c1);
        if (paramObject1 != null)
          paramt.a(paramObject1, rect); 
      } else {
        rect = null;
      } 
      Runnable runnable = new Runnable(paramt, parama, object2, parama1, paramArrayList2, paramView, g1, g2, bool, paramArrayList1, paramObject1, rect) {
          public void run() {
            a a1 = r.a(this.a, this.b, this.c, this.d);
            if (a1 != null) {
              this.e.addAll(a1.values());
              this.e.add(this.f);
            } 
            r.a(this.g, this.h, this.i, a1, false);
            Object object = this.c;
            if (object != null) {
              this.a.a(object, this.j, this.e);
              View view = r.a(a1, this.d, this.k, this.i);
              if (view != null)
                this.a.a(view, this.l); 
            } 
          }
        };
      aa.a(paramViewGroup, runnable);
      return object2;
    } 
    return null;
  }
  
  public static void b(c paramc, SparseArray<a> paramSparseArray, boolean paramBoolean) {
    if (!paramc.a.n.a())
      return; 
    for (int i = paramc.b.size() - 1; i >= 0; i--)
      a(paramc, (c.a)paramc.b.get(i), paramSparseArray, true, paramBoolean); 
  }
  
  private static void b(m paramm, int paramInt, a parama, View paramView, a<String, String> parama1) {
    Object object5;
    Object object4;
    ViewGroup viewGroup;
    if (paramm.n.a()) {
      viewGroup = (ViewGroup)paramm.n.a(paramInt);
    } else {
      viewGroup = null;
    } 
    if (viewGroup == null)
      return; 
    g g1 = parama.a;
    g g2 = parama.d;
    t t1 = a(g2, g1);
    if (t1 == null)
      return; 
    boolean bool1 = parama.b;
    boolean bool2 = parama.e;
    Object object1 = a(t1, g1, bool1);
    Object object2 = b(t1, g2, bool2);
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    Object object3 = b(t1, viewGroup, paramView, parama1, parama, arrayList1, arrayList2, object1, object2);
    if (object1 == null && object3 == null) {
      object4 = object2;
      if (object4 == null)
        return; 
    } else {
      object4 = object2;
    } 
    ArrayList arrayList3 = a(t1, object4, g2, arrayList1, paramView);
    if (arrayList3 == null || arrayList3.isEmpty()) {
      object5 = null;
    } else {
      object5 = object4;
    } 
    t1.b(object1, paramView);
    boolean bool3 = parama.b;
    Object object6 = a(t1, object1, object5, object3, g1, bool3);
    if (object6 != null) {
      ArrayList arrayList = new ArrayList();
      t1.a(object6, object1, arrayList, object5, arrayList3, object3, arrayList2);
      a(t1, viewGroup, g1, paramView, arrayList2, object1, arrayList, object5, arrayList3);
      t1.a(viewGroup, arrayList2, parama1);
      t1.a(viewGroup, object6);
      t1.a(viewGroup, arrayList2, parama1);
    } 
  }
  
  static class a {
    public g a;
    
    public boolean b;
    
    public c c;
    
    public g d;
    
    public boolean e;
    
    public c f;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */