package io.github.liuwang.magicoder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import io.github.liuwang.magicoder.category.fragment.CategoryFragment;
import io.github.liuwang.magicoder.home.HomeFragment;
import io.github.liuwang.magicoder.setting.fragment.SettingFragment;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private Toolbar mToolbar;

    private PagerBottomTabLayout tabLayout;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private int lastIndex = 0;

    private String[] menuTitle;

    private List<Fragment> fragments;

    private final int INDEX_HOME = 0;
    private final int INDEX_CATEGORY = 1;
    private final int INDEX_SETTING = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (PagerBottomTabLayout) findViewById(R.id.bottom_tab);
        setSupportActionBar(mToolbar);

        fragments = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        CategoryFragment categoryFragment = new CategoryFragment();
        SettingFragment settingFragment = new SettingFragment();
        fragments.add(homeFragment);
        fragments.add(categoryFragment);
        fragments.add(settingFragment);

        menuTitle = getResources().getStringArray(R.array.menu);
        tabLayout.builder()
                .addTabItem(R.drawable.home, "home", getResources().getColor(R.color.blue_700))
                .addTabItem(R.drawable.category, "category", getResources().getColor(R.color.blue_800))
                .addTabItem(R.drawable.setting, "setting", getResources().getColor(R.color.blue_900))
                .setMode(TabLayoutMode.HIDE_TEXT | TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                .build().addTabItemClickListener(new OnTabItemSelectListener() {
            @Override
            public void onSelected(int index, Object tag) {
                mToolbar.setTitle(menuTitle[index]);
                switchFragment(fragments.get(lastIndex),fragments.get(index));
                lastIndex = index;
            }

            @Override
            public void onRepeatClick(int index, Object tag) {

            }
        });


    }

    private void switchFragment(Fragment fragment, Fragment currentFragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (currentFragment.isAdded()) {
            fragmentTransaction.show(currentFragment).hide(fragment);
        }else {
            fragmentTransaction.add(R.id.ll_contain,currentFragment);
            if (!fragment.equals(currentFragment)) {
                fragmentTransaction.hide(fragment);
            }
        }
        fragmentTransaction.commit();
    }

}
