package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.h.r;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a;
import android.support.v7.widget.as;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AlertController {
  private int A;
  
  private boolean B = false;
  
  private CharSequence C;
  
  private Drawable D;
  
  private CharSequence E;
  
  private Drawable F;
  
  private CharSequence G;
  
  private Drawable H;
  
  private int I = 0;
  
  private Drawable J;
  
  private ImageView K;
  
  private TextView L;
  
  private TextView M;
  
  private View N;
  
  private int O;
  
  private int P;
  
  private boolean Q;
  
  private int R = 0;
  
  private final View.OnClickListener S = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        Message message2;
        if (param1View == this.a.c && this.a.d != null) {
          message2 = this.a.d;
        } else if (param1View == this.a.e && this.a.f != null) {
          message2 = this.a.f;
        } else if (param1View == this.a.g && this.a.h != null) {
          message2 = this.a.h;
        } else {
          Object object = null;
          if (object != null)
            object.sendToTarget(); 
        } 
        Message message1 = Message.obtain(message2);
        if (message1 != null)
          message1.sendToTarget(); 
      }
    };
  
  final g a;
  
  ListView b;
  
  Button c;
  
  Message d;
  
  Button e;
  
  Message f;
  
  Button g;
  
  Message h;
  
  NestedScrollView i;
  
  ListAdapter j;
  
  int k = -1;
  
  int l;
  
  int m;
  
  int n;
  
  int o;
  
  Handler p;
  
  private final Context q;
  
  private final Window r;
  
  private final int s;
  
  private CharSequence t;
  
  private CharSequence u;
  
  private View v;
  
  private int w;
  
  private int x;
  
  private int y;
  
  private int z;
  
  public AlertController(Context paramContext, g paramg, Window paramWindow) {
    this.q = paramContext;
    this.a = paramg;
    this.r = paramWindow;
    this.p = new b(paramg);
    TypedArray typedArray = paramContext.obtainStyledAttributes(null, a.j.AlertDialog, a.a.alertDialogStyle, 0);
    this.O = typedArray.getResourceId(a.j.AlertDialog_android_layout, 0);
    this.P = typedArray.getResourceId(a.j.AlertDialog_buttonPanelSideLayout, 0);
    this.l = typedArray.getResourceId(a.j.AlertDialog_listLayout, 0);
    this.m = typedArray.getResourceId(a.j.AlertDialog_multiChoiceItemLayout, 0);
    this.n = typedArray.getResourceId(a.j.AlertDialog_singleChoiceItemLayout, 0);
    this.o = typedArray.getResourceId(a.j.AlertDialog_listItemLayout, 0);
    this.Q = typedArray.getBoolean(a.j.AlertDialog_showTitle, true);
    this.s = typedArray.getDimensionPixelSize(a.j.AlertDialog_buttonIconDimen, 0);
    typedArray.recycle();
    paramg.a(1);
  }
  
  private ViewGroup a(View paramView1, View paramView2) {
    if (paramView1 == null) {
      if (paramView2 instanceof ViewStub)
        paramView2 = ((ViewStub)paramView2).inflate(); 
      return (ViewGroup)paramView2;
    } 
    if (paramView2 != null) {
      ViewParent viewParent = paramView2.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView(paramView2); 
    } 
    if (paramView1 instanceof ViewStub)
      paramView1 = ((ViewStub)paramView1).inflate(); 
    return (ViewGroup)paramView1;
  }
  
  static void a(View paramView1, View paramView2, View paramView3) {
    if (paramView2 != null) {
      byte b1;
      if (paramView1.canScrollVertically(-1)) {
        b1 = 0;
      } else {
        b1 = 4;
      } 
      paramView2.setVisibility(b1);
    } 
    if (paramView3 != null) {
      byte b1;
      if (paramView1.canScrollVertically(1)) {
        b1 = 0;
      } else {
        b1 = 4;
      } 
      paramView3.setVisibility(b1);
    } 
  }
  
  private void a(ViewGroup paramViewGroup) {
    View view = this.v;
    if (view == null)
      if (this.w != 0) {
        view = LayoutInflater.from(this.q).inflate(this.w, paramViewGroup, false);
      } else {
        view = null;
      }  
    boolean bool = false;
    if (view != null)
      bool = true; 
    if (!bool || !a(view))
      this.r.setFlags(131072, 131072); 
    if (bool) {
      FrameLayout frameLayout = (FrameLayout)this.r.findViewById(a.f.custom);
      frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
      if (this.B)
        frameLayout.setPadding(this.x, this.y, this.z, this.A); 
      if (this.b != null) {
        ((as.a)paramViewGroup.getLayoutParams()).g = 0.0F;
        return;
      } 
    } else {
      paramViewGroup.setVisibility(8);
    } 
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2) {
    View view1 = this.r.findViewById(a.f.scrollIndicatorUp);
    View view2 = this.r.findViewById(a.f.scrollIndicatorDown);
    if (Build.VERSION.SDK_INT >= 23) {
      r.a(paramView, paramInt1, paramInt2);
      if (view1 != null)
        paramViewGroup.removeView(view1); 
      if (view2 != null) {
        paramViewGroup.removeView(view2);
        return;
      } 
    } else {
      View view;
      if (view1 != null && (paramInt1 & true) == 0) {
        paramViewGroup.removeView(view1);
        view1 = null;
      } 
      if (view2 != null && (paramInt1 & 0x2) == 0) {
        paramViewGroup.removeView(view2);
        view = null;
      } else {
        view = view2;
      } 
      if (view1 != null || view != null) {
        if (this.u != null) {
          this.i.setOnScrollChangeListener(new NestedScrollView.b(this, view1, view) {
                public void a(NestedScrollView param1NestedScrollView, int param1Int1, int param1Int2, int param1Int3, int param1Int4) { AlertController.a(param1NestedScrollView, this.a, this.b); }
              });
          this.i.post(new Runnable(this, view1, view) {
                public void run() { AlertController.a(this.c.i, this.a, this.b); }
              });
          return;
        } 
        ListView listView = this.b;
        if (listView != null) {
          listView.setOnScrollListener(new AbsListView.OnScrollListener(this, view1, view) {
                public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) { AlertController.a(param1AbsListView, this.a, this.b); }
                
                public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {}
              });
          this.b.post(new Runnable(this, view1, view) {
                public void run() { AlertController.a(this.c.b, this.a, this.b); }
              });
          return;
        } 
        if (view1 != null)
          paramViewGroup.removeView(view1); 
        if (view != null)
          paramViewGroup.removeView(view); 
      } 
    } 
  }
  
  private void a(Button paramButton) {
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    layoutParams.gravity = 1;
    layoutParams.weight = 0.5F;
    paramButton.setLayoutParams(layoutParams);
  }
  
  private static boolean a(Context paramContext) {
    TypedValue typedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(a.a.alertDialogCenterButtons, typedValue, true);
    return (typedValue.data != 0);
  }
  
  static boolean a(View paramView) {
    if (paramView.onCheckIsTextEditor())
      return true; 
    if (!(paramView instanceof ViewGroup))
      return false; 
    ViewGroup viewGroup = (ViewGroup)paramView;
    int i1 = viewGroup.getChildCount();
    while (i1 > 0) {
      if (a(viewGroup.getChildAt(--i1)))
        return true; 
    } 
    return false;
  }
  
  private int b() {
    int i1 = this.P;
    return (i1 == 0) ? this.O : ((this.R == 1) ? i1 : this.O);
  }
  
  private void b(ViewGroup paramViewGroup) {
    if (this.N != null) {
      ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
      paramViewGroup.addView(this.N, 0, layoutParams);
      this.r.findViewById(a.f.title_template).setVisibility(8);
      return;
    } 
    this.K = (ImageView)this.r.findViewById(16908294);
    if (true ^ TextUtils.isEmpty(this.t) && this.Q) {
      this.L = (TextView)this.r.findViewById(a.f.alertTitle);
      this.L.setText(this.t);
      int i1 = this.I;
      if (i1 != 0) {
        this.K.setImageResource(i1);
        return;
      } 
      Drawable drawable = this.J;
      if (drawable != null) {
        this.K.setImageDrawable(drawable);
        return;
      } 
      this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
      this.K.setVisibility(8);
      return;
    } 
    this.r.findViewById(a.f.title_template).setVisibility(8);
    this.K.setVisibility(8);
    paramViewGroup.setVisibility(8);
  }
  
  private void c() { // Byte code:
    //   0: aload_0
    //   1: getfield r : Landroid/view/Window;
    //   4: getstatic android/support/v7/a/a$f.parentPanel : I
    //   7: invokevirtual findViewById : (I)Landroid/view/View;
    //   10: astore_1
    //   11: aload_1
    //   12: getstatic android/support/v7/a/a$f.topPanel : I
    //   15: invokevirtual findViewById : (I)Landroid/view/View;
    //   18: astore_2
    //   19: aload_1
    //   20: getstatic android/support/v7/a/a$f.contentPanel : I
    //   23: invokevirtual findViewById : (I)Landroid/view/View;
    //   26: astore_3
    //   27: aload_1
    //   28: getstatic android/support/v7/a/a$f.buttonPanel : I
    //   31: invokevirtual findViewById : (I)Landroid/view/View;
    //   34: astore #4
    //   36: aload_1
    //   37: getstatic android/support/v7/a/a$f.customPanel : I
    //   40: invokevirtual findViewById : (I)Landroid/view/View;
    //   43: checkcast android/view/ViewGroup
    //   46: astore #5
    //   48: aload_0
    //   49: aload #5
    //   51: invokespecial a : (Landroid/view/ViewGroup;)V
    //   54: aload #5
    //   56: getstatic android/support/v7/a/a$f.topPanel : I
    //   59: invokevirtual findViewById : (I)Landroid/view/View;
    //   62: astore #6
    //   64: aload #5
    //   66: getstatic android/support/v7/a/a$f.contentPanel : I
    //   69: invokevirtual findViewById : (I)Landroid/view/View;
    //   72: astore #7
    //   74: aload #5
    //   76: getstatic android/support/v7/a/a$f.buttonPanel : I
    //   79: invokevirtual findViewById : (I)Landroid/view/View;
    //   82: astore #8
    //   84: aload_0
    //   85: aload #6
    //   87: aload_2
    //   88: invokespecial a : (Landroid/view/View;Landroid/view/View;)Landroid/view/ViewGroup;
    //   91: astore #9
    //   93: aload_0
    //   94: aload #7
    //   96: aload_3
    //   97: invokespecial a : (Landroid/view/View;Landroid/view/View;)Landroid/view/ViewGroup;
    //   100: astore #10
    //   102: aload_0
    //   103: aload #8
    //   105: aload #4
    //   107: invokespecial a : (Landroid/view/View;Landroid/view/View;)Landroid/view/ViewGroup;
    //   110: astore #11
    //   112: aload_0
    //   113: aload #10
    //   115: invokespecial c : (Landroid/view/ViewGroup;)V
    //   118: aload_0
    //   119: aload #11
    //   121: invokespecial d : (Landroid/view/ViewGroup;)V
    //   124: aload_0
    //   125: aload #9
    //   127: invokespecial b : (Landroid/view/ViewGroup;)V
    //   130: aload #5
    //   132: ifnull -> 151
    //   135: aload #5
    //   137: invokevirtual getVisibility : ()I
    //   140: bipush #8
    //   142: if_icmpeq -> 151
    //   145: iconst_1
    //   146: istore #12
    //   148: goto -> 154
    //   151: iconst_0
    //   152: istore #12
    //   154: aload #9
    //   156: ifnull -> 175
    //   159: aload #9
    //   161: invokevirtual getVisibility : ()I
    //   164: bipush #8
    //   166: if_icmpeq -> 175
    //   169: iconst_1
    //   170: istore #13
    //   172: goto -> 178
    //   175: iconst_0
    //   176: istore #13
    //   178: aload #11
    //   180: ifnull -> 199
    //   183: aload #11
    //   185: invokevirtual getVisibility : ()I
    //   188: bipush #8
    //   190: if_icmpeq -> 199
    //   193: iconst_1
    //   194: istore #14
    //   196: goto -> 202
    //   199: iconst_0
    //   200: istore #14
    //   202: iload #14
    //   204: ifne -> 233
    //   207: aload #10
    //   209: ifnull -> 233
    //   212: aload #10
    //   214: getstatic android/support/v7/a/a$f.textSpacerNoButtons : I
    //   217: invokevirtual findViewById : (I)Landroid/view/View;
    //   220: astore #25
    //   222: aload #25
    //   224: ifnull -> 233
    //   227: aload #25
    //   229: iconst_0
    //   230: invokevirtual setVisibility : (I)V
    //   233: iload #13
    //   235: ifeq -> 300
    //   238: aload_0
    //   239: getfield i : Landroid/support/v4/widget/NestedScrollView;
    //   242: astore #22
    //   244: aload #22
    //   246: ifnull -> 255
    //   249: aload #22
    //   251: iconst_1
    //   252: invokevirtual setClipToPadding : (Z)V
    //   255: aload_0
    //   256: getfield u : Ljava/lang/CharSequence;
    //   259: ifnonnull -> 276
    //   262: aload_0
    //   263: getfield b : Landroid/widget/ListView;
    //   266: astore #24
    //   268: aconst_null
    //   269: astore #23
    //   271: aload #24
    //   273: ifnull -> 286
    //   276: aload #9
    //   278: getstatic android/support/v7/a/a$f.titleDividerNoCustom : I
    //   281: invokevirtual findViewById : (I)Landroid/view/View;
    //   284: astore #23
    //   286: aload #23
    //   288: ifnull -> 326
    //   291: aload #23
    //   293: iconst_0
    //   294: invokevirtual setVisibility : (I)V
    //   297: goto -> 326
    //   300: aload #10
    //   302: ifnull -> 326
    //   305: aload #10
    //   307: getstatic android/support/v7/a/a$f.textSpacerNoTitle : I
    //   310: invokevirtual findViewById : (I)Landroid/view/View;
    //   313: astore #21
    //   315: aload #21
    //   317: ifnull -> 326
    //   320: aload #21
    //   322: iconst_0
    //   323: invokevirtual setVisibility : (I)V
    //   326: aload_0
    //   327: getfield b : Landroid/widget/ListView;
    //   330: astore #15
    //   332: aload #15
    //   334: instanceof android/support/v7/app/AlertController$RecycleListView
    //   337: ifeq -> 352
    //   340: aload #15
    //   342: checkcast android/support/v7/app/AlertController$RecycleListView
    //   345: iload #13
    //   347: iload #14
    //   349: invokevirtual a : (ZZ)V
    //   352: iload #12
    //   354: ifne -> 407
    //   357: aload_0
    //   358: getfield b : Landroid/widget/ListView;
    //   361: astore #19
    //   363: aload #19
    //   365: ifnull -> 371
    //   368: goto -> 377
    //   371: aload_0
    //   372: getfield i : Landroid/support/v4/widget/NestedScrollView;
    //   375: astore #19
    //   377: aload #19
    //   379: ifnull -> 407
    //   382: iconst_0
    //   383: istore #20
    //   385: iload #14
    //   387: ifeq -> 393
    //   390: iconst_2
    //   391: istore #20
    //   393: aload_0
    //   394: aload #10
    //   396: aload #19
    //   398: iload #13
    //   400: iload #20
    //   402: ior
    //   403: iconst_3
    //   404: invokespecial a : (Landroid/view/ViewGroup;Landroid/view/View;II)V
    //   407: aload_0
    //   408: getfield b : Landroid/widget/ListView;
    //   411: astore #16
    //   413: aload #16
    //   415: ifnull -> 463
    //   418: aload_0
    //   419: getfield j : Landroid/widget/ListAdapter;
    //   422: astore #17
    //   424: aload #17
    //   426: ifnull -> 463
    //   429: aload #16
    //   431: aload #17
    //   433: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   436: aload_0
    //   437: getfield k : I
    //   440: istore #18
    //   442: iload #18
    //   444: iconst_m1
    //   445: if_icmple -> 463
    //   448: aload #16
    //   450: iload #18
    //   452: iconst_1
    //   453: invokevirtual setItemChecked : (IZ)V
    //   456: aload #16
    //   458: iload #18
    //   460: invokevirtual setSelection : (I)V
    //   463: return }
  
  private void c(ViewGroup paramViewGroup) {
    this.i = (NestedScrollView)this.r.findViewById(a.f.scrollView);
    this.i.setFocusable(false);
    this.i.setNestedScrollingEnabled(false);
    this.M = (TextView)paramViewGroup.findViewById(16908299);
    TextView textView = this.M;
    if (textView == null)
      return; 
    CharSequence charSequence = this.u;
    if (charSequence != null) {
      textView.setText(charSequence);
      return;
    } 
    textView.setVisibility(8);
    this.i.removeView(this.M);
    if (this.b != null) {
      ViewGroup viewGroup = (ViewGroup)this.i.getParent();
      int i1 = viewGroup.indexOfChild(this.i);
      viewGroup.removeViewAt(i1);
      viewGroup.addView(this.b, i1, new ViewGroup.LayoutParams(-1, -1));
      return;
    } 
    paramViewGroup.setVisibility(8);
  }
  
  private void d(ViewGroup paramViewGroup) { // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc_w 16908313
    //   5: invokevirtual findViewById : (I)Landroid/view/View;
    //   8: checkcast android/widget/Button
    //   11: putfield c : Landroid/widget/Button;
    //   14: aload_0
    //   15: getfield c : Landroid/widget/Button;
    //   18: aload_0
    //   19: getfield S : Landroid/view/View$OnClickListener;
    //   22: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   25: aload_0
    //   26: getfield C : Ljava/lang/CharSequence;
    //   29: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   32: istore_2
    //   33: iconst_1
    //   34: istore_3
    //   35: iload_2
    //   36: ifeq -> 61
    //   39: aload_0
    //   40: getfield D : Landroid/graphics/drawable/Drawable;
    //   43: ifnonnull -> 61
    //   46: aload_0
    //   47: getfield c : Landroid/widget/Button;
    //   50: bipush #8
    //   52: invokevirtual setVisibility : (I)V
    //   55: iconst_0
    //   56: istore #5
    //   58: goto -> 125
    //   61: aload_0
    //   62: getfield c : Landroid/widget/Button;
    //   65: aload_0
    //   66: getfield C : Ljava/lang/CharSequence;
    //   69: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   72: aload_0
    //   73: getfield D : Landroid/graphics/drawable/Drawable;
    //   76: astore #4
    //   78: aload #4
    //   80: ifnull -> 114
    //   83: aload_0
    //   84: getfield s : I
    //   87: istore #11
    //   89: aload #4
    //   91: iconst_0
    //   92: iconst_0
    //   93: iload #11
    //   95: iload #11
    //   97: invokevirtual setBounds : (IIII)V
    //   100: aload_0
    //   101: getfield c : Landroid/widget/Button;
    //   104: aload_0
    //   105: getfield D : Landroid/graphics/drawable/Drawable;
    //   108: aconst_null
    //   109: aconst_null
    //   110: aconst_null
    //   111: invokevirtual setCompoundDrawables : (Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   114: aload_0
    //   115: getfield c : Landroid/widget/Button;
    //   118: iconst_0
    //   119: invokevirtual setVisibility : (I)V
    //   122: iconst_1
    //   123: istore #5
    //   125: aload_0
    //   126: aload_1
    //   127: ldc_w 16908314
    //   130: invokevirtual findViewById : (I)Landroid/view/View;
    //   133: checkcast android/widget/Button
    //   136: putfield e : Landroid/widget/Button;
    //   139: aload_0
    //   140: getfield e : Landroid/widget/Button;
    //   143: aload_0
    //   144: getfield S : Landroid/view/View$OnClickListener;
    //   147: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   150: aload_0
    //   151: getfield E : Ljava/lang/CharSequence;
    //   154: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   157: ifeq -> 179
    //   160: aload_0
    //   161: getfield F : Landroid/graphics/drawable/Drawable;
    //   164: ifnonnull -> 179
    //   167: aload_0
    //   168: getfield e : Landroid/widget/Button;
    //   171: bipush #8
    //   173: invokevirtual setVisibility : (I)V
    //   176: goto -> 246
    //   179: aload_0
    //   180: getfield e : Landroid/widget/Button;
    //   183: aload_0
    //   184: getfield E : Ljava/lang/CharSequence;
    //   187: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   190: aload_0
    //   191: getfield F : Landroid/graphics/drawable/Drawable;
    //   194: astore #6
    //   196: aload #6
    //   198: ifnull -> 232
    //   201: aload_0
    //   202: getfield s : I
    //   205: istore #10
    //   207: aload #6
    //   209: iconst_0
    //   210: iconst_0
    //   211: iload #10
    //   213: iload #10
    //   215: invokevirtual setBounds : (IIII)V
    //   218: aload_0
    //   219: getfield e : Landroid/widget/Button;
    //   222: aload_0
    //   223: getfield F : Landroid/graphics/drawable/Drawable;
    //   226: aconst_null
    //   227: aconst_null
    //   228: aconst_null
    //   229: invokevirtual setCompoundDrawables : (Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   232: aload_0
    //   233: getfield e : Landroid/widget/Button;
    //   236: iconst_0
    //   237: invokevirtual setVisibility : (I)V
    //   240: iload #5
    //   242: iconst_2
    //   243: ior
    //   244: istore #5
    //   246: aload_0
    //   247: aload_1
    //   248: ldc_w 16908315
    //   251: invokevirtual findViewById : (I)Landroid/view/View;
    //   254: checkcast android/widget/Button
    //   257: putfield g : Landroid/widget/Button;
    //   260: aload_0
    //   261: getfield g : Landroid/widget/Button;
    //   264: aload_0
    //   265: getfield S : Landroid/view/View$OnClickListener;
    //   268: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   271: aload_0
    //   272: getfield G : Ljava/lang/CharSequence;
    //   275: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   278: ifeq -> 300
    //   281: aload_0
    //   282: getfield H : Landroid/graphics/drawable/Drawable;
    //   285: ifnonnull -> 300
    //   288: aload_0
    //   289: getfield g : Landroid/widget/Button;
    //   292: bipush #8
    //   294: invokevirtual setVisibility : (I)V
    //   297: goto -> 367
    //   300: aload_0
    //   301: getfield g : Landroid/widget/Button;
    //   304: aload_0
    //   305: getfield G : Ljava/lang/CharSequence;
    //   308: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   311: aload_0
    //   312: getfield D : Landroid/graphics/drawable/Drawable;
    //   315: astore #7
    //   317: aload #7
    //   319: ifnull -> 353
    //   322: aload_0
    //   323: getfield s : I
    //   326: istore #9
    //   328: aload #7
    //   330: iconst_0
    //   331: iconst_0
    //   332: iload #9
    //   334: iload #9
    //   336: invokevirtual setBounds : (IIII)V
    //   339: aload_0
    //   340: getfield c : Landroid/widget/Button;
    //   343: aload_0
    //   344: getfield D : Landroid/graphics/drawable/Drawable;
    //   347: aconst_null
    //   348: aconst_null
    //   349: aconst_null
    //   350: invokevirtual setCompoundDrawables : (Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   353: aload_0
    //   354: getfield g : Landroid/widget/Button;
    //   357: iconst_0
    //   358: invokevirtual setVisibility : (I)V
    //   361: iload #5
    //   363: iconst_4
    //   364: ior
    //   365: istore #5
    //   367: aload_0
    //   368: getfield q : Landroid/content/Context;
    //   371: invokestatic a : (Landroid/content/Context;)Z
    //   374: ifeq -> 428
    //   377: iload #5
    //   379: iload_3
    //   380: if_icmpne -> 398
    //   383: aload_0
    //   384: getfield c : Landroid/widget/Button;
    //   387: astore #8
    //   389: aload_0
    //   390: aload #8
    //   392: invokespecial a : (Landroid/widget/Button;)V
    //   395: goto -> 428
    //   398: iload #5
    //   400: iconst_2
    //   401: if_icmpne -> 413
    //   404: aload_0
    //   405: getfield e : Landroid/widget/Button;
    //   408: astore #8
    //   410: goto -> 389
    //   413: iload #5
    //   415: iconst_4
    //   416: if_icmpne -> 428
    //   419: aload_0
    //   420: getfield g : Landroid/widget/Button;
    //   423: astore #8
    //   425: goto -> 389
    //   428: iload #5
    //   430: ifeq -> 436
    //   433: goto -> 438
    //   436: iconst_0
    //   437: istore_3
    //   438: iload_3
    //   439: ifne -> 448
    //   442: aload_1
    //   443: bipush #8
    //   445: invokevirtual setVisibility : (I)V
    //   448: return }
  
  public void a() {
    int i1 = b();
    this.a.setContentView(i1);
    c();
  }
  
  public void a(int paramInt) {
    this.v = null;
    this.w = paramInt;
    this.B = false;
  }
  
  public void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable) {
    if (paramMessage == null && paramOnClickListener != null)
      paramMessage = this.p.obtainMessage(paramInt, paramOnClickListener); 
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("Button does not exist");
      case -1:
        this.C = paramCharSequence;
        this.d = paramMessage;
        this.D = paramDrawable;
        return;
      case -2:
        this.E = paramCharSequence;
        this.f = paramMessage;
        this.F = paramDrawable;
        return;
      case -3:
        break;
    } 
    this.G = paramCharSequence;
    this.h = paramMessage;
    this.H = paramDrawable;
  }
  
  public void a(Drawable paramDrawable) {
    this.J = paramDrawable;
    this.I = 0;
    ImageView imageView = this.K;
    if (imageView != null) {
      if (paramDrawable != null) {
        imageView.setVisibility(0);
        this.K.setImageDrawable(paramDrawable);
        return;
      } 
      imageView.setVisibility(8);
    } 
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.v = paramView;
    this.w = 0;
    this.B = true;
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
    this.A = paramInt4;
  }
  
  public void a(CharSequence paramCharSequence) {
    this.t = paramCharSequence;
    TextView textView = this.L;
    if (textView != null)
      textView.setText(paramCharSequence); 
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    NestedScrollView nestedScrollView = this.i;
    return (nestedScrollView != null && nestedScrollView.a(paramKeyEvent));
  }
  
  public void b(int paramInt) {
    this.J = null;
    this.I = paramInt;
    ImageView imageView = this.K;
    if (imageView != null) {
      if (paramInt != 0) {
        imageView.setVisibility(0);
        this.K.setImageResource(this.I);
        return;
      } 
      imageView.setVisibility(8);
    } 
  }
  
  public void b(View paramView) { this.N = paramView; }
  
  public void b(CharSequence paramCharSequence) {
    this.u = paramCharSequence;
    TextView textView = this.M;
    if (textView != null)
      textView.setText(paramCharSequence); 
  }
  
  public boolean b(int paramInt, KeyEvent paramKeyEvent) {
    NestedScrollView nestedScrollView = this.i;
    return (nestedScrollView != null && nestedScrollView.a(paramKeyEvent));
  }
  
  public int c(int paramInt) {
    TypedValue typedValue = new TypedValue();
    this.q.getTheme().resolveAttribute(paramInt, typedValue, true);
    return typedValue.resourceId;
  }
  
  public void c(View paramView) {
    this.v = paramView;
    this.w = 0;
    this.B = false;
  }
  
  public static class RecycleListView extends ListView {
    private final int a;
    
    private final int b;
    
    public RecycleListView(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, a.j.RecycleListView);
      this.b = typedArray.getDimensionPixelOffset(a.j.RecycleListView_paddingBottomNoButtons, -1);
      this.a = typedArray.getDimensionPixelOffset(a.j.RecycleListView_paddingTopNoTitle, -1);
    }
    
    public void a(boolean param1Boolean1, boolean param1Boolean2) {
      if (!param1Boolean2 || !param1Boolean1) {
        int m;
        int j;
        int i = getPaddingLeft();
        if (param1Boolean1) {
          j = getPaddingTop();
        } else {
          j = this.a;
        } 
        int k = getPaddingRight();
        if (param1Boolean2) {
          m = getPaddingBottom();
        } else {
          m = this.b;
        } 
        setPadding(i, j, k, m);
      } 
    }
  }
  
  public static class a {
    public int A;
    
    public int B;
    
    public int C;
    
    public int D;
    
    public boolean E = false;
    
    public boolean[] F;
    
    public boolean G;
    
    public boolean H;
    
    public int I = -1;
    
    public DialogInterface.OnMultiChoiceClickListener J;
    
    public Cursor K;
    
    public String L;
    
    public String M;
    
    public AdapterView.OnItemSelectedListener N;
    
    public a O;
    
    public boolean P = true;
    
    public final Context a;
    
    public final LayoutInflater b;
    
    public int c = 0;
    
    public Drawable d;
    
    public int e = 0;
    
    public CharSequence f;
    
    public View g;
    
    public CharSequence h;
    
    public CharSequence i;
    
    public Drawable j;
    
    public DialogInterface.OnClickListener k;
    
    public CharSequence l;
    
    public Drawable m;
    
    public DialogInterface.OnClickListener n;
    
    public CharSequence o;
    
    public Drawable p;
    
    public DialogInterface.OnClickListener q;
    
    public boolean r;
    
    public DialogInterface.OnCancelListener s;
    
    public DialogInterface.OnDismissListener t;
    
    public DialogInterface.OnKeyListener u;
    
    public CharSequence[] v;
    
    public ListAdapter w;
    
    public DialogInterface.OnClickListener x;
    
    public int y;
    
    public View z;
    
    public a(Context param1Context) {
      this.a = param1Context;
      this.r = true;
      this.b = (LayoutInflater)param1Context.getSystemService("layout_inflater");
    }
    
    private void b(AlertController param1AlertController) { // Byte code:
      //   0: aload_0
      //   1: getfield b : Landroid/view/LayoutInflater;
      //   4: aload_1
      //   5: getfield l : I
      //   8: aconst_null
      //   9: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
      //   12: checkcast android/support/v7/app/AlertController$RecycleListView
      //   15: astore_2
      //   16: aload_0
      //   17: getfield G : Z
      //   20: ifeq -> 100
      //   23: aload_0
      //   24: getfield K : Landroid/database/Cursor;
      //   27: astore #13
      //   29: aload #13
      //   31: ifnonnull -> 74
      //   34: aload_0
      //   35: getfield a : Landroid/content/Context;
      //   38: astore #15
      //   40: aload_1
      //   41: getfield m : I
      //   44: istore #16
      //   46: aload_0
      //   47: getfield v : [Ljava/lang/CharSequence;
      //   50: astore #17
      //   52: new android/support/v7/app/AlertController$a$1
      //   55: dup
      //   56: aload_0
      //   57: aload #15
      //   59: iload #16
      //   61: ldc 16908308
      //   63: aload #17
      //   65: aload_2
      //   66: invokespecial <init> : (Landroid/support/v7/app/AlertController$a;Landroid/content/Context;II[Ljava/lang/CharSequence;Landroid/support/v7/app/AlertController$RecycleListView;)V
      //   69: astore #6
      //   71: goto -> 221
      //   74: aload_0
      //   75: getfield a : Landroid/content/Context;
      //   78: astore #14
      //   80: new android/support/v7/app/AlertController$a$2
      //   83: dup
      //   84: aload_0
      //   85: aload #14
      //   87: aload #13
      //   89: iconst_0
      //   90: aload_2
      //   91: aload_1
      //   92: invokespecial <init> : (Landroid/support/v7/app/AlertController$a;Landroid/content/Context;Landroid/database/Cursor;ZLandroid/support/v7/app/AlertController$RecycleListView;Landroid/support/v7/app/AlertController;)V
      //   95: astore #6
      //   97: goto -> 221
      //   100: aload_0
      //   101: getfield H : Z
      //   104: ifeq -> 115
      //   107: aload_1
      //   108: getfield n : I
      //   111: istore_3
      //   112: goto -> 120
      //   115: aload_1
      //   116: getfield o : I
      //   119: istore_3
      //   120: iload_3
      //   121: istore #4
      //   123: aload_0
      //   124: getfield K : Landroid/database/Cursor;
      //   127: astore #5
      //   129: aload #5
      //   131: ifnull -> 186
      //   134: aload_0
      //   135: getfield a : Landroid/content/Context;
      //   138: astore #10
      //   140: iconst_1
      //   141: anewarray java/lang/String
      //   144: astore #11
      //   146: aload #11
      //   148: iconst_0
      //   149: aload_0
      //   150: getfield L : Ljava/lang/String;
      //   153: aastore
      //   154: iconst_1
      //   155: newarray int
      //   157: dup
      //   158: iconst_0
      //   159: ldc 16908308
      //   161: iastore
      //   162: astore #12
      //   164: new android/widget/SimpleCursorAdapter
      //   167: dup
      //   168: aload #10
      //   170: iload #4
      //   172: aload #5
      //   174: aload #11
      //   176: aload #12
      //   178: invokespecial <init> : (Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[I)V
      //   181: astore #6
      //   183: goto -> 221
      //   186: aload_0
      //   187: getfield w : Landroid/widget/ListAdapter;
      //   190: astore #6
      //   192: aload #6
      //   194: ifnull -> 200
      //   197: goto -> 221
      //   200: new android/support/v7/app/AlertController$c
      //   203: dup
      //   204: aload_0
      //   205: getfield a : Landroid/content/Context;
      //   208: iload #4
      //   210: ldc 16908308
      //   212: aload_0
      //   213: getfield v : [Ljava/lang/CharSequence;
      //   216: invokespecial <init> : (Landroid/content/Context;II[Ljava/lang/CharSequence;)V
      //   219: astore #6
      //   221: aload_0
      //   222: getfield O : Landroid/support/v7/app/AlertController$a$a;
      //   225: astore #7
      //   227: aload #7
      //   229: ifnull -> 240
      //   232: aload #7
      //   234: aload_2
      //   235: invokeinterface a : (Landroid/widget/ListView;)V
      //   240: aload_1
      //   241: aload #6
      //   243: putfield j : Landroid/widget/ListAdapter;
      //   246: aload_1
      //   247: aload_0
      //   248: getfield I : I
      //   251: putfield k : I
      //   254: aload_0
      //   255: getfield x : Landroid/content/DialogInterface$OnClickListener;
      //   258: ifnull -> 281
      //   261: new android/support/v7/app/AlertController$a$3
      //   264: dup
      //   265: aload_0
      //   266: aload_1
      //   267: invokespecial <init> : (Landroid/support/v7/app/AlertController$a;Landroid/support/v7/app/AlertController;)V
      //   270: astore #8
      //   272: aload_2
      //   273: aload #8
      //   275: invokevirtual setOnItemClickListener : (Landroid/widget/AdapterView$OnItemClickListener;)V
      //   278: goto -> 303
      //   281: aload_0
      //   282: getfield J : Landroid/content/DialogInterface$OnMultiChoiceClickListener;
      //   285: ifnull -> 303
      //   288: new android/support/v7/app/AlertController$a$4
      //   291: dup
      //   292: aload_0
      //   293: aload_2
      //   294: aload_1
      //   295: invokespecial <init> : (Landroid/support/v7/app/AlertController$a;Landroid/support/v7/app/AlertController$RecycleListView;Landroid/support/v7/app/AlertController;)V
      //   298: astore #8
      //   300: goto -> 272
      //   303: aload_0
      //   304: getfield N : Landroid/widget/AdapterView$OnItemSelectedListener;
      //   307: astore #9
      //   309: aload #9
      //   311: ifnull -> 320
      //   314: aload_2
      //   315: aload #9
      //   317: invokevirtual setOnItemSelectedListener : (Landroid/widget/AdapterView$OnItemSelectedListener;)V
      //   320: aload_0
      //   321: getfield H : Z
      //   324: ifeq -> 335
      //   327: aload_2
      //   328: iconst_1
      //   329: invokevirtual setChoiceMode : (I)V
      //   332: goto -> 347
      //   335: aload_0
      //   336: getfield G : Z
      //   339: ifeq -> 347
      //   342: aload_2
      //   343: iconst_2
      //   344: invokevirtual setChoiceMode : (I)V
      //   347: aload_1
      //   348: aload_2
      //   349: putfield b : Landroid/widget/ListView;
      //   352: return }
    
    public void a(AlertController param1AlertController) {
      View view1 = this.g;
      if (view1 != null) {
        param1AlertController.b(view1);
      } else {
        CharSequence charSequence1 = this.f;
        if (charSequence1 != null)
          param1AlertController.a(charSequence1); 
        Drawable drawable = this.d;
        if (drawable != null)
          param1AlertController.a(drawable); 
        int i2 = this.c;
        if (i2 != 0)
          param1AlertController.b(i2); 
        int i3 = this.e;
        if (i3 != 0)
          param1AlertController.b(param1AlertController.c(i3)); 
      } 
      CharSequence charSequence = this.h;
      if (charSequence != null)
        param1AlertController.b(charSequence); 
      if (this.i != null || this.j != null)
        param1AlertController.a(-1, this.i, this.k, null, this.j); 
      if (this.l != null || this.m != null)
        param1AlertController.a(-2, this.l, this.n, null, this.m); 
      if (this.o != null || this.p != null)
        param1AlertController.a(-3, this.o, this.q, null, this.p); 
      if (this.v != null || this.K != null || this.w != null)
        b(param1AlertController); 
      View view2 = this.z;
      if (view2 != null) {
        if (this.E) {
          param1AlertController.a(view2, this.A, this.B, this.C, this.D);
          return;
        } 
        param1AlertController.c(view2);
        return;
      } 
      int i1 = this.y;
      if (i1 != 0)
        param1AlertController.a(i1); 
    }
    
    public static interface a {
      void a(ListView param2ListView);
    }
  }
  
  class null extends ArrayAdapter<CharSequence> {
    null(AlertController this$0, Context param1Context, int param1Int1, int param1Int2, CharSequence[] param1ArrayOfCharSequence, AlertController.RecycleListView param1RecycleListView) { super(param1Context, param1Int1, param1Int2, param1ArrayOfCharSequence); }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      View view = super.getView(param1Int, param1View, param1ViewGroup);
      if (this.b.F != null && this.b.F[param1Int])
        this.a.setItemChecked(param1Int, true); 
      return view;
    }
  }
  
  class null extends CursorAdapter {
    private final int d;
    
    private final int e;
    
    null(AlertController this$0, Context param1Context, Cursor param1Cursor, boolean param1Boolean, AlertController.RecycleListView param1RecycleListView, AlertController param1AlertController) {
      super(param1Context, param1Cursor, param1Boolean);
      Cursor cursor = getCursor();
      this.d = cursor.getColumnIndexOrThrow(this.c.L);
      this.e = cursor.getColumnIndexOrThrow(this.c.M);
    }
    
    public void bindView(View param1View, Context param1Context, Cursor param1Cursor) {
      ((CheckedTextView)param1View.findViewById(16908308)).setText(param1Cursor.getString(this.d));
      AlertController.RecycleListView recycleListView = this.a;
      int i = param1Cursor.getPosition();
      int j = param1Cursor.getInt(this.e);
      boolean bool = true;
      if (j != bool)
        bool = false; 
      recycleListView.setItemChecked(i, bool);
    }
    
    public View newView(Context param1Context, Cursor param1Cursor, ViewGroup param1ViewGroup) { return this.c.b.inflate(this.b.m, param1ViewGroup, false); }
  }
  
  class null implements AdapterView.OnItemClickListener {
    null(AlertController this$0, AlertController param1AlertController) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      this.b.x.onClick(this.a.a, param1Int);
      if (!this.b.H)
        this.a.a.dismiss(); 
    }
  }
  
  class null implements AdapterView.OnItemClickListener {
    null(AlertController this$0, AlertController.RecycleListView param1RecycleListView, AlertController param1AlertController) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (this.c.F != null)
        this.c.F[param1Int] = this.a.isItemChecked(param1Int); 
      this.c.J.onClick(this.b.a, param1Int, this.a.isItemChecked(param1Int));
    }
  }
  
  public static interface a {
    void a(ListView param1ListView);
  }
  
  private static final class b extends Handler {
    private WeakReference<DialogInterface> a;
    
    public b(DialogInterface param1DialogInterface) { this.a = new WeakReference(param1DialogInterface); }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 1) {
        switch (i) {
          default:
            return;
          case -3:
          case -2:
          case -1:
            break;
        } 
        ((DialogInterface.OnClickListener)param1Message.obj).onClick((DialogInterface)this.a.get(), param1Message.what);
        return;
      } 
      ((DialogInterface)param1Message.obj).dismiss();
    }
  }
  
  private static class c extends ArrayAdapter<CharSequence> {
    public c(Context param1Context, int param1Int1, int param1Int2, CharSequence[] param1ArrayOfCharSequence) { super(param1Context, param1Int1, param1Int2, param1ArrayOfCharSequence); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public boolean hasStableIds() { return true; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\AlertController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */