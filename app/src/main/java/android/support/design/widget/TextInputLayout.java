package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.a.a;
import android.support.design.internal.b;
import android.support.design.internal.c;
import android.support.v4.a.a;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.a;
import android.support.v4.h.a.c;
import android.support.v4.h.b;
import android.support.v4.h.r;
import android.support.v4.widget.n;
import android.support.v7.c.a.a;
import android.support.v7.widget.aa;
import android.support.v7.widget.al;
import android.support.v7.widget.bm;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout {
  private int A;
  
  private int B;
  
  private Drawable C;
  
  private final Rect D = new Rect();
  
  private final RectF E = new RectF();
  
  private Typeface F;
  
  private boolean G;
  
  private Drawable H;
  
  private CharSequence I;
  
  private CheckableImageButton J;
  
  private boolean K;
  
  private Drawable L;
  
  private Drawable M;
  
  private ColorStateList N;
  
  private boolean O;
  
  private PorterDuff.Mode P;
  
  private boolean Q;
  
  private ColorStateList R;
  
  private ColorStateList S;
  
  private final int T;
  
  private final int U;
  
  private int V;
  
  private final int W;
  
  EditText a;
  
  private boolean aa;
  
  private boolean ab;
  
  private ValueAnimator ac;
  
  private boolean ad;
  
  private boolean ae;
  
  private boolean af;
  
  boolean b;
  
  final b c = new b(this);
  
  private final FrameLayout d;
  
  private CharSequence e;
  
  private final j f = new j(this);
  
  private int g;
  
  private boolean h;
  
  private TextView i;
  
  private final int j;
  
  private final int k;
  
  private boolean l;
  
  private CharSequence m;
  
  private boolean n;
  
  private GradientDrawable o;
  
  private final int p;
  
  private final int q;
  
  private int r;
  
  private final int s;
  
  private float t;
  
  private float u;
  
  private float v;
  
  private float w;
  
  private int x;
  
  private final int y;
  
  private final int z;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.b.textInputStyle); }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.d = new FrameLayout(paramContext);
    this.d.setAddStatesFromChildren(true);
    addView(this.d);
    this.c.a(a.a);
    this.c.b(a.a);
    this.c.b(8388659);
    bm bm = b.b(paramContext, paramAttributeSet, a.k.TextInputLayout, paramInt, a.j.Widget_Design_TextInputLayout, new int[0]);
    this.l = bm.a(a.k.TextInputLayout_hintEnabled, true);
    setHint(bm.c(a.k.TextInputLayout_android_hint));
    this.ab = bm.a(a.k.TextInputLayout_hintAnimationEnabled, true);
    this.p = paramContext.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_bottom_offset);
    this.q = paramContext.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_label_cutout_padding);
    this.s = bm.d(a.k.TextInputLayout_boxCollapsedPaddingTop, 0);
    this.t = bm.b(a.k.TextInputLayout_boxCornerRadiusTopStart, 0.0F);
    this.u = bm.b(a.k.TextInputLayout_boxCornerRadiusTopEnd, 0.0F);
    this.v = bm.b(a.k.TextInputLayout_boxCornerRadiusBottomEnd, 0.0F);
    this.w = bm.b(a.k.TextInputLayout_boxCornerRadiusBottomStart, 0.0F);
    this.B = bm.b(a.k.TextInputLayout_boxBackgroundColor, 0);
    this.V = bm.b(a.k.TextInputLayout_boxStrokeColor, 0);
    this.y = paramContext.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_default);
    this.z = paramContext.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_focused);
    this.x = this.y;
    setBoxBackgroundMode(bm.a(a.k.TextInputLayout_boxBackgroundMode, 0));
    if (bm.g(a.k.TextInputLayout_android_textColorHint)) {
      ColorStateList colorStateList = bm.e(a.k.TextInputLayout_android_textColorHint);
      this.S = colorStateList;
      this.R = colorStateList;
    } 
    this.T = a.c(paramContext, a.c.mtrl_textinput_default_box_stroke_color);
    this.W = a.c(paramContext, a.c.mtrl_textinput_disabled_color);
    this.U = a.c(paramContext, a.c.mtrl_textinput_hovered_box_stroke_color);
    if (bm.g(a.k.TextInputLayout_hintTextAppearance, -1) != -1)
      setHintTextAppearance(bm.g(a.k.TextInputLayout_hintTextAppearance, 0)); 
    int i1 = bm.g(a.k.TextInputLayout_errorTextAppearance, 0);
    boolean bool1 = bm.a(a.k.TextInputLayout_errorEnabled, false);
    int i2 = bm.g(a.k.TextInputLayout_helperTextTextAppearance, 0);
    boolean bool2 = bm.a(a.k.TextInputLayout_helperTextEnabled, false);
    CharSequence charSequence = bm.c(a.k.TextInputLayout_helperText);
    boolean bool3 = bm.a(a.k.TextInputLayout_counterEnabled, false);
    setCounterMaxLength(bm.a(a.k.TextInputLayout_counterMaxLength, -1));
    this.k = bm.g(a.k.TextInputLayout_counterTextAppearance, 0);
    this.j = bm.g(a.k.TextInputLayout_counterOverflowTextAppearance, 0);
    this.G = bm.a(a.k.TextInputLayout_passwordToggleEnabled, false);
    this.H = bm.a(a.k.TextInputLayout_passwordToggleDrawable);
    this.I = bm.c(a.k.TextInputLayout_passwordToggleContentDescription);
    if (bm.g(a.k.TextInputLayout_passwordToggleTint)) {
      this.O = true;
      this.N = bm.e(a.k.TextInputLayout_passwordToggleTint);
    } 
    if (bm.g(a.k.TextInputLayout_passwordToggleTintMode)) {
      this.Q = true;
      this.P = c.a(bm.a(a.k.TextInputLayout_passwordToggleTintMode, -1), null);
    } 
    bm.a();
    setHelperTextEnabled(bool2);
    setHelperText(charSequence);
    setHelperTextTextAppearance(i2);
    setErrorEnabled(bool1);
    setErrorTextAppearance(i1);
    setCounterEnabled(bool3);
    s();
    r.b(this, 2);
  }
  
  private void a(RectF paramRectF) {
    paramRectF.left -= this.q;
    paramRectF.top -= this.q;
    paramRectF.right += this.q;
    paramRectF.bottom += this.q;
  }
  
  private static void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    int i1 = paramViewGroup.getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = paramViewGroup.getChildAt(b1);
      view.setEnabled(paramBoolean);
      if (view instanceof ViewGroup)
        a((ViewGroup)view, paramBoolean); 
    } 
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual isEnabled : ()Z
    //   4: istore_3
    //   5: aload_0
    //   6: getfield a : Landroid/widget/EditText;
    //   9: astore #4
    //   11: iconst_1
    //   12: istore #5
    //   14: aload #4
    //   16: ifnull -> 36
    //   19: aload #4
    //   21: invokevirtual getText : ()Landroid/text/Editable;
    //   24: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   27: ifne -> 36
    //   30: iconst_1
    //   31: istore #6
    //   33: goto -> 39
    //   36: iconst_0
    //   37: istore #6
    //   39: aload_0
    //   40: getfield a : Landroid/widget/EditText;
    //   43: astore #7
    //   45: aload #7
    //   47: ifnull -> 61
    //   50: aload #7
    //   52: invokevirtual hasFocus : ()Z
    //   55: ifeq -> 61
    //   58: goto -> 64
    //   61: iconst_0
    //   62: istore #5
    //   64: aload_0
    //   65: getfield f : Landroid/support/design/widget/j;
    //   68: invokevirtual g : ()Z
    //   71: istore #8
    //   73: aload_0
    //   74: getfield R : Landroid/content/res/ColorStateList;
    //   77: astore #9
    //   79: aload #9
    //   81: ifnull -> 104
    //   84: aload_0
    //   85: getfield c : Landroid/support/design/widget/b;
    //   88: aload #9
    //   90: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   93: aload_0
    //   94: getfield c : Landroid/support/design/widget/b;
    //   97: aload_0
    //   98: getfield R : Landroid/content/res/ColorStateList;
    //   101: invokevirtual b : (Landroid/content/res/ColorStateList;)V
    //   104: iload_3
    //   105: ifne -> 139
    //   108: aload_0
    //   109: getfield c : Landroid/support/design/widget/b;
    //   112: aload_0
    //   113: getfield W : I
    //   116: invokestatic valueOf : (I)Landroid/content/res/ColorStateList;
    //   119: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   122: aload_0
    //   123: getfield c : Landroid/support/design/widget/b;
    //   126: aload_0
    //   127: getfield W : I
    //   130: invokestatic valueOf : (I)Landroid/content/res/ColorStateList;
    //   133: invokevirtual b : (Landroid/content/res/ColorStateList;)V
    //   136: goto -> 227
    //   139: iload #8
    //   141: ifeq -> 161
    //   144: aload_0
    //   145: getfield c : Landroid/support/design/widget/b;
    //   148: aload_0
    //   149: getfield f : Landroid/support/design/widget/j;
    //   152: invokevirtual k : ()Landroid/content/res/ColorStateList;
    //   155: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   158: goto -> 227
    //   161: aload_0
    //   162: getfield h : Z
    //   165: ifeq -> 202
    //   168: aload_0
    //   169: getfield i : Landroid/widget/TextView;
    //   172: astore #12
    //   174: aload #12
    //   176: ifnull -> 202
    //   179: aload_0
    //   180: getfield c : Landroid/support/design/widget/b;
    //   183: astore #11
    //   185: aload #12
    //   187: invokevirtual getTextColors : ()Landroid/content/res/ColorStateList;
    //   190: astore #10
    //   192: aload #11
    //   194: aload #10
    //   196: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   199: goto -> 227
    //   202: iload #5
    //   204: ifeq -> 227
    //   207: aload_0
    //   208: getfield S : Landroid/content/res/ColorStateList;
    //   211: astore #10
    //   213: aload #10
    //   215: ifnull -> 227
    //   218: aload_0
    //   219: getfield c : Landroid/support/design/widget/b;
    //   222: astore #11
    //   224: goto -> 192
    //   227: iload #6
    //   229: ifne -> 269
    //   232: aload_0
    //   233: invokevirtual isEnabled : ()Z
    //   236: ifeq -> 252
    //   239: iload #5
    //   241: ifne -> 269
    //   244: iload #8
    //   246: ifeq -> 252
    //   249: goto -> 269
    //   252: iload_2
    //   253: ifne -> 263
    //   256: aload_0
    //   257: getfield aa : Z
    //   260: ifne -> 285
    //   263: aload_0
    //   264: iload_1
    //   265: invokespecial d : (Z)V
    //   268: return
    //   269: iload_2
    //   270: ifne -> 280
    //   273: aload_0
    //   274: getfield aa : Z
    //   277: ifeq -> 285
    //   280: aload_0
    //   281: iload_1
    //   282: invokespecial c : (Z)V
    //   285: return }
  
  private void c(boolean paramBoolean) {
    ValueAnimator valueAnimator = this.ac;
    if (valueAnimator != null && valueAnimator.isRunning())
      this.ac.cancel(); 
    if (paramBoolean && this.ab) {
      a(1.0F);
    } else {
      this.c.b(1.0F);
    } 
    this.aa = false;
    if (t())
      u(); 
  }
  
  private void d(boolean paramBoolean) {
    ValueAnimator valueAnimator = this.ac;
    if (valueAnimator != null && valueAnimator.isRunning())
      this.ac.cancel(); 
    if (paramBoolean && this.ab) {
      a(0.0F);
    } else {
      this.c.b(0.0F);
    } 
    if (t() && ((c)this.o).a())
      v(); 
    this.aa = true;
  }
  
  private void e() {
    f();
    if (this.r != 0)
      g(); 
    h();
  }
  
  private void f() {
    GradientDrawable gradientDrawable;
    int i1 = this.r;
    if (i1 == 0) {
      gradientDrawable = null;
    } else if (i1 == 2 && this.l && !(this.o instanceof c)) {
      gradientDrawable = new c();
    } else if (!(this.o instanceof GradientDrawable)) {
      gradientDrawable = new GradientDrawable();
    } else {
      return;
    } 
    this.o = gradientDrawable;
  }
  
  private void g() {
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    int i1 = j();
    if (i1 != layoutParams.topMargin) {
      layoutParams.topMargin = i1;
      this.d.requestLayout();
    } 
  }
  
  private Drawable getBoxBackground() {
    int i1 = this.r;
    if (i1 == 1 || i1 == 2)
      return this.o; 
    throw new IllegalStateException();
  }
  
  private float[] getCornerRadiiAsArray() {
    if (!c.a(this)) {
      float[] arrayOfFloat1 = new float[8];
      float f5 = this.t;
      arrayOfFloat1[0] = f5;
      arrayOfFloat1[1] = f5;
      float f6 = this.u;
      arrayOfFloat1[2] = f6;
      arrayOfFloat1[3] = f6;
      float f7 = this.v;
      arrayOfFloat1[4] = f7;
      arrayOfFloat1[5] = f7;
      float f8 = this.w;
      arrayOfFloat1[6] = f8;
      arrayOfFloat1[7] = f8;
      return arrayOfFloat1;
    } 
    float[] arrayOfFloat = new float[8];
    float f1 = this.u;
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = f1;
    float f2 = this.t;
    arrayOfFloat[2] = f2;
    arrayOfFloat[3] = f2;
    float f3 = this.w;
    arrayOfFloat[4] = f3;
    arrayOfFloat[5] = f3;
    float f4 = this.v;
    arrayOfFloat[6] = f4;
    arrayOfFloat[7] = f4;
    return arrayOfFloat;
  }
  
  private void h() {
    if (this.r != 0 && this.o != null && this.a != null) {
      if (getRight() == 0)
        return; 
      int i1 = this.a.getLeft();
      int i2 = i();
      int i3 = this.a.getRight();
      int i4 = this.a.getBottom() + this.p;
      if (this.r == 2) {
        int i5 = this.z;
        i1 += i5 / 2;
        i2 -= i5 / 2;
        i3 -= i5 / 2;
        i4 += i5 / 2;
      } 
      this.o.setBounds(i1, i2, i3, i4);
      n();
      l();
    } 
  }
  
  private int i() {
    EditText editText = this.a;
    if (editText == null)
      return 0; 
    switch (this.r) {
      default:
        return 0;
      case 2:
        return editText.getTop() + j();
      case 1:
        break;
    } 
    return editText.getTop();
  }
  
  private int j() {
    if (!this.l)
      return 0; 
    switch (this.r) {
      default:
        return 0;
      case 2:
        f1 = this.c.b() / 2.0F;
        return (int)f1;
      case 0:
      case 1:
        break;
    } 
    float f1 = this.c.b();
    return (int)f1;
  }
  
  private int k() {
    switch (this.r) {
      default:
        return getPaddingTop();
      case 2:
        return (getBoxBackground().getBounds()).top - j();
      case 1:
        break;
    } 
    return (getBoxBackground().getBounds()).top + this.s;
  }
  
  private void l() {
    EditText editText = this.a;
    if (editText == null)
      return; 
    Drawable drawable = editText.getBackground();
    if (drawable == null)
      return; 
    if (al.b(drawable))
      drawable = drawable.mutate(); 
    Rect rect1 = new Rect();
    d.b(this, this.a, rect1);
    Rect rect2 = drawable.getBounds();
    if (rect2.left != rect2.right) {
      Rect rect = new Rect();
      drawable.getPadding(rect);
      int i1 = rect2.left - rect.left;
      int i2 = rect2.right + 2 * rect.right;
      drawable.setBounds(i1, rect2.top, i2, this.a.getBottom());
    } 
  }
  
  private void m() {
    switch (this.r) {
      default:
        return;
      case 2:
        if (this.V == 0) {
          this.V = this.S.getColorForState(getDrawableState(), this.S.getDefaultColor());
          return;
        } 
        return;
      case 1:
        break;
    } 
    this.x = 0;
  }
  
  private void n() {
    if (this.o == null)
      return; 
    m();
    EditText editText1 = this.a;
    if (editText1 != null && this.r == 2) {
      if (editText1.getBackground() != null)
        this.C = this.a.getBackground(); 
      r.a(this.a, null);
    } 
    EditText editText2 = this.a;
    if (editText2 != null && this.r == 1) {
      Drawable drawable = this.C;
      if (drawable != null)
        r.a(editText2, drawable); 
    } 
    int i1 = this.x;
    if (i1 > -1) {
      int i2 = this.A;
      if (i2 != 0)
        this.o.setStroke(i1, i2); 
    } 
    this.o.setCornerRadii(getCornerRadiiAsArray());
    this.o.setColor(this.B);
    invalidate();
  }
  
  private void o() {
    int i1 = Build.VERSION.SDK_INT;
    if (i1 != 21 && i1 != 22)
      return; 
    Drawable drawable = this.a.getBackground();
    if (drawable == null)
      return; 
    if (!this.ad) {
      Drawable drawable1 = drawable.getConstantState().newDrawable();
      if (drawable instanceof DrawableContainer)
        this.ad = e.a((DrawableContainer)drawable, drawable1.getConstantState()); 
      if (!this.ad) {
        r.a(this.a, drawable1);
        this.ad = true;
        e();
      } 
    } 
  }
  
  private void p() {
    if (this.a == null)
      return; 
    if (r()) {
      if (this.J == null) {
        this.J = (CheckableImageButton)LayoutInflater.from(getContext()).inflate(a.h.design_text_input_password_icon, this.d, false);
        this.J.setImageDrawable(this.H);
        this.J.setContentDescription(this.I);
        this.d.addView(this.J);
        this.J.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) { this.a.b(false); }
            });
      } 
      EditText editText = this.a;
      if (editText != null && r.k(editText) <= 0)
        this.a.setMinimumHeight(r.k(this.J)); 
      this.J.setVisibility(0);
      this.J.setChecked(this.K);
      if (this.L == null)
        this.L = new ColorDrawable(); 
      this.L.setBounds(0, 0, this.J.getMeasuredWidth(), 1);
      Drawable[] arrayOfDrawable = n.a(this.a);
      if (arrayOfDrawable[2] != this.L)
        this.M = arrayOfDrawable[2]; 
      n.a(this.a, arrayOfDrawable[0], arrayOfDrawable[1], this.L, arrayOfDrawable[3]);
      this.J.setPadding(this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
      return;
    } 
    CheckableImageButton checkableImageButton = this.J;
    if (checkableImageButton != null && checkableImageButton.getVisibility() == 0)
      this.J.setVisibility(8); 
    if (this.L != null) {
      Drawable[] arrayOfDrawable = n.a(this.a);
      if (arrayOfDrawable[2] == this.L) {
        n.a(this.a, arrayOfDrawable[0], arrayOfDrawable[1], this.M, arrayOfDrawable[3]);
        this.L = null;
      } 
    } 
  }
  
  private boolean q() {
    EditText editText = this.a;
    return (editText != null && editText.getTransformationMethod() instanceof PasswordTransformationMethod);
  }
  
  private boolean r() { return (this.G && (q() || this.K)); }
  
  private void s() {
    if (this.H != null && (this.O || this.Q)) {
      this.H = a.g(this.H).mutate();
      if (this.O)
        a.a(this.H, this.N); 
      if (this.Q)
        a.a(this.H, this.P); 
      CheckableImageButton checkableImageButton = this.J;
      if (checkableImageButton != null) {
        Drawable drawable1 = checkableImageButton.getDrawable();
        Drawable drawable2 = this.H;
        if (drawable1 != drawable2)
          this.J.setImageDrawable(drawable2); 
      } 
    } 
  }
  
  private void setEditText(EditText paramEditText) {
    if (this.a == null) {
      if (!(paramEditText instanceof p))
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead."); 
      this.a = paramEditText;
      e();
      setTextInputAccessibilityDelegate(new a(this));
      if (!q())
        this.c.a(this.a.getTypeface()); 
      this.c.a(this.a.getTextSize());
      int i1 = this.a.getGravity();
      this.c.b(0x30 | i1 & 0xFFFFFF8F);
      this.c.a(i1);
      this.a.addTextChangedListener(new TextWatcher(this) {
            public void afterTextChanged(Editable param1Editable) {
              TextInputLayout textInputLayout;
              textInputLayout.a(true ^ (textInputLayout = this.a).a(textInputLayout));
              if (this.a.b)
                this.a.a(param1Editable.length()); 
            }
            
            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            
            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          });
      if (this.R == null)
        this.R = this.a.getHintTextColors(); 
      if (this.l) {
        if (TextUtils.isEmpty(this.m)) {
          this.e = this.a.getHint();
          setHint(this.e);
          this.a.setHint(null);
        } 
        this.n = true;
      } 
      if (this.i != null)
        a(this.a.getText().length()); 
      this.f.d();
      p();
      a(false, true);
      return;
    } 
    throw new IllegalArgumentException("We already have an EditText, can only have one");
  }
  
  private void setHintInternal(CharSequence paramCharSequence) {
    if (!TextUtils.equals(paramCharSequence, this.m)) {
      this.m = paramCharSequence;
      this.c.a(paramCharSequence);
      if (!this.aa)
        u(); 
    } 
  }
  
  private boolean t() { return (this.l && !TextUtils.isEmpty(this.m) && this.o instanceof c); }
  
  private void u() {
    if (!t())
      return; 
    RectF rectF = this.E;
    this.c.a(rectF);
    a(rectF);
    ((c)this.o).a(rectF);
  }
  
  private void v() {
    if (t())
      ((c)this.o).b(); 
  }
  
  void a(float paramFloat) {
    if (this.c.e() == paramFloat)
      return; 
    if (this.ac == null) {
      this.ac = new ValueAnimator();
      this.ac.setInterpolator(a.b);
      this.ac.setDuration(167L);
      this.ac.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) { this.a.c.b(((Float)param1ValueAnimator.getAnimatedValue()).floatValue()); }
          });
    } 
    ValueAnimator valueAnimator = this.ac;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.c.e();
    arrayOfFloat[1] = paramFloat;
    valueAnimator.setFloatValues(arrayOfFloat);
    this.ac.start();
  }
  
  void a(int paramInt) {
    boolean bool = this.h;
    if (this.g == -1) {
      this.i.setText(String.valueOf(paramInt));
      this.i.setContentDescription(null);
      this.h = false;
    } else {
      boolean bool1;
      if (r.g(this.i) == 1)
        r.c(this.i, 0); 
      if (paramInt > this.g) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.h = bool1;
      boolean bool2 = this.h;
      if (bool != bool2) {
        int i3;
        TextView textView = this.i;
        if (bool2) {
          i3 = this.j;
        } else {
          i3 = this.k;
        } 
        a(textView, i3);
        if (this.h)
          r.c(this.i, 1); 
      } 
      TextView textView1 = this.i;
      Context context1 = getContext();
      int i1 = a.i.character_counter_pattern;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(paramInt);
      arrayOfObject1[1] = Integer.valueOf(this.g);
      textView1.setText(context1.getString(i1, arrayOfObject1));
      TextView textView2 = this.i;
      Context context2 = getContext();
      int i2 = a.i.character_counter_content_description;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(paramInt);
      arrayOfObject2[1] = Integer.valueOf(this.g);
      textView2.setContentDescription(context2.getString(i2, arrayOfObject2));
    } 
    if (this.a != null && bool != this.h) {
      a(false);
      d();
      c();
    } 
  }
  
  void a(TextView paramTextView, int paramInt) { // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic a : (Landroid/widget/TextView;I)V
    //   7: getstatic android/os/Build$VERSION.SDK_INT : I
    //   10: bipush #23
    //   12: if_icmplt -> 35
    //   15: aload_1
    //   16: invokevirtual getTextColors : ()Landroid/content/res/ColorStateList;
    //   19: invokevirtual getDefaultColor : ()I
    //   22: istore #5
    //   24: iload #5
    //   26: ldc_w -65281
    //   29: if_icmpne -> 35
    //   32: goto -> 40
    //   35: iconst_0
    //   36: istore_3
    //   37: goto -> 41
    //   40: pop
    //   41: iload_3
    //   42: ifeq -> 66
    //   45: aload_1
    //   46: getstatic android/support/design/a$j.TextAppearance_AppCompat_Caption : I
    //   49: invokestatic a : (Landroid/widget/TextView;I)V
    //   52: aload_1
    //   53: aload_0
    //   54: invokevirtual getContext : ()Landroid/content/Context;
    //   57: getstatic android/support/design/a$c.design_error : I
    //   60: invokestatic c : (Landroid/content/Context;I)I
    //   63: invokevirtual setTextColor : (I)V
    //   66: return
    // Exception table:
    //   from	to	target	type
    //   2	24	40	java/lang/Exception }
  
  void a(boolean paramBoolean) { a(paramBoolean, false); }
  
  boolean a() { return this.n; }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    if (paramView instanceof EditText) {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      layoutParams.gravity = 0x10 | 0xFFFFFF8F & layoutParams.gravity;
      this.d.addView(paramView, layoutParams);
      this.d.setLayoutParams(paramLayoutParams);
      g();
      setEditText((EditText)paramView);
      return;
    } 
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void b(boolean paramBoolean) {
    if (this.G) {
      boolean bool;
      int i1 = this.a.getSelectionEnd();
      if (q()) {
        this.a.setTransformationMethod(null);
        bool = true;
      } else {
        this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
        bool = false;
      } 
      this.K = bool;
      this.J.setChecked(this.K);
      if (paramBoolean)
        this.J.jumpDrawablesToCurrentState(); 
      this.a.setSelection(i1);
    } 
  }
  
  public boolean b() { return this.f.f(); }
  
  void c() { // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroid/widget/EditText;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull -> 10
    //   9: return
    //   10: aload_1
    //   11: invokevirtual getBackground : ()Landroid/graphics/drawable/Drawable;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull -> 20
    //   19: return
    //   20: aload_0
    //   21: invokespecial o : ()V
    //   24: aload_2
    //   25: invokestatic b : (Landroid/graphics/drawable/Drawable;)Z
    //   28: ifeq -> 36
    //   31: aload_2
    //   32: invokevirtual mutate : ()Landroid/graphics/drawable/Drawable;
    //   35: astore_2
    //   36: aload_0
    //   37: getfield f : Landroid/support/design/widget/j;
    //   40: invokevirtual g : ()Z
    //   43: ifeq -> 68
    //   46: aload_0
    //   47: getfield f : Landroid/support/design/widget/j;
    //   50: invokevirtual j : ()I
    //   53: istore #4
    //   55: aload_2
    //   56: iload #4
    //   58: getstatic android/graphics/PorterDuff$Mode.SRC_IN : Landroid/graphics/PorterDuff$Mode;
    //   61: invokestatic a : (ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;
    //   64: invokevirtual setColorFilter : (Landroid/graphics/ColorFilter;)V
    //   67: return
    //   68: aload_0
    //   69: getfield h : Z
    //   72: ifeq -> 93
    //   75: aload_0
    //   76: getfield i : Landroid/widget/TextView;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull -> 93
    //   84: aload_3
    //   85: invokevirtual getCurrentTextColor : ()I
    //   88: istore #4
    //   90: goto -> 55
    //   93: aload_2
    //   94: invokestatic f : (Landroid/graphics/drawable/Drawable;)V
    //   97: aload_0
    //   98: getfield a : Landroid/widget/EditText;
    //   101: invokevirtual refreshDrawableState : ()V
    //   104: return }
  
  void d() { // Byte code:
    //   0: aload_0
    //   1: getfield o : Landroid/graphics/drawable/GradientDrawable;
    //   4: ifnull -> 219
    //   7: aload_0
    //   8: getfield r : I
    //   11: ifne -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield a : Landroid/widget/EditText;
    //   19: astore_1
    //   20: iconst_1
    //   21: istore_2
    //   22: aload_1
    //   23: ifnull -> 38
    //   26: aload_1
    //   27: invokevirtual hasFocus : ()Z
    //   30: ifeq -> 38
    //   33: iconst_1
    //   34: istore_3
    //   35: goto -> 40
    //   38: iconst_0
    //   39: istore_3
    //   40: aload_0
    //   41: getfield a : Landroid/widget/EditText;
    //   44: astore #4
    //   46: aload #4
    //   48: ifnull -> 62
    //   51: aload #4
    //   53: invokevirtual isHovered : ()Z
    //   56: ifeq -> 62
    //   59: goto -> 64
    //   62: iconst_0
    //   63: istore_2
    //   64: aload_0
    //   65: getfield r : I
    //   68: iconst_2
    //   69: if_icmpne -> 219
    //   72: aload_0
    //   73: invokevirtual isEnabled : ()Z
    //   76: ifne -> 94
    //   79: aload_0
    //   80: getfield W : I
    //   83: istore #5
    //   85: aload_0
    //   86: iload #5
    //   88: putfield A : I
    //   91: goto -> 179
    //   94: aload_0
    //   95: getfield f : Landroid/support/design/widget/j;
    //   98: invokevirtual g : ()Z
    //   101: ifeq -> 116
    //   104: aload_0
    //   105: getfield f : Landroid/support/design/widget/j;
    //   108: invokevirtual j : ()I
    //   111: istore #5
    //   113: goto -> 85
    //   116: aload_0
    //   117: getfield h : Z
    //   120: ifeq -> 144
    //   123: aload_0
    //   124: getfield i : Landroid/widget/TextView;
    //   127: astore #7
    //   129: aload #7
    //   131: ifnull -> 144
    //   134: aload #7
    //   136: invokevirtual getCurrentTextColor : ()I
    //   139: istore #5
    //   141: goto -> 85
    //   144: iload_3
    //   145: ifeq -> 157
    //   148: aload_0
    //   149: getfield V : I
    //   152: istore #5
    //   154: goto -> 85
    //   157: iload_2
    //   158: ifeq -> 170
    //   161: aload_0
    //   162: getfield U : I
    //   165: istore #5
    //   167: goto -> 85
    //   170: aload_0
    //   171: getfield T : I
    //   174: istore #5
    //   176: goto -> 85
    //   179: iload_2
    //   180: ifne -> 187
    //   183: iload_3
    //   184: ifeq -> 203
    //   187: aload_0
    //   188: invokevirtual isEnabled : ()Z
    //   191: ifeq -> 203
    //   194: aload_0
    //   195: getfield z : I
    //   198: istore #6
    //   200: goto -> 209
    //   203: aload_0
    //   204: getfield y : I
    //   207: istore #6
    //   209: aload_0
    //   210: iload #6
    //   212: putfield x : I
    //   215: aload_0
    //   216: invokespecial n : ()V
    //   219: return }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt) {
    if (this.e != null) {
      EditText editText = this.a;
      if (editText != null) {
        bool = this.n;
        this.n = false;
        charSequence = editText.getHint();
        this.a.setHint(this.e);
        try {
          super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
          return;
        } finally {
          this.a.setHint(charSequence);
          this.n = bool;
        } 
      } 
    } 
    super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
    this.af = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.af = false;
  }
  
  public void draw(Canvas paramCanvas) {
    GradientDrawable gradientDrawable = this.o;
    if (gradientDrawable != null)
      gradientDrawable.draw(paramCanvas); 
    super.draw(paramCanvas);
    if (this.l)
      this.c.a(paramCanvas); 
  }
  
  protected void drawableStateChanged() {
    boolean bool1;
    if (this.ae)
      return; 
    boolean bool = true;
    this.ae = bool;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (!r.x(this) || !isEnabled())
      bool = false; 
    a(bool);
    c();
    h();
    d();
    b b1 = this.c;
    if (b1 != null) {
      bool1 = false | b1.a(arrayOfInt);
    } else {
      bool1 = false;
    } 
    if (bool1)
      invalidate(); 
    this.ae = false;
  }
  
  public int getBoxBackgroundColor() { return this.B; }
  
  public float getBoxCornerRadiusBottomEnd() { return this.v; }
  
  public float getBoxCornerRadiusBottomStart() { return this.w; }
  
  public float getBoxCornerRadiusTopEnd() { return this.u; }
  
  public float getBoxCornerRadiusTopStart() { return this.t; }
  
  public int getBoxStrokeColor() { return this.V; }
  
  public int getCounterMaxLength() { return this.g; }
  
  CharSequence getCounterOverflowDescription() {
    if (this.b && this.h) {
      TextView textView = this.i;
      if (textView != null)
        return textView.getContentDescription(); 
    } 
    return null;
  }
  
  public ColorStateList getDefaultHintTextColor() { return this.R; }
  
  public EditText getEditText() { return this.a; }
  
  public CharSequence getError() { return this.f.e() ? this.f.h() : null; }
  
  public int getErrorCurrentTextColors() { return this.f.j(); }
  
  final int getErrorTextCurrentColor() { return this.f.j(); }
  
  public CharSequence getHelperText() { return this.f.f() ? this.f.i() : null; }
  
  public int getHelperTextCurrentTextColor() { return this.f.l(); }
  
  public CharSequence getHint() { return this.l ? this.m : null; }
  
  final float getHintCollapsedTextHeight() { return this.c.b(); }
  
  final int getHintCurrentCollapsedTextColor() { return this.c.f(); }
  
  public CharSequence getPasswordVisibilityToggleContentDescription() { return this.I; }
  
  public Drawable getPasswordVisibilityToggleDrawable() { return this.H; }
  
  public Typeface getTypeface() { return this.F; }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.o != null)
      h(); 
    if (this.l) {
      EditText editText = this.a;
      if (editText != null) {
        Rect rect = this.D;
        d.b(this, editText, rect);
        int i1 = rect.left + this.a.getCompoundPaddingLeft();
        int i2 = rect.right - this.a.getCompoundPaddingRight();
        int i3 = k();
        this.c.a(i1, rect.top + this.a.getCompoundPaddingTop(), i2, rect.bottom - this.a.getCompoundPaddingBottom());
        this.c.b(i1, i3, i2, paramInt4 - paramInt2 - getPaddingBottom());
        this.c.g();
        if (t() && !this.aa)
          u(); 
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    p();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof b)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    b b1 = (b)paramParcelable;
    super.onRestoreInstanceState(b1.a());
    setError(b1.a);
    if (b1.b)
      b(true); 
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState() {
    b b1 = new b(super.onSaveInstanceState());
    if (this.f.g())
      b1.a = getError(); 
    b1.b = this.K;
    return b1;
  }
  
  public void setBoxBackgroundColor(int paramInt) {
    if (this.B != paramInt) {
      this.B = paramInt;
      n();
    } 
  }
  
  public void setBoxBackgroundColorResource(int paramInt) { setBoxBackgroundColor(a.c(getContext(), paramInt)); }
  
  public void setBoxBackgroundMode(int paramInt) {
    if (paramInt == this.r)
      return; 
    this.r = paramInt;
    e();
  }
  
  public void setBoxStrokeColor(int paramInt) {
    if (this.V != paramInt) {
      this.V = paramInt;
      d();
    } 
  }
  
  public void setCounterEnabled(boolean paramBoolean) {
    if (this.b != paramBoolean) {
      if (paramBoolean) {
        int i1;
        this.i = new aa(getContext());
        this.i.setId(a.f.textinput_counter);
        Typeface typeface = this.F;
        if (typeface != null)
          this.i.setTypeface(typeface); 
        this.i.setMaxLines(1);
        a(this.i, this.k);
        this.f.a(this.i, 2);
        EditText editText = this.a;
        if (editText == null) {
          i1 = 0;
        } else {
          i1 = editText.getText().length();
        } 
        a(i1);
      } else {
        this.f.b(this.i, 2);
        this.i = null;
      } 
      this.b = paramBoolean;
    } 
  }
  
  public void setCounterMaxLength(int paramInt) {
    if (this.g != paramInt) {
      if (paramInt <= 0)
        paramInt = -1; 
      this.g = paramInt;
      if (this.b) {
        int i1;
        EditText editText = this.a;
        if (editText == null) {
          i1 = 0;
        } else {
          i1 = editText.getText().length();
        } 
        a(i1);
      } 
    } 
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList) {
    this.R = paramColorStateList;
    this.S = paramColorStateList;
    if (this.a != null)
      a(false); 
  }
  
  public void setEnabled(boolean paramBoolean) {
    a(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence) {
    if (!this.f.e()) {
      if (TextUtils.isEmpty(paramCharSequence))
        return; 
      setErrorEnabled(true);
    } 
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.f.b(paramCharSequence);
      return;
    } 
    this.f.b();
  }
  
  public void setErrorEnabled(boolean paramBoolean) { this.f.a(paramBoolean); }
  
  public void setErrorTextAppearance(int paramInt) { this.f.b(paramInt); }
  
  public void setErrorTextColor(ColorStateList paramColorStateList) { this.f.a(paramColorStateList); }
  
  public void setHelperText(CharSequence paramCharSequence) {
    if (TextUtils.isEmpty(paramCharSequence)) {
      if (b()) {
        setHelperTextEnabled(false);
        return;
      } 
    } else {
      if (!b())
        setHelperTextEnabled(true); 
      this.f.a(paramCharSequence);
    } 
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList) { this.f.b(paramColorStateList); }
  
  public void setHelperTextEnabled(boolean paramBoolean) { this.f.b(paramBoolean); }
  
  public void setHelperTextTextAppearance(int paramInt) { this.f.c(paramInt); }
  
  public void setHint(CharSequence paramCharSequence) {
    if (this.l) {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    } 
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean) { this.ab = paramBoolean; }
  
  public void setHintEnabled(boolean paramBoolean) {
    if (paramBoolean != this.l) {
      this.l = paramBoolean;
      if (!this.l) {
        this.n = false;
        if (!TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.a.getHint()))
          this.a.setHint(this.m); 
        setHintInternal(null);
      } else {
        CharSequence charSequence = this.a.getHint();
        if (!TextUtils.isEmpty(charSequence)) {
          if (TextUtils.isEmpty(this.m))
            setHint(charSequence); 
          this.a.setHint(null);
        } 
        this.n = true;
      } 
      if (this.a != null)
        g(); 
    } 
  }
  
  public void setHintTextAppearance(int paramInt) {
    this.c.c(paramInt);
    this.S = this.c.h();
    if (this.a != null) {
      a(false);
      g();
    } 
  }
  
  public void setPasswordVisibilityToggleContentDescription(int paramInt) {
    CharSequence charSequence;
    if (paramInt != 0) {
      charSequence = getResources().getText(paramInt);
    } else {
      charSequence = null;
    } 
    setPasswordVisibilityToggleContentDescription(charSequence);
  }
  
  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence) {
    this.I = paramCharSequence;
    CheckableImageButton checkableImageButton = this.J;
    if (checkableImageButton != null)
      checkableImageButton.setContentDescription(paramCharSequence); 
  }
  
  public void setPasswordVisibilityToggleDrawable(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = a.b(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setPasswordVisibilityToggleDrawable(drawable);
  }
  
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable) {
    this.H = paramDrawable;
    CheckableImageButton checkableImageButton = this.J;
    if (checkableImageButton != null)
      checkableImageButton.setImageDrawable(paramDrawable); 
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean) {
    if (this.G != paramBoolean) {
      this.G = paramBoolean;
      if (!paramBoolean && this.K) {
        EditText editText = this.a;
        if (editText != null)
          editText.setTransformationMethod(PasswordTransformationMethod.getInstance()); 
      } 
      this.K = false;
      p();
    } 
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList) {
    this.N = paramColorStateList;
    this.O = true;
    s();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode) {
    this.P = paramMode;
    this.Q = true;
    s();
  }
  
  public void setTextInputAccessibilityDelegate(a parama) {
    EditText editText = this.a;
    if (editText != null)
      r.a(editText, parama); 
  }
  
  public void setTypeface(Typeface paramTypeface) {
    if (paramTypeface != this.F) {
      this.F = paramTypeface;
      this.c.a(paramTypeface);
      this.f.a(paramTypeface);
      TextView textView = this.i;
      if (textView != null)
        textView.setTypeface(paramTypeface); 
    } 
  }
  
  public static class a extends b {
    private final TextInputLayout a;
    
    public a(TextInputLayout param1TextInputLayout) { this.a = param1TextInputLayout; }
    
    public void a(View param1View, c param1c) {
      boolean bool;
      CharSequence charSequence1;
      super.a(param1View, param1c);
      EditText editText = this.a.getEditText();
      if (editText != null) {
        charSequence1 = editText.getText();
      } else {
        charSequence1 = null;
      } 
      CharSequence charSequence2 = this.a.getHint();
      CharSequence charSequence3 = this.a.getError();
      CharSequence charSequence4 = this.a.getCounterOverflowDescription();
      boolean bool1 = true ^ TextUtils.isEmpty(charSequence1);
      boolean bool2 = true ^ TextUtils.isEmpty(charSequence2);
      boolean bool3 = true ^ TextUtils.isEmpty(charSequence3);
      if (bool3 || !TextUtils.isEmpty(charSequence4)) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool1) {
        param1c.b(charSequence1);
      } else if (bool2) {
        param1c.b(charSequence2);
      } 
      if (bool2) {
        param1c.c(charSequence2);
        boolean bool4 = false;
        if (!bool1) {
          bool4 = false;
          if (bool2)
            bool4 = true; 
        } 
        param1c.e(bool4);
      } 
      if (bool) {
        if (!bool3)
          charSequence3 = charSequence4; 
        param1c.d(charSequence3);
        param1c.d(true);
      } 
    }
    
    public void b(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      CharSequence charSequence;
      super.b(param1View, param1AccessibilityEvent);
      EditText editText = this.a.getEditText();
      if (editText != null) {
        charSequence = editText.getText();
      } else {
        charSequence = null;
      } 
      if (TextUtils.isEmpty(charSequence))
        charSequence = this.a.getHint(); 
      if (!TextUtils.isEmpty(charSequence))
        param1AccessibilityEvent.getText().add(charSequence); 
    }
  }
  
  static class b extends a {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() {
        public TextInputLayout.b a(Parcel param2Parcel) { return new TextInputLayout.b(param2Parcel, null); }
        
        public TextInputLayout.b a(Parcel param2Parcel, ClassLoader param2ClassLoader) { return new TextInputLayout.b(param2Parcel, param2ClassLoader); }
        
        public TextInputLayout.b[] a(int param2Int) { return new TextInputLayout.b[param2Int]; }
      };
    
    CharSequence a;
    
    boolean b;
    
    b(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(param1Parcel);
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != bool)
        bool = false; 
      this.b = bool;
    }
    
    b(Parcelable param1Parcelable) { super(param1Parcelable); }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("TextInputLayout.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" error=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      TextUtils.writeToParcel(this.a, param1Parcel, param1Int);
      param1Parcel.writeInt(this.b);
    }
  }
  
  static final class null extends Object implements Parcelable.ClassLoaderCreator<b> {
    public TextInputLayout.b a(Parcel param1Parcel) { return new TextInputLayout.b(param1Parcel, null); }
    
    public TextInputLayout.b a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new TextInputLayout.b(param1Parcel, param1ClassLoader); }
    
    public TextInputLayout.b[] a(int param1Int) { return new TextInputLayout.b[param1Int]; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\TextInputLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */