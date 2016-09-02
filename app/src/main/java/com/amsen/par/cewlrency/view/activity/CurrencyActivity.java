package com.amsen.par.cewlrency.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.amsen.par.cewlrency.R;
import com.amsen.par.cewlrency.base.rx.subscriber.SubscriberUtils;
import com.amsen.par.cewlrency.source.CurrencySource;
import com.amsen.par.cewlrency.view.fragment.CurrencyFragment;

import javax.inject.Inject;

public class CurrencyActivity extends AppCompatActivity {
    @Inject
    CurrencySource source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialState();
    }

    private void initialState() {
        source.getCurrencies()
                .subscribe(SubscriberUtils.onNext(e -> showFragment(new CurrencyFragment())));
    }

    public void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.fragments, fragment)
                .commit();
    }
}
