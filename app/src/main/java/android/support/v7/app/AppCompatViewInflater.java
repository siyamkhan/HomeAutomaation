package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.g.a;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.view.d;
import android.support.v7.widget.aa;
import android.support.v7.widget.bj;
import android.support.v7.widget.f;
import android.support.v7.widget.h;
import android.support.v7.widget.i;
import android.support.v7.widget.j;
import android.support.v7.widget.m;
import android.support.v7.widget.o;
import android.support.v7.widget.q;
import android.support.v7.widget.r;
import android.support.v7.widget.u;
import android.support.v7.widget.v;
import android.support.v7.widget.w;
import android.support.v7.widget.y;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
  private static final String LOG_TAG = "AppCompatViewInflater";
  
  private static final String[] sClassPrefixList;
  
  private static final Map<String, Constructor<? extends View>> sConstructorMap;
  
  private static final Class<?>[] sConstructorSignature = { Context.class, AttributeSet.class };
  
  private static final int[] sOnClickAttrs = { 16843375 };
  
  private final Object[] mConstructorArgs = new Object[2];
  
  static  {
    sClassPrefixList = new String[] { "android.widget.", "android.view.", "android.webkit." };
    sConstructorMap = new a();
  }
  
  private void checkOnClickListener(View paramView, AttributeSet paramAttributeSet) {
    Context context = paramView.getContext();
    if (context instanceof ContextWrapper) {
      if (Build.VERSION.SDK_INT >= 15 && !r.B(paramView))
        return; 
      TypedArray typedArray = context.obtainStyledAttributes(paramAttributeSet, sOnClickAttrs);
      String str = typedArray.getString(0);
      if (str != null)
        paramView.setOnClickListener(new a(paramView, str)); 
      typedArray.recycle();
    } 
  }
  
  private View createViewByPrefix(Context paramContext, String paramString1, String paramString2) {
    Constructor constructor = (Constructor)sConstructorMap.get(paramString1);
    if (constructor == null)
      try {
        String str;
        ClassLoader classLoader = paramContext.getClassLoader();
        if (paramString2 != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString2);
          stringBuilder.append(paramString1);
          str = stringBuilder.toString();
        } else {
          str = paramString1;
        } 
        constructor = classLoader.loadClass(str).asSubclass(View.class).getConstructor(sConstructorSignature);
        sConstructorMap.put(paramString1, constructor);
        constructor.setAccessible(true);
        return (View)constructor.newInstance(this.mConstructorArgs);
      } catch (Exception exception) {
        return null;
      }  
    constructor.setAccessible(true);
    return (View)constructor.newInstance(this.mConstructorArgs);
  }
  
  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet) {
    if (paramString.equals("view"))
      paramString = paramAttributeSet.getAttributeValue(null, "class"); 
    try {
      this.mConstructorArgs[0] = paramContext;
      this.mConstructorArgs[1] = paramAttributeSet;
      if (-1 == paramString.indexOf('.')) {
        for (byte b = 0; b < sClassPrefixList.length; b++) {
          view = createViewByPrefix(paramContext, paramString, sClassPrefixList[b]);
          if (view != null)
            return view; 
        } 
        return null;
      } 
      return createViewByPrefix(paramContext, paramString, null);
    } catch (Exception exception) {
      return null;
    } finally {
      Object[] arrayOfObject = this.mConstructorArgs;
      arrayOfObject[0] = null;
      arrayOfObject[1] = null;
    } 
  }
  
  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2) {
    int i;
    d d;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.View, 0, 0);
    if (paramBoolean1) {
      i = typedArray.getResourceId(a.j.View_android_theme, 0);
    } else {
      i = 0;
    } 
    if (paramBoolean2 && !i) {
      i = typedArray.getResourceId(a.j.View_theme, 0);
      if (i != 0)
        Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead."); 
    } 
    typedArray.recycle();
    if (i != 0 && (!(paramContext instanceof d) || ((d)paramContext).a() != i))
      d = new d(paramContext, i); 
    return d;
  }
  
  private void verifyNotNull(View paramView, String paramString) {
    if (paramView != null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" asked to inflate view for <");
    stringBuilder.append(paramString);
    stringBuilder.append(">, but returned null");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  protected f createAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet) { return new f(paramContext, paramAttributeSet); }
  
  protected h createButton(Context paramContext, AttributeSet paramAttributeSet) { return new h(paramContext, paramAttributeSet); }
  
  protected i createCheckBox(Context paramContext, AttributeSet paramAttributeSet) { return new i(paramContext, paramAttributeSet); }
  
  protected j createCheckedTextView(Context paramContext, AttributeSet paramAttributeSet) { return new j(paramContext, paramAttributeSet); }
  
  protected m createEditText(Context paramContext, AttributeSet paramAttributeSet) { return new m(paramContext, paramAttributeSet); }
  
  protected o createImageButton(Context paramContext, AttributeSet paramAttributeSet) { return new o(paramContext, paramAttributeSet); }
  
  protected q createImageView(Context paramContext, AttributeSet paramAttributeSet) { return new q(paramContext, paramAttributeSet); }
  
  protected r createMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet) { return new r(paramContext, paramAttributeSet); }
  
  protected u createRadioButton(Context paramContext, AttributeSet paramAttributeSet) { return new u(paramContext, paramAttributeSet); }
  
  protected v createRatingBar(Context paramContext, AttributeSet paramAttributeSet) { return new v(paramContext, paramAttributeSet); }
  
  protected w createSeekBar(Context paramContext, AttributeSet paramAttributeSet) { return new w(paramContext, paramAttributeSet); }
  
  protected y createSpinner(Context paramContext, AttributeSet paramAttributeSet) { return new y(paramContext, paramAttributeSet); }
  
  protected aa createTextView(Context paramContext, AttributeSet paramAttributeSet) { return new aa(paramContext, paramAttributeSet); }
  
  protected View createView(Context paramContext, String paramString, AttributeSet paramAttributeSet) { return null; }
  
  final View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    u u;
    r r;
    i i;
    h h;
    w w;
    o o;
    j j;
    View view2;
    q q;
    v v;
    f f;
    m m;
    View view1;
    y y;
    Context context;
    if (paramBoolean1 && paramView != null) {
      context = paramView.getContext();
    } else {
      context = paramContext;
    } 
    if (paramBoolean2 || paramBoolean3)
      context = themifyContext(context, paramAttributeSet, paramBoolean2, paramBoolean3); 
    if (paramBoolean4)
      context = bj.a(context); 
    byte b = -1;
    switch (paramString.hashCode()) {
      case 2001146706:
        if (paramString.equals("Button"))
          b = 2; 
        break;
      case 1666676343:
        if (paramString.equals("EditText"))
          b = 3; 
        break;
      case 1601505219:
        if (paramString.equals("CheckBox"))
          b = 6; 
        break;
      case 1413872058:
        if (paramString.equals("AutoCompleteTextView"))
          b = 9; 
        break;
      case 1125864064:
        if (paramString.equals("ImageView"))
          b = 1; 
        break;
      case 776382189:
        if (paramString.equals("RadioButton"))
          b = 7; 
        break;
      case -339785223:
        if (paramString.equals("Spinner"))
          b = 4; 
        break;
      case -658531749:
        if (paramString.equals("SeekBar"))
          b = 12; 
        break;
      case -937446323:
        if (paramString.equals("ImageButton"))
          b = 5; 
        break;
      case -938935918:
        if (paramString.equals("TextView"))
          b = 0; 
        break;
      case -1346021293:
        if (paramString.equals("MultiAutoCompleteTextView"))
          b = 10; 
        break;
      case -1455429095:
        if (paramString.equals("CheckedTextView"))
          b = 8; 
        break;
      case -1946472170:
        if (paramString.equals("RatingBar"))
          b = 11; 
        break;
    } 
    switch (b) {
      default:
        view2 = createView(context, paramString, paramAttributeSet);
        break;
      case 12:
        w = createSeekBar(context, paramAttributeSet);
        verifyNotNull(w, paramString);
        break;
      case 11:
        v = createRatingBar(context, paramAttributeSet);
        verifyNotNull(v, paramString);
        break;
      case 10:
        r = createMultiAutoCompleteTextView(context, paramAttributeSet);
        verifyNotNull(r, paramString);
        break;
      case 9:
        f = createAutoCompleteTextView(context, paramAttributeSet);
        verifyNotNull(f, paramString);
        break;
      case 8:
        j = createCheckedTextView(context, paramAttributeSet);
        verifyNotNull(j, paramString);
        break;
      case 7:
        u = createRadioButton(context, paramAttributeSet);
        verifyNotNull(u, paramString);
        break;
      case 6:
        i = createCheckBox(context, paramAttributeSet);
        verifyNotNull(i, paramString);
        break;
      case 5:
        o = createImageButton(context, paramAttributeSet);
        verifyNotNull(o, paramString);
        break;
      case 4:
        y = createSpinner(context, paramAttributeSet);
        verifyNotNull(y, paramString);
        break;
      case 3:
        m = createEditText(context, paramAttributeSet);
        verifyNotNull(m, paramString);
        break;
      case 2:
        h = createButton(context, paramAttributeSet);
        verifyNotNull(h, paramString);
        break;
      case 1:
        q = createImageView(context, paramAttributeSet);
        verifyNotNull(q, paramString);
        break;
      case 0:
        view1 = createTextView(context, paramAttributeSet);
        verifyNotNull(view1, paramString);
        break;
    } 
    if (view1 == null && paramContext != context)
      view1 = createViewFromTag(context, paramString, paramAttributeSet); 
    if (view1 != null)
      checkOnClickListener(view1, paramAttributeSet); 
    return view1;
  }
  
  private static class a implements View.OnClickListener {
    private final View a;
    
    private final String b;
    
    private Method c;
    
    private Context d;
    
    public a(View param1View, String param1String) {
      this.a = param1View;
      this.b = param1String;
    }
    
    private void a(Context param1Context, String param1String) {
      String str;
      while (param1Context != null) {
        if (!param1Context.isRestricted()) {
          Method method = param1Context.getClass().getMethod(this.b, new Class[] { View.class });
          if (method != null) {
            this.c = method;
            this.d = param1Context;
            return;
          } 
        } 
        if (param1Context instanceof ContextWrapper) {
          param1Context = ((ContextWrapper)param1Context).getBaseContext();
          continue;
        } 
        param1Context = null;
      } 
      int i = this.a.getId();
      if (i == -1) {
        str = "";
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" with id '");
        stringBuilder1.append(this.a.getContext().getResources().getResourceEntryName(i));
        stringBuilder1.append("'");
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not find method ");
      stringBuilder.append(this.b);
      stringBuilder.append("(View) in a parent or ancestor Context for android:onClick ");
      stringBuilder.append("attribute defined on view ");
      stringBuilder.append(this.a.getClass());
      stringBuilder.append(str);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public void onClick(View param1View) {
      if (this.c == null)
        a(this.a.getContext(), this.b); 
      try {
        this.c.invoke(this.d, new Object[] { param1View });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new IllegalStateException("Could not execute method for android:onClick", invocationTargetException);
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\AppCompatViewInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */