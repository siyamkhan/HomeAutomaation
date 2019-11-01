package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.support.v4.h.c;
import android.support.v4.h.h;
import android.support.v7.a.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.al;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.jd.gui.api.API;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater {
  static final Class<?>[] a = { Context.class };
  
  static final Class<?>[] b = a;
  
  final Object[] c;
  
  final Object[] d;
  
  Context e;
  
  private Object f;
  
  public g(Context paramContext) {
    super(paramContext);
    this.e = paramContext;
    this.c = new Object[] { paramContext };
    this.d = this.c;
  }
  
  private Object a(Object paramObject) {
    if (paramObject instanceof android.app.Activity)
      return paramObject; 
    if (paramObject instanceof ContextWrapper)
      paramObject = a(((ContextWrapper)paramObject).getBaseContext()); 
    return paramObject;
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu) {
    b b1 = new b(this, paramMenu);
    int i = paramXmlPullParser.getEventType();
    do {
      if (i == 2) {
        String str1 = paramXmlPullParser.getName();
        if (str1.equals("menu")) {
          i = paramXmlPullParser.next();
          break;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expecting menu, got ");
        stringBuilder.append(str1);
        throw new RuntimeException(stringBuilder.toString());
      } 
      i = paramXmlPullParser.next();
    } while (i != 1);
    int j = i;
    String str = null;
    boolean bool1 = false;
    boolean bool2 = false;
    while (!bool1) {
      String str2;
      String str1;
      switch (j) {
        case 3:
          str2 = paramXmlPullParser.getName();
          if (bool2 && str2.equals(str)) {
            bool2 = false;
            str = null;
            break;
          } 
          if (str2.equals("group")) {
            b1.a();
            break;
          } 
          if (str2.equals("item")) {
            if (!b1.d()) {
              if (b1.a != null && b1.a.e()) {
                b1.c();
                break;
              } 
              b1.b();
            } 
            break;
          } 
          if (str2.equals("menu"))
            bool1 = true; 
          break;
        case 2:
          if (bool2)
            break; 
          str1 = paramXmlPullParser.getName();
          if (str1.equals("group")) {
            b1.a(paramAttributeSet);
            break;
          } 
          if (str1.equals("item")) {
            b1.b(paramAttributeSet);
            break;
          } 
          if (str1.equals("menu")) {
            a(paramXmlPullParser, paramAttributeSet, b1.c());
            break;
          } 
          str = str1;
          bool2 = true;
          break;
        case 1:
          throw new RuntimeException("Unexpected end of document");
      } 
      j = paramXmlPullParser.next();
    } 
  }
  
  Object a() {
    if (this.f == null)
      this.f = a(this.e); 
    return this.f;
  }
  
  public void inflate(int paramInt, Menu paramMenu) {
    API aPI;
    if (!(paramMenu instanceof android.support.v4.b.a.a)) {
      super.inflate(paramInt, paramMenu);
      return;
    } 
    XmlResourceParser xmlResourceParser = null;
    try {
      xmlResourceParser = this.e.getResources().getLayout(paramInt);
      a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), paramMenu);
      if (xmlResourceParser != null)
        xmlResourceParser.close(); 
      return;
    } catch (XmlPullParserException xmlPullParserException) {
      throw new InflateException("Error inflating menu XML", xmlPullParserException);
    } catch (IOException iOException) {
      throw new InflateException("Error inflating menu XML", iOException);
    } finally {}
    if (xmlResourceParser != null)
      xmlResourceParser.close(); 
    throw aPI;
  }
  
  private static class a implements MenuItem.OnMenuItemClickListener {
    private static final Class<?>[] a = { MenuItem.class };
    
    private Object b;
    
    private Method c;
    
    public a(Object param1Object, String param1String) {
      this.b = param1Object;
      Class clazz = param1Object.getClass();
      try {
        this.c = clazz.getMethod(param1String, a);
        return;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't resolve menu item onClick handler ");
        stringBuilder.append(param1String);
        stringBuilder.append(" in class ");
        stringBuilder.append(clazz.getName());
        InflateException inflateException = new InflateException(stringBuilder.toString());
        inflateException.initCause(exception);
        throw inflateException;
      } 
    }
    
    public boolean onMenuItemClick(MenuItem param1MenuItem) {
      try {
        if (this.c.getReturnType() == boolean.class)
          return ((Boolean)this.c.invoke(this.b, new Object[] { param1MenuItem })).booleanValue(); 
        this.c.invoke(this.b, new Object[] { param1MenuItem });
        return true;
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      } 
    }
  }
  
  private class b {
    private String A;
    
    private String B;
    
    private CharSequence C;
    
    private CharSequence D;
    
    private ColorStateList E = null;
    
    private PorterDuff.Mode F = null;
    
    c a;
    
    private Menu c;
    
    private int d;
    
    private int e;
    
    private int f;
    
    private int g;
    
    private boolean h;
    
    private boolean i;
    
    private boolean j;
    
    private int k;
    
    private int l;
    
    private CharSequence m;
    
    private CharSequence n;
    
    private int o;
    
    private char p;
    
    private int q;
    
    private char r;
    
    private int s;
    
    private int t;
    
    private boolean u;
    
    private boolean v;
    
    private boolean w;
    
    private int x;
    
    private int y;
    
    private String z;
    
    public b(g this$0, Menu param1Menu) {
      this.c = param1Menu;
      a();
    }
    
    private char a(String param1String) { return (param1String == null) ? Character.MIN_VALUE : param1String.charAt(0); }
    
    private <T> T a(String param1String, Class<?>[] param1ArrayOfClass, Object[] param1ArrayOfObject) {
      try {
        Constructor constructor = this.b.e.getClassLoader().loadClass(param1String).getConstructor(param1ArrayOfClass);
        constructor.setAccessible(true);
        return (T)constructor.newInstance(param1ArrayOfObject);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot instantiate class: ");
        stringBuilder.append(param1String);
        Log.w("SupportMenuInflater", stringBuilder.toString(), exception);
        return null;
      } 
    }
    
    private void a(MenuItem param1MenuItem) {
      boolean bool1;
      MenuItem menuItem = param1MenuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
      if (this.t >= 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      menuItem.setCheckable(bool1).setTitleCondensed(this.n).setIcon(this.o);
      int i1 = this.x;
      if (i1 >= 0)
        param1MenuItem.setShowAsAction(i1); 
      if (this.B != null)
        if (!this.b.e.isRestricted()) {
          param1MenuItem.setOnMenuItemClickListener(new g.a(this.b.a(), this.B));
        } else {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }  
      boolean bool2 = param1MenuItem instanceof j;
      if (bool2)
        (j)param1MenuItem; 
      if (this.t >= 2)
        if (bool2) {
          ((j)param1MenuItem).a(true);
        } else if (param1MenuItem instanceof k) {
          ((k)param1MenuItem).a(true);
        }  
      String str = this.z;
      boolean bool = false;
      if (str != null) {
        param1MenuItem.setActionView((View)a(str, g.a, this.b.c));
        bool = true;
      } 
      int i2 = this.y;
      if (i2 > 0)
        if (!bool) {
          param1MenuItem.setActionView(i2);
        } else {
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }  
      c c1 = this.a;
      if (c1 != null)
        h.a(param1MenuItem, c1); 
      h.a(param1MenuItem, this.C);
      h.b(param1MenuItem, this.D);
      h.b(param1MenuItem, this.p, this.q);
      h.a(param1MenuItem, this.r, this.s);
      PorterDuff.Mode mode = this.F;
      if (mode != null)
        h.a(param1MenuItem, mode); 
      ColorStateList colorStateList = this.E;
      if (colorStateList != null)
        h.a(param1MenuItem, colorStateList); 
    }
    
    public void a() {
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = true;
      this.i = true;
    }
    
    public void a(AttributeSet param1AttributeSet) {
      TypedArray typedArray = this.b.e.obtainStyledAttributes(param1AttributeSet, a.j.MenuGroup);
      this.d = typedArray.getResourceId(a.j.MenuGroup_android_id, 0);
      this.e = typedArray.getInt(a.j.MenuGroup_android_menuCategory, 0);
      this.f = typedArray.getInt(a.j.MenuGroup_android_orderInCategory, 0);
      this.g = typedArray.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
      this.h = typedArray.getBoolean(a.j.MenuGroup_android_visible, true);
      this.i = typedArray.getBoolean(a.j.MenuGroup_android_enabled, true);
      typedArray.recycle();
    }
    
    public void b() {
      this.j = true;
      a(this.c.add(this.d, this.k, this.l, this.m));
    }
    
    public void b(AttributeSet param1AttributeSet) {
      boolean bool;
      int i3;
      TypedArray typedArray = this.b.e.obtainStyledAttributes(param1AttributeSet, a.j.MenuItem);
      this.k = typedArray.getResourceId(a.j.MenuItem_android_id, 0);
      int i1 = typedArray.getInt(a.j.MenuItem_android_menuCategory, this.e);
      int i2 = typedArray.getInt(a.j.MenuItem_android_orderInCategory, this.f);
      this.l = i1 & 0xFFFF0000 | i2 & 0xFFFF;
      this.m = typedArray.getText(a.j.MenuItem_android_title);
      this.n = typedArray.getText(a.j.MenuItem_android_titleCondensed);
      this.o = typedArray.getResourceId(a.j.MenuItem_android_icon, 0);
      this.p = a(typedArray.getString(a.j.MenuItem_android_alphabeticShortcut));
      this.q = typedArray.getInt(a.j.MenuItem_alphabeticModifiers, 4096);
      this.r = a(typedArray.getString(a.j.MenuItem_android_numericShortcut));
      this.s = typedArray.getInt(a.j.MenuItem_numericModifiers, 4096);
      if (typedArray.hasValue(a.j.MenuItem_android_checkable)) {
        i3 = typedArray.getBoolean(a.j.MenuItem_android_checkable, false);
      } else {
        i3 = this.g;
      } 
      this.t = i3;
      this.u = typedArray.getBoolean(a.j.MenuItem_android_checked, false);
      this.v = typedArray.getBoolean(a.j.MenuItem_android_visible, this.h);
      this.w = typedArray.getBoolean(a.j.MenuItem_android_enabled, this.i);
      this.x = typedArray.getInt(a.j.MenuItem_showAsAction, -1);
      this.B = typedArray.getString(a.j.MenuItem_android_onClick);
      this.y = typedArray.getResourceId(a.j.MenuItem_actionLayout, 0);
      this.z = typedArray.getString(a.j.MenuItem_actionViewClass);
      this.A = typedArray.getString(a.j.MenuItem_actionProviderClass);
      if (this.A != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool && this.y == 0 && this.z == null) {
        this.a = (c)a(this.A, g.b, this.b.d);
      } else {
        if (bool)
          Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified."); 
        this.a = null;
      } 
      this.C = typedArray.getText(a.j.MenuItem_contentDescription);
      this.D = typedArray.getText(a.j.MenuItem_tooltipText);
      if (typedArray.hasValue(a.j.MenuItem_iconTintMode)) {
        this.F = al.a(typedArray.getInt(a.j.MenuItem_iconTintMode, -1), this.F);
      } else {
        this.F = null;
      } 
      if (typedArray.hasValue(a.j.MenuItem_iconTint)) {
        this.E = typedArray.getColorStateList(a.j.MenuItem_iconTint);
      } else {
        this.E = null;
      } 
      typedArray.recycle();
      this.j = false;
    }
    
    public SubMenu c() {
      this.j = true;
      SubMenu subMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
      a(subMenu.getItem());
      return subMenu;
    }
    
    public boolean d() { return this.j; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */