package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.d.a.c;
import android.support.d.a.i;
import android.support.v4.g.a;
import android.support.v4.g.f;
import android.support.v4.g.g;
import android.support.v4.g.m;
import android.support.v4.graphics.a;
import android.support.v4.graphics.drawable.a;
import android.support.v7.a.a;
import android.support.v7.d.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class l {
  private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  
  private static l b;
  
  private static final c c = new c(6);
  
  private static final int[] d;
  
  private static final int[] e;
  
  private static final int[] f;
  
  private static final int[] g;
  
  private static final int[] h;
  
  private static final int[] i;
  
  private WeakHashMap<Context, m<ColorStateList>> j;
  
  private a<String, d> k;
  
  private m<String> l;
  
  private final WeakHashMap<Context, f<WeakReference<Drawable.ConstantState>>> m = new WeakHashMap(0);
  
  private TypedValue n;
  
  private boolean o;
  
  static  {
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = a.e.abc_textfield_search_default_mtrl_alpha;
    arrayOfInt1[1] = a.e.abc_textfield_default_mtrl_alpha;
    arrayOfInt1[2] = a.e.abc_ab_share_pack_mtrl_alpha;
    d = arrayOfInt1;
    int[] arrayOfInt2 = new int[7];
    arrayOfInt2[0] = a.e.abc_ic_commit_search_api_mtrl_alpha;
    arrayOfInt2[1] = a.e.abc_seekbar_tick_mark_material;
    arrayOfInt2[2] = a.e.abc_ic_menu_share_mtrl_alpha;
    arrayOfInt2[3] = a.e.abc_ic_menu_copy_mtrl_am_alpha;
    arrayOfInt2[4] = a.e.abc_ic_menu_cut_mtrl_alpha;
    arrayOfInt2[5] = a.e.abc_ic_menu_selectall_mtrl_alpha;
    arrayOfInt2[6] = a.e.abc_ic_menu_paste_mtrl_am_alpha;
    e = arrayOfInt2;
    int[] arrayOfInt3 = new int[10];
    arrayOfInt3[0] = a.e.abc_textfield_activated_mtrl_alpha;
    arrayOfInt3[1] = a.e.abc_textfield_search_activated_mtrl_alpha;
    arrayOfInt3[2] = a.e.abc_cab_background_top_mtrl_alpha;
    arrayOfInt3[3] = a.e.abc_text_cursor_material;
    arrayOfInt3[4] = a.e.abc_text_select_handle_left_mtrl_dark;
    arrayOfInt3[5] = a.e.abc_text_select_handle_middle_mtrl_dark;
    arrayOfInt3[6] = a.e.abc_text_select_handle_right_mtrl_dark;
    arrayOfInt3[7] = a.e.abc_text_select_handle_left_mtrl_light;
    arrayOfInt3[8] = a.e.abc_text_select_handle_middle_mtrl_light;
    arrayOfInt3[9] = a.e.abc_text_select_handle_right_mtrl_light;
    f = arrayOfInt3;
    int[] arrayOfInt4 = new int[3];
    arrayOfInt4[0] = a.e.abc_popup_background_mtrl_mult;
    arrayOfInt4[1] = a.e.abc_cab_background_internal_bg;
    arrayOfInt4[2] = a.e.abc_menu_hardkey_panel_mtrl_mult;
    g = arrayOfInt4;
    int[] arrayOfInt5 = new int[2];
    arrayOfInt5[0] = a.e.abc_tab_indicator_material;
    arrayOfInt5[1] = a.e.abc_textfield_search_material;
    h = arrayOfInt5;
    int[] arrayOfInt6 = new int[2];
    arrayOfInt6[0] = a.e.abc_btn_check_material;
    arrayOfInt6[1] = a.e.abc_btn_radio_material;
    i = arrayOfInt6;
  }
  
  private static long a(TypedValue paramTypedValue) { return paramTypedValue.assetCookie << 32 | paramTypedValue.data; }
  
  static PorterDuff.Mode a(int paramInt) { return (paramInt == a.e.abc_switch_thumb_material) ? PorterDuff.Mode.MULTIPLY : null; }
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode) { // Byte code:
    //   0: ldc android/support/v7/widget/l
    //   2: monitorenter
    //   3: getstatic android/support/v7/widget/l.c : Landroid/support/v7/widget/l$c;
    //   6: iload_0
    //   7: aload_1
    //   8: invokevirtual a : (ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull -> 36
    //   16: new android/graphics/PorterDuffColorFilter
    //   19: dup
    //   20: iload_0
    //   21: aload_1
    //   22: invokespecial <init> : (ILandroid/graphics/PorterDuff$Mode;)V
    //   25: astore_3
    //   26: getstatic android/support/v7/widget/l.c : Landroid/support/v7/widget/l$c;
    //   29: iload_0
    //   30: aload_1
    //   31: aload_3
    //   32: invokevirtual a : (ILandroid/graphics/PorterDuff$Mode;Landroid/graphics/PorterDuffColorFilter;)Landroid/graphics/PorterDuffColorFilter;
    //   35: pop
    //   36: ldc android/support/v7/widget/l
    //   38: monitorexit
    //   39: aload_3
    //   40: areturn
    //   41: astore_2
    //   42: ldc android/support/v7/widget/l
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	41	finally
    //   16	36	41	finally }
  
  private static PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt) { return (paramColorStateList == null || paramMode == null) ? null : a(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode); }
  
  private Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable) {
    ColorStateList colorStateList = b(paramContext, paramInt);
    if (colorStateList != null) {
      if (al.b(paramDrawable))
        paramDrawable = paramDrawable.mutate(); 
      paramDrawable = a.g(paramDrawable);
      a.a(paramDrawable, colorStateList);
      PorterDuff.Mode mode = a(paramInt);
      if (mode != null) {
        a.a(paramDrawable, mode);
        return paramDrawable;
      } 
    } else {
      if (paramInt == a.e.abc_seekbar_track_material) {
        LayerDrawable layerDrawable = (LayerDrawable)paramDrawable;
        a(layerDrawable.findDrawableByLayerId(16908288), bh.a(paramContext, a.a.colorControlNormal), a);
        Drawable drawable = layerDrawable.findDrawableByLayerId(16908303);
        int i1 = a.a.colorControlNormal;
        a(drawable, bh.a(paramContext, i1), a);
        a(layerDrawable.findDrawableByLayerId(16908301), bh.a(paramContext, a.a.colorControlActivated), a);
        return paramDrawable;
      } 
      if (paramInt == a.e.abc_ratingbar_material || paramInt == a.e.abc_ratingbar_indicator_material || paramInt == a.e.abc_ratingbar_small_material) {
        LayerDrawable layerDrawable = (LayerDrawable)paramDrawable;
        a(layerDrawable.findDrawableByLayerId(16908288), bh.c(paramContext, a.a.colorControlNormal), a);
        Drawable drawable = layerDrawable.findDrawableByLayerId(16908303);
        int i1 = a.a.colorControlActivated;
        a(drawable, bh.a(paramContext, i1), a);
        a(layerDrawable.findDrawableByLayerId(16908301), bh.a(paramContext, a.a.colorControlActivated), a);
        return paramDrawable;
      } 
      if (!a(paramContext, paramInt, paramDrawable) && paramBoolean)
        return null; 
    } 
    return paramDrawable;
  }
  
  private Drawable a(Context paramContext, long paramLong) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield m : Ljava/util/WeakHashMap;
    //   6: aload_1
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast android/support/v4/g/f
    //   13: astore #5
    //   15: aload #5
    //   17: ifnonnull -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: aconst_null
    //   23: areturn
    //   24: aload #5
    //   26: lload_2
    //   27: invokevirtual a : (J)Ljava/lang/Object;
    //   30: checkcast java/lang/ref/WeakReference
    //   33: astore #6
    //   35: aload #6
    //   37: ifnull -> 77
    //   40: aload #6
    //   42: invokevirtual get : ()Ljava/lang/Object;
    //   45: checkcast android/graphics/drawable/Drawable$ConstantState
    //   48: astore #7
    //   50: aload #7
    //   52: ifnull -> 71
    //   55: aload #7
    //   57: aload_1
    //   58: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   61: invokevirtual newDrawable : (Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   64: astore #8
    //   66: aload_0
    //   67: monitorexit
    //   68: aload #8
    //   70: areturn
    //   71: aload #5
    //   73: lload_2
    //   74: invokevirtual b : (J)V
    //   77: aload_0
    //   78: monitorexit
    //   79: aconst_null
    //   80: areturn
    //   81: astore #4
    //   83: aload_0
    //   84: monitorexit
    //   85: aload #4
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	81	finally
    //   24	35	81	finally
    //   40	50	81	finally
    //   55	66	81	finally
    //   71	77	81	finally }
  
  public static l a() { // Byte code:
    //   0: ldc android/support/v7/widget/l
    //   2: monitorenter
    //   3: getstatic android/support/v7/widget/l.b : Landroid/support/v7/widget/l;
    //   6: ifnonnull -> 25
    //   9: new android/support/v7/widget/l
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic android/support/v7/widget/l.b : Landroid/support/v7/widget/l;
    //   19: getstatic android/support/v7/widget/l.b : Landroid/support/v7/widget/l;
    //   22: invokestatic a : (Landroid/support/v7/widget/l;)V
    //   25: getstatic android/support/v7/widget/l.b : Landroid/support/v7/widget/l;
    //   28: astore_1
    //   29: ldc android/support/v7/widget/l
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: astore_0
    //   35: ldc android/support/v7/widget/l
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	34	finally
    //   25	29	34	finally }
  
  private void a(Context paramContext, int paramInt, ColorStateList paramColorStateList) {
    if (this.j == null)
      this.j = new WeakHashMap(); 
    m m1 = (m)this.j.get(paramContext);
    if (m1 == null) {
      m1 = new m();
      this.j.put(paramContext, m1);
    } 
    m1.c(paramInt, paramColorStateList);
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode) {
    if (al.b(paramDrawable))
      paramDrawable = paramDrawable.mutate(); 
    if (paramMode == null)
      paramMode = a; 
    paramDrawable.setColorFilter(a(paramInt, paramMode));
  }
  
  static void a(Drawable paramDrawable, bk parambk, int[] paramArrayOfInt) {
    if (al.b(paramDrawable) && paramDrawable.mutate() != paramDrawable) {
      Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
      return;
    } 
    if (parambk.d || parambk.c) {
      PorterDuff.Mode mode;
      ColorStateList colorStateList;
      if (parambk.d) {
        colorStateList = parambk.a;
      } else {
        colorStateList = null;
      } 
      if (parambk.c) {
        mode = parambk.b;
      } else {
        mode = a;
      } 
      paramDrawable.setColorFilter(a(colorStateList, mode, paramArrayOfInt));
    } else {
      paramDrawable.clearColorFilter();
    } 
    if (Build.VERSION.SDK_INT <= 23)
      paramDrawable.invalidateSelf(); 
  }
  
  private static void a(l paraml) {
    if (Build.VERSION.SDK_INT < 24) {
      paraml.a("vector", new e());
      paraml.a("animated-vector", new b());
      paraml.a("animated-selector", new a());
    } 
  }
  
  private void a(String paramString, d paramd) {
    if (this.k == null)
      this.k = new a(); 
    this.k.put(paramString, paramd);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable) { // Byte code:
    //   0: getstatic android/support/v7/widget/l.a : Landroid/graphics/PorterDuff$Mode;
    //   3: astore_3
    //   4: getstatic android/support/v7/widget/l.d : [I
    //   7: iload_1
    //   8: invokestatic a : ([II)Z
    //   11: istore #4
    //   13: ldc_w 16842801
    //   16: istore #5
    //   18: iload #4
    //   20: ifeq -> 37
    //   23: getstatic android/support/v7/a/a$a.colorControlNormal : I
    //   26: istore #5
    //   28: iconst_1
    //   29: istore #6
    //   31: iconst_m1
    //   32: istore #7
    //   34: goto -> 117
    //   37: getstatic android/support/v7/widget/l.f : [I
    //   40: iload_1
    //   41: invokestatic a : ([II)Z
    //   44: ifeq -> 55
    //   47: getstatic android/support/v7/a/a$a.colorControlActivated : I
    //   50: istore #5
    //   52: goto -> 28
    //   55: getstatic android/support/v7/widget/l.g : [I
    //   58: iload_1
    //   59: invokestatic a : ([II)Z
    //   62: ifeq -> 72
    //   65: getstatic android/graphics/PorterDuff$Mode.MULTIPLY : Landroid/graphics/PorterDuff$Mode;
    //   68: astore_3
    //   69: goto -> 28
    //   72: iload_1
    //   73: getstatic android/support/v7/a/a$e.abc_list_divider_mtrl_alpha : I
    //   76: if_icmpne -> 98
    //   79: ldc_w 16842800
    //   82: istore #5
    //   84: ldc_w 40.8
    //   87: invokestatic round : (F)I
    //   90: istore #7
    //   92: iconst_1
    //   93: istore #6
    //   95: goto -> 117
    //   98: iload_1
    //   99: getstatic android/support/v7/a/a$e.abc_dialog_material_background : I
    //   102: if_icmpne -> 108
    //   105: goto -> 28
    //   108: iconst_0
    //   109: istore #6
    //   111: iconst_m1
    //   112: istore #7
    //   114: iconst_0
    //   115: istore #5
    //   117: iload #6
    //   119: ifeq -> 162
    //   122: aload_2
    //   123: invokestatic b : (Landroid/graphics/drawable/Drawable;)Z
    //   126: ifeq -> 134
    //   129: aload_2
    //   130: invokevirtual mutate : ()Landroid/graphics/drawable/Drawable;
    //   133: astore_2
    //   134: aload_2
    //   135: aload_0
    //   136: iload #5
    //   138: invokestatic a : (Landroid/content/Context;I)I
    //   141: aload_3
    //   142: invokestatic a : (ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;
    //   145: invokevirtual setColorFilter : (Landroid/graphics/ColorFilter;)V
    //   148: iload #7
    //   150: iconst_m1
    //   151: if_icmpeq -> 160
    //   154: aload_2
    //   155: iload #7
    //   157: invokevirtual setAlpha : (I)V
    //   160: iconst_1
    //   161: ireturn
    //   162: iconst_0
    //   163: ireturn }
  
  private boolean a(Context paramContext, long paramLong, Drawable paramDrawable) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload #4
    //   4: invokevirtual getConstantState : ()Landroid/graphics/drawable/Drawable$ConstantState;
    //   7: astore #6
    //   9: aload #6
    //   11: ifnull -> 75
    //   14: aload_0
    //   15: getfield m : Ljava/util/WeakHashMap;
    //   18: aload_1
    //   19: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast android/support/v4/g/f
    //   25: astore #7
    //   27: aload #7
    //   29: ifnonnull -> 52
    //   32: new android/support/v4/g/f
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #7
    //   41: aload_0
    //   42: getfield m : Ljava/util/WeakHashMap;
    //   45: aload_1
    //   46: aload #7
    //   48: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload #7
    //   54: lload_2
    //   55: new java/lang/ref/WeakReference
    //   58: dup
    //   59: aload #6
    //   61: invokespecial <init> : (Ljava/lang/Object;)V
    //   64: invokevirtual b : (JLjava/lang/Object;)V
    //   67: iconst_1
    //   68: istore #9
    //   70: aload_0
    //   71: monitorexit
    //   72: iload #9
    //   74: ireturn
    //   75: iconst_0
    //   76: istore #9
    //   78: goto -> 70
    //   81: astore #5
    //   83: aload_0
    //   84: monitorexit
    //   85: aload #5
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	81	finally
    //   14	27	81	finally
    //   32	52	81	finally
    //   52	67	81	finally }
  
  private static boolean a(Drawable paramDrawable) { return (paramDrawable instanceof i || "android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())); }
  
  private static boolean a(int[] paramArrayOfInt, int paramInt) {
    int i1 = paramArrayOfInt.length;
    for (byte b1 = 0; b1 < i1; b1++) {
      if (paramArrayOfInt[b1] == paramInt)
        return true; 
    } 
    return false;
  }
  
  private ColorStateList b(Context paramContext) { return f(paramContext, bh.a(paramContext, a.a.colorButtonNormal)); }
  
  private ColorStateList c(Context paramContext) { return f(paramContext, 0); }
  
  private Drawable c(Context paramContext, int paramInt) {
    if (this.n == null)
      this.n = new TypedValue(); 
    TypedValue typedValue = this.n;
    paramContext.getResources().getValue(paramInt, typedValue, true);
    long l1 = a(typedValue);
    LayerDrawable layerDrawable = a(paramContext, l1);
    if (layerDrawable != null)
      return layerDrawable; 
    if (paramInt == a.e.abc_cab_background_top_material) {
      Drawable[] arrayOfDrawable = new Drawable[2];
      arrayOfDrawable[0] = a(paramContext, a.e.abc_cab_background_internal_bg);
      arrayOfDrawable[1] = a(paramContext, a.e.abc_cab_background_top_mtrl_alpha);
      layerDrawable = new LayerDrawable(arrayOfDrawable);
    } 
    if (layerDrawable != null) {
      layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
      a(paramContext, l1, layerDrawable);
    } 
    return layerDrawable;
  }
  
  private ColorStateList d(Context paramContext) { return f(paramContext, bh.a(paramContext, a.a.colorAccent)); }
  
  private Drawable d(Context paramContext, int paramInt) {
    a a1 = this.k;
    if (a1 != null && !a1.isEmpty()) {
      m m1 = this.l;
      if (m1 != null) {
        String str = (String)m1.a(paramInt);
        if ("appcompat_skip_skip".equals(str) || (str != null && this.k.get(str) == null))
          return null; 
      } else {
        this.l = new m();
      } 
      if (this.n == null)
        this.n = new TypedValue(); 
      TypedValue typedValue = this.n;
      Resources resources = paramContext.getResources();
      resources.getValue(paramInt, typedValue, true);
      long l1 = a(typedValue);
      Drawable drawable = a(paramContext, l1);
      if (drawable != null)
        return drawable; 
      if (typedValue.string != null && typedValue.string.toString().endsWith(".xml"))
        try {
          int i1;
          XmlResourceParser xmlResourceParser = resources.getXml(paramInt);
          AttributeSet attributeSet = Xml.asAttributeSet(xmlResourceParser);
          while (true) {
            i1 = xmlResourceParser.next();
            if (i1 != 2 && i1 != 1)
              continue; 
            break;
          } 
          if (i1 == 2) {
            String str = xmlResourceParser.getName();
            this.l.c(paramInt, str);
            d d1 = (d)this.k.get(str);
            if (d1 != null)
              drawable = d1.a(paramContext, xmlResourceParser, attributeSet, paramContext.getTheme()); 
            if (drawable != null) {
              drawable.setChangingConfigurations(typedValue.changingConfigurations);
              a(paramContext, l1, drawable);
            } 
          } else {
            throw new XmlPullParserException("No start tag found");
          } 
        } catch (Exception exception) {
          Log.e("AppCompatDrawableManag", "Exception while inflating drawable", exception);
        }  
      if (drawable == null)
        this.l.c(paramInt, "appcompat_skip_skip"); 
      return drawable;
    } 
    return null;
  }
  
  private ColorStateList e(Context paramContext) {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList colorStateList = bh.b(paramContext, a.a.colorSwitchThumbNormal);
    if (colorStateList != null && colorStateList.isStateful()) {
      arrayOfInt[0] = bh.a;
      arrayOfInt1[0] = colorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = bh.e;
      arrayOfInt1[1] = bh.a(paramContext, a.a.colorControlActivated);
      arrayOfInt[2] = bh.h;
      arrayOfInt1[2] = colorStateList.getDefaultColor();
    } else {
      arrayOfInt[0] = bh.a;
      arrayOfInt1[0] = bh.c(paramContext, a.a.colorSwitchThumbNormal);
      arrayOfInt[1] = bh.e;
      arrayOfInt1[1] = bh.a(paramContext, a.a.colorControlActivated);
      arrayOfInt[2] = bh.h;
      arrayOfInt1[2] = bh.a(paramContext, a.a.colorSwitchThumbNormal);
    } 
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  private ColorStateList e(Context paramContext, int paramInt) {
    WeakHashMap weakHashMap = this.j;
    ColorStateList colorStateList = null;
    if (weakHashMap != null) {
      m m1 = (m)weakHashMap.get(paramContext);
      colorStateList = null;
      if (m1 != null)
        colorStateList = (ColorStateList)m1.a(paramInt); 
    } 
    return colorStateList;
  }
  
  private ColorStateList f(Context paramContext, int paramInt) {
    int[][] arrayOfInt = new int[4][];
    int[] arrayOfInt1 = new int[4];
    int i1 = bh.a(paramContext, a.a.colorControlHighlight);
    int i2 = bh.c(paramContext, a.a.colorButtonNormal);
    arrayOfInt[0] = bh.a;
    arrayOfInt1[0] = i2;
    arrayOfInt[1] = bh.d;
    arrayOfInt1[1] = a.a(i1, paramInt);
    arrayOfInt[2] = bh.b;
    arrayOfInt1[2] = a.a(i1, paramInt);
    arrayOfInt[3] = bh.h;
    arrayOfInt1[3] = paramInt;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  private void f(Context paramContext) {
    if (this.o)
      return; 
    this.o = true;
    Drawable drawable = a(paramContext, a.e.abc_vector_test);
    if (drawable != null && a(drawable))
      return; 
    this.o = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  public Drawable a(Context paramContext, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_2
    //   5: iconst_0
    //   6: invokevirtual a : (Landroid/content/Context;IZ)Landroid/graphics/drawable/Drawable;
    //   9: astore #4
    //   11: aload_0
    //   12: monitorexit
    //   13: aload #4
    //   15: areturn
    //   16: astore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_3
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	16	finally }
  
  Drawable a(Context paramContext, int paramInt, boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial f : (Landroid/content/Context;)V
    //   7: aload_0
    //   8: aload_1
    //   9: iload_2
    //   10: invokespecial d : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   13: astore #5
    //   15: aload #5
    //   17: ifnonnull -> 28
    //   20: aload_0
    //   21: aload_1
    //   22: iload_2
    //   23: invokespecial c : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   26: astore #5
    //   28: aload #5
    //   30: ifnonnull -> 40
    //   33: aload_1
    //   34: iload_2
    //   35: invokestatic a : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   38: astore #5
    //   40: aload #5
    //   42: ifnull -> 56
    //   45: aload_0
    //   46: aload_1
    //   47: iload_2
    //   48: iload_3
    //   49: aload #5
    //   51: invokespecial a : (Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   54: astore #5
    //   56: aload #5
    //   58: ifnull -> 66
    //   61: aload #5
    //   63: invokestatic a : (Landroid/graphics/drawable/Drawable;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: aload #5
    //   70: areturn
    //   71: astore #4
    //   73: aload_0
    //   74: monitorexit
    //   75: aload #4
    //   77: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	71	finally
    //   20	28	71	finally
    //   33	40	71	finally
    //   45	56	71	finally
    //   61	66	71	finally }
  
  Drawable a(Context paramContext, br parambr, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_3
    //   5: invokespecial d : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   8: astore #5
    //   10: aload #5
    //   12: ifnonnull -> 22
    //   15: aload_2
    //   16: iload_3
    //   17: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   20: astore #5
    //   22: aload #5
    //   24: ifnull -> 43
    //   27: aload_0
    //   28: aload_1
    //   29: iload_3
    //   30: iconst_0
    //   31: aload #5
    //   33: invokespecial a : (Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   36: astore #6
    //   38: aload_0
    //   39: monitorexit
    //   40: aload #6
    //   42: areturn
    //   43: aload_0
    //   44: monitorexit
    //   45: aconst_null
    //   46: areturn
    //   47: astore #4
    //   49: aload_0
    //   50: monitorexit
    //   51: aload #4
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	47	finally
    //   15	22	47	finally
    //   27	38	47	finally }
  
  public void a(Context paramContext) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield m : Ljava/util/WeakHashMap;
    //   6: aload_1
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast android/support/v4/g/f
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -> 22
    //   18: aload_3
    //   19: invokevirtual c : ()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	25	finally
    //   18	22	25	finally }
  
  ColorStateList b(Context paramContext, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_2
    //   5: invokespecial e : (Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   8: astore #4
    //   10: aload #4
    //   12: ifnonnull -> 232
    //   15: iload_2
    //   16: getstatic android/support/v7/a/a$e.abc_edit_text_material : I
    //   19: if_icmpne -> 38
    //   22: getstatic android/support/v7/a/a$c.abc_tint_edittext : I
    //   25: istore #5
    //   27: aload_1
    //   28: iload #5
    //   30: invokestatic a : (Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   33: astore #4
    //   35: goto -> 219
    //   38: iload_2
    //   39: getstatic android/support/v7/a/a$e.abc_switch_track_mtrl_alpha : I
    //   42: if_icmpne -> 53
    //   45: getstatic android/support/v7/a/a$c.abc_tint_switch_track : I
    //   48: istore #5
    //   50: goto -> 27
    //   53: iload_2
    //   54: getstatic android/support/v7/a/a$e.abc_switch_thumb_material : I
    //   57: if_icmpne -> 70
    //   60: aload_0
    //   61: aload_1
    //   62: invokespecial e : (Landroid/content/Context;)Landroid/content/res/ColorStateList;
    //   65: astore #4
    //   67: goto -> 219
    //   70: iload_2
    //   71: getstatic android/support/v7/a/a$e.abc_btn_default_mtrl_shape : I
    //   74: if_icmpne -> 87
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial b : (Landroid/content/Context;)Landroid/content/res/ColorStateList;
    //   82: astore #4
    //   84: goto -> 219
    //   87: iload_2
    //   88: getstatic android/support/v7/a/a$e.abc_btn_borderless_material : I
    //   91: if_icmpne -> 104
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial c : (Landroid/content/Context;)Landroid/content/res/ColorStateList;
    //   99: astore #4
    //   101: goto -> 219
    //   104: iload_2
    //   105: getstatic android/support/v7/a/a$e.abc_btn_colored_material : I
    //   108: if_icmpne -> 121
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial d : (Landroid/content/Context;)Landroid/content/res/ColorStateList;
    //   116: astore #4
    //   118: goto -> 219
    //   121: iload_2
    //   122: getstatic android/support/v7/a/a$e.abc_spinner_mtrl_am_alpha : I
    //   125: if_icmpeq -> 211
    //   128: iload_2
    //   129: getstatic android/support/v7/a/a$e.abc_spinner_textfield_background_material : I
    //   132: if_icmpne -> 138
    //   135: goto -> 211
    //   138: getstatic android/support/v7/widget/l.e : [I
    //   141: iload_2
    //   142: invokestatic a : ([II)Z
    //   145: ifeq -> 160
    //   148: aload_1
    //   149: getstatic android/support/v7/a/a$a.colorControlNormal : I
    //   152: invokestatic b : (Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   155: astore #4
    //   157: goto -> 219
    //   160: getstatic android/support/v7/widget/l.h : [I
    //   163: iload_2
    //   164: invokestatic a : ([II)Z
    //   167: ifeq -> 178
    //   170: getstatic android/support/v7/a/a$c.abc_tint_default : I
    //   173: istore #5
    //   175: goto -> 27
    //   178: getstatic android/support/v7/widget/l.i : [I
    //   181: iload_2
    //   182: invokestatic a : ([II)Z
    //   185: ifeq -> 196
    //   188: getstatic android/support/v7/a/a$c.abc_tint_btn_checkable : I
    //   191: istore #5
    //   193: goto -> 27
    //   196: iload_2
    //   197: getstatic android/support/v7/a/a$e.abc_seekbar_thumb_material : I
    //   200: if_icmpne -> 219
    //   203: getstatic android/support/v7/a/a$c.abc_tint_seek_thumb : I
    //   206: istore #5
    //   208: goto -> 27
    //   211: getstatic android/support/v7/a/a$c.abc_tint_spinner : I
    //   214: istore #5
    //   216: goto -> 27
    //   219: aload #4
    //   221: ifnull -> 232
    //   224: aload_0
    //   225: aload_1
    //   226: iload_2
    //   227: aload #4
    //   229: invokespecial a : (Landroid/content/Context;ILandroid/content/res/ColorStateList;)V
    //   232: aload_0
    //   233: monitorexit
    //   234: aload #4
    //   236: areturn
    //   237: astore_3
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_3
    //   241: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	237	finally
    //   15	27	237	finally
    //   27	35	237	finally
    //   38	50	237	finally
    //   53	67	237	finally
    //   70	84	237	finally
    //   87	101	237	finally
    //   104	118	237	finally
    //   121	135	237	finally
    //   138	157	237	finally
    //   160	175	237	finally
    //   178	193	237	finally
    //   196	208	237	finally
    //   211	216	237	finally
    //   224	232	237	finally }
  
  static class a implements d {
    public Drawable a(Context param1Context, XmlPullParser param1XmlPullParser, AttributeSet param1AttributeSet, Resources.Theme param1Theme) {
      try {
        return a.a(param1Context, param1Context.getResources(), param1XmlPullParser, param1AttributeSet, param1Theme);
      } catch (Exception exception) {
        Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", exception);
        return null;
      } 
    }
  }
  
  private static class b implements d {
    public Drawable a(Context param1Context, XmlPullParser param1XmlPullParser, AttributeSet param1AttributeSet, Resources.Theme param1Theme) {
      try {
        return c.a(param1Context, param1Context.getResources(), param1XmlPullParser, param1AttributeSet, param1Theme);
      } catch (Exception exception) {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", exception);
        return null;
      } 
    }
  }
  
  private static class c extends g<Integer, PorterDuffColorFilter> {
    public c(int param1Int) { super(param1Int); }
    
    private static int b(int param1Int, PorterDuff.Mode param1Mode) { return 31 * (param1Int + 31) + param1Mode.hashCode(); }
    
    PorterDuffColorFilter a(int param1Int, PorterDuff.Mode param1Mode) { return (PorterDuffColorFilter)a(Integer.valueOf(b(param1Int, param1Mode))); }
    
    PorterDuffColorFilter a(int param1Int, PorterDuff.Mode param1Mode, PorterDuffColorFilter param1PorterDuffColorFilter) { return (PorterDuffColorFilter)a(Integer.valueOf(b(param1Int, param1Mode)), param1PorterDuffColorFilter); }
  }
  
  private static interface d {
    Drawable a(Context param1Context, XmlPullParser param1XmlPullParser, AttributeSet param1AttributeSet, Resources.Theme param1Theme);
  }
  
  private static class e implements d {
    public Drawable a(Context param1Context, XmlPullParser param1XmlPullParser, AttributeSet param1AttributeSet, Resources.Theme param1Theme) {
      try {
        return i.a(param1Context.getResources(), param1XmlPullParser, param1AttributeSet, param1Theme);
      } catch (Exception exception) {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", exception);
        return null;
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */