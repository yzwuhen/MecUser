package com.example.mechanicalapp

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mechanicalapp.ui.activity.ReleaseActivity
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.fragment.home.HomeFragment
import com.example.mechanicalapp.ui.fragment.mine.MineFragment
import com.example.mechanicalapp.ui.fragment.msg.MsgFragment
import com.example.mechanicalapp.ui.fragment.store.StoreFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<NetData>() ,View.OnClickListener{

     private var mManager: FragmentManager? = null

     private var mHomeFragment:Fragment?=null
     private var mStoreFragment:Fragment?=null
     private var mMsgFragment:Fragment?=null
     private var mMineFragment:Fragment?=null

    private var mTextViews:MutableList<TextView> = ArrayList<TextView>()

     override fun getLayoutId(): Int {

         return R.layout.activity_main;
     }

     override fun initView() {
         super.initView()
         mManager = supportFragmentManager
         mTextViews = ArrayList<TextView>()

         mTextViews.add(tv_home);
         mTextViews.add(tv_store);
         mTextViews.add(tv_release);
         mTextViews.add(tv_msg);
         mTextViews.add(tv_mine);

         clickTabHome();
         selectText(0);
         ly_home?.setOnClickListener(this)
         ly_store?.setOnClickListener(this)
         ly_release?.setOnClickListener(this)
         ly_mine?.setOnClickListener(this)
         ly_msg?.setOnClickListener(this)
     }

     private fun selectText(index: Int) {
         for ((i,e) in mTextViews?.withIndex()!!) {

             mTextViews[i].isSelected =i == index
//             if (i == index) {
//                 mTextViews?.get(i)?.setSelected(true);
//             } else {
//                 mTextViews?.get(i)?.setSelected(false);
//             }
         }
     }

     private fun clickTabHome() {
        var transaction: FragmentTransaction? = mManager?.beginTransaction()

        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment();
            transaction?.add(R.id.main_frame, mHomeFragment as Fragment);
        } else {
            if (transaction != null) {
                showFragment(transaction, mHomeFragment as Fragment)
            };
        }
        if (transaction != null) {
            hideFragment(transaction, mStoreFragment,  mMsgFragment, mMineFragment)
        };
        transaction?.commitAllowingStateLoss();

    }

    private fun clickTabStore() {
        var transaction: FragmentTransaction? = mManager?.beginTransaction()

        if (mStoreFragment == null) {
            mStoreFragment = StoreFragment();
            transaction?.add(R.id.main_frame, mStoreFragment as Fragment);
        } else {
            if (transaction != null) {
                showFragment(transaction, mStoreFragment as Fragment)
            };
        }
        if (transaction != null) {
            hideFragment(transaction, mHomeFragment,  mMsgFragment, mMineFragment)
        };
        transaction?.commitAllowingStateLoss();

    }

    private fun clickTabRelease() {

        jumpActivity(null,ReleaseActivity::class.java)

//        var transaction: FragmentTransaction? = mManager?.beginTransaction()
//
//        if (mReleaseFragment == null) {
//            mReleaseFragment = ReleaseFragment();
//            transaction?.add(R.id.main_frame, mReleaseFragment as Fragment);
//        } else {
//            if (transaction != null) {
//                showFragment(transaction, mReleaseFragment as Fragment)
//            };
//        }
//        if (transaction != null) {
//            hideFragment(transaction, mStoreFragment, mHomeFragment, mMsgFragment, mMineFragment)
//        };
//        transaction?.commitAllowingStateLoss();

    }

    private fun clickTabMsg() {
        var transaction: FragmentTransaction? = mManager?.beginTransaction()

        if (mMsgFragment == null) {
            mMsgFragment = MsgFragment();
            transaction?.add(R.id.main_frame, mMsgFragment as Fragment);
        } else {
            if (transaction != null) {
                showFragment(transaction, mMsgFragment as Fragment)
            };
        }
        if (transaction != null) {
            hideFragment(transaction, mStoreFragment,  mHomeFragment, mMineFragment)
        };
        transaction?.commitAllowingStateLoss();

    }

    private fun clickTabMine() {
        var transaction: FragmentTransaction? = mManager?.beginTransaction()

        if (mMineFragment == null) {
            mMineFragment = MineFragment();
            transaction?.add(R.id.main_frame, mMineFragment as Fragment);
        } else {
            if (transaction != null) {
                showFragment(transaction, mMineFragment as Fragment)
            };
        }
        if (transaction != null) {
            hideFragment(transaction, mStoreFragment, mMsgFragment, mHomeFragment)
        };
        transaction?.commitAllowingStateLoss();

    }


    private fun hideFragment(
        transaction: FragmentTransaction,
        fragment1: Fragment?,
        fragment2: Fragment?,
        fragment3: Fragment?
    ) {

        if (fragment1 != null) {
            hideFragment(transaction, fragment1)
        };
        if (fragment2 != null) {
            hideFragment(transaction, fragment2)
        };
        if (fragment3 != null) {
            hideFragment(transaction, fragment3)
        };

    }
     /*
      * 隐藏一个Fragment
      */
     private fun hideFragment(transaction:FragmentTransaction, fragment:Fragment ) {
         if (fragment != null && fragment.isAdded) {
             transaction.hide(fragment)
         }
     }

     private fun showFragment(transaction: FragmentTransaction, fragment: Fragment) {
         if (fragment == null) return;
         if (fragment.isAdded) {
             transaction.show(fragment);
         } else {
             transaction.add(R.id.main_frame, fragment);
         }
     }

     override fun initPresenter() {

     }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.ly_home){
            clickTabHome();
            selectText(0);
        }
        if (p0?.id == R.id.ly_store){
            clickTabStore();
            selectText(1);
        }
        if (p0?.id == R.id.ly_release){
            clickTabRelease();
          //  selectText(2);
        }
        if (p0?.id == R.id.ly_msg){
            clickTabMsg();
            selectText(3);
        }
        if (p0?.id == R.id.ly_mine){
            clickTabMine();
            selectText(4);
        }
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hiedLoading() {
        TODO("Not yet implemented")
    }

    override fun showData(t: NetData) {
        TODO("Not yet implemented")
    }

}