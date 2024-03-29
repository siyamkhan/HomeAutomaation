package android.support.d.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.a.a.g;
import android.support.v4.g.a;
import android.support.v4.graphics.drawable.a;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class c extends h implements b {
  ArrayList<Object> a = null;
  
  final Drawable.Callback b = new Drawable.Callback(this) {
      public void invalidateDrawable(Drawable param1Drawable) { this.a.invalidateSelf(); }
      
      public void scheduleDrawable(Drawable param1Drawable, Runnable param1Runnable, long param1Long) { this.a.scheduleSelf(param1Runnable, param1Long); }
      
      public void unscheduleDrawable(Drawable param1Drawable, Runnable param1Runnable) { this.a.unscheduleSelf(param1Runnable); }
    };
  
  private a d;
  
  private Context e;
  
  private ArgbEvaluator f = null;
  
  private Animator.AnimatorListener g = null;
  
  c() { this(null, null, null); }
  
  private c(Context paramContext) { this(paramContext, null, null); }
  
  private c(Context paramContext, a parama, Resources paramResources) {
    this.e = paramContext;
    if (parama != null) {
      this.d = parama;
      return;
    } 
    this.d = new a(paramContext, parama, this.b, paramResources);
  }
  
  public static c a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    c c1 = new c(paramContext);
    c1.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return c1;
  }
  
  private void a(Animator paramAnimator) {
    if (paramAnimator instanceof AnimatorSet) {
      ArrayList arrayList = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (arrayList != null)
        for (byte b1 = 0; b1 < arrayList.size(); b1++)
          a((Animator)arrayList.get(b1));  
    } 
    if (paramAnimator instanceof ObjectAnimator) {
      ObjectAnimator objectAnimator = (ObjectAnimator)paramAnimator;
      String str = objectAnimator.getPropertyName();
      if ("fillColor".equals(str) || "strokeColor".equals(str)) {
        if (this.f == null)
          this.f = new ArgbEvaluator(); 
        objectAnimator.setEvaluator(this.f);
      } 
    } 
  }
  
  private void a(String paramString, Animator paramAnimator) {
    paramAnimator.setTarget(this.d.b.a(paramString));
    if (Build.VERSION.SDK_INT < 21)
      a(paramAnimator); 
    if (this.d.d == null) {
      this.d.d = new ArrayList();
      this.d.e = new a();
    } 
    this.d.d.add(paramAnimator);
    this.d.e.put(paramAnimator, paramString);
  }
  
  public void applyTheme(Resources.Theme paramTheme) {
    if (this.c != null)
      a.a(this.c, paramTheme); 
  }
  
  public boolean canApplyTheme() { return (this.c != null) ? a.d(this.c) : 0; }
  
  public void draw(Canvas paramCanvas) {
    if (this.c != null) {
      this.c.draw(paramCanvas);
      return;
    } 
    this.d.b.draw(paramCanvas);
    if (this.d.c.isStarted())
      invalidateSelf(); 
  }
  
  public int getAlpha() { return (this.c != null) ? a.c(this.c) : this.d.b.getAlpha(); }
  
  public int getChangingConfigurations() { return (this.c != null) ? this.c.getChangingConfigurations() : (super.getChangingConfigurations() | this.d.a); }
  
  public Drawable.ConstantState getConstantState() { return (this.c != null && Build.VERSION.SDK_INT >= 24) ? new b(this.c.getConstantState()) : null; }
  
  public int getIntrinsicHeight() { return (this.c != null) ? this.c.getIntrinsicHeight() : this.d.b.getIntrinsicHeight(); }
  
  public int getIntrinsicWidth() { return (this.c != null) ? this.c.getIntrinsicWidth() : this.d.b.getIntrinsicWidth(); }
  
  public int getOpacity() { return (this.c != null) ? this.c.getOpacity() : this.d.b.getOpacity(); }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) { inflate(paramResources, paramXmlPullParser, paramAttributeSet, null); }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    if (this.c != null) {
      a.a(this.c, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    int i = paramXmlPullParser.getEventType();
    int j = 1 + paramXmlPullParser.getDepth();
    while (i != 1 && (paramXmlPullParser.getDepth() >= j || i != 3)) {
      if (i == 2) {
        TypedArray typedArray;
        String str = paramXmlPullParser.getName();
        if ("animated-vector".equals(str)) {
          typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.e);
          int k = typedArray.getResourceId(0, 0);
          if (k != 0) {
            i i1 = i.a(paramResources, k, paramTheme);
            i1.a(false);
            i1.setCallback(this.b);
            if (this.d.b != null)
              this.d.b.setCallback(null); 
            this.d.b = i1;
          } 
        } else if ("target".equals(str)) {
          typedArray = paramResources.obtainAttributes(paramAttributeSet, a.f);
          String str1 = typedArray.getString(0);
          int k = typedArray.getResourceId(1, 0);
          if (k != 0) {
            Context context = this.e;
            if (context != null) {
              a(str1, e.a(context, k));
            } else {
              typedArray.recycle();
              throw new IllegalStateException("Context can't be null when inflating animators");
            } 
          } 
        } else {
          continue;
        } 
        typedArray.recycle();
      } 
      continue;
      i = paramXmlPullParser.next();
    } 
    this.d.a();
  }
  
  public boolean isAutoMirrored() { return (this.c != null) ? a.b(this.c) : this.d.b.isAutoMirrored(); }
  
  public boolean isRunning() { return (this.c != null) ? ((AnimatedVectorDrawable)this.c).isRunning() : this.d.c.isRunning(); }
  
  public boolean isStateful() { return (this.c != null) ? this.c.isStateful() : this.d.b.isStateful(); }
  
  public Drawable mutate() {
    if (this.c != null)
      this.c.mutate(); 
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    if (this.c != null) {
      this.c.setBounds(paramRect);
      return;
    } 
    this.d.b.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt) { return (this.c != null) ? this.c.setLevel(paramInt) : this.d.b.setLevel(paramInt); }
  
  protected boolean onStateChange(int[] paramArrayOfInt) { return (this.c != null) ? this.c.setState(paramArrayOfInt) : this.d.b.setState(paramArrayOfInt); }
  
  public void setAlpha(int paramInt) {
    if (this.c != null) {
      this.c.setAlpha(paramInt);
      return;
    } 
    this.d.b.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    if (this.c != null) {
      a.a(this.c, paramBoolean);
      return;
    } 
    this.d.b.setAutoMirrored(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (this.c != null) {
      this.c.setColorFilter(paramColorFilter);
      return;
    } 
    this.d.b.setColorFilter(paramColorFilter);
  }
  
  public void setTint(int paramInt) {
    if (this.c != null) {
      a.a(this.c, paramInt);
      return;
    } 
    this.d.b.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (this.c != null) {
      a.a(this.c, paramColorStateList);
      return;
    } 
    this.d.b.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (this.c != null) {
      a.a(this.c, paramMode);
      return;
    } 
    this.d.b.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.c != null)
      return this.c.setVisible(paramBoolean1, paramBoolean2); 
    this.d.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start() {
    if (this.c != null) {
      ((AnimatedVectorDrawable)this.c).start();
      return;
    } 
    if (this.d.c.isStarted())
      return; 
    this.d.c.start();
    invalidateSelf();
  }
  
  public void stop() {
    if (this.c != null) {
      ((AnimatedVectorDrawable)this.c).stop();
      return;
    } 
    this.d.c.end();
  }
  
  private static class a extends Drawable.ConstantState {
    int a;
    
    i b;
    
    AnimatorSet c;
    
    ArrayList<Animator> d;
    
    a<Animator, String> e;
    
    public a(Context param1Context, a param1a, Drawable.Callback param1Callback, Resources param1Resources) {
      if (param1a != null) {
        this.a = param1a.a;
        i i1 = param1a.b;
        byte b1 = 0;
        if (i1 != null) {
          Drawable drawable;
          Drawable.ConstantState constantState = i1.getConstantState();
          if (param1Resources != null) {
            drawable = constantState.newDrawable(param1Resources);
          } else {
            drawable = constantState.newDrawable();
          } 
          this.b = (i)drawable;
          this.b = (i)this.b.mutate();
          this.b.setCallback(param1Callback);
          this.b.setBounds(param1a.b.getBounds());
          this.b.a(false);
        } 
        ArrayList arrayList = param1a.d;
        if (arrayList != null) {
          int j = arrayList.size();
          this.d = new ArrayList(j);
          this.e = new a(j);
          while (b1 < j) {
            Animator animator1 = (Animator)param1a.d.get(b1);
            Animator animator2 = animator1.clone();
            String str = (String)param1a.e.get(animator1);
            animator2.setTarget(this.b.a(str));
            this.d.add(animator2);
            this.e.put(animator2, str);
            b1++;
          } 
          a();
        } 
      } 
    }
    
    public void a() {
      if (this.c == null)
        this.c = new AnimatorSet(); 
      this.c.playTogether(this.d);
    }
    
    public int getChangingConfigurations() { return this.a; }
    
    public Drawable newDrawable() { throw new IllegalStateException("No constant state support for SDK < 24."); }
    
    public Drawable newDrawable(Resources param1Resources) { throw new IllegalStateException("No constant state support for SDK < 24."); }
  }
  
  private static class b extends Drawable.ConstantState {
    private final Drawable.ConstantState a;
    
    public b(Drawable.ConstantState param1ConstantState) { this.a = param1ConstantState; }
    
    public boolean canApplyTheme() { return this.a.canApplyTheme(); }
    
    public int getChangingConfigurations() { return this.a.getChangingConfigurations(); }
    
    public Drawable newDrawable() {
      c c = new c();
      c.c = this.a.newDrawable();
      c.c.setCallback(c.b);
      return c;
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      c c = new c();
      c.c = this.a.newDrawable(param1Resources);
      c.c.setCallback(c.b);
      return c;
    }
    
    public Drawable newDrawable(Resources param1Resources, Resources.Theme param1Theme) {
      c c = new c();
      c.c = this.a.newDrawable(param1Resources, param1Theme);
      c.c.setCallback(c.b);
      return c;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\d\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */