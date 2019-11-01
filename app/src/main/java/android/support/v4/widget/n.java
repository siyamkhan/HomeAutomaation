package android.support.v4.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.support.v4.f.b;
import android.support.v4.g.k;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class n {
  private static int a(TextDirectionHeuristic paramTextDirectionHeuristic) { return (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) ? 1 : ((paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) ? 1 : ((paramTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) ? 2 : ((paramTextDirectionHeuristic == TextDirectionHeuristics.LTR) ? 3 : ((paramTextDirectionHeuristic == TextDirectionHeuristics.RTL) ? 4 : ((paramTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) ? 5 : ((paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) ? 6 : ((paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) ? 7 : 1))))))); }
  
  public static ActionMode.Callback a(TextView paramTextView, ActionMode.Callback paramCallback) { return (Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 27) ? ((paramCallback instanceof a) ? paramCallback : new a(paramCallback, paramTextView)) : paramCallback; }
  
  public static void a(TextView paramTextView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23) {
      paramTextView.setTextAppearance(paramInt);
      return;
    } 
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }
  
  public static void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    if (Build.VERSION.SDK_INT >= 18) {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 17) {
      Drawable drawable;
      int i = paramTextView.getLayoutDirection();
      boolean bool = true;
      if (i != bool)
        bool = false; 
      if (bool) {
        drawable = paramDrawable3;
      } else {
        drawable = paramDrawable1;
      } 
      if (!bool)
        paramDrawable1 = paramDrawable3; 
      paramTextView.setCompoundDrawables(drawable, paramDrawable2, paramDrawable1, paramDrawable4);
      return;
    } 
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void a(TextView paramTextView, b.a parama) {
    if (Build.VERSION.SDK_INT >= 18)
      paramTextView.setTextDirection(a(parama.b())); 
    if (Build.VERSION.SDK_INT < 23) {
      float f = parama.a().getTextScaleX();
      paramTextView.getPaint().set(parama.a());
      if (f == paramTextView.getTextScaleX())
        paramTextView.setTextScaleX(1.0F + f / 2.0F); 
      paramTextView.setTextScaleX(f);
      return;
    } 
    paramTextView.getPaint().set(parama.a());
    paramTextView.setBreakStrategy(parama.c());
    paramTextView.setHyphenationFrequency(parama.d());
  }
  
  public static void a(TextView paramTextView, b paramb) {
    PrecomputedText precomputedText;
    if (Build.VERSION.SDK_INT >= 28) {
      precomputedText = paramb.a();
    } else if (!d(paramTextView).equals(precomputedText.b())) {
      throw new IllegalArgumentException("Given text can not be applied to TextView.");
    } 
    paramTextView.setText(precomputedText);
  }
  
  public static Drawable[] a(TextView paramTextView) {
    if (Build.VERSION.SDK_INT >= 18)
      return paramTextView.getCompoundDrawablesRelative(); 
    if (Build.VERSION.SDK_INT >= 17) {
      int i = paramTextView.getLayoutDirection();
      boolean bool = true;
      if (i != bool)
        bool = false; 
      Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
      if (bool) {
        Drawable drawable1 = arrayOfDrawable[2];
        Drawable drawable2 = arrayOfDrawable[0];
        arrayOfDrawable[0] = drawable1;
        arrayOfDrawable[2] = drawable2;
      } 
      return arrayOfDrawable;
    } 
    return paramTextView.getCompoundDrawables();
  }
  
  public static int b(TextView paramTextView) { return paramTextView.getPaddingTop() - (paramTextView.getPaint().getFontMetricsInt()).top; }
  
  public static void b(TextView paramTextView, int paramInt) {
    int i;
    k.a(paramInt);
    if (Build.VERSION.SDK_INT >= 28) {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
      return;
    } 
    Paint.FontMetricsInt fontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if (Build.VERSION.SDK_INT < 16 || paramTextView.getIncludeFontPadding()) {
      i = fontMetricsInt.top;
    } else {
      i = fontMetricsInt.ascent;
    } 
    if (paramInt > Math.abs(i)) {
      int j = paramInt - -i;
      paramTextView.setPadding(paramTextView.getPaddingLeft(), j, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
    } 
  }
  
  public static int c(TextView paramTextView) { return paramTextView.getPaddingBottom() + (paramTextView.getPaint().getFontMetricsInt()).bottom; }
  
  public static void c(TextView paramTextView, int paramInt) {
    int i;
    k.a(paramInt);
    Paint.FontMetricsInt fontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if (Build.VERSION.SDK_INT < 16 || paramTextView.getIncludeFontPadding()) {
      i = fontMetricsInt.bottom;
    } else {
      i = fontMetricsInt.descent;
    } 
    if (paramInt > Math.abs(i)) {
      int j = paramInt - i;
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), j);
    } 
  }
  
  public static b.a d(TextView paramTextView) {
    if (Build.VERSION.SDK_INT >= 28)
      return new b.a(paramTextView.getTextMetricsParams()); 
    b.a.a a = new b.a.a(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23) {
      a.a(paramTextView.getBreakStrategy());
      a.b(paramTextView.getHyphenationFrequency());
    } 
    if (Build.VERSION.SDK_INT >= 18)
      a.a(e(paramTextView)); 
    return a.a();
  }
  
  public static void d(TextView paramTextView, int paramInt) {
    k.a(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i)
      paramTextView.setLineSpacing((paramInt - i), 1.0F); 
  }
  
  private static TextDirectionHeuristic e(TextView paramTextView) {
    if (paramTextView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod)
      return TextDirectionHeuristics.LTR; 
    if (Build.VERSION.SDK_INT >= 28 && (0xF & paramTextView.getInputType()) == 3) {
      byte b = Character.getDirectionality(DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      return (b == 1 || b == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
    } 
    int i = paramTextView.getLayoutDirection();
    boolean bool = false;
    if (i == 1)
      bool = true; 
    switch (paramTextView.getTextDirection()) {
      default:
        return bool ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
      case 7:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
      case 6:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
      case 5:
        return TextDirectionHeuristics.LOCALE;
      case 4:
        return TextDirectionHeuristics.RTL;
      case 3:
        return TextDirectionHeuristics.LTR;
      case 2:
        break;
    } 
    return TextDirectionHeuristics.ANYRTL_LTR;
  }
  
  private static class a implements ActionMode.Callback {
    private final ActionMode.Callback a;
    
    private final TextView b;
    
    private Class c;
    
    private Method d;
    
    private boolean e;
    
    private boolean f;
    
    a(ActionMode.Callback param1Callback, TextView param1TextView) {
      this.a = param1Callback;
      this.b = param1TextView;
      this.f = false;
    }
    
    private Intent a() { return (new Intent()).setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"); }
    
    private Intent a(ResolveInfo param1ResolveInfo, TextView param1TextView) { return a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", true ^ a(param1TextView)).setClassName(param1ResolveInfo.activityInfo.packageName, param1ResolveInfo.activityInfo.name); }
    
    private List<ResolveInfo> a(Context param1Context, PackageManager param1PackageManager) {
      ArrayList arrayList = new ArrayList();
      if (!(param1Context instanceof android.app.Activity))
        return arrayList; 
      for (ResolveInfo resolveInfo : param1PackageManager.queryIntentActivities(a(), 0)) {
        if (a(resolveInfo, param1Context))
          arrayList.add(resolveInfo); 
      } 
      return arrayList;
    }
    
    private void a(Menu param1Menu) {
      Method method;
      Context context = this.b.getContext();
      PackageManager packageManager = context.getPackageManager();
      if (!this.f) {
        this.f = true;
        try {
          this.c = Class.forName("com.android.internal.view.menu.MenuBuilder");
          Class clazz = this.c;
          Class[] arrayOfClass = new Class[1];
          arrayOfClass[0] = int.class;
          this.d = clazz.getDeclaredMethod("removeItemAt", arrayOfClass);
          this.e = true;
        } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException) {
          this.c = null;
          this.d = null;
          this.e = false;
        } 
      } 
      if (this.e && this.c.isInstance(param1Menu)) {
        method = this.d;
      } else {
        Class clazz = param1Menu.getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = int.class;
        method = clazz.getDeclaredMethod("removeItemAt", arrayOfClass);
      } 
      for (int i = param1Menu.size() - 1; i >= 0; i--) {
        MenuItem menuItem = param1Menu.getItem(i);
        if (menuItem.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(menuItem.getIntent().getAction())) {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(i);
          method.invoke(param1Menu, arrayOfObject);
        } 
      } 
      List list = a(context, packageManager);
      for (byte b1 = 0; b1 < list.size(); b1++) {
        ResolveInfo resolveInfo = (ResolveInfo)list.get(b1);
        param1Menu.add(0, 0, b1 + 100, resolveInfo.loadLabel(packageManager)).setIntent(a(resolveInfo, this.b)).setShowAsAction(1);
      } 
    }
    
    private boolean a(ResolveInfo param1ResolveInfo, Context param1Context) {
      boolean bool1 = param1Context.getPackageName().equals(param1ResolveInfo.activityInfo.packageName);
      boolean bool2 = true;
      if (bool1)
        return bool2; 
      if (!param1ResolveInfo.activityInfo.exported)
        return false; 
      if (param1ResolveInfo.activityInfo.permission != null) {
        if (param1Context.checkSelfPermission(param1ResolveInfo.activityInfo.permission) == 0)
          return bool2; 
        bool2 = false;
      } 
      return bool2;
    }
    
    private boolean a(TextView param1TextView) { return (param1TextView instanceof android.text.Editable && param1TextView.onCheckIsTextEditor() && param1TextView.isEnabled()); }
    
    public boolean onActionItemClicked(ActionMode param1ActionMode, MenuItem param1MenuItem) { return this.a.onActionItemClicked(param1ActionMode, param1MenuItem); }
    
    public boolean onCreateActionMode(ActionMode param1ActionMode, Menu param1Menu) { return this.a.onCreateActionMode(param1ActionMode, param1Menu); }
    
    public void onDestroyActionMode(ActionMode param1ActionMode) { this.a.onDestroyActionMode(param1ActionMode); }
    
    public boolean onPrepareActionMode(ActionMode param1ActionMode, Menu param1Menu) {
      a(param1Menu);
      return this.a.onPrepareActionMode(param1ActionMode, param1Menu);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */