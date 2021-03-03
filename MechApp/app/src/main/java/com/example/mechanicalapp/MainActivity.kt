package com.example.mechanicalapp

import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mechanicalapp.ui.activity.ReleaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.AppVersionBean
import com.example.mechanicalapp.ui.data.request.ReAppVersion
import com.example.mechanicalapp.ui.fragment.home.HomeFragment
import com.example.mechanicalapp.ui.fragment.mine.MineFragment
import com.example.mechanicalapp.ui.fragment.msg.MsgFragment
import com.example.mechanicalapp.ui.fragment.store.StoreFragment
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DownLoadUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseCusActivity() ,View.OnClickListener,NetDataView<AppVersionBean>,PopUtils.onViewListener{

     private var mManager: FragmentManager? = null

     private var mHomeFragment:Fragment?=null
     private var mStoreFragment:Fragment?=null
     private var mMsgFragment:Fragment?=null
     private var mMineFragment:Fragment?=null

    private var mTextViews:MutableList<TextView> = ArrayList<TextView>()

    private var mPresenter :MecAppPresenter?=null
    private var mReAppVersion:ReAppVersion?=null

    private var mTvPopSure :TextView ?=null
    private var mTvPopCancel:TextView?=null
    private var mTvPopContext :TextView ?=null

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

         verifyStoragePermissions(this)

     }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.v("Main","=====================onNewIntent")
    }

    private fun selectText(index: Int) {
         for ((i,e) in mTextViews?.withIndex()!!) {
             mTextViews[i].isSelected =i == index
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
         mPresenter =MecAppPresenter(this)
    //     mPresenter?.getVersion()
     }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.ly_home->{
                clickTabHome();
                selectText(0);
            }
            R.id.ly_store->{
                clickTabStore();
                selectText(1);
            }
            R.id.ly_release->{
                clickTabRelease();
            }
            R.id.ly_msg->{
                clickTabMsg();
                selectText(3);
            }
            R.id.ly_mine->{
                clickTabMine();
                selectText(4);
            }
            R.id.tv_pop_sure->{
               var downLoadUtils =DownLoadUtils()
                downLoadUtils.startDownLoad(this,mReAppVersion?.downUrl)
            }
            R.id.tv_pop_cancel->{

            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.v("yz_map","$resultCode=======main==========$requestCode")
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun refreshUI(data: AppVersionBean?) {
        if (data!=null&&data.result!=null){
            mReAppVersion =data.result
            if (data.result.isUpdate=="1"){
                PopUtils.init(this,this,R.layout.pop_app_version, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    true,
                    false,this)
                PopUtils.showPopupWindow(ly_home,this,Gravity.TOP)
            }
        }

    }

    override fun loadMore(data: AppVersionBean?) {
    }

    override fun getView(view: View?) {

        mTvPopSure= view?.findViewById(R.id.tv_pop_sure)
        mTvPopCancel =view?.findViewById(R.id.tv_pop_cancel)
        mTvPopContext =view?.findViewById(R.id.tv_pop_content)

        mTvPopSure?.setOnClickListener(this)
        mTvPopCancel?.setOnClickListener(this)

    }

}