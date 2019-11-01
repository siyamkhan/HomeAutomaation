package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.f.b;
import android.support.v4.h.q;
import android.support.v4.widget.b;
import android.support.v4.widget.n;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.Future;

public class aa extends TextView implements q, b {
  private final g b = new g(this);
  
  private final z c;
  
  private Future<b> d;
  
  public aa(Context paramContext) { this(paramContext, null); }
  
  public aa(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 16842884); }
  
  public aa(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(bj.a(paramContext), paramAttributeSet, paramInt);
    this.b.a(paramAttributeSet, paramInt);
    this.c = new z(this);
    this.c.a(paramAttributeSet, paramInt);
    this.c.a();
  }
  
  private void a() { // Byte code:
    //   0: aload_0
    //   1: getfield d : Ljava/util/concurrent/Future;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull -> 30
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield d : Ljava/util/concurrent/Future;
    //   14: aload_0
    //   15: aload_1
    //   16: invokeinterface get : ()Ljava/lang/Object;
    //   21: checkcast android/support/v4/f/b
    //   24: invokestatic a : (Landroid/widget/TextView;Landroid/support/v4/f/b;)V
    //   27: goto -> 31
    //   30: pop
    //   31: return
    // Exception table:
    //   from	to	target	type
    //   9	27	30	java/lang/InterruptedException
    //   9	27	30	java/util/concurrent/ExecutionException }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    g g1 = this.b;
    if (g1 != null)
      g1.c(); 
    z z1 = this.c;
    if (z1 != null)
      z1.a(); 
  }
  
  public int getAutoSizeMaxTextSize() {
    if (a)
      return super.getAutoSizeMaxTextSize(); 
    z z1 = this.c;
    return (z1 != null) ? z1.g() : -1;
  }
  
  public int getAutoSizeMinTextSize() {
    if (a)
      return super.getAutoSizeMinTextSize(); 
    z z1 = this.c;
    return (z1 != null) ? z1.f() : -1;
  }
  
  public int getAutoSizeStepGranularity() {
    if (a)
      return super.getAutoSizeStepGranularity(); 
    z z1 = this.c;
    return (z1 != null) ? z1.e() : -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes() {
    if (a)
      return super.getAutoSizeTextAvailableSizes(); 
    z z1 = this.c;
    return (z1 != null) ? z1.h() : new int[0];
  }
  
  public int getAutoSizeTextType() {
    if (a) {
      int i = super.getAutoSizeTextType();
      byte b1 = 0;
      if (i == 1)
        b1 = 1; 
      return b1;
    } 
    z z1 = this.c;
    return (z1 != null) ? z1.d() : 0;
  }
  
  public int getFirstBaselineToTopHeight() { return n.b(this); }
  
  public int getLastBaselineToBottomHeight() { return n.c(this); }
  
  public ColorStateList getSupportBackgroundTintList() {
    g g1 = this.b;
    return (g1 != null) ? g1.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    g g1 = this.b;
    return (g1 != null) ? g1.b() : null;
  }
  
  public CharSequence getText() {
    a();
    return super.getText();
  }
  
  public b.a getTextMetricsParamsCompat() { return n.d(this); }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) { return n.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this); }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    z z1 = this.c;
    if (z1 != null)
      z1.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    a();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (this.c != null && !a && this.c.c())
      this.c.b(); 
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (a) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    z z1 = this.c;
    if (z1 != null)
      z1.a(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt) {
    if (a) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    } 
    z z1 = this.c;
    if (z1 != null)
      z1.a(paramArrayOfInt, paramInt); 
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt) {
    if (a) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    } 
    z z1 = this.c;
    if (z1 != null)
      z1.a(paramInt); 
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramInt); 
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) { super.setCustomSelectionActionModeCallback(n.a(this, paramCallback)); }
  
  public void setFirstBaselineToTopHeight(int paramInt) {
    if (Build.VERSION.SDK_INT >= 28) {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    } 
    n.b(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt) {
    if (Build.VERSION.SDK_INT >= 28) {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    } 
    n.c(this, paramInt);
  }
  
  public void setLineHeight(int paramInt) { n.d(this, paramInt); }
  
  public void setPrecomputedText(b paramb) { n.a(this, paramb); }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramMode); 
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    z z1 = this.c;
    if (z1 != null)
      z1.a(paramContext, paramInt); 
  }
  
  public void setTextFuture(Future<b> paramFuture) {
    this.d = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(b.a parama) { n.a(this, parama); }
  
  public void setTextSize(int paramInt, float paramFloat) {
    if (a) {
      super.setTextSize(paramInt, paramFloat);
      return;
    } 
    z z1 = this.c;
    if (z1 != null)
      z1.a(paramInt, paramFloat); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */