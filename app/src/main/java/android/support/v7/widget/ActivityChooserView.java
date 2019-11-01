package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.h.c;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
  final a a;
  
  final FrameLayout b;
  
  final FrameLayout c;
  
  c d;
  
  final DataSetObserver e;
  
  PopupWindow.OnDismissListener f;
  
  boolean g;
  
  int h;
  
  private final b i;
  
  private final View j;
  
  private final ImageView k;
  
  private final int l;
  
  private final ViewTreeObserver.OnGlobalLayoutListener m;
  
  private at n;
  
  private boolean o;
  
  private int p;
  
  void a(int paramInt) {
    if (this.a.d() != null) {
      a a1;
      int i1;
      getViewTreeObserver().addOnGlobalLayoutListener(this.m);
      if (this.c.getVisibility() == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      } 
      int i2 = this.a.c();
      if (paramInt != Integer.MAX_VALUE && i2 > paramInt + i1) {
        this.a.a(true);
        a1 = this.a;
        paramInt--;
      } else {
        this.a.a(false);
        a1 = this.a;
      } 
      a1.a(paramInt);
      at at1 = getListPopupWindow();
      if (!at1.d()) {
        if (this.g || i1 == 0) {
          this.a.a(true, i1);
        } else {
          this.a.a(false, false);
        } 
        at1.g(Math.min(this.a.a(), this.l));
        at1.a();
        c c1 = this.d;
        if (c1 != null)
          c1.a(true); 
        at1.e().setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
        at1.e().setSelector(new ColorDrawable(0));
      } 
      return;
    } 
    throw new IllegalStateException("No data model. Did you call #setDataModel?");
  }
  
  public boolean a() {
    if (!c()) {
      if (!this.o)
        return false; 
      this.g = false;
      a(this.h);
      return true;
    } 
    return false;
  }
  
  public boolean b() {
    if (c()) {
      getListPopupWindow().c();
      ViewTreeObserver viewTreeObserver = getViewTreeObserver();
      if (viewTreeObserver.isAlive())
        viewTreeObserver.removeGlobalOnLayoutListener(this.m); 
    } 
    return true;
  }
  
  public boolean c() { return getListPopupWindow().d(); }
  
  public d getDataModel() { return this.a.d(); }
  
  at getListPopupWindow() {
    if (this.n == null) {
      this.n = new at(getContext());
      this.n.a(this.a);
      this.n.b(this);
      this.n.a(true);
      this.n.a(this.i);
      this.n.a(this.i);
    } 
    return this.n;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    d d1 = this.a.d();
    if (d1 != null)
      d1.registerObserver(this.e); 
    this.o = true;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    d d1 = this.a.d();
    if (d1 != null)
      d1.unregisterObserver(this.e); 
    ViewTreeObserver viewTreeObserver = getViewTreeObserver();
    if (viewTreeObserver.isAlive())
      viewTreeObserver.removeGlobalOnLayoutListener(this.m); 
    if (c())
      b(); 
    this.o = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.j.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!c())
      b(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    View view = this.j;
    if (this.c.getVisibility() != 0)
      paramInt2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824); 
    measureChild(view, paramInt1, paramInt2);
    setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(d paramd) {
    this.a.a(paramd);
    if (c()) {
      b();
      a();
    } 
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt) { this.p = paramInt; }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt) {
    String str = getContext().getString(paramInt);
    this.k.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable) { this.k.setImageDrawable(paramDrawable); }
  
  public void setInitialActivityCount(int paramInt) { this.h = paramInt; }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) { this.f = paramOnDismissListener; }
  
  public void setProvider(c paramc) { this.d = paramc; }
  
  public static class InnerLayout extends LinearLayout {
    private static final int[] a = { 16842964 };
    
    public InnerLayout(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      bm bm = bm.a(param1Context, param1AttributeSet, a);
      setBackgroundDrawable(bm.a(0));
      bm.a();
    }
  }
  
  private class a extends BaseAdapter {
    private d b;
    
    private int c;
    
    private boolean d;
    
    private boolean e;
    
    private boolean f;
    
    public int a() {
      int i = this.c;
      this.c = Integer.MAX_VALUE;
      byte b1 = 0;
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      int k = View.MeasureSpec.makeMeasureSpec(0, 0);
      int m = getCount();
      View view = null;
      int n = 0;
      while (b1 < m) {
        view = getView(b1, view, null);
        view.measure(j, k);
        n = Math.max(n, view.getMeasuredWidth());
        b1++;
      } 
      this.c = i;
      return n;
    }
    
    public void a(int param1Int) {
      if (this.c != param1Int) {
        this.c = param1Int;
        notifyDataSetChanged();
      } 
    }
    
    public void a(d param1d) {
      d d1 = this.a.a.d();
      if (d1 != null && this.a.isShown())
        d1.unregisterObserver(this.a.e); 
      this.b = param1d;
      if (param1d != null && this.a.isShown())
        param1d.registerObserver(this.a.e); 
      notifyDataSetChanged();
    }
    
    public void a(boolean param1Boolean) {
      if (this.f != param1Boolean) {
        this.f = param1Boolean;
        notifyDataSetChanged();
      } 
    }
    
    public void a(boolean param1Boolean1, boolean param1Boolean2) {
      if (this.d != param1Boolean1 || this.e != param1Boolean2) {
        this.d = param1Boolean1;
        this.e = param1Boolean2;
        notifyDataSetChanged();
      } 
    }
    
    public ResolveInfo b() { return this.b.b(); }
    
    public int c() { return this.b.a(); }
    
    public d d() { return this.b; }
    
    public boolean e() { return this.d; }
    
    public int getCount() {
      int i = this.b.a();
      if (!this.d && this.b.b() != null)
        i--; 
      int j = Math.min(i, this.c);
      if (this.f)
        j++; 
      return j;
    }
    
    public Object getItem(int param1Int) {
      switch (getItemViewType(param1Int)) {
        default:
          throw new IllegalArgumentException();
        case 1:
          return null;
        case 0:
          break;
      } 
      if (!this.d && this.b.b() != null)
        param1Int++; 
      return this.b.a(param1Int);
    }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public int getItemViewType(int param1Int) { return (this.f && param1Int == getCount() - 1) ? 1 : 0; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      switch (getItemViewType(param1Int)) {
        default:
          throw new IllegalArgumentException();
        case 1:
          if (param1View == null || param1View.getId() != 1) {
            param1View = LayoutInflater.from(this.a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, param1ViewGroup, false);
            param1View.setId(1);
            ((TextView)param1View.findViewById(a.f.title)).setText(this.a.getContext().getString(a.h.abc_activity_chooser_view_see_all));
          } 
          return param1View;
        case 0:
          break;
      } 
      if (param1View == null || param1View.getId() != a.f.list_item)
        param1View = LayoutInflater.from(this.a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, param1ViewGroup, false); 
      PackageManager packageManager = this.a.getContext().getPackageManager();
      ImageView imageView = (ImageView)param1View.findViewById(a.f.icon);
      ResolveInfo resolveInfo = (ResolveInfo)getItem(param1Int);
      imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
      ((TextView)param1View.findViewById(a.f.title)).setText(resolveInfo.loadLabel(packageManager));
      if (this.d && param1Int == 0 && this.e) {
        param1View.setActivated(true);
        return param1View;
      } 
      param1View.setActivated(false);
      return param1View;
    }
    
    public int getViewTypeCount() { return 3; }
  }
  
  private class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private void a() {
      if (this.a.f != null)
        this.a.f.onDismiss(); 
    }
    
    public void onClick(View param1View) {
      if (param1View == this.a.c) {
        this.a.b();
        ResolveInfo resolveInfo = this.a.a.b();
        int i = this.a.a.d().a(resolveInfo);
        Intent intent = this.a.a.d().b(i);
        if (intent != null) {
          intent.addFlags(524288);
          this.a.getContext().startActivity(intent);
          return;
        } 
      } else {
        if (param1View == this.a.b) {
          ActivityChooserView activityChooserView = this.a;
          activityChooserView.g = false;
          activityChooserView.a(activityChooserView.h);
          return;
        } 
        throw new IllegalArgumentException();
      } 
    }
    
    public void onDismiss() {
      a();
      if (this.a.d != null)
        this.a.d.a(false); 
    }
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      switch (((ActivityChooserView.a)param1AdapterView.getAdapter()).getItemViewType(param1Int)) {
        default:
          throw new IllegalArgumentException();
        case 1:
          this.a.a(2147483647);
          return;
        case 0:
          break;
      } 
      this.a.b();
      if (this.a.g) {
        if (param1Int > 0) {
          this.a.a.d().c(param1Int);
          return;
        } 
      } else {
        if (!this.a.a.e())
          param1Int++; 
        Intent intent = this.a.a.d().b(param1Int);
        if (intent != null) {
          intent.addFlags(524288);
          this.a.getContext().startActivity(intent);
        } 
      } 
    }
    
    public boolean onLongClick(View param1View) {
      if (param1View == this.a.c) {
        if (this.a.a.getCount() > 0) {
          ActivityChooserView activityChooserView = this.a;
          activityChooserView.g = true;
          activityChooserView.a(activityChooserView.h);
        } 
        return true;
      } 
      throw new IllegalArgumentException();
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ActivityChooserView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */