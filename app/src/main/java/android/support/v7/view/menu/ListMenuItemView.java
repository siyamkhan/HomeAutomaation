package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.widget.bm;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements p.a, AbsListView.SelectionBoundsAdjuster {
  private j a;
  
  private ImageView b;
  
  private RadioButton c;
  
  private TextView d;
  
  private CheckBox e;
  
  private TextView f;
  
  private ImageView g;
  
  private ImageView h;
  
  private LinearLayout i;
  
  private Drawable j;
  
  private int k;
  
  private Context l;
  
  private boolean m;
  
  private Drawable n;
  
  private boolean o;
  
  private int p;
  
  private LayoutInflater q;
  
  private boolean r;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.listMenuViewStyle); }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet);
    bm bm = bm.a(getContext(), paramAttributeSet, a.j.MenuView, paramInt, 0);
    this.j = bm.a(a.j.MenuView_android_itemBackground);
    this.k = bm.g(a.j.MenuView_android_itemTextAppearance, -1);
    this.m = bm.a(a.j.MenuView_preserveIconSpacing, false);
    this.l = paramContext;
    this.n = bm.a(a.j.MenuView_subMenuArrow);
    TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, a.a.dropDownListViewStyle, 0);
    this.o = typedArray.hasValue(0);
    bm.a();
    typedArray.recycle();
  }
  
  private void a(View paramView) { a(paramView, -1); }
  
  private void a(View paramView, int paramInt) {
    LinearLayout linearLayout = this.i;
    if (linearLayout != null) {
      linearLayout.addView(paramView, paramInt);
      return;
    } 
    addView(paramView, paramInt);
  }
  
  private void b() {
    this.b = (ImageView)getInflater().inflate(a.g.abc_list_menu_item_icon, this, false);
    a(this.b, 0);
  }
  
  private void c() {
    this.c = (RadioButton)getInflater().inflate(a.g.abc_list_menu_item_radio, this, false);
    a(this.c);
  }
  
  private void d() {
    this.e = (CheckBox)getInflater().inflate(a.g.abc_list_menu_item_checkbox, this, false);
    a(this.e);
  }
  
  private LayoutInflater getInflater() {
    if (this.q == null)
      this.q = LayoutInflater.from(getContext()); 
    return this.q;
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean) {
    ImageView imageView = this.g;
    if (imageView != null) {
      byte b1;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      imageView.setVisibility(b1);
    } 
  }
  
  public void a(j paramj, int paramInt) {
    byte b1;
    this.a = paramj;
    this.p = paramInt;
    if (paramj.isVisible()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    setVisibility(b1);
    setTitle(paramj.a(this));
    setCheckable(paramj.isCheckable());
    a(paramj.f(), paramj.d());
    setIcon(paramj.getIcon());
    setEnabled(paramj.isEnabled());
    setSubMenuArrowVisible(paramj.hasSubMenu());
    setContentDescription(paramj.getContentDescription());
  }
  
  public void a(boolean paramBoolean, char paramChar) {
    byte b1;
    if (paramBoolean && this.a.f()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    if (b1 == 0)
      this.f.setText(this.a.e()); 
    if (this.f.getVisibility() != b1)
      this.f.setVisibility(b1); 
  }
  
  public boolean a() { return false; }
  
  public void adjustListItemSelectionBounds(Rect paramRect) {
    ImageView imageView = this.h;
    if (imageView != null && imageView.getVisibility() == 0) {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.h.getLayoutParams();
      paramRect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    } 
  }
  
  public j getItemData() { return this.a; }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    r.a(this, this.j);
    this.d = (TextView)findViewById(a.f.title);
    int i1 = this.k;
    if (i1 != -1)
      this.d.setTextAppearance(this.l, i1); 
    this.f = (TextView)findViewById(a.f.shortcut);
    this.g = (ImageView)findViewById(a.f.submenuarrow);
    ImageView imageView = this.g;
    if (imageView != null)
      imageView.setImageDrawable(this.n); 
    this.h = (ImageView)findViewById(a.f.group_divider);
    this.i = (LinearLayout)findViewById(a.f.content);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.b != null && this.m) {
      ViewGroup.LayoutParams layoutParams = getLayoutParams();
      LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if (layoutParams.height > 0 && layoutParams1.width <= 0)
        layoutParams1.width = layoutParams.height; 
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean) {
    RadioButton radioButton;
    CheckBox checkBox;
    if (!paramBoolean && this.c == null && this.e == null)
      return; 
    if (this.a.g()) {
      if (this.c == null)
        c(); 
      checkBox = this.c;
      radioButton = this.e;
    } else {
      if (this.e == null)
        d(); 
      checkBox = this.e;
      radioButton = this.c;
    } 
    if (paramBoolean) {
      checkBox.setChecked(this.a.isChecked());
      if (checkBox.getVisibility() != 0)
        checkBox.setVisibility(0); 
      if (radioButton != null && radioButton.getVisibility() != 8) {
        radioButton.setVisibility(8);
        return;
      } 
    } else {
      CheckBox checkBox1 = this.e;
      if (checkBox1 != null)
        checkBox1.setVisibility(8); 
      RadioButton radioButton1 = this.c;
      if (radioButton1 != null)
        radioButton1.setVisibility(8); 
    } 
  }
  
  public void setChecked(boolean paramBoolean) {
    CheckBox checkBox;
    if (this.a.g()) {
      if (this.c == null)
        c(); 
      checkBox = this.c;
    } else {
      if (this.e == null)
        d(); 
      checkBox = this.e;
    } 
    checkBox.setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.r = paramBoolean;
    this.m = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean) {
    ImageView imageView = this.h;
    if (imageView != null) {
      byte b1;
      if (!this.o && paramBoolean) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      imageView.setVisibility(b1);
    } 
  }
  
  public void setIcon(Drawable paramDrawable) {
    boolean bool;
    if (this.a.i() || this.r) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool && !this.m)
      return; 
    if (this.b == null && paramDrawable == null && !this.m)
      return; 
    if (this.b == null)
      b(); 
    if (paramDrawable != null || this.m) {
      ImageView imageView = this.b;
      if (!bool)
        paramDrawable = null; 
      imageView.setImageDrawable(paramDrawable);
      if (this.b.getVisibility() != 0)
        this.b.setVisibility(0); 
      return;
    } 
    this.b.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    TextView textView;
    byte b1;
    if (paramCharSequence != null) {
      this.d.setText(paramCharSequence);
      if (this.d.getVisibility() != 0) {
        textView = this.d;
        b1 = 0;
      } else {
        return;
      } 
    } else {
      int i1 = this.d.getVisibility();
      b1 = 8;
      if (i1 != b1) {
        textView = this.d;
      } else {
        return;
      } 
    } 
    textView.setVisibility(b1);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */