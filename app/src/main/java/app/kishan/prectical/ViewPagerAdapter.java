package app.kishan.prectical;

/**
 * Created by Administrator on 7/3/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.kishan.prectical.Fragments.ContactsFragemt;
import app.kishan.prectical.Fragments.DialPadFragment;
import app.kishan.prectical.Fragments.MessageFragement;
import app.kishan.prectical.Fragments.RecentFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ContactsFragemt tab1 = new ContactsFragemt();
                return tab1;
            case 1:
                DialPadFragment tab2 = new DialPadFragment();
                return tab2;
            case 2:
                RecentFragment tab3 = new RecentFragment();
                return tab3;
            case 3:
                MessageFragement tab4 = new MessageFragement();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
