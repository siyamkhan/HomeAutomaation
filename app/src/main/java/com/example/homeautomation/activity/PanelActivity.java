package com.salyantech.homecontrolpanel.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.b;
import android.support.v7.app.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.AdView;
import com.salyantech.homecontrolpanel.a.a;
import com.salyantech.homecontrolpanel.b;
import com.salyantech.homecontrolpanel.b.a;
import com.salyantech.homecontrolpanel.c;
import com.salyantech.homecontrolpanel.c.a;

public class PanelActivity extends c {
  private RecyclerView k;
  
  private a l;
  
  private MenuItem m;
  
  private MenuItem n;
  
  private MenuItem o;
  
  private TextView p;
  
  private AdView q;
  
  private AdView r;
  
  private int s = 0;
  
  private String[] t = new String[12];
  
  private boolean u = false;
  
  private final BroadcastReceiver v = new BroadcastReceiver(this) {
      public void onReceive(Context param1Context, Intent param1Intent) {
        if (param1Intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED"))
          switch (param1Intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648)) {
            default:
              return;
            case 12:
              a.a.b(this.a, (b.a()).b.e).execute(new Void[0]);
              return;
            case 10:
              c.e(param1Context);
              break;
            case 13:
              break;
          }  
      }
    };
  
  private void a(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append(" ");
    stringBuilder.append(getResources().getQuantityString(2131689472, paramInt2));
    stringBuilder.append(" ");
    stringBuilder.append(getResources().getString(2131755147));
    stringBuilder.append(", ");
    int i = paramInt1 - paramInt2;
    stringBuilder.append(i);
    stringBuilder.append(" ");
    stringBuilder.append(getResources().getQuantityString(2131689472, i));
    stringBuilder.append(" ");
    stringBuilder.append(getResources().getString(2131755148));
    c.a(this, stringBuilder.toString());
  }
  
  private void k() {
    a((Toolbar)findViewById(2131296482));
    if (g() != null) {
      g().b(true);
      g().a(true);
    } 
    this.q = (AdView)findViewById(2131296282);
    this.r = (AdView)findViewById(2131296283);
    this.k = (RecyclerView)findViewById(2131296413);
    this.p = (TextView)findViewById(2131296492);
    this.t = getResources().getStringArray(2130903040);
  }
  
  private void l() {
    c.a(this.q);
    c.a(this.r);
    c.a(this);
    if ((b.a()).b.d)
      c.e(this); 
    a.a.b(this, (b.a()).b.e).execute(new Void[0]);
    IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
    registerReceiver(this.v, intentFilter);
    if ((b.a()).b.b || (b.a()).b.a.size() == 0)
      n(); 
    p();
    o();
  }
  
  private void m() {
    int i = (b.a()).b.a.size();
    if (this.u) {
      if (i + this.s > 12) {
        a(12, i);
        return;
      } 
      if (i == 0)
        i = 1; 
      for (int j = 0; j < this.s; j++) {
        a a1 = new a();
        a1.a(0);
        String[] arrayOfString = this.t;
        int i1 = i + j;
        a1.c(arrayOfString[i1]);
        a1.b("newPin");
        a1.a(String.valueOf(i1));
        (b.a()).b.a.add(a1);
      } 
      this.u = false;
      return;
    } 
    for (byte b = 0; b < this.s; b++) {
      a a1 = new a();
      a1.a(0);
      a1.c(this.t[b]);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pin");
      stringBuilder.append(b + 2);
      a1.b(stringBuilder.toString());
      a1.a(String.valueOf(b));
      (b.a()).b.a.add(a1);
    } 
  }
  
  private void n() {
    b.a a1 = new b.a(this);
    View view = LayoutInflater.from(this).inflate(2131492912, null);
    a1.b(view);
    a1.a(false);
    a1.a(getResources().getString(2131755108));
    EditText editText = (EditText)view.findViewById(2131296334);
    a1.a(getResources().getString(17039370), new DialogInterface.OnClickListener(this, editText, a1) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (TextUtils.isEmpty(this.a.getText().toString().trim())) {
              c.a(this.c, "Please fill the field");
              return;
            } 
            PanelActivity.a(this.c, Integer.parseInt(this.a.getText().toString().trim()));
            if (PanelActivity.a(this.c) < 1 || PanelActivity.a(this.c) > 12) {
              PanelActivity.a(this.c, 0);
              PanelActivity panelActivity = this.c;
              c.a(panelActivity, panelActivity.getResources().getString(2131755124));
              return;
            } 
            PanelActivity.b(this.c);
            PanelActivity.c(this.c);
            (b.a()).b.b = false;
            this.b.b().dismiss();
          }
        });
    a1.b(getResources().getString(17039360), new DialogInterface.OnClickListener(this, a1) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) { this.a.b().dismiss(); }
        });
    a1.c();
  }
  
  private void o() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
    this.k.setLayoutManager(linearLayoutManager);
    this.l = new a(this, (b.a()).b.a, new a.b(this) {
          public void a() {
            PanelActivity.d(this.a).c();
            PanelActivity.c(this.a);
          }
        });
    this.k.setAdapter(this.l);
  }
  
  private void p() {
    if ((b.a()).b.a.size() == 0) {
      this.p.setVisibility(0);
      this.k.setVisibility(8);
      return;
    } 
    this.p.setVisibility(8);
    this.k.setVisibility(0);
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    c.a();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492895);
    k();
    l();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(2131558400, paramMenu);
    this.m = paramMenu.findItem(2131296377);
    this.n = paramMenu.findItem(2131296381);
    this.o = paramMenu.findItem(2131296380);
    this.o.setVisible(true);
    this.n.setVisible(false);
    return true;
  }
  
  public void onDestroy() {
    super.onDestroy();
    unregisterReceiver(this.v);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    int i = paramMenuItem.getItemId();
    if (i != 16908332) {
      switch (i) {
        default:
          return super.onOptionsItemSelected(paramMenuItem);
        case 2131296382:
          c.c(this);
          return true;
        case 2131296381:
          this.m.setVisible(true);
          this.n.setVisible(false);
          a.a.b(this, (b.a()).b.e).execute(new Void[0]);
          return true;
        case 2131296380:
          c.d(this);
          return true;
        case 2131296379:
          c.a(this, HelpActivity.class);
          return true;
        case 2131296378:
          c.b(this);
          return true;
        case 2131296377:
          this.m.setVisible(false);
          this.n.setVisible(true);
          c.a(getLayoutInflater().inflate(2131492911, null), this, this.l);
          return true;
        case 2131296376:
          break;
      } 
      this.u = true;
      n();
      return true;
    } 
    onBackPressed();
    return true;
  }
  
  protected void onResume() {
    super.onResume();
    this.l.c();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\activity\PanelActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */